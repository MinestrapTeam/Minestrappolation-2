package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.Minestrappolation.*;
import static minestrapteam.minestrappolation.lib.MTools.bronzePickaxe;
import static minestrapteam.minestrappolation.lib.MTools.bronzeSword;
import static minestrapteam.minestrappolation.lib.MTools.steelPickaxe;
import static minestrapteam.minestrappolation.lib.MTools.steelSword;
import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.mcore.item.MCItem;
import minestrapteam.mcore.item.MCItemFood;
import minestrapteam.mcore.lib.MCBlocks;
import minestrapteam.mcore.util.MCAssetManager;
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
		soulGem = new ItemSoulGem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("soul_gem"));
		meuroditeGem = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("meurodite_gem"));
		uranium = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("uranium"));
		plutonium = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("plutonium"));
		radiantQuartz = new MItemFoiled().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("radiant_quartz"));
		desertQuartz = new MCItem().setTextureName(MCAssetManager.getMineralTexture("desert_quartz"));
		blazeShard = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("blazium_dust"));
		sunstoneDust = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("sunstone_dust"));
		
		copperIngot = new MCItem().setTextureName(MCAssetManager.getMineralTexture("copper_ingot"));
		tinIngot = new MCItem().setTextureName(MCAssetManager.getMineralTexture("tin_ingot"));
		bronzeIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("bronze_ingot"));
		coalIronIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("coaliron_ingot"));
		steelIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("steel_ingot"));
		titaniumIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("titanium_ingot"));
		toriteIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("torite_ingot"));
		blaziumIngot = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMineralTexture("blazium_ingot"));
		
		steelKey = new ItemKey().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getTexture("steel_key"));
		steelLock = new ItemLock().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getTexture("steel_lock"));
		soulBottle = new ItemSoulBottle().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getTexture("soul_bottle"));
		grenade = new ItemGrenade().setCreativeTab(tabCombat).setTextureName(MCAssetManager.getTexture("grenade"));
		grenadeNuke = new ItemGrenadeNuke().setCreativeTab(tabCombat).setTextureName(MCAssetManager.getTexture("grenade_nuke"));
		grenadeSticky = new ItemGrenadeSticky().setCreativeTab(tabCombat).setTextureName(MCAssetManager.getTexture("grenade_sticky"));
		
		// bucketMagma
		
		plateTinItem = new ItemPlating(MBlocks.tinPlate, "tin").setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMineralTexture("tin_plating"));
		plateBronzeItem = new ItemPlating(MBlocks.bronzePlate, "bronze").setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMineralTexture("bronze_plating"));
		plateSteelItem = new ItemPlating(MBlocks.steelPlate, "steel").setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMineralTexture("steel_plating"));
		plateMeuroditeItem = new ItemPlating(MBlocks.meuroditePlate, "meurodite").setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMineralTexture("meurodite_plating"));
		
		ropeItem = new ItemReed(MBlocks.rope).setCreativeTab(tabDecorationBlocks).setTextureName(MCAssetManager.getTexture("rope"));
		cardboardItem = new ItemReed(MBlocks.cardboard).setCreativeTab(tabDecorationBlocks).setTextureName(MCAssetManager.getTexture("cardboard"));
		glassDoor = new EDItemDoor(MBlocks.glassDoor).setCreativeTab(tabDecorationBlocks).setTextureName(MCAssetManager.getTexture("glass_door"));
		
		snout = new MCItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("snout"));
		pigHoof = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("pig_foot"));
		fat = new MCItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fat"));
		grease = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("grease"));
		friedApple = new MCItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_apple"));
		friedBeef = new MCItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_beef"));
		friedBread = new MCItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_bread"));
		friedCarrot = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_carrot"));
		friedCookie = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_cookie"));
		friedFlesh = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("fried_flesh"));
		animalBones = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("animal_bones"));
		cowHoof = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("cow_foot"));
		horn = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("horn"));
		beakChicken = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("chicken_beak"));
		footChicken = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("chicken_foot"));
		chickenWingRaw = new MCItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("chicken_wing_raw"));
		chickenWingCooked = new MCItemFood(4, 0.65F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("chicken_wing_cooked"));
		lambchopRaw = new MCItemFood(3, 0.2F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("lamb_chop_raw"));
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("lamb_chop_cooked"));
		sheepHoof = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("sheep_hoof"));
		squidTentacle = new MCItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("squid_tentacle"));
		calimari = new ItemCalimari(2, 0.6F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("calimari_cooked"));
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("infectious_fungus"));
		airSack = new ItemAirSack().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("air_sack"));
		whisker = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("whisker"));
		catEye = new ItemCatEye(0, 0.0F).setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("cat_eye"));
		wolfHide = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("wolf_hide"));
		flesh = new MCItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("flesh"));
		marrow = new MCItemFood(5, 0.0F).setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getFoodTexture("marrow_bowl"));
		legSpider = new MCItem().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("spider_leg"));
		poisonSack = new MCItem().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("poison_sack"));
		guano = new ItemGuano().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getTexture("guano"));
		carcassSilverfish = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("silverfish_carcass"));
		hideCreeper = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("creeper_hide"));
		slimeCore = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("slime_core"));
		enderCore = new ItemEnderCore(0, 0).setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("ender_core"));
		ghastTentacle = new ItemGhastTentacle().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getMobTexture("ghast_tentacle"));
		horseHoof = new MCItem().setCreativeTab(tabFood).setTextureName(MCAssetManager.getMobTexture("horse_foot"));
		horseHaunchRaw = new MCItemFood(4, 0.4F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("horse_haunch_raw"));
		horseHaunchCooked = new MCItemFood(10, 0.8F).setCreativeTab(tabFood).setTextureName(MCAssetManager.getFoodTexture("horse_haunch_cooked"));
		horseHair = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("horse_hair"));
		genes = new ItemGene().setCreativeTab(tabMaterials);
		charms = new ItemCharm().setCreativeTab(tabMaterials);
		amuletPorcum = new ItemAmuletPorcum().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMobTexture("pig_amulet"));
		amuletVaccam = new ItemAmuletVaccam().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMobTexture("horse_amulet"));
		amuletPullum = new ItemAmuletPullum().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMobTexture("chicken_amulet"));
		amuletOves = new ItemAmuletOves().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMobTexture("sheep_amulet"));
		wingSinew = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("wing_sinew"));
		wingSegment = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getTexture("hangglider_segment"));
		hangGlider = new ItemHangGlider().setCreativeTab(null).setTextureName(MCAssetManager.getTexture("hangGlider"));
		enderAura = new MCItem().setCreativeTab(tabMisc).setTextureName(MCAssetManager.getMobTexture("ender_aura"));
		ghastlySoul = new MCItem().setCreativeTab(tabBrewing).setTextureName(MCAssetManager.getDrinkTexture("ghast_soul_bottle"));
		witheredBone = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("wither_bone"));
		horseHairFibre = new MCItem().setCreativeTab(tabMaterials).setTextureName(MCAssetManager.getMobTexture("horse_hair_fibre"));
		horseHairBow = new ItemHorseHairBow().setCreativeTab(tabCombat);
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
		
		MCBlocks.obsidianStairsBricks.setHarvestLevel("pickaxe", 3);
		MCBlocks.obsidianStairsRaw.setHarvestLevel("pickaxe", 3);
		MCBlocks.obsidianStairsTiles.setHarvestLevel("pickaxe", 3);
		
		MBlocks.glassDoor.setHarvestLevel("pickaxe", 0);		
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
