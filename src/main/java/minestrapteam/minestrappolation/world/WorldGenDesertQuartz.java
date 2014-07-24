package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDesertQuartz extends WorldGenerator
{
	/**
	 * Defines how deep the spire goes into the ground.
	 */
	public int	maxDepth		= 6;
	
	/**
	 * Defines how tall the tip of the spire is
	 */
	public int	maxTopHeight	= 3;
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		if (world.getBlock(x, y + 1, z) == Blocks.air && world.getBlock(x, y, z) == Blocks.sand)
		{
			int depth = random.nextInt(this.maxDepth) + 3;
			for (int i = 0; i < depth; i++)
			{
				int y1 = y - i;
				world.setBlock(x, y1, z, MBlocks.desertQuartz);
				world.setBlock(x + 1, y1, z, MBlocks.desertQuartz);
				world.setBlock(x - 1, y1, z, MBlocks.desertQuartz);
				world.setBlock(x, y1, z + 1, MBlocks.desertQuartz);
				world.setBlock(x, y1, z - 1, MBlocks.desertQuartz);
			}
			
			int height = random.nextInt(this.maxTopHeight) + 2;
			for (int i = 0; i < height; i++)
			{
				world.setBlock(x, y + i, z, MBlocks.desertQuartz);
			}
			
			return true;
		}
		return false;
	}
}
