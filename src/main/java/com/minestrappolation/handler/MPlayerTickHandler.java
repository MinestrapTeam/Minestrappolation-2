package com.minestrappolation.handler;

import java.util.Random;

import com.minestrappolation.lib.MItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class MPlayerTickHandler
{
	public static boolean	ghastTentacleEffect	= false;
	
	static int				ticks				= 0;
	static Random			rand				= new Random();
	public static int		gTime				= 30 + rand.nextInt(150);
	
	@SubscribeEvent
	public void playerUpdate(PlayerTickEvent evt)
	{
		EntityPlayer player = evt.player;
		
		if (evt.phase == Phase.START)
		{
			if (ghastTentacleEffect)
			{
				ticks++;
				if (ticks == gTime * 20)
				{
					ghastTentacleEffect = false;
					EntityPlayerMP playermp = (EntityPlayerMP) player;
					playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0);
				}
			}
			else
			{
				ticks = 0;
			}
		}
		
		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack pants = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);
		
		if (helmet != null && chest != null && pants != null && boots != null)
		{
			if (helmet.getItem() == MItems.meuroditeHelmet && chest.getItem() == MItems.meuroditeChest && pants.getItem() == MItems.meuroditePants && boots.getItem() == MItems.meuroditeBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1, 0, true));
			}
			
			if (helmet.getItem() == MItems.ToriteHelmet && chest.getItem() == MItems.ToriteChest && pants.getItem() == MItems.ToritePants && boots.getItem() == MItems.ToriteBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1, 0, true));
			}
			
			if (helmet.getItem() == MItems.TitaniumHelmet && chest.getItem() == MItems.TitaniumChest && pants.getItem() == MItems.TitaniumPants && boots.getItem() == MItems.TitaniumBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1, 1, true));
			}
		}
	}
}