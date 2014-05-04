package sobiohazardous.mods.minestrappolation.core.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sobiohazardous.mods.minestrappolation.core.tileentity.InventoryStonecutterExtraSlot;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class StonecutterShapelessRecipes implements IStonecutterRecipe
{
    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;

    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;
    
    private final ItemStack extraSlot;
    

    public StonecutterShapelessRecipes(ItemStack par1ItemStack, List par2List, ItemStack extraSlot)
    {
        this.recipeOutput = par1ItemStack;
        this.recipeItems = par2List;
        this.extraSlot = extraSlot;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extraInv, World par2World)
    {
    	ArrayList var3 = new ArrayList(this.recipeItems);

        for (int var4 = 0; var4 < 3; ++var4)
        {
            for (int var5 = 0; var5 < 3; ++var5)
            {
                ItemStack var6 = par1InventoryCrafting.getStackInRowAndColumn(var5, var4);

                if (var6 != null)
                {
                    boolean var7 = false;
                    Iterator var8 = var3.iterator();

                    while (var8.hasNext())
                    {
                        ItemStack var9 = (ItemStack)var8.next();

                        if (var6.getItem() == var9.getItem() && (var9.getItemDamage() == 32767 || var6.getItemDamage() == var9.getItemDamage()))
                        {
                            var7 = true;
                            var3.remove(var9);
                            break;
                        }
                    }

                    if (!var7)
                    {
                        return false;
                    }
                }
            }
        }

        return var3.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extraInv)
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}
