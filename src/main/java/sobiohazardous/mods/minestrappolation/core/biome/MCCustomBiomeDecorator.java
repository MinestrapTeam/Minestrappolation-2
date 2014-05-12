package sobiohazardous.mods.minestrappolation.core.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class MCCustomBiomeDecorator extends BiomeDecorator
{
	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int x, int z)
	{
		// decorate the biome
		super.decorateChunk(world, rand, biome, x, z);
	}
	
	@Override
	protected void generateOres()
	{
		// generate ores
		super.generateOres();
	}
}
