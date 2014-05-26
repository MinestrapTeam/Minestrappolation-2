package com.minestrappolation_core.block;

import net.minecraft.util.IIcon;

public class BlockStoneClay extends MCBlockStoneCustom
{
	public BlockStoneClay(String[] types, String name, float baseHardness)
	{
		super(types, name, baseHardness);
	}

	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 6 && chiseledSided)
		{
			if (side == 0 || side == 1)
				return this.refinedIcon;
			else
				return this.chiseledSideIcon;
		}
		return super.getIcon(side, metadata);
	}
}
