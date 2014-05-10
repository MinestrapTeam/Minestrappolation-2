package sobiohazardous.mods.minestrappolation.extraores.gen;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * @author SoBiohazardous
 */
public class EOOreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		// if (chunkGenerator instanceof ChunkProviderGenerate)
		// {
		// this.generateSurface(world, random, chunkX << 4, chunkZ << 4);
		// }
		// else if (chunkGenerator instanceof ChunkProviderHell)
		// {
		// this.generateNether(world, random, chunkX << 4, chunkZ << 4);
		// }
		// else if (chunkGenerator instanceof ChunkProviderEnd)
		// {
		// this.generateEnd(world, random, chunkX << 4, chunkZ << 4);
		// }
	}
	
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		int x1;
		int y1;
		int z1;
		
		// Zirconium Ore
		for (int i = 0; i < 5; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(28); // layer it spawns in
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.meuroditeOre, 5).generate(world, rand, x1, y1, z1);
		}
		// Uranium Ore
		for (int i = 0; i < 8; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.UraniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// Plutonium Ore
		for (int i = 0; i < 8; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.PlutoniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// Titanium Ore
		for (int i = 0; i < 8; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(16);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.TitaniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// torite ore
		for (int h = 0; h < 12; h++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(30);
			z1 = chunkZ + rand.nextInt(16);
			
			if (world.getBiomeGenForCoords(x1, z1) instanceof BiomeGenJungle)
			{
				new WorldGenMinable(EOBlocks.ToriteOre, 4).generate(world, rand, x1, y1, z1);
			}
		}
		// sunstone ore
		for (int i = 0; i < 10; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(42);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.SunstoneOre, 3).generate(world, rand, x1, y1, z1);
		}
		// granite
		for (int i = 0; i < 12; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.Granite, 50).generate(world, rand, x1, y1, z1);
		}
		// Desert Quartz
		for (int i = 0; i < 12; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(108);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenDesertQuartzSpire().generate(world, rand, x1, y1, z1);
		}
		// copper ore
		for (int i = 0; i < 13; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(1 + 64);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.CopperOre, 10).generate(world, rand, x1, y1, z1);
		}
		// tin ore
		for (int i = 0; i < 14; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(1 + 64);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.TinOre, 11).generate(world, rand, x1, y1, z1);
		}
		// Radiant Quartz
		for (int i = 0; i < 9; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.RadiantQuartzOre, 3).generate(world, rand, x1, y1, z1);
		}
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				world.setBlock(chunkX + i, 0, chunkZ + j, EOBlocks.Invincium);
			}
		}
	}
	
	public void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
		// blazium ore
		for (int h = 0; h < 9; h++)
		{
			int i5 = chunkX + rand.nextInt(16);
			int j5 = rand.nextInt(128);
			int k5 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.BlaziumOre, 13, Blocks.netherrack).generate(world, rand, i5, j5, k5);
		}
		// soul ore
		for (int h = 0; h < 28; h++)
		{
			int i5 = chunkX + rand.nextInt(16);
			int j5 = rand.nextInt(128);
			int k5 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(EOBlocks.SoulOre, 15, Blocks.soul_sand).generate(world, rand, i5, j5, k5);
		}
		// invincium
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				world.setBlock(chunkX + i, 0, chunkZ + j, EOBlocks.Invincium);
			}
		}
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
}
