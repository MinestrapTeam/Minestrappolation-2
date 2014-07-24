package minestrapteam.minestrappolation.world;

import java.util.ArrayList;
import java.util.Random;

import minestrapteam.mcore.lib.MCBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenRedWoodTree extends WorldGenBaseTree
{
	
	int leafStart = 5;
	int leafSpacing = 2;
	
	public WorldGenRedWoodTree() {
		super(MCBlocks.redwoodLog, 1, MCBlocks.redwoodLeaves, 1, 23, 17, 2);
		
	}

	@Override
	public boolean genLeafStructure(World world, Random rand, int x, int y,int z) 
	{
		setBlock(world , x , y + this.topHeight, z, leaves, lMeta);
		setBlock(world , x , y + this.topHeight, z + 1, leaves, lMeta);			
		setBlock(world , x - 1, y + this.topHeight, z + 1, leaves, lMeta);
		setBlock(world , x - 1, y + this.topHeight, z, leaves, lMeta);
		
		
		double thinkness = 6.5;
		for (int r = leafStart; r < this.topHeight; r++)
		{
			if ( r % leafSpacing == 0)
			{
				this.generateLeafCircles( world , rand , thinkness , x - 1 , z + 1, y + r);
				thinkness -= .4;
			}
		}
		return true;
	}

	@Override
	public boolean genExtras(World world, Random rand, int x, int y, int z) 
	{
		for (int r = leafStart; r < this.topHeight; r++)
		{
			if ( r % leafSpacing == 0)
			{
					int chance = rand.nextInt(2);
					if ( chance == 1 )
					{
						int minL = 2;
						
						int c1 = rand.nextInt(2);
						int c2 = rand.nextInt(2);
						int c3 = rand.nextInt(2);
						int c4 = rand.nextInt(2);
						
						if (c1 == 1)
						{
							for (int l = 0; l < rand.nextInt(2)+minL ; l++)
							{
								setBlock(world , x + l, y + r , z,wood, wMeta);
							}
							
						}
						
						if (c2 == 1)
						{
							for (int l = 0; l < rand.nextInt(2)+minL ; l++)
							{
								setBlock(world , x - l , y + r , z , wood, wMeta);
							}
						}
						
						if(c3 == 1)
						{
							for (int l = 0; l < rand.nextInt(2)+minL ; l++)
							{
								setBlock(world , x , y + r , z - l, wood, wMeta);
							}
							
						}
						
						if(c4 == 1)
						{
							for (int l = 0; l < rand.nextInt(2)+minL ; l++)
							{
								setBlock(world , x  , y + r , z + l, wood, wMeta);
							}
						}
						

					}
			}
		}
		return true;
	}
}