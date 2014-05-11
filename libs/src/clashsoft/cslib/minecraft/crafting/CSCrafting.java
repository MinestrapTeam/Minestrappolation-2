package clashsoft.cslib.minecraft.crafting;

import static clashsoft.cslib.minecraft.item.CSStacks.air;
import static clashsoft.cslib.minecraft.item.CSStacks.coal;
import static clashsoft.cslib.minecraft.item.CSStacks.fire;
import static clashsoft.cslib.minecraft.item.CSStacks.stick;

import java.util.HashMap;
import java.util.Map;

import clashsoft.cslib.minecraft.item.meta.ISubItemRecipe;
import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;

/**
 * The Class CSCrafting.
 * <p>
 * This class adds several utils for adding crafting and furnace recipes and
 * analyzing them.
 * 
 * @author Clashsoft
 */
public class CSCrafting
{
	public static void registerRecipe(IRecipe recipe)
	{
		CraftingManager.getInstance().getRecipeList().add(recipe);
	}
	
	/**
	 * Adds a new shaped crafting recipe to the game.
	 * <p>
	 * Save for adding advanced recipes (bigger than 3x3)
	 * 
	 * @param output
	 *            the output
	 * @param recipe
	 *            the recipe
	 * @return the ShapedRecipe instance created
	 * @see CSCrafting#addAdvancedRecipe(ItemStack, Object...)
	 */
	public static ShapedRecipes addRecipe(ItemStack output, Object... recipe)
	{
		return addAdvancedRecipe(output, recipe);
	}
	
