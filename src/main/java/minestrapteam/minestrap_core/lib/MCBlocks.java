package minestrapteam.minestrap_core.lib;

import clashsoft.cslib.minecraft.block.CSBlocks;
import minestrapteam.minestrap_core.block.MCBlockStonecutter;
import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrap_core.util.MCBlockHelper;
import minestrapteam.minestrappolation.Minestrappolation;

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
	public static Block	radiantQuartz;
	public static Block	radiantQuartz2;
	
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
	
	public static Block	woodOak;
	public static Block	woodOak2;
	public static Block	woodBirch;
	public static Block	woodBirch2;
	public static Block	woodSpruce;
	public static Block	woodSpruce2;
	public static Block	woodJungle;
	public static Block	woodJungle2;
	
	public static void init()
	{
		stoneCutter = new MCBlockStonecutter().setCreativeTab(Minestrappolation.tabTech).setBlockTextureName(MCAssetManager.getMachineTexture("stonecutter")).setHardness(3.5F).setStepSound(Block.soundTypeStone);
		CSBlocks.addBlock(stoneCutter, "stonecutter");
		
		CreativeTabs tab = Minestrappolation.tabStoneDecor;
		CreativeTabs tab_decor = Minestrappolation.tabDecorationBlocks;
		
		String[] types_stone = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", null, null, "mossy", null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_stone_2 = new String[] { "pillar", null, null, "tile_slab", "refined_slab" };
		String[] types_granite = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_sandstone = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", null, "chiseled", null, "mossy" };
		String[] types_sandstone_2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_redsandstone = new String[] {"raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, "mossy", null, null};
		String[] types_redsandstone2 = new String[] {"pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab"};
		String[] types_flint = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_lapis = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_obsidian = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_endstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_bedrock = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
		String[] types_netherrack = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_netherquartz = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", };
		String[] types_netherquartz_2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_desertquartz = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_desertquartz_2 = new String[] { "pillar", null, "brick_slab", "tile_slab", "refined_slab" };
		String[] types_radiantquartz = new String[] {"raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null};
		String[] types_radiantquartz2 = new String[] {"pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab"};
		String[] types_clay = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_colored_clay = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled" };
		String[] types_clay_2 = new String[] { "pillar", "raw_slab", null, "tile_slab", "refined_slab" };
		
		stone = MCBlockHelper.createStoneBlock(types_stone, "stone", 1.5F, 0, tab);
		stone2 = MCBlockHelper.createStoneBlock2(types_stone_2, "stone", 1.5F, 0, tab);
		stoneTin = MCBlockHelper.createStoneBlock("stone_tin", 1.7F, 1, tab);
		stoneTin2 = MCBlockHelper.createStoneBlock2("stone_tin", 1.7F, 1, tab);
		stoneBronze = MCBlockHelper.createStoneBlock("stone_bronze", 1.7F, 1, tab);
		stoneBronze2 = MCBlockHelper.createStoneBlock2("stone_bronze", 1.7F, 1, tab);
		stoneSteel = MCBlockHelper.createStoneBlock("stone_steel", 3F, 1, tab);
		stoneSteel2 = MCBlockHelper.createStoneBlock2("stone_steel", 3F, 1, tab);
		stoneMeurodite = MCBlockHelper.createStoneBlock("stone_meurodite", 2.3F, 2, tab);
		stoneMeurodite2 = MCBlockHelper.createStoneBlock2("stone_meurodite", 2.3F, 2, tab);
		
		granite = MCBlockHelper.createStoneBlock(types_granite, "granite", 2F, 1, tab);
		granite2 = MCBlockHelper.createStoneBlock2("granite", 2F, 1, tab);
		graniteTin = MCBlockHelper.createStoneBlock(types_granite, "granite_tin", 2.2F, 1, tab);
		graniteTin2 = MCBlockHelper.createStoneBlock2("granite_tin", 2.2F, 1, tab);
		graniteBronze = MCBlockHelper.createStoneBlock(types_granite, "granite_bronze", 2.2F, 1, tab);
		graniteBronze2 = MCBlockHelper.createStoneBlock2("granite_bronze", 2.2F, 1, tab);
		graniteSteel = MCBlockHelper.createStoneBlock(types_granite, "granite_steel", 4F, 1, tab);
		graniteSteel2 = MCBlockHelper.createStoneBlock2("granite_steel", 4F, 1, tab);
		graniteMeurodite = MCBlockHelper.createStoneBlock(types_granite, "granite_meurodite", 3F, 2, tab);
		graniteMeurodite2 = MCBlockHelper.createStoneBlock2("granite_meurodite", 3F, 2, tab);
		
		sandstone = MCBlockHelper.createStoneBlock(types_sandstone, "sandstone", 0.8F, 0, tab);
		sandstone2 = MCBlockHelper.createStoneBlock2(types_sandstone_2, "sandstone", 0.8F, 0, tab);
		redSandstone = MCBlockHelper.createStoneBlock("red_sandstone", 0.8F, 0, tab);
		redSandstone2 = MCBlockHelper.createStoneBlock2("red_sandstone", 0.8F, 0, tab);
		flint = MCBlockHelper.createStoneBlock(types_flint, "flint", 1.8F, 1, tab);
		flint2 = MCBlockHelper.createStoneBlock2("flint", 1.8F, 1, tab);
		lapis = MCBlockHelper.createStoneBlock(types_lapis, "lapis", 3.0F, 2, tab).setChiseledSided();
		lapis2 = MCBlockHelper.createStoneBlock2("lapis", 3.0F, 2, tab);
		obsidian = MCBlockHelper.createStoneBlock(types_obsidian, "obsidian", 50.0F, 3, tab);
		obsidian2 = MCBlockHelper.createStoneBlock2("obsidian", 50.0F, 3, tab);
		endstone = MCBlockHelper.createStoneBlock(types_endstone, "endstone", 3.0F, 2, tab).setChiseledSided();
		endstone2 = MCBlockHelper.createStoneBlock2("endstone", 3.0F, 2, tab);
		bedrock = MCBlockHelper.createStoneBlock(types_bedrock, "bedrock", 80F, 4, tab);
		bedrock2 = MCBlockHelper.createStoneBlock2("bedrock", 80F, 4, tab);
		netherrack = MCBlockHelper.createStoneBlock(types_netherrack, "netherrack", 0.4F, 1, tab);
		netherrack2 = MCBlockHelper.createStoneBlock2("netherrack", 0.4F, 1, tab);
		netherQuartz = MCBlockHelper.createStoneBlock(types_netherquartz, "netherquartz", 0.8F, 2, tab).setChiseledSided();
		netherQuartz2 = MCBlockHelper.createStoneBlock2(types_netherquartz_2, "netherquartz", 0.8F, 2, tab);
		desertQuartz = MCBlockHelper.createStoneBlock(types_desertquartz, "desertquartz", 1.7F, 2, tab).setChiseledSided();
		desertQuartz2 = MCBlockHelper.createStoneBlock2(types_desertquartz_2, "desertquartz", 1.7F, 2, tab);
		radiantQuartz = MCBlockHelper.createStoneBlock(types_desertquartz, "radiant_quartz", 2F, 2, tab).setChiseledSided();
		radiantQuartz2 = MCBlockHelper.createStoneBlock2(types_desertquartz_2, "radiant_quartz", 2F, 2, tab);
		
		clay = MCBlockHelper.createStoneBlock(types_clay, "clay", 1.25F, 0, tab).setClayChiseled();
		clay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "clay", 1.25F, 0, tab);
		blackClay = MCBlockHelper.createStoneBlock(types_colored_clay, "black_clay", 1.25F, 0, tab).setClayChiseled();
		blackClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "black_clay", 1.25F, 0, tab);
		blueClay = MCBlockHelper.createStoneBlock(types_colored_clay, "blue_clay", 1.25F, 0, tab).setClayChiseled();
		blueClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "blue_clay", 1.25F, 0, tab);
		brownClay = MCBlockHelper.createStoneBlock(types_colored_clay, "brown_clay", 1.25F, 0, tab).setClayChiseled();
		brownClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "brown_clay", 1.25F, 0, tab);
		cyanClay = MCBlockHelper.createStoneBlock(types_colored_clay, "cyan_clay", 1.25F, 0, tab).setClayChiseled();
		cyanClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "cyan_clay", 1.25F, 0, tab);
		lightBlueClay = MCBlockHelper.createStoneBlock(types_colored_clay, "lightblue_clay", 1.25F, 0, tab).setClayChiseled();
		lightBlueClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "lightblue_clay", 1.25F, 0, tab);
		limeClay = MCBlockHelper.createStoneBlock(types_colored_clay, "lime_clay", 1.25F, 0, tab).setClayChiseled();
		limeClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "lime_clay", 1.25F, 0, tab);
		magentaClay = MCBlockHelper.createStoneBlock(types_colored_clay, "magenta_clay", 1.25F, 0, tab).setClayChiseled();
		magentaClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "magenta_clay", 1.25F, 0, tab);
		orangeClay = MCBlockHelper.createStoneBlock(types_colored_clay, "orange_clay", 1.25F, 0, tab).setClayChiseled();
		orangeClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "orange_clay", 1.25F, 0, tab);
		pinkClay = MCBlockHelper.createStoneBlock(types_colored_clay, "pink_clay", 1.25F, 0, tab).setClayChiseled();
		pinkClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "pink_clay", 1.25F, 0, tab);
		purpleClay = MCBlockHelper.createStoneBlock(types_colored_clay, "purple_clay", 1.25F, 0, tab).setClayChiseled();
		purpleClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "purple_clay", 1.25F, 0, tab);
		redClay = MCBlockHelper.createStoneBlock(types_colored_clay, "red_clay", 1.25F, 0, tab).setClayChiseled();
		redClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "red_clay", 1.25F, 0, tab);
		silverClay = MCBlockHelper.createStoneBlock(types_colored_clay, "silver_clay", 1.25F, 0, tab).setClayChiseled();
		silverClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "silver_clay", 1.25F, 0, tab);
		whiteClay = MCBlockHelper.createStoneBlock(types_colored_clay, "white_clay", 1.25F, 0, tab).setClayChiseled();
		whiteClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "white_clay", 1.25F, 0, tab);
		yellowClay = MCBlockHelper.createStoneBlock(types_colored_clay, "yellow_clay", 1.25F, 0, tab).setClayChiseled();
		yellowClay2 = MCBlockHelper.createStoneBlock2(types_clay_2, "yellow_clay", 1.25F, 0, tab);
		
		woodOak = MCBlockHelper.createWoodBlock("oak", tab_decor);
		woodOak2 = MCBlockHelper.createWoodBlock2("oak", tab_decor);
		woodBirch = MCBlockHelper.createWoodBlock("birch", tab_decor);
		woodBirch2 = MCBlockHelper.createWoodBlock2("birch", tab_decor);
		woodSpruce = MCBlockHelper.createWoodBlock("spruce", tab_decor);
		woodSpruce2 = MCBlockHelper.createWoodBlock2("spruce", tab_decor);
		woodJungle = MCBlockHelper.createWoodBlock("jungle", tab_decor);
		woodJungle2 = MCBlockHelper.createWoodBlock2("jungle", tab_decor);
	}
}
