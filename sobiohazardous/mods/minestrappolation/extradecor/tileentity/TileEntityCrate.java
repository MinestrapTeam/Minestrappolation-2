package sobiohazardous.mods.minestrappolation.extradecor.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;

public class TileEntityCrate extends TileEntityInventory
{
	public TileEntityCrate()
	{
		super(18);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 18;
	}
}