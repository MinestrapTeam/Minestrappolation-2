package minestrapteam.minestrap_core.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class SlotStonecutterCrafting extends SlotCrafting
{
	private IInventory		extraSlotInv;
	private EntityPlayer	thePlayer;
	
	public SlotStonecutterCrafting(EntityPlayer player, IInventory craftMatrix, IInventory craftResult, IInventory extraSlot, int slotID, int x, int y)
	{
		super(player, craftMatrix, craftResult, slotID, x, y);
		this.extraSlotInv = extraSlot;
		this.thePlayer = player;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		super.onPickupFromSlot(player, stack);
		
		ItemStack extraSlotItem = this.extraSlotInv.getStackInSlot(0);
		
		this.extraSlotInv.decrStackSize(0, 1);
		
		if (extraSlotItem.getItem().hasContainerItem())
		{
			ItemStack extraSlotItemContainer = new ItemStack(extraSlotItem.getItem().getContainerItem());
			
			if (!extraSlotItem.getItem().doesContainerItemLeaveCraftingGrid(extraSlotItem) || !this.thePlayer.inventory.addItemStackToInventory(extraSlotItemContainer))
			{
				if (this.extraSlotInv.getStackInSlot(0) == null)
				{
					this.extraSlotInv.setInventorySlotContents(0, extraSlotItemContainer);
				}
				else
				{
					this.thePlayer.dropPlayerItemWithRandomChoice(extraSlotItemContainer, false);
				}
			}
		}
	}
	
}