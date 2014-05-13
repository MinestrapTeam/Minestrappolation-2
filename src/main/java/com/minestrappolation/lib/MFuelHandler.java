package com.minestrappolation.lib;

import cpw.mods.fml.common.IFuelHandler;

import net.minecraft.item.ItemStack;

public class MFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == MItems.Plutonium)
		{
			return 35000;
		}
		if (fuel.getItem() == MItems.Uranium)
		{
			return 30000;
		}
		if (fuel.getItem() == MItems.guano)
		{
			return 2000;
		}
		return 0;
	}
}
