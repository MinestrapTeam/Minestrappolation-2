package minestrapteam.minestrappolation.nei.handler;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.stack.CSStacks;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiSawmill;
import minestrapteam.minestrappolation.crafting.sawmill.ISawingRecipe;
import minestrapteam.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.minestrappolation.crafting.sawmill.ShapelessSawingRecipe;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ShapelessSawingHandler extends ShapelessRecipeHandler
{
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.sawmill.shapeless");
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
				if (irecipe instanceof ShapelessSawingRecipe)
				{
					ShapelessSawingRecipe srecipe = (ShapelessSawingRecipe) irecipe;
					CachedShapelessRecipe recipe = new CachedShapelessRecipe(srecipe.recipeItems, srecipe.recipeOutput);
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
			if (irecipe instanceof ShapelessSawingRecipe)
			{
				if (CSStacks.itemEquals(irecipe.getRecipeOutput(), result))
				{
					ShapelessSawingRecipe srecipe = (ShapelessSawingRecipe) irecipe;
					CachedShapelessRecipe recipe = new CachedShapelessRecipe(srecipe.recipeItems, srecipe.recipeOutput);
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
			if (irecipe instanceof ShapelessSawingRecipe)
			{
				ShapelessSawingRecipe srecipe = (ShapelessSawingRecipe) irecipe;
				CachedShapelessRecipe recipe = new CachedShapelessRecipe(srecipe.recipeItems, srecipe.recipeOutput);
				
				if (recipe.contains(recipe.ingredients, ingredient))
				{
					recipe.setIngredientPermutation(recipe.ingredients, ingredient);
					this.arecipes.add(recipe);
				}
			}
		}
	}
}
