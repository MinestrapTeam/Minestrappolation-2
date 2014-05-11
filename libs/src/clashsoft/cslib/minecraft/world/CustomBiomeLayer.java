package clashsoft.cslib.minecraft.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public abstract class CustomBiomeLayer extends GenLayer
{
	public CustomBiomeLayer(long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
	}
	
	public CustomBiomeLayer(long seed)
	{
		super(seed);
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		BiomeGenBase[] biomes = this.getBiomes();
		
		int[] dest = IntCache.getIntCache(width * depth);
		
		for (int dz = 0; dz < depth; dz++)
		{
			for (int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[dx + dz * width] = biomes[this.nextInt(biomes.length)].biomeID;
			}
		}
		return dest;
	}
	
	public abstract BiomeGenBase[] getBiomes();
}
