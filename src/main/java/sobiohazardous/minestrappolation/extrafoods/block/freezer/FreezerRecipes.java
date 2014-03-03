package sobiohazardous.minestrappolation.extrafoods.block.freezer;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class FreezerRecipes
{
	private static final FreezerRecipes fridgeBase = new FreezerRecipes();

	/** The list of smelting results. */
	private Map fridgeList = new HashMap();
	private Map fridgeExperience = new HashMap();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final FreezerRecipes smelting()
	{
		return fridgeBase;
	}

	private FreezerRecipes()
	{
		addSmelting(Block.dirt.blockID, new ItemStack(Block.cobblestone, 1, 0), 0.7F);
	}

	/**
	 * Adds a smelting recipe.
	 */
	public void addSmelting(int id, ItemStack itemStack, float experience)
	{
		fridgeList.put(Integer.valueOf(id), itemStack);
		this.fridgeExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
	}	

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getSmeltingResult(int id)
	{
		return (ItemStack)fridgeList.get(Integer.valueOf(id));
	}

	public Map getSmeltingList()
	{
		return fridgeList;
	}
	public float getExperience(int par1)
	{
		return this.fridgeExperience.containsKey(Integer.valueOf(par1)) ? ((Float)this.fridgeExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}
}