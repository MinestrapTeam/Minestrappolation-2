package sobiohazardous.minestrappolation.api.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class MCustomBiomeDecorator extends BiomeDecorator
{
    /**
     * The method that does the work of actually decorating chunks
     */
    public void decorateChunk(World world, Random rand, BiomeGenBase biome, int par4, int par5)
    {
    	//decorate the biome
        super.decorateChunk(world, rand, biome, par4, par5);
    }

    /**
     * Generates ores in the current chunk
     */
    protected void generateOres()
    {
    	//generate ores
    	super.generateOres();
    }
}
