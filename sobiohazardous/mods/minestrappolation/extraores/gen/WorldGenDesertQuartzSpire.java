package sobiohazardous.mods.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDesertQuartzSpire extends WorldGenerator
{
	
	Random	rand			= new Random();
	// add 2 so if you want a depth or 5 you use 3
	int		maxDepth		= 6;
	
	// how tall the tip of the spire is
	int		maxTopHeight	= 3;
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		if (world.getBlock(i, j, k) != Blocks.sand && world.getBlock(i, j - 1, k) != Blocks.sand && world.getBlock(i + 1, j, k) != Blocks.sand && world.getBlock(i, j - 1, k) != Blocks.sand)
		{
			return false;
		}
		else if (world.getBlock(i, j, k) == Blocks.water || world.getBlock(i, j + 1, k) == Blocks.water || world.getBlock(i, j - 1, k) == Blocks.water || world.getBlock(i + 1, j, k) == Blocks.water || world.getBlock(i - 1, j, k) == Blocks.water)
		{
			System.out.println("water found skipping");
			return false;
		}
		else if (world.getBlock(i, j + 1, k) != Blocks.air)
		{
			System.out.println("not air skipping");
			return false;
		}
		
		int a;
		int randTopHeight;
		a = this.rand.nextInt(this.maxDepth);
		randTopHeight = this.rand.nextInt(3);
		for (int z = 0; z < a + 2; z++)
		{
			world.setBlock(i, j - z, k, EOBlocks.Quartzite);
			world.setBlock(i + 1, j - z, k, EOBlocks.Quartzite);
			world.setBlock(i - 1, j - z, k, EOBlocks.Quartzite);
			world.setBlock(i, j - z, k + 1, EOBlocks.Quartzite);
			world.setBlock(i, j - z, k - 1, EOBlocks.Quartzite);
			
		}
		
		world.setBlock(i, j, k, EOBlocks.Quartzite);
		world.setBlock(i + 1, j, k, EOBlocks.Quartzite);
		world.setBlock(i - 1, j, k, EOBlocks.Quartzite);
		world.setBlock(i, j, k + 1, EOBlocks.Quartzite);
		world.setBlock(i, j, k - 1, EOBlocks.Quartzite);
		
		for (int height = 0; height < randTopHeight; height++)
		{
			world.setBlock(i, j + randTopHeight, k, EOBlocks.Quartzite);
		}
		
		world.setBlock(i, j + 1, k, EOBlocks.Quartzite);
		
		System.out.println("Spire at: x-" + i + ",y-" + j + ",z-" + k);
		return true;
	}
	
}
