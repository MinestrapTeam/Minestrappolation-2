package minestrapteam.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;

public class TileEntityArcaneForge extends TileEntityInventory
{
	public TileEntityArcaneForge()
	{
		super(12);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 12;
	}
}
