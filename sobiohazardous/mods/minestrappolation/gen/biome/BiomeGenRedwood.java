package sobiohazardous.mods.minestrappolation.gen.biome;

import sobiohazardous.mods.minestrappolation.core.biome.MCCustomBiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRedwood extends BiomeGenBase
{
	public BiomeGenRedwood(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new MCCustomBiomeDecorator();
	}
}
