package sobiohazardous.minestrappolation.extradecor.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlate extends TileEntity 
{
	public void render(boolean render, ItemStack currItem)
	{
		if(render)
		{
			if(!this.worldObj.isRemote)
			{
				EntityItem item = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, currItem);
				this.worldObj.spawnEntityInWorld(item);
				item.posX = this.xCoord;
				item.posY = this.yCoord;
				item.posZ = this.zCoord;
			}
		}
	}
	
	public void updateEntity()
	{
		
	}
}
