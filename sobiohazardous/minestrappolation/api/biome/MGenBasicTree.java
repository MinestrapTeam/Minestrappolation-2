package sobiohazardous.minestrappolation.api.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MGenBasicTree extends WorldGenerator
{
	int leavesID;
	int woodID;
	int height;
	int thickness;
	int treeType = 1;


public MGenBasicTree(int leavesBlockID,int woodBlockID,int height,int leavethickness)
{
	this.leavesID = leavesBlockID;
	this.woodID = woodBlockID;
	this.height = height;
	this.thickness = leavethickness;
	if(this.treeType == 1){
		System.out.println("basic tree type");
	}
}

		@Override
			public boolean generate(World world, Random random, int i, int j, int k)
			{
				int bID;
		

				for (boolean var6 = false; ((bID = world.getBlockId(i, j, k)) == 0 || bID == this.leavesID) && j > 0; --j)
				{
					;
				}

				int blockID = world.getBlockId(i, j, k);

				if (blockID == Block.dirt.blockID || blockID == Block.grass.blockID)
				{
					
					++j;
			
					for(int a = 0;a<height+1;a++){
						this.setBlockAndMetadata(world, i, j+a, k, this.woodID, 1);
					}
					this.setBlockAndMetadata(world, i, j+height, k, this.leavesID, 1);

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

		if ((Math.abs(var12) != var10 || Math.abs(var14) != var10 || random.nextInt(2) != 0) && !Block.opaqueCubeLookup[world.getBlockId(x, y, z)])
		{
			System.out.println("leavesX - "+x+", "+"leavesY - "+y+", "+"leavesZ - "+z);
			for(int v = 0; v < this.thickness; v++){
				this.setBlockAndMetadata(world, x, y+height-v, z, this.leavesID, 1);
			}
		}
						}
					}
					}
				}

		return true;
	}
}