package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;

public class ItemHangGlider extends MItem
{
	boolean initCheck = true;
	boolean checking = false;
	public ItemHangGlider(int id) 
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(25);
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
    		if(initCheck == true && (Math.abs(player.motionX) + Math.abs(player.motionZ) > 0.15))
    		{
    			checking = true;
    			initCheck = false;
    		}
    		if(checking == true && (Math.abs(player.motionX) + Math.abs(player.motionZ) <= 0.15) && (player.isCollidedHorizontally == false))
    		{
    			checking = false;
    			initCheck = true;
    		}
    		if(checking == true && (player.isCollidedHorizontally == true))
    		{
    			player.motionX = 0;
    			player.motionZ = 0;
    			if(!player.worldObj.isRemote)
    			{    				
        			System.out.println("True");
    				par1ItemStack.damageItem(1, player);   				
    			}
    			checking = false;
    			initCheck = true;
    		}
    		//wall colision
    		/*if((Math.abs(prev2XMotion) > 0.3 || Math.abs(prev2ZMotion) > 0.3 || (Math.abs(prev2XMotion) > 0.3 && Math.abs(prev2ZMotion) > 0.3)) && player.isCollidedHorizontally && Math.abs(player.motionY) > 0.13)
    		{
    			par1ItemStack.damageItem(1, Minecraft.getMinecraft().thePlayer);
    		}*/
    		//System.out.println("Checking" + checking);
    		//System.out.println("InitChecking" + initCheck);
    		//System.out.println("SpeedZ" + player.motionZ);
    		//System.out.println("SpeedX" + player.motionX);
    	}
    	
    }
    
}
