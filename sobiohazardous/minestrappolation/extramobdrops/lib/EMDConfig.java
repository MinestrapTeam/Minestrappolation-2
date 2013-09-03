package sobiohazardous.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
	whiskerId;
	
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
		hornSandstoneId = config.getItem("Horned Sandstone Sword", 4017).getInt();
		hornGraniteId = config.getItem("Horned Granite Sword", 4018).getInt();
		hornCopperId = config.getItem("Horned Copper Sword", 4019).getInt();
		hornSteelId = config.getItem("Horned Steel Sword", 4020).getInt();
		hornBronzeId = config.getItem("Horned Bronze Sword", 4021).getInt();
		hornMeuroditeId = config.getItem("Horned Meurodite Sword", 4022).getInt();
		hornToriteId = config.getItem("Horned Torite Sword", 4023).getInt();
		hornBlaziumId = config.getItem("Horned Blazium Sword", 4024).getInt();
		hornTitaniumId = config.getItem("Horned Titanium Sword", 4025).getInt();
		beakChickenId = config.getItem("Chicken Beak", 4026).getInt();
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
		
		config.save();
	}
}
