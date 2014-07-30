package minestrapteam.minestrappolation.nei;

import java.awt.Rectangle;
import java.util.*;
import java.util.Map.Entry;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.stack.CSStacks;
import codechicken.nei.ItemList;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.minestrappolation.client.gui.GuiMelter;
import minestrapteam.minestrappolation.crafting.MelterRecipes;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class NEIMelterManager extends TemplateRecipeHandler
{
	public class MeltingPair extends CachedRecipe
	{
		protected PositionedStack	ingred;
		protected PositionedStack	result;
		protected PositionedStack	bucket;
		
		public MeltingPair(ItemStack ingred, ItemStack result)
		{
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 51, 6);
			this.result = new PositionedStack(result, 111, 24);
			
			ItemStack container = result.getItem().getContainerItem(result);
			if (container != null)
			{
				this.bucket = new PositionedStack(container, 61, 42);
			}
		}
		
		@Override
		public List<PositionedStack> getIngredients()
		{
			return this.getCycledIngredients(NEIMelterManager.this.cycleticks / 48, Arrays.asList(this.ingred));
		}
		
		@Override
		public PositionedStack getResult()
		{
			return this.result;
		}
		
		@Override
		public List<PositionedStack> getOtherStacks()
		{
			List<PositionedStack> list = super.getOtherStacks();
			PositionedStack fuel = afuels.get(NEIMelterManager.this.cycleticks / 48 % afuels.size()).stack;
			if (fuel != null)
			{
				list.add(fuel);
			}
			if (this.bucket != null)
			{
				list.add(this.bucket);
			}
			return list;
		}
	}
	
	public static class FuelPair
	{
		public PositionedStack	stack;
		public int				burnTime;
		
		public FuelPair(ItemStack ingred, int burnTime)
		{
			this.stack = new PositionedStack(ingred, 42, 42, false);
			this.burnTime = burnTime;
		}
	}
	
	public static ArrayList<FuelPair>	afuels;
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "melter_fuel"));
		this.transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "melting"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiMelter.class;
	}
	
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.melting");
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
		findFuels();
		
		if (outputId.equals("melting"))
		{
			Map<ItemStack, ItemStack> recipes = MelterRecipes.instance.getRecipes();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
			{
				this.arecipes.add(new MeltingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}
	
	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		Map<ItemStack, ItemStack> recipes = MelterRecipes.instance.getRecipes();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			if (CSStacks.itemEquals(recipe.getValue(), result))
			{
				this.arecipes.add(new MeltingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients)
	{
		if (inputId.equals("melter_fuel"))
		{
			this.loadCraftingRecipes("melting");
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		Map<ItemStack, ItemStack> recipes = MelterRecipes.instance.getRecipes();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			if (CSStacks.itemEquals(recipe.getKey(), ingredient))
			{
				MeltingPair arecipe = new MeltingPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				this.arecipes.add(arecipe);
			}
		}
	}
	
	@Override
	public String getGuiTexture()
	{
		return MAssetManager.getTexture("textures/gui/container/melter.png");
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
			int burnTime = TileEntityMelter.getItemBurnTime(item);
			if (burnTime > 0)
			{
				afuels.add(new FuelPair(item.copy(), burnTime));
			}
		}
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "melting";
	}
}
