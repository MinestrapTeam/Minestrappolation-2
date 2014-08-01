package minestrapteam.minestrappolation.nei.handler;

import java.awt.Rectangle;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.stack.CSStacks;
import codechicken.nei.recipe.ShapedRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiSawmill;
import minestrapteam.minestrappolation.crafting.sawmill.ISawingRecipe;
import minestrapteam.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.minestrappolation.crafting.sawmill.ShapedSawingRecipe;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ShapedSawingHandler extends ShapedRecipeHandler
{
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.sawmill.shaped");
	}
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), "sawmill"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiSawmill.class;
	}
	
	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
	{
		return false;
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if ("sawmill".equals(outputId))
		{
			for (ISawingRecipe irecipe : SawingManager.instance.getRecipeList())
			{
				if (irecipe instanceof ShapedSawingRecipe)
				{
					ShapedSawingRecipe srecipe = (ShapedSawingRecipe) irecipe;
					CachedShapedRecipe recipe = new CachedShapedRecipe(srecipe.recipeWidth, srecipe.recipeHeight, srecipe.recipeItems, srecipe.recipeOutput);
					
					recipe.computeVisuals();
					this.arecipes.add(recipe);
				}
			}
		}
		else
		{
			super.loadCraftingRecipes(outputId, results);
		}
	}
	
	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		for (ISawingRecipe irecipe : SawingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapedSawingRecipe)
			{
				if (CSStacks.itemEquals(irecipe.getRecipeOutput(), result))
				{
					ShapedSawingRecipe srecipe = (ShapedSawingRecipe) irecipe;
					CachedShapedRecipe recipe = new CachedShapedRecipe(srecipe.recipeWidth, srecipe.recipeHeight, srecipe.recipeItems, srecipe.recipeOutput);
					
					recipe.computeVisuals();
					this.arecipes.add(recipe);
				}
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (ISawingRecipe irecipe : SawingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapedSawingRecipe)
			{
				ShapedSawingRecipe srecipe = (ShapedSawingRecipe) irecipe;
				CachedShapedRecipe recipe = new CachedShapedRecipe(srecipe.recipeWidth, srecipe.recipeHeight, srecipe.recipeItems, srecipe.recipeOutput);
				
				if (recipe.contains(recipe.ingredients, ingredient.getItem()))
				{
					recipe.computeVisuals();
					if (recipe.contains(recipe.ingredients, ingredient))
					{
						recipe.setIngredientPermutation(recipe.ingredients, ingredient);
						this.arecipes.add(recipe);
					}
				}
			}
		}
	}
}
