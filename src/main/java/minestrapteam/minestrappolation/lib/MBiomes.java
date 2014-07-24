package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.biome.BiomeGenRedwood;
import minestrapteam.minestrappolation.biome.MCBiomeManager;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomes
{
	public static BiomeGenBase	redwood;
	
	public static void loadBiomes()
	{
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
		
		
		MCBiomeManager.addWarmBiome(redwood, 75, Type.FOREST);
	}
	
}
