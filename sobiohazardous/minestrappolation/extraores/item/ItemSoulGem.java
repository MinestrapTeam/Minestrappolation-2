package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulGem extends EItemFoiled
{
	public ItemSoulGem(int id) 
	{
		super(id);
	}

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.addExperience(20);
    	--par1ItemStack.stackSize;
    	return par1ItemStack;	   
    }
}
