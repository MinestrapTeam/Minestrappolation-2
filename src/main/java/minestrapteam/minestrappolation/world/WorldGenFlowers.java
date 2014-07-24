package minestrapteam.minestrappolation.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlowers extends WorldGenerator
{
	/** The plant block used in this plant generator. */
	private Block	block;
	private int		metadata;
	
	public WorldGenFlowers(Block block)
	{
		this(block, 0);
	}
	
	public WorldGenFlowers(Block block, int metadata)
	{
		this.block = block;
		this.metadata = metadata;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for (int l = 0; l < 64; ++l)
		{
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			int j1 = y + random.nextInt(4) - random.nextInt(4);
			int k1 = z + random.nextInt(8) - random.nextInt(8);
			
			if (world.isAirBlock(i1, j1, k1) && this.block.canBlockStay(world, i1, j1, k1))
			{
				world.setBlock(i1, j1, k1, this.block, this.metadata, 2);
			}
		}
		
		return true;
	}
}