package sobiohazardous.minestrappolation.api.lib;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MAPIRecipes
{
	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MAPIBlocks.stoneCutter), new Object[]
				{
			"CC", "CC", Character.valueOf('C'), Blocks.cobblestone
				});
	}
}
