package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.tileentity.TileEntityPlate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlate extends BlockContainer
{
	public BlockPlate(Material material)
	{
		super(material);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.125F, 0.9375F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		TileEntityPlate te = (TileEntityPlate) world.getTileEntity(x, y, z);
		if (stack != null)
		{
			te.setItem(stack);
			
			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}
		}
		else
		{
			te.setItem(null);
			if (!world.isRemote)
			{
				stack = te.getItem();
				player.inventory.addItemStackToInventory(stack);
			}
		}
		return true;
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
