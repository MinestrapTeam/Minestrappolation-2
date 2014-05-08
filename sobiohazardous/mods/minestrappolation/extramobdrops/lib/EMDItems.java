package sobiohazardous.mods.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;
import sobiohazardous.mods.minestrappolation.core.item.MItemSword;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.creativetabs.CreativeTabEMDItems;
import sobiohazardous.mods.minestrappolation.extramobdrops.item.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.*;

public class EMDItems
{
	public static Item			snout;
	public static Item			pigHoof;
	public static Item			fat;
	public static Item			grease;
	
	public static Item			friedApple;
	public static Item			friedBeef;
	public static Item			friedBread;
	public static Item			friedCarrot;
	public static Item			friedCookie;
	public static Item			friedFlesh;
	
	public static Item			animalBones;
	public static Item			cowHoof;
	public static Item			horn;
	
	public static Item			hornSwordWood;
	public static Item			hornSwordStone;
	public static Item			hornSwordIron;
	public static Item			hornSwordDiamond;
	public static Item			hornSwordGold;
	
	public static Item			hornSandstone;
	public static Item			hornGranite;
	public static Item			hornCopper;
	public static Item			hornSteel;
	public static Item			hornBronze;
	public static Item			hornMeurodite;
	public static Item			hornTorite;
	public static Item			hornBlazium;
	public static Item			hornTitanium;
	
	public static Item			beakChicken;
	
	public static Item			footChicken;
	
	public static Item			chickenWingRaw;
	public static Item			chickenWingCooked;
	
	public static Item			lambchopRaw;
	public static Item			lambchopCooked;
	
	public static Item			sheepHoof;
	
	public static Item			squidTentacle;
	public static Item			calimari;
	
	public static Item			infectiousFungus;
	
	public static Item			airSack;
	
	public static Item			whisker;
	
	public static Item			catEye;
	
	public static Item			wolfHide;
	
	public static Item			flesh;
	
	public static Item			marrow;
	
	public static Item			legSpider;
	public static Item			poisonSack;
	
	public static Item			swordPoisonWood;
	public static Item			swordPoisonStone;
	public static Item			swordPoisonIron;
	public static Item			swordPoisonDiamond;
	public static Item			swordPoisonGold;
	
	public static Item			swordPosionSandstone;
	public static Item			swordPosionGranite;
	public static Item			swordPosionCopper;
	public static Item			swordPosionSteel;
	public static Item			swordPosionBronze;
	public static Item			swordPosionMeurodite;
	public static Item			swordPosionTorite;
	public static Item			swordPosionBlazium;
	public static Item			swordPosionTitanium;
	
	public static Item			guano;
	public static Item			carcassSilverfish;
	
	public static Item			hideCreeper;
	
	public static Item			slimeCore;
	public static Item			enderCore;
	
	public static Item			ghastTentacle;
	
	public static Item			horseHoof;
	public static Item			rawHorseHaunch;
	public static Item			cookedHorseHaunch;
	public static Item			horseHair;
	
	public static Item			genes;
	
	public static Item			charms;
	
	public static Item			amuletPorcum;
	public static Item			amuletVaccam;
	public static Item			amuletPullum;
	public static Item			amuletOves;
	
	public static Item			wingSinew;
	public static Item			wingSegment;
	
	public static Item			hangGlider;
	
	public static Item			enderAura;
	
	public static Item			ghastlySoul;
	
	public static Item			witheredBone;
	
	public static Item			horseHairFibre;
	public static Item			horseHairBow;
	
	public static ToolMaterial	toolMaterialWoodH		= EnumHelper.addToolMaterial("ToolWoodH", 0, 59, 2.0F, 2.0F, 15);
	public static ToolMaterial	toolMaterialStoneH		= EnumHelper.addToolMaterial("ToolStoneH", 1, 131, 4.0F, 3.0F, 5);
	public static ToolMaterial	toolMaterialIronH		= EnumHelper.addToolMaterial("ToolIronH", 2, 250, 6.0F, 4.0F, 14);
	public static ToolMaterial	toolMaterialDiamondH	= EnumHelper.addToolMaterial("ToolDiamondH", 3, 1561, 8.0F, 5.0F, 10);
	public static ToolMaterial	toolMaterialGoldH		= EnumHelper.addToolMaterial("ToolGoldH", 0, 32, 12.0F, 2.0F, 22);
	
