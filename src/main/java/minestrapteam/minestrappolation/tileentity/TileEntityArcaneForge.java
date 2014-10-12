package minestrapteam.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;

public class TileEntityArcaneForge extends TileEntityInventory
{
	/* 0 - 7: Elemental Potency
	 * 8: Category
	 * 9: Variety
	 * 10: Enhancement
	 * 11: Name 
	 */
	
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
