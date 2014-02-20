package sobiohazardous.minestrappolation.extrafoods.block.freezer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


// Referenced classes of package net.minecraft.src:
//            Slot, EntityPlayer, ItemStack, Item, 
//            AchievementList, ModLoader, IInventory

public class SlotFreezer extends Slot
{

    public SlotFreezer(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
    {
        super(iinventory, i, j, k);
    }

    public boolean isItemValid(ItemStack itemstack)
    {
        return false;
    }

    public void onPickupFromSlot(EntityPlayer player,ItemStack itemstack)
    {
        super.onPickupFromSlot(player, itemstack);
    }
}

