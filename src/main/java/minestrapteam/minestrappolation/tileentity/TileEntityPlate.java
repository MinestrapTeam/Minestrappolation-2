package minestrapteam.minestrappolation.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlate extends TileEntity
{
	public ItemStack	stack;
	private EntityItem	theItem;
	
	public void spawnItem(ItemStack stack)
	{
		if (!this.worldObj.isRemote)
		{
			if (stack != null && this.theItem == null)
			{
				this.theItem = new EntityItem(this.worldObj, this.xCoord + 0.5F, this.yCoord, this.zCoord + 0.5F, stack);
				this.theItem.setVelocity(0D, 0D, 0D);
				this.theItem.delayBeforeCanPickup = 1000000000;
				this.theItem.lifespan = -1;
				this.worldObj.spawnEntityInWorld(this.theItem);
			}
		}
	}
	
	public void setItem(ItemStack stack)
	{
		this.stack = stack;
		
		if (this.theItem != null)
		{
			this.theItem.setDead();
			this.theItem = null;
		}
	}
	
	@Override
	public void updateEntity()
	{
		this.spawnItem(this.stack);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		if (this.stack != null)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			this.stack.writeToNBT(nbt1);
			nbt.setTag("Item", nbt1);
		}
		
		this.setItem(null);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		if (nbt.hasKey("Item"))
		{
			NBTTagCompound nbt1 = nbt.getCompoundTag("Item");
			this.stack = ItemStack.loadItemStackFromNBT(nbt1);
		}
	}
}
