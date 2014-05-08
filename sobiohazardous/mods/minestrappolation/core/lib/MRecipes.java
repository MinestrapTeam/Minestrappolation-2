package sobiohazardous.mods.minestrappolation.core.lib;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MRecipes
{
	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MBlocks.stoneCutter), new Object[] { "CC", "CC", 'C', Blocks.cobblestone });
		
		GameRegistry.addRecipe(new ItemStack(MItems.brickStone), new Object[] { "BB", "BB", 'B', Blocks.stone });
		// TODO re-add recipes with stone brick
	}
}
