package minestrapteam.minestrappolation.world;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenBaseTree extends WorldGenAbstractTree  {
	
	protected Block wood;
	protected int wMeta;
	protected Block leaves;
	protected int lMeta;
	
	
	public int maxHeight;
	public int minHeight;
	public int width;
	
	public int topHeight;
	
	public WorldGenBaseTree(Block wood, int meta, Block leaves, int meta2, int maxHeight,int minHeight,int width) {
		super(true);
		this.wood = wood;
		this.wMeta = meta;
		this.leaves = leaves;
		this.lMeta = meta2;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.width = width;
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y,int z)
	{
		if (!canSpawn(world, x, y, z))
		{
			return false;
		}
		
		Block top = world.getBlock(x, y+topHeight, z);
		if (top != Blocks.air)
		{
			return false;
		}
		this.createTrunk(world, rand, x, y, z);
		this.genLeafStructure(world, rand, x, y, z);
		this.genExtras(world, rand, x, y, z);
		return true;
	}
	
	
	public abstract boolean genLeafStructure(World world, Random rand, int x, int y,int z);
	
	public abstract boolean genExtras(World world, Random rand, int x, int y,int z);
	
	
	public boolean canSpawn(World world,int x,int y,int z)
	{
		Block ground = world.getBlock(x, y-1, z);
		if (width == 1)
		{
			return ground == Blocks.dirt && world.getBlockMetadata(x, y-1, z) == 2 || ground == Blocks.grass;
		}
		else
		{
			Block b1 = world.getBlock(x - 1, y - 1, z);
			Block b2 = world.getBlock(x, y - 1, z + 1);
			
			return b1 == Blocks.dirt && world.getBlockMetadata(x, y-1, z) == 2 && b2 == Blocks.dirt && world.getBlockMetadata(x, y-1, z) == 2 || ground == Blocks.grass;
		}
		
	}
	
	public void createTrunk(World world, Random rand,int x,int y,int z)
	{
		int genHeight = rand.nextInt(maxHeight - minHeight + 1) + minHeight;
		this.topHeight = genHeight;
		
		for (int w = 0; w < width; w++)
		{
			for (int h = 0; h < genHeight; h++)
			{
				if ( width >= 2)
				{
					world.setBlock(x, y + h, z, wood, wMeta, 2);
					world.setBlock(x, y + h, z + 1, wood, wMeta, 2);			
					world.setBlock(x - 1, y + h, z + 1, wood, wMeta, 2);
					world.setBlock(x - 1, y + h, z, wood, wMeta, 2);
				} 
				else
				{
					world.setBlock(x, y + h, z, wood, wMeta, 2);
				}
			}
		}
		
	}
	
	public void generateLeafCircles(World world, Random random, double radius, int xo, int zo, int h){
	     for (int x = (int)Math.ceil(xo - radius); x <= (int)Math.ceil(xo + radius); x++)
	     {
	    	 for (int z = (int)Math.ceil(zo - radius); z <= (int)Math.ceil(zo + radius); z++)
	    	 {
	    		 double xfr = z - zo;
	    		 double zfr = x- xo;

	    		 if (xfr * xfr + zfr * zfr <= radius * radius)
	    		 {
	    			 if (xfr * xfr + zfr * zfr <= (radius - 1) * (radius - 1) || random.nextInt(2) == 0)
	    			 {
	    				 setBlock(world,x, h, z, this.leaves, this.lMeta);
	    			 }
	    		 }
	    	  }
	     	}
	}
	
	public void setBlock(World world,int x, int y, int z, Block block,int meta){
		Block cur = world.getBlock(x, y, z);
		if (cur == Blocks.air || cur == Blocks.leaves)
		{
			world.setBlock(x, y, z, block, meta,2);
		}
	}

}
