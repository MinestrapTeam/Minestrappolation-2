package sobiohazardous.mods.minestrappolation.lib;

import net.minecraft.world.biome.BiomeGenBase;
import sobiohazardous.mods.minestrappolation.gen.biome.BiomeGenRedwood;

public class MBiomes
{
	public static BiomeGenBase	redwood;

	public static void loadBiomes()
	{
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
	}

}
