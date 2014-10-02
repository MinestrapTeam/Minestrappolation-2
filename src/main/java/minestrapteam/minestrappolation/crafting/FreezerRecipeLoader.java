package minestrapteam.minestrappolation.crafting;

import clashsoft.cslib.minecraft.crafting.loader.CustomRecipeLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FreezerRecipeLoader extends CustomRecipeLoader
{
	public FreezerRecipeLoader(String name)
	{
		super(name);
	}
	
	@Override
	public void addRecipe(Item input, int inputMeta, Item output, int outputMeta, int amount, float exp)
	{
		FreezerRecipes.instance.addRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, amount, outputMeta));
	}
}
