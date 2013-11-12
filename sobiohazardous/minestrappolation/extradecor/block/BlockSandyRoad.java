package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSandyRoad extends Block
{
	public Entity entity;
	public EntityLivingBase living;
	private Icon top;
	private Icon bottom;
	public static boolean fallInstantly = false;
    public BlockSandyRoad(int par1)
    {
        super(par1, Material.sand);
    }
    
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }
    
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
    
    protected void onStartFalling(EntityFallingSand par1EntityFallingSand) {}
    
    public int tickRate(World par1World)
    {
        return 2;
    }
    
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int l = par0World.getBlockId(par1, par2, par3);

        if (l == 0)
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
    
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
    
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if(this.blockID == EDBlockManager.sandyRoad.blockID)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadBottom");
    	}
    	else if(this.blockID == EDBlockManager.sandstoneRoad.blockID)
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_SandstoneRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_SandstoneRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_SandyRoadBottom");
    	}
    	else
    	{
    		this.blockIcon = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadSide");
    		this.top = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadTop");
    		this.bottom = par1IconRegister.registerIcon("Minestrappolation:block_GravelRoadBottom");
    	}
    }
    
    public Icon getIcon(int i, int j)
    {
    	if (i == 0)//bottom
            
            return bottom;
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
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if(this.blockID == EDBlockManager.sandyRoad.blockID || this.blockID == EDBlockManager.gravelRoad.blockID)
    	{
    		living = (EntityLivingBase)par5Entity;
    		living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 0, true));
    	}
        else
        {
        	living = (EntityLivingBase)par5Entity;
    		living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 1, true));
        }
    }
}