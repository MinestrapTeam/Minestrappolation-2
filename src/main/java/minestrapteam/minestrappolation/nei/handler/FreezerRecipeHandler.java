package minestrapteam.minestrappolation.nei.handler;

import java.awt.Rectangle;
import java.util.*;
import java.util.Map.Entry;

import clashsoft.cslib.minecraft.lang.I18n;
import codechicken.nei.ItemList;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.FurnaceRecipeHandler.FuelPair;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiFreezer;
import minestrapteam.minestrappolation.crafting.FreezerRecipes;
import minestrapteam.minestrappolation.tileentity.TileEntityFreezer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class FreezerRecipeHandler extends TemplateRecipeHandler
{
	public class FreezingPair extends CachedRecipe
	{
		PositionedStack	ingred;
		PositionedStack	result;
		
		public FreezingPair(ItemStack ingred, ItemStack result)
		{
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 51, 6);
			this.result = new PositionedStack(result, 111, 24);
		}
		
		@Override
		public List<PositionedStack> getIngredients()
		{
			return this.getCycledIngredients(FreezerRecipeHandler.this.cycleticks / 48, Arrays.asList(this.ingred));
		}
		
		@Override
		public PositionedStack getResult()
		{
			return this.result;
		}
		
		@Override
		public PositionedStack getOtherStack()
		{
			return afuels.get(FreezerRecipeHandler.this.cycleticks / 48 % afuels.size()).stack;
		}
	}
	
	public static ArrayList<FuelPair>	afuels;
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "freezer_fuel"));
		this.transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "freezing"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiFreezer.class;
	}
	
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.freezing");
	}
	
	@Override
	public TemplateRecipeHandler newInstance()
	{
		if (afuels == null)
		{
			findFuels();
		}
		return super.newInstance();
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if (outputId.equals("freezing") && this.getClass() == FreezerRecipeHandler.class)
		{
			Map<ItemStack, ItemStack> recipes = FreezerRecipes.instance.getRecipes();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
			{
				this.arecipes.add(new FreezingPair(recipe.getKey(), recipe.getValue()));
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
		Map<ItemStack, ItemStack> recipes = FreezerRecipes.instance.getRecipes();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
			{
				this.arecipes.add(new FreezingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients)
	{
		if (inputId.equals("freezer_fuel") && this.getClass() == FreezerRecipeHandler.class)
		{
			this.loadCraftingRecipes("freezing");
		}
		else
		{
			super.loadUsageRecipes(inputId, ingredients);
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		Map<ItemStack, ItemStack> recipes = FreezerRecipes.instance.getRecipes();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient))
			{
				FreezingPair arecipe = new FreezingPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				this.arecipes.add(arecipe);
			}
		}
	}
	
	@Override
	public String getGuiTexture()
	{
		return "minestrappolation:textures/gui/container/freezer.png";
	}
	
	@Override
	public void drawExtras(int recipe)
	{
		this.drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
		this.drawProgressBar(74, 23, 176, 14, 24, 16, 48, 0);
	}
	
	private static void findFuels()
	{
		afuels = new ArrayList<FuelPair>();
		for (ItemStack item : ItemList.items)
		{
			int burnTime = TileEntityFreezer.getItemEnergy(item);
			if (burnTime > 0)
			{
				afuels.add(new FuelPair(item.copy(), burnTime));
			}
		}
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "freezing";
	}
}
