package sobiohazardous.mods.minestrappolation.handler;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.lib.MItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class MEventHandler
{
	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		Random random = event.entityLiving.getRNG();
		String damageType = event.source.getDamageType();
		if ("player".equals(damageType))
		{
			int looting = event.lootingLevel + 1;
			double rand = random.nextDouble() / looting;
			double rand2 = random.nextDouble() / looting;
			double rand3 = random.nextDouble() / looting;
			double rand4 = random.nextDouble() / looting;
			double rand5 = random.nextDouble() / looting;
			
			if (event.entityLiving instanceof EntityPig)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				
				if (rand2 < 0.25D)
				{
					event.entityLiving.dropItem(MItems.pigHoof, 4);
				}
				
				if (rand3 < 0.3D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 4);
				}
				
				if (rand4 < 0.3D)
				{
					if (event.entityLiving.isBurning())
					{
						event.entityLiving.dropItem(MItems.grease, 5);
					}
					else
					{
						event.entityLiving.dropItem(MItems.fat, 5);
					}
				}
			}
			else if (event.entityLiving instanceof EntityCow)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 4);
				}
				
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(MItems.cowHoof, 4);
				}
				
				if (rand4 < 0.05D)
				{
					event.entityLiving.dropItem(MItems.horn, 2);
				}
			}
			else if (event.entityLiving instanceof EntityMooshroom)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 4);
				}
				
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(MItems.cowHoof, 4);
				}
				
				if (rand4 < 0.05D)
				{
					event.entityLiving.dropItem(MItems.horn, 2);
				}
				if (rand5 < 0.1D)
				{
					event.entityLiving.dropItem(MItems.infectiousFungus, 3);
				}
			}
			else if (event.entityLiving instanceof EntityHorse)
			{
				if (rand < 0.15D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				
				if (rand2 < 0.2D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 4);
				}
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(MItems.horseHoof, 4);
				}
				if (rand4 < 0.5)
				{
					event.entityLiving.dropItem(MItems.rawHorseHaunch, 3);
				}
				if (rand5 < 0.3)
				{
					event.entityLiving.dropItem(MItems.horseHair, 4);
				}
			}
			else if (event.entityLiving instanceof EntityWolf)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				if (rand2 < 0.4D)
				{
					event.entityLiving.dropItem(MItems.wolfHide, 4);
				}
			}
			else if (event.entityLiving instanceof EntityPigZombie)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(MItems.snout, 1);
				}
				
				if (rand2 < 0.1D)
				{
					event.entityLiving.dropItem(MItems.pigHoof, 2);
				}
				
				if (rand3 < 0.15D)
				{
					event.entityLiving.dropItem(MItems.fat, 2);
				}
				
				if (rand4 < 0.1D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 2);
				}
				
				if (rand5 < 0.1D)
				{
					event.entityLiving.dropItem(MItems.marrow, 3);
				}
			}
			else if (event.entityLiving instanceof EntitySheep)
			{
				if (rand < 0.3D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 4);
				}
				
				if (rand2 < 0.9D)
				{
					event.entityLiving.dropItem(MItems.lambchopRaw, 3);
				}
				if (rand3 < 0.25D)
				{
					event.entityLiving.dropItem(MItems.sheepHoof, 3);
				}
			}
			else if (event.entityLiving instanceof EntityChicken)
			{
				if (rand < 0.2D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 2);
				}
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(MItems.beakChicken, 1);
				}
				if (rand3 < 0.2D)
				{
					event.entityLiving.dropItem(MItems.footChicken, 2);
				}
				if (rand4 < 0.5D)
				{
					event.entityLiving.dropItem(MItems.chickenWingRaw, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySpider)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 1);
				}
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(MItems.legSpider, 4);
				}
			}
			else if (event.entityLiving instanceof EntityCaveSpider)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(MItems.animalBones, 1);
				}
				
				if (rand2 < 0.3D)
				{
					event.entityLiving.dropItem(MItems.poisonSack, 2);
				}
				
				if (rand3 < 0.15D)
				{
					event.entityLiving.dropItem(MItems.legSpider, 4);
				}
			}
			else if (event.entityLiving instanceof EntityOcelot)
			{
				if (rand < 0.05D)
				{
					event.entityLiving.dropItem(MItems.footChicken, 1);
				}
				
				if (rand2 < 0.15D)
				{
					event.entityLiving.dropItem(MItems.whisker, 4);
				}
				if (rand3 < 0.1D)
				{
					event.entityLiving.dropItem(MItems.catEye, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySquid)
			{
				if (rand < 0.4D)
				{
					event.entityLiving.dropItem(MItems.squidTentacle, 4);
				}
				
				if (rand2 < 0.2D)
				{
					event.entityLiving.dropItem(MItems.airSack, 1);
				}
			}
			else if (event.entityLiving instanceof EntityVillager)
			{
				if (rand < 0.2D)
				{
					event.entityLiving.dropItem(MItems.flesh, 3);
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
						event.entityLiving.dropItem(MItems.witheredBone, 3);
					}
				}
				else if (rand < 0.15D)
				{
					event.entityLiving.dropItem(MItems.marrow, 3);
				}
			}
			else if (event.entityLiving instanceof EntityBat)
			{
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(MItems.guano, 2);
				}
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(MItems.wingSinew, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySilverfish)
			{
				if (rand < 0.5)
				{
					event.entityLiving.dropItem(MItems.carcassSilverfish, 1);
				}
			}
			else if (event.entityLiving instanceof EntityCreeper)
			{
				if (rand < 0.1)
				{
					event.entityLiving.dropItem(MItems.hideCreeper, 2);
				}
			}
			else if (event.entityLiving instanceof EntitySlime)
			{
				if (rand < 0.1)
				{
					event.entityLiving.dropItem(MItems.slimeCore, 1);
				}
			}
			else if (event.entityLiving instanceof EntityEnderman)
			{
				if (rand < 0.25)
				{
					event.entityLiving.dropItem(MItems.enderCore, 1);
				}
				if (rand < 0.20)
				{
					event.entityLiving.dropItem(MItems.enderAura, 2);
				}
			}
			else if (event.entityLiving instanceof EntityGhast)
			{
				if (rand < 0.15)
				{
					event.entityLiving.dropItem(MItems.ghastTentacle, 4);
				}
			}
			else if (event.entityLiving instanceof EntityWither)
			{
				event.entityLiving.dropItem(MItems.witheredBone, 15);
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
			inventory.addItemStackToInventory(new ItemStack(MItems.ghastlySoul, 1));
		}
	}
}
