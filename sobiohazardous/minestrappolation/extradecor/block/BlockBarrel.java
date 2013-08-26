package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockBarrel extends BlockContainer
{
	private Icon top;
	/** Do blocks fall instantly to where they stop or do they fall over time */
    public static boolean fallInstantly;
	
	public BlockBarrel(int id)
	{
		super(id, Material.wood);
	}
	
	public Icon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return top;
    	if (i == 1)//top
           
            return top;
   
    	if (i == 2) // side
           
            return blockIcon;
    	if (i == 3)//side 
           
            return blockIcon;
    	if (i == 4) //side
   
    		return blockIcon;
    	if (i == 5) //side
   
    		return blockIcon;

    	if (j ==1)
    	{
    		return blockIcon;
    	}
		return blockIcon;
    }
    
    public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Minestrappolation:block_BarrelSide");
	         this.top = iconRegister.registerIcon("Minestrappolation:block_BarrelTop");    
	}
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.openGui(ExtraDecor.instance, 1, par1World, par2, par3, par4);

            return true;
        }
    }
    
    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        TileEntityBarrel tileentitychest = new TileEntityBarrel();
        return tileentitychest;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int i, int j)
    {
    	dropItems(world, x, y, z);
    	super.breakBlock(world, x, y, z, i, j);
    }

    private void dropItems(World world, int x, int y, int z)
    {
    	Random rand = new Random();

    	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

    	if(!(tile_entity instanceof IInventory))
    	{
    		return;
    	}

    	IInventory inventory = (IInventory) tile_entity;

    	for(int i = 0; i < inventory.getSizeInventory(); i++)
    	{
    		ItemStack item = inventory.getStackInSlot(i);

    		if(item != null && item.stackSize > 0){
    			float rx = rand.nextFloat() * 0.6F + 0.1F;
    			float ry = rand.nextFloat() * 0.6F + 0.1F;
    			float rz = rand.nextFloat() * 0.6F + 0.1F;

    			EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

    			if(item.hasTagCompound())
    			{
    				entity_item.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
    			}

    			float factor = 0.5F;

    			entity_item.motionX = rand.nextGaussian() * factor;
    			entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
    			entity_item.motionZ = rand.nextGaussian() * factor;
    			world.spawnEntityInWorld(entity_item);
    			item.stackSize = 0;
    		}
    	}
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }

    /**
     * If there is space to fall below will start this block falling
     */
    private void tryToFall(World par1World, int par2, int par3, int par4)
    {
        if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0)
        {
            byte b0 = 32;

            if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
            {
                if (!par1World.isRemote)
                {
                    EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(entityfallingsand);
                    par1World.spawnEntityInWorld(entityfallingsand);
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);

                while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
                {
                    --par3;
                }

                if (par3 > 0)
                {
                    par1World.setBlock(par2, par3, par4, this.blockID);
                }
            }
        }
    }

    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(EntityFallingSand entityfallingsand) {}

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return 2;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int l = par0World.getBlockId(par1, par2, par3);

        if (par0World.isAirBlock(par1, par2, par3))
        {
            return true;
        }
        else if (l == Block.fire.blockID)
        {
            return true;
        }
        else
        {
            Material material = Block.blocksList[l].blockMaterial;
            return material == Material.water ? true : material == Material.lava;
        }
    }

    /**
     * Called when the falling block entity for this block hits the ground and turns back into a block
     */
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
}
