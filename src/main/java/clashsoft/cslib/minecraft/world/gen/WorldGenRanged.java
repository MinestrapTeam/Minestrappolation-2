package clashsoft.cslib.minecraft.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRanged extends WorldGenerator
{
	public int		amount;
	public int		rangeX;
	public int		rangeY;
	public int		rangeZ;
	
	public Block	block;
	public int		metadata;
	
	public WorldGenRanged(Block bush, int bushMeta)
	{
		this(64, 8, 4, 8, bush, bushMeta);
	}
	
	public WorldGenRanged(int amount, int rangeX, int rangeY, int rangeZ, Block block, int metadata)
	{
		this.amount = amount;
		this.rangeX = rangeX;
		this.rangeY = rangeY;
		this.rangeZ = rangeZ;
		
		this.block = block;
		this.metadata = metadata;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for (int i = 0; i < this.amount; ++i)
		{
			int x1 = x + random.nextInt(this.rangeX) - random.nextInt(this.rangeX);
			int y1 = y + random.nextInt(this.rangeY) - random.nextInt(this.rangeY);
			int z1 = z + random.nextInt(this.rangeZ) - random.nextInt(this.rangeZ);
			
			if (this.block.canPlaceBlockAt(world, x1, y1, z1))
			{
				world.setBlock(x1, y1, z1, this.block, this.metadata, 2);
			}
		}
		
		return true;
	}
}
