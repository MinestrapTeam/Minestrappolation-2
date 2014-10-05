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
	
	private static int		sheepBonesC;
	private static int		sheepLambchopC;
	private static int		sheepHoofC;
	private static float	sheepBonesP;
	private static float	sheepLambchopP;
	private static float	sheepHoofP;
	
	private static int		chickenBonesC;
	private static int		chickenBeakC;
	private static int		chickenFootC;
	private static int		chickenWingC;
	private static float	chickenBonesP;
	private static float	chickenBeakP;
	private static float	chickenFootP;
	private static float	chickenWingP;
	
	private static int		squidTentacleC;
	private static int		squidAirSackC;
	private static float	squidTentacleP;
	private static float	squidAirSackP;
	
	private static int		ocelotChickenFootC;
	private static int		ocelotWhiskerC;
	private static int		ocelotEyeC;
	private static float	ocelotChickenFootP;
	private static float	ocelotWhiskerP;
	private static float	ocelotEyeP;
	
	private static int		batWingC;
	private static int		batGuanoC;
	private static float	batWingP;
	private static float	batGuanoP;
	
	private static int		wolfSnoutC;
	private static int		wolfHideC;
	private static float	wolfSnoutP;
	private static float	wolfHideP;
	
	private static int		villagerFleshC;
	private static float	villagerFleshP;
	
	private static int		slimeCoreC;
	private static float	slimeCoreP;
	
	private static int		silverfishCarcassC;
	private static float	silverfishCarcassP;
	
	private static int		spiderBonesC;
	private static int		spiderLegC;
	private static float	spiderBonesP;
	private static float	spiderLegP;
	
	private static int		caveSpiderBonesC;
	private static int		caveSpiderPoisonSackC;
	private static int		caveSpiderLegC;
	private static float	caveSpiderBonesP;
	private static float	caveSpiderPoisonSackP;
	private static float	caveSpiderLegP;
	
	private static int		skeletonMarrowC;
	private static float	skeletonMarrowP;
	
	private static int		witherSkeletonBonesC;
	private static float	witherSkeletonBonesP;
	
	private static int		creeperHideC;
	private static float	creeperHideP;
	
	private static int		pigZombieSnoutC;
	private static int		pigZombieHoofC;
	private static int		pigZombieFatC;
	private static int		pigZombieBonesC;
	private static int		pigZombieMarrowC;
	private static float	pigZombieSnoutP;
	private static float	pigZombieHoofP;
	private static float	pigZombieFatP;
	private static float	pigZombieBonesP;
	private static float	pigZombieMarrowP;
	
	private static int		ghastTentacleC;
	private static float	ghastTentacleP;
	
	private static int		endermanCoreC;
	private static int		endermanAuraC;
	private static float	endermanCoreP;
	private static float	endermanAuraP;
	
	private static int		witherBoneC;
	private static float	witherBoneP;
	
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
		
		sheepBonesC = CSConfig.getInt("sheep", "Bones Count", null, 4);
		sheepLambchopC = CSConfig.getInt("sheep", "Lambchop Count", null, 3);
		sheepHoofC = CSConfig.getInt("sheep", "Hoof Count", null, 3);
		sheepBonesP = CSConfig.getFloat("sheep", "Bones Probability", null, 0.3F);
		sheepLambchopP = CSConfig.getFloat("sheep", "Lambchop Probability", null, 0.7F);
		sheepHoofP = CSConfig.getFloat("sheep", "Hoof Probability", null, 0.15F);
		
		chickenBonesC = CSConfig.getInt("chicken", "Bones Count", null, 2);
		chickenBeakC = CSConfig.getInt("chicken", "Beak Count", null, 1);
		chickenFootC = CSConfig.getInt("chicken", "Foot Count", null, 2);
		chickenWingC = CSConfig.getInt("chicken", "Wing Count", null, 2);
		chickenBonesP = CSConfig.getFloat("chicken", "Bones Probability", null, 0.2F);
		chickenBeakP = CSConfig.getFloat("chicken", "Beak Probability", null, 0.15F);
		chickenFootP = CSConfig.getFloat("chicken", "Foot Probability", null, 0.15F);
		chickenWingP = CSConfig.getFloat("chicken", "Wing Probability", null, 0.5F);
		
		squidTentacleC = CSConfig.getInt("squid", "Tentacle Count", null, 4);
		squidAirSackC = CSConfig.getInt("squid", "Air Sack Count", null, 1);
		squidTentacleP = CSConfig.getFloat("squid", "Tentacle Probability", null, 0.4F);
		squidAirSackP = CSConfig.getFloat("squid", "Air Sack Probability", null, 0.2F);
		
		ocelotChickenFootC = CSConfig.getInt("ocelot", "Chicken Foot Count", null, 1);
		ocelotWhiskerC = CSConfig.getInt("ocelot", "Whisker Count", null, 4);
		ocelotEyeC = CSConfig.getInt("ocelot", "Eye Count", null, 2);
		ocelotChickenFootP = CSConfig.getFloat("ocelot", "Chicken Foot Probability", null, 0.05F);
		ocelotWhiskerP = CSConfig.getFloat("ocelot", "Whisker Probability", null, 0.25F);
		ocelotEyeP = CSConfig.getFloat("ocelot", "Eye Probability", null, 0.15F);
		
		batWingC = CSConfig.getInt("bat", "Wing Count", null, 2);
		batGuanoC = CSConfig.getInt("bat", "Guano Count", null, 2);
		batWingP = CSConfig.getFloat("bat", "Wing Probability", null, 0.5F);
		batGuanoP = CSConfig.getFloat("bat", "Guano Probability", null, 0.5F);
		
		wolfSnoutC = CSConfig.getInt("wolf", "Snout Count", null, 1);
		wolfHideC = CSConfig.getInt("wolf", "Hide Count", null, 3);
		wolfSnoutP = CSConfig.getFloat("wolf", "Snout Probability", null, 0.1F);
		wolfHideP = CSConfig.getFloat("wolf", "Hide Probability", null, 0.4F);
		
		villagerFleshC = CSConfig.getInt("villager", "Flesh Count", null, 3);
		villagerFleshP = CSConfig.getFloat("villager", "Flesh Probability", null, 0.2F);
		
		slimeCoreC = CSConfig.getInt("slime", "Core Count", null, 1);
		slimeCoreP = CSConfig.getFloat("slime", "Core Probability", null, 0.1F);
		
		silverfishCarcassC = CSConfig.getInt("silverfish", "Carcass Count", null, 1);
		silverfishCarcassP = CSConfig.getFloat("silverfish", "Carcass Probability", null, 0.5F);
		
		spiderBonesC = CSConfig.getInt("spider", "Bones Count", null, 1);
		spiderLegC = CSConfig.getInt("spider", "Leg Count", null, 4);
		spiderBonesP = CSConfig.getFloat("spider", "Bones Probability", null, 0.05F);
		spiderLegP = CSConfig.getFloat("spider", "Leg Probability", null, 0.15F);
		
		caveSpiderBonesC = CSConfig.getInt("cave_spider", "Bones Count", null, 1);
		caveSpiderPoisonSackC = CSConfig.getInt("cave_spider", "Poison Sack Count", null, 2);
		caveSpiderLegC = CSConfig.getInt("cave_spider", "Leg Count", null, 4);
		caveSpiderBonesP = CSConfig.getFloat("cave_spider", "Bones Probability", null, 0.05F);
		caveSpiderPoisonSackP = CSConfig.getFloat("cave_spider", "Poison Sack Probability", null, 0.3F);
		caveSpiderLegP = CSConfig.getFloat("cave_spider", "Leg Probability", null, 0.15F);
		
		skeletonMarrowC = CSConfig.getInt("skeleton", "Marrow Count", null, 3);
		skeletonMarrowP = CSConfig.getFloat("skeleton", "Marrow Probability", null, 0.15F);
		
		witherSkeletonBonesC = CSConfig.getInt("wither_skeleton", "Bones Count", null, 3);
		witherSkeletonBonesP = CSConfig.getFloat("wither_skeleton", "Bones Probability", null, 0.2F);
		
		creeperHideC = CSConfig.getInt("creeper", "Hide Count", null, 2);
		creeperHideP = CSConfig.getFloat("creeper", "Hide Probability", null, 0.1F);
		
		pigZombieSnoutC = CSConfig.getInt("pig_zombie", "Snout Count", null, 1);
		pigZombieHoofC = CSConfig.getInt("pig_zombie", "Hoof Count", null, 2);
		pigZombieFatC = CSConfig.getInt("pig_zombie", "Fat Count", null, 2);
		pigZombieBonesC = CSConfig.getInt("pig_zombie", "Bones Count", null, 2);
		pigZombieMarrowC = CSConfig.getInt("pig_zombie", "Marrow Count", null, 3);
		pigZombieSnoutP = CSConfig.getFloat("pig_zombie", "Snout Probability", null, 0.1F);
		pigZombieHoofP = CSConfig.getFloat("pig_zombie", "Hoof Probability", null, 0.1F);
		pigZombieFatP = CSConfig.getFloat("pig_zombie", "Fat Probability", null, 0.15F);
		pigZombieBonesP = CSConfig.getFloat("pig_zombie", "Bones Probability", null, 0.1F);
		pigZombieMarrowP = CSConfig.getFloat("pig_zombie", "Marrow Probability", null, 0.1F);
		
		ghastTentacleC = CSConfig.getInt("ghast", "Tentacle Count", null, 4);
		ghastTentacleP = CSConfig.getFloat("ghast", "Tentacle Probability", null, 0.15F);
		
		endermanCoreC = CSConfig.getInt("enderman", "Core Count", null, 1);
		endermanAuraC = CSConfig.getInt("enderman", "Aura Count", null, 2);
		endermanCoreP = CSConfig.getFloat("enderman", "Core Probability", null, 0.25F);
		endermanAuraP = CSConfig.getFloat("enderman", "Aura Probability", null, 0.20F);
		
		witherBoneC = CSConfig.getInt("wither", "Bones Count", null, 15);
		witherBoneP = CSConfig.getFloat("wither", "Bones Probability", null, 1F);
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
		if (random.nextFloat() / looting < sheepBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(sheepBonesC + looting));
		}
		if (random.nextFloat() / looting < sheepLambchopP)
		{
			living.dropItem(onFire ? MItems.lambchopCooked : MItems.lambchopRaw, random.nextInt(sheepLambchopC + looting));
		}
		if (random.nextFloat() / looting < sheepHoofP)
		{
			living.dropItem(MItems.sheepHoof, random.nextInt(sheepHoofC + looting));
		}
	}
	
	private static void dropChickenItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < chickenBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(chickenBonesC + looting));
		}
		if (random.nextFloat() / looting < chickenBeakP)
		{
			living.dropItem(MItems.beakChicken, random.nextInt(chickenBeakC + looting));
		}
		if (random.nextFloat() / looting < chickenFootP)
		{
			living.dropItem(MItems.footChicken, random.nextInt(chickenFootC + looting));
		}
		if (random.nextFloat() / looting < chickenWingP)
		{
			living.dropItem(onFire ? MItems.chickenWingCooked : MItems.chickenWingRaw, random.nextInt(chickenWingC + looting));
		}
	}
	
	private static void dropSquidItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < squidTentacleP)
		{
			living.dropItem(MItems.squidTentacle, random.nextInt(squidTentacleC + looting));
		}
		if (random.nextFloat() / looting < squidAirSackP)
		{
			living.dropItem(MItems.airSack, random.nextInt(squidAirSackC + looting));
		}
	}
	
	private static void dropOcelotItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < ocelotChickenFootP)
		{
			living.dropItem(MItems.footChicken, random.nextInt(ocelotChickenFootC + looting));
		}
		if (random.nextFloat() / looting < ocelotWhiskerP)
		{
			living.dropItem(MItems.whisker, random.nextInt(ocelotWhiskerC + looting));
		}
		if (random.nextFloat() / looting < ocelotEyeP)
		{
			living.dropItem(MItems.catEye, random.nextInt(ocelotEyeC + looting));
		}
	}
	
	private static void dropBatItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < batGuanoP)
		{
			living.dropItem(MItems.guano, random.nextInt(batGuanoC + looting));
		}
		if (random.nextFloat() / looting < batWingP)
		{
			living.dropItem(MItems.wingSinew, random.nextInt(batWingC + looting));
		}
	}
	
	private static void dropWolfItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < wolfSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(wolfSnoutC + looting));
		}
		if (random.nextFloat() / looting < wolfHideP)
		{
			living.dropItem(MItems.wolfHide, random.nextInt(wolfHideC + looting));
		}
	}
	
	private static void dropVillagerItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < villagerFleshP)
		{
			living.dropItem(MItems.flesh, random.nextInt(villagerFleshC + looting));
		}
	}
	
	private static void dropSlimeItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < slimeCoreP)
		{
			living.dropItem(MItems.slimeCore, slimeCoreC);
		}
	}
	
	private static void dropSilverfishItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < silverfishCarcassP)
		{
			living.dropItem(MItems.carcassSilverfish, silverfishCarcassC);
		}
	}
	
	private static void dropSpiderItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < spiderBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(spiderBonesC + looting));
		}
		if (random.nextFloat() / looting < spiderLegP)
		{
			living.dropItem(MItems.legSpider, random.nextInt(spiderLegC + looting));
		}
	}
	
	private static void dropCaveSpiderItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < caveSpiderBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(caveSpiderBonesC + looting));
		}
		if (random.nextFloat() / looting < caveSpiderPoisonSackP)
		{
			living.dropItem(MItems.poisonSack, random.nextInt(caveSpiderPoisonSackC + looting));
		}
		if (random.nextFloat() / looting < caveSpiderLegP)
		{
			living.dropItem(MItems.legSpider, random.nextInt(caveSpiderLegC + looting));
		}
	}
	
	private static void dropSkeletonItems(EntityLivingBase living, Random random, int looting)
	{
		EntitySkeleton skeleton = (EntitySkeleton) living;
		if (skeleton.getSkeletonType() == 1)
		{
			if (random.nextFloat() / looting < witherSkeletonBonesP)
			{
				living.dropItem(MItems.witheredBone, random.nextInt(witherSkeletonBonesC + looting));
			}
		}
		else if (random.nextFloat() / looting < skeletonMarrowP)
		{
			living.dropItem(MItems.marrow, random.nextInt(skeletonMarrowC + looting));
		}
	}
	
	private static void dropCreeperItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < creeperHideP)
		{
			living.dropItem(MItems.hideCreeper, random.nextInt(creeperHideC + looting));
		}
	}
	
	private static void dropPigZombieItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < pigZombieSnoutP)
		{
			living.dropItem(MItems.snout, random.nextInt(pigZombieSnoutC + looting));
		}
		if (random.nextFloat() / looting < pigZombieHoofP)
		{
			living.dropItem(MItems.pigHoof, random.nextInt(pigZombieHoofC + looting));
		}
		if (random.nextFloat() / looting < pigZombieFatP)
		{
			living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(pigZombieFatC + looting));
		}
		if (random.nextFloat() / looting < pigZombieBonesP)
		{
			living.dropItem(MItems.animalBones, random.nextInt(pigZombieBonesC + looting));
		}
		if (random.nextFloat() / looting < pigZombieMarrowP)
		{
			living.dropItem(MItems.marrow, random.nextInt(pigZombieMarrowC + looting));
		}
	}
	
	private static void dropGhastItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < ghastTentacleP)
		{
			living.dropItem(MItems.ghastTentacle, random.nextInt(ghastTentacleC + looting));
		}
	}
	
	private static void dropEndermanItems(EntityLivingBase living, Random random, int looting)
	{
		if (random.nextFloat() / looting < endermanCoreP)
		{
			living.dropItem(MItems.enderCore, endermanCoreC);
		}
		if (random.nextFloat() / looting < endermanAuraP)
		{
			living.dropItem(MItems.enderAura, random.nextInt(endermanAuraC + looting));
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
		if (random.nextFloat() / looting < witherBoneP)
		{
			living.dropItem(MItems.witheredBone, random.nextInt(witherBoneC + looting));
		}
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
