package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EOArmorEffects 
{
    private static int tick = 0;
    
	/**
	 * @param player
	 */
	public static void loadArmorEffects(EntityPlayer player)
	{ 
		ItemStack helmet = player.getCurrentItemOrArmor(4);
		  ItemStack chest = player.getCurrentItemOrArmor(3);
		  ItemStack pants = player.getCurrentItemOrArmor(2);
		  ItemStack boots = player.getCurrentItemOrArmor(1);
		//all
		if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null)
		  {		
			  tick++;
			  if (helmet.getItem() == EOItemManager.meuroditeHelmet || helmet.getItem() == EOItemManager.BPMeuroditeHelmet && chest.getItem() == EOItemManager.meuroditeChest || chest.getItem() == EOItemManager.BPMeuroditeChest && pants.getItem() == EOItemManager.meuroditePants || pants.getItem() == EOItemManager.BPMeuroditePants && boots.getItem() == EOItemManager.meuroditeBoots || boots.getItem() == EOItemManager.BPMeuroditeBoots) 
			  {	
				  player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 80, 0,true));
			  }
			 
			  if(tick == 40)
			  {
				  	if (helmet.getItem() == EOItemManager.ToriteHelmet || helmet.getItem() == EOItemManager.BPToriteHelmet && chest.getItem() == EOItemManager.ToriteChest || chest.getItem() == EOItemManager.BPToriteChest  && pants.getItem() == EOItemManager.ToritePants || pants.getItem() == EOItemManager.BPToritePants && boots.getItem() == EOItemManager.ToriteBoots || boots.getItem() == EOItemManager.BPToriteBoots) 
				  	{	
				  		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 0,true));
				  	}

			  	tick = 0;
			  }
			  
			  if (helmet.getItem() == EOItemManager.TitaniumHelmet || helmet.getItem() == EOItemManager.BPTitaniumHelmet && chest.getItem() == EOItemManager.TitaniumChest || chest.getItem() == EOItemManager.BPTitaniumChest && pants.getItem() == EOItemManager.TitaniumPants || pants.getItem() == EOItemManager.BPTitaniumPants && boots.getItem() == EOItemManager.TitaniumBoots || boots.getItem() == EOItemManager.BPTitaniumBoots) 
			  {	
				  player.addPotionEffect(new PotionEffect(Potion.resistance.id, 80, 1,true));
			  }		
			  
		  }				  
	}
	
}