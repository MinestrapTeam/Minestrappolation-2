package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMossCover extends Block
{
	public BlockMossCover()
	{
		super(Material.plants);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.125F, 1F);
		this.setLightOpacity(0);
		this.setTickRandomly(true);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public int tickRate(World world)
	{
		return 40;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!this.canBlockStay(world, x, y, z))
		{
			world.func_147480_a(x, y, z, true);
			return;
		}
		
		int x1 = x + random.nextInt(3) - 1;
		int y1 = y + random.nextInt(2) - random.nextInt(2);
		int z1 = z + random.nextInt(3) - 1;
		
		if (world.isAirBlock(x1, y1, z1) && this.canBlockStay(world, x1, y1, z1))
		{
			world.setBlock(x1, y1, z1, this);
		}
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y - 1, z);
		if (block == Blocks.dirt && world.getBlockMetadata(x, y - 1, z) == 2)
		{
			return true;
		}
		if (!block.isSideSolid(world, x, y - 1, z, ForgeDirection.UP))
		{
			return false;
		}
		return world.getBlockLightValue(x, y, z) < 7;
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
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.mossLump;
	}
}
