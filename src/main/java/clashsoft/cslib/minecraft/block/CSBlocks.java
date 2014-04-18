package clashsoft.cslib.minecraft.block;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import clashsoft.cslib.minecraft.crafting.CSCrafting;
import clashsoft.cslib.minecraft.item.block.ItemCustomBlock;
import clashsoft.cslib.reflect.CSReflection;
import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
	public static boolean replaceBlock(Block block, Block newBlock)
	{
		long now = System.currentTimeMillis();
		try
		{
			for (Field field : Blocks.class.getDeclaredFields())
			{
				if (Block.class.isAssignableFrom(field.getType()))
				{
					Block block1 = (Block) field.get(null);
					if (block1 == block)
					{
						FMLControlledNamespacedRegistry<Block> registry = GameData.getBlockRegistry();
						String registryName = registry.getNameForObject(block1);
						int id = Block.getIdFromBlock(block1);
						ItemBlock item = (ItemBlock) Item.getItemFromBlock(block1);
						
						// Set field
						CSReflection.setModifier(field, Modifier.FINAL, false);
						field.set(null, newBlock);
						
						// Replace registry entry
						CSReflection.invoke(FMLControlledNamespacedRegistry.class, registry, new Object[] { id, registryName, newBlock }, "addObjectRaw");
						
						// Replace ItemBlock reference
						if (item != null)
						{
							CSReflection.setValue(ItemBlock.class, item, newBlock, 0);
						}
						
						now = System.currentTimeMillis() - now;
						CSLog.info("Replace Item : %s (%s) with %s", new Object[] { field.getName(), block1.getClass().getSimpleName(), newBlock.getClass().getSimpleName(), now });
						
						return true;
					}
				}
			}
		}
		catch (Exception e)
		{
			CSLog.error(e);
		}
		return false;
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
	 * Registers a Block and its name. This calls
	 * {@link CSBlocks#addBlock(Block, Class, String)} with
	 * {@link ItemCustomBlock}.{@code class} as the {@code itemClass} argument.
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
		block.setBlockName(name);
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
		CSCrafting.addRecipe(new ItemStack(block, craftingAmount), recipe);
	}
}
