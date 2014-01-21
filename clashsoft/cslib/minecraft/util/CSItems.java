package clashsoft.cslib.minecraft.util;

import clashsoft.cslib.minecraft.item.datatools.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

/**
 * The Class CSItems.
 * <p>
 * This class adds several utils for adding items.
 * 
 *  @author Clashsoft
 */
public class CSItems
{
	
	/**
	 * Adds an Item without recipe.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 */
	public static void addItem(Item item, String name)
	{
		GameRegistry.registerItem(item, name.replace(" ", ""));
		LanguageRegistry.addName(item, name);
	}
	
	/**
	 * Adds an Item with a shaped recipe.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addItemWithRecipe(Item item, String name, int craftingAmount, Object... recipe)
	{
		addItem(item, name);
		CSCrafting.addCrafting(new ItemStack(item, craftingAmount), recipe);
	}
	
	/**
	 * Adds an Item with a shapeless recipe.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addItemWithShapelessRecipe(Item item, String name, int craftingAmount, Object... recipe)
	{
		addItem(item, name);
		CSCrafting.addShapelessCrafting(new ItemStack(item, craftingAmount), recipe);
	}
	
	/**
	 * Adds an armor item with a shaped recipe.
	 * 
	 * @see CSCrafting#addArmorRecipe(ItemStack, ItemStack, int)
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param stick
	 *            the stick
	 * @param type
	 *            the type
	 */
	public static void addArmor(Item item, String name, ItemStack material, int type)
	{
		addItem(item, name);
		CSCrafting.addArmorRecipe(new ItemStack(item), material, type);
	}
	
	/**
	 * Adds a tool with automatic shaped recipe.
	 * 
	 * @see CSItems#addTool(Item, String, ItemStack, ItemStack, int)
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param type
	 *            the type
	 */
	public static void addTool(Item item, String name, ItemStack material, int type)
	{
		addTool(item, name, material, CSCrafting.STICK, type);
	}
	
	/**
	 * Adds a tool with automatic shaped recipe.
	 * 
	 * @see CSCrafting#addToolRecipe(ItemStack, ItemStack, int)
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param stick
	 *            the stick
	 * @param type
	 *            the type
	 */
	public static void addTool(Item item, String name, ItemStack material, ItemStack stick, int type)
	{
		addItem(item, name);
		CSCrafting.addToolRecipe(new ItemStack(item), material, stick, type);
	}
	
	/**
	 * Adds a tool material, can also be applied to a tool set.
	 * 
	 * @param name
	 *            the name
	 * @param harvestLevel
	 *            the harvest level
	 * @param maxUses
	 *            the max uses
	 * @param efficiency
	 *            the efficiency
	 * @param damage
	 *            the damage
	 * @param enchantability
	 *            the enchantability
	 * @param color
	 *            the color
	 * @param recipe
	 *            the recipe
	 * @param dataToolSet
	 *            the data tool set
	 * @return the enum tool material
	 */
	public static EnumToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, int color, ItemStack recipe, DataToolSet dataToolSet)
	{
		EnumToolMaterial var1 = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
		if (dataToolSet != null)
			dataToolSet.registerToolMaterial(var1, name);
		return var1;
	}
	
	/**
	 * The Class DataToolSet.
	 */
	public static class DataToolSet
	{
		
		/** The sword. */
		public ItemDataSword sword;
		
		/** The shovel. */
		public ItemDataSpade shovel;
		
		/** The pickaxe. */
		public ItemDataPickaxe pickaxe;
		
		/** The axe. */
		public ItemDataAxe axe;
		
		/** The hoe. */
		public ItemDataHoe hoe;
		
		/**
		 * Instantiates a new data tool set.
		 * 
		 * @param sword
		 *            the sword
		 * @param shovel
		 *            the shovel
		 * @param pickaxe
		 *            the pickaxe
		 * @param axe
		 *            the axe
		 * @param hoe
		 *            the hoe
		 */
		public DataToolSet(ItemDataSword sword, ItemDataSpade shovel, ItemDataPickaxe pickaxe, ItemDataAxe axe, ItemDataHoe hoe)
		{
			this.sword = sword;
			this.shovel = shovel;
			this.pickaxe = pickaxe;
			this.axe = axe;
			this.hoe = hoe;
		}
		
		/**
		 * Register tool material.
		 * 
		 * @param material
		 *            the material
		 * @param name
		 *            the name
		 */
		public void registerToolMaterial(EnumToolMaterial material, String name)
		{
			this.sword.registerMaterial(material, name);
			this.shovel.registerMaterial(material, name);
			this.pickaxe.registerMaterial(material, name);
			this.axe.registerMaterial(material, name);
			this.hoe.registerMaterial(material, name);
		}
	}
}
