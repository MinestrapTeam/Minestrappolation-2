package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;

public class ItemHangGlider extends MItem
{
	public ItemHangGlider(int id) 
	{
		super(id);
	}

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	EntityPlayer player = (EntityPlayer)par3Entity; 
    	if(player.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItemStack(par1ItemStack))
    	{
    		player.motionY /= 1.55;
    		player.fallDistance = 0;
    	}
    }
    
}
