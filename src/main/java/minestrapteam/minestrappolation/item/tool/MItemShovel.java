package minestrapteam.minestrappolation.item.tool;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MItemShovel extends MItemTool
{
	public MItemShovel(ToolMaterial material)
	{
		this(material, false);
	}
	
	public MItemShovel(ToolMaterial material, boolean ignites)
	{
		super(ItemDataSpade.baseDamage, material, ItemDataSpade.blocksEffectiveAgainst, "shovel", ignites);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
