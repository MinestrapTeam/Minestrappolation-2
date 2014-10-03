package minestrapteam.minestrappolation.nei.handler;

import static codechicken.nei.NEIClientUtils.translate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import clashsoft.cslib.minecraft.lang.I18n;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.FurnaceRecipeHandler.FuelPair;
import codechicken.nei.recipe.GuiRecipe;
import minestrapteam.minestrappolation.crafting.FreezerRecipes;

import net.minecraft.item.ItemStack;

public class FreezerFuelHandler extends FreezerRecipeHandler
{
	public class CachedFuelRecipe extends CachedRecipe
	{
		public FuelPair	fuel;
		
		public CachedFuelRecipe(FuelPair fuel)
		{
			this.fuel = fuel;
		}
		
		@Override
		public PositionedStack getIngredient()
		{
			return FreezerFuelHandler.this.mfurnace.get(FreezerFuelHandler.this.cycleticks / 48 % FreezerFuelHandler.this.mfurnace.size()).ingred;
		}
		
		@Override
		public PositionedStack getResult()
		{
			return FreezerFuelHandler.this.mfurnace.get(FreezerFuelHandler.this.cycleticks / 48 % FreezerFuelHandler.this.mfurnace.size()).result;
		}
		
		@Override
		public PositionedStack getOtherStack()
		{
			return this.fuel.stack;
		}
	}
	
	private ArrayList<FreezingPair>	mfurnace	= new ArrayList();
	
	public FreezerFuelHandler()
	{
		super();
		this.loadAllSmelting();
	}
	
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.freezer_fuel");
	}
	
	private void loadAllSmelting()
	{
		Map<ItemStack, ItemStack> recipes = FreezerRecipes.instance.getRecipes();
		
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			this.mfurnace.add(new FreezingPair(recipe.getKey(), recipe.getValue()));
		}
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if (outputId.equals("freezer_fuel") && this.getClass() == FreezerFuelHandler.class)
		{
			for (FuelPair fuel : afuels)
			{
				this.arecipes.add(new CachedFuelRecipe(fuel));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (FuelPair fuel : afuels)
		{
			if (fuel.stack.contains(ingredient))
			{
				this.arecipes.add(new CachedFuelRecipe(fuel));
			}
		}
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "freezer_fuel";
	}
	
	@Override
	public List<String> handleItemTooltip(GuiRecipe gui, ItemStack stack, List<String> currenttip, int recipe)
	{
		CachedFuelRecipe crecipe = (CachedFuelRecipe) this.arecipes.get(recipe);
		FuelPair fuel = crecipe.fuel;
		float burnTime = fuel.burnTime / 200F;
		
		if (gui.isMouseOver(fuel.stack, recipe) && burnTime < 1)
		{
			burnTime = 1F / burnTime;
			String s_time = Float.toString(burnTime);
			if (burnTime == Math.round(burnTime))
			{
				s_time = Integer.toString((int) burnTime);
			}
			
			currenttip.add(translate("recipe.fuel.required", s_time));
		}
		else if ((gui.isMouseOver(crecipe.getResult(), recipe) || gui.isMouseOver(crecipe.getIngredient(), recipe)) && burnTime > 1)
		{
			String s_time = Float.toString(burnTime);
			if (burnTime == Math.round(burnTime))
			{
				s_time = Integer.toString((int) burnTime);
			}
			
			currenttip.add(translate("recipe.fuel." + (gui.isMouseOver(crecipe.getResult(), recipe) ? "produced" : "processed"), s_time));
		}
		
		return currenttip;
	}
}
