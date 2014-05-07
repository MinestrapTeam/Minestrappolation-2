package clashsoft.cslib.minecraft.world.biome;

import net.minecraft.block.Block;

public interface ICustomBiome
{
	public Block getTopBlock(int x, int y, int z);
	
	public Block getFillerBlock(int x, int y, int z);
	
	public Block getStoneBlock(int x, int y, int z);
	
	public byte getTopMetadata(int x, int y, int z);
	
	public byte getFillerMetadata(int x, int y, int z);
	
	public byte getStoneMetadata(int x, int y, int z);
}
