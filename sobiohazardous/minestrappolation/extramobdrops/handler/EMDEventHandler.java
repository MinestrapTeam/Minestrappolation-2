package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.Collection;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDPotionManager;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.ModelHangGlider;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.RenderPlayerEvent;
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
			double rand5 = Math.random();
			
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
				if(rand5 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItemManager.infectiousFungus.itemID, 3);
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
				if(rand2 < 0.4D)
				{
					event.entityLiving.dropItem(EMDItemManager.wolfHide.itemID, 4);
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
				
				if(rand5 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItemManager.marrow.itemID, 3);
				}
			}
			
			if(event.entityLiving instanceof EntitySheep)
			{
				if (rand < 0.3D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 4);
				}
				
				if(rand2 < 0.9D)
				{
					event.entityLiving.dropItem(EMDItemManager.lambchopRaw.itemID, 3);
				}
				if(rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItemManager.sheepHoof.itemID, 3);
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
				if(rand4 < 0.5D)
				{
					event.entityLiving.dropItem(EMDItemManager.chickenWingRaw.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntitySpider)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 1);
				}
				if(rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.legSpider.itemID, 4);
				}			
			}
			
			if(event.entityLiving instanceof EntityCaveSpider)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.animalBones.itemID, 1);
				}
				
				if(rand2 <0.3D)
				{
					event.entityLiving.dropItem(EMDItemManager.poisonSack.itemID, 2);
				}
				
				if(rand3 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.legSpider.itemID, 4);
				}
			}
			
			if(event.entityLiving instanceof EntityOcelot)
			{
				if (rand < 0.05D) //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.)
				{
					event.entityLiving.dropItem(EMDItemManager.footChicken.itemID, 1);
				}
				
				if(rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.whisker.itemID, 4);
				}
				if(rand3 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItemManager.catEye.itemID, 2);
				}
			}
			
			if(event.entityLiving instanceof EntitySquid)
			{
				if(rand < 0.4D)
				{
					event.entityLiving.dropItem(EMDItemManager.squidTentacle.itemID, 4);
				}
				
				if(rand2 < 0.2D)
				{
					event.entityLiving.dropItem(EMDItemManager.airSack.itemID, 1);
				}
			}
			
			if(event.entityLiving instanceof EntityVillager)
			{
				if(rand < 0.2D)
				{
					event.entityLiving.dropItem(EMDItemManager.flesh.itemID, 3);
				}
			}
			if(event.entityLiving instanceof EntitySkeleton)
			{
				if(rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItemManager.marrow.itemID, 3);
				}
			}
			if(event.entityLiving instanceof EntityBat)
			{
				if(rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItemManager.guano.itemID, 2);
				}
			}
			if(event.entityLiving instanceof EntitySilverfish)
			{
				if(rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItemManager.carcassSilverfish.itemID, 1);
				}
			}
			if(event.entityLiving instanceof EntityCreeper)
			{
				if(rand < 0.1)
				{
					event.entityLiving.dropItem(EMDItemManager.hideCreeper.itemID, 2);
				}
			}
			if(event.entityLiving instanceof EntitySlime)
			{
				if(rand < 0.1)
				{
					event.entityLiving.dropItem(EMDItemManager.slimeCore.itemID, 1);
				}
			}
			if(event.entityLiving instanceof EntityEnderman)
			{
				if(rand < 0.25)
				{
					event.entityLiving.dropItem(EMDItemManager.enderCore.itemID, 1);
				}
			}
			if(event.entityLiving instanceof EntityGhast)
			{
				if(rand < 0.15)
				{
					event.entityLiving.dropItem(EMDItemManager.ghastTentacle.itemID, 4);
				}
			}
		}
	}
	
	@ForgeSubscribe
	public void renderPlayer (RenderPlayerEvent.Post evt)
	{
		//add if statements to check if holding item
		//bind the model texture (this is hard)
		//rotate model above player (GL11)
		//make the players hands move upward
		//ModelHangGlider m = new ModelHangGlider();				
		//m.render(0.0625F);
	}
	
	@ForgeSubscribe
	public void livingUpdate(LivingUpdateEvent event)
	{
		EMDPotionManager.loadPotionEffect(event);
	}
}
