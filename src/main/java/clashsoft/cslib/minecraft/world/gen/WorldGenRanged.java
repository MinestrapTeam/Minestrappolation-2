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
		for (int l = 0; l < this.amount; ++l)
		{
			int i1 = x + random.nextInt(this.rangeX) - random.nextInt(this.rangeX);
			int j1 = y + random.nextInt(this.rangeY) - random.nextInt(this.rangeY);
			int k1 = z + random.nextInt(this.rangeZ) - random.nextInt(this.rangeZ);
			
			if (world.isAirBlock(i1, j1, k1) && this.block.canPlaceBlockAt(world, i1, j1, k1))
			{
				world.setBlock(i1, j1, k1, this.block, this.metadata, 2);
			}
		}
		
		return true;
	}
}
