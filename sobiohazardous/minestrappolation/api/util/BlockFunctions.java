package sobiohazardous.minestrappolation.api.util;

import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/**
 *This class is for additional block functions i think we will need in the future
 *feel free to use any of them
 *all written by SoBiohazardous (Domenic)
 * @author SoBiohazardous
 * 
*/
public class BlockFunctions 
{
	/**
	 * This checks and returns if water is near in a 4x1,4 square
	 * @param World
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 4; l <= par2 + 4; ++l)//x
        {
            for (int i1 = par3; i1 <= par3 + 1; ++i1)//y
            {
                for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)//z
                {
                    if (par1World.getBlockMaterial(l, i1, j1) == Material.water)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
	
	/**
	 * This checks and returns if the current block is touching the right the block ID specified
	 * @param The world
	 * @param Block x
	 * @param Block y
	 * @param Block z
	 * @param BlockIdtouching - What block to check if touching?
	 * @return
	 */
	public static boolean isBlockTouchingRight(World par1World, int x, int y, int z, int BlockIdtouching)
	{
		for (int i = x - 1; i <= x + 1; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 0; ++i1)//y
            {
                for (int j1 = 0 - 1; j1 <= z + 0; ++j1)//z
                {
                    if (par1World.getBlockId(i, i1, j1) == BlockIdtouching)
                    {
                        return true;
                    }
                }
            }
		}
		
		return false;
	}
	
	/**
	 * This checks and returns if the current block is touching the left the block ID specified
	 * @param The world
	 * @param Block x
	 * @param Block y
	 * @param Block z
	 * @param BlockIdtouching - What block to check if touching?
	 * @return
	 */
	public static boolean isBlockTouchingLeft(World par1World, int x, int y, int z, int BlockIdtouching)
	{
		for (int i = x - 0; i <= x + 0; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 0; ++i1)//y
            {
                for (int j1 = z - 1; j1 <= z + 1; ++j1)//z
                {
                    if (par1World.getBlockId(i, i1, j1) == BlockIdtouching)
                    {
                        return true;
                    }
                }
            }
		}
		
		return false;
	}
	
	/**
	 * This checks and returns if the current block is touching the left the block ID specified
	 * @param The world
	 * @param Block x
	 * @param Block y
	 * @param Block z
	 * @param BlockIdtouching - What block to check if touching?
	 * @return
	 */
	public static boolean isWaterTouchingAllSides(World par1World, int x, int y, int z)
	{
		for (int i = x - 1; i <= x + 1; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 0; ++i1)//y
            {
                for (int j1 = z - 1; j1 <= z + 1; ++j1)//z
                {
                	 if (par1World.getBlockMaterial(i, i1, j1) == Material.water)
                     {
                         return true;
                     }
                }
            }
		}
		
		return false;
	}
	
	/**
	 * Checks if specified block material is within 4x1x4
	 * @param par1World
	 * @param x
	 * @param y
	 * @param z
	 * @param materialToCheck - What block material is within?
	 * @return
	 */
	public boolean isBlockMaterialNearby(World par1World, int x, int y, int z, Material materialToCheck)
    {
        for (int l = x - 4; l <= x + 4; ++l)//x
        {
            for (int i1 = y; i1 <= y + 1; ++i1)//y
            {
                for (int j1 = z - 4; j1 <= z + 4; ++j1)//z
                {
                    if (par1World.getBlockMaterial(l, i1, j1) == materialToCheck)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
	
	/**
	 * Checks specified block is within specified x, y, and z.
	 * @param par1World
	 * @param Block x
	 * @param Block y
	 * @param Block z
	 * @param blockIdtoCheck - What block to check for?
	 * @param xWithin - Check within what x?
	 * @param yWithin - check within what y?
	 * @param zWhithin - check within what z?
	 * @return
	 */
	public boolean isBlockWithin(World par1World, int x, int y, int z, int blockIdtoCheck, int xWithin, int yWithin, int zWhithin)
    {
        for (int l = x - xWithin; l <= x + xWithin; ++l)//x
        {
            for (int i1 = y; i1 <= y + yWithin; ++i1)//y
            {
                for (int j1 = z - zWhithin; j1 <= z + zWhithin; ++j1)//z
                {
                    if (par1World.getBlockId(x, y, z) == blockIdtoCheck)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
	
	/**
	 * Returns if a block is touching the top or not, doesn't know which block.
	 * @param par1World
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static boolean isBlockAbove(World par1World, int x, int y, int z)
	{
		for (int i = x - 0; i <= x + 0; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 1; ++i1)//y
            {
                for (int j1 = 0 - 0; j1 <= z + 0; ++j1)//z
                {
                    /*
                	if (par1World.getBlockId(i, i1, j1) == BlockIdtouching)
                    {
                        return true;
                    }
                    */
                    if(par1World.blockExists(i,  i1, j1))
                    {
                    	return true;
                    }
                }
            }
		}
		
		return false;
	}
	
}
