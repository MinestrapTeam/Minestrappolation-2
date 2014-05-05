package sobiohazardous.mods.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */
public class EOOreGenerator implements IWorldGenerator
{
	public static ExtraOres BASEMOD;

	public EOOreGenerator()
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

	public void generateSurface(World world, Random rand, int chunkx, int chunkz)
	{
		//Zirconium Ore
		for(int l = 0; l<5; l++) //5 = how much veins in a chunk (chunk = 16x16x128)
		{
			int i1 = chunkx +rand.nextInt(16);
			int j1 = rand.nextInt(28); //layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.meuroditeOre, 5)).generate(world, rand, i1, j1, k1); //5 = how much in a vain
		}
		//Uranium Ore
		for(int o = 0; o<8; o++)
		{
			int i2 = chunkx +rand.nextInt(16);
			int j2 = rand.nextInt(32); 
			int k2 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.UraniumOre, 3)).generate(world, rand, i2, j2, k2); 
		}

		//Plutonium Ore
		for(int u = 0; u<8; u++)
		{
			int i3 = chunkx +rand.nextInt(16);
			int j3 = rand.nextInt(32); 
			int k3 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.PlutoniumOre, 3)).generate(world, rand, i3, j3, k3);
		}
		//Titanium Ore
		for(int q = 0; q<8; q++)
		{
			int i4 = chunkx +rand.nextInt(16);
			int j4 = rand.nextInt(16); 
			int k4 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.TitaniumOre, 3)).generate(world, rand, i4, j4, k4);
		}
		//torite ore
		BiomeGenBase biome2 = world.getWorldChunkManager().getBiomeGenAt(chunkx, chunkz);
		if(biome2 instanceof BiomeGenJungle)
		{
		    for(int h = 0; h<12; h++)
		    {
		    	int i5 = chunkx +rand.nextInt(16);
		    	int j5 = rand.nextInt(30); 
		    	int k5 = chunkz + rand.nextInt(16);
		
		    (new WorldGenMinable(EOBlocks.ToriteOre, 4)).generate(world, rand, i5, j5, k5);
		    }
		}
		//sunstone ore
		for(int h = 0; h<10; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(42); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.SunstoneOre, 3)).generate(world, rand, i5, j5, k5);
		}
		//granite
		for(int h = 0; h<12; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(256); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.Granite, 50)).generate(world, rand, i5, j5, k5);
		}
		//quartzite
		for(int h = 0; h<12; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(8 + 100); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenDesertQuartzSpire()).generate(world, rand, i5, j5, k5);
		}
		//copper ore
		for(int h = 0; h<13; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(1 + 64); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.CopperOre, 10)).generate(world, rand, i5, j5, k5);
		}	
		//tin ore
		for(int h = 0; h<14; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(1 + 64); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.TinOre, 11)).generate(world, rand, i5, j5, k5);
		}	
		//invincium
		for(int h = 0; h<400; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(1); 
			int k5 = chunkz + rand.nextInt(16);
		
		(new WorldGenInvincium(EOBlocks.Invincium, 20)).generate(world, rand, i5, j5, k5);
		}	
		//Radiant Quartz
		for(int q = 0; q<9; q++)
		{
			int i4 = chunkx +rand.nextInt(16);
			int j4 = rand.nextInt(256); 
			int k4 = chunkz + rand.nextInt(16);
		
		(new WorldGenMinable(EOBlocks.RadiantQuartzOre , 3)).generate(world, rand, i4, j4, k4);
		}
	}
	public void generateNether(World world, Random rand, int chunkx, int chunkz)
	{
		//blazium ore
		for(int h = 0; h<9; h++)
		{
			int i5 = chunkx + rand.nextInt(16);
			int j5 = rand.nextInt(256);
			int k5 = chunkz + rand.nextInt(16);
			
			(new WorldGenNether(EOBlocks.BlaziumOre, 13)).generate(world, rand, i5, j5, k5);
		}
		//soul ore
		for(int h = 0; h<28; h++)
		{
			int i5 = chunkx + rand.nextInt(16);
			int j5 = rand.nextInt(256);
			int k5 = chunkz + rand.nextInt(16);
			
			(new WorldGenSoulSand(EOBlocks.SoulOre, 15)).generate(world,rand, i5, j5, k5);
		}
		//invincium
		for(int h = 0; h<400; h++)
		{
			int i5 = chunkx +rand.nextInt(16);
			int j5 = rand.nextInt(1); 
			int k5 = chunkz + rand.nextInt(16);
				
		(new WorldGenInvincium(EOBlocks.Invincium, 20)).generate(world, rand, i5, j5, k5);
		}
	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
