package clashsoft.cslib.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The Class CSWorld.
 * <p>
 * This class adds several utils for world editing.
 * 
 * @author Clashsoft
 */
public class CSWorld
{
	/** The Constant sideMap. */
	public static final int[][]	sideMap			= new int[][] { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
	
	/** The Constant oppositeSideMap. */
	public static final int[]	oppositeSideMap	= new int[] { 1, 0, 3, 2, 5, 4 };
	
	/**
	 * Gets the block at the given coordinates.
	 * 
	 * @see World#getBlock(int, int, int)
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @return the block
	 */
	public static Block getBlock(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z);
	}
	
	/**
	 * Gets the block metadata at the given coordinates.
	 * 
	 * @see World#getBlockMetadata(int, int, int)
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @return the block metadata
	 */
	public static int getBlockMetadata(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	/**
	 * Gets the block tile entity at the given coordinates.
	 * 
	 * @see World#getBlockTileEntity(int, int, int)
	 * @param <T>
	 *            the generic type
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @return the block tile entity
	 */
	public static <T extends TileEntity> T getBlockTileEntity(IBlockAccess world, int x, int y, int z)
	{
		return (T) world.getTileEntity(x, y, z);
	}
	
	/**
	 * Gets the block id at the given side of the given coordinates.
	 * 
	 * @see World#getBlockId(int, int, int)
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param side
	 *            the side
	 * @return the block at side
	 */
	public static Block getBlockAtSide(IBlockAccess world, int x, int y, int z, int side)
	{
		switch (side)
		{
		case 0:
			return getBlock(world, x, y - 1, z);
		case 1:
			return getBlock(world, x, y + 1, z);
		case 2:
			return getBlock(world, x, y, z - 1);
		case 3:
			return getBlock(world, x, y, z + 1);
		case 4:
			return getBlock(world, x - 1, y, z);
		case 5:
			return getBlock(world, x + 1, y, z);
		default:
			return getBlock(world, x, y, z);
		}
	}
	
	/**
	 * Gets the block metadata at the given side of the given coordinates.
	 * 
	 * @see World#getBlockMetadata(int, int, int)
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param side
	 *            the side
	 * @return the block metadata at side
	 */
	public static int getBlockMetadataAtSide(IBlockAccess world, int x, int y, int z, int side)
	{
		switch (side)
		{
		case 0:
			return getBlockMetadata(world, x, y - 1, z);
		case 1:
			return getBlockMetadata(world, x, y + 1, z);
		case 2:
			return getBlockMetadata(world, x, y, z - 1);
		case 3:
			return getBlockMetadata(world, x, y, z + 1);
		case 4:
			return getBlockMetadata(world, x - 1, y, z);
		case 5:
			return getBlockMetadata(world, x + 1, y, z);
		default:
			return getBlockMetadata(world, x, y, z);
		}
	}
	
	/**
	 * Gets the block at the given side of the given coordinates.
	 * 
	 * @see World#getBlockTileEntity(int, int, int)
	 * @param <T>
	 *            the generic type
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param side
	 *            the side
	 * @return the block tile entity at side
	 */
	public static <T extends TileEntity> T getBlockTileEntityAtSide(IBlockAccess world, int x, int y, int z, int side)
	{
		switch (side)
		{
		case 0:
			return getBlockTileEntity(world, x, y - 1, z);
		case 1:
			return getBlockTileEntity(world, x, y + 1, z);
		case 2:
			return getBlockTileEntity(world, x, y, z - 1);
		case 3:
			return getBlockTileEntity(world, x, y, z + 1);
		case 4:
			return getBlockTileEntity(world, x - 1, y, z);
		case 5:
			return getBlockTileEntity(world, x + 1, y, z);
		default:
			return getBlockTileEntity(world, x, y, z);
		}
	}
	
	/**
	 * Sets the block with the given metadata at the given coordinates.
	 * 
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param block
	 *            the block
	 * @param meta
	 *            the meta
	 */
	public static void setBlock(World world, int x, int y, int z, Block block, int meta)
	{
		world.setBlock(x, y, z, block, meta, 0x02);
	}
	
	/**
	 * Sets the block tile entity at the given coordinates.
	 * 
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param tileentity
	 *            the tileentity
	 */
	public static void setBlockTileEntity(World world, int x, int y, int z, TileEntity tileentity)
	{
		world.setTileEntity(x, y, z, tileentity);
	}
	
	/**
	 * Sets the block with the given metadata at the given side of the given
	 * coordinates.
	 * 
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param side
	 *            the side
	 * @param block
	 *            the block
	 * @param meta
	 *            the meta
	 */
	public static void setBlockAtSide(World world, int x, int y, int z, int side, Block block, int meta)
	{
		setBlock(world, x + sideMap[side][0], y + sideMap[side][1], z + sideMap[side][2], block, meta);
	}
	
	/**
	 * Sets the block tile entity at the given side of the given coordinates.
	 * 
	 * @param world
	 *            the world
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param z
	 *            the z
	 * @param side
	 *            the side
	 * @param tileentity
	 *            the tileentity
	 */
	public static void setBlockTileEntityAtSide(World world, int x, int y, int z, int side, TileEntity tileentity)
	{
		setBlockTileEntity(world, x + sideMap[side][0], y + sideMap[side][1], z + sideMap[side][2], tileentity);
	}
	
	/**
	 * Generates a Block/Line/Cube.
	 * 
	 * @param world
	 *            the world
	 * @param x1
	 *            the x1
	 * @param y1
	 *            the y1
	 * @param z1
	 *            the z1
	 * @param x2
	 *            the x2
	 * @param y2
	 *            the y2
	 * @param z2
	 *            the z2
	 * @param block
	 *            the block
	 * @param meta
	 *            the meta
	 */
	public static void setCube(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block, int meta)
	{
		for (int x = x1; x <= x2; x++)
		{
			for (int y = y1; y <= y2; y++)
			{
				for (int z = z1; z <= z2; z++)
				{
					setBlock(world, x, y, z, block, meta);
				}
			}
		}
	}
	
	/**
	 * Generates the wireframe of a cube made of the given block with the given
	 * metadata.
	 * 
	 * @param world
	 *            the world
	 * @param x1
	 *            the x1
	 * @param y1
	 *            the y1
	 * @param z1
	 *            the z1
	 * @param x2
	 *            the x2
	 * @param y2
	 *            the y2
	 * @param z2
	 *            the z2
	 * @param block
	 *            the block
	 * @param meta
	 *            the meta
	 */
	public static void setFrame(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block, int meta)
	{
		// Lower 2D-Frame
		setCube(world, x1, y1, z1, x2, y1, z1, block, meta);
		setCube(world, x1, y1, z1, x1, y1, z2, block, meta);
		setCube(world, x2, y1, z1, x2, y1, z2, block, meta);
		setCube(world, x1, y1, z2, x2, y1, z2, block, meta);
		
		// Columns
		setCube(world, x1, y1, z1, x1, y2, z1, block, meta);
		setCube(world, x2, y1, z1, x2, y2, z1, block, meta);
		setCube(world, x1, y1, z2, x1, y2, z2, block, meta);
		setCube(world, x2, y1, z2, x2, y2, z2, block, meta);
		
		// Upper 2D-Frame
		setCube(world, x1, y2, z1, x2, y2, z1, block, meta);
		setCube(world, x1, y2, z1, x1, y2, z2, block, meta);
		setCube(world, x2, y2, z1, x2, y2, z2, block, meta);
		setCube(world, x1, y2, z2, x2, y2, z2, block, meta);
	}
}
