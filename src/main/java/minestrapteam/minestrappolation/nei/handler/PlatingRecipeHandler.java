package minestrapteam.minestrappolation.nei.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import minestrapteam.minestrappolation.item.IPlatable;
import minestrapteam.minestrappolation.item.IPlating;
import minestrapteam.minestrappolation.item.MItemTool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PlatingRecipeHandler extends ShapelessRecipeHandler
{
	public class CachedPlatingRecipe extends CachedShapelessRecipe
	{
		public CachedPlatingRecipe(ItemStack platable, ItemStack plating)
		{
			IPlatable iplatable = (IPlatable) platable.getItem();
			IPlating iplating = (IPlating) plating.getItem();
			
			ItemStack platable1 = platable.copy();
			MItemTool.setPlating(platable1, iplating);
			
			int count = iplatable.getPlatingCount(platable);
			List<ItemStack> list = new ArrayList(count);
			for (int i = 0; i < count; i++)
			{
				list.add(plating);
			}
			list.add(platable);
			
			this.setResult(platable1);
			this.setIngredients(list);
		}
	}
	
	@Override
	public String getRecipeName()
	{
		return I18n.getString("recipe.plating");
	}
	
	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		if (result.getItem() instanceof IPlatable)
		{
			IPlating iplating = MItemTool.getPlating(result);
			if (iplating != null)
			{
				ItemStack plating = new ItemStack((Item) iplating, 1, 0);
				ItemStack platable = result.copy();
				platable.stackTagCompound = new NBTTagCompound();
				this.arecipes.add(new CachedPlatingRecipe(platable, plating));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		if (ingredient.getItem() instanceof IPlatable)
		{
			for (IPlating iplating : IPlating.platings.values())
			{
				if (iplating.canApply((IPlatable) ingredient.getItem()))
				{
					ItemStack plating = new ItemStack((Item) iplating, 1, 0);
					this.arecipes.add(new CachedPlatingRecipe(ingredient, plating));
				}
			}
		}
		if (ingredient.getItem() instanceof IPlating)
		{
			IPlating iplating = (IPlating) ingredient.getItem();
			Iterator<Item> iterator = Item.itemRegistry.iterator();
			while (iterator.hasNext())
			{
				Item item = iterator.next();
				if (item instanceof IPlatable)
				{
					List<ItemStack> list = new ArrayList();
					item.getSubItems(item, null, list);
					for (ItemStack stack : list)
					{
						this.arecipes.add(new CachedPlatingRecipe(stack, ingredient));
					}
				}
			}
		}
	}
}
