package sobiohazardous.mods.minestrappolation.extraores.tileentity;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOConfig;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCopper extends TileEntity
{
	private int	daysPassed	= 0;
	
	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	@Override
	public void updateEntity()
	{
		System.out.println(this.worldObj.getWorldTime());
		if (this.worldObj.getWorldTime() == 12521)
		{
			this.daysPassed += 1;
			// System.out.println(this.daysPassed+"/"+EOConfig.daysUntilTarnish);
		}
		
		if (this.daysPassed >= EOConfig.daysUntilTarnish)
		{
			// System.out.println(EOConfig.daysUntilTarnish);
			this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EOBlocks.CopperBlockTarnished);
		}
	}
}
