package sobiohazardous.minestrappolation.extraores.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EOPlayerTickHandler
{
	int tick = 0;

	public void playerUpdate(PlayerTickEvent evt)
	{
		EntityPlayer player = evt.player;

		ItemStack helmet = player.getCurrentArmor(4);
		ItemStack chest = player.getCurrentArmor(3);
		ItemStack pants = player.getCurrentArmor(2);
		ItemStack boots = player.getCurrentArmor(1);
		// all
		if (player.getCurrentArmor(4) != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null)
		{
			tick++;
			if (helmet.getItem() == EOItemManager.meuroditeHelmet && chest.getItem() == EOItemManager.meuroditeChest && pants.getItem() == EOItemManager.meuroditePants && boots.getItem() == EOItemManager.meuroditeBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 80, 0, true));
			}

			if (tick == 40)
			{
				if (helmet.getItem() == EOItemManager.ToriteHelmet && chest.getItem() == EOItemManager.ToriteChest && pants.getItem() == EOItemManager.ToritePants && boots.getItem() == EOItemManager.ToriteBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 0, true));
				}

				tick = 0;
			}

			if (helmet.getItem() == EOItemManager.TitaniumHelmet && chest.getItem() == EOItemManager.TitaniumChest && pants.getItem() == EOItemManager.TitaniumPants && boots.getItem() == EOItemManager.TitaniumBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 80, 1, true));
			}

		}
	}
}
