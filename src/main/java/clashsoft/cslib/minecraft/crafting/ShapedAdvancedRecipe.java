package clashsoft.cslib.minecraft.crafting;

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
	
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	@Override
	public boolean matches(InventoryCrafting inventoryCrafting, World world)
	{
		int size = (int) MathHelper.sqrt_float(inventoryCrafting.getSizeInventory());
		for (int i = 0; i <= size - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= size - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inventoryCrafting, i, j, true))
				{
					return true;
				}
				
				if (this.checkMatch(inventoryCrafting, i, j, false))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 */
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
					if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
					{
						return false;
					}
					
					if (itemstack.getItem() != itemstack1.getItem())
					{
						return false;
					}
					
					if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
