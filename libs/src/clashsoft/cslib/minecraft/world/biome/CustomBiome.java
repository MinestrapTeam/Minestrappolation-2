package clashsoft.cslib.minecraft.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class CustomBiome extends BiomeGenBase implements ICustomBiome
{
	public CustomBiome(int id)
	{
		super(id);
	}
	
	public CustomBiome(int id, boolean register)
	{
		super(id, register);
	}
	
	@Override
	public Block getTopBlock(int x, int y, int z)
	{
		return this.topBlock;
	}
	
	@Override
	public Block getFillerBlock(int x, int y, int z)
	{
		return this.fillerBlock;
	}
	
	@Override
	public Block getStoneBlock(int x, int y, int z)
	{
		return Blocks.stone;
	}
	
	@Override
	public byte getTopMetadata(int x, int y, int z)
	{
		return 0;
	}
	
	@Override
	public byte getFillerMetadata(int x, int y, int z)
	{
		return 0;
	}
	
	@Override
	public byte getStoneMetadata(int x, int y, int z)
	{
		return 0;
	}
	
	@Override
	public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] metadatas, int x, int z, double noise)
	{
		Block topBlock = this.topBlock;
		Block fillerBlock = this.fillerBlock;
		byte topMeta = 0;
		byte fillerMeta = 0;
		
		int count = blocks.length >> 8;
		int x1 = x & 0xF;
		int z1 = z & 0xF;
		int index1 = ((z1 << 4) + x1) * count;
		int sandHeight = -1;
		int randomNoise = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		
		for (int y = 255; y >= 0; --y)
		{
			int index = index1 + y;
			
			if (y < 5 && y <= random.nextInt(5))
			{
				blocks[index] = Blocks.bedrock;
				continue;
			}
			
			Block block = blocks[index];
			
			if (block != null && block.getMaterial() != Material.air)
			{
				if (block != Blocks.stone)
				{
					continue;
				}
				
				blocks[index] = this.getStoneBlock(x, y, z);
				metadatas[index] = this.getStoneMetadata(x, y, z);
				
				if (sandHeight == -1)
				{
					if (randomNoise <= 0)
					{
						topBlock = null;
						topMeta = 0;
						
						fillerBlock = this.getStoneBlock(x, y, z);
						fillerMeta = this.getStoneMetadata(x, y, z);
					}
					else if (y > 58 && y <= 64)
					{
						topBlock = this.getTopBlock(x, y, z);
						topMeta = this.getTopMetadata(x, y, z);
						
						fillerBlock = this.getFillerBlock(x, y, z);
						fillerMeta = this.getFillerMetadata(x, y, z);
					}
					
					if (y < 63 && topBlock == null)
					{
						if (this.getFloatTemperature(x, y, z) < 0.15F)
						{
							topBlock = Blocks.ice;
							topMeta = 0;
						}
						else
						{
							topBlock = Blocks.water;
							topMeta = 0;
						}
					}
					
					sandHeight = randomNoise;
					
					if (y >= 62)
					{
						blocks[index] = topBlock;
						metadatas[index] = topMeta;
					}
					else if (y < 56 - randomNoise)
					{
						topBlock = null;
						topMeta = 0;
						
						fillerBlock = this.getStoneBlock(x, y, z);
						fillerMeta = this.getStoneMetadata(x, y, z);
					}
					else
					{
						blocks[index] = fillerBlock;
						metadatas[index] = fillerMeta;
					}
				}
				else
				{
					--sandHeight;
					blocks[index] = fillerBlock;
					metadatas[index] = fillerMeta;
					
					if (sandHeight == 0 && fillerBlock == Blocks.sand)
					{
						sandHeight = random.nextInt(4) + Math.max(0, y - 63);
						fillerBlock = Blocks.sandstone;
					}
				}
			}
			else
			{
				sandHeight = -1;
			}
		}
	}
}
