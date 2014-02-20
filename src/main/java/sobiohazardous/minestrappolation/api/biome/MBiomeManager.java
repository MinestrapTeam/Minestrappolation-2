package sobiohazardous.minestrappolation.api.biome;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomeManager {
	
	public static void addBiomes(BiomeGenBase biomeToAdd,Type tpye){
		GameRegistry.addBiome(biomeToAdd);
		BiomeDictionary.registerBiomeType(biomeToAdd, tpye);
	}
	
	
	

}
