package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.lib.MTools.bronzePickaxe;
import static minestrapteam.minestrappolation.lib.MTools.bronzeSword;
import static minestrapteam.minestrappolation.lib.MTools.steelPickaxe;
import static minestrapteam.minestrappolation.lib.MTools.steelSword;
import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.minestrap_core.item.MCItem;
import minestrapteam.minestrap_core.item.MCItemFood;
import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.item.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class MItems
{
	/* / {----- Extra Ores -----} / */
	
	public static Item	copperIngot;
	public static Item	tinIngot;
	public static Item	bronzeIngot;
	public static Item	coalIronIngot;
	public static Item	steelIngot;
	public static Item	titaniumIngot;
	public static Item	toriteIngot;
	public static Item	blaziumIngot;
	
	public static Item	soulGem;
	public static Item	meuroditeGem;
	public static Item	uranium;
	public static Item	plutonium;
	public static Item	radiantQuartz;
	public static Item	desertQuartz;
	public static Item	blazeShard;
	public static Item	sunstoneDust;
	
	public static Item	steelKey;
	public static Item	steelLock;
	public static Item	soulBottle;
	public static Item	grenade;
	public static Item	grenadeNuke;
	public static Item	grenadeSticky;
	
	public static Item	plateTinItem;
	public static Item	plateBronzeItem;
	public static Item	plateSteelItem;
	public static Item	plateMeuroditeItem;
	
	// public static Item bucketMagma;
	
	/* / {----- Extra Decor -----} / */
	
	public static Item	ropeItem;
	public static Item	cardboardItem;
	public static Item	goblet;
	public static Item	glassDoor;
	
	/* / {----- Extra Mod Drops -----} / */
	
	public static Item	snout;
	public static Item	pigHoof;
	public static Item	fat;
	public static Item	grease;
	public static Item	friedApple;
	public static Item	friedBeef;
	public static Item	friedBread;
	public static Item	friedCarrot;
	public static Item	friedCookie;
	public static Item	friedFlesh;
	public static Item	animalBones;
	public static Item	cowHoof;
	public static Item	horn;
	public static Item	beakChicken;
	public static Item	footChicken;
	public static Item	chickenWingRaw;
	public static Item	chickenWingCooked;
	public static Item	lambchopRaw;
	public static Item	lambchopCooked;
	public static Item	sheepHoof;
	public static Item	squidTentacle;
	public static Item	calimari;
	public static Item	airSack;
	public static Item	infectiousFungus;
	public static Item	whisker;
	public static Item	catEye;
	public static Item	wolfHide;
	public static Item	flesh;
	public static Item	marrow;
	public static Item	legSpider;
	public static Item	poisonSack;
	public static Item	guano;
	public static Item	carcassSilverfish;
	public static Item	hideCreeper;
	public static Item	slimeCore;
	public static Item	enderCore;
	public static Item	ghastTentacle;
	public static Item	horseHoof;
	public static Item	horseHaunchRaw;
	public static Item	hoarseHaunchCooked;
	public static Item	horseHair;
	public static Item	genes;
	public static Item	charms;
	public static Item	amuletPorcum;
	public static Item	amuletVaccam;
	public static Item	amuletPullum;
	public static Item	amuletOves;
	public static Item	wingSinew;
	public static Item	wingSegment;
	public static Item	hangGlider;
	public static Item	enderAura;
	public static Item	ghastlySoul;
	public static Item	witheredBone;
	public static Item	horseHairFibre;
	public static Item	horseHairBow;
	
	public static void init()
	{
		soulGem = new ItemSoulGem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("soul_gem"));
		meuroditeGem = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("meurodite_gem"));
		uranium = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("uranium"));
		plutonium = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("plutonium"));
		radiantQuartz = new MItemFoiled().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("radiant_quartz"));
		desertQuartz = new MCItem().setTextureName(MCAssetManager.getMineralTexture("desert_quartz"));
		blazeShard = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("blazium_dust"));
		sunstoneDust = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("sunstone_dust"));
		
		copperIngot = new MCItem().setTextureName(MCAssetManager.getMineralTexture("copper_ingot"));
		tinIngot = new MCItem().setTextureName(MCAssetManager.getMineralTexture("tin_ingot"));
		bronzeIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("bronze_ingot"));
		coalIronIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("coaliron_ingot"));
		steelIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("steel_ingot"));
		titaniumIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("titanium_ingot"));
		toriteIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("torite_ingot"));
		blaziumIngot = new MCItem().setCreativeTab(Minestrappolation.tabMaterials).setTextureName(MCAssetManager.getMineralTexture("blazium_ingot"));
		
		steelKey = new ItemKey().setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("steel_key"));
		steelLock = new ItemLock().setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("steel_lock"));
		soulBottle = new ItemSoulBottle().setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("soul_bottle"));
		grenade = new ItemGrenade().setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("grenade"));
		grenadeNuke = new ItemGrenadeNuke().setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("grenade_nuke"));
		grenadeSticky = new ItemGrenadeSticky().setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("grenade_sticky"));
		
		// bucketMagma
		
		plateTinItem = new ItemPlating(MBlocks.tinPlate, "tin").setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getMineralTexture("tin_plating"));
		plateBronzeItem = new ItemPlating(MBlocks.bronzePlate, "bronze").setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getMineralTexture("bronze_plating"));
		plateSteelItem = new ItemPlating(MBlocks.steelPlate, "steel").setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getMineralTexture("steel_plating"));
		plateMeuroditeItem = new ItemPlating(MBlocks.meuroditePlate, "meurodite").setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getMineralTexture("meurodite_plating"));
		
		ropeItem = new ItemReed(MBlocks.rope).setCreativeTab(Minestrappolation.tabFood).setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("rope"));
		cardboardItem = new ItemReed(MBlocks.cardboard).setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("cardboard"));
		goblet = new ItemReed(MBlocks.goblet).setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("goblet"));
		glassDoor = new EDItemDoor(MBlocks.glassDoor).setCreativeTab(Minestrappolation.tabBuildingBlocks).setTextureName(MCAssetManager.getTexture("glass_door"));
		
		snout = new MCItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setTextureName(MCAssetManager.getTexture("snout")).setCreativeTab(Minestrappolation.tabFood);
		pigHoof = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footPig"));
		fat = new MCItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setTextureName(MCAssetManager.getTexture("fat")).setCreativeTab(Minestrappolation.tabFood);
		grease = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("grease"));
		friedApple = new MCItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedApple")).setCreativeTab(Minestrappolation.tabFood);
		friedBeef = new MCItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedBeef")).setCreativeTab(Minestrappolation.tabFood);
		friedBread = new MCItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedBread")).setCreativeTab(Minestrappolation.tabFood);
		friedCarrot = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedCarrot")).setCreativeTab(Minestrappolation.tabFood);
		friedCookie = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedCookie")).setCreativeTab(Minestrappolation.tabFood);
		friedFlesh = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedFlesh")).setCreativeTab(Minestrappolation.tabFood);
		animalBones = new MCItem().setTextureName(MCAssetManager.getTexture("animalBones")).setCreativeTab(Minestrappolation.tabFood);
		cowHoof = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footCow"));
		horn = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horn"));
		beakChicken = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("chickenBeak"));
		footChicken = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footChicken"));
		chickenWingRaw = new MCItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setTextureName(MCAssetManager.getTexture("chickenWingRaw")).setCreativeTab(Minestrappolation.tabFood);
		chickenWingCooked = new MCItemFood(4, 0.65F).setTextureName(MCAssetManager.getTexture("chickenWingCooked")).setCreativeTab(Minestrappolation.tabFood);
		lambchopRaw = new MCItemFood(3, 0.2F).setTextureName(MCAssetManager.getTexture("lambChopRaw")).setCreativeTab(Minestrappolation.tabFood);
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setTextureName(MCAssetManager.getTexture("lambChopCooked")).setCreativeTab(Minestrappolation.tabFood);
		sheepHoof = new MCItem().setTextureName(MCAssetManager.getTexture("footSheep")).setCreativeTab(Minestrappolation.tabFood);
		squidTentacle = new MCItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setTextureName(MCAssetManager.getTexture("tentacleSquid")).setCreativeTab(Minestrappolation.tabFood);
		calimari = new ItemCalimari(2, 0.6F).setTextureName(MCAssetManager.getTexture("calimari")).setCreativeTab(Minestrappolation.tabFood);
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setTextureName(MCAssetManager.getTexture("infectiousFungus")).setCreativeTab(Minestrappolation.tabFood);
		airSack = new ItemAirSack().setTextureName(MCAssetManager.getTexture("sackAir")).setCreativeTab(Minestrappolation.tabFood);
		whisker = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("whisker"));
		catEye = new ItemCatEye(0, 0.0F).setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("catEye"));
		wolfHide = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hideWolf"));
		flesh = new MCItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setTextureName(MCAssetManager.getTexture("flesh")).setCreativeTab(Minestrappolation.tabFood);
		marrow = new MCItemFood(5, 0.0F).setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("bowlMarrow"));
		legSpider = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("armSpider"));
		poisonSack = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("sackPoison"));
		guano = new ItemGuano().setTextureName(MCAssetManager.getTexture("guano")).setCreativeTab(Minestrappolation.tabFood);
		carcassSilverfish = new MCItem().setTextureName(MCAssetManager.getTexture("silverfishCarcass")).setCreativeTab(Minestrappolation.tabFood);
		hideCreeper = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hideCreeper"));
		slimeCore = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("coreSlime"));
		enderCore = new ItemEnderCore(0, 0).setTextureName(MCAssetManager.getTexture("coreEnder")).setCreativeTab(Minestrappolation.tabFood);
		ghastTentacle = new ItemGhastTentacle().setTextureName(MCAssetManager.getTexture("tentacleGhast")).setCreativeTab(Minestrappolation.tabFood);
		horseHoof = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footHorse"));
		horseHaunchRaw = new MCItemFood(4, 0.4F).setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horseHaunchRaw"));
		hoarseHaunchCooked = new MCItemFood(10, 0.8F).setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horseHaunchCooked"));
		horseHair = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horseHair"));
		genes = new ItemGene();
		charms = new ItemCharm().setCreativeTab(Minestrappolation.tabFood);
		amuletPorcum = new ItemAmuletPorcum().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletPig"));
		amuletVaccam = new ItemAmuletVaccam().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletHorse"));
		amuletPullum = new ItemAmuletPullum().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletChicken"));
		amuletOves = new ItemAmuletOves().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletSheep"));
		wingSinew = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("wingSinew"));
		wingSegment = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hangGliderSegment"));
		hangGlider = new ItemHangGlider().setCreativeTab(Minestrappolation.tabMisc).setTextureName(MCAssetManager.getTexture("hangGlider"));
		enderAura = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("enderAura"));
		ghastlySoul = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("ghastlySoul"));
		witheredBone = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("witherBone"));
		horseHairFibre = new MCItem().setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horseHairFibre"));
		horseHairBow = new ItemHorseHairBow().setCreativeTab(Minestrappolation.tabFood);
	}
	
	public static void load()
	{
		CSItems.addItem(soulGem, "soul_gem");
		CSItems.addItem(meuroditeGem, "meurodite_gem");
		CSItems.addItem(uranium, "uranium");
		CSItems.addItem(plutonium, "plutonium");
		CSItems.addItem(radiantQuartz, "radiant_quartz");
		CSItems.addItem(desertQuartz, "desert_quartz");
		CSItems.addItem(blazeShard, "blaze_shard");
		CSItems.addItem(sunstoneDust, "sunstone_dust");
		
		CSItems.addItem(copperIngot, "copper_ingot");
		CSItems.addItem(tinIngot, "tin_ingot");
		CSItems.addItem(bronzeIngot, "bronze_ingot");
		CSItems.addItem(coalIronIngot, "coaliron_ingot");
		CSItems.addItem(steelIngot, "steel_ingot");
		CSItems.addItem(titaniumIngot, "titanium_ingot");
		CSItems.addItem(toriteIngot, "torite_ingot");
		CSItems.addItem(blaziumIngot, "blazium_ingot");
		
		CSItems.addItem(steelKey, "steel_key");
		CSItems.addItem(steelLock, "steel_lock");
		CSItems.addItem(soulBottle, "soul_bottle");
		CSItems.addItem(grenade, "grenade");
		CSItems.addItem(grenadeNuke, "nuke_grenade");
		CSItems.addItem(grenadeSticky, "sticky_grenade");
		CSItems.addItem(plateTinItem, "tin_plate");
		CSItems.addItem(plateBronzeItem, "bronze_plate");
		CSItems.addItem(plateSteelItem, "steel_plate");
		CSItems.addItem(plateMeuroditeItem, "meurodite_plate");
		
		CSItems.addItem(ropeItem, "rope");
		CSItems.addItem(cardboardItem, "cardboard");
		CSItems.addItem(goblet, "goblet");
		CSItems.addItem(glassDoor, "glass_door");
		
		CSItems.addItem(snout, "snout");
		CSItems.addItem(pigHoof, "pig_hoof");
		CSItems.addItem(fat, "fat");
		CSItems.addItem(grease, "grease");
		CSItems.addItem(friedApple, "fried_apple");
		CSItems.addItem(friedBeef, "fried_beef");
		CSItems.addItem(friedBread, "fried_bread");
		CSItems.addItem(friedCarrot, "fried_carrot");
		CSItems.addItem(friedCookie, "fried_cookie");
		CSItems.addItem(friedFlesh, "fried_flesh");
		CSItems.addItem(animalBones, "animal_bones");
		CSItems.addItem(cowHoof, "cow_hoof");
		CSItems.addItem(horn, "horn");
		CSItems.addItem(beakChicken, "beak_chicken");
		CSItems.addItem(footChicken, "foot_chicken");
		CSItems.addItem(chickenWingRaw, "chicken_wing_raw");
		CSItems.addItem(chickenWingCooked, "chicken_wing_cooked");
		CSItems.addItem(lambchopRaw, "lamb_chop_raw");
		CSItems.addItem(lambchopCooked, "lamb_chop_cooked");
		CSItems.addItem(sheepHoof, "sheep_hoof");
		CSItems.addItem(squidTentacle, "squid_tentacle");
		CSItems.addItem(calimari, "calimari");
		CSItems.addItem(infectiousFungus, "infectious_fungus");
		CSItems.addItem(airSack, "air_sack");
		CSItems.addItem(whisker, "whisker");
		CSItems.addItem(catEye, "cat_eye");
		CSItems.addItem(wolfHide, "wolf_hide");
		CSItems.addItem(flesh, "flesh");
		CSItems.addItem(marrow, "marrow");
		CSItems.addItem(legSpider, "spider_leg");
		CSItems.addItem(poisonSack, "poison_sack");
		CSItems.addItem(guano, "guano");
		CSItems.addItem(carcassSilverfish, "silverfish_carcass");
		CSItems.addItem(hideCreeper, "creeper_hide");
		CSItems.addItem(slimeCore, "slime_core");
		CSItems.addItem(enderCore, "ender_core");
		CSItems.addItem(ghastTentacle, "ghast_tentacle");
		CSItems.addItem(horseHoof, "horse_hoof");
		CSItems.addItem(horseHaunchRaw, "horse_haunch_raw");
		CSItems.addItem(hoarseHaunchCooked, "horse_haunch_cooked");
		CSItems.addItem(horseHair, "horse_hair");
		CSItems.addItem(genes, "genes");
		CSItems.addItem(charms, "charms");
		CSItems.addItem(amuletPorcum, "porcum_amulet");
		CSItems.addItem(amuletVaccam, "vaccam_amulet");
		CSItems.addItem(amuletPullum, "pullum_amulet");
		CSItems.addItem(amuletOves, "oves_amulet");
		CSItems.addItem(wingSinew, "wing_sinew");
		CSItems.addItem(wingSegment, "wing_segment");
		CSItems.addItem(hangGlider, "hangglider");
		CSItems.addItem(enderAura, "ender_aura");
		CSItems.addItem(ghastlySoul, "ghastly_soul");
		CSItems.addItem(witheredBone, "withered_bone");
		CSItems.addItem(horseHairFibre, "horse_hair_fibre");
		CSItems.addItem(horseHairBow, "horse_hair_bow");
		
		addItemsToChests();
		setHarvestLevels();
	}
	
	public static void setHarvestLevels()
	{
		Blocks.bedrock.setHardness(80F);
		Blocks.bedrock.setHarvestLevel("pickaxe", 5);
		Blocks.diamond_ore.setHarvestLevel("pickaxe", 3);
		Blocks.diamond_block.setHarvestLevel("pickaxe", 3);
		Blocks.obsidian.setHarvestLevel("pickaxe", 4);
		
		Items.diamond_shovel.setHarvestLevel("shovel", 4);
		Items.diamond_pickaxe.setHarvestLevel("pickaxe", 4);
		Items.diamond_axe.setHarvestLevel("axe", 4);
		
		MBlocks.copperOre.setHarvestLevel("pickaxe", 0);
		MBlocks.copperBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.tinOre.setHarvestLevel("pickaxe", 1);
		MBlocks.tinBlock.setHarvestLevel("pickaxe", 1);
		MBlocks.meuroditeOre.setHarvestLevel("pickaxe", 2);
		MBlocks.meuroditeBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.toriteOre.setHarvestLevel("pickaxe", 2);
		MBlocks.toriteBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.titaniumOre.setHarvestLevel("pickaxe", 4);
		MBlocks.titaniumBlock.setHarvestLevel("pickaxe", 4);
		MBlocks.uraniumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.plutoniumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.sunstoneOre.setHarvestLevel("pickaxe", 2);
		MBlocks.blaziumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.blaziumBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.soulOre.setHarvestLevel("shovel", 2);
		MBlocks.bronzeBlock.setHarvestLevel("pickaxe", 1);
		MBlocks.uraniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.plutoniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.godstone.setHarvestLevel("pickaxe", 2);
		MBlocks.soulBlock.setHarvestLevel("pickaxe", 4);
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		
		MBlocks.snowBrick.setHarvestLevel("shovel", 0);
		MBlocks.gunpowderBlock.setHarvestLevel("shovel", 0);
		MBlocks.sugarBlock.setHarvestLevel("shovel", 0);
		MBlocks.ropeCoil.setHarvestLevel("shears", 0);
		MBlocks.rope.setHarvestLevel("shears", 0);
		// MBlocks.checkerTileStairs.setHarvestLevel("pickaxe", 1);
		MBlocks.slimeOoze.setHarvestLevel("shovel", 0);
		MBlocks.magmaOoze.setHarvestLevel("shovel", 0);
	}
	
	public static void addItemsToChests()
	{
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftCorridor = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks strongholdCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks strongholdCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks desertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		ChestGenHooks strongholdLibrary = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 25));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(coalIronIngot), 1, 5, 17));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 5, 17));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 4, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 3, 8));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(titaniumIngot), 1, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 7, 25));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(uranium), 1, 2, 10));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(plutonium), 1, 2, 10));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzePickaxe), 1, 1, 11));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steelPickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 4, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 3, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(titaniumIngot), 1, 2, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 7, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(uranium), 1, 2, 10));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(plutonium), 1, 2, 10));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzePickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steelPickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(coalIronIngot), 1, 5, 17));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(blaziumIngot), 1, 2, 7));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steelSword), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzeSword), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 4, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(titaniumIngot), 1, 2, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 7, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(uranium), 1, 2, 10));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(plutonium), 1, 2, 10));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronzePickaxe), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(steelPickaxe), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(coalIronIngot), 1, 5, 17));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(blaziumIngot), 1, 2, 7));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(steelSword), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronzeSword), 1, 1, 11));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 1, 3, 12));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 7, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(desertQuartz), 1, 10, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 3, 10));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(coalIronIngot), 1, 5, 17));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 5, 17));
	}
}
