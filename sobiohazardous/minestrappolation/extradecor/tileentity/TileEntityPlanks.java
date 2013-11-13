package sobiohazardous.minestrappolation.extradecor.tileentity;

import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDConfig;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlanks extends TileEntity
{
    private int daysPassed = 0;
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
    	if(worldObj.getWorldTime() == 12521)
        {
        	this.daysPassed += 1;
        }
    	
    	if(worldObj.getBlockMaterial(this.xCoord, this.yCoord + 1, this.zCoord) == Material.water)
    	{
    		if(this.daysPassed >= EDConfig.daysUntilMossy)
    		{
    			this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.woodPlanksMossy.blockID);
    		}
    	}
    }
}
