package sobiohazardous.mods.minestrappolation.extradecor.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;

/**
 * @author Crzyguitardude
 */
public class EDOreGenerator implements IWorldGenerator
{
	public EDOreGenerator()
	{
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			this.generateSurface(world, random, chunkX << 4, chunkZ << 4);
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			this.generateNether(world, random, chunkX << 4, chunkZ << 4);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			this.generateEnd(world, random, chunkX << 4, chunkZ << 4);
		}
	}
	
	public void generateSurface(World world, Random rand, int chunkx, int chunkz)
	{
		for (int l = 0; l < 20; l++) // 5 = how much veins in a chunk (chunk =
										// 16x16x128)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(80); // layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenSandstone(EDBlocks.sandstoneBricks, 3).generate(world, rand, i1, j1, k1); // 5
																									// =
																									// how
																									// much
																									// in
																									// a
																									// vain
		}
		
		for (int l1 = 0; l1 < 20; l1++) // 5 = how much veins in a chunk (chunk
										// = 16x16x128)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(256); // layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenSandstone(EDBlocks.sandstoneBricks, 4).generate(world, rand, i1, j1, k1); // 5
																									// =
																									// how
																									// much
																									// in
																									// a
																									// vain
		}
		
		for (int l1 = 0; l1 < 20; l1++) // 5 = how much veins in a chunk (chunk
										// = 16x16x128)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(60); // layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenSandstone(EDBlocks.woodPlanksMossy, 3).generate(world, rand, i1, j1, k1); // 5
																									// =
																									// how
																									// much
																									// in
																									// a
																									// vain
		}
		
	}
	
	public void generateNether(World world, Random rand, int chunkx, int chunkz)
	{
		
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
	
}
