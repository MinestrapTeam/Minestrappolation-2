package sobiohazardous.minestrappolation.extraores.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class EOConfig {
	public static int 
	meuroditeOreId, 
	meuroditeBlockId, 
	meuroditeIngotId, 
	meuroditeSwordId, 
	meuroditePickaxeId, 
	meuroditeAxeId, 
	meuroditeHoeId, 
	meuroditeShovelId, 
	meuroditeHelmetId, 
	meuroditeChestId, 
	meuroditePantsId, 
	meuroditeBootsId,
	uraniumOreId,
	uraniumId,
	rawUraniumBlockId,
	plutoniumOreId,
	plutoniumId,
	rawPlutoniumBlockId,
	titaniumOreId,
	titaniumIngotId,
	titaniumSwordId,
	titaniumPickaxeId,
	titaniumAxeId,
	titaniumHoeId,
	titaniumShovelId,
	titaniumHelmetId,
	titaniumChestId,
	titaniumPantsId,
	titaniumBootsId,
	titaniumBlockId,
	sunstoneId,
	sunstoneDustId,
	sunstoneOreId,
	toriteOreId,
	toriteIngotId,
	toriteBlockId,
	toriteSwordId,
	toritePickaxeId,
	toriteAxeId,
	toriteHoeId,
	toriteShovelId,
	toriteHelmetId,
	toriteChestId,
	toritePantsId,
	toriteBootsId,
	graniteId,
	graniteBrickId,
	quartziteId,
	quartziteTileId,
	blaziumOreId,
	blaziumBlockId,
	blaziumShardId,
	blaziumIngotId,
	blaziumSwordId,
	blaziumPickaxeId,
	blaziumAxeId,
	blaziumHoeId,
	blaziumShovelId,
	blaziumHelmetId,
	blaziumChestId,
	blaziumPantsId,
	blaziumBootsId,
	copperOreId,
	copperBlockId,
	copperIngotId,
	copperTarnishedId,
	copperSwordId,
	copperPickaxeId,
	copperAxeId,
	copperHoeId,
	copperShovelId,
	tinOreId,
	tinIngotId,
	tinBlockId,
	tinHelmetId,
	tinChestId,
	tinPantsId,
	tinBootsId,
	tinPlateId,
	meuroditePlateID,
	bronzePlateId,
	steelPlateId,
	tinPlateItemId,
	bronzePlateItemId,
	steelPlateItemId,
	coalIronIngotId,
	steelIngotId,
	steelPickaxeId,
	steelAxeId,
	steelShovelId,
	steelHoeId,
	steelSwordId,
	steelHelmetId,
	steelChestId,
	steelPantsId,
	steelBootsId,
	steelBlockId,
	soulOreId,
	soulGemId,
	smoothQuartziteId,
	pillarQuartziteId,
	chiseledQuartziteId,
	smoothQuartzTileId,
	pinkQuartzId,
	sandstonePickaxeId,
	sandstoneShovelId,
	sandstoneAxeId,
	sandstoneHoeId,
	sandstoneSwordId,
	tinPlatedCobbleId,
	tinPlatedMossyId,
	tinPlatedStoneBrickId,
	tinPlatedChiseledId,
	tinPlatedGraniteId,
	bronzeIngotId,
	bronzePickaxeId,
	bronzeShovelId,
	bronzeAxeId,
	bronzeHoeId,
	bronzeSwordId,
	bronzeHelmetId,
	bronzeChestId,
	bronzePantsId,
	bronzeBootsId,
	bronzeBlockId,
	bronzePlatedCobbleId,
	bronzePlatedMossyId,
	bronzePlatedStoneBrickId,
	bronzePlatedChiseledId,
	bronzePlatedGraniteId,
	invinciumId,
	extraOresBedrockId,
	bedrockPickaxeId,
	bedrockAxeId,
	bedrockShovelId,
	bedrockHoeId,
	steelPlatedCobbleId,
	steelPlatedMossyId,
	steelPlatedStoneBrickId,
	steelPlatedChiseledId,
	steelPlatedGraniteId,
	granitePickaxeId,
	graniteShovelId,
	graniteAxeId,
	graniteHoeId,
	graniteSwordId,
	soulBottleId,
	nukeId,
	grenadeId,
	grenadeImpactId,
	grenadeStickyId,
	BPmeuroditeSwordId,
	BPmeuroditePickaxeId,
	BPmeuroditeAxeId,
	BPmeuroditeHoeId,
	BPmeuroditeShovelId,
	BPmeuroditeHelmetId,
	BPmeuroditeChestId,
	BPmeuroditePantsId,
	BPmeuroditeBootsId,
	BPTitaniumSwordId,
	BPTitaniumPickaxeId,
	BPTitaniumAxeId,
	BPTitaniumHoeId,
	BPTitaniumShovelId,
	BPTitaniumHelmetId,
	BPTitaniumChestId,
	BPTitaniumPantsId,
	BPTitaniumBootsId,
	BPToriteSwordId,
	BPToritePickaxeId,
	BPToriteAxeId,
	BPToriteHoeId,
	BPToriteShovelId,
	BPToriteHelmetId,
	BPToriteChestId,
	BPToritePantsId,
	BPToriteBootsId,
	BPBlaziumSwordId,
	BPBlaziumPickaxeId,
	BPBlaziumAxeId,
	BPBlaziumHoeId,
	BPBlaziumShovelId,
	BPBlaziumHelmetId,
	BPBlaziumChestId,
	BPBlaziumPantsId,
	BPBlaziumBootsId,
	BPCopperSwordId,
	BPCopperPickaxeId,
	BPCopperAxeId,
	BPCopperHoeId,
	BPCopperShovelId,
	BPTinHelmetId,
	BPTinChestId,
	BPTinPantsId,
	BPTinBootsId,
	BPSteelPickaxeId,
	BPSteelAxeId,
	BPSteelShovelId,
	BPSteelHoeId,
	BPSteelSwordId,
	BPSteelHelmetId,
	BPSteelChestId,
	BPSteelPantsId,
	BPSteelBootsId,
	BPSandstonePickaxeId,
	BPSandstoneShovelId,
	BPSandstoneAxeId,
	BPSandstoneHoeId,
	BPSandstoneSwordId,
	BPBedrockPickaxeId,
	BPBedrockAxeId,
	BPBedrockShovelId,
	BPBedrockHoeId,
	BPGranitePickaxeId,
	BPGraniteShovelId,
	BPGraniteAxeId,
	BPGraniteHoeId,
	BPGraniteSwordId,
	BPWoodPickaxeId,
	BPWoodAxeId,
	BPWoodShovelId,
	BPWoodHoeId,
	BPWoodSwordId,
    BPClothHelmetId,
	BPClothChestId,
	BPClothPantsId,
	BPClothBootsId,
	BPStonePickaxeId,
	BPStoneAxeId,
	BPStoneShovelId,
	BPStoneHoeId,
	BPStoneSwordId,
	BPChainHelmetId,
	BPChainChestId,
	BPChainPantsId,
	BPChainBootsId,
	BPIronPickaxeId,
	BPIronAxeId,
	BPIronShovelId,
	BPIronHoeId,
	BPIronSwordId,
	BPIronHelmetId,
	BPIronChestId,
	BPIronPantsId,
	BPIronBootsId,
	BPGoldPickaxeId,
	BPGoldAxeId,
	BPGoldShovelId,
	BPGoldHoeId,
	BPGoldSwordId,
	BPGoldHelmetId,
	BPGoldChestId,
	BPGoldPantsId,
	BPGoldBootsId,
	BPDiamondPickaxeId,
	BPDiamondAxeId,
	BPDiamondShovelId,
	BPDiamondHoeId,
	BPDiamondSwordId,
	BPDiamondHelmetId,
	BPDiamondChestId,
	BPDiamondPantsId,
	BPDiamondBootsId,
	smoothRadiantQuartzId,
	chiseledRadiantQuartzId,
	pillarRadiantQuartzId,
	radiantQuartzOreId,
	radiantQuartzId,
	godstoneId,
	melterIdleId,
	melterBurningId,
	radiantQuartzStairsId,
	radiantQuartzSingleSlabId,
	radiantQuartzDoubleSlabId,
	pinkQuartzStairsId,
	pinkQuartzSingleSlabId,
	pinkQuartzDoubleSlabId,
	graniteBrickStairsId,
	graniteBrickSingleSlabId,
	graniteBrickDoubleSlabId,
	tinPlatedCobbleStairsId,
	tinPlatedCobbleSingleSlabId,
	tinPlatedCobbleDoubleSlabId,
	steelPlatedCobbleStairsId,
	steelPlatedCobbleSingleSlabId,
	steelPlatedCobbleDoubleSlabId,	
	bronzePlatedCobbleStairsId,
	bronzePlatedCobbleSingleSlabId,
	bronzePlatedCobbleDoubleSlabId,
	tinPlatedStoneBrickStairsId,
	tinPlatedStoneBrickSingleSlabId,
	tinPlatedStoneBrickDoubleSlabId,
	steelPlatedStoneBrickStairsId,
	steelPlatedStoneBrickSingleSlabId,
	steelPlatedStoneBrickDoubleSlabId,
	bronzePlatedStoneBrickStairsId,
	bronzePlatedStoneBrickSingleSlabId,
	bronzePlatedStoneBrickDoubleSlabId,
	tinPlatedGraniteBrickStairsId,
	tinPlatedGraniteBrickSingleSlabId,
	tinPlatedGraniteBrickDoubleSlabId,
	steelPlatedGraniteBrickStairsId,
	steelPlatedGraniteBrickSingleSlabId,
	steelPlatedGraniteBrickDoubleSlabId,
	bronzePlatedGraniteBrickStairsId,
	bronzePlatedGraniteBrickSingleSlabId,
	bronzePlatedGraniteBrickDoubleSlabId,
	plutoniumInsulatedId,
	glowGlassID,
	uraniumInsulatedId,
	meuroditePlateItemID,
	magmaId,
	bucketMagmaId;
	
	public static int daysUntilTarnish;
	
	public static void initilize(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		meuroditeOreId = config.getBlock("meurodite Ore", 3000).getInt();
	    meuroditeBlockId = config.getBlock("meurodite Block", 3001).getInt();
	    meuroditeIngotId = config.getItem("meurodite Ingot", 1000).getInt();
	    meuroditeSwordId = config.getItem("meurodite Sword", 1001).getInt();
		meuroditePickaxeId = config.getItem("meurodite Pickaxe", 1002).getInt();
		meuroditeAxeId = config.getItem("meurodite Axe", 1003).getInt(); 
		meuroditeHoeId = config.getItem("meurodite Hoe", 1004).getInt(); 
		meuroditeShovelId = config.getItem("meurodite Shovel", 1005).getInt(); 
		meuroditeHelmetId = config.getItem("meurodite Helmet", 1006).getInt();  
		meuroditeChestId = config.getItem("meurodite Chest", 1007).getInt(); 
		meuroditePantsId = config.getItem("meurodite Pants", 1008).getInt();  
		meuroditeBootsId = config.getItem("meurodite Boots", 1009).getInt(); 
		uraniumOreId = config.getBlock("Uranium Ore", 3002).getInt();
		uraniumId = config.getItem("Uranium", 1010).getInt();
		rawUraniumBlockId = config.getBlock("Raw Uranium", 3003).getInt();
		plutoniumOreId = config.getBlock("Plutonium Ore", 3004).getInt();
		plutoniumId = config.getItem("Plutonium", 1011).getInt();
		rawPlutoniumBlockId = config.getBlock("Raw Plutonium", 3005).getInt();
		titaniumOreId = config.getBlock("Titanium Ore", 3006).getInt(); 
		titaniumIngotId = config.getItem("Titanium Ingot", 1012).getInt();
		titaniumSwordId = config.getItem("Titanium Sword", 1013).getInt(); 
		titaniumPickaxeId = config.getItem("Titanium Pick", 1014).getInt();
		titaniumAxeId = config.getItem("Titanium Axe", 1015).getInt();
		titaniumHoeId = config.getItem("Titanium Hoe", 1016).getInt();
		titaniumShovelId = config.getItem("Titanium Shovel", 1017).getInt();
		titaniumHelmetId = config.getItem("Titanium Helmet", 1018).getInt();
		titaniumChestId = config.getItem("Titanium Chest", 1019).getInt();
		titaniumPantsId = config.getItem("Titanium Pants", 1020).getInt();
		titaniumBootsId = config.getItem("Titanium Boots", 1021).getInt();
		titaniumBlockId = config.getBlock("Titanium Block", 3007).getInt(); 
		sunstoneId = config.getBlock("Sunstone", 3008).getInt();
		sunstoneDustId = config.getItem("Sunstone Dust", 1022).getInt();
		sunstoneOreId = config.getBlock("Sunstone Ore", 3009).getInt();
		toriteOreId = config.getBlock("Torite Ore", 3010).getInt();
		toriteIngotId = config.getItem("Torite Ingot", 1023).getInt();
		toriteBlockId = config.getBlock("Torite Block", 3011).getInt();
		toriteSwordId = config.getItem("Torite Sword", 1024).getInt();
		toritePickaxeId = config.getItem("Torite Pick", 1025).getInt();
		toriteAxeId = config.getItem("Torite Axe", 1026).getInt();
		toriteHoeId = config.getItem("Torite Hoe", 1027).getInt();
		toriteShovelId = config.getItem("Torite Shovel", 1028).getInt();
		toriteHelmetId = config.getItem("Torite Helmet", 1029).getInt();
		toriteChestId = config.getItem("Torite Chest", 1030).getInt();
		toritePantsId = config.getItem("Torite Pants", 1031).getInt();
		toriteBootsId = config.getItem("Torite Boots", 1032).getInt();
		graniteId = config.getBlock("Granite", 3012).getInt();
		graniteBrickId = config.getBlock("Granite Brick", 3013).getInt();
		quartziteId = config.getBlock("Quartzite", 3014).getInt();
		quartziteTileId = config.getBlock("Quartzite Tile", 3015).getInt();
		blaziumOreId = config.getBlock("Blazium Ore", 3016).getInt();
		blaziumBlockId = config.getBlock("Blazium Block", 3017).getInt();
		blaziumShardId = config.getItem("Blazium Shard", 1033).getInt();
		blaziumIngotId = config.getItem("Blazium Ingot", 1034).getInt();
		blaziumSwordId = config.getItem("Blazium Sword", 1035).getInt();
		blaziumPickaxeId = config.getItem("Blazium Pickaxe", 1036).getInt();
		blaziumAxeId = config.getItem("Blazium Axe", 1037).getInt();
		blaziumHoeId = config.getItem("Blazium Hoe", 1038).getInt();
		blaziumShovelId = config.getItem("Blazium Shovel", 1039).getInt();
		blaziumHelmetId = config.getItem("Blazium Helmet", 1040).getInt();
		blaziumChestId = config.getItem("Blazium Chest", 1041).getInt();
		blaziumPantsId = config.getItem("Blazium Pants", 1042).getInt();
		blaziumBootsId = config.getItem("Blazium Boots", 1043).getInt();
		copperOreId = config.getBlock("Copper Ore", 3018).getInt();
		copperBlockId = config.getBlock("Copper Block", 3019).getInt();
		copperIngotId = config.getItem("Copper Ingot", 1044).getInt();
		copperTarnishedId = config.getBlock("Copper Tarnished", 3020).getInt();
		copperSwordId = config.getItem("Copper Sword", 1045).getInt();
		copperPickaxeId = config.getItem("Copper Pick", 1046).getInt();
		copperAxeId = config.getItem("Copper Axe", 1047).getInt();
		copperHoeId = config.getItem("Copper Hoe", 1048).getInt();
		copperShovelId = config.getItem("Copper Shovel", 1049).getInt();
		tinOreId = config.getBlock("Tin Ore", 3021).getInt();
		tinIngotId = config.getItem("Tin Ingot", 1050).getInt();
		tinBlockId = config.getBlock("Tin Block", 3022).getInt();
		tinHelmetId = config.getItem("Tin Helmet", 1051).getInt();
		tinChestId = config.getItem("Tin Chest", 1052).getInt();
		tinPantsId = config.getItem("Tin Pants", 1053).getInt();
		tinBootsId = config.getItem("Tin Boots", 1054).getInt();
		tinPlateId = config.getBlock("Tin Plate Block", 3023).getInt();
		bronzePlateId = config.getBlock("Bronze Plate Block", 3024).getInt();
		steelPlateId = config.getBlock("Steel Plate Block", 3025).getInt();
		meuroditePlateID = config.getBlock("Meurodite Plate Block", 3140).getInt();
		tinPlateItemId = config.getItem("Tin Plate Item", 1055).getInt();
		bronzePlateItemId = config.getItem("Bronze Plate Item", 1056).getInt();
		steelPlateItemId = config.getItem("Steel Plate Item", 1057).getInt();	
		coalIronIngotId = config.getItem("Coal Iron Ingot", 1058).getInt();
		steelIngotId = config.getItem("Steel Ingot", 1059).getInt();
		steelPickaxeId = config.getItem("Steel Pickaxe", 1060).getInt();
		steelAxeId = config.getItem("Steel Axe", 1061).getInt();
		steelShovelId = config.getItem("Steel Shovel", 1062).getInt();
		steelHoeId = config.getItem("Steel Hoe", 1063).getInt();
		steelSwordId = config.getItem("Steel Sword", 1064).getInt();
		steelHelmetId = config.getItem("Steel Helmet", 1065).getInt();
		steelChestId = config.getItem("Steel Chest", 1066).getInt();
		steelPantsId = config.getItem("Steel Pants", 1067).getInt();
		steelBootsId = config.getItem("Steel Boots", 1068).getInt();
		steelBlockId = config.getBlock("Steel Block", 3026).getInt();
		soulOreId = config.getBlock("Soul Ore", 3027).getInt();
		soulGemId = config.getItem("Soul Gem", 1069).getInt();
		smoothQuartziteId = config.getBlock("Smooth Quartzite", 3028).getInt();
		pillarQuartziteId = config.getBlock("Quartzite Pillar", 3029).getInt();
		chiseledQuartziteId = config.getBlock("Chiseled Quartzite", 3030).getInt();
		smoothQuartzTileId = config.getBlock("Smooth Quartzite Tile", 3031).getInt();
		pinkQuartzId = config.getItem("Pink Quartz", 1070).getInt();
		sandstonePickaxeId = config.getItem("Sandstone Pick", 1071).getInt();
		sandstoneShovelId = config.getItem("Sandstone Shovel", 1072).getInt();
		sandstoneAxeId = config.getItem("Sandstone Axe", 1073).getInt();
		sandstoneHoeId = config.getItem("Sandstone Hoe", 1074).getInt();
		sandstoneSwordId = config.getItem("Sandstone Sword", 1075).getInt();
		tinPlatedCobbleId = config.getBlock("Tin Plated Cobble", 3032).getInt();
		tinPlatedMossyId = config.getBlock("Tin Plated Mossy", 3033).getInt();
		tinPlatedStoneBrickId = config.getBlock("Tine Plate Stone Brick", 3034).getInt();
		tinPlatedChiseledId = config.getBlock("Tin Plate Chiseled", 3035).getInt();
		tinPlatedGraniteId = config.getBlock("Tin Plated Granite", 3036).getInt();
		bronzeIngotId = config.getItem("Bronze Ingot", 1076).getInt();
		bronzePickaxeId = config.getItem("Bronze Pick", 1077).getInt();
		bronzeShovelId = config.getItem("Bronze Shovel", 1078).getInt();
		bronzeAxeId = config.getItem("Bronze Axe", 1079).getInt();
		bronzeHoeId = config.getItem("Bronze Hoe", 1080).getInt();
		bronzeSwordId = config.getItem("Bronze Sword", 1081).getInt();
		bronzeHelmetId = config.getItem("Bronze Helmet", 1082).getInt();
		bronzeChestId = config.getItem("Bronze Chest", 1083).getInt();
		bronzePantsId = config.getItem("Bronze Pants", 1084).getInt();
		bronzeBootsId = config.getItem("Bronze Boots", 1085).getInt();
		bronzeBlockId = config.getBlock("Bronze Block", 3037).getInt();
		bronzePlatedCobbleId = config.getBlock("Bronze Plated Cobble", 3038).getInt();
		bronzePlatedMossyId = config.getBlock("Bronze Plated Mossy", 3039).getInt();
		bronzePlatedStoneBrickId = config.getBlock("Bronze Plated Stone Brick", 3040).getInt();
		bronzePlatedChiseledId = config.getBlock("Bronze Plated Chiseled", 3041).getInt();
		bronzePlatedGraniteId = config.getBlock("Bronze Plated Granite", 3042).getInt();
		invinciumId = config.getBlock("Invincium", 3043).getInt();
		extraOresBedrockId = config.getBlock("Extra Ores Bedrock", 3044).getInt();
		bedrockPickaxeId = config.getItem("Bedrock Pickaxe", 1086).getInt();
		bedrockAxeId = config.getItem("Bedrock Axe", 1087).getInt();
		bedrockShovelId = config.getItem("Bedrock Shovel", 1088).getInt();
		bedrockHoeId = config.getItem("Bedrock Hoe", 1089).getInt(); 
		steelPlatedCobbleId = config.getBlock("Steel Plated Cobble", 3045).getInt();
		steelPlatedMossyId = config.getBlock("Steel Plated Mossy", 3046).getInt();
		steelPlatedStoneBrickId = config.getBlock("Steel Plated Stone Brick", 3047).getInt();
		steelPlatedChiseledId = config.getBlock("Steel Plated Chiseled", 3048).getInt();
		steelPlatedGraniteId = config.getBlock("Steel Plated Granite", 3049).getInt();
		granitePickaxeId = config.getItem("Granite Pickaxe", 1090).getInt();
		graniteShovelId = config.getItem("Granite Shovel", 1091).getInt();
		graniteAxeId = config.getItem("Granite Axe", 1092).getInt();
		graniteHoeId = config.getItem("Granite Hoe", 1093).getInt();
		graniteSwordId = config.getItem("Granite Sword", 1094).getInt();
		soulBottleId = config.getItem("Soul Bottle", 1095).getInt();
		nukeId = config.getBlock("Nuke", 3050).getInt();
		grenadeId = config.getItem("Nuke Grenade", 1096).getInt();
		grenadeImpactId = config.getItem("Grenade Impact", 1097).getInt(); 
		grenadeStickyId = config.getItem("Grenade Sticky", 1098).getInt();
		BPmeuroditeSwordId = config.getItem("BP meurodite Sword", 1099).getInt();
		BPmeuroditePickaxeId = config.getItem("BP meurodite Pickaxe", 1100).getInt();
		BPmeuroditeAxeId = config.getItem("BP meurodite Axe", 1101).getInt(); 
		BPmeuroditeHoeId = config.getItem("BP meurodite Hoe", 1102).getInt();
		BPmeuroditeShovelId = config.getItem("BP meurodite Shovel", 1103).getInt();
		BPmeuroditeHelmetId = config.getItem("BP meurodite Helmet", 1104).getInt();
		BPmeuroditeChestId = config.getItem("BP meurodite Chest", 1105).getInt();
		BPmeuroditePantsId = config.getItem("BP meurodite Pants", 1106).getInt();
		BPmeuroditeBootsId = config.getItem("BP meurodite Boots", 1107).getInt();
		BPTitaniumSwordId = config.getItem("BP Titanium Sword", 1108).getInt();
		BPTitaniumPickaxeId = config.getItem("BP Titanium Pickaxe", 1109).getInt();
		BPTitaniumAxeId = config.getItem("BP Titanium Axe", 1110).getInt();
		BPTitaniumHoeId = config.getItem("BP Titanium Hoe", 1111).getInt();
		BPTitaniumShovelId = config.getItem("BP Titanium Shovel", 1112).getInt();
		BPTitaniumHelmetId = config.getItem("BP Titanium Helmet", 1113).getInt();
		BPTitaniumChestId = config.getItem("BP Titanium Chest", 1114).getInt();
		BPTitaniumPantsId = config.getItem("BP Titanium Pants", 1115).getInt();
		BPTitaniumBootsId = config.getItem("BP Titanium Boots", 1116).getInt(); 
		BPToriteSwordId = config.getItem("BP Torite Sword", 1117).getInt();
		BPToritePickaxeId = config.getItem("BP Torite Pickaxe", 1118).getInt();
		BPToriteAxeId = config.getItem("BP Torite Axe", 1119).getInt();
		BPToriteHoeId = config.getItem("BP Torite Hoe", 1120).getInt();
		BPToriteShovelId = config.getItem("BP Torite Shovel", 1121).getInt();
		BPToriteHelmetId = config.getItem("BP Torite Helmet", 1122).getInt();
		BPToriteChestId = config.getItem("BP Torite Chest", 1123).getInt();
		BPToritePantsId = config.getItem("BP Torite Pants", 1124).getInt();
		BPToriteBootsId = config.getItem("BP Torite Boots", 1125).getInt();
		BPBlaziumSwordId = config.getItem("BP Blazium Sword", 1126).getInt(); 
		BPBlaziumPickaxeId = config.getItem("BP Blazium Pickaxe", 1127).getInt();
		BPBlaziumAxeId = config.getItem("BP Blazium Axe", 1128).getInt();
		BPBlaziumHoeId = config.getItem("BP Blazium Hoe", 1129).getInt();
		BPBlaziumShovelId = config.getItem("BP Blazium Shovel", 1130).getInt();
		BPBlaziumHelmetId = config.getItem("BP Blazium Helmet", 1131).getInt();
		BPBlaziumChestId = config.getItem("BP Blazium Chest", 1132).getInt();
		BPBlaziumPantsId = config.getItem("BP Blazium Pants", 1133).getInt();
		BPBlaziumBootsId = config.getItem("BP Blazium Boots", 1134).getInt();
		BPCopperSwordId = config.getItem("BP Copper Sword", 1135).getInt(); 
		BPCopperPickaxeId = config.getItem("BP Copper Pickaxe", 1136).getInt();
		BPCopperAxeId = config.getItem("BP Copper Axe", 1137).getInt();
		BPCopperHoeId = config.getItem("BP Copper Hoe", 1138).getInt();
		BPCopperShovelId = config.getItem("BP Copper Shovel", 1139).getInt();
		BPTinHelmetId = config.getItem("BP Tin Helmet", 1140).getInt();
		BPTinChestId = config.getItem("BP Tin Chest", 1141).getInt();
		BPTinPantsId = config.getItem("BP Tin Pants", 1142).getInt();
		BPTinBootsId = config.getItem("BP Tin Boots", 1143).getInt();
		BPSteelPickaxeId = config.getItem("BP Steel Pickaxe", 1144).getInt();
		BPSteelAxeId = config.getItem("BP Steel Axe", 1145).getInt();
		BPSteelShovelId = config.getItem("BP Steel Shovel", 1146).getInt();
		BPSteelHoeId = config.getItem("BP Steel Hoe", 1147).getInt();
		BPSteelSwordId = config.getItem("BP Steel Sword", 1148).getInt();
		BPSteelHelmetId = config.getItem("BP Steel Helmet", 1149).getInt();
		BPSteelChestId = config.getItem("BP Steel Chest", 1150).getInt();
		BPSteelPantsId = config.getItem("BP Steel Pants", 1151).getInt();
		BPSteelBootsId = config.getItem("BP Steel Boots", 1152).getInt(); 
		BPSandstonePickaxeId = config.getItem("BP Sandstone Pick", 1153).getInt();
		BPSandstoneShovelId = config.getItem("BP Sandstone Shovel", 1154).getInt();
		BPSandstoneAxeId = config.getItem("BP Sandstone Axe", 1155).getInt();
		BPSandstoneHoeId = config.getItem("BP Sandstone Hoe", 1156).getInt();
		BPSandstoneSwordId = config.getItem("BP Sandstone Sword", 1157).getInt();
		BPBedrockPickaxeId = config.getItem("BP Bedrock Pick", 1158).getInt();
		BPBedrockAxeId = config.getItem("BP Bedrock Axe", 1159).getInt();
		BPBedrockShovelId = config.getItem("BP Bedrock Shovel", 1160).getInt(); 
		BPBedrockHoeId = config.getItem("BP Bedrock Hoe", 1161).getInt();
		BPGranitePickaxeId = config.getItem("BP Granite Pickaxe", 1162).getInt();
		BPGraniteShovelId = config.getItem("BP Granite Shovel", 1163).getInt();
		BPGraniteAxeId = config.getItem("BP Granite Axe", 1164).getInt();
		BPGraniteHoeId = config.getItem("BP Granite Hoe", 1165).getInt();
		BPGraniteSwordId = config.getItem("BP Granite Sword", 1166).getInt();
		BPWoodPickaxeId = config.getItem("BP Wood Pickaxe", 1167).getInt();
		BPWoodAxeId = config.getItem("BP Wood Axe", 1168).getInt();
		BPWoodShovelId = config.getItem("BP Wood Shovel", 1169).getInt();
		BPWoodHoeId = config.getItem("BP Wood Hoe", 1170).getInt();
		BPWoodSwordId = config.getItem("BP Wood Sword", 1171).getInt();
	    BPClothHelmetId = config.getItem("BP Cloth Helmet", 1172).getInt();
		BPClothChestId = config.getItem("BP Cloth Chest", 1173).getInt();
		BPClothPantsId = config.getItem("BP Cloth Pants", 1174).getInt();
		BPClothBootsId = config.getItem("BP Cloth Boots", 1175).getInt();
		BPStonePickaxeId = config.getItem("BP Stone Pickaxe", 1176).getInt();
		BPStoneAxeId = config.getItem("BP Stone Axe", 1177).getInt();
		BPStoneShovelId = config.getItem("BP Stone Shovel", 1178).getInt();
		BPStoneHoeId = config.getItem("BP Stone Hoe", 1179).getInt();
		BPStoneSwordId = config.getItem("BP Stone Sword", 1180).getInt();
		BPChainHelmetId = config.getItem("BP Chain Helmet", 1181).getInt();
		BPChainChestId = config.getItem("BP Chain Chest", 1182).getInt();
		BPChainPantsId = config.getItem("BP Chain Pants", 1183).getInt();
		BPChainBootsId = config.getItem("BP Chain Boots", 1184).getInt();
		BPIronPickaxeId = config.getItem("BP Iron Pick", 1185).getInt();
		BPIronAxeId = config.getItem("BP Iron Axe", 1186).getInt();
		BPIronShovelId = config.getItem("BP Iron Shovel", 1187).getInt();
		BPIronHoeId = config.getItem("BP Iron Hoe", 1188).getInt();
		BPIronSwordId = config.getItem("BP Iron Sword", 1189).getInt();
		BPIronHelmetId = config.getItem("BP Iron Helmet", 1190).getInt();
		BPIronChestId = config.getItem("BP Iron Chest", 1191).getInt();
		BPIronPantsId = config.getItem("BP Iron Pants", 1192).getInt();
		BPIronBootsId = config.getItem("BP Iron Boots", 1193).getInt();
		BPGoldPickaxeId = config.getItem("BP Gold Pick", 1194).getInt();
		BPGoldAxeId = config.getItem("BP Gold Axe", 1195).getInt();
		BPGoldShovelId = config.getItem("BP Gold Shovel", 1196).getInt();
		BPGoldHoeId = config.getItem("BP Gold Hoe", 1197).getInt();
		BPGoldSwordId = config.getItem("BP Gold Sword", 1198).getInt();
		BPGoldHelmetId = config.getItem("BP Gold Helmet", 1199).getInt();
		BPGoldChestId = config.getItem("BP Gold Chest", 1200).getInt();
		BPGoldPantsId = config.getItem("BP Gold Pants", 1201).getInt();
		BPGoldBootsId = config.getItem("BP Gold Boots", 1202).getInt();
		BPDiamondPickaxeId = config.getItem("BP Diamond Pickaxe", 1203).getInt();
		BPDiamondAxeId = config.getItem("BP Diamond Axe", 1204).getInt();
		BPDiamondShovelId = config.getItem("BP Diamond Shovel", 1205).getInt();
		BPDiamondHoeId = config.getItem("BP Diamond Hoe", 1206).getInt();
		BPDiamondSwordId = config.getItem("BP Diamond Sword", 1207).getInt();
		BPDiamondHelmetId = config.getItem("BP Diamond Helmet", 1208).getInt();
		BPDiamondChestId = config.getItem("BP Diamond Chest", 1209).getInt();
		BPDiamondPantsId = config.getItem("BP Diamond Pants", 1210).getInt();
		BPDiamondBootsId = config.getItem("BP Diamond Boots", 1211).getInt();
		smoothRadiantQuartzId = config.getBlock("Smooth Radiant Quartz", 3051).getInt();
		chiseledRadiantQuartzId = config.getBlock("Chiseled Radiant Quartz", 3052).getInt();
		pillarRadiantQuartzId = config.getBlock("Pillar Radiant Quartz", 3053).getInt();
		radiantQuartzOreId = config.getBlock("Radiant Quartz Ore", 3054).getInt(); 
		radiantQuartzId = config.getItem("Radiant Quartz", 1212).getInt();
		godstoneId  = config.getBlock("Godstone", 3055).getInt();
		melterIdleId  = config.getBlock("Melter Idle", 3056).getInt();
		melterBurningId = config.getBlock("Melter Burnign", 3057).getInt(); 
		radiantQuartzStairsId  = config.getBlock("Radiant Quartz Stairs", 3058).getInt();
		radiantQuartzSingleSlabId  = config.getBlock("Radiant Quartz Single Slab", 3059).getInt();
		radiantQuartzDoubleSlabId  = config.getBlock("Radiant Quartz Double Slab", 3060).getInt();
		pinkQuartzStairsId  = config.getBlock("Pink Quartz Stairs", 3061).getInt();
		pinkQuartzSingleSlabId  = config.getBlock("Pink Quartz Slab", 3062).getInt();
		pinkQuartzDoubleSlabId = config.getBlock("Pink Quartz Double Slab", 3063).getInt();
		graniteBrickStairsId = config.getBlock("Granite Brick Stairs", 3064).getInt();
		graniteBrickSingleSlabId = config.getBlock("Granite Brick Slab", 3065).getInt();
		graniteBrickDoubleSlabId = config.getBlock("Granite Brick Double Slab", 3066).getInt();
		tinPlatedCobbleStairsId = config.getBlock("Tin Plated Cobble Stairs", 3067).getInt();
		tinPlatedCobbleSingleSlabId = config.getBlock("Tin Cobble Plated Slab", 3068).getInt();
		tinPlatedCobbleDoubleSlabId = config.getBlock("Tin Cobble Plated Double Slab", 3069).getInt();
	    steelPlatedCobbleStairsId = config.getBlock("Steel Plated Cobble Stairs", 3070).getInt();
	    steelPlatedCobbleSingleSlabId = config.getBlock("Steel Cobble Plated Slab", 3071).getInt();
	    steelPlatedCobbleDoubleSlabId = config.getBlock("Steel Cobble Plated Double Slab", 3072).getInt();
	    bronzePlatedCobbleStairsId = config.getBlock("Bronze Plated Cobble Stairs", 3073).getInt();
	    bronzePlatedCobbleSingleSlabId = config.getBlock("Bronze Plated Slab", 3074).getInt();
	    bronzePlatedCobbleDoubleSlabId = config.getBlock("Bronze Plated Double Slab", 3075).getInt();
	    tinPlatedStoneBrickStairsId = config.getBlock("Tin Plated Stone Brick Stairs", 3076).getInt();
	    tinPlatedStoneBrickSingleSlabId = config.getBlock("Tin Plated Stone Brick Slab", 3077).getInt();
	    tinPlatedStoneBrickDoubleSlabId = config.getBlock("Tin Plated Stone Brick Double Slab", 3078).getInt();
	    steelPlatedStoneBrickStairsId = config.getBlock("Steel Plated Stone Brick Stairs", 3079).getInt();
	    steelPlatedStoneBrickSingleSlabId = config.getBlock("Steel Plated Stone Brick Slab", 3080).getInt();
	    steelPlatedStoneBrickDoubleSlabId = config.getBlock("Steel Plated Stone Brick Double Slab", 3081).getInt();
	    bronzePlatedStoneBrickStairsId = config.getBlock("Bronze Plated Stone Brick Stairs", 3082).getInt();
	    bronzePlatedStoneBrickSingleSlabId = config.getBlock("Bronze Plated Stone Brick Slab", 3083).getInt();
	    bronzePlatedStoneBrickDoubleSlabId = config.getBlock("Bronze Plated Stone Brick Double Slab", 3084).getInt();
	    tinPlatedGraniteBrickStairsId = config.getBlock("Tin Plated Granite Brick Stairs", 3085).getInt();
	    tinPlatedGraniteBrickSingleSlabId = config.getBlock("Tin Plated Granite Brick Slab", 3086).getInt();
	    tinPlatedGraniteBrickDoubleSlabId = config.getBlock("Tin Plated Granite Brick Double Slab", 3087).getInt();
	    steelPlatedGraniteBrickStairsId = config.getBlock("Steel Plated Granite Brick Stairs", 3088).getInt();
	    steelPlatedGraniteBrickSingleSlabId = config.getBlock("Steel Plated Granite Brick Slab", 3089).getInt();
	    steelPlatedGraniteBrickDoubleSlabId = config.getBlock("Steel Plated Granite Brick Double Slab", 3090).getInt();
	    bronzePlatedGraniteBrickStairsId = config.getBlock("Bronze Plated Granite Brick Stairs", 3091).getInt();
	    bronzePlatedGraniteBrickSingleSlabId = config.getBlock("Bronze Plated Granite Brick Slab", 3092).getInt();
	    bronzePlatedGraniteBrickDoubleSlabId = config.getBlock("Bronze Plated Granite Brick Double Slab", 3093).getInt();
	    plutoniumInsulatedId = config.getBlock("Insulated Plutonium Block", 3094).getInt();
	    uraniumInsulatedId = config.getBlock("Insulated Uranium Block", 3095).getInt();
	    glowGlassID = config.getBlock("Glow Glass", 3096).getInt();
	    daysUntilTarnish = config.get("Misc", "Days until copper tarnish", 3).getInt();
	    meuroditePlateItemID = config.getItem("Meurodite Plate Item", 1075).getInt();
	    magmaId = config.getBlock("Magma", 3097).getInt();
	    bucketMagmaId = config.getItem("Bucket of Magma", 1076).getInt();
		config.save();
	}

}
