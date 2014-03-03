package sobiohazardous.minestrappolation.extradecor.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlate extends TileEntity 
{
	int itemNumbersSpawned = 0;
	EntityItem item;
	public void render(boolean render, ItemStack currItem)
	{
		if(render)
		{
			if(!this.worldObj.isRemote)
			{
				
				item = new EntityItem(this.worldObj, this.xCoord+.5, this.yCoord+1, this.zCoord+.5, currItem);
				item.setVelocity(0D, 0D, 0D);
				if(this.itemNumbersSpawned == 0){
					this.worldObj.spawnEntityInWorld(item);
					this.itemNumbersSpawned = 1;
				}				
				item.delayBeforeCanPickup = 1000000000;
			
			}
		}
	}
	
	public void updateEntity()
	{
		render(true,new ItemStack(Item.bone));
		
	}
}
