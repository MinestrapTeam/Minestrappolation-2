package com.minestrappolation.block;

import java.util.Random;

import com.minestrappolation.lib.MBlocks;
import com.minestrappolation.lib.MItems;

import net.minecraft.block.BlockRailBase;
import net.minecraft.item.Item;

public class BlockPlateMetal extends BlockRailBase
{
	public BlockPlateMetal()
	{
		super(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.TinPlate)
		{
			return MItems.plateTinItem;
		}
		else if (this == MBlocks.BronzePlate)
		{
			return MItems.plateBronzeItem;
		}
		else if (this == MBlocks.SteelPlate)
		{
			return MItems.plateSteelItem;
		}
		else if (this == MBlocks.meuroditePlate)
		{
			return MItems.plateMeuroditeItem;
		}
		return Item.getItemFromBlock(this);
	}
}
