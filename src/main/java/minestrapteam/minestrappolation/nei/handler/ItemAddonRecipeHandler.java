package minestrapteam.minestrappolation.nei.handler;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import codechicken.nei.ItemList;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import minestrapteam.minestrappolation.item.IItemAddon;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAddonRecipeHandler extends ShapelessRecipeHandler
{
	public class CachedAddonRecipe extends CachedShapelessRecipe
	{
		public CachedAddonRecipe(ItemStack platable, ItemStack addon)
		{
			IItemAddon iaddon = (IItemAddon) addon.getItem();
			
			ItemStack copy = platable.copy();
			iaddon.apply(copy);
			
			int count = iaddon.getCount(platable);
			List<ItemStack> list = new ArrayList(count);
			for (int i = 0; i < count; i++)
			{
				list.add(addon);
			}
			list.add(platable);
			
			this.setResult(copy);
			this.setIngredients(list);
		}
	}
	
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.item_addons");
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if ("crafting".equals(outputId))
		{
			for (IItemAddon iaddon : IItemAddon.addons)
			{
				ItemStack addon = new ItemStack((Item) iaddon, 1, 0);
				for (ItemStack stack : ItemList.items)
				{
					if (iaddon.canApply(stack))
					{
						this.arecipes.add(new CachedAddonRecipe(stack, addon));
					}
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
		for (IItemAddon iaddon : IItemAddon.addons)
		{
			if (iaddon.isApplied(result))
			{
				ItemStack addon = new ItemStack((Item) iaddon, 1, 0);
				ItemStack copy = result.copy();
				iaddon.unapply(copy);
				this.arecipes.add(new CachedAddonRecipe(copy, addon));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (IItemAddon iaddon : IItemAddon.addons)
		{
			if (iaddon.canApply(ingredient))
			{
				ItemStack addon = new ItemStack((Item) iaddon, 1, 0);
				this.arecipes.add(new CachedAddonRecipe(ingredient, addon));
			}
		}
		
		if (ingredient.getItem() instanceof IItemAddon)
		{
			IItemAddon iaddon = (IItemAddon) ingredient.getItem();
			
			for (ItemStack stack : ItemList.items)
			{
				if (iaddon.canApply(stack))
				{
					this.arecipes.add(new CachedAddonRecipe(stack, ingredient));
				}
			}
		}
	}
}
