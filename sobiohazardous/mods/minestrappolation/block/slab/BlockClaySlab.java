package sobiohazardous.mods.minestrappolation.block.slab;

import sobiohazardous.mods.minestrappolation.core.block.MCBlockMultiSlab;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

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
		if (this == EDBlocks.claySlabsDouble1)
			return Item.getItemFromBlock(EDBlocks.claySlabsSingle1);
		else if (this == EDBlocks.claySlabsDouble2)
			return Item.getItemFromBlock(EDBlocks.claySlabsSingle2);
		else if (this == EDBlocks.claySlabsDouble3)
			return Item.getItemFromBlock(EDBlocks.claySlabsSingle3);
		else if (this == EDBlocks.claySlabsDouble4)
			return Item.getItemFromBlock(EDBlocks.claySlabsSingle4);
		
		else if (this == EDBlocks.refinedClaySlabsDouble1)
			return Item.getItemFromBlock(EDBlocks.refinedClaySlabsSingle1);
		else if (this == EDBlocks.refinedClaySlabsDouble2)
			return Item.getItemFromBlock(EDBlocks.refinedClaySlabsSingle2);
		else if (this == EDBlocks.refinedClaySlabsDouble3)
			return Item.getItemFromBlock(EDBlocks.refinedClaySlabsSingle3);
		else if (this == EDBlocks.refinedClaySlabsDouble4)
			return Item.getItemFromBlock(EDBlocks.refinedClaySlabsSingle4);
		return Item.getItemFromBlock(this);
	}
}
