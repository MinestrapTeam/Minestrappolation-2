package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDPotionEffectManager;

public class InfectiousFungus extends MItemFood
{
	public InfectiousFungus(int id, int healAmt, float sat) 
	{
		super(id, healAmt, sat);
	}
	
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		super.onFoodEaten(itemStack, world, entityPlayer);
	        
	    entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 1));
	    entityPlayer.addPotionEffect(new PotionEffect(EMDPotionEffectManager.infectious.id, 30 * 20, 1));
	}

}
