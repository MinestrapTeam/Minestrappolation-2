package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.Collection;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDPotionManager;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

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
				if(rand3 < 0.25D)
				{
					event.entityLiving.dropItem(EMDItemManager.horseHoof.itemID, 4);
				}
				if(rand4 < 0.5)
				{
					event.entityLiving.dropItem(EMDItemManager.rawHorseHaunch.itemID, 3);
				}
				if(rand5 < 0.3)
				{
					event.entityLiving.dropItem(EMDItemManager.horseHair.itemID, 4);
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
				EntitySkeleton skeleton = (EntitySkeleton)event.entityLiving;

				if(skeleton.getSkeletonType() == 0)
				{
					if(rand < 0.15D)
					{
						event.entityLiving.dropItem(EMDItemManager.marrow.itemID, 3);
					}
				}
				
				if(skeleton.getSkeletonType() == 1)
				{
					if(rand < 0.2D)
					{
						event.entityLiving.dropItem(EMDItemManager.witheredBone.itemID, 3);
					}
				}
			}

			if(event.entityLiving instanceof EntityBat)
			{
				if(rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItemManager.guano.itemID, 2);
				}
				if(rand < 0.5)
				{
					event.entityLiving.dropItem(EMDItemManager.wingSinew.itemID, 2);
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
				if(rand < 0.20)
				{
					event.entityLiving.dropItem(EMDItemManager.enderAura.itemID, 2);
				}
			}
			if(event.entityLiving instanceof EntityGhast)
			{
				if(rand < 0.15)
				{
					event.entityLiving.dropItem(EMDItemManager.ghastTentacle.itemID, 4);
				}
			}
			if(event.entityLiving instanceof EntityWither)
			{
				event.entityLiving.dropItem(EMDItemManager.witheredBone.itemID, 15);
			}
		}
	}
	
	
	@ForgeSubscribe
	public void renderPlayer (RenderPlayerEvent.Pre evt)
	{
		//add if statements to check if holding item
		//bind the model texture (this is hard)
		//rotate model above player (GL11)
		//make the players hands move upward
		if(evt.entityPlayer.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItemStack(null))
		{
			GL11.glPushMatrix();
			ModelHangGlider m = new ModelHangGlider();		
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("minestrappolation:textures/misc/HangGlider.png"));
			int tick = 0;
			tick++;
			float rotateYaw = this.interpolateRotation(evt.entityPlayer.prevRotationYaw, evt.entityPlayer.rotationYaw, tick);
			GL11.glRotatef(rotateYaw, 0, -1, 0);
			GL11.glRotatef(180F, 0, 0, 1);
			GL11.glTranslatef(0, 0, -0.5F);				
			m.render(0.0625F);
			GL11.glPopMatrix();
		}		
	}
	
	public static float interpolateRotation(float par1, float par2, float par3)
    {
        float f3;

        for (f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return par1 + par3 * f3;
    }
	
	@ForgeSubscribe
	public void entityInteract(EntityInteractEvent evt)
	{
		if(evt.target instanceof EntityGhast && evt.entityPlayer.inventory.getCurrentItem() != Item.glassBottle.getContainerItemStack(null))
		{
			evt.entityPlayer.inventory.getCurrentItem().stackSize--;
			evt.entityPlayer.inventory.addItemStackToInventory(new ItemStack(EMDItemManager.ghastlySoul, 1));
		}
	}
	
	@ForgeSubscribe
	public void livingUpdate(LivingUpdateEvent event)
	{
		EMDPotionManager.loadPotionEffect(event);
	}
}
