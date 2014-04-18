package sobiohazardous.minestrappolation.extradecor.bridge;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * This class loads recipes that use other mods from minestrappolation
 * @author SoBiohazardous
 *
 */
public class EDBridgeRecipes 
{
	private static boolean hasExtraOres = Loader.isModLoaded(MAPIReference.MODID_EO);
	
	//static Block sunstone = GameRegistry.findBlock(MAPIReference.MODID_EO, "Sunstone");
	
	public static void loadBridgeRecipes() throws Exception
	{	
		if(hasExtraOres)
		{
			
			GameRegistry.addRecipe(new ItemStack(EDBlockManager.stoneLamp, 8,1), new Object[]
					{
				"SSS", "SGS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.stones,1,1), Character.valueOf('G'), sobiohazardous.minestrappolation.extraores.lib.EOBlockManager.Sunstone
					});
				
			
			GameRegistry.addRecipe(new ItemStack(EDBlockManager.bedrockBrick, 4), new Object[]
					{
				"SS", "SS", Character.valueOf('S'), Blocks.bedrock
					});
		}
	}
	
	//EXPERIMENTAL - I Tried to use reflection to refer to other mods possibly loaded or not. it failed, and turns out, forge already has it.\\
	
	/**
	 * Used for getting blocks and items from classes if they do not exist (reflection)
	 * @param pkg the package for the class
	 * @param modClassName the name of the class
	 * @param blockOrItemName the block of item you are wanting to reference
	 * @return itemstack of the block or item your referencing
	 */
	public static ItemStack getItemStackFromObject(String pkg, String modClassName, String blockOrItemName) 
	{
		try 
		{
			Class eoReflect = Class.forName(pkg + "." + modClassName);
			
			Object itemstackField = eoReflect.getField(blockOrItemName).get(null);

			if (itemstackField instanceof ItemStack)
			{
				return (ItemStack) itemstackField;
			} 
				else 
				{
					return null;
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Minestrappolation: getItemStackFromMod failed for "+blockOrItemName);

				return null;
			}
	}
		
}
