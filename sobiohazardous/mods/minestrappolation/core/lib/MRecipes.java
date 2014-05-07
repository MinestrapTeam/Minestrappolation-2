package sobiohazardous.mods.minestrappolation.core.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MRecipes
{
	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MBlocks.stoneCutter), new Object[]
				{
			"II", "CC", "CC", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('I'), Items.iron_ingot
				});
		//TODO re-add recipes with stone brick
	}
}
