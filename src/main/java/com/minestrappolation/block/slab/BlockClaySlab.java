package com.minestrappolation.block.slab;

import com.minestrappolation.lib.MBlocks;
import com.minestrappolation_core.block.MCBlockMultiSlab;

import net.minecraft.item.Item;

public class BlockClaySlab extends MCBlockMultiSlab
{
	public BlockClaySlab(boolean isDouble, String[] sideIconNames, String[] topIconNames)
	{
		super(isDouble, sideIconNames, topIconNames);
	}
	
	@Override
	public Item getItem(int metadata)
	{
		if (this == MBlocks.claySlabsDouble1)
		{
			return Item.getItemFromBlock(MBlocks.claySlabsSingle1);
		}
		else if (this == MBlocks.claySlabsDouble2)
		{
			return Item.getItemFromBlock(MBlocks.claySlabsSingle2);
		}
		else if (this == MBlocks.claySlabsDouble3)
		{
			return Item.getItemFromBlock(MBlocks.claySlabsSingle3);
		}
		else if (this == MBlocks.claySlabsDouble4)
		{
			return Item.getItemFromBlock(MBlocks.claySlabsSingle4);
		}
		else if (this == MBlocks.refinedClaySlabsDouble1)
		{
			return Item.getItemFromBlock(MBlocks.refinedClaySlabsSingle1);
		}
		else if (this == MBlocks.refinedClaySlabsDouble2)
		{
			return Item.getItemFromBlock(MBlocks.refinedClaySlabsSingle2);
		}
		else if (this == MBlocks.refinedClaySlabsDouble3)
		{
			return Item.getItemFromBlock(MBlocks.refinedClaySlabsSingle3);
		}
		else if (this == MBlocks.refinedClaySlabsDouble4)
		{
			return Item.getItemFromBlock(MBlocks.refinedClaySlabsSingle4);
		}
		return Item.getItemFromBlock(this);
	}
}
