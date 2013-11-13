package sobiohazardous.minestrappolation.extradecor.tileentity;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityEdgeStone extends TileEntity
{
	private long ticks = 0;
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
    	if(this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickLeft.blockID);
		}
    	
    	if(this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickRight.blockID);
		}
    	
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) == Block.stoneBrick.blockID ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickLeft.blockID);
		}
    	
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) == Block.stoneBrick.blockID ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickRight.blockID);
		}
    }
    
}
