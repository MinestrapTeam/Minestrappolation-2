package clashsoft.cslib.minecraft.world.gen;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

/**
 * The class CustomTreeGenerator
 * 
 * @author Clashsoft
 */
public class CustomTreeGenerator extends WorldGenTrees
{
	/** The minimum height of a generated tree. */
	public int		minTreeHeight	= 4;
	
	/** True if this tree should grow Vines. */
	public boolean	vinesGrow		= false;
	
	public int		woodId			= Block.wood.blockID;
	public int		leavesId		= Block.leaves.blockID;
	public int		vinesId			= Block.vine.blockID;
	
	/** The metadata value of the wood to use in tree generation. */
	public int		metaWood		= 0;
	
	/** The metadata value of the leaves to use in tree generation. */
	public int		metaLeaves		= 0;
	
	public CustomTreeGenerator(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID)
	{
		this(blockUpdates, minTreeHeight, woodID, leavesID, 0, 0);
	}
	
	public CustomTreeGenerator(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata)
	{
		this(blockUpdates, minTreeHeight, woodID, leavesID, woodMetadata, leavesMetadata, false);
	}
	
	public CustomTreeGenerator(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates);
		this.minTreeHeight = minTreeHeight;
		this.woodId = woodID;
		this.leavesId = leavesID;
		this.metaWood = woodMetadata;
		this.metaLeaves = leavesMetadata;
		this.vinesGrow = vinesGrow;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int treeHeight = random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		
		if (y > 0 && y + treeHeight < 256)
		{
			int var8;
			byte var9;
			int var11;
			int var12;
			
			for (var8 = y; var8 <= y + 1 + treeHeight; ++var8)
			{
				var9 = 1;
				
				if (var8 == y)
				{
					var9 = 0;
				}
				
				if (var8 >= y + 1 + treeHeight - 2)
				{
					var9 = 2;
				}
				
				for (int var10 = x - var9; var10 <= x + var9 && flag; ++var10)
				{
					for (var11 = z - var9; var11 <= z + var9 && flag; ++var11)
					{
						if (var8 >= 0 && var8 < 256)
						{
							var12 = world.getBlockId(var10, var8, var11);
							int var12_1 = world.getBlockMetadata(var10, var8, var11);
							
							Block block = Block.blocksList[var12];
							
							if (var12 != 0 && !block.isLeaves(world, var10, var8, var11) && var12 != Block.grass.blockID && var12 != Block.dirt.blockID)
							{
								flag = false;
							}
						}
						else
						{
							flag = false;
						}
					}
				}
			}
			
			if (!flag)
			{
				return false;
			}
			else
			{
				var8 = world.getBlockId(x, y - 1, z);
				int var8_1 = world.getBlockMetadata(x, y - 1, z);
				
				if (y < 256 - treeHeight - 1)
				{
					var9 = 3;
					byte var18 = 0;
					int var13;
					int var14;
					int var15;
					
					for (var11 = y - var9 + treeHeight; var11 <= y + treeHeight; ++var11)
					{
						var12 = var11 - (y + treeHeight);
						var13 = var18 + 1 - var12 / 2;
						
						for (var14 = x - var13; var14 <= x + var13; ++var14)
						{
							var15 = var14 - x;
							
							for (int var16 = z - var13; var16 <= z + var13; ++var16)
							{
								int var17 = var16 - z;
								
								Block block = Block.blocksList[world.getBlockId(var14, var11, var16)];
								
								if ((Math.abs(var15) != var13 || Math.abs(var17) != var13 || random.nextInt(2) != 0 && var12 != 0) && (block == null || block.canBeReplacedByLeaves(world, var14, var11, var16)))
								{
									this.setBlockAndMetadata(world, var14, var11, var16, this.leavesId, this.metaLeaves);
								}
							}
						}
					}
					
					for (var11 = 0; var11 < treeHeight; ++var11)
					{
						var12 = world.getBlockId(x, y + var11, z);
						
						Block block = Block.blocksList[var12];
						
						if (var12 == 0 || block == null || block.isLeaves(world, x, y + var11, z))
						{
							this.setBlockAndMetadata(world, x, y + var11, z, this.woodId, this.metaWood);
							
							if (this.vinesGrow && var11 > 0)
							{
								if (random.nextInt(3) > 0 && world.isAirBlock(x - 1, y + var11, z))
								{
									this.setBlockAndMetadata(world, x - 1, y + var11, z, Block.vine.blockID, 8);
								}
								
								if (random.nextInt(3) > 0 && world.isAirBlock(x + 1, y + var11, z))
								{
									this.setBlockAndMetadata(world, x + 1, y + var11, z, Block.vine.blockID, 2);
								}
								
								if (random.nextInt(3) > 0 && world.isAirBlock(x, y + var11, z - 1))
								{
									this.setBlockAndMetadata(world, x, y + var11, z - 1, Block.vine.blockID, 1);
								}
								
								if (random.nextInt(3) > 0 && world.isAirBlock(x, y + var11, z + 1))
								{
									this.setBlockAndMetadata(world, x, y + var11, z + 1, Block.vine.blockID, 4);
								}
							}
						}
					}
					
					if (this.vinesGrow)
					{
						for (var11 = y - 3 + treeHeight; var11 <= y + treeHeight; ++var11)
						{
							var12 = var11 - (y + treeHeight);
							var13 = 2 - var12 / 2;
							
							for (var14 = x - var13; var14 <= x + var13; ++var14)
							{
								for (var15 = z - var13; var15 <= z + var13; ++var15)
								{
									Block block = Block.blocksList[world.getBlockId(var14, var11, var15)];
									if (block != null && block.isLeaves(world, var14, var11, var15))
									{
										if (random.nextInt(4) == 0 && world.getBlockId(var14 - 1, var11, var15) == 0)
										{
											this.growVines(world, var14 - 1, var11, var15, 8);
										}
										
										if (random.nextInt(4) == 0 && world.getBlockId(var14 + 1, var11, var15) == 0)
										{
											this.growVines(world, var14 + 1, var11, var15, 2);
										}
										
										if (random.nextInt(4) == 0 && world.getBlockId(var14, var11, var15 - 1) == 0)
										{
											this.growVines(world, var14, var11, var15 - 1, 1);
										}
										
										if (random.nextInt(4) == 0 && world.getBlockId(var14, var11, var15 + 1) == 0)
										{
											this.growVines(world, var14, var11, var15 + 1, 4);
										}
									}
								}
							}
						}
						
						if (random.nextInt(5) == 0 && treeHeight > 5)
						{
							for (var11 = 0; var11 < 2; ++var11)
							{
								for (var12 = 0; var12 < 4; ++var12)
								{
									if (random.nextInt(4 - var11) == 0)
									{
										var13 = random.nextInt(3);
										this.setBlockAndMetadata(world, x + Direction.offsetX[Direction.directionToFacing[var12]], y + treeHeight - 5 + var11, z + Direction.offsetZ[Direction.directionToFacing[var12]], Block.cocoaPlant.blockID, var13 << 2 | var12);
									}
								}
							}
						}
					}
					
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Grows vines downward from the given block for a given length. Args:
	 * world, x, y, z, vine metadata
	 */
	private void growVines(World world, int x, int y, int z, int vineMetadata)
	{
		this.setBlockAndMetadata(world, x, y, z, vinesId, vineMetadata);
		int var6 = 4;
		
		while (world.getBlockId(x, y, z) != 0 || var6 <= 0)
		{
			--y;
			--var6;
			this.setBlockAndMetadata(world, x, y, z, vinesId, vineMetadata);
		}
	}
}
