package minestrapteam.minestrappolation.world.gen;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.world.World;

public class WorldGenRedWoodTree extends WorldGenBaseTree
{
	protected int	leafStart	= 5;
	protected int	leafSpacing	= 2;
	
	public WorldGenRedWoodTree()
	{
		super(MBlocks.redwoodLog, 0, MBlocks.redwoodLeaves, 0, 17, 23, 2);
	}
	
	@Override
	public boolean genLeafStructure(World world, Random rand, int x, int y, int z)
	{
		this.setBlock(world, x, y + this.topHeight, z, this.leaves, this.leavesMetadata);
		this.setBlock(world, x, y + this.topHeight, z + 1, this.leaves, this.leavesMetadata);
		this.setBlock(world, x + 1, y + this.topHeight, z + 1, this.leaves, this.leavesMetadata);
		this.setBlock(world, x + 1, y + this.topHeight, z, this.leaves, this.leavesMetadata);
		
		double thinkness = 6.5D;
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				this.generateLeafCircles(world, rand, thinkness, x + 1, z + 1, y + r);
				thinkness -= 0.4D;
			}
		}
		return true;
	}
	
	@Override
	public boolean genExtras(World world, Random rand, int x, int y, int z)
	{
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				int chance = rand.nextInt(2);
				if (chance == 1)
				{
					int minL = 2;
					
					int c1 = rand.nextInt(2);
					int c2 = rand.nextInt(2);
					int c3 = rand.nextInt(2);
					int c4 = rand.nextInt(2);
					
					if (c1 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							this.setBlock(world, x + l, y + r, z, this.wood, this.woodMetadata);
						}
						
					}
					
					if (c2 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							this.setBlock(world, x - l, y + r, z, this.wood, this.woodMetadata);
						}
					}
					
					if (c3 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							this.setBlock(world, x, y + r, z - l, this.wood, this.woodMetadata);
						}
						
					}
					
					if (c4 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							this.setBlock(world, x, y + r, z + l, this.wood, this.woodMetadata);
						}
					}
					
				}
			}
		}
		return true;
	}
}