package clashsoft.cslib.minecraft.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CustomBigTreeGen extends CustomTreeGen
{
	public static final byte[]	otherCoordPairs		= new byte[] { (byte) 2, (byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 1 };
	
	public Random				rand				= new Random();
	
	public World				worldObj;
	public int[]				basePos				= new int[] { 0, 0, 0 };
	public int					heightLimit;
	public int					height;
	public double				heightAttenuation	= 0.618D;
	public double				branchDensity		= 1.0D;
	public double				branchSlope			= 0.381D;
	public double				scaleWidth			= 1.0D;
	public double				leafDensity			= 1.0D;
	public int					trunkSize			= 1;
	public int					heightLimitLimit	= 12;
	public int					leafDistanceLimit	= 4;
	
	public int[][]				leafNodes;
	
	public CustomBigTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates, minTreeHeight, log, leaf, woodMetadata, leavesMetadata, vinesGrow);
	}
	
	public CustomBigTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, log, leaf, woodMetadata, leavesMetadata);
	}
	
	public CustomBigTreeGen(boolean blockUpdates, int minTreeHeight, Block log, Block leaf)
	{
		super(blockUpdates, minTreeHeight, log, leaf);
	}
	
	/**
	 * Generates a list of leaf nodes for the tree, to be populated by
	 * generateLeaves.
	 */
	public void generateLeafNodeList()
	{
		this.height = (int) (this.heightLimit * this.heightAttenuation);
		
		if (this.height >= this.heightLimit)
		{
			this.height = this.heightLimit - 1;
		}
		
		int i = (int) (1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));
		
		if (i < 1)
		{
			i = 1;
		}
		
		int[][] aint = new int[i * this.heightLimit][4];
		int j = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
		int k = 1;
		int l = this.basePos[1] + this.height;
		int i1 = j - this.basePos[1];
		aint[0][0] = this.basePos[0];
		aint[0][1] = j;
		aint[0][2] = this.basePos[2];
		aint[0][3] = l;
		--j;
		
		while (i1 >= 0)
		{
			int j1 = 0;
			float f = this.layerSize(i1);
			
			if (f < 0.0F)
			{
				--j;
				--i1;
			}
			else
			{
				for (double d0 = 0.5D; j1 < i; ++j1)
				{
					double d1 = this.scaleWidth * f * (this.rand.nextFloat() + 0.328D);
					double d2 = this.rand.nextFloat() * 2.0D * Math.PI;
					int k1 = MathHelper.floor_double(d1 * Math.sin(d2) + this.basePos[0] + d0);
					int l1 = MathHelper.floor_double(d1 * Math.cos(d2) + this.basePos[2] + d0);
					int[] aint1 = new int[] { k1, j, l1 };
					int[] aint2 = new int[] { k1, j + this.leafDistanceLimit, l1 };
					
					if (this.checkBlockLine(aint1, aint2) == -1)
					{
						int[] aint3 = new int[] { this.basePos[0], this.basePos[1], this.basePos[2] };
						double d3 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - aint1[0]), 2.0D) + Math.pow(Math.abs(this.basePos[2] - aint1[2]), 2.0D));
						double d4 = d3 * this.branchSlope;
						
						if (aint1[1] - d4 > l)
						{
							aint3[1] = l;
						}
						else
						{
							aint3[1] = (int) (aint1[1] - d4);
						}
						
						if (this.checkBlockLine(aint3, aint1) == -1)
						{
							aint[k][0] = k1;
							aint[k][1] = j;
							aint[k][2] = l1;
							aint[k][3] = aint3[1];
							++k;
						}
					}
				}
				
				--j;
				--i1;
			}
		}
		
		this.leafNodes = new int[k][4];
		System.arraycopy(aint, 0, this.leafNodes, 0, k);
	}
	
	public void genTreeLayer(int x, int y, int z, float f, byte b, Block block, int metadata)
	{
		int i1 = (int) (f + 0.618D);
		byte b1 = otherCoordPairs[b];
		byte b2 = otherCoordPairs[b + 3];
		int[] coords = new int[] { x, y, z };
		int[] newCoords = new int[] { 0, 0, 0 };
		int j1 = -i1;
		int k1 = -i1;
		
		for (newCoords[b] = coords[b]; j1 <= i1; ++j1)
		{
			newCoords[b1] = coords[b1] + j1;
			k1 = -i1;
			
			while (k1 <= i1)
			{
				double d0 = Math.pow(Math.abs(j1) + 0.5D, 2.0D) + Math.pow(Math.abs(k1) + 0.5D, 2.0D);
				
				if (d0 > f * f)
				{
					++k1;
				}
				else
				{
					newCoords[b2] = coords[b2] + k1;
					Block block1 = this.worldObj.getBlock(newCoords[0], newCoords[1], newCoords[2]);
					
					if (block != block1)
					{
						++k1;
					}
					else
					{
						this.setBlockAndNotifyAdequately(this.worldObj, newCoords[0], newCoords[1], newCoords[2], block, metadata);
						++k1;
					}
				}
			}
		}
	}
	
	/**
	 * Gets the rough size of a layer of the tree.
	 */
	public float layerSize(int layer)
	{
		if (layer < this.heightLimit * 0.3D)
		{
			return -1.618F;
		}
		else
		{
			float f = this.heightLimit / 2.0F;
			float f1 = this.heightLimit / 2.0F - layer;
			float f2;
			
			if (f1 == 0.0F)
			{
				f2 = f;
			}
			else if (Math.abs(f1) >= f)
			{
				f2 = 0.0F;
			}
			else
			{
				f2 = (float) Math.sqrt(Math.pow(Math.abs(f), 2.0D) - Math.pow(Math.abs(f1), 2.0D));
			}
			
			f2 *= 0.5F;
			return f2;
		}
	}
	
	public float leafSize(int layer)
	{
		return layer >= 0 && layer < this.leafDistanceLimit ? layer != 0 && layer != this.leafDistanceLimit - 1 ? 3.0F : 2.0F : -1.0F;
	}
	
	/**
	 * Generates the leaves surrounding an individual entry in the leafNodes
	 * list.
	 */
	public void generateLeafNode(int x, int y, int z)
	{
		int l = y;
		
		for (int y1 = y + this.leafDistanceLimit; l < y1; ++l)
		{
			float f = this.leafSize(l - y);
			this.genTreeLayer(x, l, z, f, (byte) 1, this.leafBlock, 1);
		}
	}
	
	/**
	 * Places a line of the specified block ID into the world from the first
	 * coordinate triplet to the second.
	 */
	public void placeBlockLine(int[] src, int[] dest, Block block, int metadata)
	{
		int[] coords = new int[] { 0, 0, 0 };
		int b0 = 0;
		int b1;
		
		for (b1 = 0; b0 < 3; ++b0)
		{
			coords[b0] = dest[b0] - src[b0];
			
			if (Math.abs(coords[b0]) > Math.abs(coords[b1]))
			{
				b1 = b0;
			}
		}
		
		if (coords[b1] != 0)
		{
			byte b2 = otherCoordPairs[b1];
			byte b3 = otherCoordPairs[b1 + 3];
			byte b4;
			
			if (coords[b1] > 0)
			{
				b4 = 1;
			}
			else
			{
				b4 = -1;
			}
			
			double d0 = (double) coords[b2] / (double) coords[b1];
			double d1 = (double) coords[b3] / (double) coords[b1];
			int[] aint3 = new int[] { 0, 0, 0 };
			int j = 0;
			
			for (int k = coords[b1] + b4; j != k; j += b4)
			{
				aint3[b1] = MathHelper.floor_double(src[b1] + j + 0.5D);
				aint3[b2] = MathHelper.floor_double(src[b2] + j * d0 + 0.5D);
				aint3[b3] = MathHelper.floor_double(src[b3] + j * d1 + 0.5D);
				int b5 = metadata;
				int l = Math.abs(aint3[0] - src[0]);
				int i1 = Math.abs(aint3[2] - src[2]);
				int j1 = Math.max(l, i1);
				
				if (j1 > 0)
				{
					if (l == j1)
					{
						b5 |= 4;
					}
					else if (i1 == j1)
					{
						b5 |= 8;
					}
				}
				
				this.setBlockAndNotifyAdequately(this.worldObj, aint3[0], aint3[1], aint3[2], block, b5);
			}
		}
	}
	
	/**
	 * Generates the leaf portion of the tree as specified by the leafNodes
	 * list.
	 */
	public void generateLeaves()
	{
		int i = 0;
		
		for (int j = this.leafNodes.length; i < j; ++i)
		{
			int k = this.leafNodes[i][0];
			int l = this.leafNodes[i][1];
			int i1 = this.leafNodes[i][2];
			this.generateLeafNode(k, l, i1);
		}
	}
	
	/**
	 * Indicates whether or not a leaf node requires additional wood to be added
	 * to preserve integrity.
	 */
	public boolean leafNodeNeedsBase(int layer)
	{
		return layer >= this.heightLimit * 0.2D;
	}
	
	/**
	 * Places the trunk for the big tree that is being generated. Able to
	 * generate double-sized trunks by changing a field that is always 1 to 2.
	 */
	public void generateTrunk()
	{
		int i = this.basePos[0];
		int j = this.basePos[1];
		int k = this.basePos[1] + this.height;
		int l = this.basePos[2];
		int[] src = new int[] { i, j, l };
		int[] dest = new int[] { i, k, l };
		this.placeBlockLine(src, dest, this.leafBlock, this.leafMetadata);
		
		if (this.trunkSize == 2)
		{
			++src[0];
			++dest[0];
			this.placeBlockLine(src, dest, this.leafBlock, this.leafMetadata);
			++src[2];
			++dest[2];
			this.placeBlockLine(src, dest, this.leafBlock, this.leafMetadata);
			src[0] += -1;
			dest[0] += -1;
			this.placeBlockLine(src, dest, this.leafBlock, this.leafMetadata);
		}
	}
	
	/**
	 * Generates additional wood blocks to fill out the bases of different leaf
	 * nodes that would otherwise degrade.
	 */
	public void generateLeafNodeBases()
	{
		int i = 0;
		int j = this.leafNodes.length;
		
		for (int[] aint = new int[] { this.basePos[0], this.basePos[1], this.basePos[2] }; i < j; ++i)
		{
			int[] aint1 = this.leafNodes[i];
			int[] aint2 = new int[] { aint1[0], aint1[1], aint1[2] };
			aint[1] = aint1[3];
			int k = aint[1] - this.basePos[1];
			
			if (this.leafNodeNeedsBase(k))
			{
				this.placeBlockLine(aint, aint2, this.logBlock, this.logMetadata);
			}
		}
	}
	
	/**
	 * Checks a line of blocks in the world from the first coordinate to triplet
	 * to the second, returning the distance (in blocks) before a non-air,
	 * non-leaf block is encountered and/or the end is encountered.
	 */
	public int checkBlockLine(int[] sourceCoords, int[] destCoords)
	{
		int[] aint2 = new int[3];
		byte b0 = 0;
		byte b1;
		
		for (b1 = 0; b0 < 3; ++b0)
		{
			aint2[b0] = destCoords[b0] - sourceCoords[b0];
			
			if (Math.abs(aint2[b0]) > Math.abs(aint2[b1]))
			{
				b1 = b0;
			}
		}
		
		if (aint2[b1] == 0)
		{
			return -1;
		}
		else
		{
			byte b2 = otherCoordPairs[b1];
			byte b3 = otherCoordPairs[b1 + 3];
			byte b4;
			
			if (aint2[b1] > 0)
			{
				b4 = 1;
			}
			else
			{
				b4 = -1;
			}
			
			double d0 = (double) aint2[b2] / (double) aint2[b1];
			double d1 = (double) aint2[b3] / (double) aint2[b1];
			int[] aint3 = new int[] { 0, 0, 0 };
			int i = 0;
			int j;
			
			for (j = aint2[b1] + b4; i != j; i += b4)
			{
				aint3[b1] = sourceCoords[b1] + i;
				aint3[b2] = MathHelper.floor_double(sourceCoords[b2] + i * d0);
				aint3[b3] = MathHelper.floor_double(sourceCoords[b3] + i * d1);
				Block block1 = this.worldObj.getBlock(aint3[0], aint3[1], aint3[2]);
				
				if (block1 != this.leafBlock)
				{
					break;
				}
			}
			
			return i == j ? -1 : Math.abs(i);
		}
	}
	
	/**
	 * Returns a boolean indicating whether or not the current location for the
	 * tree, spanning basePos to to the height limit, is valid.
	 */
	public boolean validTreeLocation()
	{
		int[] aint = new int[] { this.basePos[0], this.basePos[1], this.basePos[2] };
		int[] aint1 = new int[] { this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2] };
		Block soil = this.worldObj.getBlock(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
		boolean isValidSoil = soil != null && soil.canSustainPlant(this.worldObj, this.basePos[0], this.basePos[1] - 1, this.basePos[2], ForgeDirection.UP, (BlockSapling) Blocks.sapling);
		if (!isValidSoil)
		{
			return false;
		}
		else
		{
			int j = this.checkBlockLine(aint, aint1);
			
			if (j == -1)
			{
				return true;
			}
			else if (j < 6)
			{
				return false;
			}
			else
			{
				this.heightLimit = j;
				return true;
			}
		}
	}
	
	@Override
	public void setScale(double scaleHeight, double scaleWidth, double leafDensity)
	{
		this.heightLimitLimit = (int) (scaleHeight * 12.0D);
		
		if (scaleHeight > 0.5D)
		{
			this.leafDistanceLimit = 5;
		}
		
		this.scaleWidth = scaleWidth;
		this.leafDensity = leafDensity;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		this.worldObj = world;
		long l = random.nextLong();
		this.rand.setSeed(l);
		this.basePos[0] = x;
		this.basePos[1] = y;
		this.basePos[2] = z;
		
		if (this.heightLimit == 0)
		{
			this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
		}
		
		if (!this.validTreeLocation())
		{
			return false;
		}
		else
		{
			this.generateLeafNodeList();
			this.generateLeaves();
			this.generateTrunk();
			this.generateLeafNodeBases();
			return true;
		}
	}
}