	public static ToolMaterial	toolMaterialSandstoneH	= EnumHelper.addToolMaterial("ToolSandstoneH", 1, 111, 4.5F, 4, 6);
	public static ToolMaterial	toolMaterialGraniteH	= EnumHelper.addToolMaterial("ToolGraniteH", 1, 199, 4.3F, 4, 4);
	public static ToolMaterial	toolMaterialCopperH		= EnumHelper.addToolMaterial("ToolCopperH", 1, 139, 5.0F, 4, 10);
	public static ToolMaterial	toolMaterialSteelH		= EnumHelper.addToolMaterial("ToolSteelH", 2, 300, 7.5F, 5, 15);
	public static ToolMaterial	toolMaterialBronzeH		= EnumHelper.addToolMaterial("ToolBronzeH", 2, 1501, 6.5F, 4, 8);
	public static ToolMaterial	toolMaterialMeuroditeH	= EnumHelper.addToolMaterial("ToolMeuroditeH", 2, 805, 7.0F, 4, 15);
	public static ToolMaterial	toolMaterialToriteH		= EnumHelper.addToolMaterial("ToolToriteH", 2, 699, 6.0F, 5, 20);
	public static ToolMaterial	toolMaterialBlaziumH	= EnumHelper.addToolMaterial("ToolBlaziumH", 2, 799, 8.0F, 5, 18);
	public static ToolMaterial	toolMaterialTitaniumH	= EnumHelper.addToolMaterial("ToolTitaniumH", 4, 2999, 10.0F, 6, 11);
	
	public static CreativeTabs	tabItems				= new CreativeTabEMDItems(CreativeTabs.getNextID(), "Extrappolated Mob Drops - Items");
	
