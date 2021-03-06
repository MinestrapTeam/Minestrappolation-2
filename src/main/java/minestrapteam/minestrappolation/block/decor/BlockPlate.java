package minestrapteam.minestrappolation.block.decor;

import minestrapteam.minestrappolation.tileentity.TileEntityPlate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlate extends BlockContainer
{
	public BlockPlate(Material material)
	{
		super(material);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.125F, 0.9375F);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return world.isSideSolid(x, y - 1, z, ForgeDirection.UP);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		if (!this.canBlockStay(world, x, y, z))
		{
			world.func_147480_a(x, y, z, true);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return false;
		}
		
		ItemStack stack = player.inventory.getCurrentItem();
		TileEntityPlate te = (TileEntityPlate) world.getTileEntity(x, y, z);
		if (stack != null && te.getItem() == null && stack.getItem() instanceof ItemFood)
		{
			ItemStack stack1 = stack.copy();
			stack1.stackSize = 1;
			te.setItem(stack1);
			
			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}
			return true;
		}
		else
		{
			stack = te.getItem();
			if (stack != null)
			{
				te.dropItem();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityPlate)
		{
			((TileEntityPlate) te).dropItem();
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityPlate();
	}
}
