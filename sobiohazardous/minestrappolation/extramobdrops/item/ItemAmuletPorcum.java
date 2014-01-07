package sobiohazardous.minestrappolation.extramobdrops.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItem;

public class ItemAmuletPorcum extends MItem
{
	int tick = 0;

	public ItemAmuletPorcum(int id) 
	{
		super(id);
		this.setMaxDamage(50);
	}

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	EntityPlayer player = (EntityPlayer)par3Entity;
    	Random rand = new Random();
    	int randnum = rand.nextInt(61);
    	tick++;
    	if(player.inventory.hasItem(this.itemID))
    	{
    		if(tick > 60)
    		{
    			if(randnum > 59)
    			{
    				tick = 0;
    				if(player.getFoodStats().needFood())
    				{
    					player.getFoodStats().addStats(1, 0F);
    					par1ItemStack.damageItem(1, player);
    				}
    			}
    		}
    		else if(tick > 120)
    		{
    			tick = 0;
    		}
    	}	
    }
}
