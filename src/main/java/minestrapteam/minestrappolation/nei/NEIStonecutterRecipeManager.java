package minestrapteam.minestrappolation.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.stack.CSStacks;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapedRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.crafting.stonecutter.ISCRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.ShapedSCRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecutterCraftingManager;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class NEIStonecutterRecipeManager extends ShapedRecipeHandler
{
	public class SCCachedShapedRecipe extends CachedRecipe
	{
		public ArrayList<PositionedStack>	ingredients;
		public PositionedStack				result;
		
		public SCCachedShapedRecipe(int width, int height, Object[] items, ItemStack out)
		{
			this.result = new PositionedStack(out, 119, 24);
			this.ingredients = new ArrayList<PositionedStack>();
			this.setIngredients(width, height, items);
		}
		
		public SCCachedShapedRecipe(ShapedSCRecipe recipe)
		{
			this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
		}
		
		public void setIngredients(int width, int height, Object[] items)
		{
			for (int x = 0; x < width; x++)
			{
				for (int y = 0; y < height; y++)
				{
					if (items[y * width + x] == null)
					{
						continue;
					}
					
					PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18, false);
					stack.setMaxSize(1);
					this.ingredients.add(stack);
				}
			}
		}
		
		@Override
		public List<PositionedStack> getIngredients()
		{
			return this.getCycledIngredients(NEIStonecutterRecipeManager.this.cycleticks / 20, this.ingredients);
		}
		
		@Override
		public PositionedStack getResult()
		{
			return this.result;
		}
		
		public void computeVisuals()
		{
			for (PositionedStack p : this.ingredients)
			{
				p.generatePermutations();
			}
		}
	}
	
	@Override
	public String getGuiTexture()
	{
		return MAssetManager.getTexture("textures/gui/container/stonecutter.png");
	}
	
	@Override
	public String getRecipeName()
	{
		return "Stonecutter";
	}
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(8, 35, 24, 26), "stonecutter"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiStonecutter.class;
	}
	
	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
	{
		return false;
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (ISCRecipe irecipe : StonecutterCraftingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapedSCRecipe)
			{
				SCCachedShapedRecipe recipe = new SCCachedShapedRecipe((ShapedSCRecipe) irecipe);
				
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
	
	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		for (ISCRecipe irecipe : StonecutterCraftingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapedSCRecipe)
			{
				if (CSStacks.itemEquals(irecipe.getRecipeOutput(), result))
				{
					SCCachedShapedRecipe recipe = new SCCachedShapedRecipe((ShapedSCRecipe) irecipe);
					
					recipe.computeVisuals();
					this.arecipes.add(recipe);
				}
			}
		}
	}
}
