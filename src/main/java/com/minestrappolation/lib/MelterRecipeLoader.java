package com.minestrappolation.lib;

import com.minestrappolation.crafting.MelterRecipes;
import com.minestrappolation_core.crafting.CustomRecipeLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MelterRecipeLoader extends CustomRecipeLoader
{
	public MelterRecipeLoader(String name)
	{
		super(name);
	}
	
	@Override
	public void addRecipe(Item input, int inputMeta, Item output, int outputMeta, int amount, float exp)
	{
		MelterRecipes.instance.addRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, amount, outputMeta), exp);
	}
}
