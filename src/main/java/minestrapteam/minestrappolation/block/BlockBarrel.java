package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBarrel extends BlockFalling implements ITileEntityProvider
{
	protected IIcon	top;
	
	public BlockBarrel()
	{
		super(Material.wood);
	}
	
	@Override
	protected void func_149829_a(EntityFallingBlock entity)
	{
		TileEntity te = entity.worldObj.getTileEntity((int) entity.posX, (int) entity.posY, (int) entity.posZ);
		if (te != null)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			te.writeToNBT(nbt);
			entity.field_145810_d = nbt;
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.top;
		}
		return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMachineTexture("barrel_side"));
		this.top = iconRegister.registerIcon(MAssetManager.getMachineTexture("barrel_top"));
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity te = world.getTileEntity(x, y, z);

        if (te instanceof IInventory)
        {
        	IInventory inventory = (IInventory) te;
            for (int i1 = 0; i1 < inventory.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = inventory.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = world.rand.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        entityitem.motionX = world.rand.nextGaussian() * 0.05F;
                        entityitem.motionY = world.rand.nextGaussian() * 0.05F + 0.2F;
                        entityitem.motionZ = world.rand.nextGaussian() * 0.05F;

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.openGui(Minestrappolation.instance, 1, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, int x, int y, int z, int id, int data)
	{
		super.onBlockEventReceived(world, x, y, z, id, data);
		TileEntity te = world.getTileEntity(x, y, z);
		return te != null ? te.receiveClientEvent(id, data) : false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityBarrel();
	}
}
