package sobiohazardous.minestrappolation.extradecor.gen;

import java.util.Random;

import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.*;
import net.minecraft.item.ItemStack;
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
		for(int l = 0; l <20; l++) //5 = how much veins in a chunk (chunk = 16x16x128)
		{
			int i1 = chunkx +rand.nextInt(16);
			int j1 = rand.nextInt(80); //layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
		
		(new WorldGenSandstone(EDBlockManager.sandstoneBricks.blockID, 3, 6)).generate(world, rand, i1, j1, k1); //5 = how much in a vain
		}
		
		for(int l1 = 0; l1 <20; l1++) //5 = how much veins in a chunk (chunk = 16x16x128)
		{
			int i1 = chunkx +rand.nextInt(16);
			int j1 = rand.nextInt(256); //layer it spawns in
			int k1 = chunkz + rand.nextInt(16);
		
		(new WorldGenSandstone(EDBlockManager.sandstoneBricks.blockID, 4, 6)).generate(world, rand, i1, j1, k1); //5 = how much in a vain
		}
		
	}
	
	public void generateNether(World world, Random rand, int chunkx, int chunkz)
	{
		
	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
