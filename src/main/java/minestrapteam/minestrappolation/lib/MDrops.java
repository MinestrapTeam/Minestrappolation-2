package minestrapteam.minestrappolation.lib;

import java.util.Random;

import clashsoft.cslib.config.CSConfig;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MDrops
{
	private static int		pigSnoutC;
	private static int		pigHoofC	= 4;
	private static int		pigBonesC	= 4;
	private static int		pigGreaseC	= 5;
	
	private static float	pigSnoutP	= 0.15F;
	private static float	pigHoofP	= 0.15F;
	private static float	pigBonesP	= 0.3F;
	private static float	pigGreaseP	= 0.5F;
	
	public static void loadConfig()
	{
		pigSnoutC = CSConfig.getInt("pig", "Snout Count", null, 1);
		pigHoofC = CSConfig.getInt("pig", "Hoof Count", null, 1);
		pigBonesC = CSConfig.getInt("pig", "Bones Count", null, 1);
		pigGreaseC = CSConfig.getInt("pig", "Grease Count", null, 1);
		
		pigSnoutP = CSConfig.getInt("pig", "Snout Probability", null, 1);
		pigHoofP = CSConfig.getInt("pig", "Hoof Probability", null, 1);
		pigBonesP = CSConfig.getInt("pig", "Bones Probability", null, 1);
		pigGreaseP = CSConfig.getInt("pig", "Grease Probability", null, 1);
		
		// TODO Complete the pattern...
	}
	
	public static void onMobDrops(LivingDropsEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		Random random = living.getRNG();
		boolean onFire = living.isBurning();
		int looting = event.lootingLevel;
		int looting1 = looting + 1;
		float rand1 = random.nextFloat() / looting1;
		float rand2 = random.nextFloat() / looting1;
		float rand3 = random.nextFloat() / looting1;
		float rand4 = random.nextFloat() / looting1;
		float rand5 = random.nextFloat() / looting1;
		
		if (living instanceof EntityPig)
		{
			if (rand1 < pigSnoutP)
			{
				living.dropItem(MItems.snout, random.nextInt(pigSnoutC + looting));
			}
			if (rand2 < pigHoofP)
			{
				living.dropItem(MItems.pigHoof, random.nextInt(pigHoofC + looting));
			}
			if (rand3 < pigBonesP)
			{
				living.dropItem(MItems.animalBones, random.nextInt(pigBonesC + looting));
			}
			if (rand4 < pigGreaseP)
			{
				living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(pigGreaseC + looting));
			}
		}
		else if (living instanceof EntityCow)
		{
			if (rand1 < 0.15D)
			{
				living.dropItem(MItems.snout, random.nextInt(1 + looting));
			}
			if (rand2 < 0.3D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
			}
			if (rand3 < 0.15D)
			{
				living.dropItem(MItems.cowHoof, random.nextInt(4 + looting));
			}
			if (rand4 < 0.05D)
			{
				living.dropItem(MItems.horn, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntityMooshroom)
		{
			if (rand1 < 0.15D)
			{
				living.dropItem(MItems.snout, random.nextInt(1 + looting));
			}
			if (rand2 < 0.3D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
			}
			if (rand3 < 0.25D)
			{
				living.dropItem(MItems.cowHoof, random.nextInt(4 + looting));
			}
			if (rand4 < 0.05D)
			{
				living.dropItem(MItems.horn, random.nextInt(2 + looting));
			}
			if (rand5 < 0.1D)
			{
				living.dropItem(MItems.infectiousFungus, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntityHorse)
		{
			if (rand1 < 0.15D)
			{
				living.dropItem(MItems.snout, random.nextInt(1 + looting));
			}
			if (rand2 < 0.2D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
			}
			if (rand3 < 0.20D)
			{
				living.dropItem(MItems.horseHoof, random.nextInt(4 + looting));
			}
			if (rand4 < 0.5)
			{
				living.dropItem(onFire ? MItems.horseHaunchCooked : MItems.horseHaunchRaw, random.nextInt(3 + looting));
			}
			if (rand5 < 0.3)
			{
				living.dropItem(MItems.horseHair, random.nextInt(4 + looting));
			}
		}
		else if (living instanceof EntityWolf)
		{
			if (rand1 < 0.1D)
			{
				living.dropItem(MItems.snout, random.nextInt(1 + looting));
			}
			if (rand2 < 0.4D)
			{
				living.dropItem(MItems.wolfHide, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntityPigZombie)
		{
			if (rand1 < 0.1D)
			{
				living.dropItem(MItems.snout, random.nextInt(1 + looting));
			}
			
			if (rand2 < 0.1D)
			{
				living.dropItem(MItems.pigHoof, random.nextInt(2 + looting));
			}
			
			if (rand3 < 0.15D)
			{
				living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(2 + looting));
			}
			
			if (rand4 < 0.1D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
			}
			
			if (rand5 < 0.1D)
			{
				living.dropItem(MItems.marrow, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntitySheep)
		{
			if (rand1 < 0.3D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
			}
			
			if (rand2 < 0.7D)
			{
				living.dropItem(onFire ? MItems.lambchopCooked : MItems.lambchopRaw, random.nextInt(3 + looting));
			}
			if (rand3 < 0.15D)
			{
				living.dropItem(MItems.sheepHoof, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntityChicken)
		{
			if (rand1 < 0.2D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
			}
			if (rand2 < 0.15D)
			{
				living.dropItem(MItems.beakChicken, random.nextInt(1 + looting));
			}
			if (rand3 < 0.15D)
			{
				living.dropItem(MItems.footChicken, random.nextInt(2 + looting));
			}
			if (rand4 < 0.5D)
			{
				living.dropItem(onFire ? MItems.chickenWingCooked : MItems.chickenWingRaw, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntitySpider)
		{
			if (rand1 < 0.05D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
			}
			if (rand2 < 0.15D)
			{
				living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
			}
		}
		else if (living instanceof EntityCaveSpider)
		{
			if (rand1 < 0.05D)
			{
				living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
			}
			
			if (rand2 < 0.3D)
			{
				living.dropItem(MItems.poisonSack, random.nextInt(2 + looting));
			}
			
			if (rand3 < 0.15D)
			{
				living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
			}
		}
		else if (living instanceof EntityOcelot)
		{
			if (rand1 < 0.05D)
			{
				living.dropItem(MItems.footChicken, random.nextInt(1 + looting));
			}
			
			if (rand2 < 0.25D)
			{
				living.dropItem(MItems.whisker, random.nextInt(4 + looting));
			}
			if (rand3 < 0.15D)
			{
				living.dropItem(MItems.catEye, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntitySquid)
		{
			if (rand1 < 0.4D)
			{
				living.dropItem(MItems.squidTentacle, random.nextInt(4 + looting));
			}
			
			if (rand2 < 0.2D)
			{
				living.dropItem(MItems.airSack, random.nextInt(1 + looting));
			}
		}
		else if (living instanceof EntityVillager)
		{
			if (rand1 < 0.2D)
			{
				living.dropItem(MItems.flesh, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntityWitch)
		{
			for (EntityItem item : event.drops)
			{
				ItemStack stack = item.getEntityItem();
				if (stack.getItem() == Items.stick)
				{
					enchantStick(stack, random, rand1, rand2, rand3, rand4, rand5);
					break;
				}
			}
		}
		else if (living instanceof EntitySkeleton)
		{
			EntitySkeleton skeleton = (EntitySkeleton) living;
			if (skeleton.getSkeletonType() == 1)
			{
				if (rand1 < 0.2D)
				{
					living.dropItem(MItems.witheredBone, random.nextInt(3 + looting));
				}
			}
			else if (rand1 < 0.15D)
			{
				living.dropItem(MItems.marrow, random.nextInt(3 + looting));
			}
		}
		else if (living instanceof EntityBat)
		{
			if (rand1 < 0.5)
			{
				living.dropItem(MItems.guano, random.nextInt(2 + looting));
			}
			if (rand1 < 0.5)
			{
				living.dropItem(MItems.wingSinew, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntitySilverfish)
		{
			if (rand1 < 0.5)
			{
				living.dropItem(MItems.carcassSilverfish, 1);
			}
		}
		else if (living instanceof EntityCreeper)
		{
			if (rand1 < 0.1)
			{
				living.dropItem(MItems.hideCreeper, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntitySlime)
		{
			if (rand1 < 0.1)
			{
				living.dropItem(MItems.slimeCore, 1);
			}
		}
		else if (living instanceof EntityEnderman)
		{
			if (rand1 < 0.25)
			{
				living.dropItem(MItems.enderCore, 1);
			}
			if (rand1 < 0.20)
			{
				living.dropItem(MItems.enderAura, random.nextInt(2 + looting));
			}
		}
		else if (living instanceof EntityGhast)
		{
			if (rand1 < 0.15)
			{
				living.dropItem(MItems.ghastTentacle, random.nextInt(4 + looting));
			}
		}
		else if (living instanceof EntityWither)
		{
			living.dropItem(MItems.witheredBone, random.nextInt(15 + looting));
		}
	}
	
	public static void enchantStick(ItemStack stack, Random random, double rand1, double rand2, double rand3, double rand4, double rand5)
	{
		if (rand1 < 0.3D)
		{
			int level = -1;
			
			// Knockback
			if (rand2 < 0.7D)
			{
				if (rand3 < 0.01D)
				{
					level = 7 + random.nextInt(3);
				}
				else if (rand3 < 0.02D)
				{
					level = 6;
				}
				else if (rand3 < 0.05D)
				{
					level = 2 + random.nextInt(4);
				}
				else if (rand3 < 0.25D)
				{
					level = 1;
				}
				else
				{
					level = 0;
				}
				
				stack.addEnchantment(Enchantment.knockback, level);
			}
			
			// Fire Aspect
			if (rand2 < 0.2D)
			{
				if (rand3 < 0.01D)
				{
					level = 4;
				}
				if (rand3 < 0.09D)
				{
					level = 3;
				}
				if (rand3 < 0.15D)
				{
					level = 2;
				}
				if (rand3 < 0.25D)
				{
					level = 1;
				}
				else if (rand3 < 0.5D)
				{
					level = 0;
				}
				
				stack.addEnchantment(Enchantment.fireAspect, level);
			}
			
			// Looting
			if (rand2 < 0.1D)
			{
				if (rand3 < 0.01D)
				{
					level = 7 + random.nextInt(3);
				}
				else if (rand3 < 0.02D)
				{
					level = 6;
				}
				else if (rand3 < 0.05D)
				{
					level = 2 + random.nextInt(4);
				}
				else if (rand3 < 0.25D)
				{
					level = 1;
				}
				else
				{
					level = 0;
				}
				
				stack.addEnchantment(Enchantment.looting, level);
			}
		}
	}
}
