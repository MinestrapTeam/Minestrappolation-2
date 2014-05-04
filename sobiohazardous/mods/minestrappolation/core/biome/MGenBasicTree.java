package sobiohazardous.mods.minestrappolation.core.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MGenBasicTree extends WorldGenerator
{
	Block leavesID;
	Block woodID;
	int height;
	int thickness;
	int treeType = 1;


	public MGenBasicTree(Block leavesBlockID, Block woodBlockID,int height,int leavethickness)
	{
		this.leavesID = leavesBlockID;
		this.woodID = woodBlockID;
		this.height = height;
		// to thick and the leaves will start to decay
		this.thickness = leavethickness;
		if(this.treeType == 1)
		{
			System.out.println("basic tree type");
		}
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		Block bID = world.getBlock(i, j, k);
				

		for (boolean var6 = false; ((Block.isEqualTo(bID, Block.getBlockById(0)) || bID == this.leavesID) && j > 0); --j)
		{
			;
		}

		Block block = world.getBlock(i, j, k);
		
		if (block == Blocks.dirt || block == Blocks.grass)
		{
					
			++j;
			
			for(int a = 0;a<height+1;a++)
			{
				this.setBlockAndNotifyAdequately(world, i, j+a, k, this.woodID, 1);
			}
			this.setBlockAndNotifyAdequately(world, i, j+height, k, this.leavesID, 1);

			for (int y = j; y <= j + 1; ++y)
			{
				int var9 = y - j;
					
				int var10 = 2 - var9;
					
				for (int x = i - var10; x <= i + var10; ++x)
				{
					int var12 = x - i;

					for (int z = k - var10; z <= k + var10; ++z)
					{
						int var14 = z - k;

						if ((Math.abs(var12) != var10 || Math.abs(var14) != var10 || random.nextInt(2) != 0) && !world.isBlockNormalCubeDefault(x, y, z, true))
						{
							for(int v = 0; v < this.thickness; v++)
							{
								this.setBlockAndNotifyAdequately(world, x, y+height-v, z, this.leavesID, 1);
							}
						}
					}
				}
			}
		}

		return true;
	}
}