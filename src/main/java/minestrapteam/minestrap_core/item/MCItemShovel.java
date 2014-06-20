package minestrapteam.minestrap_core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MCItemShovel extends MCItemTool
{
	public MCItemShovel(ToolMaterial material)
	{
		this(material, false);
	}
	
	public MCItemShovel(ToolMaterial material, boolean ignites)
	{
		super(ItemDataSpade.baseDamage, material, ItemDataSpade.blocksEffectiveAgainst, "shovel", ignites);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
