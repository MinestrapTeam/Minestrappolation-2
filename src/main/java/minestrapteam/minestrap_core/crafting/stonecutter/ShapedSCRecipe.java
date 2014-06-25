package minestrapteam.minestrap_core.crafting.stonecutter;

import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ShapedSCRecipe implements ISCRecipe
{
	public final int			recipeWidth;
	public final int			recipeHeight;
	
	public final ItemStack[]	recipeItems;
	public final ItemStack		recipeOutput;
	
	private ItemStack			extraSlot;
	
	protected boolean			hasNBTResult;
	
	public ShapedSCRecipe(int width, int height, ItemStack[] data, ItemStack output, ItemStack extra)
	{
		this.recipeWidth = width;
		this.recipeHeight = height;
		this.recipeItems = data;
		this.recipeOutput = output;
		this.extraSlot = extra;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}
	
	@Override
	public boolean matches(InventoryCrafting inventory, ItemStack extra, World world)
	{
		if (!CSStacks.equals(this.extraSlot, extra))
		{
			return false;
		}
		
		for (int i = 0; i <= 3 - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= 3 - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inventory, i, j, true))
				{
					return true;
				}
				
				if (this.checkMatch(inventory, i, j, false))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 */
	private boolean checkMatch(InventoryCrafting inventory, int x, int y, boolean mirror)
	{
		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				int i1 = i - x;
				int j1 = j - y;
				ItemStack stack1 = null;
				
				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (mirror)
					{
						stack1 = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						stack1 = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}
				
				ItemStack stack2 = inventory.getStackInRowAndColumn(i, j);
				
				if (stack2 != null || stack1 != null)
				{
					if (!CSStacks.equals(stack1, stack2))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack extra)
	{
		ItemStack stack = this.getRecipeOutput().copy();
		
		if (this.hasNBTResult)
		{
			for (int i = 0; i < inventory.getSizeInventory(); ++i)
			{
				ItemStack stack1 = inventory.getStackInSlot(i);
				
				if (stack1 != null && stack1.hasTagCompound())
				{
					stack.setTagCompound((NBTTagCompound) stack1.stackTagCompound.copy());
				}
			}
		}
		
		return stack;
	}
	
	@Override
	public int getRecipeSize()
	{
		return this.recipeWidth * this.recipeHeight;
	}
	
	public ShapedSCRecipe setHasNBTResult(boolean hasNBTResult)
	{
		this.hasNBTResult = hasNBTResult;
		return this;
	}
}
