package sobiohazardous.mods.minestrappolation.extradecor.container;

import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrate extends Container
{
	
	protected TileEntityCrate	tile_entity;
	
	public ContainerCrate(TileEntityCrate tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;
		
		this.bindPlayerInventory(player_inventory);
		int j;
		int k;
		
		for (j = 0; j < 2; ++j)
		{
			for (k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(tile_entity, k + j * 9, 8 + k * 18, 18 + j * 18 - 1));
			}
		}
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.tile_entity.isUseableByPlayer(player);
	}
	
	protected void bindPlayerInventory(InventoryPlayer par1IInventory)
	{
		int i = -2 * 18 - 1;
		int j;
		int k;
		for (j = 0; j < 3; ++j)
		{
			for (k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(par1IInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}
		
		for (j = 0; j < 9; ++j)
		{
			this.addSlotToContainer(new Slot(par1IInventory, j, 8 + j * 18, 161 + i));
		}
	}
	
	/*
	 * @Override public ItemStack transferStackInSlot(EntityPlayer player, int
	 * slot_index) { ItemStack stack = null; Slot slot_object = (Slot)
	 * inventorySlots.get(slot_index); if(slot_object != null &&
	 * slot_object.getHasStack()){ ItemStack stack_in_slot =
	 * slot_object.getStack(); stack = stack_in_slot.copy(); if(slot_index ==
	 * 0){ if(!mergeItemStack(stack_in_slot, 1, inventorySlots.size(), true)){
	 * return null; } } else if(!mergeItemStack(stack_in_slot, 0, 1, false)){
	 * return null; } if(stack_in_slot.stackSize == 0){
	 * slot_object.putStack(null); } else{ slot_object.onSlotChanged(); } }
	 * return stack; }
	 */
	
	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (par2 < 36)
			{
				if (!this.mergeItemStack(itemstack1, 36, this.inventorySlots.size(), false))
				{
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (!this.mergeItemStack(itemstack1, 0, 19, false))
			{
				return null;
			}
			slot.onSlotChange(itemstack1, itemstack);
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
		}
		
		return itemstack;
	}
}