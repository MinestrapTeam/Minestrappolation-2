package com.minestrappolation.lib;

import com.minestrappolation.biome.BiomeGenRedwood;

import net.minecraft.world.biome.BiomeGenBase;

public class MBiomes
{
	public static BiomeGenBase	redwood;
	
	public static void loadBiomes()
	{
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
	}
	
}
