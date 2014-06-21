package minestrapteam.minestrap_core.crafting;

import minestrapteam.minestrap_core.item.IPlatable;
import minestrapteam.minestrap_core.item.MCItemTool;
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
		String plating = null;
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack == null)
				continue;
			
			if (stack.getItem() instanceof IPlatable)
			{
				if (platable != null)
				{
					return null;
				}
				else
				{
					platable = stack;
				}
			}
			else if (stack.getItem() instanceof ItemPlating)
			{
				if (plating != null)
				{
					return null;
				}
				else
				{
					plating = ((ItemPlating) stack.getItem()).getPlating(stack);
				}
			}
		}
		
		if (platable != null && plating != null)
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
				continue;
			
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
			else if (stack.getItem() instanceof ItemPlating)
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
