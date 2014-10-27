package minestrapteam.minestrappolation.world.gen;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRedSandstone extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x1 = x + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z1 = z + z0;
				for (int y1 = 0; y1 < 128; y1++)
				{
					if (world.getBlock(x1, y1, z1) == Blocks.sand && world.getBlockMetadata(x1, y1, z1) == 1)
					{
						int n = rand.nextInt(12);
						if (n == 0)
						{
							world.setBlock(x1, y1 - rand.nextInt(3), z1, MBlocks.redSandstone, 7, 2);
						}
						else if (n == 1)
						{
							world.setBlock(x1, y1 - rand.nextInt(3), z1, MBlocks.redSandstone, 8, 2);
						}
						else
						{
							int height = rand.nextInt(3) + 2;
							for (int i = 0; i < height; i++)
							{
								world.setBlock(x1, y1 + i, z1, MBlocks.redSandstone);
							}
						}
						
						break;
					}
				}
			}
		}
		
		return true;
	}
}
