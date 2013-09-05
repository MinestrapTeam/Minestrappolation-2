package sobiohazardous.minestrappolation.extraores.client.gui;

import java.util.Iterator;
import java.util.List;

import sobiohazardous.minestrappolation.extraores.lib.MelterRecipes;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMelter extends Container
{
private TileEntityMelter goldOven;
private int lastGoldOvenCookTime;
private int lastGoldOvenBurnTime;
private int lastGoldOvenItemBurnTime;

public ContainerMelter(InventoryPlayer par1InventoryPlayer, TileEntityMelter par2TileEntityGoldOven)
{
         lastGoldOvenCookTime = 0;
         lastGoldOvenBurnTime = 0;
         lastGoldOvenItemBurnTime = 0;
         goldOven = par2TileEntityGoldOven;
         //burn
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 1, 47, 53));
         //fuel
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 0, 56, 17));
         //result
         addSlotToContainer(new SlotMelter(par1InventoryPlayer.player, par2TileEntityGoldOven, 2, 116, 35));
         //bucket
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 3, 66, 53));
         
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
                 if (this.lastGoldOvenCookTime != this.goldOven.goldCookTime)
                 {
                         var2.sendProgressBarUpdate(this, 0, this.goldOven.goldCookTime);
                 }
                 if (this.lastGoldOvenBurnTime != this.goldOven.goldBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 1, this.goldOven.goldBurnTime);
                 }
                 if (this.lastGoldOvenItemBurnTime != this.goldOven.goldItemBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 2, this.goldOven.goldItemBurnTime);
                 }
         }
         this.lastGoldOvenCookTime = this.goldOven.goldCookTime;
         this.lastGoldOvenBurnTime = this.goldOven.goldBurnTime;
         this.lastGoldOvenItemBurnTime = this.goldOven.goldItemBurnTime;
}

public void updateProgressBar(int par1, int par2)
{
         if (par1 == 0)
         {
                 goldOven.goldCookTime = par2;
         }

         if (par1 == 1)
         {
                 goldOven.goldBurnTime = par2;
         }

         if (par1 == 2)
         {
                 goldOven.goldItemBurnTime = par2;
         }
}

public boolean canInteractWith(EntityPlayer par1EntityPlayer)
{
         return goldOven.isUseableByPlayer(par1EntityPlayer);
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
                 else if (MelterRecipes.smelting().getSmeltingResult(itemstack1.getItem().itemID) != null)
                 {
                         if (!mergeItemStack(itemstack1, 0, 1, false))
                         {
                                 return null;
                         }
                 }
                 else if (TileEntityMelter.isItemFuel(itemstack1))
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

public TileEntityMelter getentity()
{
	return this.goldOven;
}
}