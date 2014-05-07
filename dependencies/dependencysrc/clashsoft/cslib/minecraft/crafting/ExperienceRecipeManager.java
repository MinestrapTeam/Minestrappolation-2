package clashsoft.cslib.minecraft.crafting;

import gnu.trove.map.hash.TCustomHashMap;

import java.util.Map;

import clashsoft.cslib.minecraft.util.ItemStackHashingStrategy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExperienceRecipeManager extends SimpleRecipeManager
{
	private Map<ItemStack, Float>			experienceMap	= new TCustomHashMap(ItemStackHashingStrategy.instance);
	
	@Override
	public void addRecipe(ItemStack input, ItemStack output)
	{
		this.addRecipe(input, output, 0F);
	}
	
	public void addRecipe(Block block, ItemStack output, float exp)
	{
		this.addRecipe(new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE), output, exp);
	}
	
	public void addRecipe(Item item, ItemStack output, float exp)
	{
		this.addRecipe(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE), output, exp);
	}
	
	public void addRecipe(ItemStack input, ItemStack output, float exp)
	{
		super.addRecipe(input, output);
		this.experienceMap.put(output.copy(), Float.valueOf(exp));
	}
	
	public float getExp(ItemStack input)
	{
		float ret = input.getItem().getSmeltingExperience(input);
		if (ret != -1.0F)
			return ret;
		
		Float f = this.experienceMap.get(input);
		return f == null ? 0F : f.floatValue();
	}
}
