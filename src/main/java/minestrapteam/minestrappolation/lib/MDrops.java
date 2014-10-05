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
	private static int		pigHoofC;
	private static int		pigBonesC;
	private static int		pigGreaseC;
	private static float	pigSnoutP;
	private static float	pigHoofP;
	private static float	pigBonesP;
	private static float	pigGreaseP;
	
	private static int		cowSnoutC;
	private static int		cowBonesC;
	private static int		cowHoofC;
	private static int		cowHornC;
	private static float	cowSnoutP;
	private static float	cowBonesP;
	private static float	cowHoofP;
	private static float	cowHornP;
	
	private static int		mooshroomSnoutC;
	private static int		mooshroomBonesC;
	private static int		mooshroomHoofC;
	private static int		mooshroomHornC;
	private static int		mooshroomFungusC;
	private static float	mooshroomSnoutP;
	private static float	mooshroomBonesP;
	private static float	mooshroomHoofP;
	private static float	mooshroomHornP;
	private static float	mooshroomFungusP;
	
	private static int		horseSnoutC;
	private static int		horseBonesC;
	private static int		horseHoofC;
	private static int		horseHaunchC;
	private static int		horseHairC;
	private static float	horseSnoutP;
	private static float	horseBonesP;
	private static float	horseHoofP;
	private static float	horseHaunchP;
	private static float	horseHairP;
	
	protected static void loadConfig()
	{
		pigSnoutC = CSConfig.getInt("pig", "Snout Count", null, 1);
		pigHoofC = CSConfig.getInt("pig", "Hoof Count", null, 4);
		pigBonesC = CSConfig.getInt("pig", "Bones Count", null, 4);
		pigGreaseC = CSConfig.getInt("pig", "Grease Count", null, 5);
		pigSnoutP = CSConfig.getFloat("pig", "Snout Probability", null, 0.15F);
		pigHoofP = CSConfig.getFloat("pig", "Hoof Probability", null, 0.15F);
		pigBonesP = CSConfig.getFloat("pig", "Bones Probability", null, 0.3F);
		pigGreaseP = CSConfig.getFloat("pig", "Grease Probability", null, 0.5F);
		
		cowSnoutC = CSConfig.getInt("cow", "Snout Count", null, 1);
		cowHoofC = CSConfig.getInt("cow", "Hoof Count", null, 4);
		cowBonesC = CSConfig.getInt("cow", "Bones Count", null, 4);
		cowHornC = CSConfig.getInt("cow", "Horn Count", null, 2);
		cowSnoutP = CSConfig.getFloat("cow", "Snout Probability", null, 0.15F);
		cowHoofP = CSConfig.getFloat("cow", "Hoof Probability", null, 0.3F);
		cowBonesP = CSConfig.getFloat("cow", "Bones Probability", null, 0.15F);
		cowHornP = CSConfig.getFloat("cow", "Horn Probability", null, 0.05F);
		
		mooshroomSnoutC = CSConfig.getInt("mooshroom", "Snout Count", null, 1);
		mooshroomHoofC = CSConfig.getInt("mooshroom", "Hoof Count", null, 4);
		mooshroomBonesC = CSConfig.getInt("mooshroom", "Bones Count", null, 4);
		mooshroomHornC = CSConfig.getInt("mooshroom", "Horn Count", null, 2);
		mooshroomFungusC = CSConfig.getInt("mooshroom", "Infectious Fungus Count", null, 3);
		mooshroomSnoutP = CSConfig.getFloat("mooshroom", "Snout Probability", null, 0.15F);
		mooshroomHoofP = CSConfig.getFloat("mooshroom", "Hoof Probability", null, 0.3F);
		mooshroomBonesP = CSConfig.getFloat("mooshroom", "Bones Probability", null, 0.25F);
		mooshroomHornP = CSConfig.getFloat("mooshroom", "Horn Probability", null, 0.05F);
		mooshroomFungusP = CSConfig.getFloat("mooshroom", "Infectious Fungus Probability", null, 0.1F);
		
		horseSnoutC = CSConfig.getInt("horse", "Snout Count", null, 1);
		horseHoofC = CSConfig.getInt("horse", "Hoof Count", null, 4);
		horseBonesC = CSConfig.getInt("horse", "Bones Count", null, 4);
		horseHaunchC = CSConfig.getInt("horse", "Haunch Count", null, 3);
		horseHairC = CSConfig.getInt("horse", "Hair Count", null, 4);
		horseSnoutP = CSConfig.getFloat("horse", "Snout Probability", null, 0.15F);
		horseHoofP = CSConfig.getFloat("horse", "Hoof Probability", null, 0.2F);
		horseBonesP = CSConfig.getFloat("horse", "Bones Probability", null, 0.2F);
		horseHaunchP = CSConfig.getFloat("horse", "Haunch Probability", null, 0.5F);
		horseHairP = CSConfig.getFloat("horse", "Hair Probability", null, 0.3F);
	}
	
	public static void onMobDrops(LivingDropsEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		Random random = living.getRNG();
		boolean onFire = living.isBurning();
		int looting = event.lootingLevel + 1;
		
		if (living instanceof EntityPig)
		{
			dropPigItems(living, random, onFire, looting);
		}
		else if (living instanceof EntityCow)
		{
			dropCowItems(living, random, looting);
		}
		else if (living instanceof EntityMooshroom)
		{
			dropMooshroomItems(living, random, looting);
		}
		else if (living instanceof EntityHorse)
		{
			dropHorseItems(living, random, onFire, looting);
		}
		else if (living instanceof EntitySheep)
		{
			dropSheepItems(living, random, onFire, looting);
		}
		else if (living instanceof EntityChicken)
		{
			dropChickenItems(living, random, onFire, looting);
		}
		else if (living instanceof EntitySquid)
		{
			dropSquidItems(living, random, looting);
		}
		else if (living instanceof EntityOcelot)
		{
			dropOcelotItems(living, random, looting);
		}
		else if (living instanceof EntityBat)
		{
			dropBatItems(living, random, looting);
		}
		else if (living instanceof EntityWolf)
		{
			dropWolfItems(living, random, looting);
		}
		else if (living instanceof EntityVillager)
		{
			dropVillagerItems(living, random, looting);
		}
		else if (living instanceof EntitySlime)
		{
			dropSlimeItems(living, random, looting);
		}
		else if (living instanceof EntitySilverfish)
		{
			dropSilverfishItems(living, random, looting);
		}
		else if (living instanceof EntitySpider)
		{
			dropSpiderItems(living, random, looting);
		}
		else if (living instanceof EntityCaveSpider)
		{
			dropCaveSpiderItems(living, random, looting);
		}
		else if (living instanceof EntitySkeleton)
		{
			dropSkeletonItems(living, random, looting);
		}
		else if (living instanceof EntityCreeper)
		{
			dropCreeperItems(living, random, looting);
		}
		else if (living instanceof EntityPigZombie)
		{
			dropPigZombieItems(living, random, onFire, looting);
		}
		else if (living instanceof EntityGhast)
		{
			dropGhastItems(living, random, looting);
		}
		else if (living instanceof EntityEnderman)
		{
			dropEndermanItems(living, random, looting);
		}
		else if (living instanceof EntityWitch)
		{
			dropWitchItems(event, random, looting);
		}
		else if (living instanceof EntityWither)
		{
			dropWitherItems(living, random, looting);
		}
	}
	
	private static void dropPigItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < pigSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(pigSnoutC + looting));
		}
		if (random.nextFloat() / looting < pigHoofP)
		{
			living.dropItem(MItems.pigHoof, random.nextInt(pigHoofC + looting));
		}
		if (random.nextFloat() / looting < pigBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(pigBonesC + looting));
		}
		if (random.nextFloat() / looting < pigGreaseP)
		{
			living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(pigGreaseC + looting));
		}
	}
	
	private static void dropCowItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < cowSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(cowSnoutC + looting));
		}
		if (random.nextFloat() / looting < cowBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(cowBonesC + looting));
		}
		if (random.nextFloat() / looting < cowHoofP)
		{
			living.dropItem(MItems.cowHoof, random.nextInt(cowHoofC + looting));
		}
		if (random.nextFloat() / looting < cowHornP)
		{
			living.dropItem(MItems.horn, random.nextInt(cowHornC + looting));
		}
	}
	
	private static void dropMooshroomItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < mooshroomSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(mooshroomSnoutC + looting));
		}
		if (random.nextFloat() / looting < mooshroomBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(mooshroomBonesC + looting));
		}
		if (random.nextFloat() / looting < mooshroomHoofP)
		{
			living.dropItem(MItems.cowHoof, random.nextInt(mooshroomHoofC + looting));
		}
		if (random.nextFloat() / looting < mooshroomHornP)
		{
			living.dropItem(MItems.horn, random.nextInt(mooshroomHornC + looting));
		}
		if (random.nextFloat() / looting < mooshroomFungusP)
		{
			living.dropItem(MItems.infectiousFungus, random.nextInt(mooshroomFungusC + looting));
		}
	}
	
	private static void dropHorseItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < horseSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(horseSnoutC + looting));
		}
		if (random.nextFloat() / looting < horseBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(horseBonesC + looting));
		}
		if (random.nextFloat() / looting < horseHoofP)
		{
			living.dropItem(MItems.horseHoof, random.nextInt(horseHoofC + looting));
		}
		if (random.nextFloat() / looting < horseHaunchP)
		{
			living.dropItem(onFire ? MItems.horseHaunchCooked : MItems.horseHaunchRaw, random.nextInt(horseHaunchC + looting));
		}
		if (random.nextFloat() / looting < horseHairP)
		{
			living.dropItem(MItems.horseHair, random.nextInt(horseHairC + looting));
		}
	}
	
	private static void dropSheepItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < 0.3D)
		{
			living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
		}
		if (random.nextFloat() / looting < 0.7D)
		{
			living.dropItem(onFire ? MItems.lambchopCooked : MItems.lambchopRaw, random.nextInt(3 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.sheepHoof, random.nextInt(3 + looting));
		}
	}
	
	private static void dropChickenItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < 0.2D)
		{
			living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.beakChicken, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.footChicken, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.5D)
		{
			living.dropItem(onFire ? MItems.chickenWingCooked : MItems.chickenWingRaw, random.nextInt(2 + looting));
		}
	}
	
	private static void dropSquidItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.4D)
		{
			living.dropItem(MItems.squidTentacle, random.nextInt(4 + looting));
		}
		if (random.nextFloat() / looting < 0.2D)
		{
			living.dropItem(MItems.airSack, random.nextInt(1 + looting));
		}
	}
	
	private static void dropOcelotItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.05D)
		{
			living.dropItem(MItems.footChicken, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.25D)
		{
			living.dropItem(MItems.whisker, random.nextInt(4 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.catEye, random.nextInt(2 + looting));
		}
	}
	
	private static void dropBatItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.5)
		{
			living.dropItem(MItems.guano, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.5)
		{
			living.dropItem(MItems.wingSinew, random.nextInt(2 + looting));
		}
	}
	
	private static void dropWolfItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.1D)
		{
			living.dropItem(MItems.snout, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.4D)
		{
			living.dropItem(MItems.wolfHide, random.nextInt(3 + looting));
		}
	}
	
	private static void dropVillagerItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.2D)
		{
			living.dropItem(MItems.flesh, random.nextInt(3 + looting));
		}
	}
	
	private static void dropSlimeItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.1)
		{
			living.dropItem(MItems.slimeCore, 1);
		}
	}
	
	private static void dropSilverfishItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.5)
		{
			living.dropItem(MItems.carcassSilverfish, 1);
		}
	}
	
	private static void dropSpiderItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.05D)
		{
			living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
		}
	}
	
	private static void dropCaveSpiderItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.05D)
		{
			living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.3D)
		{
			living.dropItem(MItems.poisonSack, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
		}
	}
	
	private static void dropSkeletonItems(EntityLivingBase living, Random random, int looting)
	{
		EntitySkeleton skeleton = (EntitySkeleton) living;
		if (skeleton.getSkeletonType() == 1)
		{
			if (random.nextFloat() / looting < 0.2D)
			{
				living.dropItem(MItems.witheredBone, random.nextInt(3 + looting));
			}
		}
		else if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(MItems.marrow, random.nextInt(3 + looting));
		}
	}
	
	private static void dropCreeperItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.1)
		{
			living.dropItem(MItems.hideCreeper, random.nextInt(2 + looting));
		}
	}
	
	private static void dropPigZombieItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < 0.1D)
		{
			living.dropItem(MItems.snout, random.nextInt(1 + looting));
		}
		if (random.nextFloat() / looting < 0.1D)
		{
			living.dropItem(MItems.pigHoof, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.15D)
		{
			living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.1D)
		{
			living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
		}
		if (random.nextFloat() / looting < 0.1D)
		{
			living.dropItem(MItems.marrow, random.nextInt(3 + looting));
		}
	}
	
	private static void dropGhastItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.15)
		{
			living.dropItem(MItems.ghastTentacle, random.nextInt(4 + looting));
		}
	}
	
	private static void dropEndermanItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < 0.25)
		{
			living.dropItem(MItems.enderCore, 1);
		}
		if (random.nextFloat() / looting < 0.20)
		{
			living.dropItem(MItems.enderAura, random.nextInt(2 + looting));
		}
	}
	
	private static void dropWitchItems(LivingDropsEvent event, Random random, int looting)
	{
		for (EntityItem item : event.drops)
		{
			ItemStack stack = item.getEntityItem();
			if (stack.getItem() == Items.stick)
			{
				enchantStick(stack, random, looting);
				break;
			}
		}
	}
	
	private static void dropWitherItems(EntityLivingBase living, Random random, int looting)
	{
		living.dropItem(MItems.witheredBone, random.nextInt(15 + looting));
	}
	
	public static void enchantStick(ItemStack stack, Random random, int looting)
	{
		double rand1 = random.nextFloat() / looting;
		double rand2 = random.nextFloat() / looting;
		double rand3 = random.nextFloat() / looting;
		
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
