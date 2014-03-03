package sobiohazardous.minestrappolation.extrafoods.lib;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class EFCraftingManager implements ICraftingHandler
{
        @Override
        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
        {
                for (int i = 0; i < craftMatrix.getSizeInventory(); i++) // Checks all
                                                                                                                                        // the slots
                {
                        if (craftMatrix.getStackInSlot(i) != null) // If there is an item
                        {
                                ItemStack j = craftMatrix.getStackInSlot(i); // Gets the item
                                if (j.getItem() != null && j.getItem() == ExtraFoods.knifeStone)
                                {
                                        ItemStack k = new ItemStack(ExtraFoods.knifeStone, 2, (j.getItemDamage()+1));
                                        if (k.getItemDamage() >= k.getMaxDamage())
                                        {
                                                k.stackSize--;
                                        		k.damageItem(k.getItemDamage(), player);
                                        }
                                        craftMatrix.setInventorySlotContents(i, k);                         
                                }
                               
                                if (j.getItem() != null && j.getItem() == ExtraFoods.knifeIron)
                                {
                                        ItemStack k = new ItemStack(ExtraFoods.knifeIron, 2, (j.getItemDamage()+1));
                                        if (k.getItemDamage() >= k.getMaxDamage())
                                        {
                                        	k.stackSize--; 
                                        	k.damageItem(k.getItemDamage(), player);
                                        }
                                        craftMatrix.setInventorySlotContents(i, k);                         
                                }
                                
                                if (j.getItem() != null && j.getItem() == ExtraFoods.knifeDiamond)
                                {
                                        ItemStack k = new ItemStack(ExtraFoods.knifeDiamond, 2, (j.getItemDamage()+1));
                                        if (k.getItemDamage() >= k.getMaxDamage())
                                        {
                                        	k.stackSize--;
                                        	k.damageItem(k.getItemDamage(), player);
                                        }
                                        craftMatrix.setInventorySlotContents(i, k);                         
                                }
                        }
                }
        }

        @Override
        public void onSmelting(EntityPlayer player, ItemStack item) {
        }
}