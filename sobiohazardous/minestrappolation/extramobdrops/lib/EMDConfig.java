package sobiohazardous.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class EMDConfig 
{
	public static int snoutId,
	pigHoofId,
	fatId,
	greaseId,
	friedAppleId,
	friedBeefId,
	friedBreadId,
	friedCarrotId,
	friedCookieId,
	friedFleshId,
	animalBonesId,
	cowHoofId,
	hornId,
	hornSwordWoodId,
	hornSwordStoneId,
	hornSwordIronId,
	hornSwordDiamondId,
	hornSwordGoldId,
	hornSandstoneId,
	hornGraniteId,
	hornCopperId,
	hornSteelId,
	hornBronzeId,
	hornMeuroditeId,
	hornToriteId,
	hornBlaziumId,
	hornTitaniumId,
	beakChickenId,
	potionId,
	footChickenId,
	chickenWingRawId,
	chickenWingCookedId,
	lambchopRawId,
	lambchopCookedId,
	sheepHoofId,
	squidTentacleId,
	calimariId,
	infectiousFungusId,
	airSackId,
	whiskerId,
	catEyeId,
	wolfHideId,
	fleshId,
	marrowId,
	legSpiderId,
	poisonSackId,
	swordPoisonWoodId,
	swordPoisonStoneId,
	swordPoisonIronId,
	swordPoisonDiamondId,
	swordPoisonGoldId,
	swordPoisonSandstoneId,
	swordPoisonGraniteId,
	swordPoisonCopperId,
	swordPoisonSteelId,
	swordPoisonBronzeId,
	swordPoisonMeuroditeId,
	swordPoisonToriteId,
	swordPoisonBlaziumId,
	swordPoisonTitaniumId,
	guanoId,
	carcassSilverfishId,
	hideCreeperId,
	slimeCoreId,
	enderCoreId,
	ghastTentacleId,
	genesId,
	charmsId,
	amuletPorcumId,
	horseHoofId,
	rawHorseHaunchId,
	cookedHorseHaunchId,
	horseHairId,
	amuletVaccamId,
	amuletPullumId,
	amuletOvesId,
	wingSinewId,
	wingSegmentId,
	hangGliderId,
	enderAuraId,
	ghastlySoulId,
	witheredBoneId,
	horseHairFibreId;
	
	public static void initConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		//items 400
		snoutId = config.getItem("Snout", 4000).getInt();
		pigHoofId = config.getItem("Pig Hoof", 4001).getInt();
		fatId = config.getItem("Fat", 4002).getInt();
		greaseId = config.getItem("Grease", 4003).getInt();
		friedAppleId = config.getItem("Fried Apple", 4004).getInt();
		friedBeefId = config.getItem("Fried Beef", 4005).getInt();
		friedBreadId = config.getItem("Fried Bread", 4006).getInt();
		friedCarrotId = config.getItem("Fried Carrot", 4007).getInt();
		friedCookieId = config.getItem("Fried Cookie", 4008).getInt();
		friedFleshId = config.getItem("Fried Flesh", 4009).getInt();
		animalBonesId = config.getItem("Animal Bones", 4010).getInt();
		cowHoofId = config.getItem("Cow Hoof", 4011).getInt();
		hornId = config.getItem("Horn", 4012).getInt();
		hornSwordWoodId = config.getItem("Horned Wood Sword", 4013).getInt();
		hornSwordStoneId = config.getItem("Horned Stone Sword", 4014).getInt();
		hornSwordIronId = config.getItem("Horned Iron Sword", 4015).getInt();
		hornSwordDiamondId = config.getItem("Horned Diamond Sword", 4016).getInt();
		hornSwordGoldId = config.getItem("Horned Gold Sword", 4026).getInt();
		beakChickenId = config.getItem("Chicken Beak", 4026).getInt();
		hornSandstoneId = config.getItem("Horned Sandstone Sword", 4017).getInt();
		hornGraniteId = config.getItem("Horned Granite Sword", 4018).getInt();
		hornCopperId = config.getItem("Horned Copper Sword", 4019).getInt();
		hornSteelId = config.getItem("Horned Steel Sword", 4020).getInt();
		hornBronzeId = config.getItem("Horned Bronze Sword", 4021).getInt();
		hornMeuroditeId = config.getItem("Horned Meurodite Sword", 4022).getInt();
		hornToriteId = config.getItem("Horned Torite Sword", 4023).getInt();
		hornBlaziumId = config.getItem("Horned Blazium Sword", 4024).getInt();
		hornTitaniumId = config.getItem("Horned Titanium Sword", 4025).getInt();
		potionId = config.getItem("Potion", 4027).getInt();
		footChickenId = config.getItem("Chicken Foot", 4028).getInt();
		chickenWingRawId = config.getItem("Raw Chicken Wing", 4029).getInt();
		chickenWingCookedId = config.getItem("Cooked Chicken Wing", 4030).getInt();
		lambchopRawId = config.getItem("Raw Lamb Chop", 4031).getInt();
		lambchopCookedId = config.getItem("Cooked Lamb Chop", 4032).getInt();
		sheepHoofId = config.getItem("sheepHoof", 4033).getInt();
		squidTentacleId = config.getItem("Squid Tentacle", 4034).getInt();
		calimariId= config.getItem("Calimari", 4035).getInt();
		infectiousFungusId= config.getItem("Infectious Fungus", 4036).getInt();
		airSackId = config.getItem("Air Sack", 4037).getInt();
		whiskerId = config.getItem("Whisker", 4038).getInt();
		catEyeId = config.getItem("Cat Eye", 4039).getInt();
		wolfHideId = config.getItem("Wolf Hide", 4040).getInt();
		fleshId = config.getItem("Flesh", 4041).getInt();
		marrowId = config.getItem("Marrow", 4042).getInt();
		legSpiderId = config.getItem("Spider Leg", 4043).getInt();
		poisonSackId = config.getItem("Poison Sack", 4044).getInt();
		swordPoisonWoodId = config.getItem("Poisoned Wood Sword", 4045).getInt();
		swordPoisonStoneId = config.getItem("Poisoned Stone Sword", 4046).getInt();
		swordPoisonIronId = config.getItem("Poisoned Iron Sword", 4047).getInt();
		swordPoisonDiamondId = config.getItem("Poisoned Diamond Sword", 4048).getInt();
		swordPoisonGoldId = config.getItem("Poisoned Gold Sword", 4049).getInt();
		swordPoisonSandstoneId = config.getItem("Poisoned Sandstone Sword", 4050).getInt();
		swordPoisonGraniteId = config.getItem("Poisoned Granite Sword", 4051).getInt();
		swordPoisonCopperId = config.getItem("Poisoned Copper Sword", 4052).getInt();
		swordPoisonSteelId = config.getItem("Poisoned Steel Sword", 4053).getInt();
		swordPoisonBronzeId = config.getItem("Poisoned Bronze Sword", 4054).getInt();
		swordPoisonMeuroditeId = config.getItem("Poisoned Meurodite Sword", 4055).getInt();
		swordPoisonToriteId = config.getItem("Poisoned Torite Sword", 4056).getInt();
		swordPoisonBlaziumId = config.getItem("Poisoned Blazium Sword", 4057).getInt();
		swordPoisonTitaniumId = config.getItem("Poisoned Titanium Sword", 4058).getInt();
		guanoId = config.getItem("Guano", 4059).getInt();
		carcassSilverfishId = config.getItem("Silverfish Carcass", 4060).getInt();
		hideCreeperId = config.getItem("Creeper Hide", 4061).getInt();
		slimeCoreId = config.getItem("Slime Core", 4062).getInt();
		enderCoreId = config.getItem("Ender Core", 4063).getInt();
		ghastTentacleId = config.getItem("Ghast Tentacle", 4064).getInt();
		genesId = config.getItem("Genes", 4065).getInt();
		charmsId = config.getItem("Charms", 4066).getInt();
		amuletPorcumId = config.getItem("Porcum Amulet", 4067).getInt();
		horseHoofId = config.getItem("Horse Hoof", 4068).getInt();
		rawHorseHaunchId = config.getItem("Raw Horse Haunch", 4069).getInt();
		cookedHorseHaunchId = config.getItem("Cooked Horse Haunch", 4070).getInt();
		horseHairId = config.getItem("Horse Hair ", 4071).getInt();
		amuletVaccamId = config.getItem("Vaccam Amulet", 4072).getInt();
		amuletPullumId = config.getItem("Pullum Amulet", 4073).getInt();
		amuletOvesId = config.getItem("Oves Amulet", 4074).getInt();
		wingSinewId = config.getItem("Wing Sinew", 4075).getInt();
		wingSegmentId = config.getItem("Wing Segment", 4076).getInt();
		hangGliderId = config.getItem("Hang Glider", 4077).getInt();
		enderAuraId = config.getItem("Ender Aura", 4078).getInt();
		ghastlySoulId = config.getItem("Ghastly Soul", 4079).getInt();
		witheredBoneId = config.getItem("Withered Bone", 4080).getInt();
		horseHairFibreId = config.getItem("Horse Hair Fibre", 4081).getInt();
		config.save();
	}
}
