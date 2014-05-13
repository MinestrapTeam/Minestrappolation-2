package com.minestrappolation.core.creativetab;

import com.minestrappolation.core.lib.MCBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class MCCreativeTabStone extends CreativeTabs
{
	public MCCreativeTabStone(int id, String label)
	{
		super(id, label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(MCBlocks.stoneCutter);
	}
}