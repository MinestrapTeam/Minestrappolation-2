package sobiohazardous.mods.minestrappolation.lib;

import sobiohazardous.mods.minestrappolation.core.customrecipes.CustomRecipeLoader;
import sobiohazardous.mods.minestrappolation.crafting.MelterRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MelterRecipeLoader extends CustomRecipeLoader
{
	public MelterRecipeLoader()
	{
		super("melter");
	}	
	
	@Override
	public void addRecipe(Item input, int inputMeta, Item output, int outputMeta, int amount, float exp)
	{
		MelterRecipes.instance.addRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, amount, outputMeta), exp);
	}
}
