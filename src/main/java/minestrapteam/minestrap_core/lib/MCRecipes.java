package minestrapteam.minestrap_core.lib;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MCRecipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(MCBlocks.stoneCutter), new Object[] { "CC", "CC", 'C', Blocks.cobblestone });
		GameRegistry.addRecipe(new ItemStack(MCItems.brickStone), new Object[] { "BB", "BB", 'B', Blocks.stone });
		GameRegistry.addRecipe(new ItemStack(MCItems.brickSandstone), new Object[] { "BB", "BB", 'B', Blocks.sandstone });
		GameRegistry.addSmelting(Blocks.sandstone, new ItemStack(MCItems.brickSandstone, 4), 0.8F);
	}
}
