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
    	if(player.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItemStack(par1ItemStack) && player.onGround == false && player.isInWater() == false)
    	{
    		player.motionY /= 1.55;
    		player.fallDistance = 0;
    		if(Math.abs(player.motionX) < 0.15)
    		{
    			player.motionX *= 1.1;
    		}
    		else if(Math.abs(player.motionX) < 0.9)
    		{
    			player.motionX *= 1.06;
    		}
    		if(Math.abs(player.motionZ) < 0.15)
    		{
    			player.motionZ *= 1.1;
    		}
    		if(Math.abs(player.motionZ) < 0.9)
    		{
    			player.motionZ *= 1.06;
    		}
    	}
    }
    
}
