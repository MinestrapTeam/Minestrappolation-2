package sobiohazardous.minestrappolation.extraores.tileentity;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.BlockCopper;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCopper extends TileEntity
{
    private int daysPassed = 0;
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
    	if(worldObj.getWorldTime() == 12520)
        {
        	this.daysPassed += 1;
        }
    	
    	if(this.daysPassed ==3)
        {
        	this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, ExtraOres.CopperBlockTarnished.blockID);
        }
    }
}
