package minestrapteam.minestrappolation.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomeManager
{
	private static void addBiomes(BiomeGenBase biome, Type type)
	{
		BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.registerBiomeType(biome, type);
	}
	
	public static void addCoolBiome(BiomeGenBase biome,int weight,Type type){
		addBiomes(biome,type);
		BiomeManager.coolBiomes.add(new BiomeManager.BiomeEntry(biome,weight));
	}
	
	public static void addWarmBiome(BiomeGenBase biome,int weight,Type type){
		addBiomes(biome,type);
		BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(biome,weight));
	}
	
	public static void addIcyBiome(BiomeGenBase biome,int weight,Type type){
		addBiomes(biome,type);
		BiomeManager.icyBiomes.add(new BiomeManager.BiomeEntry(biome,weight));
	}
	
	public static void addDryBiome(BiomeGenBase biome,int weight,Type type){
		addBiomes(biome,type);
		BiomeManager.desertBiomes.add(new BiomeManager.BiomeEntry(biome,weight));
	}
	
	public static void addOceanBiome(BiomeGenBase biome,Type type){
		addBiomes(biome,type);
		BiomeManager.oceanBiomes.add(biome);
	}
}
