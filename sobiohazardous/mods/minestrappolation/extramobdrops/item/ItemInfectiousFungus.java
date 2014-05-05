package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDPotions;

public class ItemInfectiousFungus extends MItemFood
{
	public ItemInfectiousFungus(int healAmt, float sat) 
	{
		super(healAmt, sat);
	}
	
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		super.onFoodEaten(itemStack, world, entityPlayer);
	        
	    entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 1));
	    entityPlayer.addPotionEffect(new PotionEffect(EMDPotions.infectious.id, 30 * 20, 1));
	}

}
