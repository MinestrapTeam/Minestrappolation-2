package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

import net.minecraft.block.BlockRailBase;
import net.minecraft.item.Item;

public class BlockPlate extends BlockRailBase
{
	public BlockPlate()
	{
		super(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == EOBlocks.TinPlate)
		{
			return EOItems.plateTinItem;
		}
		else if (this == EOBlocks.BronzePlate)
		{
			return EOItems.plateBronzeItem;
		}
		else if (this == EOBlocks.SteelPlate)
		{
			return EOItems.plateSteelItem;
		}
		else if (this == EOBlocks.meuroditePlate)
		{
			return EOItems.plateMeuroditeItem;
		}
		return Item.getItemFromBlock(this);
	}
}
