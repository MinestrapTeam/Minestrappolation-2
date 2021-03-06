package minestrapteam.minestrappolation.nei.handler;

import java.awt.Rectangle;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.stack.CSStacks;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.crafting.stonecutter.ICuttingRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.ShapelessCuttingRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecuttingManager;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ShapelessStonecuttingHandler extends ShapelessRecipeHandler
{
	public class CachedShapelessSCRecipe extends CachedShapelessRecipe
	{
		private PositionedStack	extraSlot;
		
		public CachedShapelessSCRecipe(ShapelessCuttingRecipe recipe)
		{
			this.setResult(recipe.recipeOutput);
			this.setIngredients(recipe.recipeItems);
			this.setExtraSlot(recipe.extraSlot);
		}
		
		public CachedShapelessSCRecipe(ItemStack extra, Object[] input, ItemStack output)
		{
			super(input, output);
			this.setExtraSlot(extra);
		}
		
		public CachedShapelessSCRecipe(ItemStack extra, List<?> input, ItemStack output)
		{
			super(input, output);
			this.setExtraSlot(extra);
		}
		
		@Override
		public void setResult(ItemStack output)
		{
			this.result = new PositionedStack(output, 133, 24);
		}
		
		public void setExtraSlot(ItemStack extra)
		{
			if (extra != null)
			{
				this.extraSlot = new PositionedStack(extra, 3, 24);
			}
		}
		
		@Override
		public void setIngredients(List<?> items)
		{
			this.ingredients.clear();
			for (int ingred = 0; ingred < items.size(); ingred++)
			{
				PositionedStack stack = new PositionedStack(items.get(ingred), 39 + ShapelessStonecuttingHandler.this.stackorder[ingred][0] * 18, 6 + ShapelessStonecuttingHandler.this.stackorder[ingred][1] * 18);
				stack.setMaxSize(1);
				this.ingredients.add(stack);
			}
		}
		
		@Override
		public PositionedStack getOtherStack()
		{
			return this.extraSlot;
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
		return I18n.getString("recipe.stonecutter.shapeless");
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "stonecutter";
	}
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(22, 23, 12, 18), "stonecutter"));
		this.transferRects.add(new RecipeTransferRect(new Rectangle(98, 23, 24, 18), "stonecutter"));
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
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if ("stonecutter".equals(outputId))
		{
			for (ICuttingRecipe irecipe : StonecuttingManager.instance.getRecipeList())
			{
				if (irecipe instanceof ShapelessCuttingRecipe)
				{
					CachedShapelessSCRecipe recipe = new CachedShapelessSCRecipe((ShapelessCuttingRecipe) irecipe);
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
		for (ICuttingRecipe irecipe : StonecuttingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapelessCuttingRecipe)
			{
				if (CSStacks.itemEquals(irecipe.getRecipeOutput(), result))
				{
					CachedShapelessSCRecipe recipe = new CachedShapelessSCRecipe((ShapelessCuttingRecipe) irecipe);
					this.arecipes.add(recipe);
				}
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (ICuttingRecipe irecipe : StonecuttingManager.instance.getRecipeList())
		{
			if (irecipe instanceof ShapelessCuttingRecipe)
			{
				CachedShapelessSCRecipe recipe = new CachedShapelessSCRecipe((ShapelessCuttingRecipe) irecipe);
				
				if (recipe.contains(recipe.ingredients, ingredient))
				{
					recipe.setIngredientPermutation(recipe.ingredients, ingredient);
					this.arecipes.add(recipe);
				}
			}
		}
	}
}
