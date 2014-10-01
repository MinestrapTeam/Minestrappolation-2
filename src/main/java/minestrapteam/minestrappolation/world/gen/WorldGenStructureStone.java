package minestrapteam.minestrappolation.world.gen;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * Class that replaces Stone variant blocks in biomes with their respective
 * Biome Stone Type variants.
 * 
 * @author Delocuro
 * @author Clashsoft
 */
public class WorldGenStructureStone extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, int chunkX, int y, int chunkZ)
	{
		Chunk chunk = world.getChunkFromBlockCoords(chunkX, chunkZ);
		WorldChunkManager chunkManager = world.getWorldChunkManager();
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x2 = chunkX + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z2 = chunkZ + z0;
				BiomeGenBase biome = chunk.getBiomeGenForWorldCoords(x0, z0, chunkManager);
				
				for (int y2 = 0; y2 < 128; y2++)
				{
					Block block = world.getBlock(x2, y2, z2);
					int blockMetadata = world.getBlockMetadata(x2, y2, z2);
					
					if (biome.temperature < 0.2F)
					{
						if (block == Blocks.cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 7, 2);
						}
						if (block == Blocks.mossy_cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 8, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 1, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 1)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 10, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 2)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 9, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 3)
						{
							world.setBlock(x2, y2, z2, MBlocks.icestone, 6, 2);
						}
					}
					else if (biome.temperature < 0.4F)
					{
						if (block == Blocks.cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 7, 2);
						}
						if (block == Blocks.mossy_cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 8, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 1, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 1)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 10, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 2)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 9, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 3)
						{
							world.setBlock(x2, y2, z2, MBlocks.coldstone, 6, 2);
						}
					}
					else if (biome.getTempCategory() == TempCategory.OCEAN)
					{
						if (block == Blocks.cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 7, 2);
						}
						if (block == Blocks.mossy_cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 8, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 1, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 1)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 10, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 2)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 9, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 3)
						{
							world.setBlock(x2, y2, z2, MBlocks.oceanstone, 6, 2);
						}
					}
					else if (biome.temperature >= 1.0F)
					{
						if (block == Blocks.cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 7, 2);
						}
						if (block == Blocks.mossy_cobblestone && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 8, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 0)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 1, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 1)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 10, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 2)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 9, 2);
						}
						if (block == Blocks.stonebrick && blockMetadata == 3)
						{
							world.setBlock(x2, y2, z2, MBlocks.redrock, 6, 2);
						}
					}
				}
			}
		}
		return true;
	}
}