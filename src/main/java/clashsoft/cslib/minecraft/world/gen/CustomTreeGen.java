package clashsoft.cslib.minecraft.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * The class CustomTreeGenerator
 * 
 * @author Clashsoft
 */
public class CustomTreeGen extends WorldGenTrees
{
	/** The minimum height of a generated tree. */
	public int		minTreeHeight	= 4;
	
	/** True if this tree should grow Vines. */
	public boolean	vinesGrow		= false;
	
	public Block	logBlock		= Blocks.log;
	public Block	leafBlock		= Blocks.leaves;
	public Block	vineBlock		= Blocks.vine;
	
	/** The metadata value of the wood to use in tree generation. */
	public int		logMetadata	= 0;
	
	/** The metadata value of the leaves to use in tree generation. */
	public int		leafMetadata	= 0;
	
	public CustomTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf)
	{
		this(blockUpdates, minTreeHeight, log, leaf, 0, 0);
	}
	
	public CustomTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata)
	{
		this(blockUpdates, minTreeHeight, log, leaf, woodMetadata, leavesMetadata, false);
	}
	
	public CustomTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates);
		this.minTreeHeight = minTreeHeight;
		this.logBlock = log;
		this.leafBlock = leaf;
		this.logMetadata = woodMetadata;
		this.leafMetadata = leavesMetadata;
		this.vinesGrow = vinesGrow;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int l = random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		
		if ((y >= 1) && (y + l + 1 <= 256))
		{
			for (int i1 = y; i1 <= y + 1 + l; ++i1)
			{
				byte b0 = 1;
				
				if (i1 == y)
				{
					b0 = 0;
				}
				
				if (i1 >= y + 1 + l - 2)
				{
					b0 = 2;
				}
				
				for (int j1 = x - b0; (j1 <= x + b0) && (flag); ++j1)
				{
					for (int k1 = z - b0; (k1 <= z + b0) && (flag); ++k1)
					{
						if ((i1 >= 0) && (i1 < 256))
						{
							Block block = world.getBlock(j1, i1, k1);
							
							if (this.isReplaceable(world, j1, i1, k1))
								continue;
							flag = false;
						}
						else
						{
							flag = false;
						}
					}
				}
			}
			
			if (!(flag))
			{
				return false;
			}
			
			Block block2 = world.getBlock(x, y - 1, z);
			
			boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling) Blocks.sapling);
			if ((isSoil) && (y < 256 - l - 1))
			{
				block2.onPlantGrow(world, x, y - 1, z, x, y, z);
				byte b0 = 3;
				byte b1 = 0;
				
				for (int k1 = y - b0 + l; k1 <= y + l; ++k1)
				{
					int i3 = k1 - (y + l);
					int l1 = b1 + 1 - (i3 / 2);
					
					for (int i2 = x - l1; i2 <= x + l1; ++i2)
					{
						int j2 = i2 - x;
						
						for (int k2 = z - l1; k2 <= z + l1; ++k2)
						{
							int l2 = k2 - z;
							
							if ((Math.abs(j2) == l1) && (Math.abs(l2) == l1) && (((random.nextInt(2) == 0) || (i3 == 0))))
								continue;
							Block block1 = world.getBlock(i2, k1, k2);
							
							if ((!(block1.isAir(world, i2, k1, k2))) && (!(block1.isLeaves(world, i2, k1, k2))))
								continue;
							this.setBlockAndNotifyAdequately(world, i2, k1, k2, this.leafBlock, this.leafMetadata);
						}
						
					}
					
				}
				
				for (int k1 = 0; k1 < l; ++k1)
				{
					Block block = world.getBlock(x, y + k1, z);
					
					if ((!(block.isAir(world, x, y + k1, z))) && (!(block.isLeaves(world, x, y + k1, z))))
						continue;
					this.setBlockAndNotifyAdequately(world, x, y + k1, z, this.logBlock, this.logMetadata);
					
					if ((!(this.vinesGrow)) || (k1 <= 0))
						continue;
					if ((random.nextInt(3) > 0) && (world.isAirBlock(x - 1, y + k1, z)))
					{
						this.setBlockAndNotifyAdequately(world, x - 1, y + k1, z, Blocks.vine, 8);
					}
					
					if ((random.nextInt(3) > 0) && (world.isAirBlock(x + 1, y + k1, z)))
					{
						this.setBlockAndNotifyAdequately(world, x + 1, y + k1, z, Blocks.vine, 2);
					}
					
					if ((random.nextInt(3) > 0) && (world.isAirBlock(x, y + k1, z - 1)))
					{
						this.setBlockAndNotifyAdequately(world, x, y + k1, z - 1, Blocks.vine, 1);
					}
					
					if ((random.nextInt(3) <= 0) || (!(world.isAirBlock(x, y + k1, z + 1))))
						continue;
					this.setBlockAndNotifyAdequately(world, x, y + k1, z + 1, Blocks.vine, 4);
				}
				
				if (this.vinesGrow)
				{
					for (int k1 = y - 3 + l; k1 <= y + l; ++k1)
					{
						int i3 = k1 - (y + l);
						int l1 = 2 - (i3 / 2);
						
						for (int i2 = x - l1; i2 <= x + l1; ++i2)
						{
							for (int j2 = z - l1; j2 <= z + l1; ++j2)
							{
								if (!(world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2)))
									continue;
								if ((random.nextInt(4) == 0) && (world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2)))
								{
									this.growVines(world, i2 - 1, k1, j2, 8);
								}
								
								if ((random.nextInt(4) == 0) && (world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2)))
								{
									this.growVines(world, i2 + 1, k1, j2, 2);
								}
								
								if ((random.nextInt(4) == 0) && (world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1)))
								{
									this.growVines(world, i2, k1, j2 - 1, 1);
								}
								
								if ((random.nextInt(4) != 0) || (!(world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1))))
									continue;
								this.growVines(world, i2, k1, j2 + 1, 4);
							}
							
						}
						
					}
					
					if ((random.nextInt(5) == 0) && (l > 5))
					{
						for (int k1 = 0; k1 < 2; ++k1)
						{
							for (int i3 = 0; i3 < 4; ++i3)
							{
								if (random.nextInt(4 - k1) != 0)
									continue;
								int l1 = random.nextInt(3);
								this.setBlockAndNotifyAdequately(world, x + net.minecraft.util.Direction.offsetX[net.minecraft.util.Direction.rotateOpposite[i3]], y + l - 5 + k1, z + net.minecraft.util.Direction.offsetZ[net.minecraft.util.Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
							}
						}
					}
					
				}
				
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	private void growVines(World world, int x, int y, int z, int metadata)
	{
		this.setBlockAndNotifyAdequately(world, x, y, z, this.vineBlock, metadata);
		int i1 = 4;
		while (true)
		{
			--y;
			
			if ((world.getBlock(x, y, z).isAir(world, x, y, z)) || (i1 <= 0))
			{
				return;
			}
			
			this.setBlockAndNotifyAdequately(world, x, y, z, this.vineBlock, metadata);
			--i1;
		}
	}
}
