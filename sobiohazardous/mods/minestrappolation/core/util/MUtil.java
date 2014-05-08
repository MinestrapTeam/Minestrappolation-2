package sobiohazardous.mods.minestrappolation.core.util;

import java.util.Iterator;
import java.util.List;

import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

/**
 * This class is for additional block functions i think we will need in the
 * future feel free to use any of them all written by SoBiohazardous (Domenic)
 * 
 * @author SoBiohazardous
 */
public class MUtil
{
	public static boolean isMaterial(World world, int x, int y, int z, Material material)
	{
		return world.getBlock(x, y, z).getMaterial() == material;
	}
	
	public static boolean isBlock(World world, int x, int y, int z, Block block)
	{
		return world.getBlock(x, y, z) == block;
	}
	
	/**
	 * This checks and returns if water is near in a 9x3x9 square
	 * 
	 * @param World
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static boolean isWaterNearby(World world, int x, int y, int z)
	{
		for (int x1 = -4; x1 <= 4; ++x1)
		{
			for (int y1 = -1; y1 <= 1; ++y1)
			{
				for (int z1 = -4; z1 <= 4; ++z1)
				{
					if (isMaterial(world, x + x1, y + y1, z + z1, Material.water))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isWaterTouchingAnySide(World world, int x, int y, int z)
	{
		return isMaterial(world, x + 1, y, z, Material.water) // x+
				|| isMaterial(world, x - 1, y, z, Material.water) // x-
				|| isMaterial(world, x, y + 1, z, Material.water) // y+
				|| isMaterial(world, x, y - 1, z, Material.water) // y-
				|| isMaterial(world, x, y, z + 1, Material.water) // z+
				|| isMaterial(world, x, y, z - 1, Material.water); // z-
	}
	
	public static boolean isBlockTouchingAnySide(World world, int x, int y, int z, Block block)
	{
		return isBlock(world, x + 1, y, z, block) // x+
				|| isBlock(world, x - 1, y, z, block) // x-
				|| isBlock(world, x, y + 1, z, block) // y+
				|| isBlock(world, x, y - 1, z, block) // y-
				|| isBlock(world, x, y, z + 1, block) // z+
				|| isBlock(world, x, y, z - 1, block); // z-
	}
	
	public boolean isBlockWithin(World world, int x, int y, int z, Block block, int width, int height, int length)
	{
		for (int l = -width; l <= width; ++l)
		{
			for (int i1 = -height; i1 <= height; ++i1)
			{
				for (int j1 = -length; j1 <= length; ++j1)
				{
					if (isBlock(world, x, y, z, block))
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
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static boolean isBlockAbove(World world, int x, int y, int z)
	{
		return !isMaterial(world, x, y + 1, z, Material.air);
	}
	
	public static boolean isRaining(World world, int x, int y, int z)
	{
		return world.isRaining() && world.getBiomeGenForCoords(x, z).canSpawnLightningBolt();
	}
	
	/**
	 * Removes a vanilla recipe based on the result item and amount.
	 * 
	 * @param output
	 */
	public static void removeRecipe(ItemStack output)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = recipes.iterator();
		IRecipe recipe;
		
		while (iterator.hasNext())
		{
			recipe = iterator.next();
			ItemStack stack = recipe.getRecipeOutput();
			if (CSStacks.equals(output, stack))
			{
				System.out.println("CrazyFoods: Removed Recipe: " + recipe + " -> " + output);
				iterator.remove();
			}
		}
	}
	
}
