package sobiohazardous.mods.minestrappolation.extradecor.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

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
		for (int i = 0; i < 20; i++)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(80);
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenMinable(EDBlocks.sandstoneBricks, 3, Blocks.sandstone).generate(world, rand, i1, j1, k1);
		}
		
		for (int i = 0; i < 20; i++)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(256);
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenMinable(EDBlocks.sandstoneBricks, 4, Blocks.sandstone).generate(world, rand, i1, j1, k1);
		}
		
		for (int i = 0; i < 20; i++)
		{
			int i1 = chunkx + rand.nextInt(16);
			int j1 = rand.nextInt(60);
			int k1 = chunkz + rand.nextInt(16);
			
			new WorldGenMinable(EDBlocks.woodPlanksMossy, 3, Blocks.planks).generate(world, rand, i1, j1, k1);
		}
	}
	
	public void generateNether(World world, Random rand, int chunkx, int chunkz)
	{
		
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
}
