package minestrapteam.minestrappolation.crafting;

import clashsoft.cslib.minecraft.stack.CSStacks;
import minestrapteam.minestrappolation.item.IItemAddon;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

public class RecipesItemAddons implements IRecipe
{
	static
	{
		RecipeSorter.register("minestrappolation:plating", RecipesItemAddons.class, Category.SHAPELESS, "after:minecraft:shapeless");
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory)
	{
		ItemStack platable = null;
		ItemStack addon = null;
		int count = 0;
		
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack == null)
			{
				continue;
			}
			
			if (stack.getItem() instanceof IItemAddon)
			{
				if (addon != null)
				{
					if (CSStacks.itemEquals(addon, stack))
					{
						count++;
					}
					else
					{
						return null;
					}
				}
				else
				{
					count++;
					addon = stack;
				}
			}
			else if (platable == null)
			{
				platable = stack;
			}
			else
			{
				return null;
			}
		}
		
		if (platable != null && addon != null)
		{
			IItemAddon iaddon = (IItemAddon) addon.getItem();
			if (!iaddon.isApplied(platable) && count == iaddon.getCount(platable))
			{
				ItemStack result = platable.copy();
				iaddon.apply(result);
				return result;
			}
		}
		
		return null;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}
	
	@Override
	public int getRecipeSize()
	{
		return 2;
	}
	
	@Override
	public boolean matches(InventoryCrafting inventory, World world)
	{
		ItemStack platable = null;
		ItemStack addon = null;
		int count = 0;
		
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack == null)
			{
				continue;
			}
			
			if (stack.getItem() instanceof IItemAddon)
			{
				if (addon != null)
				{
					if (CSStacks.itemEquals(addon, stack))
					{
						count++;
					}
					else
					{
						return false;
					}
				}
				else
				{
					count++;
					addon = stack;
				}
			}
			else if (platable == null)
			{
				platable = stack;
			}
			else
			{
				return false;
			}
		}
		
		if (platable != null && addon != null)
		{
			IItemAddon iaddon = (IItemAddon) addon.getItem();
			return !iaddon.isApplied(platable) && count == iaddon.getCount(platable);
		}
		return false;
	}
}
