package sobiohazardous.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.extramobdrops.CreativeTabExtraMobDropsItems;
import sobiohazardous.minestrappolation.extramobdrops.item.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;

public class EMDItemManager 
{
	public static Item snout;
	public static Item pigHoof;
	public static Item fat;
	public static Item grease;
	
	public static Item friedApple;
	public static Item friedBeef;
	public static Item friedBread;
	public static Item friedCarrot;
	public static Item friedCookie;
	public static Item friedFlesh;
	
	public static Item animalBones;
	public static Item cowHoof;
	public static Item horn;
	
	public static Item hornSwordWood;
	public static Item hornSwordStone;
	public static Item hornSwordIron;
	public static Item hornSwordDiamond;
	public static Item hornSwordGold;
	
	public static Item hornSandstone;
	public static Item hornGranite;
	public static Item hornCopper;
	public static Item hornSteel;
	public static Item hornBronze;
	public static Item hornMeurodite;
	public static Item hornTorite;
	public static Item hornBlazium;
	public static Item hornTitanium;
	
	public static Item beakChicken;
	
	public static Item footChicken;
	
	public static Item chickenWingRaw;
	public static Item chickenWingCooked;
	
	public static Item lambchopRaw;
	public static Item lambchopCooked;
	
	public static Item sheepHoof;
	
	public static Item squidTentacle;	
	public static Item calimari;
	
	public static Item infectiousFungus;
	
	public static Item airSack;
	
	public static Item whisker;
	
	public static Item catEye;
	
	public static Item wolfHide;
	
	public static Item flesh;
	
	public static Item marrow;
	
	public static Item legSpider;
	public static Item poisonSack;
	
	public static Item swordPoisonWood;
	public static Item swordPoisonStone;
	public static Item swordPoisonIron;
	public static Item swordPoisonDiamond;
	public static Item swordPoisonGold;
	
	public static Item swordPosionSandstone;
	public static Item swordPosionGranite;
	public static Item swordPosionCopper;
	public static Item swordPosionSteel;
	public static Item swordPosionBronze;
	public static Item swordPosionMeurodite;
	public static Item swordPosionTorite;
	public static Item swordPosionBlazium;
	public static Item swordPosionTitanium;
	
	public static Item guano;
	public static Item carcassSilverfish;
	
	public static Item hideCreeper;
	
	public static Item slimeCore;	
	public static Item enderCore;

	public static Item ghastTentacle;
	
	public static Item horseHoof;
	public static Item rawHorseHaunch;
	public static Item cookedHorseHaunch;
	public static Item horseHair;
	
	public static Item genes;
	
	public static Item charms;
	
	public static Item amuletPorcum;
	public static Item amuletVaccam;
	public static Item amuletPullum;
	public static Item amuletOves;
	
	public static Item wingSinew;
	public static Item wingSegment;
	
	public static Item hangGlider;
	
	public static Item enderAura;
	
	public static Item ghastlySoul;
	
	public static Item witheredBone;
	
	public static Item horseHairFibre;
	
	public static EnumToolMaterial toolMaterialWoodH = EnumHelper.addToolMaterial("ToolWoodH", 0, 59, 2.0F, 2.0F, 15);
	public static EnumToolMaterial toolMaterialStoneH = EnumHelper.addToolMaterial("ToolStoneH", 1, 131, 4.0F, 3.0F, 5);
	public static EnumToolMaterial toolMaterialIronH = EnumHelper.addToolMaterial("ToolIronH", 2, 250, 6.0F, 4.0F, 14);
	public static EnumToolMaterial toolMaterialDiamondH = EnumHelper.addToolMaterial("ToolDiamondH", 3, 1561, 8.0F, 5.0F, 10);
	public static EnumToolMaterial toolMaterialGoldH = EnumHelper.addToolMaterial("ToolGoldH", 0, 32, 12.0F, 2.0F, 22);
	
