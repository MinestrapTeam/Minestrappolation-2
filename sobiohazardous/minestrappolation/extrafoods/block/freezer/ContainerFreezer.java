package sobiohazardous.minestrappolation.extrafoods.block.freezer;

import java.util.Iterator;
import java.util.List;

import sobiohazardous.minestrappolation.extrafoods.block.fridge.SlotFridge;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFreezer extends Container
	{
	private TileEntityFreezer freezer;
	private int lastFreezerFreezeTime;
	private int lastFreezerIceTime;
	private int lastFreezerItemFreezeTime;

	public ContainerFreezer(InventoryPlayer par1InventoryPlayer, TileEntityFreezer par2TileEntityGoldOven)
	{
         lastFreezerFreezeTime = 0;
         lastFreezerIceTime = 0;
         lastFreezerItemFreezeTime = 0;
         freezer = par2TileEntityGoldOven;
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 0, 56, 17));
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 1, 56, 53));
         addSlotToContainer(new SlotFreezer(par1InventoryPlayer.player, par2TileEntityGoldOven, 2, 116, 35));
         
         //storage
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 3, 8, 17));
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 4, 26, 17));
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 5, 8, 35));
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 6, 26, 35));
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 7, 8, 53));
         addSlotToContainer(new SlotFridge(par1InventoryPlayer.player,par2TileEntityGoldOven, 8, 26, 53));
         
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

	/**
         * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
         */
	public void detectAndSendChanges()
	{
         super.detectAndSendChanges();
         Iterator var1 = this.crafters.iterator();
         while (var1.hasNext())
         {
                 ICrafting var2 = (ICrafting)var1.next();
                 if (this.lastFreezerFreezeTime != this.freezer.fridgeFreezeTime)
                 {
                         var2.sendProgressBarUpdate(this, 0, this.freezer.fridgeFreezeTime);
                 }
                 if (this.lastFreezerIceTime != this.freezer.fridgeIceTime)
                 {
                         var2.sendProgressBarUpdate(this, 1, this.freezer.fridgeIceTime);
                 }
                 if (this.lastFreezerItemFreezeTime != this.freezer.fridgeItemFreezeTime)
                 {
                         var2.sendProgressBarUpdate(this, 2, this.freezer.fridgeItemFreezeTime);
                 }
         }
         this.lastFreezerFreezeTime = this.freezer.fridgeFreezeTime;
         this.lastFreezerIceTime = this.freezer.fridgeIceTime;
         this.lastFreezerItemFreezeTime = this.freezer.fridgeItemFreezeTime;
	}

	public void updateProgressBar(int par1, int par2)
	{	
         if (par1 == 0)
         {
                 freezer.fridgeFreezeTime = par2;
         }

         if (par1 == 1)
         {
                 freezer.fridgeIceTime = par2;
         }

         if (par1 == 2)
         {
                 freezer.fridgeItemFreezeTime = par2;
         }
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
         return freezer.isUseableByPlayer(par1EntityPlayer);
	}

	/**
         * Called to transfer a stack from one inventory to the other eg. when shift clicking.
         */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
	{
         ItemStack itemstack = null;
         Slot slot = (Slot)inventorySlots.get(slotnumber);

         if (slot != null && slot.getHasStack())
         {
                 ItemStack itemstack1 = slot.getStack();
                 itemstack = itemstack1.copy();

                 if (slotnumber == 2)
                 {
                         if (!mergeItemStack(itemstack1, 3, 39, true))
                         {
                                 return null;
                         }

                         slot.onSlotChange(itemstack1, itemstack);
                 }
                 else if (slotnumber == 1 || slotnumber == 0)
                 {
                         if (!mergeItemStack(itemstack1, 3, 39, false))
                         {
                                 return null;
                         }
                 }
                 else if (FreezerRecipes.smelting().getSmeltingResult(itemstack1.getItem().itemID) != null)
                 {
                         if (!mergeItemStack(itemstack1, 0, 1, false))
                         {
                                 return null;
                         }
                 }
                 else if (TileEntityFreezer.isItemFuel(itemstack1))
                 {
                         if (!mergeItemStack(itemstack1, 1, 2, false))
                         {
                                 return null;
                         }
                 }
                 else if (slotnumber >= 3 && slotnumber < 30)
                 {
                         if (!mergeItemStack(itemstack1, 30, 39, false))
                         {
                                 return null;
                         }
                 }
                 else if (slotnumber >= 30 && slotnumber < 39 && !mergeItemStack(itemstack1, 3, 30, false))
                 {
                         return null;
                 }

                 if (itemstack1.stackSize == 0)
                 {
                         slot.putStack(null);
                 }
                 else
                 {
                         slot.onSlotChanged();
                 }

                 if (itemstack1.stackSize == itemstack.stackSize)
                 {
                         return null;
                 }
                
                 slot.onPickupFromSlot(player, itemstack);
         }

         return itemstack;
	}
}