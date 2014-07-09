package minestrapteam.mcore.crafting.stonecutter;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShapelessSCRecipe implements ISCRecipe
{
	public final List		recipeItems;
	public final ItemStack	recipeOutput;
	public final ItemStack	extraSlot;
	
	public ShapelessSCRecipe(ItemStack output, List items, ItemStack extraSlot)
	{
		this.recipeOutput = output;
		this.recipeItems = items;
		this.extraSlot = extraSlot;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}
	
	@Override
	public boolean matches(InventoryCrafting inventory, ItemStack extra, World par2World)
	{
		ArrayList<ItemStack> list = new ArrayList(this.recipeItems);
		
		for (int i = 0; i < inventory.getSizeInventory(); ++i)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack != null)
			{
				boolean flag = false;
				for (ItemStack stack1 : list)
				{
					if (CSStacks.equals(stack, stack1))
					{
						flag = true;
						list.remove(stack1);
						break;
					}
				}
				
				if (!flag)
				{
					return false;
				}
			}
		}
		
		return list.isEmpty();
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack extra)
	{
		return this.recipeOutput.copy();
	}
	
	@Override
	public int getRecipeSize()
	{
		return this.recipeItems.size();
	}
}
