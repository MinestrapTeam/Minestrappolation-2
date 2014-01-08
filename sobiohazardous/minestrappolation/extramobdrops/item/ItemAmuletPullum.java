package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItem;

public class ItemAmuletPullum extends MItem
{
	public ItemAmuletPullum(int id) 
	{
		super(id);
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
	}

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	EntityPlayer player = (EntityPlayer)par3Entity;
    	double rand = Math.random();
    	if(player.inventory.hasItem(this.itemID))
    	{
    		if(rand < 0.33)
    		{
    			//TODO
    			//FIXME temp fix. Needs to damage item when player doesn't take fall damage
    			if(player.isAirBorne)
    			{
    				player.fallDistance = 0;    			
    				par1ItemStack.damageItem(1, player);
    			}   			
    		}
    	}
    }
}
