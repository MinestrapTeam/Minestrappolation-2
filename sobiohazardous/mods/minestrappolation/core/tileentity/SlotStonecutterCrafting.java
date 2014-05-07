package sobiohazardous.mods.minestrappolation.core.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class SlotStonecutterCrafting extends SlotCrafting
{
	private InventoryStonecutterExtraSlot	extraSlotInv;
	private EntityPlayer					thePlayer;
	
	public SlotStonecutterCrafting(EntityPlayer par1EntityPlayer, IInventory par2iInventory, IInventory par3iInventory, InventoryStonecutterExtraSlot extraSlotInv, int par4, int par5, int par6)
	{
		super(par1EntityPlayer, par2iInventory, par3iInventory, par4, par5, par6);
		this.extraSlotInv = extraSlotInv;
		this.thePlayer = par1EntityPlayer;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
	{
		super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
		
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