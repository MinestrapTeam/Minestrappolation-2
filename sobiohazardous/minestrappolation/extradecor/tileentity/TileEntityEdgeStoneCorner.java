package sobiohazardous.minestrappolation.extradecor.tileentity;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityEdgeStoneCorner extends TileEntity
{
	private long ticks = 0;
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
    	
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,3,2);
		}else
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,2,2);
		}else
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,0,2);
		}else
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,1,2);
		}else{
			if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,4,2);
	    	}
			if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,6,2);
	    	}
			if(this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,7,2);
	    	}
			if(this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner.blockID,5,2);
	    	}
			
			if(this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick.blockID);
			}
			if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) == Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) == Block.stoneBrick.blockID){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick.blockID);
			}
		}
 
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) != Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) != Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) != Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) != Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick.blockID);
    		
		}
    	
    /*	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord+1) != Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord+1, this.yCoord, this.zCoord) != Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick.blockID);
		}else
    	
    	if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord-1) != Block.stoneBrick.blockID && this.worldObj.getBlockId(this.xCoord-1, this.yCoord, this.zCoord) != Block.stoneBrick.blockID){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick.blockID);
		}*/
  
    }
    
}
