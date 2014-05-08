package sobiohazardous.mods.minestrappolation.core.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class MCustomBiomeDecorator extends BiomeDecorator
{
	/**
	 * The method that does the work of actually decorating chunks
	 */
	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int x, int z)
	{
		// decorate the biome
		super.decorateChunk(world, rand, biome, x, z);
	}
	
	/**
	 * Generates ores in the current chunk
	 */
	@Override
	protected void generateOres()
	{
		// generate ores
		super.generateOres();
	}
}
