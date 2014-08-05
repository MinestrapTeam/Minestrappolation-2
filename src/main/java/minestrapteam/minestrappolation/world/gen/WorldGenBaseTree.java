package minestrapteam.minestrappolation.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenBaseTree extends WorldGenAbstractTree
{
	protected Block	wood;
	protected int	woodMetadata;
	protected Block	leaves;
	protected int	leavesMetadata;
	
	public int		minHeight;
	public int		maxHeight;
	public int		width;
	
	public int		topHeight;
	
	public WorldGenBaseTree(Block wood, int woodMetadata, Block leaves, int leavesMetadata, int minHeight, int maxHeight, int width)
	{
		super(true);
		this.wood = wood;
		this.woodMetadata = woodMetadata;
		this.leaves = leaves;
		this.leavesMetadata = leavesMetadata;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.width = width;
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (!this.canSpawn(world, x, y, z))
		{
			return false;
		}
		
		// Calculates the random height of the tree
		this.topHeight = rand.nextInt(this.maxHeight - this.minHeight + 1) + this.minHeight;
		
		if (!world.isAirBlock(x, y + this.topHeight, z))
		{
			return false;
		}
		
		this.createTrunk(world, rand, x, y, z);
		this.genLeafStructure(world, rand, x, y, z);
		this.genExtras(world, rand, x, y, z);
		return true;
	}
	
	public abstract boolean genLeafStructure(World world, Random rand, int x, int y, int z);
	
	public abstract boolean genExtras(World world, Random rand, int x, int y, int z);
	
	public boolean canSpawn(World world, int x, int y, int z)
	{
		if (this.width == 1)
		{
			Block ground = world.getBlock(x, y - 1, z);
			return ground == Blocks.dirt && world.getBlockMetadata(x, y - 1, z) == 2 || ground == Blocks.grass;
		}
		else
		{
			for (int i = 0; i < this.width; i++)
			{
				for (int j = 0; j < this.width; j++)
				{
					Block block = world.getBlock(x, y - 1, z);
					if (block != Blocks.dirt && block != Blocks.grass)
					{
						return false;
					}
				}
			}
			
			return true;
		}
	}
	
	public void createTrunk(World world, Random rand, int x, int y, int z)
	{
		for (int h = 0; h < this.topHeight; h++)
		{
			if (this.width == 1)
			{
				world.setBlock(x, y + h, z, this.wood, this.woodMetadata, 2);
			}
			else if (this.width == 2)
			{
				world.setBlock(x, y + h, z, this.wood, this.woodMetadata, 2);
				world.setBlock(x, y + h, z + 1, this.wood, this.woodMetadata, 2);
				world.setBlock(x + 1, y + h, z + 1, this.wood, this.woodMetadata, 2);
				world.setBlock(x + 1, y + h, z, this.wood, this.woodMetadata, 2);
			}
			else
			{
				for (int i = 0; i < this.width; i++)
				{
					for (int j = 0; j < this.width; j++)
					{
						world.setBlock(x + i, y + h, z + j, this.wood, this.woodMetadata, 2);
					}
				}
			}
		}
	}
	
	public void generateLeafCircles(World world, Random random, double radius, int xo, int zo, int h)
	{
		double radius1 = radius * radius;
		double radius2 = (radius - 1) * (radius - 1);
		int x1 = (int) Math.ceil(xo - radius);
		int z1 = (int) Math.ceil(zo - radius);
		int x2 = (int) Math.ceil(xo + radius);
		int z2 = (int) Math.ceil(zo + radius);
		
		for (int x = x1; x <= x2; x++)
		{
			for (int z = z1; z <= z2; z++)
			{
				double xfr = z - zo;
				double zfr = x - xo;
				double d = xfr * xfr + zfr * zfr;
				
				if (d <= radius1)
				{
					if (d <= radius2 || random.nextInt(2) == 0)
					{
						this.setBlock(world, x, h, z, this.leaves, this.leavesMetadata);
					}
				}
			}
		}
	}
	
	protected void setBlock(World world, int x, int y, int z, Block block, int meta)
	{
		Block cur = world.getBlock(x, y, z);
		if (cur == Blocks.air || cur == this.leaves)
		{
			world.setBlock(x, y, z, block, meta, 2);
		}
	}
}
