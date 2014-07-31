package minestrapteam.minestrappolation.crafting.sawmill;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISawingRecipe
{
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting inventory, World world);
	
	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(InventoryCrafting inventory);
	
	/**
	 * Returns the size of the recipe area
	 */
	public int getRecipeSize();
	
	public ItemStack getRecipeOutput();
}
