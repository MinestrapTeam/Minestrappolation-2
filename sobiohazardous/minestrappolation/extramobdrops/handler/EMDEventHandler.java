package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.Collection;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EMDEventHandler 
{
	@ForgeSubscribe
	public void onMobDrops(LivingDropsEvent event)
	{
		if (event.source.getDamageType().equals("player")) 
		{
			double rand = Math.random();
			double rand2 = Math.random();
			double rand3 = Math.random();
			double rand4 = Math.random();
			
			if (event.entityLiving instanceof EntityPig)
			{
				if (rand < 0.15D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{	
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);		
				}
				
				if (rand2 < 0.25D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.pigHoof.itemID, 4);	

				}
				
				if (rand3 < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
				
				if (rand4 < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					if(event.entityLiving.isBurning())
					{
						event.entityLiving.dropItem(EMDItemManager.grease.itemID, 5);	
					}
					else
					{
						event.entityLiving.dropItem(EMDItemManager.fat.itemID, 5);	
					}
				}
			}
			
			if(event.entityLiving instanceof EntityCow)
			{
				if (rand < 0.15D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);
				}
				
				if (rand2 < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
				
				if(rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItemManager.cowHoof.itemID, 4);
				}
				
				if(rand4 < 0.05D)
				{
					event.entityLiving.dropItem(EMDItemManager.horn.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntityMooshroom)
			{
				if (rand < 0.15D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);
				}
				
				if (rand2 < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
				
				if(rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItemManager.cowHoof.itemID, 4);
				}
				
				if(rand4 < 0.05D)
				{
					event.entityLiving.dropItem(EMDItemManager.horn.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntityHorse)
			{
				if (rand < 0.15D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);
				}
				
				if (rand2 < 0.2D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
			}
			
			if(event.entityLiving instanceof EntityWolf)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);
				}
			}
			
			if(event.entityLiving instanceof EntityPigZombie)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.snout.itemID, 1);
				}
				
				if (rand2 < 0.1D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.pigHoof.itemID, 2);
				}
				
				if (rand3 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.fat.itemID, 2);	
				}
				
				if (rand4 < 0.1D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntitySheep)
			{
				if (rand < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
			}
			
			if(event.entityLiving instanceof EntityChicken)
			{
				if (rand < 0.2D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 2);
				}
				if(rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.beakChicken.itemID, 1);
				}
				if(rand3 < 0.2D)
				{
					event.entityLiving.dropItem(EMDItemManager.footChicken.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntitySpider)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 1);
				}
			}
			
			if(event.entityLiving instanceof EntityOcelot)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.footChicken.itemID, 1);
				}
			}
		}
	}
}
