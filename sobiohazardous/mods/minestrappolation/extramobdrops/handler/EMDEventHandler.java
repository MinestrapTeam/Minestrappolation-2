package sobiohazardous.mods.minestrappolation.extramobdrops.handler;

import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EMDEventHandler
{
	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		if ("player".equals(event.source.getDamageType()))
		{
			double rand = Math.random();
			double rand2 = Math.random();
			double rand3 = Math.random();
			double rand4 = Math.random();
			double rand5 = Math.random();
			
			if (event.entityLiving instanceof EntityPig)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				
				if (rand2 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItems.pigHoof, 4);
					
				}
				
				if (rand3 < 0.3D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 4);
				}
				
				if (rand4 < 0.3D)
				{
					if (event.entityLiving.isBurning())
					{
						event.entityLiving.dropItem(EMDItems.grease, 5);
					}
					else
					{
						event.entityLiving.dropItem(EMDItems.fat, 5);
					}
				}
			}
			else if (event.entityLiving instanceof EntityCow)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 4);
				}
				
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItems.cowHoof, 4);
				}
				
				if (rand4 < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.horn, 2);
				}
			}
			else if (event.entityLiving instanceof EntityMooshroom)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 4);
				}
				
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItems.cowHoof, 4);
				}
				
				if (rand4 < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.horn, 2);
				}
				if (rand5 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItems.infectiousFungus, 3);
				}
			}
			else if (event.entityLiving instanceof EntityHorse)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				
				if (rand2 < 0.2D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 4);
				}
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItems.horseHoof, 4);
				}
				if (rand4 < 0.5)
				{
					event.entityLiving.dropItem(EMDItems.rawHorseHaunch, 3);
				}
				if (rand5 < 0.3)
				{
					event.entityLiving.dropItem(EMDItems.horseHair, 4);
				}
			}
			else if (event.entityLiving instanceof EntityWolf)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				if (rand2 < 0.4D)
				{
					event.entityLiving.dropItem(EMDItems.wolfHide, 4);
				}
			}
			else if (event.entityLiving instanceof EntityPigZombie)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.snout, 1);
				}
				
				if (rand2 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItems.pigHoof, 2);
				}
				
				if (rand3 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.fat, 2);
				}
				
				if (rand4 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 2);
				}
				
				if (rand5 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItems.marrow, 3);
				}
			}
			else if (event.entityLiving instanceof EntitySheep)
			{
				if (rand < 0.3D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 4);
				}
				
				if (rand2 < 0.9D)
				{
					event.entityLiving.dropItem(EMDItems.lambchopRaw, 3);
				}
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItems.sheepHoof, 3);
				}
			}
			else if (event.entityLiving instanceof EntityChicken)
			{
				if (rand < 0.2D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 2);
				}
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.beakChicken, 1);
				}
				if (rand3 < 0.2D)
				{
					event.entityLiving.dropItem(EMDItems.footChicken, 2);
				}
				if (rand4 < 0.5D)
				{
					event.entityLiving.dropItem(EMDItems.chickenWingRaw, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySpider)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 1);
				}
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.legSpider, 4);
				}
			}
			else if (event.entityLiving instanceof EntityCaveSpider)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.animalBones, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(EMDItems.poisonSack, 2);
				}
				
				if (rand3 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.legSpider, 4);
				}
			}
			else if (event.entityLiving instanceof EntityOcelot)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(EMDItems.footChicken, 1);
				}
				
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.whisker, 4);
				}
				if (rand3 < 0.1D)
				{
					event.entityLiving.dropItem(EMDItems.catEye, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySquid)
			{
				if (rand < 0.4D)
				{
					event.entityLiving.dropItem(EMDItems.squidTentacle, 4);
				}
				
				if (rand2 < 0.2D)
				{
					event.entityLiving.dropItem(EMDItems.airSack, 1);
				}
			}
			else if (event.entityLiving instanceof EntityVillager)
			{
				if (rand < 0.2D)
				{
					event.entityLiving.dropItem(EMDItems.flesh, 3);
				}
			}
			else if (event.entityLiving instanceof EntitySkeleton)
			{
				EntitySkeleton skeleton = (EntitySkeleton) event.entityLiving;
				int type = skeleton.getSkeletonType();
				
				if (type == 1)
				{
					if (rand < 0.2D)
					{
						event.entityLiving.dropItem(EMDItems.witheredBone, 3);
					}
				}
				else if (rand < 0.15D)
				{
					event.entityLiving.dropItem(EMDItems.marrow, 3);
				}
			}
			else if (event.entityLiving instanceof EntityBat)
			{
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItems.guano, 2);
				}
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItems.wingSinew, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySilverfish)
			{
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItems.carcassSilverfish, 1);
				}
			}
			else if (event.entityLiving instanceof EntityCreeper)
			{
				if (rand < 0.1)
				{
					event.entityLiving.dropItem(EMDItems.hideCreeper, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySlime)
			{
				if (rand < 0.1)
				{
					event.entityLiving.dropItem(EMDItems.slimeCore, 1);
				}
			}
			else if (event.entityLiving instanceof EntityEnderman)
			{
				if (rand < 0.25)
				{
					event.entityLiving.dropItem(EMDItems.enderCore, 1);
				}
				if (rand < 0.20)
				{
					event.entityLiving.dropItem(EMDItems.enderAura, 2);
				}
			}
			else if (event.entityLiving instanceof EntityGhast)
			{
				if (rand < 0.15)
				{
					event.entityLiving.dropItem(EMDItems.ghastTentacle, 4);
				}
			}
			else if (event.entityLiving instanceof EntityWither)
			{
				event.entityLiving.dropItem(EMDItems.witheredBone, 15);
			}
		}
	}
	
	/*
	 * @SubscribeEvent public void renderPlayer(RenderPlayerEvent.Pre evt) {
	 * if(evt.entityPlayer.inventory.getCurrentItem() !=
	 * EMDItemManager.hangGlider.getContainerItem(null)) { GL11.glPushMatrix();
	 * ModelHangGlider m = new ModelHangGlider();
	 * Minecraft.getMinecraft().getTextureManager().bindTexture(new
	 * ResourceLocation("extramobdrops:textures/misc/hangGlider.png")); int tick
	 * = 0; tick++; float rotateYaw =
	 * this.interpolateRotation(evt.entityPlayer.prevRotationYaw,
	 * evt.entityPlayer.rotationYaw, tick); GL11.glRotatef(rotateYaw, 0, -1, 0);
	 * GL11.glRotatef(180F, 0, 0, 1); GL11.glTranslatef(0, 0, -0.5F);
	 * m.render(0.0625F); GL11.glPopMatrix(); } }
	 */
	
	public static float interpolateRotation(float prev, float current, float tick)
	{
		return current + (current - prev) * tick;
	}
	
	@SubscribeEvent
	public void entityInteract(EntityInteractEvent event)
	{
		InventoryPlayer inventory = event.entityPlayer.inventory;
		if (event.target instanceof EntityGhast && inventory.getCurrentItem().getItem() == Items.glass_bottle)
		{
			inventory.getCurrentItem().stackSize--;
			inventory.addItemStackToInventory(new ItemStack(EMDItems.ghastlySoul, 1));
		}
	}
}
