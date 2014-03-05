package sobiohazardous.minestrappolation.extradecor.tileentity;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
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
    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,3,2);
		}else
    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,2,2);
		}
    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,0,2);
		}else
    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,1,2);
		}else
    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
	    	this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick );
		}
    	else{
	    	if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,4,2);
	    	}
			if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,6,2);
	    	}
			if(this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,7,2);
	    	}
			if(this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrickCorner ,5,2);
	    	}
			
			if(this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick );
			}
			if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1) == Blocks.stonebrick  && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1) == Blocks.stonebrick ){
	    		this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, EDBlockManager.edgeStoneBrick );
			}
			
		}
    	
    	
    	

    	
    	
    }
    
}
