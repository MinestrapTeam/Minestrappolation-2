package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;

public class ItemCatEye extends MItemFood
{
	public ItemCatEye(int id, int healAmt, float sat) 
	{
		super(id, healAmt, sat);
	}
	
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		super.onFoodEaten(itemStack, world, entityPlayer);
	        
	    entityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 45 * 20, 0));
	    entityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 10 * 20, 0));
	}

}
