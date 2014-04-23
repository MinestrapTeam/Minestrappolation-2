package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;

public class ItemAirSack extends MItemFood
{
	public ItemAirSack() 
	{
		super(0, 0);
	}
	
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if(par3EntityPlayer.isInWater())
        {
        	par3EntityPlayer.setAir(par3EntityPlayer.getAir() + 60);
        }
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(par3EntityPlayer.isInWater())
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
}
