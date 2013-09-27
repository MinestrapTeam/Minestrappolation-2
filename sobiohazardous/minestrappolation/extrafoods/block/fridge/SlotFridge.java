package sobiohazardous.minestrappolation.extrafoods.block.fridge;

import sobiohazardous.minestrappolation.extrafoods.item.EFFoodSpoilable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


// Referenced classes of package net.minecraft.src:
//            Slot, EntityPlayer, ItemStack, Item, 
//            AchievementList, ModLoader, IInventory

public class SlotFridge extends Slot
{

    public SlotFridge(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
    {
        super(iinventory, i, j, k);
    }

    public boolean isItemValid(ItemStack itemstack)
    {
        if(itemstack.getItem() instanceof EFFoodSpoilable)
        {
        	return true;
        }
    	return false;
    }

    public void onPickupFromSlot(EntityPlayer player,ItemStack itemstack)
    {
        super.onPickupFromSlot(player, itemstack);
    }
}

