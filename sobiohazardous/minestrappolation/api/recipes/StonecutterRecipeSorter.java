package sobiohazardous.minestrappolation.api.recipes;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

class RecipeSorter implements Comparator
{
    final StonecutterCraftingManager craftingManager;

    RecipeSorter(StonecutterCraftingManager par1CraftingManager)
    {
        this.craftingManager = par1CraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof StonecutterShapelessRecipes && par2IRecipe instanceof StonecutterShapedRecipes ? 1 : (par2IRecipe instanceof StonecutterShapelessRecipes && par1IRecipe instanceof StonecutterShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}
