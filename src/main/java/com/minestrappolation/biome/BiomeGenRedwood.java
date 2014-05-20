package com.minestrappolation.biome;

import com.minestrappolation_core.biome.MCCustomBiomeDecorator;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRedwood extends BiomeGenBase
{
	public BiomeGenRedwood(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new MCCustomBiomeDecorator();
	}
}
