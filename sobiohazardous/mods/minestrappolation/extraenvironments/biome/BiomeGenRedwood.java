package sobiohazardous.mods.minestrappolation.extraenvironments.biome;

import sobiohazardous.mods.minestrappolation.core.biome.MCustomBiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRedwood extends BiomeGenBase
{	
	public BiomeGenRedwood(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new MCustomBiomeDecorator();
	}	
}