	public static ShapedRecipes addAdvancedRecipe(ItemStack output, Object... recipe)
	{
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		
		if (recipe[i] instanceof String[])
		{
			String[] astring = (String[]) recipe[i++];
			
			for (String s1 : astring)
			{
				++k;
				j = s1.length();
				s = s + s1;
			}
		}
		else
		{
			while (recipe[i] instanceof String)
			{
				String s2 = (String) recipe[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}
		
		HashMap hashmap;
		
		for (hashmap = new HashMap(); i < recipe.length; i += 2)
		{
			Character character = (Character) recipe[i];
			ItemStack itemstack1 = null;
			
			if (recipe[i + 1] instanceof Item)
			{
				itemstack1 = new ItemStack((Item) recipe[i + 1]);
			}
			else if (recipe[i + 1] instanceof Block)
			{
				itemstack1 = new ItemStack((Block) recipe[i + 1], 1, 32767);
			}
			else if (recipe[i + 1] instanceof ItemStack)
			{
				itemstack1 = (ItemStack) recipe[i + 1];
			}
			
			hashmap.put(character, itemstack1);
		}
		
		ItemStack[] stacks = new ItemStack[j * k];
		
		for (int i1 = 0; i1 < j * k; ++i1)
		{
			char c0 = s.charAt(i1);
			
			if (hashmap.containsKey(Character.valueOf(c0)))
			{
				stacks[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			}
			else
			{
				stacks[i1] = null;
			}
		}
		
		ShapedRecipes shapedrecipes = new ShapedAdvancedRecipe(j, k, stacks, output);
		
		registerRecipe(shapedrecipes);
		return shapedrecipes;
	}
	
	/**
	 * Adds a new shapeless crafting recipe to the game.
	 * 
	 * @param output
	 *            the output
	 * @param recipe
	 *            the recipe
	 * @see GameRegistry#addShapelessRecipe(ItemStack, Object...)
	 */
	public static void addShapelessRecipe(ItemStack output, Object... recipe)
	{
		GameRegistry.addShapelessRecipe(output, recipe);
	}
	
	/**
	 * Adds a new furnace recipe to the game.
	 * 
	 * @param input
	 *            the input
	 * @param output
	 *            the output
	 * @param experience
	 *            the experience
	 * @see FurnaceRecipes#addSmelting(int, int ItemStack, float)
	 */
	public static void addFurnaceRecipe(ItemStack input, ItemStack output, float experience)
	{
		FurnaceRecipes.smelting().func_151394_a(input, output, experience);
	}
	
	/**
	 * Adds a recipe for a storage block. The size can be
	 * <p>
	 * 1:<br>
	 * [X] -> [O]
	 * <p>
	 * 2:<br>
	 * [X][X]<br>
	 * [X][X] -> [O]
	 * <p>
	 * 3:
	 * <p>
	 * [X][X][X]<br>
	 * [X][X][X] -> [O]<br>
	 * [X][X][X]
	 * 
	 * @param material
	 *            the input
	 * @param block
	 *            the output
	 * @param size
	 *            the size of the recipe
	 */
	public static void addStorageBlock(ItemStack material, ItemStack block, int size)
	{
		if (size == 1)
		{
			addShapelessRecipe(block, material);
			addShapelessRecipe(material, block);
		}
		else if (size == 2)
		{
			ItemStack copy = material.copy();
			copy.stackSize = 4;
			addShapelessRecipe(copy, block);
			addRecipe(block, "XX", "XX", 'X', material);
		}
		else if (size == 3)
		{
			ItemStack copy = material.copy();
			copy.stackSize = 9;
			addShapelessRecipe(copy, block);
			addRecipe(block, "XXX", "XXX", "XXX", 'X', material);
		}
		else
		{
			throw new IllegalArgumentException("The size of a storage block recipe should be either 1, 2 or 3");
		}
	}
	
	/**
	 * Adds a new wooden stick-shaped recipe to the game.
	 * 
	 * @param output
	 *            the stick item stack
	 * @param input
	 *            the planks item stack
	 */
	public static void addStick(ItemStack output, ItemStack input)
	{
		addRecipe(output, "s", "s", 's', input);
	}
	
	/**
	 * Adds a new wood-planks-shaped recipe to the game.
	 * 
	 * @param output
	 *            the planks item stack
	 * @param input
	 *            the log item stack
	 */
	public static void addPlanks(ItemStack output, ItemStack input)
	{
		addShapelessRecipe(output, input);
	}
	
	/**
	 * Adds a new armor-shaped recipe to the game. (Type 0 = Helmet, Type 1 =
	 * Chestplate, Type 2 = Leggings, Type 3 = Boots, Type 4 = Gloves)
	 * 
	 * @param output
	 *            the output
	 * @param input
	 *            the material
	 * @param type
	 *            the armor type
	 */
	public static void addArmorRecipe(ItemStack output, ItemStack input, int type)
	{
		if (type == 0)
		{
			addRecipe(output, new Object[] { "XXX", "X X", Character.valueOf('X'), input });
		}
		else if (type == 1)
		{
			addRecipe(output, new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'), input });
		}
		else if (type == 2)
		{
			addRecipe(output, new Object[] { "XXX", "X X", "X X", Character.valueOf('X'), input });
		}
		else if (type == 3)
		{
			addRecipe(output, new Object[] { "X X", "X X", Character.valueOf('X'), input });
		}
		else if (type == 4)
		{
			addRecipe(output, new Object[] { "X X", 'X', input });
		}
	}
	
	/**
	 * @see CSCrafting#addToolRecipe(ItemStack, ItemStack, ItemStack, int)
	 * @param output
	 *            the output
	 * @param material
	 *            the material
	 * @param type
	 *            the tool type
	 */
	public static void addToolRecipe(ItemStack output, ItemStack material, int type)
	{
		addToolRecipe(output, material, stick, type);
	}
	
	/**
	 * Adds a new tool-shaped recipe to the game.
	 * <p>
	 * Type 0 = Sword, Type 1 = Spade, Type 2 = Pickaxe, Type 3 = Axe, Type 4 =
	 * Hoe
	 * 
	 * @param output
	 *            the output
	 * @param material
	 *            the material
	 * @param stick
	 *            the stick material
	 * @param type
	 *            the tool type
	 */
	public static void addToolRecipe(ItemStack output, ItemStack material, ItemStack stick, int type)
	{
		if (type == 0)
		{
			addRecipe(output, "X", "X", "|", 'X', material, '|', stick);
		}
		else if (type == 1)
		{
			addRecipe(output, "X", "|", "|", 'X', material, '|', stick);
		}
		else if (type == 2)
		{
			addRecipe(output, "XXX", " | ", " | ", 'X', material, '|', stick);
		}
		else if (type == 3)
		{
			addRecipe(output, "XX ", "X| ", " | ", 'X', material, '|', stick);
		}
		else if (type == 4)
		{
			addRecipe(output, "XX", " |", " |", 'X', material, '|', stick);
		}
	}
	
	/**
	 * Removes a recipe from the game.
	 * 
	 * @param recipe
	 *            Recipe to remove
	 */
	public static void removeRecipe(Object... recipe)
	{
		addRecipe(air, recipe);
	}
	
	/**
	 * Registers an ore to the ore dictionary.
	 * 
	 * @see OreDictionary
	 * @see OreDictionary#registerOre(String, ItemStack)
	 * @param name
	 *            the name
	 * @param ore
	 *            the ore
	 * @return the item stack
	 */
	public static ItemStack registerOre(String name, ItemStack ore)
	{
		OreDictionary.registerOre(name, ore);
		return ore;
	}
	
	/**
	 * Analyzes a crafting recipe, mainly used for recipe displays. Depending on
	 * the recipe type, the output is either
	 * <p>
	 * [1][2][ ] Any shape possible
	 * <p>
	 * [3][4][ ] # = how you need to put the items in the crafting table
	 * <p>
	 * [ ][ ][5]
	 * <p>
	 * <p>
	 * for shaped recipes,
	 * <p>
	 * <p>
	 * [1][2][3] # = objects in shaped recipe list
	 * <p>
	 * [4][5][ ]
	 * <p>
	 * [ ][ ][ ]
	 * <p>
	 * <p>
	 * for shapeless recipes or
	 * <p>
	 * <p>
	 * [ ][o][ ] o = output
	 * <p>
	 * [ ][f][ ] f = fire
	 * <p>
	 * [ ][c][ ] c = coal
	 * <p>
	 * <p>
	 * for furnace recipes.
	 * 
	 * @param recipe
	 *            the recipe
	 * @return the item stack[][]
	 */
	public static ItemStack[][] analyseCrafting(ISubItemRecipe recipe)
	{
		try
		{
			if (recipe.getCraftingType() == ISubItemRecipe.FURNACE)
			{
				return new ItemStack[][] { { null, (ItemStack) recipe.getData()[0], null }, { null, fire, null }, { null, coal, null } };
			}
			else if (recipe.getCraftingType() == ISubItemRecipe.CRAFTING_SHAPELESS)
			{
				ItemStack[][] ret = new ItemStack[3][3];
				
				for (int i = 0; i < recipe.getData().length; i++)
				{
					int x = i / 3 % 3;
					int y = i % 3;
					ret[x][y] = (ItemStack) recipe.getData()[i];
				}
				
				return ret;
			}
			else if (recipe.getCraftingType() == ISubItemRecipe.CRAFTING)
			{
				return analyseCraftingShaped(recipe.getData());
			}
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
		}
		return new ItemStack[][] { { null, null, null }, { null, null, null }, { null, null, null } };
	}
	
	/**
	 * Analyzes a shaped crafting recipe.
	 * 
	 * @param recipe
	 *            the recipe
	 * @return the item stack[][]
	 */
	public static ItemStack[][] analyseCraftingShaped(Object... recipe)
	{
		String s = "";
		int i = 0;
		int j = 0; // Width
		int k = 0; // Height
		
		if (recipe[i] instanceof String[])
		{
			String[] astring = (String[]) recipe[i++];
			
			k = astring.length;
			for (String s1 : astring)
			{
				j = s1.length();
				s = s + s1;
			}
		}
		else
		{
			while (recipe[i] instanceof String)
			{
				String s2 = (String) recipe[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}
		
		Map<Character, ItemStack> hashmap = new HashMap<Character, ItemStack>();
		
		for (; i < recipe.length; i += 2)
		{
			Character character = (Character) recipe[i];
			ItemStack itemstack1 = null;
			
			if (recipe[i + 1] instanceof Item)
			{
				itemstack1 = new ItemStack((Item) recipe[i + 1]);
			}
			else if (recipe[i + 1] instanceof Block)
			{
				itemstack1 = new ItemStack((Block) recipe[i + 1], 1, OreDictionary.WILDCARD_VALUE);
			}
			else if (recipe[i + 1] instanceof ItemStack)
			{
				itemstack1 = (ItemStack) recipe[i + 1];
			}
			
			hashmap.put(character, itemstack1);
		}
		
		ItemStack[][] ret = new ItemStack[3][3];
		
		for (int j1 = 0; j1 < j; ++j1)
		{
			for (int k1 = 0; k1 < k; ++k1)
			{
				int i1 = k1 * j + j1;
				char c0 = s.charAt(i1 % s.length());
				
				if (hashmap.containsKey(c0))
				{
					ret[k1 % 3][j1 % 3] = hashmap.get(c0).copy();
				}
				else
				{
					ret[k1 % 3][j1 % 3] = null;
				}
			}
		}
		return ret;
	}
}
