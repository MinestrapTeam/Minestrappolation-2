package minestrapteam.minestrappolation.inventory;

import clashsoft.cslib.minecraft.inventory.SlotOutput;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.crafting.FreezerRecipes;
import minestrapteam.minestrappolation.tileentity.TileEntityFreezer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFreezer extends Container
{
	public TileEntityFreezer	freezer;
	private int					lastFreezeTime;
	private int					lastEnergyTime;
	private int					lastMaxEnergyTime;
	
	public ContainerFreezer(InventoryPlayer inventory, TileEntityFreezer freezer)
	{
		this.freezer = freezer;
		this.addSlotToContainer(new Slot(freezer, 0, 56, 17));
		this.addSlotToContainer(new Slot(freezer, 1, 56, 53));
		this.addSlotToContainer(new SlotOutput(freezer, 2, 116, 35));
		int i;
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.freezer.freezeTime);
		crafting.sendProgressBarUpdate(this, 1, this.freezer.energyTime);
		crafting.sendProgressBarUpdate(this, 2, this.freezer.maxEnergyTime);
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastFreezeTime != this.freezer.freezeTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.freezer.freezeTime);
			}
			
			if (this.lastEnergyTime != this.freezer.energyTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.freezer.energyTime);
			}
			
			if (this.lastMaxEnergyTime != this.freezer.maxEnergyTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, this.freezer.maxEnergyTime);
			}
		}
		
		this.lastFreezeTime = this.freezer.freezeTime;
		this.lastEnergyTime = this.freezer.energyTime;
		this.lastMaxEnergyTime = this.freezer.maxEnergyTime;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int value)
	{
		if (id == 0)
		{
			this.freezer.freezeTime = value;
		}
		
		if (id == 1)
		{
			this.freezer.energyTime = value;
		}
		
		if (id == 2)
		{
			this.freezer.maxEnergyTime = value;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.freezer.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotID == 2)
			{
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotID != 1 && slotID != 0)
			{
				if (FreezerRecipes.instance.getResult(itemstack1) != null)
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if (TileEntityFreezer.isItemFuel(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}
				else if (slotID >= 3 && slotID < 30)
				{
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if (slotID >= 30 && slotID < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
}