package minestrapteam.mcore.lib;

import clashsoft.cslib.minecraft.block.CSBlocks;
import minestrapteam.mcore.block.*;
import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.mcore.util.MCBlockHelper;
import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class MCBlocks
{
	public static Block			stoneCutter;
	
	public static MCBlockCustom	stone;
	public static Block			stoneStairsRaw;
	public static Block			stoneStairsTiles;
	public static Block			stone2;
	public static MCBlockCustom	stoneTin;
	public static Block			stoneTinStairsRaw;
	public static Block			stoneTinStairsBricks;
	public static Block			stoneTinStairsTiles;
	public static Block			stoneTinStairsCracked;
	public static Block			stoneTin2;
	public static MCBlockCustom	stoneBronze;
	public static Block			stoneBronzeStairsRaw;
	public static Block			stoneBronzeStairsBricks;
	public static Block			stoneBronzeStairsTiles;
	public static Block			stoneBronzeStairsCracked;
	public static Block			stoneBronze2;
	public static MCBlockCustom	stoneSteel;
	public static Block			stoneSteelStairsRaw;
	public static Block			stoneSteelStairsBricks;
	public static Block			stoneSteelStairsTiles;
	public static Block			stoneSteelStairsCracked;
	public static Block			stoneSteel2;
	public static MCBlockCustom	stoneMeurodite;
	public static Block			stoneMeuroditeStairsRaw;
	public static Block			stoneMeuroditeStairsBricks;
	public static Block			stoneMeuroditeStairsTiles;
	public static Block			stoneMeuroditeStairsCracked;
	public static Block			stoneMeurodite2;
	
	public static MCBlockCustom	graniteSlate;
	public static Block			graniteSlateStairsRaw;
	public static Block			graniteSlateStairsBricks;
	public static Block			graniteSlateStairsTiles;
	public static Block			graniteSlate2;
	public static MCBlockCustom	graniteSlateTin;
	public static Block			graniteSlateTinStairsRaw;
	public static Block			graniteSlateTinStairsBricks;
	public static Block			graniteSlateTinStairsTiles;
	public static Block			graniteSlateTin2;
	public static MCBlockCustom	graniteSlateBronze;
	public static Block			graniteSlateBronzeStairsRaw;
	public static Block			graniteSlateBronzeStairsBricks;
	public static Block			graniteSlateBronzeStairsTiles;
	public static Block			graniteSlateBronze2;
	public static MCBlockCustom	graniteSlateSteel;
	public static Block			graniteSlateSteelStairsRaw;
	public static Block			graniteSlateSteelStairsBricks;
	public static Block			graniteSlateSteelStairsTiles;
	public static Block			graniteSlateSteel2;
	public static MCBlockCustom	graniteSlateMeurodite;
	public static Block			graniteSlateMeuroditeStairsRaw;
	public static Block			graniteSlateMeuroditeStairsBricks;
	public static Block			graniteSlateMeuroditeStairsTiles;
	public static Block			graniteSlateMeurodite2;
	
	public static MCBlockCustom	sandstone;
	public static Block			sandstoneStairsBricks;
	public static Block			sandstoneStairsTiles;
	public static Block			sandstone2;
	public static MCBlockCustom	redSandstone;
	public static Block			redSandstoneStairsRaw;
	public static Block			redSandstoneStairsBricks;
	public static Block			redSandstoneStairsTiles;
	public static Block			redSandstone2;
	public static MCBlockCustom	flint;
	public static Block			flintStairsRaw;
	public static Block			flintStairsBricks;
	public static Block			flintStairsTiles;
	public static Block			flint2;
	public static MCBlockCustom	lapis;
	public static Block			lapisStairsRaw;
	public static Block			lapisStairsBricks;
	public static Block			lapisStairsTiles;
	public static Block			lapis2;
	public static MCBlockCustom	obsidian;
	public static Block			obsidianStairsRaw;
	public static Block			obsidianStairsBricks;
	public static Block			obsidianStairsTiles;
	public static Block			obsidian2;
	public static MCBlockCustom	endstone;
	public static Block			endstoneStairsRaw;
	public static Block			endstoneStairsBricks;
	public static Block			endstoneStairsTiles;
	public static Block			endstoneStairsCracked;
	public static Block			endstone2;
	public static MCBlockCustom	bedrock;
	public static Block			bedrockStairsRaw;
	public static Block			bedrockStairsBricks;
	public static Block			bedrockStairsTiles;
	public static Block			bedrock2;
	public static MCBlockCustom	netherrack;
	public static Block			netherrackStairsRaw;
	public static Block			netherrackStairsTiles;
	public static Block			netherrack2;
	public static MCBlockCustom	netherQuartz;
	public static Block			netherQuartzStairsBricks;
	public static Block			netherQuartzStairsTiles;
	public static Block			netherQuartz2;
	public static MCBlockCustom	desertQuartz;
	public static Block			desertQuartzStairsRaw;
	public static Block			desertQuartzStairsBricks;
	public static Block			desertQuartzStairsTiles;
	public static Block			desertQuartz2;
	public static MCBlockCustom	radiantQuartz;
	public static Block			radiantQuartzStairsRaw;
	public static Block			radiantQuartzStairsBricks;
	public static Block			radiantQuartzStairsTiles;
	public static Block			radiantQuartz2;
	
	public static MCBlockCustom	clay;
	public static Block			clayStairsRaw;
	public static Block			clayStairsTiles;
	public static Block			clay2;
	public static MCBlockCustom	blackClay;
	public static Block			blackClayStairsRaw;
	public static Block			blackClayStairsBricks;
	public static Block			blackClayStairsTiles;
	public static Block			blackClay2;
	public static MCBlockCustom	blueClay;
	public static Block			blueClayStairsRaw;
	public static Block			blueClayStairsBricks;
	public static Block			blueClayStairsTiles;
	public static Block			blueClay2;
	public static MCBlockCustom	brownClay;
	public static Block			brownClayStairsRaw;
	public static Block			brownClayStairsBricks;
	public static Block			brownClayStairsTiles;
	public static Block			brownClay2;
	public static MCBlockCustom	cyanClay;
	public static Block			cyanClayStairsRaw;
	public static Block			cyanClayStairsBricks;
	public static Block			cyanClayStairsTiles;
	public static Block			cyanClay2;
	public static MCBlockCustom	lightBlueClay;
	public static Block			lightBlueClayStairsRaw;
	public static Block			lightBlueClayStairsBricks;
	public static Block			lightBlueClayStairsTiles;
	public static Block			lightBlueClay2;
	public static MCBlockCustom	limeClay;
	public static Block			limeClayStairsRaw;
	public static Block			limeClayStairsBricks;
	public static Block			limeClayStairsTiles;
	public static Block			limeClay2;
	public static MCBlockCustom	magentaClay;
	public static Block			magentaClayStairsRaw;
	public static Block			magentaClayStairsBricks;
	public static Block			magentaClayStairsTiles;
	public static Block			magentaClay2;
	public static MCBlockCustom	orangeClay;
	public static Block			orangeClayStairsRaw;
	public static Block			orangeClayStairsBricks;
	public static Block			orangeClayStairsTiles;
	public static Block			orangeClay2;
	public static MCBlockCustom	pinkClay;
	public static Block			pinkClayStairsRaw;
	public static Block			pinkClayStairsBricks;
	public static Block			pinkClayStairsTiles;
	public static Block			pinkClay2;
	public static MCBlockCustom	purpleClay;
	public static Block			purpleClayStairsRaw;
	public static Block			purpleClayStairsBricks;
	public static Block			purpleClayStairsTiles;
	public static Block			purpleClay2;
	public static MCBlockCustom	redClay;
	public static Block			redClayStairsRaw;
	public static Block			redClayStairsBricks;
	public static Block			redClayStairsTiles;
	public static Block			redClay2;
	public static MCBlockCustom	silverClay;
	public static Block			silverClayStairsRaw;
	public static Block			silverClayStairsBricks;
	public static Block			silverClayStairsTiles;
	public static Block			silverClay2;
	public static MCBlockCustom	whiteClay;
	public static Block			whiteClayStairsRaw;
	public static Block			whiteClayStairsBricks;
	public static Block			whiteClayStairsTiles;
	public static Block			whiteClay2;
	public static MCBlockCustom	yellowClay;
	public static Block			yellowClayStairsRaw;
	public static Block			yellowClayStairsBricks;
	public static Block			yellowClayStairsTiles;
	public static Block			yellowClay2;
	public static MCBlockCustom	greenClay;
	public static Block			greenClayStairsRaw;
	public static Block			greenClayStairsBricks;
	public static Block			greenClayStairsTiles;
	public static Block			greenClay2;
	public static MCBlockCustom	greyClay;
	public static Block			greyClayStairsRaw;
	public static Block			greyClayStairsBricks;
	public static Block			greyClayStairsTiles;
	public static Block			greyClay2;
	
	public static MCBlockCustom	woodOak;
	public static Block			woodOakStairsBoards;
	public static Block			woodOak2;
	public static MCBlockCustom	woodBirch;
	public static Block			woodBirchStairsBoards;
	public static Block			woodBirch2;
	public static MCBlockCustom	woodSpruce;
	public static Block			woodSpruceStairsBoards;
	public static Block			woodSpruce2;
	public static MCBlockCustom	woodJungle;
	public static Block			woodJungleStairsBoards;
	public static Block			woodJungle2;
	public static MCBlockCustom	woodAcacia;
	public static Block			woodAcaciaStairsBoards;
	public static Block			woodAcacia2;
	public static MCBlockCustom	woodDarkOak;
	public static Block			woodDarkOakStairsBoards;
	public static Block			woodDarkOak2;
	
	public static Block			redwoodLog;
	public static Block			redwoodLeaves;
	
	public static void init()
	{
		stoneCutter = new MCBlockStonecutter().setCreativeTab(Minestrappolation.tabTech).setBlockTextureName(MCAssetManager.getMachineTexture("stonecutter")).setHardness(3.5F).setStepSound(Block.soundTypeStone);
		CSBlocks.addBlock(stoneCutter, "stonecutter");
		
		CreativeTabs tab = Minestrappolation.tabStoneDecor;
		CreativeTabs tab_decor = Minestrappolation.tabDecorationBlocks;
		
		String[] types_stone = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", null, null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_stone_2 = new String[] { "pillar", null, null, "tile_slab", "refined_slab" };
		String[] types_granite = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_sandstone = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", null, "chiseled", "chiseled_2", "mossy" };
		String[] types_sandstone_2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_redsandstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "chiseled_2", "chiseled_3", "mossy" };
		String[] types_redsandstone_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_flint = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_lapis = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "gilded" };
		String[] types_obsidian = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "lamp_godstone" };
		String[] types_endstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_bedrock = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_netherrack = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_netherrack2 = new String[] { "pillar", "raw_slab", null, "tile_slab", "refined_slab" };
		String[] types_netherquartz = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_netherquartz_2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_desertquartz = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "refined_tiles", "rough_tiles", "road", "refined", "chiseled" };
		String[] types_desertquartz_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_radiantquartz = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_radiantquartz_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_clay = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_clay_2 = new String[] { "pillar", "raw_slab", null, "tile_slab", "refined_slab" };
		String[] types_colored_clay = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_colored_clay_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		
		stone = MCBlockHelper.createStoneBlock(types_stone, "stone", 1.5F, 10.0F, 0, tab).setIsStone();
		stone2 = MCBlockHelper.createStoneBlock2(types_stone_2, "stone", 1.5F, 10.0F, 0, tab);
		stoneStairsRaw = MCBlockHelper.createStoneStair(Blocks.stone, "stone", 0, tab);
		stoneStairsTiles = MCBlockHelper.createStoneStair(stone, 3, tab);
		stoneTin = MCBlockHelper.createStoneBlock("stone_tin", 1.7F, 11.0F, 0, tab).setIsStone();
		stoneTin2 = MCBlockHelper.createStoneBlock2("stone_tin", 1.7F, 11.0F, 0, tab);
		stoneTinStairsRaw = MCBlockHelper.createStoneStair(stoneTin, 0, tab);
		stoneTinStairsBricks = MCBlockHelper.createStoneStair(stoneTin, 1, tab);
		stoneTinStairsTiles = MCBlockHelper.createStoneStair(stoneTin, 3, tab);
		stoneTinStairsCracked = MCBlockHelper.createStoneStair(stoneTin, 7, tab);
		stoneBronze = MCBlockHelper.createStoneBlock("stone_bronze", 1.7F, 20.0F, 0, tab).setIsStone();
		stoneBronze2 = MCBlockHelper.createStoneBlock2("stone_bronze", 1.7F, 20.0F, 0, tab);
		stoneBronzeStairsRaw = MCBlockHelper.createStoneStair(stoneBronze, 0, tab);
		stoneBronzeStairsBricks = MCBlockHelper.createStoneStair(stoneBronze, 1, tab);
		stoneBronzeStairsTiles = MCBlockHelper.createStoneStair(stoneBronze, 3, tab);
		stoneBronzeStairsCracked = MCBlockHelper.createStoneStair(stoneBronze, 7, tab);
		stoneSteel = MCBlockHelper.createStoneBlock("stone_steel", 3F, 11.0F, 0, tab).setIsStone();
		stoneSteel2 = MCBlockHelper.createStoneBlock2("stone_steel", 3F, 11.0F, 0, tab);
		stoneSteelStairsRaw = MCBlockHelper.createStoneStair(stoneSteel, 0, tab);
		stoneSteelStairsBricks = MCBlockHelper.createStoneStair(stoneSteel, 1, tab);
		stoneSteelStairsTiles = MCBlockHelper.createStoneStair(stoneSteel, 3, tab);
		stoneSteelStairsCracked = MCBlockHelper.createStoneStair(stoneSteel, 7, tab);
		stoneMeurodite = MCBlockHelper.createStoneBlock("stone_meurodite", 2.3F, 15.0F, 0, tab).setIsStone();
		stoneMeurodite2 = MCBlockHelper.createStoneBlock2("stone_meurodite", 2.3F, 15.0F, 0, tab);
		stoneMeuroditeStairsRaw = MCBlockHelper.createStoneStair(stoneMeurodite, 0, tab);
		stoneMeuroditeStairsBricks = MCBlockHelper.createStoneStair(stoneMeurodite, 1, tab);
		stoneMeuroditeStairsTiles = MCBlockHelper.createStoneStair(stoneMeurodite, 3, tab);
		stoneMeuroditeStairsCracked = MCBlockHelper.createStoneStair(stoneMeurodite, 7, tab);
		
		graniteSlate = MCBlockHelper.createStoneBlock(types_granite, "granite", 2F, 15.0F, 0, tab);
		graniteSlate2 = MCBlockHelper.createStoneBlock2("granite", 2F, 15.0F, 0, tab);
		graniteSlateStairsRaw = MCBlockHelper.createStoneStair(graniteSlate, 0, tab);
		graniteSlateStairsBricks = MCBlockHelper.createStoneStair(graniteSlate, 1, tab);
		graniteSlateStairsTiles = MCBlockHelper.createStoneStair(graniteSlate, 3, tab);
		graniteSlateTin = MCBlockHelper.createStoneBlock(types_granite, "granite_tin", 2.2F, 16.0F, 0, tab);
		graniteSlateTin2 = MCBlockHelper.createStoneBlock2("granite_tin", 2.2F, 16.0F, 0, tab);
		graniteSlateTinStairsRaw = MCBlockHelper.createStoneStair(graniteSlateTin, 0, tab);
		graniteSlateTinStairsBricks = MCBlockHelper.createStoneStair(graniteSlateTin, 1, tab);
		graniteSlateTinStairsTiles = MCBlockHelper.createStoneStair(graniteSlateTin, 3, tab);
		graniteSlateBronze = MCBlockHelper.createStoneBlock(types_granite, "granite_bronze", 2.2F, 30.0F, 0, tab);
		graniteSlateBronze2 = MCBlockHelper.createStoneBlock2("granite_bronze", 2.2F, 30.0F, 0, tab);
		graniteSlateBronzeStairsRaw = MCBlockHelper.createStoneStair(graniteSlateBronze, 0, tab);
		graniteSlateBronzeStairsBricks = MCBlockHelper.createStoneStair(graniteSlateBronze, 1, tab);
		graniteSlateBronzeStairsTiles = MCBlockHelper.createStoneStair(graniteSlateBronze, 3, tab);
		graniteSlateSteel = MCBlockHelper.createStoneBlock(types_granite, "granite_steel", 4F, 16.0F, 0, tab);
		graniteSlateSteel2 = MCBlockHelper.createStoneBlock2("granite_steel", 4F, 16.0F, 0, tab);
		graniteSlateSteelStairsRaw = MCBlockHelper.createStoneStair(graniteSlateSteel, 0, tab);
		graniteSlateSteelStairsBricks = MCBlockHelper.createStoneStair(graniteSlateSteel, 1, tab);
		graniteSlateSteelStairsTiles = MCBlockHelper.createStoneStair(graniteSlateSteel, 3, tab);
		graniteSlateMeurodite = MCBlockHelper.createStoneBlock(types_granite, "granite_meurodite", 3F, 22.5F, 0, tab);
		graniteSlateMeurodite2 = MCBlockHelper.createStoneBlock2("granite_meurodite", 3F, 22.5F, 0, tab);
		graniteSlateMeuroditeStairsRaw = MCBlockHelper.createStoneStair(graniteSlateMeurodite, 0, tab);
		graniteSlateMeuroditeStairsBricks = MCBlockHelper.createStoneStair(graniteSlateMeurodite, 1, tab);
		graniteSlateMeuroditeStairsTiles = MCBlockHelper.createStoneStair(graniteSlateMeurodite, 3, tab);
		
		sandstone = MCBlockHelper.createStoneBlock(types_sandstone, "sandstone", 0.8F, 1.33F, 0, tab);
		sandstone2 = MCBlockHelper.createStoneBlock2(types_sandstone_2, "sandstone", 0.8F, 1.33F, 0, tab);
		sandstoneStairsBricks = MCBlockHelper.createStoneStair(sandstone, 1, tab);
		sandstoneStairsTiles = MCBlockHelper.createStoneStair(sandstone, 3, tab);
		redSandstone = MCBlockHelper.createStoneBlock(types_redsandstone, "red_sandstone", 0.8F, 1.33F, 0, tab).setIsRedSandstone();
		redSandstone2 = MCBlockHelper.createStoneBlock2(types_redsandstone_2, "red_sandstone", 0.8F, 1.33F, 0, tab).setIsRedSandstone();
		redSandstoneStairsRaw = MCBlockHelper.createStoneStair(redSandstone, 0, tab);
		redSandstoneStairsBricks = MCBlockHelper.createStoneStair(redSandstone, 1, tab);
		redSandstoneStairsTiles = MCBlockHelper.createStoneStair(redSandstone, 3, tab);
		flint = MCBlockHelper.createStoneBlock(types_flint, "flint", 1.8F, 15.0F, 1, tab);
		flint2 = MCBlockHelper.createStoneBlock2("flint", 1.8F, 15.0F, 1, tab);
		flintStairsRaw = MCBlockHelper.createStoneStair(flint, 0, tab);
		flintStairsBricks = MCBlockHelper.createStoneStair(flint, 1, tab);
		flintStairsTiles = MCBlockHelper.createStoneStair(flint, 3, tab);
		lapis = MCBlockHelper.createStoneBlock(types_lapis, "lapis", 3.0F, 5.0F, 1, tab).setChiseledSided();
		lapis2 = MCBlockHelper.createStoneBlock2("lapis", 3.0F, 5.0F, 1, tab);
		lapisStairsRaw = MCBlockHelper.createStoneStair(Blocks.lapis_block, "lapis", 0, tab);
		lapisStairsBricks = MCBlockHelper.createStoneStair(lapis, 1, tab);
		lapisStairsTiles = MCBlockHelper.createStoneStair(lapis, 3, tab);
		obsidian = MCBlockHelper.createStoneBlock(types_obsidian, "obsidian", 50.0F, 2000.0F, 3, tab).setEnderDragonCantDestroy();
		obsidian2 = MCBlockHelper.createStoneBlock2("obsidian", 50.0F, 2000.0F, 3, tab).setEnderDragonCantDestroy();
		obsidianStairsRaw = MCBlockHelper.createStoneStair(Blocks.obsidian, "obsidian", 0, tab);
		obsidianStairsBricks = MCBlockHelper.createStoneStair(obsidian, 1, tab);
		obsidianStairsTiles = MCBlockHelper.createStoneStair(obsidian, 3, tab);
		endstone = MCBlockHelper.createStoneBlock(types_endstone, "endstone", 3.0F, 15.0F, 0, tab).setChiseledSided().setEnderDragonCantDestroy();
		endstone2 = MCBlockHelper.createStoneBlock2("endstone", 3.0F, 15.0F, 0, tab).setEnderDragonCantDestroy();
		endstoneStairsRaw = MCBlockHelper.createStoneStair(endstone, 0, tab);
		endstoneStairsBricks = MCBlockHelper.createStoneStair(endstone, 1, tab);
		endstoneStairsTiles = MCBlockHelper.createStoneStair(endstone, 3, tab);
		endstoneStairsCracked = MCBlockHelper.createStoneStair(Blocks.end_stone, "endstone.cracked_stairs", 0, tab);
		bedrock = MCBlockHelper.createStoneBlock(types_bedrock, "bedrock", 80F, 6000000.0F, 4, tab).setRoadWalkSpeed(1.5F).setEnderDragonCantDestroy();
		bedrock2 = MCBlockHelper.createStoneBlock2("bedrock", 80F, 6000000.0F, 4, tab).setEnderDragonCantDestroy();
		bedrockStairsRaw = MCBlockHelper.createStoneStair(Blocks.bedrock, "bedrock", 0, tab);
		bedrockStairsBricks = MCBlockHelper.createStoneStair(bedrock, 1, tab);
		bedrockStairsTiles = MCBlockHelper.createStoneStair(bedrock, 3, tab);
		netherrack = MCBlockHelper.createStoneBlock(types_netherrack, "netherrack", 0.4F, 0.67F, 0, tab).setIsNetherrack();
		netherrack2 = MCBlockHelper.createStoneBlock2(types_netherrack2, "netherrack", 0.4F, 0.67F, 0, tab).setIsNetherrack();
		netherrackStairsRaw = MCBlockHelper.createStoneStair(Blocks.netherrack, "netherrack", 0, tab);
		netherrackStairsTiles = MCBlockHelper.createStoneStair(netherrack, 3, tab);
		netherQuartz = MCBlockHelper.createStoneBlock(types_netherquartz, "netherquartz", 0.8F, 1.33F, 0, tab).setChiseledSided();
		netherQuartz2 = MCBlockHelper.createStoneBlock2(types_netherquartz_2, "netherquartz", 0.8F, 1.33F, 0, tab);
		netherQuartzStairsBricks = MCBlockHelper.createStoneStair(netherQuartz, 1, tab);
		netherQuartzStairsTiles = MCBlockHelper.createStoneStair(netherQuartz, 3, tab);
		desertQuartz = MCBlockHelper.createStoneBlock(types_desertquartz, "desertquartz", 1.7F, 4.0F, 1, tab).setChiseledSided();
		desertQuartz2 = MCBlockHelper.createStoneBlock2(types_desertquartz_2, "desertquartz", 1.7F, 4.0F, 1, tab).setRawSlabUnsided();
		desertQuartzStairsRaw = MCBlockHelper.createStoneStair(desertQuartz, 0, tab);
		desertQuartzStairsBricks = MCBlockHelper.createStoneStair(desertQuartz, 1, tab);
		desertQuartzStairsTiles = MCBlockHelper.createStoneStair(desertQuartz, 3, tab);
		radiantQuartz = (MCBlockCustom) MCBlockHelper.createStoneBlock(types_radiantquartz, "radiant_quartz", 2F, 6.0F, 3, tab).setBeaconBase().setLightLevel(0.5F);
		radiantQuartz2 = ((MCBlockCustom2) MCBlockHelper.createStoneBlock2(types_radiantquartz_2, "radiant_quartz", 2F, 6.0F, 3, tab).setBeaconBase().setLightLevel(0.5F)).setRawSlabUnsided();
		radiantQuartzStairsRaw = MCBlockHelper.createStoneStair(radiantQuartz, 0, tab);
		radiantQuartzStairsBricks = MCBlockHelper.createStoneStair(radiantQuartz, 1, tab);
		radiantQuartzStairsTiles = MCBlockHelper.createStoneStair(radiantQuartz, 3, tab);
		
		clay = MCBlockHelper.createStoneBlock(types_clay, "clay", 1.25F, 7.0F, 0, tab).setIsClay();
		clay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "clay", 1.25F, 7.0F, 0, tab);
		clayStairsRaw = MCBlockHelper.createStoneStair(Blocks.hardened_clay, "clay", 0, tab);
		clayStairsTiles = MCBlockHelper.createStoneStair(clay, 3, tab);
		blackClay = MCBlockHelper.createStoneBlock(types_colored_clay, "black_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		blackClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "black_clay", 1.25F, 7.0F, 0, tab);
		blackClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "black_clay", 15, tab);
		blackClayStairsBricks = MCBlockHelper.createStoneStair(blackClay, 1, tab);
		blackClayStairsTiles = MCBlockHelper.createStoneStair(blackClay, 3, tab);
		blueClay = MCBlockHelper.createStoneBlock(types_colored_clay, "blue_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		blueClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "blue_clay", 1.25F, 7.0F, 0, tab);
		blueClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "blue_clay", 11, tab);
		blueClayStairsBricks = MCBlockHelper.createStoneStair(blueClay, 1, tab);
		blueClayStairsTiles = MCBlockHelper.createStoneStair(blueClay, 3, tab);
		brownClay = MCBlockHelper.createStoneBlock(types_colored_clay, "brown_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		brownClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "brown_clay", 1.25F, 7.0F, 0, tab);
		brownClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "brown_clay", 12, tab);
		brownClayStairsBricks = MCBlockHelper.createStoneStair(brownClay, 1, tab);
		brownClayStairsTiles = MCBlockHelper.createStoneStair(brownClay, 3, tab);
		cyanClay = MCBlockHelper.createStoneBlock(types_colored_clay, "cyan_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		cyanClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "cyan_clay", 1.25F, 7.0F, 0, tab);
		cyanClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "cyan_clay", 9, tab);
		cyanClayStairsBricks = MCBlockHelper.createStoneStair(cyanClay, 1, tab);
		cyanClayStairsTiles = MCBlockHelper.createStoneStair(cyanClay, 3, tab);
		lightBlueClay = MCBlockHelper.createStoneBlock(types_colored_clay, "lightblue_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		lightBlueClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "lightblue_clay", 1.25F, 7.0F, 0, tab);
		lightBlueClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "lightblue_clay", 3, tab);
		lightBlueClayStairsBricks = MCBlockHelper.createStoneStair(lightBlueClay, 1, tab);
		lightBlueClayStairsTiles = MCBlockHelper.createStoneStair(lightBlueClay, 3, tab);
		limeClay = MCBlockHelper.createStoneBlock(types_colored_clay, "lime_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		limeClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "lime_clay", 1.25F, 7.0F, 0, tab);
		limeClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "lime_clay", 5, tab);
		limeClayStairsBricks = MCBlockHelper.createStoneStair(limeClay, 1, tab);
		limeClayStairsTiles = MCBlockHelper.createStoneStair(limeClay, 3, tab);
		magentaClay = MCBlockHelper.createStoneBlock(types_colored_clay, "magenta_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		magentaClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "magenta_clay", 1.25F, 7.0F, 0, tab);
		magentaClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "magenta_clay", 2, tab);
		magentaClayStairsBricks = MCBlockHelper.createStoneStair(magentaClay, 1, tab);
		magentaClayStairsTiles = MCBlockHelper.createStoneStair(magentaClay, 3, tab);
		orangeClay = MCBlockHelper.createStoneBlock(types_colored_clay, "orange_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		orangeClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "orange_clay", 1.25F, 7.0F, 0, tab);
		orangeClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "orange_clay", 1, tab);
		orangeClayStairsBricks = MCBlockHelper.createStoneStair(orangeClay, 1, tab);
		orangeClayStairsTiles = MCBlockHelper.createStoneStair(orangeClay, 3, tab);
		pinkClay = MCBlockHelper.createStoneBlock(types_colored_clay, "pink_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		pinkClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "pink_clay", 1.25F, 7.0F, 0, tab);
		pinkClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "pink_clay", 6, tab);
		pinkClayStairsBricks = MCBlockHelper.createStoneStair(pinkClay, 1, tab);
		pinkClayStairsTiles = MCBlockHelper.createStoneStair(pinkClay, 3, tab);
		purpleClay = MCBlockHelper.createStoneBlock(types_colored_clay, "purple_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		purpleClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "purple_clay", 1.25F, 7.0F, 0, tab);
		purpleClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "purple_clay", 10, tab);
		purpleClayStairsBricks = MCBlockHelper.createStoneStair(purpleClay, 1, tab);
		purpleClayStairsTiles = MCBlockHelper.createStoneStair(purpleClay, 3, tab);
		redClay = MCBlockHelper.createStoneBlock(types_colored_clay, "red_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		redClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "red_clay", 1.25F, 7.0F, 0, tab);
		redClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "red_clay", 14, tab);
		redClayStairsBricks = MCBlockHelper.createStoneStair(redClay, 1, tab);
		redClayStairsTiles = MCBlockHelper.createStoneStair(redClay, 3, tab);
		silverClay = MCBlockHelper.createStoneBlock(types_colored_clay, "silver_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		silverClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "silver_clay", 1.25F, 7.0F, 0, tab);
		silverClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "silver_clay", 8, tab);
		silverClayStairsBricks = MCBlockHelper.createStoneStair(silverClay, 1, tab);
		silverClayStairsTiles = MCBlockHelper.createStoneStair(silverClay, 3, tab);
		whiteClay = MCBlockHelper.createStoneBlock(types_colored_clay, "white_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		whiteClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "white_clay", 1.25F, 7.0F, 0, tab);
		whiteClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "white_clay", 0, tab);
		whiteClayStairsBricks = MCBlockHelper.createStoneStair(whiteClay, 1, tab);
		whiteClayStairsTiles = MCBlockHelper.createStoneStair(whiteClay, 3, tab);
		yellowClay = MCBlockHelper.createStoneBlock(types_colored_clay, "yellow_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		yellowClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "yellow_clay", 1.25F, 7.0F, 0, tab);
		yellowClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "yellow_clay", 4, tab);
		yellowClayStairsBricks = MCBlockHelper.createStoneStair(yellowClay, 1, tab);
		yellowClayStairsTiles = MCBlockHelper.createStoneStair(yellowClay, 3, tab);
		greenClay = MCBlockHelper.createStoneBlock(types_colored_clay, "green_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		greenClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "green_clay", 1.25F, 7.0F, 0, tab);
		greenClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "green_clay", 13, tab);
		greenClayStairsBricks = MCBlockHelper.createStoneStair(greenClay, 1, tab);
		greenClayStairsTiles = MCBlockHelper.createStoneStair(greenClay, 3, tab);
		greyClay = MCBlockHelper.createStoneBlock(types_colored_clay, "grey_clay", 1.25F, 7.0F, 0, tab).setIsClay();
		greyClay2 = MCBlockHelper.createStoneBlock2(types_colored_clay_2, "grey_clay", 1.25F, 7.0F, 0, tab);
		greyClayStairsRaw = MCBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "grey_clay", 7, tab);
		greyClayStairsBricks = MCBlockHelper.createStoneStair(greyClay, 1, tab);
		greyClayStairsTiles = MCBlockHelper.createStoneStair(greyClay, 3, tab);
		
		woodOak = MCBlockHelper.createWoodBlock("oak", 2.0F, 5.0F, tab_decor);
		woodOak2 = MCBlockHelper.createWoodBlock2("oak", 2.0F, 5.0F, tab_decor);
		woodOakStairsBoards = MCBlockHelper.createWoodStair(woodOak, 1, tab_decor);
		woodBirch = MCBlockHelper.createWoodBlock("birch", 2.0F, 5.0F, tab_decor);
		woodBirch2 = MCBlockHelper.createWoodBlock2("birch", 2.0F, 5.0F, tab_decor);
		woodBirchStairsBoards = MCBlockHelper.createWoodStair(woodBirch, 1, tab_decor);
		woodSpruce = MCBlockHelper.createWoodBlock("spruce", 2.0F, 5.0F, tab_decor);
		woodSpruce2 = MCBlockHelper.createWoodBlock2("spruce", 2.0F, 5.0F, tab_decor);
		woodSpruceStairsBoards = MCBlockHelper.createWoodStair(woodSpruce, 1, tab_decor);
		woodJungle = MCBlockHelper.createWoodBlock("jungle", 2.0F, 5.0F, tab_decor);
		woodJungle2 = MCBlockHelper.createWoodBlock2("jungle", 2.0F, 5.0F, tab_decor);
		woodJungleStairsBoards = MCBlockHelper.createWoodStair(woodJungle, 1, tab_decor);
		woodAcacia = MCBlockHelper.createWoodBlock("acacia", 2.0F, 5.0F, tab_decor);
		woodAcacia2 = MCBlockHelper.createWoodBlock2("acacia", 2.0F, 5.0F, tab_decor);
		woodAcaciaStairsBoards = MCBlockHelper.createWoodStair(woodAcacia, 1, tab_decor);
		woodDarkOak = MCBlockHelper.createWoodBlock("dark_oak", 2.0F, 5.0F, tab_decor);
		woodDarkOak2 = MCBlockHelper.createWoodBlock2("dark_oak", 2.0F, 5.0F, tab_decor);
		woodDarkOakStairsBoards = MCBlockHelper.createWoodStair(woodDarkOak, 1, tab_decor);
		
		redwoodLog = new MCBlockLog().setBlockTextureName(MCAssetManager.getWoodTexture("redwood_log")).setCreativeTab(tab_decor);
		redwoodLeaves = new MCBlockLeaves(865539).setBlockTextureName(MCAssetManager.getPlantTexture("redwood_leaves")).setCreativeTab(tab_decor);
		
		CSBlocks.addBlock(redwoodLog, "redwood_log");
		CSBlocks.addBlock(redwoodLeaves, "redwood_leaves");
	}
}
