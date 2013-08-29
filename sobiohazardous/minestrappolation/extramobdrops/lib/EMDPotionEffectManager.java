package sobiohazardous.minestrappolation.extramobdrops.lib;

import sobiohazardous.minestrappolation.api.potion.MPotion;
import net.minecraft.block.Block;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EMDPotionEffectManager 
{
	private static String iconLoc = "minestrappolation:gui/potion_icons.png";
	
	public static Potion infectious;
	
	public static void loadPotions()
	{
		infectious = new MPotion("potion.infectious", true, 0, false, iconLoc, 0,6).setInGamePotionName("Potion of Infection");
	}
	
	/**
	 * Add potion effects for any time the player is alive
	 * @param event
	 */
	public static void loadPotionEffect(LivingUpdateEvent event)
	{
		if (event.entityLiving.isPotionActive(EMDPotionEffectManager.infectious)) 
		{
			event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY - 2, (int)event.entityLiving.posZ, Block.mycelium.blockID);
			if(event.entityLiving.worldObj.getBlockId((int)event.entityLiving.posX, (int)event.entityLiving.posY - 1, (int)event.entityLiving.posZ) == Block.mycelium.blockID)
			{
				//TODO add regen effect to player
			}
		}	
	}
	
	/**
	 * Add potion effects for when a mob is killed
	 * @param event
	 */
	public static void loadPotionEffect(LivingDropsEvent event)
	{
		if (event.entityLiving.isPotionActive(infectious))
		{
			if (event.source.getDamageType().equals("player")) 
			{
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 8 * 20, 1));
			}
		}
	}
}
