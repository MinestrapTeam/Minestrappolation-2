package minestrapteam.minestrappolation.world.gen;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenObsidianSpikes extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x1 = x + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z1 = z + z0;
				yLoop:
				for (y = 128; y >= 32; y--)
				{
					if (world.getBlock(x1, y, z1) == Blocks.obsidian && world.getBlock(x1, y + 1, z1) == Blocks.air)
					{
						world.setBlock(x1, y, z1, MBlocks.endstone, 4, 3);
						break yLoop;
					}
				}
			}
		}
		
		return true;
	}
}
