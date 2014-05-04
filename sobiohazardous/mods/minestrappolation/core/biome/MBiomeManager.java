package sobiohazardous.mods.minestrappolation.core.biome;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomeManager 
{
	public static void addBiomes(BiomeGenBase biomeToAdd,Type tpye)
	{
		BiomeManager.addSpawnBiome(biomeToAdd);
		//TODO Not sure if this works
		BiomeDictionary.registerBiomeType(biomeToAdd, tpye);
	}	
}
