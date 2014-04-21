package sobiohazardous.minestrappolation.api.recipes;

import sobiohazardous.minestrappolation.api.tileentity.InventoryStonecutterExtraSlot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class StonecutterShapedRecipes implements IStonecutterRecipe
{
    /** How many horizontal slots this recipe is wide. */
    public final int recipeWidth;

    /** How many vertical slots this recipe uses. */
    public final int recipeHeight;

    /** Is a array of ItemStack that composes the recipe. */
    public final ItemStack[] recipeItems;

    /** Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;
    
    private boolean field_92101_f;
    
    private ItemStack neededExtraSlot;
    
    public StonecutterShapedRecipes(int par1, int par2, ItemStack[] par3ArrayOfItemStack, ItemStack par4ItemStack, ItemStack neededExtraSlot)
    {
        this.recipeWidth = par1;
        this.recipeHeight = par2;
        this.recipeItems = par3ArrayOfItemStack;
        this.recipeOutput = par4ItemStack;
        this.neededExtraSlot = neededExtraSlot;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extra, World par2World)
    {
        for (int i = 0; i <= 3 - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= 3 - this.recipeHeight; ++j)
            {
                if (this.checkMatch(par1InventoryCrafting, extra, i, j, true))
                {
                    return true;
                }

                if (this.checkMatch(par1InventoryCrafting, extra, i, j, false))
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
    private boolean checkMatch(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extraInv, int par2, int par3,boolean par4)
    { 	
    	for (int var5 = 0; var5 < 3; ++var5)
        {
            for (int var6 = 0; var6 < 3; ++var6)
            {
                int var7 = var5 - par2;
                int var8 = var6 - par3;
                ItemStack var9 = null;

                if (var7 >= 0 && var8 >= 0 && var7 < this.recipeWidth && var8 < this.recipeHeight)
                {
                    if (par4)
                    {
                        var9 = this.recipeItems[this.recipeWidth - var7 - 1 + var8 * this.recipeWidth];
                    }
                    else
                    {
                        var9 = this.recipeItems[var7 + var8 * this.recipeWidth];
                    }
                }

                ItemStack var10 = par1InventoryCrafting.getStackInRowAndColumn(var5, var6);
                ItemStack currentExtraSlot = extraInv.getStackInSlot(0);

                if (var10 != null || var9 != null)
                {
                    if (var10 == null && var9 != null || var10 != null && var9 == null)
                    {
                    	return false;
                    }

                    if (var9.getItem() != var10.getItem())
                    {
                        return false;
                    }

                    if (var9.getItemDamage() != 32767 && var9.getItemDamage() != var10.getItemDamage())
                    {
                        return false;
                    }   
                    
                    if(currentExtraSlot == null && neededExtraSlot != null || currentExtraSlot != null && neededExtraSlot == null)
                    {
                        return false;
                    }
                    //TODO It's beyond me why this is == instead of != wtf
                    if(currentExtraSlot == neededExtraSlot)
                    {
                    	System.out.println(currentExtraSlot + " == " + neededExtraSlot);
                    	return false;
                    }
                } 
                
                /*
                if(currentExtraSlot != null || neededExtraSlot != null)
                {
                	 if(currentExtraSlot == null && neededExtraSlot != null || currentExtraSlot != null && neededExtraSlot == null)
                     {
                     	 System.out.println("4");
                         return false;
                     }
                     if(currentExtraSlot != neededExtraSlot)
                     {
                     	System.out.println("5");
                     	return false;
                     }
                }
                */
            }
        }
        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extra)
    {
        ItemStack var2 = this.getRecipeOutput().copy();

        if (this.field_92101_f)
        {
            for (int var3 = 0; var3 < par1InventoryCrafting.getSizeInventory(); ++var3)
            {
                ItemStack var4 = par1InventoryCrafting.getStackInSlot(var3);

                if (var4 != null && var4.hasTagCompound())
                {
                    var2.setTagCompound((NBTTagCompound)var4.stackTagCompound.copy());
                }
            }
        }

        return var2;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeWidth * this.recipeHeight;
    }

    //setHasNBTResult
    public StonecutterShapedRecipes func_92100_c()
    {
        this.field_92101_f = true;
        return this;
    }
    
}
