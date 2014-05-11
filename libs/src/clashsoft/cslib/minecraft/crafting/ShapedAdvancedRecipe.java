package clashsoft.cslib.minecraft.crafting;

import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ShapedAdvancedRecipe extends ShapedRecipes
{
	public ShapedAdvancedRecipe(int width, int height, ItemStack[] stacks, ItemStack output)
	{
		super(width, height, stacks, output);
	}
	
	public static ShapedAdvancedRecipe fromRecipe(ShapedRecipes recipe)
	{
		return new ShapedAdvancedRecipe(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
	}
	
	@Override
	public boolean matches(InventoryCrafting inventory, World world)
	{
		int size = (int) MathHelper.sqrt_float(inventory.getSizeInventory());
		for (int i = 0; i <= size - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= size - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inventory, i, j, true))
				{
					return true;
				}
				
				if (this.checkMatch(inventory, i, j, false))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkMatch(InventoryCrafting inventoryCrafting, int i, int j, boolean mirror)
	{
		int size = (int) MathHelper.sqrt_float(inventoryCrafting.getSizeInventory());
		for (int k = 0; k < size; ++k)
		{
			for (int l = 0; l < size; ++l)
			{
				int i1 = k - i;
				int j1 = l - j;
				ItemStack itemstack = null;
				
				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (mirror)
					{
						itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}
				
				ItemStack itemstack1 = inventoryCrafting.getStackInRowAndColumn(k, l);
				
				if (itemstack1 != null || itemstack != null)
				{
					if (!CSStacks.equals(itemstack, itemstack1))
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
