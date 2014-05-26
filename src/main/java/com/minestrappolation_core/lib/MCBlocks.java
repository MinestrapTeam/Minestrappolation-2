package com.minestrappolation_core.lib;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.block.MCBlockStonecutter;
import com.minestrappolation_core.util.MCBlockHelper;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MCBlocks
{
	public static Block	stoneCutter;
	
	public static Block	stone;
	public static Block	stone2;
	public static Block	stoneTin;
	public static Block	stoneTin2;
	public static Block	stoneBronze;
	public static Block	stoneBronze2;
	public static Block	stoneSteel;
	public static Block	stoneSteel2;
	public static Block	stoneMeurodite;
	public static Block	stoneMeurodite2;
	
	public static Block	granite;
	public static Block	granite2;
	public static Block	graniteTin;
	public static Block	graniteTin2;
	public static Block	graniteBronze;
	public static Block	graniteBronze2;
	public static Block	graniteSteel;
	public static Block	graniteSteel2;
	public static Block	graniteMeurodite;
	public static Block	graniteMeurodite2;
	
	public static Block	sandstone;
	public static Block	sandstone2;
	public static Block	redSandstone;
	public static Block	redSandstone2;
	public static Block	flint;
	public static Block	flint2;
	public static Block	lapis;
	public static Block	lapis2;
	public static Block	obsidian;
	public static Block	obsidian2;
	public static Block	endstone;
	public static Block	endstone2;
	public static Block	bedrock;
	public static Block	bedrock2;
	public static Block	netherrack;
	public static Block	netherrack2;
	public static Block	netherQuartz;
	public static Block	netherQuartz2;
	public static Block	desertQuartz;
	public static Block	desertQuartz2;
	
	// TODO add radiant quartz when textures are finished
	// public static Block radiantQuartz;
	// public static Block radiantQuartz2;
	
	public static Block	clay;
	public static Block	clay2;
	public static Block	blackClay;
	public static Block	blackClay2;
	public static Block	blueClay;
	public static Block	blueClay2;
	public static Block	brownClay;
	public static Block	brownClay2;
	public static Block	cyanClay;
	public static Block	cyanClay2;
	public static Block	lightBlueClay;
	public static Block	lightBlueClay2;
	public static Block	limeClay;
	public static Block	limeClay2;
	public static Block	magentaClay;
	public static Block	magentaClay2;
	public static Block	orangeClay;
	public static Block	orangeClay2;
	public static Block	pinkClay;
	public static Block	pinkClay2;
	public static Block	purpleClay;
	public static Block	purpleClay2;
	public static Block	redClay;
	public static Block	redClay2;
	public static Block	silverClay;
	public static Block	silverClay2;
	public static Block	whiteClay;
	public static Block	whiteClay2;
	public static Block	yellowClay;
	public static Block	yellowClay2;
	
	public static void init()
	{
		stoneCutter = new MCBlockStonecutter().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
		
		CreativeTabs tab = Minestrappolation.tabStoneDecor;
		
		String[] types_stone = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", null, null, "mossy", null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_stone_2 = new String[] { "pillar", null, null, "tile_slab", "refined_slab" };
		String[] types_granite = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_sandstone = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", null, "chiseled", null, "mossy" };
		String[] types_sandstone2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_flint = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_lapis = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_obsidian = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_endstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_bedrock = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_netherrack = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_netherquartz = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_netherquartz2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_desertQuartz = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_desertQuartz2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_clay = new String[] { null, "bricks", null, "tiles", "road", "refined", "chiseled" };
		String[] types_clay_colored = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_clay2 = new String[] { "pillar", "raw_slab", null, "tile_slab", "refined_slab" };
		
		stone = MCBlockHelper.createStoneBlock(types_stone, "stone", 2F, tab);
		stone2 = MCBlockHelper.createStoneBlock2(types_stone_2, "stone", 2F, tab);
		stoneTin = MCBlockHelper.createStoneBlock("stone_tin", 2F, tab);
		stoneTin2 = MCBlockHelper.createStoneBlock2("stone_tin", 2F, tab);
		stoneBronze = MCBlockHelper.createStoneBlock("stone_bronze", 2F, tab);
		stoneBronze2 = MCBlockHelper.createStoneBlock2("stone_bronze", 2F, tab);
		stoneSteel = MCBlockHelper.createStoneBlock("stone_steel", 2F, tab);
		stoneSteel2 = MCBlockHelper.createStoneBlock2("stone_steel", 2F, tab);
		stoneMeurodite = MCBlockHelper.createStoneBlock("stone_meurodite", 2F, tab);
		stoneMeurodite2 = MCBlockHelper.createStoneBlock2("stone_meurodite", 2F, tab);
		
		granite = MCBlockHelper.createStoneBlock(types_granite, "granite", 2F, tab);
		granite2 = MCBlockHelper.createStoneBlock2("granite", 2F, tab);
		graniteTin = MCBlockHelper.createStoneBlock(types_granite, "granite_tin", 2F, tab);
		graniteTin2 = MCBlockHelper.createStoneBlock2("granite_tin", 2F, tab);
		graniteBronze = MCBlockHelper.createStoneBlock(types_granite, "granite_bronze", 2F, tab);
		graniteBronze2 = MCBlockHelper.createStoneBlock2("granite_bronze", 2F, tab);
		graniteSteel = MCBlockHelper.createStoneBlock(types_granite, "granite_steel", 2F, tab);
		graniteSteel2 = MCBlockHelper.createStoneBlock2("granite_steel", 2F, tab);
		graniteMeurodite = MCBlockHelper.createStoneBlock(types_granite, "granite_meurodite", 2F, tab);
		graniteMeurodite2 = MCBlockHelper.createStoneBlock2("granite_meurodite", 2F, tab);
		
		sandstone = MCBlockHelper.createStoneBlock(types_sandstone, "sandstone", 1.5F, tab);
		sandstone2 = MCBlockHelper.createStoneBlock2(types_sandstone2, "sandstone", 1.5F, tab);
		flint = MCBlockHelper.createStoneBlock(types_flint, "flint", 1F, tab);
		flint2 = MCBlockHelper.createStoneBlock2("flint", 1F, tab);
		lapis = MCBlockHelper.createStoneBlock(types_lapis, "lapis", 1F, tab);
		lapis2 = MCBlockHelper.createStoneBlock2("lapis", 1F, tab);
		obsidian = MCBlockHelper.createStoneBlock(types_obsidian, "obsidian", 1F, tab);
		obsidian2 = MCBlockHelper.createStoneBlock2("obsidian", 1F, tab);
		endstone = MCBlockHelper.createStoneBlock(types_endstone, "endstone", 1F, tab);
		endstone2 = MCBlockHelper.createStoneBlock2("endstone", 1F, tab);
		bedrock = MCBlockHelper.createStoneBlock(types_bedrock, "bedrock", 1F, tab);
		bedrock2 = MCBlockHelper.createStoneBlock2("bedrock", 1F, tab);
		netherrack = MCBlockHelper.createStoneBlock(types_netherrack, "netherrack", 1F, tab);
		netherrack2 = MCBlockHelper.createStoneBlock2("netherrack", 1F, tab);
		netherQuartz = MCBlockHelper.createStoneBlock(types_netherquartz, "netherquartz", 1F, tab);
		netherQuartz2 = MCBlockHelper.createStoneBlock2(types_netherquartz2, "netherquartz", 1F, tab);
		desertQuartz = MCBlockHelper.createStoneBlock(types_desertQuartz, "desertquartz", 1F, tab);
		desertQuartz2 = MCBlockHelper.createStoneBlock2(types_desertQuartz2, "desertquartz", 1F, tab);
		
		// TODO add radiant quartz when textures are finished
		// radiantQuartz = MCBlockHelper.createStoneBlock("radiant_quartz", 1F,
		// tab);
		// radiantQuartz2= MCBlockHelper.createStoneBlock2("radiant_quartz", 1F,
		// tab);
		
		clay = MCBlockHelper.createStoneBlock(types_clay, "clay", 2F, tab);
		clay2 = MCBlockHelper.createStoneBlock2(types_clay2, "clay", 2F, tab);
		blackClay = MCBlockHelper.createStoneBlock(types_clay_colored, "black_clay", 2F, tab);
		blackClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "black_clay", 2F, tab);
		blueClay = MCBlockHelper.createStoneBlock(types_clay_colored, "blue_clay", 2F, tab);
		blueClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "blue_clay", 2F, tab);
		brownClay = MCBlockHelper.createStoneBlock(types_clay_colored, "brown_clay", 2F, tab);
		brownClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "brown_clay", 2F, tab);
		cyanClay = MCBlockHelper.createStoneBlock(types_clay_colored, "cyan_clay", 2F, tab);
		cyanClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "cyan_clay", 2F, tab);
		lightBlueClay = MCBlockHelper.createStoneBlock(types_clay_colored, "lightblue_clay", 2F, tab);
		lightBlueClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "lightblue_clay", 2F, tab);
		limeClay = MCBlockHelper.createStoneBlock(types_clay_colored, "lime_clay", 2F, tab);
		limeClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "lime_clay", 2F, tab);
		magentaClay = MCBlockHelper.createStoneBlock(types_clay_colored, "magenta_clay", 2F, tab);
		magentaClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "magenta_clay", 2F, tab);
		orangeClay = MCBlockHelper.createStoneBlock(types_clay_colored, "orange_clay", 2F, tab);
		orangeClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "orange_clay", 2F, tab);
		pinkClay = MCBlockHelper.createStoneBlock(types_clay_colored, "pink_clay", 2F, tab);
		pinkClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "pink_clay", 2F, tab);
		purpleClay = MCBlockHelper.createStoneBlock(types_clay_colored, "purple_clay", 2F, tab);
		purpleClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "purple_clay", 2F, tab);
		redClay = MCBlockHelper.createStoneBlock(types_clay_colored, "red_clay", 2F, tab);
		redClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "red_clay", 2F, tab);
		silverClay = MCBlockHelper.createStoneBlock(types_clay_colored, "silver_clay", 2F, tab);
		silverClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "silver_clay", 2F, tab);
		whiteClay = MCBlockHelper.createStoneBlock(types_clay_colored, "white_clay", 2F, tab);
		whiteClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "white_clay", 2F, tab);
		yellowClay = MCBlockHelper.createStoneBlock(types_clay_colored, "yellow_clay", 2F, tab);
		yellowClay2 = MCBlockHelper.createStoneBlock2(types_clay2, "yellow_clay", 2F, tab);
	}
}
