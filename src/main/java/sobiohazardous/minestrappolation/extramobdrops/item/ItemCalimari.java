package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;

public class ItemCalimari extends MItemFood
{
	public ItemCalimari(int healAmt, float sat) 
	{
		super(healAmt, sat);
	}
	
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.heal(2F);
    	super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
    	return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
    }
    
}
