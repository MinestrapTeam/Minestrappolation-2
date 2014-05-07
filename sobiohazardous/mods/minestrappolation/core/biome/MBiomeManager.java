package sobiohazardous.mods.minestrappolation.core.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomeManager
{
	public static void addBiomes(BiomeGenBase biome, Type type)
	{
		BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.registerBiomeType(biome, type);
	}
}
