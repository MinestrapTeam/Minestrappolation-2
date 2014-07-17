package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.mcore.lib.MCBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRedSandstone extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, int chunkX, int y, int chunkZ)
	{
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x2 = chunkX + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z2 = chunkZ + z0;
				for (int y2 = 0; y2 < 256; y2++)
				{
					if (world.getBlock(x2, y2, z2) == Blocks.sand && world.getBlockMetadata(x2, y2, z2) == 1)
					{
						if (rand.nextInt(1) == 0)
						{
							world.setBlock(x2, y2 - 1, z2, MCBlocks.redSandstone);
						}
					}
				}
			}
		}
		
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x2 = chunkX + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z2 = chunkZ + z0;
				for (int y2 = 0; y2 < 256; y2++)
				{
					if (world.getBlock(x2, y2, z2) == MCBlocks.redSandstone && world.getBlockMetadata(x2, y2, z2) == 0)
					{
						if (rand.nextInt(1) == 0)
						{
							for (int d = 0; d < rand.nextInt(3) + 2; d++)
							{
								world.setBlock(x2, y2 - d, z2, MCBlocks.redSandstone);
							}
						}
						if (rand.nextInt(12) == 0)
						{
							world.setBlock(x2, y2 - rand.nextInt(3), z2, MCBlocks.redSandstone, 7, 2);
						}
						if (rand.nextInt(12) == 6)
						{
							world.setBlock(x2, y2 - rand.nextInt(3), z2, MCBlocks.redSandstone, 8, 2);
						}
					}
				}
			}
		}
		
		return true;
	}
}