package sobiohazardous.minestrappolation.extradecor.container;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;


public class ContainerBarrel extends Container
{

protected TileEntityBarrel tile_entity;

	public ContainerBarrel(TileEntityBarrel tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;
		
		bindPlayerInventory(player_inventory);
        int j;
        int k;

        for (j = 0; j < 4; ++j)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(tile_entity, k + j * 9, 8 + k * 18, 18 + j * 18 - 10));
            }
        }

		  
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile_entity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer par1IInventory)
	{
		int i = (-2 * 18) - 2;
		int j;
		int k;
		for (j = 0; j < 3; ++j)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(par1IInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i + 28));
            }
        }

        for (j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(par1IInventory, j, 8 + j * 18, 161 + i + 28));
        }
	}

	/*
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_index)
	{
		ItemStack stack = null;
		Slot slot_object = (Slot) inventorySlots.get(slot_index);

		if(slot_object != null && slot_object.getHasStack()){
			ItemStack stack_in_slot = slot_object.getStack();
			stack = stack_in_slot.copy();

			if(slot_index == 0){
				if(!mergeItemStack(stack_in_slot, 1, inventorySlots.size(), true)){
					return null;
				}
			} else if(!mergeItemStack(stack_in_slot, 0, 1, false)){
				return null;
			}

			if(stack_in_slot.stackSize == 0){
				slot_object.putStack(null);
			} else{
				slot_object.onSlotChanged();
			}
		}

		return stack;
	}
	*/
	
	/**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

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
            else if (!this.mergeItemStack(itemstack1, 0, 18, false))
            {
                return null;
            }
            slot.onSlotChange(itemstack1, itemstack);

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}