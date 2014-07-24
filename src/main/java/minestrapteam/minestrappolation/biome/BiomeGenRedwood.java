package minestrapteam.minestrappolation.biome;

import java.util.Random;

import minestrapteam.minestrappolation.world.WorldGenRedWoodTree;
import minestrapteam.minestrappolation.world.WorldGenRedWoodTreeSmall;
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
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return par1Random.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 2) : new WorldGenTallGrass(Blocks.tallgrass, 1);
    }
	
	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {
            this.topBlock = Blocks.grass;
            this.field_150604_aj = 0;
            this.fillerBlock = Blocks.dirt;

            if (p_150573_7_ > -0.95D)
            {
                this.topBlock = Blocks.dirt;
                this.field_150604_aj = 2;
            }

        this.genBiomeTerrain(world, rand, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
	       int k;
	       int l;
	       int i1;
	       int j1;

	       for (k = 0; k < 7; ++k)
	       {
	           l = par3 + par2Random.nextInt(16) + 8;
	           i1 = par4 + par2Random.nextInt(16) + 8;
	           j1 = par2Random.nextInt(par1World.getHeightValue(l, i1) + 32);
	           genTallFlowers.generate(par1World, par2Random, l, j1, i1);
        }
	  
	       super.decorate(par1World, par2Random, par3, par4);
	}
	
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return rand.nextInt(4) > 2 ? new WorldGenRedWoodTree() : new WorldGenRedWoodTreeSmall();
    }

}
