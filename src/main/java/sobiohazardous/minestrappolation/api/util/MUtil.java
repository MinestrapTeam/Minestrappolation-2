package sobiohazardous.minestrappolation.api.util;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
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
public class MUtil 
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
                    if (par1World.getBlock(l, i1, j1) == Block.getBlockFromName("waterStill"))
                    {
                        return true;
                    }
                    if (par1World.getBlock(l, i1, j1) == Block.getBlockFromName("waterMoving"))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
	
	public static boolean isWaterTouchingAnySide(World par1World, int par2, int par3, int par4)
	{
		
		for (int l = par2 - 1; l <= par2 + 1; ++l)//x
        {
            for (int i1 = par3; i1 <= par3 + 1; ++i1)//y
            {
                for (int j1 = par4 - 1; j1 <= par4 + 1; ++j1)//z
                {
                    if (par1World.getBlock(l, i1, j1) == Block.getBlockFromName("waterStill"))
                    {
                        return true;
                    }
                    if (par1World.getBlock(l, i1, j1) == Block.getBlockFromName("waterMoving"))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
		
	}
	
	public static boolean isBlockTouchingAnySide(World par1World, int par2, int par3, int par4, Block block)
	{	
		for (int l = par2 - 1; l <= par2 + 1; ++l)//x
	    {
			for (int i1 = par3; i1 <= par3 + 1; ++i1)//y
			{
				for (int j1 = par4 - 1; j1 <= par4 + 1; ++j1)//z
				{	
					if (par1World.getBlock(l, i1, j1) == block)
					{
						return true;
					}
					if (par1World.getBlock(l, i1, j1) == block)
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
	public static boolean isBlockTouchingRight(World par1World, int x, int y, int z, Block BlockIdtouching)
	{
		for (int i = x - 1; i <= x + 1; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 0; ++i1)//y
            {
                for (int j1 = 0 - 1; j1 <= z + 0; ++j1)//z
                {
                    if (par1World.getBlock(i, i1, j1) == BlockIdtouching)
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
	public static boolean isBlockTouchingLeft(World par1World, int x, int y, int z, Block BlockIdtouching)
	{
		for (int i = x - 0; i <= x + 0; ++ i)//x
		{
			for (int i1 = y; i1 <= y + 0; ++i1)//y
            {
                for (int j1 = z - 1; j1 <= z + 1; ++j1)//z
                {
                    if (par1World.getBlock(i, i1, j1) == BlockIdtouching)
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
	public boolean isBlockWithin(World par1World, int x, int y, int z, Block blockIdtoCheck, int xWithin, int yWithin, int zWhithin)
    {
        for (int l = x - xWithin; l <= x + xWithin; ++l)//x
        {
            for (int i1 = y; i1 <= y + yWithin; ++i1)//y
            {
                for (int j1 = z - zWhithin; j1 <= z + zWhithin; ++j1)//z
                {
                    if (par1World.getBlock(x, y, z) == blockIdtoCheck)
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
	
	public static boolean isRaining(World par1World, int x, int y, int z)
	{
		if(par1World.isRaining()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Removes a vanilla recipe based on the result item and amount.
	 * @param resultItem
	 */
	public static void removeRecipe(ItemStack resultItem)
	{
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		for (int scan = 0; scan < recipes.size(); scan++)
		{
			IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			recipeResult = tmpRecipe.getRecipeOutput();
			if (recipeResult != null) {
				if (recipeResult == resultItem && recipeResult.getItemDamage() == resultItem.getItemDamage())
				{
					System.out.println("CrazyFoods: Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
					recipes.remove(scan);
					scan--; //list is shifted after remove! Adjust index, so next time we will check this value again.
				}
			}
		}
	}
	
}
