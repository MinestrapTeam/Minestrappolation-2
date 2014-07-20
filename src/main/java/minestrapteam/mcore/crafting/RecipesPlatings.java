package minestrapteam.mcore.crafting;

import clashsoft.cslib.minecraft.stack.CSStacks;
import minestrapteam.mcore.item.IPlatable;
import minestrapteam.mcore.item.IPlating;
import minestrapteam.mcore.item.MCItemTool;
import minestrapteam.minestrappolation.item.ItemPlating;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesPlatings implements IRecipe
{
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory)
	{
		ItemStack platable = null;
		IPlating plating = null;
		int count = 0;
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack == null)
			{
				continue;
			}
			
			if (stack.getItem() instanceof IPlatable)
			{
				if (platable != null)
				{
					if (CSStacks.itemEquals(platable, stack))
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
					platable = stack;
				}
			}
			else if (stack.getItem() instanceof IPlating)
			{
				if (plating != null)
				{
					return null;
				}
				else
				{
					plating = (ItemPlating) stack.getItem();
				}
			}
		}
		
		if (platable != null && plating != null && count == ((IPlatable) platable.getItem()).getPlatingCount(platable))
		{
			ItemStack result = platable.copy();
			MCItemTool.setPlating(result, plating);
			return result;
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
		boolean platable = false;
		boolean plating = false;
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack == null)
			{
				continue;
			}
			
			if (stack.getItem() instanceof IPlatable)
			{
				if (platable)
				{
					return false;
				}
				else
				{
					platable = true;
				}
			}
			else if (stack.getItem() instanceof IPlating)
			{
				if (plating)
				{
					return false;
				}
				else
				{
					plating = true;
				}
			}
		}
		
		return plating && platable;
	}
}
