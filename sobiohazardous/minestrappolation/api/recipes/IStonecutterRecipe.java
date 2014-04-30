package sobiohazardous.minestrappolation.api.recipes;

import sobiohazardous.minestrappolation.api.tileentity.InventoryStonecutterExtraSlot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IStonecutterRecipe
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventoryCrafting var1, InventoryStonecutterExtraSlot extra, World var2);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCrafting var1, InventoryStonecutterExtraSlot extra);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();
}
