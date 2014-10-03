package minestrapteam.minestrappolation.world;

import java.util.Random;

import clashsoft.cslib.minecraft.block.ore.BlockOre2;
import cpw.mods.fml.common.IWorldGenerator;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MConfig;
import minestrapteam.minestrappolation.world.gen.WorldGenDesertQuartz;
import minestrapteam.minestrappolation.world.gen.WorldGenRedSandstone;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTreeSmall;
import minestrapteam.minestrappolation.world.gen.WorldGenStructureStone;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraft.world.chunk.Chunk;
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
	public static WorldGenMinable			slateGen			= new WorldGenMinable(MBlocks.graniteSlate, 50);
	public static WorldGenMinable			copperGen			= new WorldGenMinable(MBlocks.copperOre, 10);
	public static WorldGenMinable			tinGen				= new WorldGenMinable(MBlocks.tinOre, 11);
	public static WorldGenMinable			radiantQuartzGen	= new WorldGenMinable(MBlocks.radiantQuartzOre, 3);
	public static WorldGenMinable			mossyPlankGen		= new WorldGenMinable(MBlocks.oak, 3, 15, Blocks.planks);
	public static WorldGenMinable			meuroditeGen		= new WorldGenMinable(MBlocks.meuroditeOre, 5);
	public static WorldGenMinable			uraniumGen			= new WorldGenMinable(MBlocks.uraniumOre, 3);
	public static WorldGenMinable			plutoniumGen		= new WorldGenMinable(MBlocks.plutoniumOre, 3);
	public static WorldGenMinable			titaniumGen			= new WorldGenMinable(MBlocks.titaniumOre, 3);
	public static WorldGenMinable			toriteGen			= new WorldGenMinable(MBlocks.toriteOre, 3);
	public static WorldGenMinable			sunstoneGen			= new WorldGenMinable(MBlocks.sunstoneOre, 3);
	public static WorldGenMinable			sandstoneGen		= new WorldGenMinable(MBlocks.sandstone, 6, 7, Blocks.sandstone);
	public static WorldGenMinable			sandstoneGen2		= new WorldGenMinable(MBlocks.sandstone, 7, 7, Blocks.sandstone);
	public static WorldGenRedSandstone		redSandstoneGen		= new WorldGenRedSandstone();
	public static WorldGenStructureStone	stoneStructureGen	= new WorldGenStructureStone();
	public static WorldGenDesertQuartz		desertQuartzGen		= new WorldGenDesertQuartz();
	public static WorldGenMinable			blaziumGen			= new WorldGenMinable(MBlocks.blaziumOre, 8, Blocks.netherrack);
	public static WorldGenMinable			soulOreGen			= new WorldGenMinable(MBlocks.soulOre, 15, Blocks.soul_sand);
	public static WorldGenRedWoodTreeSmall	redwoodTreeGen		= new WorldGenRedWoodTreeSmall();
	
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
			if (MConfig.generateBiomeStone)
			{
				this.genBiomeStone(world, chunkX, chunkZ, random);
			}
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
		
		// Red Sandstone
		if (biome instanceof BiomeGenDesert)
		{
			for (int i = 0; i < 40; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(256);
				z1 = chunkZ + rand.nextInt(16);
				
				sandstoneGen.generate(world, rand, x1, y1, z1);
			}
			for (int i = 0; i < 40; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(256);
				z1 = chunkZ + rand.nextInt(16);
				
				sandstoneGen2.generate(world, rand, x1, y1, z1);
			}
		}
		
		if (biome instanceof BiomeGenHills || biome instanceof BiomeGenTaiga)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = 64 + rand.nextInt(64);
			z1 = chunkZ + rand.nextInt(16);
			
			redwoodTreeGen.generate(world, rand, x1, y1, z1);
		}
		
		// Mossy Planks
		for (int i = 0; i < 50; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = 16 + rand.nextInt(128);
			z1 = chunkZ + rand.nextInt(16);
			
			mossyPlankGen.generate(world, rand, x1, y1, z1);
		}
		
		// Meurodite Ore
		for (int i = 0; i < 8; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(40);
			z1 = chunkZ + rand.nextInt(16);
			
			meuroditeGen.generate(world, rand, x1, y1, z1);
		}
		
		// Uranium Ore
		for (int i = 0; i < 6; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			uraniumGen.generate(world, rand, x1, y1, z1);
		}
		
		// Plutonium Ore
		for (int i = 0; i < 6; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(32);
			z1 = chunkZ + rand.nextInt(16);
			
			plutoniumGen.generate(world, rand, x1, y1, z1);
		}
		
		// Titanium Ore
		for (int i = 0; i < 4; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(10);
			z1 = chunkZ + rand.nextInt(16);
			
			titaniumGen.generate(world, rand, x1, y1, z1);
		}
		
		// Torite Ore
		if (biome instanceof BiomeGenJungle || biome instanceof BiomeGenForest)
		{
			for (int i = 0; i < 7; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(30);
				z1 = chunkZ + rand.nextInt(16);
				
				toriteGen.generate(world, rand, x1, y1, z1);
			}
		}
		
		// Sunstone Ore
		for (int i = 0; i < 15; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			sunstoneGen.generate(world, rand, x1, y1, z1);
		}
		
		// Granite
		for (int i = 0; i < 12; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			
			slateGen.generate(world, rand, x1, y1, z1);
		}
		
		// Desert Quartz
		if (biome instanceof BiomeGenDesert)
		{
			for (int i = 0; i < 12; i++)
			{
				x1 = chunkX + rand.nextInt(16);
				y1 = rand.nextInt(100);
				z1 = chunkZ + rand.nextInt(16);
				
				desertQuartzGen.generate(world, rand, x1, y1, z1);
			}
		}
		
		// Structure Gen
		
		x1 = chunkX + rand.nextInt(16);
		y1 = rand.nextInt(256);
		z1 = chunkZ + rand.nextInt(16);
		stoneStructureGen.generate(world, rand, x1, y1, z1);
		
		// Red Sandstone
		if (biome instanceof BiomeGenMesa)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(256);
			z1 = chunkZ + rand.nextInt(16);
			redSandstoneGen.generate(world, rand, x1, y1, z1);
		}
		
		// Copper Ore
		for (int i = 0; i < 14; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(80);
			z1 = chunkZ + rand.nextInt(16);
			
			copperGen.generate(world, rand, x1, y1, z1);
		}
		
		// Tin Ore
		for (int i = 0; i < 14; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(80);
			z1 = chunkZ + rand.nextInt(16);
			
			tinGen.generate(world, rand, x1, y1, z1);
		}
		
		// Radiant Quartz
		for (int i = 0; i < 9; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(128);
			z1 = chunkZ + rand.nextInt(16);
			
			radiantQuartzGen.generate(world, rand, x1, y1, z1);
		}
		
		if (MConfig.generateInvincium)
		{
			for (x1 = 0; x1 < 16; x1++)
			{
				for (z1 = 0; z1 < 16; z1++)
				{
					world.setBlock(chunkX + x1, 0, chunkZ + z1, MBlocks.invincium, 0, 0);
				}
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
			
			blaziumGen.generate(world, rand, i5, j5, k5);
		}
		// soul ore
		for (int h = 0; h < 20; h++)
		{
			int i5 = chunkX + rand.nextInt(16);
			int j5 = rand.nextInt(128);
			int k5 = chunkZ + rand.nextInt(16);
			
			soulOreGen.generate(world, rand, i5, j5, k5);
		}
		// Invincium
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
		this.generateObsidianSpikes(world, random, chunkX, chunkZ);
	}
	
	public void generateObsidianSpikes(World world, Random random, int chunkX, int chunkZ)
	{
		for (int x = 0; x < 16; x++)
		{
			int x1 = chunkX + x;
			for (int z = 0; z < 16; z++)
			{
				int z1 = chunkZ + z;
				yLoop:
				for (int y = 0; y < 128; y++)
				{
					if (world.getBlock(x1, y, z1) == Blocks.obsidian && world.getBlock(x1, y + 1, z1) == Blocks.air)
					{
						world.setBlock(x1, y, z1, MBlocks.endstone, 4, 3);
						break yLoop;
					}
				}
			}
		}
	}
	
	public void genBiomeStone(World world, int chunkX, int chunkZ, Random random)
	{
		Chunk chunk = world.getChunkFromBlockCoords(chunkX, chunkZ);
		WorldChunkManager chunkManager = world.getWorldChunkManager();
		
		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				BiomeGenBase biome = chunk.getBiomeGenForWorldCoords(x, z, chunkManager);
				Block stoneBlock = Blocks.stone;
				Block deepStoneBlock = null;
				int oreMetadata = 0;
				int deepOreMetadata = 0;
				int deepStoneDepth = 0;
				
				if (biome.temperature < 0.2F)
				{
					stoneBlock = MBlocks.icestone;
					deepStoneBlock = MBlocks.glacierrock;
					deepStoneDepth = random.nextInt(5) + 30;
					oreMetadata = 10;
					deepOreMetadata = 11;
				}
				else if (biome.temperature < 0.4F)
				{
					stoneBlock = MBlocks.coldstone;
					deepStoneBlock = MBlocks.deepColdstone;
					deepStoneDepth = random.nextInt(5) + 35;
					oreMetadata = 8;
					deepOreMetadata = 9;
				}
				else if (biome.getTempCategory() == TempCategory.OCEAN)
				{
					stoneBlock = MBlocks.oceanstone;
					deepStoneBlock = MBlocks.pressurizedOceanstone;
					deepStoneDepth = random.nextInt(5) + 20;
					oreMetadata = 12;
					deepOreMetadata = 13;
				}
				else if (biome.temperature >= 1.0F)
				{
					stoneBlock = MBlocks.redrock;
					deepStoneBlock = MBlocks.deepRedrock;
					deepStoneDepth = random.nextInt(5) + 35;
					oreMetadata = 6;
					deepOreMetadata = 7;
				}
				else
				{
					deepStoneBlock = MBlocks.deepstone;
					deepStoneDepth = random.nextInt(5) + 35;
					deepOreMetadata = 5;
				}
				
				for (int y = 128; y >= 0; y--)
				{
					Block block = chunk.getBlock(x, y, z);
					if (block == Blocks.stone)
					{
						if (y < deepStoneDepth)
						{
							chunk.func_150807_a(x, y, z, deepStoneBlock, 0);
						}
						else
						{
							chunk.func_150807_a(x, y, z, stoneBlock, 0);
						}
					}
					else if (block instanceof BlockOre2)
					{
						if (y < deepStoneDepth)
						{
							chunk.func_150807_a(x, y, z, block, deepOreMetadata);
						}
						else
						{
							chunk.func_150807_a(x, y, z, block, oreMetadata);
						}
					}
				}
			}
		}
	}
	
	private static void genBiomeStone(BiomeGenBase biome, World world, Random random, Block[] blocks, byte[] metadata, int chunkX, int chunkZ)
	{
		Block stoneBlock = Blocks.stone;
		Block deepStoneBlock = null;
		int deepStoneDepth = 0;
		
		if (biome.temperature < 0.2F)
		{
			stoneBlock = MBlocks.icestone;
			deepStoneBlock = MBlocks.glacierrock;
			deepStoneDepth = random.nextInt(5) + 30;
		}
		else if (biome.temperature < 0.4F)
		{
			stoneBlock = MBlocks.coldstone;
			deepStoneBlock = MBlocks.deepColdstone;
			deepStoneDepth = random.nextInt(5) + 35;
		}
		else if (biome.getTempCategory() == TempCategory.OCEAN)
		{
			stoneBlock = MBlocks.oceanstone;
			deepStoneBlock = MBlocks.pressurizedOceanstone;
			deepStoneDepth = random.nextInt(5) + 20;
		}
		else if (biome.temperature >= 1.0F)
		{
			stoneBlock = MBlocks.redrock;
			deepStoneBlock = MBlocks.deepRedrock;
			deepStoneDepth = random.nextInt(5) + 35;
		}
		else
		{
			deepStoneBlock = MBlocks.deepstone;
			deepStoneDepth = random.nextInt(5) + 35;
		}
		
		int x = chunkX & 15;
		int z = chunkZ & 15;
		int count = blocks.length / 256;
		
		for (int y = 128; y >= 0; y--)
		{
			int index = (z * 16 + x) * count + y;
			if (blocks[index] == Blocks.stone)
			{
				if (y < deepStoneDepth)
				{
					blocks[index] = deepStoneBlock;
				}
				else
				{
					blocks[index] = stoneBlock;
				}
			}
		}
	}
}
