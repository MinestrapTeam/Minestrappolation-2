package com.minestrappolation.world;

import java.util.Random;

import com.minestrappolation.lib.MBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDesertQuartzSpire extends WorldGenerator
{
	// add 2 so if you want a depth or 5 you use 3
	public int	maxDepth		= 6;
	
	// how tall the tip of the spire is
	int			maxTopHeight	= 3;
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		if (world.getBlock(x, y + 1, z) == Blocks.air && world.getBlock(x, y, z) == Blocks.sand)
		{
			System.out.println("not air skipping");
			return false;
		}
		
		int depth = random.nextInt(this.maxDepth) + 2;
		for (int i = 0; i < depth; z++)
		{
			int y1 = y - depth;
			world.setBlock(x, y1, z, MBlocks.Quartzite);
			world.setBlock(x + 1, y1, z, MBlocks.Quartzite);
			world.setBlock(x - 1, y1, z, MBlocks.Quartzite);
			world.setBlock(x, y1, z + 1, MBlocks.Quartzite);
			world.setBlock(x, y1, z - 1, MBlocks.Quartzite);
		}
		
		int height = random.nextInt(this.maxTopHeight);
		for (int i = 0; i < height; i++)
		{
			world.setBlock(x, y + height, z, MBlocks.Quartzite);
		}
		
		world.setBlock(x, y, z, MBlocks.Quartzite);
		world.setBlock(x + 1, y, z, MBlocks.Quartzite);
		world.setBlock(x - 1, y, z, MBlocks.Quartzite);
		world.setBlock(x, y, z + 1, MBlocks.Quartzite);
		world.setBlock(x, y, z - 1, MBlocks.Quartzite);
		
		System.out.println("Spire at: x-" + x + ",y-" + y + ",z-" + z);
		return true;
	}
	
}
