package sobiohazardous.minestrappolation.extraenviroments;

import sobiohazardous.minestrappolation.api.biome.MCustomBiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRedwood extends BiomeGenBase {
	private MCustomBiomeDecorator biomedec;

	public BiomeGenRedwood(int par1) {
		super(par1);
		
		theBiomeDecorator = new MCustomBiomeDecorator(this);
		biomedec = (MCustomBiomeDecorator)theBiomeDecorator;
		
		
	}

}
