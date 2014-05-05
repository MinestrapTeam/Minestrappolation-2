package sobiohazardous.mods.minestrappolation.extraores.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
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
			if (helmet.getItem() == EOItems.meuroditeHelmet && chest.getItem() == EOItems.meuroditeChest && pants.getItem() == EOItems.meuroditePants && boots.getItem() == EOItems.meuroditeBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 80, 0, true));
			}

			if (tick == 40)
			{
				if (helmet.getItem() == EOItems.ToriteHelmet && chest.getItem() == EOItems.ToriteChest && pants.getItem() == EOItems.ToritePants && boots.getItem() == EOItems.ToriteBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 0, true));
				}

				tick = 0;
			}

			if (helmet.getItem() == EOItems.TitaniumHelmet && chest.getItem() == EOItems.TitaniumChest && pants.getItem() == EOItems.TitaniumPants && boots.getItem() == EOItems.TitaniumBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 80, 1, true));
			}

		}
	}
}
