package sobiohazardous.minestrappolation.extraores.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class ItemSoulBottle extends Item
{
        public ItemSoulBottle(int i)
        {
                super(i);
                this.setCreativeTab(EOItemManager.tabOresItems);
                this.setMaxStackSize(1);
        }

        public void registerIcons(IconRegister iconRegister)
    	{
    	         itemIcon = iconRegister.registerIcon("Minestrappolation:item_SoulBottle");
    	}
        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par2EntityPlayer)
        {
        	if (par2EntityPlayer.experienceTotal >= 10)
        	{
        		par2EntityPlayer.addExperience(-10);
        
            	--par1ItemStack.stackSize;
            	
            	return par1ItemStack.stackSize <= 0 ? new ItemStack(Item.expBottle) : par1ItemStack;	   
        	}
        	else
        	{
        		return par1ItemStack.stackSize <= 0 ? new ItemStack(EOBlockManager.SoulBottle) : par1ItemStack;
        	}
            
        }
        
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
        {
        	par3List.add(EnumChatFormatting.RED + "WIP");
        }
        
}