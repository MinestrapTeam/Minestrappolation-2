package minestrapteam.minestrappolation.biome;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTree;
import minestrapteam.minestrappolation.world.gen.WorldGenRedWoodTreeSmall;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRedwood extends BiomeGenBase
{
	public BiomeGenRedwood(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new MBiomeDecorator();
		
		this.fillerBlock = Blocks.stone;
		this.topBlock = Blocks.dirt;
		this.field_150604_aj = 2;
		
		this.theBiomeDecorator.flowersPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.theBiomeDecorator.grassPerChunk = 11;
		this.theBiomeDecorator.deadBushPerChunk = 4;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 2) : new WorldGenTallGrass(Blocks.tallgrass, 1);
	}
	
	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] metadata, int x, int z, double noise)
	{
		this.fillerBlock = Blocks.dirt;
		this.topBlock = Blocks.grass;
		this.field_150604_aj = 0;
		
		if (noise > 2.5D)
		{
			this.topBlock = Blocks.sand;
			this.field_150604_aj = 0;
			this.fillerBlock = Blocks.sand;
		}
		else if (noise > -0.95D)
		{
			this.topBlock = Blocks.dirt;
			this.field_150604_aj = 2;
		}
		
		this.genBiomeTerrain(world, rand, block, metadata, x, z, noise);
	}
	
	@Override
	public void decorate(World world, Random random, int x, int z)
	{
		for (int k = 0; k < 7; ++k)
		{
			int x1 = x + random.nextInt(16) + 8;
			int z1 = z + random.nextInt(16) + 8;
			int y1 = world.getHeightValue(x1, z1);
			
			genTallFlowers.generate(world, random, x1, y1, z1);
		}
		
		for (int k = 0; k < 4; ++k)
		{
			int x1 = x + random.nextInt(16) + 8;
			int z1 = z + random.nextInt(16) + 8;
			int y1 = world.getHeightValue(x1, z1);
			
			if (MBlocks.mossCover.canPlaceBlockAt(world, x1, y1, z1))
			{
				world.setBlock(x1, y1, z1, MBlocks.mossCover);
			}
		}
		
		super.decorate(world, random, x, z);
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenRedWoodTree() : random.nextInt(8) < 2 ? this.worldGeneratorTrees : new WorldGenRedWoodTreeSmall();
	}
}
