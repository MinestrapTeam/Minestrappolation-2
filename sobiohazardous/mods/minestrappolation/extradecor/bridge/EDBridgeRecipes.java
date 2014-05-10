package sobiohazardous.mods.minestrappolation.extradecor.bridge;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * This class loads recipes that use other mods from Minestrappolation
 * 
 * @author SoBiohazardous
 */
public class EDBridgeRecipes
{
	private static boolean	hasExtraOres	= Loader.isModLoaded(MReference.EO_MODID);
	
	public static void loadBridgeRecipes() throws Exception
	{
		if (hasExtraOres)
		{
			GameRegistry.addRecipe(new ItemStack(EDBlocks.stoneLamp, 8, 1), new Object[] { "SSS", "SGS", "SSS", 'S', new ItemStack(EDBlocks.stones, 1, 1), 'G', EOBlocks.Sunstone });
			
			GameRegistry.addRecipe(new ItemStack(EDBlocks.bedrockBrick, 4), new Object[] { "SS", "SS", 'S', Blocks.bedrock });
		}
	}	
}
