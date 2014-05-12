package com.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;

public class TileEntityBarrel extends TileEntityInventory
{
	public TileEntityBarrel()
	{
		super(36);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 36;
	}
}