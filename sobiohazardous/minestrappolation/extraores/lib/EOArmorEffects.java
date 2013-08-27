package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EOArmorEffects 
{
    
	/**
	 * @param player
	 */
	public static void loadArmorEffects(EntityPlayer player)
	{ 
		//all
		if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null)
		  {
			  ItemStack helmet = player.getCurrentItemOrArmor(4);
			  ItemStack chest = player.getCurrentItemOrArmor(3);
			  ItemStack pants = player.getCurrentItemOrArmor(2);
			  ItemStack boots = player.getCurrentItemOrArmor(1);
			  
			  if (helmet.getItem() == EOItemManager.meuroditeHelmet && chest.getItem() == EOItemManager.meuroditeChest && pants.getItem() == EOItemManager.meuroditePants && boots.getItem() == EOItemManager.meuroditeBoots) 
			  {	
				  player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 80, 0));
			  }
			  
			  if (helmet.getItem() == EOItemManager.ToriteHelmet && chest.getItem() == EOItemManager.ToriteChest && pants.getItem() == EOItemManager.ToritePants && boots.getItem() == EOItemManager.ToriteBoots) 
			  {	
				  player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 1));
			  }
			  
			  if (helmet.getItem() == EOItemManager.TitaniumHelmet && chest.getItem() == EOItemManager.TitaniumChest && pants.getItem() == EOItemManager.TitaniumPants && boots.getItem() == EOItemManager.TitaniumBoots) 
			  {	
				  player.addPotionEffect(new PotionEffect(Potion.resistance.id, 80, 1));
			  }			  
		  }
	}
	
}