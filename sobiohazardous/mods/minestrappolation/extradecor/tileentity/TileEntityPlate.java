package sobiohazardous.mods.minestrappolation.extradecor.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlate extends TileEntity
{
	int			itemNumbersSpawned	= 0;
	EntityItem	item;
	
	public void render(boolean render, ItemStack currItem)
	{
		if (render)
		{
			if (!this.worldObj.isRemote)
			{
				
				this.item = new EntityItem(this.worldObj, this.xCoord + .5, this.yCoord + 1, this.zCoord + .5, currItem);
				this.item.setVelocity(0D, 0D, 0D);
				if (this.itemNumbersSpawned == 0)
				{
					this.worldObj.spawnEntityInWorld(this.item);
					this.itemNumbersSpawned = 1;
				}
				this.item.delayBeforeCanPickup = 1000000000;
				
			}
		}
	}
	
	@Override
	public void updateEntity()
	{
		this.render(true, new ItemStack(Items.bone));
		
	}
}
