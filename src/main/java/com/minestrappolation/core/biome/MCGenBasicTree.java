package com.minestrappolation.core.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MCGenBasicTree extends WorldGenerator
{
	Block	leavesID;
	Block	woodID;
	int		height;
	int		thickness;
	int		treeType	= 1;
	
	public MCGenBasicTree(Block leavesBlockID, Block woodBlockID, int height, int leavethickness)
	{
		this.leavesID = leavesBlockID;
		this.woodID = woodBlockID;
		this.height = height;
		// to thick and the leaves will start to decay
		this.thickness = leavethickness;
		if (this.treeType == 1)
		{
			System.out.println("basic tree type");
		}
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for (; y > 0 && world.isAirBlock(x, y, z); --y)
		{
		}
		
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.dirt || block == Blocks.grass)
		{
			++y;
			
			for (int a = 0; a < this.height + 1; a++)
			{
				this.setBlockAndNotifyAdequately(world, x, y + a, z, this.woodID, 1);
			}
			this.setBlockAndNotifyAdequately(world, x, y + this.height, z, this.leavesID, 1);
			
			for (int y1 = y; y1 <= y + 1; ++y1)
			{
				int y2 = y1 - y;
				int y3 = 2 - y2;
				
				for (int x1 = x - y3; x1 <= x + y3; ++x1)
				{
					int x2 = x1 - x;
					
					for (int z1 = z - y3; z1 <= z + y3; ++z1)
					{
						int z2 = z1 - z;
						
						if ((Math.abs(x2) != y3 || Math.abs(z2) != y3 || random.nextInt(2) != 0) && !world.isBlockNormalCubeDefault(x1, y1, z1, true))
						{
							for (int v = 0; v < this.thickness; v++)
							{
								this.setBlockAndNotifyAdequately(world, x1, y1 + this.height - v, z1, this.leavesID, 1);
							}
						}
					}
				}
			}
		}
		
		return true;
	}
}