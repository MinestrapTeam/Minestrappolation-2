package clashsoft.cslib.minecraft.crafting;

import gnu.trove.map.hash.TCustomHashMap;

import java.util.Map;

import clashsoft.cslib.minecraft.util.ItemStackHashingStrategy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SimpleRecipeManager
{
	private Map<ItemStack, ItemStack>	recipeMap	= new TCustomHashMap(ItemStackHashingStrategy.instance);
	
	protected SimpleRecipeManager()
	{
	}
	
	public void addRecipe(Block block, ItemStack output)
	{
		this.addRecipe(new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE), output);
	}
	
	public void addRecipe(Item item, ItemStack output)
	{
		this.addRecipe(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE), output);
	}
	
	public void addRecipe(ItemStack input, ItemStack output)
	{
		this.recipeMap.put(input, output.copy());
	}
	
	public ItemStack getResult(ItemStack ingredient)
	{
		return this.recipeMap.get(ingredient);
	}
}
