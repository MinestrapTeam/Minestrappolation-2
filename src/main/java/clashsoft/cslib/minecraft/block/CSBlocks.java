package clashsoft.cslib.minecraft.block;

import clashsoft.cslib.minecraft.crafting.CSCrafting;
import clashsoft.cslib.minecraft.item.block.ItemCustomBlock;
import clashsoft.cslib.reflect.CSReflection;
import cpw.mods.fml.common.registry.GameRegistry;

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
	 * Overrides a vanilla block by registering it with the mod id "minecraft". This calls
	 * {@link CSBlocks#addBlock(Block, Class, String)} with {@link ItemCustomBlock}.{@code class} as
	 * the {@code itemClass} argument.
	 * 
	 * @param block
	 *            the new block
	 * @param name
	 *            the name
	 */
	public static void overrideBlock(Block block, String name)
	{
		overrideBlock(block, ItemCustomBlock.class, name);
	}
	
	/**
	 * Overrides a vanilla block by registering it with the mod id "minecraft".
	 * 
	 * @param block
	 *            the new block
	 * @param itemClass
	 *            the item class
	 * @param name
	 *            the name
	 */
	public static void overrideBlock(Block block, Class<? extends ItemBlock> itemClass, String name)
	{
		GameRegistry.registerBlock(block, itemClass, name, "minecraft", new Object[0]);
	}
	
	public static void addAllBlocks(Class mod)
	{
		Block[] blocks = CSReflection.getStaticObjects(mod, Block.class, true);
		
		for (Block block : blocks)
		{
			addBlock(block);
		}
	}
	
	public static void addBlock(Block block)
	{
		String name = block.getUnlocalizedName();
		if (name.startsWith("tile."))
		{
			name = name.substring(5);
		}
		addBlock(block, name);
	}
	
	/**
	 * Registers a Block and its name. This calls {@link CSBlocks#addBlock(Block, Class, String)}
	 * with {@link ItemCustomBlock}.{@code class} as the {@code itemClass} argument.
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
		name = clashsoft.cslib.util.CSString.identifier(name);
		GameRegistry.registerBlock(block, itemClass, name);
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
