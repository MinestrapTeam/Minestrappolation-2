package sobiohazardous.mods.minestrappolation.extradecor.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrate extends TileEntity implements IInventory
{
	
	private ItemStack[]	inventory;
	private String		name;
	
	public TileEntityCrate()
	{
		this.inventory = new ItemStack[18];
	}
	
	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slotIndex)
	{
		return this.inventory[slotIndex];
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inventory[slot] = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = this.getStackInSlot(slotIndex);
		
		if (stack != null)
		{
			if (stack.stackSize <= amount)
			{
				this.setInventorySlotContents(slotIndex, null);
			}
			else
			{
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0)
				{
					this.setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return stack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = this.getStackInSlot(slotIndex);
		
		if (stack != null)
		{
			this.setInventorySlotContents(slotIndex, null);
		}
		return stack;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5) < 64;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		NBTTagList var2 = p_145839_1_.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];
		
		if (p_145839_1_.hasKey("CustomName", 8))
		{
			this.name = p_145839_1_.getString("CustomName");
		}
		
		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = var2.getCompoundTagAt(var3);
			int var5 = var4.getByte("Slot") & 255;
			
			if (var5 >= 0 && var5 < this.inventory.length)
			{
				this.inventory[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);
		NBTTagList var2 = new NBTTagList();
		
		for (int var3 = 0; var3 < this.inventory.length; ++var3)
		{
			if (this.inventory[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.inventory[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}
		
		p_145841_1_.setTag("Items", var2);
		
		if (this.hasCustomInventoryName())
		{
			p_145841_1_.setString("CustomName", this.name);
		}
	}
	
	@Override
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.name : "tileEntity.crate";
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return true;
	}
	
	@Override
	public void closeInventory()
	{
	}
	
	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}
	
	@Override
	public void openInventory()
	{
	}
}