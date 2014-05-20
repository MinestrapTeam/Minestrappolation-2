package com.minestrappolation_core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MCItemShovel extends MCItemTool
{
	public MCItemShovel(ToolMaterial material, ToolMaterial plateMaterial)
	{
		this(material, plateMaterial, false);
	}
	
	public MCItemShovel(ToolMaterial material, ToolMaterial plateMaterial, boolean ignites)
	{
		super(ItemDataSpade.baseDamage, material, plateMaterial, ItemDataSpade.blocksEffectiveAgainst, "overlayToolShovelBronze", ignites);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.snow || block == Blocks.snow_layer;
	}
}
