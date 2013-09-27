package sobiohazardous.minestrappolation.extrafoods.handler;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EFEventHandler 
{
	@ForgeSubscribe
	public void onLivingDrops(LivingDropsEvent event)
	{
		if (event.source.getDamageType().equals("player")) 
		{
			double rand = Math.random();
			if (event.entityLiving instanceof EntitySquid)
			{
				if (rand < 0.75D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{	
					event.entityLiving.dropItem(ExtraFoods.calimariRaw.itemID, 1);				
				}
			}
			
			if (event.entityLiving instanceof EntitySheep)
			{
				if (rand < 0.75D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{	
					event.entityLiving.dropItem(ExtraFoods.lambchopRaw.itemID, 1);				
				}
			}
		}
	}
}
