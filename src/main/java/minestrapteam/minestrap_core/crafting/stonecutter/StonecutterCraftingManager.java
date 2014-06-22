package minestrapteam.minestrap_core.crafting.stonecutter;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StonecutterCraftingManager
{
	/** The static instance of this class */
	public static final StonecutterCraftingManager	instance	= new StonecutterCraftingManager();
	
	/** A list of all the recipes added */
	private List									recipes		= new ArrayList();
	
	private StonecutterCraftingManager()
	{
		// add recipes
		this.addRecipe(new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), new Object[] { " S ", " S ", " S ", 'S', Items.stick });
		
		Object[] objects = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay };
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), objects);
		
		Collections.sort(this.recipes, new Comparator()
		{
			public int compare(IStonecutterRecipe recipe1, IStonecutterRecipe recipe2)
			{
				boolean flag1 = recipe1 instanceof StonecutterShapedRecipes;
				boolean flag2 = recipe1 instanceof StonecutterShapelessRecipes;
				boolean flag3 = recipe2 instanceof StonecutterShapedRecipes;
				boolean flag4 = recipe2 instanceof StonecutterShapelessRecipes;
				return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
			}
			
			@Override
			public int compare(Object o1, Object o2)
			{
				return this.compare((IStonecutterRecipe) o1, (IStonecutterRecipe) o2);
			}
		});
	}
	
	public StonecutterShapedRecipes addRecipe(ItemStack stack, ItemStack extraSlot, Object... data)
	{
		String s = "";
		int index = 0;
		int width = 0;
		int height = 0;
		
		if (data[index] instanceof String[])
		{
			String[] strings = (String[]) data[index++];
			
			for (String s1 : strings)
			{
				++height;
				width = s1.length();
				s += s1;
			}
		}
		else
		{
			while (data[index] instanceof String)
			{
				String s1 = (String) data[index++];
				++height;
				width = s1.length();
				s += s1;
			}
		}
		
		HashMap map;
		
		for (map = new HashMap(); index < data.length; index += 2)
		{
			Character c = (Character) data[index];
			int index1 = index + 1;
			ItemStack stack1 = null;
			
			if (data[index1] instanceof Item)
			{
				stack1 = new ItemStack((Item) data[index1]);
			}
			else if (data[index1] instanceof Block)
			{
				stack1 = new ItemStack((Block) data[index1], 1, 32767);
			}
			else if (data[index1] instanceof ItemStack)
			{
				stack1 = (ItemStack) data[index1];
			}
			
			map.put(c, stack1);
		}
		
		int len = width * height;
		ItemStack[] stacks = new ItemStack[len];
		
		for (int i = 0; i < len; ++i)
		{
			char c = s.charAt(i);
			
			if (map.containsKey(Character.valueOf(c)))
			{
				stacks[i] = ((ItemStack) map.get(Character.valueOf(c))).copy();
			}
			else
			{
				stacks[i] = null;
			}
		}
		
		StonecutterShapedRecipes recipe = new StonecutterShapedRecipes(width, height, stacks, stack, extraSlot);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public StonecutterShapelessRecipes addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
	{
		ArrayList list = new ArrayList();
		int len = data.length;
		
		for (int i = 0; i < len; ++i)
		{
			Object o = data[i];
			
			if (o instanceof ItemStack)
			{
				list.add(((ItemStack) o).copy());
			}
			else if (o instanceof Item)
			{
				list.add(new ItemStack((Item) o));
			}
			else if (o instanceof Block)
			{
				list.add(new ItemStack((Block) o));
			}
			else
			{
				throw new RuntimeException("Invalid shapeless recipy!");
			}
		}
		
		StonecutterShapelessRecipes recipe = new StonecutterShapelessRecipes(stack, list, extra);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, ItemStack extra, World world)
	{
		for (int i = 0; i < this.recipes.size(); ++i)
		{
			IStonecutterRecipe recipe = (IStonecutterRecipe) this.recipes.get(i);
			if (recipe.matches(inventory, extra, world))
			{
				return recipe.getCraftingResult(inventory, extra);
			}
		}
		
		return null;
	}
	
	public List getRecipeList()
	{
		return this.recipes;
	}
}
