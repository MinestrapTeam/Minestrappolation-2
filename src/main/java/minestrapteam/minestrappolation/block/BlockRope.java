package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRope extends BlockRopeCoil
{
	public BlockRope()
	{
		super();
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote && !this.canPlaceBlockAt(world, x, y, z))
		{
			// EntityFallingBlock entityfallingblock = new
			// EntityFallingBlock(world, x + 0.5F, y + 0.5F, z + 0.5F, this,
			// world.getBlockMetadata(x, y, z));
			// world.spawnEntityInWorld(entityfallingblock);
			world.setBlockToAir(x, y, z);
			this.dropBlockAsItem(world, x, y, z, new ItemStack(MItems.ropeItem));
		}
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
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y + 1, z);
		return block == this || block.isSideSolid(world, x, y, z, ForgeDirection.DOWN);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.ropeItem;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return MItems.ropeItem;
	}
	
}
