package sobiohazardous.mods.minestrappolation.core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MItemShovel extends MItemTool
{
	public MItemShovel(ToolMaterial material, ToolMaterial plateMaterial)
	{
		this(material, plateMaterial, false);
	}
	
	public MItemShovel(ToolMaterial material, ToolMaterial plateMaterial, boolean ignites)
	{
		super(ItemDataSpade.baseDamage, material, plateMaterial, ItemDataSpade.blocksEffectiveAgainst, "overlayToolShovelBronze", ignites);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
