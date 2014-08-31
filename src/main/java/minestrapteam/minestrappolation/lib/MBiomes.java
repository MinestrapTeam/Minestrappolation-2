package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.biome.BiomeGenRedwood;
import minestrapteam.minestrappolation.biome.MBiomeManager;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomes
{
	public static BiomeGenBase	redwood;
	
	public static void load()
	{
		redwood = new BiomeGenRedwood(115).setBiomeName("Redwood Forest");
		
		MBiomeManager.addWarmBiome(redwood, 10, Type.FOREST);
	}
	
}
