package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItem;

public class ItemAmuletPullum extends MItem
{
	public ItemAmuletPullum() 
	{
		super();
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
	}

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	EntityPlayer player = (EntityPlayer)par3Entity;
    	double rand = Math.random();
    	if(player.inventory.hasItem(this))
    	{
    		if(rand < 0.33)
    		{
    			//TODO
    			//FIXME temp fix. Needs to damage item when player doesn't take fall damage
    			if(player.isAirBorne)
    			{
    				if(player.motionY > 1.2)
    				{
    					player.fallDistance = 0;    			
    					par1ItemStack.damageItem(1, player);
    				}
    			}   			
    		}
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
