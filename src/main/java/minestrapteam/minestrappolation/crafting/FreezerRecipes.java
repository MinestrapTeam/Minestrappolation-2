package minestrapteam.minestrappolation.crafting;

import minestrapteam.minestrappolation.item.MItemFood;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import clashsoft.cslib.minecraft.crafting.manager.SimpleRecipeManager;

public class FreezerRecipes extends SimpleRecipeManager
{
	public static final FreezerRecipes	instance	= new FreezerRecipes();
	
	private FreezerRecipes()
	{
		// TODO Add Recipes
	}
	
	@Override
	public ItemStack getResult(ItemStack input)
	{
		if (input.getItem() instanceof MItemFood && !MItemFood.isFrozen(input))
		{
			ItemStack stack = new ItemStack(input.getItem(), 1, input.getItemDamage());
			
			if (input.stackTagCompound != null)
			{
				stack.stackTagCompound = (NBTTagCompound) input.stackTagCompound.copy();
			}
			
			MItemFood.setFrozen(stack, true);
			
			return stack;
		}
		
		return super.getResult(input);
	}
}
