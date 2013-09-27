package sobiohazardous.minestrappolation.extrafoods.block.fridge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ContainerFridge extends Container
{
	protected TileEntityFridge tile_entity;
	public ContainerFridge(TileEntityFridge tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;
		
		for (int i = 0; i < 3; i++)
		  {
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new SlotFridge(player_inventory.player, tile_entity, j + i * 9 + 1, 8 + 18 * j, 17 + (i * 18)));
			}
		  }

		bindPlayerInventory(player_inventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile_entity.isUseableByPlayer(player);
	}
	
	protected void bindPlayerInventory(InventoryPlayer par1InventoryPlayer)
	{
		 for (int i = 0; i < 3; i++)
         {
                 for (int k = 0; k < 9; k++)
                 {
                         addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
                 }
         }

         for (int j = 0; j < 9; j++)
         {
                 addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
         }
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot_index)
	{
		ItemStack stack = null;
		Slot slot_object = (Slot) inventorySlots.get(slot_index);

		if(slot_object != null && slot_object.getHasStack())
		{
			ItemStack stack_in_slot = slot_object.getStack();
			stack = stack_in_slot.copy();

			if(slot_index == 0)
			{
				if(!mergeItemStack(stack_in_slot, 1, inventorySlots.size(), true))
				{
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
	}