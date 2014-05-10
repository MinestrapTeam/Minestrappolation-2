package sobiohazardous.mods.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
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
		if (world.getBlock(x, y, z) != Blocks.sand && world.getBlock(x, y - 1, z) != Blocks.sand && world.getBlock(x + 1, y, z) != Blocks.sand && world.getBlock(x, y - 1, z) != Blocks.sand)
		{
			return false;
		}
		else if (world.getBlock(x, y, z) == Blocks.water || world.getBlock(x, y + 1, z) == Blocks.water || world.getBlock(x, y - 1, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.water)
		{
			System.out.println("water found skipping");
			return false;
		}
		else if (world.getBlock(x, y + 1, z) != Blocks.air)
		{
			System.out.println("not air skipping");
			return false;
		}
		
		int depth = random.nextInt(this.maxDepth) + 2;
		for (int i = 0; i < depth; z++)
		{
			world.setBlock(x, y - depth, z, EOBlocks.Quartzite);
			world.setBlock(x + 1, y - depth, z, EOBlocks.Quartzite);
			world.setBlock(x - 1, y - depth, z, EOBlocks.Quartzite);
			world.setBlock(x, y - depth, z + 1, EOBlocks.Quartzite);
			world.setBlock(x, y - depth, z - 1, EOBlocks.Quartzite);
		}
		
		int height = random.nextInt(this.maxTopHeight);
		for (int i = 0; i < height; i++)
		{
			world.setBlock(x, y + height, z, EOBlocks.Quartzite);
		}
		
		world.setBlock(x, y, z, EOBlocks.Quartzite);
		world.setBlock(x + 1, y, z, EOBlocks.Quartzite);
		world.setBlock(x - 1, y, z, EOBlocks.Quartzite);
		world.setBlock(x, y, z + 1, EOBlocks.Quartzite);
		world.setBlock(x, y, z - 1, EOBlocks.Quartzite);
		
		System.out.println("Spire at: x-" + x + ",y-" + y + ",z-" + z);
		return true;
	}
	
}
