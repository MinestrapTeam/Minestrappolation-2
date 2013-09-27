package sobiohazardous.minestrappolation.extrafoods.gen;

import java.util.Random;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * 
 * 
 * @author Crzyguitardude
 */
public class EFOreGenerator implements IWorldGenerator
{
	public static ExtraFoods BASEMOD;

	public EFOreGenerator()
	{

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			generateSurface(world, random, chunkX << 4, chunkZ << 4);
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			generateNether(world, random, chunkX << 4, chunkZ << 4);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			generateEnd(world, random, chunkX << 4, chunkZ << 4);
		}
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		
		for(int i = 0; i < 13; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(55);
			int randPosZ = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(BASEMOD.oreSalt.blockID, 6)).generate(world, random, randPosX, randPosY, randPosZ);
	
		}
		
		
		for(int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(55);
			int randPosZ = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(BASEMOD.oreAluminum.blockID, 6)).generate(world, random, randPosX, randPosY, randPosZ);
	
		}
	
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ); 
		//WorldGenGreenTree tree = new WorldGenGreenTree(false); 
		if(biome instanceof BiomeGenForest)
			
		{ 
			/*
			for(int x = 0; x < 6; x++)
			{
				int Xcoord = chunkX + random.nextInt(16); 
				int Zcoord = chunkZ + random.nextInt(16); 
				int i = world.getHeightValue(Xcoord, Zcoord); 
				tree.generate(world, random, Xcoord, i, Zcoord); 
			}
			 */
		}
	
		if(biome instanceof BiomeGenPlains)
		{
			/*
			for(int x = 0; x < 25; x++)
				{
					int randPosX = chunkX + random.nextInt(16);
					int randPosY = random.nextInt(128);
					int randPosZ = chunkZ + random.nextInt(16);
					(new WorldGenFlowers(BASEMOD.bgrass.blockID)).generate(world, random, randPosX, randPosY, randPosZ);
				}
				*/
		
			for(int x = 0; x < 9; x++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(128);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenFlowers(BASEMOD.flowerVanilla.blockID)).generate(world, random, randPosX, randPosY, randPosZ);
			}
			
		}
	
	}	

	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{

	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