	public static EnumToolMaterial toolMaterialSandstoneH = EnumHelper.addToolMaterial("ToolSandstoneH", 1, 111, 4.5F, 4, 6);
	public static EnumToolMaterial toolMaterialGraniteH = EnumHelper.addToolMaterial("ToolGraniteH", 1, 199, 4.3F, 4, 4);
	public static EnumToolMaterial toolMaterialCopperH = EnumHelper.addToolMaterial("ToolCopperH", 1, 139, 5.0F, 4, 10);
	public static EnumToolMaterial toolMaterialSteelH = EnumHelper.addToolMaterial("ToolSteelH", 2, 300, 7.5F, 5, 15);
	public static EnumToolMaterial toolMaterialBronzeH = EnumHelper.addToolMaterial("ToolBronzeH", 2, 1501, 6.5F, 4, 8);
	public static EnumToolMaterial toolMaterialMeuroditeH = EnumHelper.addToolMaterial("ToolMeuroditeH", 2, 805, 7.0F, 4, 15);
	public static EnumToolMaterial toolMaterialToriteH = EnumHelper.addToolMaterial("ToolToriteH", 2, 699, 6.0F, 5, 20);
	public static EnumToolMaterial toolMaterialBlaziumH = EnumHelper.addToolMaterial("ToolBlaziumH", 2, 799, 8.0F, 5, 18);
	public static EnumToolMaterial toolMaterialTitaniumH = EnumHelper.addToolMaterial("ToolTitaniumH", 4, 2999, 10.0F, 6, 11);
	
	public static CreativeTabs tabItems = new CreativeTabExtraMobDropsItems(CreativeTabs.getNextID(), "Extrappolated Mob Drops - Items");

