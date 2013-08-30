package sobiohazardous.minestrappolation.extraores;

import java.util.HashMap;
import java.util.Map;

import sobiohazardous.minestrappolation.extraores.client.gui.ContainerMelter;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class MelterRecipes
{
private static final MelterRecipes melterBase = new MelterRecipes();

/** The list of smelting results. */
private Map melterList = new HashMap();
private Map melterExperience = new HashMap();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final MelterRecipes smelting()
	{
	return melterBase;
	}

	private MelterRecipes()
	{
		addSmelting(Block.cobblestone.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.7F);
		addSmelting(Block.cobblestoneMossy.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.7F);
		addSmelting(Block.gravel.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.7F);
		addSmelting(Block.stone.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.7F);
		addSmelting(Block.stoneBrick.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.7F);
		addSmelting(Block.snow.blockID, new ItemStack(Item.bucketWater,1,0), 0.7F);
		addSmelting(Block.ice.blockID, new ItemStack(Item.bucketWater,1,0), 0.7F);
	}	

/**
* Adds a smelting recipe.
*/
	public void addSmelting(int id, ItemStack itemStack, float experience)
	{
		melterList.put(Integer.valueOf(id), itemStack);
			this.melterExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
		
		
		
	}

/**
* Returns the smelting result of an item.
*/
public ItemStack getSmeltingResult(int id)
{
return (ItemStack)melterList.get(Integer.valueOf(id));
}

public Map getSmeltingList()
{
return melterList;
}
public float getExperience(int par1)
{
return this.melterExperience.containsKey(Integer.valueOf(par1)) ? ((Float)this.melterExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
}
}