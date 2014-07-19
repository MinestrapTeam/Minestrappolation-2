package minestrapteam.mcore.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MCRecipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(MCBlocks.stoneCutter), new Object[] { "II", "CC", "CC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot });
	}
	
	public static void addStairRecipe(Block stairs, ItemStack material)
	{
		GameRegistry.addRecipe(new ItemStack(stairs, 4, 0), new Object[]{"M  ", "MM ", "MMM", 'M', material});
	}
}
