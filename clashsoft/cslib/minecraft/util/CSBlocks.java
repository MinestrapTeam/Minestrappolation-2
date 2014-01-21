package clashsoft.cslib.minecraft.util;

import clashsoft.cslib.minecraft.ItemCustomBlock;
import clashsoft.cslib.minecraft.block.ICustomBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * The Class CSBlocks.
 * <p>
 * This class adds several methods for block adding.
 * 
 * @author Clashsoft
 */
public class CSBlocks
{
	
	/**
	 * Registers a Block and its name.
	 * 
	 * @param block
	 *            the block
	 * @param name
	 *            the name
	 */
	public static void addBlock(Block block, String name)
	{
		addBlock(block, ItemCustomBlock.class, name);
	}
	
	/**
	 * Registers a Block and its name to a block item.
	 * 
	 * @param block
	 *            the block
	 * @param itemClass
	 *            the item class
	 * @param name
	 *            the name
	 */
	public static void addBlock(Block block, Class<? extends ItemBlock> itemClass, String name)
	{
		GameRegistry.registerBlock(block, itemClass, name.replace(" ", ""));
		if (block instanceof ICustomBlock)
		{
			((ICustomBlock) block).addNames();
		}
		else
		{
			LanguageRegistry.addName(block, name);
		}
	}
	
	/**
	 * Register a block with its name and an recipe for it.
	 * 
	 * @param block
	 *            the block
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addBlockWithRecipe(Block block, String name, int craftingAmount, Object... recipe)
	{
		addBlock(block, name);
		CSCrafting.addCrafting(new ItemStack(block, craftingAmount), recipe);
	}
}
