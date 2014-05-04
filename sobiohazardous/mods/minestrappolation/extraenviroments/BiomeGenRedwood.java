package sobiohazardous.mods.minestrappolation.extraenviroments;

import sobiohazardous.mods.minestrappolation.core.biome.MCustomBiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRedwood extends BiomeGenBase 
{
	private MCustomBiomeDecorator biomedec;

	public BiomeGenRedwood(int par1) 
	{
		super(par1);
		
		theBiomeDecorator = new MCustomBiomeDecorator();
		biomedec = (MCustomBiomeDecorator)theBiomeDecorator;				
	}

}
