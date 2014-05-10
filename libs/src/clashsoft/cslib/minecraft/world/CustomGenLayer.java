package clashsoft.cslib.minecraft.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class CustomGenLayer
{	
	public abstract GenLayer getBiomeGenLayer(long seed, WorldType worldType);
	
	public abstract int getBiomeSize(long seed, WorldType worldType);
	
	public GenLayer[] createWorld(long seed, WorldType worldType)
	{
		GenLayer biomes = this.getBiomeGenLayer(seed, worldType);
		int biomeSize = this.getBiomeSize(seed, worldType);
		biomes = GenLayerZoom.magnify(seed, biomes, biomeSize);
		GenLayer voronoiZoom = new GenLayerVoronoiZoom(seed, biomes);
		
		biomes.initWorldGenSeed(seed);
		voronoiZoom.initWorldGenSeed(seed);
		
		return new GenLayer[] { biomes, voronoiZoom };
		
	}
}
