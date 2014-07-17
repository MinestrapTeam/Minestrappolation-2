package minestrapteam.minestrappolation.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import minestrapteam.mcore.lib.MCBlocks;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MOreGenerator implements IWorldGenerator
{
	public MOreGenerator()
	{
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX <<= 4;
		chunkZ <<= 4;
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			this.generateSurface(world, random, chunkX, chunkZ);
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			this.generateNether(world, random, chunkX, chunkZ);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			this.generateEnd(world, random, chunkX, chunkZ);
		}
	}
	
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		int x1;
		int y1;
		int z1;
		
		BiomeGenBase biome = world.getBiomeGenForCoords(chunkX, chunkZ);
		
		if (biome instanceof BiomeGenDesert)
		{
			for (int i = 0; i < 40; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(256);
				z1 = chunkZ + rand.nextInt(16);
				
				new WorldGenMinable(MCBlocks.sandstone, 6, 7, Blocks.sandstone).generate(world, rand, x1, y1, z1);
			}
			for (int i = 0; i < 40; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(256);
				z1 = chunkZ + rand.nextInt(16);
				
				new WorldGenMinable(MCBlocks.sandstone, 7, 7, Blocks.sandstone).generate(world, rand, x1, y1, z1);
			}
		}
		
		for (int i = 0; i < 50; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(200);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MCBlocks.woodOak, 3, 15, Blocks.planks).generate(world, rand, x1, y1, z1);
		}
		
		// Meurodite Ore
		for (int i = 0; i < 8; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(40);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.meuroditeOre, 5).generate(world, rand, x1, y1, z1);
		}
		// Uranium Ore
		for (int i = 0; i < 6; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.uraniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// Plutonium Ore
		for (int i = 0; i < 6; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.plutoniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// Titanium Ore
		for (int i = 0; i < 4; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(10);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.titaniumOre, 3).generate(world, rand, x1, y1, z1);
		}
		// Torite Ore
		if (biome instanceof BiomeGenJungle || biome instanceof BiomeGenForest)
		{
			for (int i = 0; i < 7; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(30);
				z1 = chunkZ + rand.nextInt(16);
				
				new WorldGenMinable(MBlocks.toriteOre, 3).generate(world, rand, x1, y1, z1);
			}
		}
		// Sunstone Ore
		for (int i = 0; i < 10; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.sunstoneOre, 3).generate(world, rand, x1, y1, z1);
		}
		
		// Granite
		for (int i = 0; i < 12; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(Block.getBlockFromItem(new ItemStack(MCBlocks.graniteSlate, 1, 0).getItem()), 50).generate(world, rand, x1, y1, z1);
		}
		
		// Desert Quartz
		if (biome instanceof BiomeGenDesert)
		{
			for (int i = 0; i < 12; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(100);
				z1 = chunkZ + rand.nextInt(16);
				
				new WorldGenDesertQuartz().generate(world, rand, x1, y1, z1);
			}
		}
		
		// Red Sandstone
		if (biome instanceof BiomeGenMesa)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			new WorldGenRedSandstone().generate(world, rand, x1, y1, z1);
		}
		
		// Copper Ore
		for (int i = 0; i < 14; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(80);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.copperOre, 10).generate(world, rand, x1, y1, z1);
		}
		// Tin Ore
		for (int i = 0; i < 14; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(80);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.tinOre, 11).generate(world, rand, x1, y1, z1);
		}
		// Radiant Quartz
		for (int i = 0; i < 9; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(128);
			z1 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.radiantQuartzOre, 3).generate(world, rand, x1, y1, z1);
		}
		
		for (x1 = 0; x1 < 16; x1++)
		{
			for (z1 = 0; z1 < 16; z1++)
			{
				world.setBlock(chunkX + x1, 0, chunkZ + z1, MBlocks.invincium, 0, 0);
			}
		}
	}
	
	public void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
		// blazium ore
		for (int h = 0; h < 8; h++)
		{
			int i5 = chunkX + rand.nextInt(16);
			int j5 = rand.nextInt(128);
			int k5 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.blaziumOre, 8, Blocks.netherrack).generate(world, rand, i5, j5, k5);
		}
		// soul ore
		for (int h = 0; h < 20; h++)
		{
			int i5 = chunkX + rand.nextInt(16);
			int j5 = rand.nextInt(128);
			int k5 = chunkZ + rand.nextInt(16);
			
			new WorldGenMinable(MBlocks.soulOre, 15, Blocks.soul_sand).generate(world, rand, i5, j5, k5);
		}
		// invincium
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				world.setBlock(chunkX + i, 0, chunkZ + j, MBlocks.invincium, 0, 0);
			}
		}
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
}