	public static void loadItems()
	{
		snout = new MItemFood(EMDConfig.snoutId, 3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setUnlocalizedName("snout").setCreativeTab(tabItems);
		pigHoof = new MItem(EMDConfig.pigHoofId).setUnlocalizedName("pig_foot").setCreativeTab(tabItems);
		fat = new MItemFood(EMDConfig.fatId, 8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setCreativeTab(tabItems);
		grease = new MItem(EMDConfig.greaseId).setUnlocalizedName("grease").setCreativeTab(tabItems);
		
		friedApple = new MItemFood(EMDConfig.friedAppleId, 8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_apple").setCreativeTab(tabItems);
		friedBeef = new MItemFood(EMDConfig.friedBeefId, 16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_beef").setCreativeTab(tabItems);
		friedBread = new MItemFood(EMDConfig.friedBreadId, 10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_bread").setCreativeTab(tabItems);
		friedCarrot = new MItemFood(EMDConfig.friedCarrotId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_carrot").setCreativeTab(tabItems);
		friedCookie = new MItemFood(EMDConfig.friedCookieId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_cookie").setCreativeTab(tabItems);
		friedFlesh = new MItemFood(EMDConfig.friedFleshId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_flesh").setCreativeTab(tabItems);
		
		animalBones = new MItem(EMDConfig.animalBonesId).setUnlocalizedName("animal_bones").setCreativeTab(tabItems);
		cowHoof = new MItem(EMDConfig.cowHoofId).setUnlocalizedName("cow_hoof").setCreativeTab(tabItems);
		
		horn = new MItem(EMDConfig.hornId).setUnlocalizedName("horn").setCreativeTab(tabItems);
		
		hornSwordWood = new MItemSword(EMDConfig.hornSwordWoodId, toolMaterialWoodH, false).setUnlocalizedName("horned_wood_sword").setCreativeTab(tabItems);
		hornSwordStone = new MItemSword(EMDConfig.hornSwordStoneId, toolMaterialStoneH, false).setUnlocalizedName("horned_stone_sword").setCreativeTab(tabItems);
		hornSwordIron = new MItemSword(EMDConfig.hornSwordIronId, toolMaterialIronH, false).setUnlocalizedName("horned_iron_sword").setCreativeTab(tabItems);
		hornSwordDiamond = new MItemSword(EMDConfig.hornSwordDiamondId, toolMaterialDiamondH, false).setUnlocalizedName("horned_diamond_sword").setCreativeTab(tabItems);
		hornSwordGold = new MItemSword(EMDConfig.hornSwordGoldId, toolMaterialGoldH, false).setUnlocalizedName("horned_gold_sword").setCreativeTab(tabItems);
		
		beakChicken = new MItem(EMDConfig.beakChickenId).setUnlocalizedName("chicken_beak").setCreativeTab(tabItems);
			
		footChicken = new MItem(EMDConfig.footChickenId).setUnlocalizedName("chicken_foot").setCreativeTab(tabItems);
	
		chickenWingRaw = new MItemFood(EMDConfig.chickenWingRawId, 1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setUnlocalizedName("raw_chicken_wing").setCreativeTab(tabItems);
		chickenWingCooked = new MItemFood(EMDConfig.chickenWingCookedId, 4, 0.65F).setUnlocalizedName("cooked_chicken_wing").setCreativeTab(tabItems);
	
		lambchopRaw = new MItemFood(EMDConfig.lambchopRawId, 3, 0.2F).setUnlocalizedName("raw_lamb_chop").setCreativeTab(tabItems);
		lambchopCooked = new ItemCookedLambchop(EMDConfig.lambchopCookedId, 6, 0.8F).setUnlocalizedName("cooked_lamb_chop").setCreativeTab(tabItems);
		
		sheepHoof = new MItem(EMDConfig.sheepHoofId).setUnlocalizedName("sheep_hoof").setCreativeTab(tabItems);
	
		squidTentacle = new MItemFood(EMDConfig.squidTentacleId, 2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setUnlocalizedName("tentacle").setCreativeTab(tabItems);
		calimari = new ItemCalimari(EMDConfig.calimariId, 2, 0.6F).setUnlocalizedName("calamari").setCreativeTab(tabItems);
	
		infectiousFungus = new ItemInfectiousFungus(EMDConfig.infectiousFungusId, 0, 0F).setUnlocalizedName("infectious_fungus").setCreativeTab(tabItems);
		
		airSack = new ItemAirSack(EMDConfig.airSackId).setUnlocalizedName("air_sack").setCreativeTab(tabItems);
	
		whisker = new MItem(EMDConfig.whiskerId).setUnlocalizedName("whisker").setCreativeTab(tabItems);
		
		catEye = new ItemCatEye(EMDConfig.catEyeId, 0, 0.0F).setUnlocalizedName("cat_eye").setCreativeTab(tabItems);
	
		wolfHide = new MItem(EMDConfig.wolfHideId).setUnlocalizedName("wolf_hide").setCreativeTab(tabItems);
	
		flesh = new MItemFood(EMDConfig.fleshId, 4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setUnlocalizedName("flesh").setCreativeTab(tabItems);
	
		marrow = new MItemFood(EMDConfig.marrowId, 5, 0.0F).setUnlocalizedName("marrow").setCreativeTab(tabItems);
	
		legSpider = new MItem(EMDConfig.legSpiderId).setUnlocalizedName("spider_leg").setCreativeTab(tabItems);
		poisonSack = new MItem(EMDConfig.poisonSackId).setUnlocalizedName("poison_sack").setCreativeTab(tabItems);
		
		swordPoisonWood = new ItemPoisonSword(EMDConfig.swordPoisonWoodId, EnumToolMaterial.WOOD, Item.swordWood.itemID).setUnlocalizedName("woodSwordPoison").setTextureName("wood_sword").setCreativeTab(tabItems);
		swordPoisonStone = new ItemPoisonSword(EMDConfig.swordPoisonStoneId, EnumToolMaterial.STONE, Item.swordStone.itemID).setUnlocalizedName("stoneSwordPoison").setTextureName("stone_sword").setCreativeTab(tabItems);
		swordPoisonIron = new ItemPoisonSword(EMDConfig.swordPoisonIronId, EnumToolMaterial.IRON, Item.swordIron.itemID).setUnlocalizedName("ironSwordPoison").setTextureName("iron_sword").setCreativeTab(tabItems);
		swordPoisonDiamond = new ItemPoisonSword(EMDConfig.swordPoisonDiamondId, EnumToolMaterial.EMERALD, Item.swordDiamond.itemID).setUnlocalizedName("diamondSwordPoison").setTextureName("diamond_sword").setCreativeTab(tabItems);
		swordPoisonGold = new ItemPoisonSword(EMDConfig.swordPoisonGoldId, EnumToolMaterial.GOLD, Item.swordGold.itemID).setUnlocalizedName("goldSwordPoison").setTextureName("gold_sword").setCreativeTab(tabItems);
		
		guano = new ItemGuano(EMDConfig.guanoId).setUnlocalizedName("guano").setCreativeTab(tabItems);
		carcassSilverfish = new MItem(EMDConfig.carcassSilverfishId).setUnlocalizedName("silverfish_carcass").setCreativeTab(tabItems);
		
		hideCreeper = new MItem(EMDConfig.hideCreeperId).setUnlocalizedName("creeper_hide").setCreativeTab(tabItems);
		
		slimeCore = new MItem(EMDConfig.slimeCoreId).setUnlocalizedName("slime_core").setCreativeTab(tabItems);
		enderCore = new ItemEnderCore(EMDConfig.enderCoreId, 0, 0).setUnlocalizedName("ender_core").setCreativeTab(tabItems);
	
		ghastTentacle = new ItemGhastTentacle(EMDConfig.ghastTentacleId).setUnlocalizedName("ghast_tentacle").setCreativeTab(tabItems);
		
		horseHoof = new MItem(EMDConfig.horseHoofId).setCreativeTab(tabItems).setUnlocalizedName("horse_foot");
		rawHorseHaunch = new MItemFood(EMDConfig.rawHorseHaunchId, 4, 0.4F).setCreativeTab(tabItems).setUnlocalizedName("raw_horse_haunch");
		cookedHorseHaunch = new MItemFood(EMDConfig.cookedHorseHaunchId, 10, 0.8F).setCreativeTab(tabItems).setUnlocalizedName("cooked_horse_haunch");
		horseHair = new MItem(EMDConfig.horseHairId).setCreativeTab(tabItems).setUnlocalizedName("horse_hair");
		
		genes = new ItemGene(EMDConfig.genesId).setUnlocalizedName("gene");
		
		charms = new ItemCharm(EMDConfig.charmsId).setUnlocalizedName("charm").setCreativeTab(tabItems);
		
		amuletPorcum = new ItemAmuletPorcum(EMDConfig.amuletPorcumId).setUnlocalizedName("PorcumAmulet").setCreativeTab(tabItems);
		amuletVaccam = new ItemAmuletVaccam(EMDConfig.amuletVaccamId).setUnlocalizedName("VaccamAmulet").setCreativeTab(tabItems);
		amuletPullum = new ItemAmuletPullum(EMDConfig.amuletPullumId).setUnlocalizedName("PullumAmulet").setCreativeTab(tabItems);
		amuletOves = new ItemAmuletOves(EMDConfig.amuletOvesId).setUnlocalizedName("OvesAmulet").setCreativeTab(tabItems);
		
		wingSinew = new MItem(EMDConfig.wingSinewId).setUnlocalizedName("wing_sinew").setCreativeTab(tabItems);
		wingSegment = new MItem(EMDConfig.wingSegmentId).setUnlocalizedName("wing_segment").setCreativeTab(tabItems);
		
		hangGlider = new ItemHangGlider(EMDConfig.hangGliderId).setUnlocalizedName("hangglider").setCreativeTab(tabItems);
		
		enderAura = new MItem(EMDConfig.enderAuraId).setUnlocalizedName("item_EnderAura1").setCreativeTab(tabItems);
		
		ghastlySoul = new MItem(EMDConfig.ghastlySoulId).setUnlocalizedName("item_GhastlySoul").setCreativeTab(tabItems);
		
		witheredBone = new MItem(EMDConfig.witheredBoneId).setUnlocalizedName("withered_bone").setCreativeTab(tabItems);
		
		horseHairFibre = new MItem(EMDConfig.horseHairFibreId).setUnlocalizedName("horse_hair_fibre").setCreativeTab(tabItems);
	}
	
	public static void loadNames()
	{
		LanguageRegistry.addName(snout, "Snout");
		LanguageRegistry.addName(pigHoof, "Pig Hoof");
		LanguageRegistry.addName(fat, "Fat");
		LanguageRegistry.addName(grease, "Grease");
		LanguageRegistry.addName(friedApple, "Fried Apple");
		LanguageRegistry.addName(friedBeef, "Fried Beef");
		LanguageRegistry.addName(friedBread, "Fried Bread");
		LanguageRegistry.addName(friedCarrot, "Fried Carrot");
		LanguageRegistry.addName(friedCookie, "Fried Cookie");
		LanguageRegistry.addName(friedFlesh, "Fried Flesh");
		LanguageRegistry.addName(animalBones, "Amimal Bones");
		LanguageRegistry.addName(cowHoof, "Cow Hoof");
		LanguageRegistry.addName( horn, "Horn");
		LanguageRegistry.addName( beakChicken, "Chicken Beak");
		LanguageRegistry.addName( footChicken, "Chicken Foot");
		LanguageRegistry.addName(chickenWingRaw, "Raw Chicken Wing");
		LanguageRegistry.addName(chickenWingCooked, "Cooked Chicken Wing");
		LanguageRegistry.addName(lambchopRaw, "Raw Lamb Chop");
		LanguageRegistry.addName(lambchopCooked, "Cooked Lamb Chop");
		LanguageRegistry.addName(sheepHoof, "Sheep Hoof");
		LanguageRegistry.addName(squidTentacle, "Squid Tentacle");
		LanguageRegistry.addName(calimari, "Calamari");
		LanguageRegistry.addName(infectiousFungus, "Infectious Fungus");
		LanguageRegistry.addName(airSack, "Air Sack");
		LanguageRegistry.addName(whisker, "Whisker");
		LanguageRegistry.addName(catEye, "Cat Eye");
		LanguageRegistry.addName(wolfHide, "Wolf Hide");
		LanguageRegistry.addName(flesh, "Flesh");
		LanguageRegistry.addName(marrow, "Marrow");
		LanguageRegistry.addName(legSpider, "Spider Leg");
		LanguageRegistry.addName(poisonSack, "Poison Sack");
		LanguageRegistry.addName(swordPoisonWood, "Wood Sword");
		LanguageRegistry.addName(swordPoisonStone, "Stone Sword");
		LanguageRegistry.addName(swordPoisonIron, "Iron Sword");
		LanguageRegistry.addName(swordPoisonDiamond, "Diamond Sword");
		LanguageRegistry.addName(swordPoisonGold, "Gold Sword");
		LanguageRegistry.addName(guano, "Guano");
		LanguageRegistry.addName(carcassSilverfish, "Silverfish Carcass");
		LanguageRegistry.addName(hideCreeper, "Creeper Hide");
		LanguageRegistry.addName(slimeCore, "Slime Core");
		LanguageRegistry.addName(enderCore, "Ender Core");
		LanguageRegistry.addName(ghastTentacle, "Ghast Tentacle");
		LanguageRegistry.addName(horseHoof, "Horse Hoof");
		LanguageRegistry.addName(rawHorseHaunch, "Raw Horse Haunch");
		LanguageRegistry.addName(cookedHorseHaunch, "Cooked Horse Haunch");
		LanguageRegistry.addName(horseHair, "Horse Hair");
		
		LanguageRegistry.instance().addStringLocalization("item.gene.pig.name", "Pig Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.cow.name", "Cow Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.chicken.name", "Chicken Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.sheep.name", "Sheep Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.horse.name", "Horse Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.mooshroom.name", "Mooshroom Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.squid.name", "Squid Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.ocelot.name", "Ocelot Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.wolf.name", "Wolf Gene");
		LanguageRegistry.instance().addStringLocalization("item.gene.bat.name", "Bat Gene");
		
		LanguageRegistry.instance().addStringLocalization("item.charm.pig.name", "Porcum Charm");
		LanguageRegistry.instance().addStringLocalization("item.charm.cow.name", "Vaccam Charm");
		LanguageRegistry.instance().addStringLocalization("item.charm.chicken.name", "Pullum Charm");
		LanguageRegistry.instance().addStringLocalization("item.charm.sheep.name", "Oves Charm");
		LanguageRegistry.instance().addStringLocalization("item.charm.horse.name", "Equus Charm");
		
		LanguageRegistry.addName(amuletPorcum, "Porcum Amulet");
		LanguageRegistry.addName(amuletVaccam, "Vaccam Amulet");
		LanguageRegistry.addName(amuletPullum, "Pullum Amulet");
		LanguageRegistry.addName(amuletOves, "Oves Amulet");
		LanguageRegistry.addName(wingSinew, "Wing Sinew");
		LanguageRegistry.addName(wingSegment, "Wing Segment");
		LanguageRegistry.addName(hangGlider, "Hang Glider");
		LanguageRegistry.addName(enderAura, "Ender Aura");
		LanguageRegistry.addName(ghastlySoul, "Ghastly Soul");
		LanguageRegistry.addName(witheredBone, "Withered Bone");
		LanguageRegistry.addName(horseHairFibre, "Horse Hair Fibre");
	}
	
	public static void loadBridgedItems() throws Exception
	{
		if(Loader.isModLoaded("ExtraOres"))
		{
			hornSandstone = new MItemSword(EMDConfig.hornSandstoneId, toolMaterialSandstoneH, false).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(tabItems);
			hornGranite= new MItemSword(EMDConfig.hornGraniteId, toolMaterialGraniteH, false).setUnlocalizedName("horned_granite_sword").setCreativeTab(tabItems);
			hornCopper= new MItemSword(EMDConfig.hornCopperId, toolMaterialCopperH, false).setUnlocalizedName("horned_copper_sword").setCreativeTab(tabItems);
			hornSteel= new MItemSword(EMDConfig.hornSteelId, toolMaterialSteelH, false).setUnlocalizedName("horned_steel_sword").setCreativeTab(tabItems);
			hornBronze= new MItemSword(EMDConfig.hornBronzeId, toolMaterialBronzeH, false).setUnlocalizedName("horned_bronze_sword").setCreativeTab(tabItems);
			hornMeurodite= new MItemSword(EMDConfig.hornMeuroditeId, toolMaterialMeuroditeH, false).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(tabItems);
			hornTorite= new MItemSword(EMDConfig.hornToriteId, toolMaterialToriteH, false).setUnlocalizedName("horned_torite_sword").setCreativeTab(tabItems);
			hornBlazium= new MItemSword(EMDConfig.hornBlaziumId, toolMaterialBlaziumH, true).setUnlocalizedName("horned_fire_sword").setCreativeTab(tabItems);
			hornTitanium= new MItemSword(EMDConfig.hornTitaniumId, toolMaterialTitaniumH, false).setUnlocalizedName("horned_titanium_sword").setCreativeTab(tabItems);
			
			swordPosionSandstone = new ItemPoisonSword(EMDConfig.swordPoisonSandstoneId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSandstone, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword.itemID).setUnlocalizedName("sandstoneSwordPoison").setTextureName("minestrappolation:item_SandstoneSword").setCreativeTab(tabItems);
			swordPosionGranite = new ItemPoisonSword(EMDConfig.swordPoisonGraniteId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialGranite, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword.itemID).setUnlocalizedName("graniteSwordPoison").setTextureName("minestrappolation:item_GraniteSword").setCreativeTab(tabItems);
			swordPosionCopper = new ItemPoisonSword(EMDConfig.swordPoisonCopperId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialCopper, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword.itemID).setUnlocalizedName("copperSwordPoison").setTextureName("minestrappolation:item_CopperSword").setCreativeTab(tabItems);
			swordPosionSteel = new ItemPoisonSword(EMDConfig.swordPoisonSteelId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSteel, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword.itemID).setUnlocalizedName("steelSwordPoison").setTextureName("minestrappolation:item_SteelSword").setCreativeTab(tabItems);
			swordPosionBronze = new ItemPoisonSword(EMDConfig.swordPoisonBronzeId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBronze, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword.itemID).setUnlocalizedName("bronzeSwordPoison").setTextureName("minestrappolation:item_BronzeSword").setCreativeTab(tabItems);
			swordPosionMeurodite = new ItemPoisonSword(EMDConfig.swordPoisonMeuroditeId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialMeurodite, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword.itemID).setUnlocalizedName("meuroditeSwordPoison").setTextureName("minestrappolation:item_MeuroditeSword").setCreativeTab(tabItems);
			swordPosionTorite = new ItemPoisonSword(EMDConfig.swordPoisonToriteId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTorite, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword.itemID).setUnlocalizedName("toriteSwordPoison").setTextureName("minestrappolation:item_ToriteSword").setCreativeTab(tabItems);
			swordPosionBlazium = new ItemPoisonSword(EMDConfig.swordPoisonBlaziumId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBlazium, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword.itemID).setUnlocalizedName("blaziumSwordPoison").setTextureName("minestrappolation:item_BlaziumSword").setCreativeTab(tabItems);
			swordPosionTitanium = new ItemPoisonSword(EMDConfig.swordPoisonTitaniumId, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTitanium, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword.itemID).setUnlocalizedName("titaniumSwordPoison").setTextureName("minestrappolation:item_TitaniumSword").setCreativeTab(tabItems);
			
			LanguageRegistry.addName(hornSwordWood, "Horned Wood Sword");
			LanguageRegistry.addName(hornSwordStone, "Horned Stone Sword");
			LanguageRegistry.addName(hornSwordIron, "Horned Iron Sword");
			LanguageRegistry.addName(hornSwordDiamond, "Horned Diamond Sword");
			LanguageRegistry.addName(hornSwordGold, "Horned Gold Sword");
			LanguageRegistry.addName(hornSandstone, "Horned Sanstone Sword");
			LanguageRegistry.addName(hornGranite, "Horned Granite Sword");
			LanguageRegistry.addName(hornCopper, "Horned Copper Sword");
			LanguageRegistry.addName(hornSteel, "Horned Steel Sword");
			LanguageRegistry.addName(hornBronze, "Horned Bronze Sword");
			LanguageRegistry.addName(hornMeurodite, "Horned Meurodite Sword");
			LanguageRegistry.addName(hornTorite, "Horned Torite Sword");
			LanguageRegistry.addName(hornBlazium, "Horned Blazium Sword");
			LanguageRegistry.addName(hornTitanium, "Horned Titanium Sword");
			
			LanguageRegistry.addName(swordPosionSandstone, "Sandstone Sword");
			LanguageRegistry.addName(swordPosionGranite, "Granite Sword");
			LanguageRegistry.addName(swordPosionCopper, "Copper Sword");
			LanguageRegistry.addName(swordPosionSteel, "Steel Sword");
			LanguageRegistry.addName(swordPosionBronze, "Bronze Sword");
			LanguageRegistry.addName(swordPosionMeurodite, "Meurodite Sword");
			LanguageRegistry.addName(swordPosionTorite, "Torite Sword");
			LanguageRegistry.addName(swordPosionBlazium, "Blazium Sword");
			LanguageRegistry.addName(swordPosionTitanium, "Titanium Sword");

		}
	}
}
