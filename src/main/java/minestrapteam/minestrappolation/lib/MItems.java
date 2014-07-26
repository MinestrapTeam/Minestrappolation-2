package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.Minestrappolation.*;
import static minestrapteam.minestrappolation.lib.MTools.bronzePickaxe;
import static minestrapteam.minestrappolation.lib.MTools.bronzeSword;
import static minestrapteam.minestrappolation.lib.MTools.steelPickaxe;
import static minestrapteam.minestrappolation.lib.MTools.steelSword;
import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.item.*;
import minestrapteam.minestrappolation.util.MAssetManager;

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
	/* / {----- Stonecutter Bricks -----} / */
	
	public static Item	brickStone;
	public static Item	brickStoneTin;
	public static Item	brickStoneBronze;
	public static Item	brickStoneSteel;
	public static Item	brickStoneMeurodite;
	public static Item	brickSandstone;
	public static Item	brickRedSandstone;
	public static Item	brickClay;
	public static Item	brickColoredClay;
	public static Item	brickFlint;
	public static Item	brickLapis;
	public static Item	brickSlate;
	public static Item	brickSlateTin;
	public static Item	brickSlateBronze;
	public static Item	brickSlateSteel;
	public static Item	brickSlateMeurodite;
	public static Item	brickDesertQuartz;
	public static Item	brickNetherQuartz;
	public static Item	brickObsidian;
	public static Item	brickEndStone;
	public static Item	brickBedrock;
	public static Item	brickRadiantQuartz;
	
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
	public static Item	horseHaunchCooked;
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
		brickStone = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("stone_brick"));
		brickStoneTin = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("stone_brick_tin"));
		brickStoneBronze = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("stone_brick_bronze"));
		brickStoneSteel = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("stone_brick_steel"));
		brickStoneMeurodite = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("stone_brick_meurodite"));
		brickSandstone = new MItem().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("sandstone_brick"));
		brickRedSandstone = new MItem().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("red_sandstone_brick"));
		brickColoredClay = new MItemMulti(null, new String[] { MAssetManager.getStonecutterTexture("black_clay_brick"), MAssetManager.getStonecutterTexture("blue_clay_brick"), MAssetManager.getStonecutterTexture("brown_clay_brick"), MAssetManager.getStonecutterTexture("cyan_clay_brick"), MAssetManager.getStonecutterTexture("grey_clay_brick"), MAssetManager.getStonecutterTexture("green_clay_brick"), MAssetManager.getStonecutterTexture("lightblue_clay_brick"), MAssetManager.getStonecutterTexture("lime_clay_brick"), MAssetManager.getStonecutterTexture("magenta_clay_brick"), MAssetManager.getStonecutterTexture("orange_clay_brick"), MAssetManager.getStonecutterTexture("pink_clay_brick"), MAssetManager.getStonecutterTexture("purple_clay_brick"), MAssetManager.getStonecutterTexture("red_clay_brick"), MAssetManager.getStonecutterTexture("silver_clay_brick"), MAssetManager.getStonecutterTexture("white_clay_brick"), MAssetManager.getStonecutterTexture("yellow_clay_brick") }).setUnlocalizedName(
				"clay_brick").setCreativeTab(Minestrappolation.tabStoneDecor);
		brickFlint = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("flint_brick"));
		brickLapis = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("lapis_brick"));
		brickSlate = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("granite_brick"));
		brickSlateTin = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("granite_brick_tin"));
		brickSlateBronze = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("granite_brick_bronze"));
		brickSlateSteel = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("granite_brick_steel"));
		brickSlateMeurodite = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("granite_brick_meurodite"));
		brickDesertQuartz = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("desertquartz_brick"));
		brickNetherQuartz = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("netherquartz_brick"));
		brickObsidian = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("obsidian_brick"));
		brickEndStone = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("endstone_brick"));
		brickBedrock = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("bedrock_brick"));
		brickRadiantQuartz = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MAssetManager.getStonecutterTexture("radiantquartz_brick"));
		
		soulGem = new ItemSoulGem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("soul_gem"));
		meuroditeGem = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("meurodite_gem"));
		uranium = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("uranium"));
		plutonium = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("plutonium"));
		radiantQuartz = new MItemFoiled().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("radiant_quartz"));
		desertQuartz = new MItem().setTextureName(MAssetManager.getMineralTexture("desert_quartz"));
		blazeShard = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("blazium_dust"));
		sunstoneDust = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("sunstone_dust"));
		
		copperIngot = new MItem().setTextureName(MAssetManager.getMineralTexture("copper_ingot"));
		tinIngot = new MItem().setTextureName(MAssetManager.getMineralTexture("tin_ingot"));
		bronzeIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("bronze_ingot"));
		coalIronIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("coaliron_ingot"));
		steelIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("steel_ingot"));
		titaniumIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("titanium_ingot"));
		toriteIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("torite_ingot"));
		blaziumIngot = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("blazium_ingot"));
		
		steelKey = new ItemKey().setCreativeTab(tabMisc).setTextureName(MAssetManager.getTexture("steel_key"));
		steelLock = new ItemLock().setCreativeTab(tabMisc).setTextureName(MAssetManager.getTexture("steel_lock"));
		soulBottle = new ItemSoulBottle().setCreativeTab(tabTools).setTextureName(MAssetManager.getTexture("soul_bottle"));
		grenade = new ItemGrenade().setCreativeTab(tabCombat).setTextureName(MAssetManager.getTexture("grenade"));
		grenadeNuke = new ItemGrenadeNuke().setCreativeTab(tabCombat).setTextureName(MAssetManager.getTexture("grenade_nuke"));
		grenadeSticky = new ItemGrenadeSticky().setCreativeTab(tabCombat).setTextureName(MAssetManager.getTexture("grenade_sticky"));
		
		// bucketMagma
		
		plateTinItem = new ItemPlating(MBlocks.tinPlate, "tin", 64, 1.2F).setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("tin_plating"));
		plateBronzeItem = new ItemPlating(MBlocks.bronzePlate, "bronze", 128, 1.3F).setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("bronze_plating"));
		plateSteelItem = new ItemPlating(MBlocks.steelPlate, "steel", 192, 1.4F).setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("steel_plating"));
		plateMeuroditeItem = new ItemPlating(MBlocks.meuroditePlate, "meurodite", 256, 1.5F).setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMineralTexture("meurodite_plating"));
		
		ropeItem = new ItemReed(MBlocks.rope).setCreativeTab(tabDecorationBlocks).setTextureName(MAssetManager.getTexture("rope"));
		cardboardItem = new ItemReed(MBlocks.cardboard).setCreativeTab(tabDecorationBlocks).setTextureName(MAssetManager.getTexture("cardboard"));
		glassDoor = new MItemDoor(MBlocks.glassDoor).setCreativeTab(tabDecorationBlocks).setTextureName(MAssetManager.getTexture("glass_door"));
		
		snout = new MItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setCreativeTab(tabFood).setTextureName(MAssetManager.getMobTexture("snout"));
		pigHoof = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("pig_foot"));
		fat = new MItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fat"));
		grease = new MItem().setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("grease"));
		friedApple = new MItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_apple"));
		friedBeef = new MItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_beef"));
		friedBread = new MItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_bread"));
		friedCarrot = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_carrot"));
		friedCookie = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_cookie"));
		friedFlesh = new MItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("fried_flesh"));
		animalBones = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("animal_bones"));
		cowHoof = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("cow_foot"));
		horn = new ItemHorn().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMobTexture("horn"));
		beakChicken = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getFoodTexture("chicken_beak"));
		footChicken = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("chicken_foot"));
		chickenWingRaw = new MItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("chicken_wing_raw"));
		chickenWingCooked = new MItemFood(4, 0.65F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("chicken_wing_cooked"));
		lambchopRaw = new MItemFood(3, 0.2F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("lamb_chop_raw"));
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("lamb_chop_cooked"));
		sheepHoof = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("sheep_hoof"));
		squidTentacle = new MItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setCreativeTab(tabFood).setTextureName(MAssetManager.getMobTexture("squid_tentacle"));
		calimari = new ItemCalimari(2, 0.6F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("calimari_cooked"));
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("infectious_fungus"));
		airSack = new ItemAirSack().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("air_sack"));
		whisker = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("whisker"));
		catEye = new ItemCatEye(0, 0.0F).setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("cat_eye"));
		wolfHide = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMobTexture("wolf_hide"));
		flesh = new MItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("flesh"));
		marrow = new MItemFood(5, 0.0F).setCreativeTab(tabBrewing).setTextureName(MAssetManager.getFoodTexture("marrow_bowl"));
		legSpider = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("spider_leg"));
		poisonSack = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMobTexture("poison_sack"));
		guano = new ItemGuano().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getTexture("guano"));
		carcassSilverfish = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("silverfish_carcass"));
		hideCreeper = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMobTexture("creeper_hide"));
		slimeCore = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("slime_core"));
		enderCore = new ItemEnderCore(0, 0).setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("ender_core"));
		ghastTentacle = new ItemGhastTentacle().setCreativeTab(tabFood).setTextureName(MAssetManager.getMobTexture("ghast_tentacle"));
		horseHoof = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("horse_foot"));
		horseHaunchRaw = new MItemFood(4, 0.4F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("horse_haunch_raw"));
		horseHaunchCooked = new MItemFood(10, 0.8F).setCreativeTab(tabFood).setTextureName(MAssetManager.getFoodTexture("horse_haunch_cooked"));
		horseHair = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("horse_hair"));
		genes = new ItemGene().setCreativeTab(tabMisc);
		charms = new ItemCharm().setCreativeTab(tabMisc);
		amuletPorcum = new ItemAmuletPorcum().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("pig_amulet"));
		amuletVaccam = new ItemAmuletVaccam().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("horse_amulet"));
		amuletPullum = new ItemAmulet(30).setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("chicken_amulet"));
		amuletOves = new ItemAmulet(30).setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("sheep_amulet"));
		wingSinew = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("wing_sinew"));
		wingSegment = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getTexture("hangglider_segment"));
		hangGlider = new ItemHangGlider().setCreativeTab(null).setTextureName(MAssetManager.getTexture("hangGlider"));
		enderAura = new MItem().setCreativeTab(tabBrewing).setTextureName(MAssetManager.getMobTexture("ender_aura"));
		ghastlySoul = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getDrinkTexture("ghast_soul_bottle"));
		witheredBone = new MItem().setCreativeTab(tabMisc).setTextureName(MAssetManager.getMobTexture("wither_bone"));
		horseHairFibre = new MItem().setCreativeTab(tabMaterials).setTextureName(MAssetManager.getMobTexture("horse_hair_fibre"));
		horseHairBow = new ItemHorseHairBow().setCreativeTab(tabCombat);
	}
	
	public static void load()
	{
		CSItems.addItem(brickStone, "stone_brick");
		CSItems.addItem(brickStoneTin, "stone_brick_tin");
		CSItems.addItem(brickStoneBronze, "stone_brick_bronze");
		CSItems.addItem(brickStoneSteel, "stone_brick_steel");
		CSItems.addItem(brickStoneMeurodite, "stone_brick_meurodite");
		CSItems.addItem(brickSandstone, "sandstone_brick");
		CSItems.addItem(brickRedSandstone, "red_sandstone_brick");
		CSItems.addItem(brickColoredClay, "clay_brick");
		CSItems.addItem(brickFlint, "flint_brick");
		CSItems.addItem(brickLapis, "lapis_brick");
		CSItems.addItem(brickSlate, "granite_brick");
		CSItems.addItem(brickSlateTin, "granite_brick_tin");
		CSItems.addItem(brickSlateBronze, "granite_brick_bronze");
		CSItems.addItem(brickSlateSteel, "granite_brick_steel");
		CSItems.addItem(brickSlateMeurodite, "granite_brick_meurodite");
		CSItems.addItem(brickDesertQuartz, "desertquartz_brick");
		CSItems.addItem(brickNetherQuartz, "netherquartz_brick");
		CSItems.addItem(brickObsidian, "obsidian_brick");
		CSItems.addItem(brickEndStone, "endstone_brick");
		CSItems.addItem(brickBedrock, "bedrock_brick");
		CSItems.addItem(brickRadiantQuartz, "radiantquartz_brick");
		
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
		CSItems.addItem(horseHaunchCooked, "horse_haunch_cooked");
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
		Blocks.diamond_ore.setHarvestLevel("pickaxe", 3);
		Blocks.diamond_block.setHarvestLevel("pickaxe", 3);
		Blocks.obsidian.setHarvestLevel("pickaxe", 4);
		
		Items.diamond_shovel.setHarvestLevel("shovel", 4);
		Items.diamond_pickaxe.setHarvestLevel("pickaxe", 4);
		Items.diamond_axe.setHarvestLevel("axe", 4);
		
		Blocks.bedrock.setHardness(80F).setHarvestLevel("pickaxe", 5);
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
		MBlocks.radiantQuartzOre.setHarvestLevel("pickaxe", 4);
		MBlocks.blaziumBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.soulOre.setHarvestLevel("shovel", 4);
		MBlocks.bronzeBlock.setHarvestLevel("pickaxe", 1);
		MBlocks.uraniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.plutoniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.godstone.setHarvestLevel("pickaxe", 2);
		MBlocks.soulBlock.setHarvestLevel("pickaxe", 4);
		
		MBlocks.snowBrick.setHarvestLevel("shovel", 0);
		MBlocks.gunpowderBlock.setHarvestLevel("shovel", 0);
		MBlocks.sugarBlock.setHarvestLevel("shovel", 0);
		MBlocks.ropeCoil.setHarvestLevel("shears", 0);
		MBlocks.rope.setHarvestLevel("shears", 0);
		MBlocks.slimeOoze.setHarvestLevel("shovel", 0);
		MBlocks.magmaOoze.setHarvestLevel("shovel", 0);
		
		MBlocks.obsidianStairsBricks.setHarvestLevel("pickaxe", 3);
		MBlocks.obsidianStairsRaw.setHarvestLevel("pickaxe", 3);
		MBlocks.obsidianStairsTiles.setHarvestLevel("pickaxe", 3);
		
		MBlocks.glassDoor.setHarvestLevel("pickaxe", 0);
	}
	
	public static void addItemsToChests()
	{
		ChestGenHooks bonusChest = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftCorridor = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks strongholdCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks strongholdCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks desertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		ChestGenHooks strongholdLibrary = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.sandstonePickaxe), 0, 1, 4));
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.sandstoneShovel), 1, 1, 4));
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.stoneCutter), 0, 1, 1));
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.granitePickaxe), 0, 1, 2));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 4, 25));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 1, 5));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 2, 4));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 4, 8, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 3, 8));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelPickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzePickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.sunstoneBlock), 1, 1, 3));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(uranium), 0, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(plutonium), 0, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 0, 5, 1));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(grenadeNuke), 0, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 3, 9, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 3, 13));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 3, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(soulBottle), 1, 2, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzePickaxe), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelSword), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeHelmet), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelChestplate), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeLeggings), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelBoots), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(titaniumIngot), 0, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.godstone), 0, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 1, 2, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 2, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 6, 20));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 1, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MTools.granitePickaxe), 1, 1, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzePickaxe), 0, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelPickaxe), 0, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MTools.meuroditePickaxe), 0, 1, 2));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(desertQuartz), 1, 3, 15));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 3, 8));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 1, 2, 3));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(soulBottle), 1, 4, 2));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiantQuartz), 1, 1, 2));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 4, 25));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(toriteIngot), 1, 5, 15));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 3, 13));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 2, 6));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(soulBottle), 1, 4, 2));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 0, 3, 1));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 4, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(desertQuartz), 3, 11, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(brickDesertQuartz), 1, 4, 15));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(brickSandstone), 1, 12, 15));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 3, 13));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 4, 6));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 8));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(soulBottle), 1, 5, 2));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 0, 3, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(copperIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(tinIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronzeIngot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steelIngot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(plateTinItem), 1, 6, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(plateBronzeItem), 1, 2, 13));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(plateSteelItem), 1, 2, 13));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeGem), 1, 2, 13));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(sunstoneDust), 1, 8, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(desertQuartz), 1, 5, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(radiantQuartz), 1, 3, 8));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(plateMeuroditeItem), 1, 2, 10));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelSword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelPickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelHelmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelChestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelLeggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.steelBoots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeSword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzePickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeHelmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeChestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeLeggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MTools.bronzeBoots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiantQuartz), 1, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(titaniumIngot), 0, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(soulGem), 0, 3, 1));
	}
}