	public static void loadItems()
	{
		snout = new MItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setTextureName(MAssetManager.getEMDTexture("snout")).setUnlocalizedName("snout").setCreativeTab(tabItems);
		pigHoof = new MItem().setUnlocalizedName("pigFoot").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("footPig"));
		fat = new MItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setTextureName(MAssetManager.getEMDTexture("fat")).setCreativeTab(tabItems);
		grease = new MItem().setUnlocalizedName("grease").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("grease"));
		
		friedApple = new MItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedApple")).setUnlocalizedName("grease_apple").setCreativeTab(tabItems);
		friedBeef = new MItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedBeef")).setUnlocalizedName("grease_beef").setCreativeTab(tabItems);
		friedBread = new MItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedBread")).setUnlocalizedName("grease_bread").setCreativeTab(tabItems);
		friedCarrot = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedCarrot")).setUnlocalizedName("grease_carrot").setCreativeTab(tabItems);
		friedCookie = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedCookie")).setUnlocalizedName("grease_cookie").setCreativeTab(tabItems);
		friedFlesh = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MAssetManager.getEMDTexture("friedFlesh")).setUnlocalizedName("grease_flesh").setCreativeTab(tabItems);
		
		animalBones = new MItem().setUnlocalizedName("animal_bones").setTextureName(MAssetManager.getEMDTexture("animalBones")).setCreativeTab(tabItems);
		cowHoof = new MItem().setUnlocalizedName("cow_hoof").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("footCow"));
		
		horn = new MItem().setUnlocalizedName("horn").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("horn"));
		
		hornSwordWood = new MItemSword(toolMaterialWoodH, null).setUnlocalizedName("horned_wood_sword").setTextureName(MAssetManager.getEMDTexture("weaponSwordWoodHorned")).setCreativeTab(tabItems);
		hornSwordStone = new MItemSword(toolMaterialStoneH, null).setUnlocalizedName("horned_stone_sword").setTextureName(MAssetManager.getEMDTexture("weaponSwordStoneHorned")).setCreativeTab(tabItems);
		hornSwordIron = new MItemSword(toolMaterialIronH, null).setUnlocalizedName("horned_iron_sword").setTextureName(MAssetManager.getEMDTexture("weaponSwordIronHorned")).setCreativeTab(tabItems);
		hornSwordDiamond = new MItemSword(toolMaterialDiamondH, null).setUnlocalizedName("horned_diamond_sword").setTextureName(MAssetManager.getEMDTexture("weaponSwordDiamondHorned")).setCreativeTab(tabItems);
		hornSwordGold = new MItemSword(toolMaterialGoldH, null).setUnlocalizedName("horned_gold_sword").setTextureName(MAssetManager.getEMDTexture("weaponSwordGoldHorned")).setCreativeTab(tabItems);
		
		beakChicken = new MItem().setUnlocalizedName("chicken_beak").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("chickenBeak"));
		
		footChicken = new MItem().setUnlocalizedName("chicken_foot").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("footChicken"));
		
		chickenWingRaw = new MItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setTextureName(MAssetManager.getEMDTexture("chickenWingRaw")).setUnlocalizedName("raw_chicken_wing").setCreativeTab(tabItems);
		chickenWingCooked = new MItemFood(4, 0.65F).setUnlocalizedName("cooked_chicken_wing").setTextureName(MAssetManager.getEMDTexture("chickenWingCooked")).setCreativeTab(tabItems);
		
		lambchopRaw = new MItemFood(3, 0.2F).setUnlocalizedName("raw_lamb_chop").setTextureName(MAssetManager.getEMDTexture("lambChopRaw")).setCreativeTab(tabItems);
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setUnlocalizedName("cooked_lamb_chop").setTextureName(MAssetManager.getEMDTexture("lambChopCooked")).setCreativeTab(tabItems);
		
		sheepHoof = new MItem().setUnlocalizedName("sheep_hoof").setTextureName(MAssetManager.getEMDTexture("footSheep")).setCreativeTab(tabItems);
		
		squidTentacle = new MItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setTextureName(MAssetManager.getEMDTexture("tentacleSquid")).setUnlocalizedName("tentacle").setCreativeTab(tabItems);
		calimari = new ItemCalimari(2, 0.6F).setUnlocalizedName("calamari").setTextureName(MAssetManager.getEMDTexture("calimari")).setCreativeTab(tabItems);
		
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setUnlocalizedName("infectious_fungus").setTextureName(MAssetManager.getEMDTexture("infectiousFungus")).setCreativeTab(tabItems);
		
		airSack = new ItemAirSack().setUnlocalizedName("air_sack").setTextureName(MAssetManager.getEMDTexture("sackAir")).setCreativeTab(tabItems);
		
		whisker = new MItem().setUnlocalizedName("whisker").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("whisker"));
		
		catEye = new ItemCatEye(0, 0.0F).setUnlocalizedName("cat_eye").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("catEye"));
		
		wolfHide = new MItem().setUnlocalizedName("wolf_hide").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("hideWolf"));
		
		flesh = new MItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setUnlocalizedName("flesh").setTextureName(MAssetManager.getEMDTexture("flesh")).setCreativeTab(tabItems);
		
		marrow = new MItemFood(5, 0.0F).setUnlocalizedName("marrow").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("bowlMarrow"));
		
		
		legSpider = new MItem().setUnlocalizedName("spider_leg").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("armSpider"));
		poisonSack = new MItem().setUnlocalizedName("poison_sack").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("sackPoison"));
		swordPoisonWood = new ItemPoisonSword(ToolMaterial.WOOD, Items.wooden_sword).setUnlocalizedName("woodSwordPoison").setTextureName("wood_sword").setCreativeTab(tabItems);
		swordPoisonStone = new ItemPoisonSword(ToolMaterial.STONE, Items.stone_sword).setUnlocalizedName("stoneSwordPoison").setTextureName("stone_sword").setCreativeTab(tabItems);
		swordPoisonIron = new ItemPoisonSword(ToolMaterial.IRON, Items.iron_sword).setUnlocalizedName("ironSwordPoison").setTextureName("iron_sword").setCreativeTab(tabItems);
		swordPoisonDiamond = new ItemPoisonSword(ToolMaterial.EMERALD, Items.diamond_sword).setUnlocalizedName("diamondSwordPoison").setTextureName("diamond_sword").setCreativeTab(tabItems);
		swordPoisonGold = new ItemPoisonSword(ToolMaterial.GOLD, Items.golden_sword).setUnlocalizedName("goldSwordPoison").setTextureName("gold_sword").setCreativeTab(tabItems);
		
		guano = new ItemGuano().setUnlocalizedName("guano").setTextureName(MAssetManager.getEMDTexture("guano")).setCreativeTab(tabItems);
		carcassSilverfish = new MItem().setUnlocalizedName("silverfish_carcass").setTextureName(MAssetManager.getEMDTexture("silverfishCarcass")).setCreativeTab(tabItems);
		
		hideCreeper = new MItem().setUnlocalizedName("creeper_hide").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("hideCreeper"));
		
		slimeCore = new MItem().setUnlocalizedName("slime_core").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("coreSlime"));
		enderCore = new ItemEnderCore(0, 0).setUnlocalizedName("ender_core").setTextureName(MAssetManager.getEMDTexture("coreEnder")).setCreativeTab(tabItems);
		
		ghastTentacle = new ItemGhastTentacle().setUnlocalizedName("ghast_tentacle").setTextureName(MAssetManager.getEMDTexture("tentacleGhast")).setCreativeTab(tabItems);
		
		horseHoof = new MItem().setCreativeTab(tabItems).setUnlocalizedName("horse_foot").setTextureName(MAssetManager.getEMDTexture("footHorse"));
		rawHorseHaunch = new MItemFood(4, 0.4F).setCreativeTab(tabItems).setUnlocalizedName("raw_horse_haunch").setTextureName(MAssetManager.getEMDTexture("horseHaunchRaw"));
		cookedHorseHaunch = new MItemFood(10, 0.8F).setCreativeTab(tabItems).setUnlocalizedName("cooked_horse_haunch").setTextureName(MAssetManager.getEMDTexture("horseHaunchCooked"));
		horseHair = new MItem().setCreativeTab(tabItems).setUnlocalizedName("horse_hair").setTextureName(MAssetManager.getEMDTexture("horseHair"));
		
		genes = new ItemGene().setUnlocalizedName("gene");
		
		charms = new ItemCharm().setUnlocalizedName("charm").setCreativeTab(tabItems);
		
		amuletPorcum = new ItemAmuletPorcum().setUnlocalizedName("PorcumAmulet").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("amuletPig"));
		amuletVaccam = new ItemAmuletVaccam().setUnlocalizedName("VaccamAmulet").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("amuletHorse"));
		amuletPullum = new ItemAmuletPullum().setUnlocalizedName("PullumAmulet").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("amuletChicken"));
		amuletOves = new ItemAmuletOves().setUnlocalizedName("OvesAmulet").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("amuletSheep"));
		
		wingSinew = new MItem().setUnlocalizedName("wing_sinew").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("wingSinew"));
		wingSegment = new MItem().setUnlocalizedName("wing_segment").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("hangGliderSegment"));
		
		hangGlider = new ItemHangGlider().setUnlocalizedName("hangglider").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("hangGlider"));
		
		enderAura = new MItem().setUnlocalizedName("item_EnderAura1").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("enderAura"));
		
		ghastlySoul = new MItem().setUnlocalizedName("item_GhastlySoul").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("ghastlySoul"));
		
		witheredBone = new MItem().setUnlocalizedName("withered_bone").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("witherBone"));
		
		horseHairFibre = new MItem().setUnlocalizedName("horse_hair_fibre").setCreativeTab(tabItems).setTextureName(MAssetManager.getEMDTexture("horseHairFibre"));
		horseHairBow = new ItemHorseHairBow().setUnlocalizedName("horsehair_bow").setCreativeTab(tabItems);
		
		GameRegistry.registerItem(snout, "snout");
		GameRegistry.registerItem(pigHoof, "pigHoof");
		GameRegistry.registerItem(fat, "fat");
		GameRegistry.registerItem(grease, "grease");
		GameRegistry.registerItem(friedApple, "friedApple");
		GameRegistry.registerItem(friedBeef, "friedBeef");
		GameRegistry.registerItem(friedBread, "friedBread");
		GameRegistry.registerItem(friedCarrot, "friedCarrot");
		GameRegistry.registerItem(friedCookie, "friedCookie");
		GameRegistry.registerItem(friedFlesh, "friedFlesh");
		GameRegistry.registerItem(animalBones, "animalBones");
		GameRegistry.registerItem(cowHoof, "cowHoof");
		GameRegistry.registerItem(horn, "horn");
		GameRegistry.registerItem(hornSwordWood, "hornSwordWood");
		GameRegistry.registerItem(hornSwordStone, "hornSwordStone");
		GameRegistry.registerItem(hornSwordIron, "hornSwordIron");
		GameRegistry.registerItem(hornSwordDiamond, "hornSwordDiamond");
		GameRegistry.registerItem(hornSwordGold, "hornSwordGold");
		GameRegistry.registerItem(beakChicken, "beakChicken");
		GameRegistry.registerItem(footChicken, "footChicken");
		GameRegistry.registerItem(chickenWingRaw, "chickenWingRaw");
		GameRegistry.registerItem(chickenWingCooked, "chickenWingCooked");
		GameRegistry.registerItem(lambchopRaw, "lambChopRaw");
		GameRegistry.registerItem(lambchopCooked, "lambChopCooked");
		GameRegistry.registerItem(sheepHoof, "sheepHoof");
		GameRegistry.registerItem(squidTentacle, "squidTentacle");
		GameRegistry.registerItem(calimari, "calimari");
		GameRegistry.registerItem(infectiousFungus, "infectiousFungus");
		GameRegistry.registerItem(airSack, "airSack");
		GameRegistry.registerItem(whisker, "whisker");
		GameRegistry.registerItem(catEye, "catEye");
		GameRegistry.registerItem(wolfHide, "wolfHide");
		GameRegistry.registerItem(flesh, "flesh");
		GameRegistry.registerItem(marrow, "marrow");
		GameRegistry.registerItem(legSpider, "legSpider");
		GameRegistry.registerItem(poisonSack, "poisonSack");
		GameRegistry.registerItem(swordPoisonWood, "swordPoisonWood");
		GameRegistry.registerItem(swordPoisonStone, "swordPoisonStone");
		GameRegistry.registerItem(swordPoisonIron, "swordPoisonIron");
		GameRegistry.registerItem(swordPoisonDiamond, "swordPoisonDiamond");
		GameRegistry.registerItem(swordPoisonGold, "swordPoisonGold");
		GameRegistry.registerItem(guano, "guano");
		GameRegistry.registerItem(carcassSilverfish, "carcassSilverFish");
		GameRegistry.registerItem(hideCreeper, "hideCreeper");
		GameRegistry.registerItem(slimeCore, "slimeCore");
		GameRegistry.registerItem(enderCore, "enderCore");
		GameRegistry.registerItem(ghastTentacle, "ghastTentacle");
		GameRegistry.registerItem(horseHoof, "horseHoof");
		GameRegistry.registerItem(rawHorseHaunch, "rawHorseHaunch");
		GameRegistry.registerItem(cookedHorseHaunch, "cookedHorseHaunch");
		GameRegistry.registerItem(horseHair, "horseHair");
		GameRegistry.registerItem(genes, "genes");
		GameRegistry.registerItem(charms, "charms");
		GameRegistry.registerItem(amuletPorcum, "amuletPorcum");
		GameRegistry.registerItem(amuletVaccam, "amuletVaccam");
		GameRegistry.registerItem(amuletPullum, "amuletPullum");
		GameRegistry.registerItem(amuletOves, "amuletOves");
		GameRegistry.registerItem(wingSinew, "wingSinew");
		GameRegistry.registerItem(wingSegment, "wingSegment");
		GameRegistry.registerItem(hangGlider, "hangGlider");
		GameRegistry.registerItem(enderAura, "enderAura");
		GameRegistry.registerItem(ghastlySoul, "ghastlySoul");
		GameRegistry.registerItem(witheredBone, "witheredBone");
		GameRegistry.registerItem(horseHairFibre, "horseHairFibre");
		GameRegistry.registerItem(horseHairBow, "horseHairBow");
	}
	
	public static void loadBridgedItems() throws Exception
	{
		if (Loader.isModLoaded(MReference.MODID_EO))
		{
			hornSandstone = new MItemSword(toolMaterialSandstoneH, null).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(tabItems);
			hornGranite = new MItemSword(toolMaterialGraniteH, null).setUnlocalizedName("horned_granite_sword").setCreativeTab(tabItems);
			hornCopper = new MItemSword(toolMaterialCopperH, null).setUnlocalizedName("horned_copper_sword").setCreativeTab(tabItems);
			hornSteel = new MItemSword(toolMaterialSteelH, null).setUnlocalizedName("horned_steel_sword").setCreativeTab(tabItems);
			hornBronze = new MItemSword(toolMaterialBronzeH, null).setUnlocalizedName("horned_bronze_sword").setCreativeTab(tabItems);
			hornMeurodite = new MItemSword(toolMaterialMeuroditeH, null).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(tabItems);
			hornTorite = new MItemSword(toolMaterialToriteH, null).setUnlocalizedName("horned_torite_sword").setCreativeTab(tabItems);
			hornBlazium = new MItemSword(toolMaterialBlaziumH, null).setUnlocalizedName("horned_fire_sword").setCreativeTab(tabItems);
			hornTitanium = new MItemSword(toolMaterialTitaniumH, null).setUnlocalizedName("horned_titanium_sword").setCreativeTab(tabItems);
			
			// swordPosionSandstone = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSandstone,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword
			// ).setUnlocalizedName("sandstoneSwordPoison").setTextureName("minestrappolation:item_SandstoneSword").setCreativeTab(tabItems);
			// swordPosionGranite = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialGranite,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword
			// ).setUnlocalizedName("graniteSwordPoison").setTextureName("minestrappolation:item_GraniteSword").setCreativeTab(tabItems);
			// swordPosionCopper = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialCopper,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword
			// ).setUnlocalizedName("copperSwordPoison").setTextureName("minestrappolation:item_CopperSword").setCreativeTab(tabItems);
			// swordPosionSteel = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSteel,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword
			// ).setUnlocalizedName("steelSwordPoison").setTextureName("minestrappolation:item_SteelSword").setCreativeTab(tabItems);
			// swordPosionBronze = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBronze,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword
			// ).setUnlocalizedName("bronzeSwordPoison").setTextureName("minestrappolation:item_BronzeSword").setCreativeTab(tabItems);
			// swordPosionMeurodite = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialMeurodite,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword
			// ).setUnlocalizedName("meuroditeSwordPoison").setTextureName("minestrappolation:item_MeuroditeSword").setCreativeTab(tabItems);
			// swordPosionTorite = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTorite,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword
			// ).setUnlocalizedName("toriteSwordPoison").setTextureName("minestrappolation:item_ToriteSword").setCreativeTab(tabItems);
			// swordPosionBlazium = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBlazium,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword
			// ).setUnlocalizedName("blaziumSwordPoison").setTextureName("minestrappolation:item_BlaziumSword").setCreativeTab(tabItems);
			// swordPosionTitanium = new
			// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTitanium,
			// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword
			// ).setUnlocalizedName("titaniumSwordPoison").setTextureName("minestrappolation:item_TitaniumSword").setCreativeTab(tabItems);
		}
	}
}
