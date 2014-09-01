package minestrapteam.minestrappolation.lib;

import clashsoft.cslib.minecraft.block.CSBlocks;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.*;
import minestrapteam.minestrappolation.item.block.MCItemBlockMulti;
import minestrapteam.minestrappolation.material.MaterialOoze;
import minestrapteam.minestrappolation.util.MAssetManager;
import minestrapteam.minestrappolation.util.MBlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class MBlocks
{
	public static Material		materialOoze	= new MaterialOoze(MapColor.foliageColor);
	
	/* / {----- Stonecutter Blocks -----} / */
	
	public static MBlockCustom	stone;
	public static Block			stoneStairsRaw;
	public static Block			stoneStairsTiles;
	public static Block			stone2;
	public static MBlockCustom	stoneTin;
	public static Block			stoneTinStairsRaw;
	public static Block			stoneTinStairsBricks;
	public static Block			stoneTinStairsTiles;
	public static Block			stoneTinStairsCracked;
	public static Block			stoneTin2;
	public static MBlockCustom	stoneBronze;
	public static Block			stoneBronzeStairsRaw;
	public static Block			stoneBronzeStairsBricks;
	public static Block			stoneBronzeStairsTiles;
	public static Block			stoneBronzeStairsCracked;
	public static Block			stoneBronze2;
	public static MBlockCustom	stoneSteel;
	public static Block			stoneSteelStairsRaw;
	public static Block			stoneSteelStairsBricks;
	public static Block			stoneSteelStairsTiles;
	public static Block			stoneSteelStairsCracked;
	public static Block			stoneSteel2;
	public static MBlockCustom	stoneMeurodite;
	public static Block			stoneMeuroditeStairsRaw;
	public static Block			stoneMeuroditeStairsBricks;
	public static Block			stoneMeuroditeStairsTiles;
	public static Block			stoneMeuroditeStairsCracked;
	public static Block			stoneMeurodite2;
	
	public static MBlockCustom	deepstone;
	public static Block			deepstoneStairsRaw;
	public static Block			deepstoneStairsBricks;
	public static Block			deepstoneStairsTiles;
	public static Block			deepstone2;
	
	public static MBlockCustom	coldstone;
	public static Block			coldstoneStairsRaw;
	public static Block			coldstoneStairsBricks;
	public static Block			coldstoneStairsTiles;
	public static Block			coldstone2;
	
	public static MBlockCustom	deepColdstone;
	public static Block			deepColdstoneStairsRaw;
	public static Block			deepColdstoneStairsBricks;
	public static Block			deepColdstoneStairsTiles;
	public static Block			deepColdstone2;
	
	public static MBlockCustom	redrock;
	public static Block			redrockStairsRaw;
	public static Block			redrockStairsBricks;
	public static Block			redrockStairsTiles;
	public static Block			redrock2;
	
	public static MBlockCustom	deepRedrock;
	public static Block			deepRedrockStairsRaw;
	public static Block			deepRedrockStairsBricks;
	public static Block			deepRedrockStairsTiles;
	public static Block			deepRedrock2;
	
	public static MBlockCustom	icestone;
	public static Block			icestoneStairsRaw;
	public static Block			icestoneStairsBricks;
	public static Block			icestoneStairsTiles;
	public static Block			icestone2;
	
	public static MBlockCustom	glacierrock;
	public static Block			glacierrockStairsRaw;
	public static Block			glacierrockStairsBricks;
	public static Block			glacierrockStairsTiles;
	public static Block			glacierrock2;
	
	public static MBlockCustom	oceanstone;
	public static Block			oceanstoneStairsRaw;
	public static Block			oceanstoneStairsBricks;
	public static Block			oceanstoneStairsTiles;
	public static Block			oceanstone2;
	
	public static MBlockCustom	pressurizedOceanstone;
	public static Block			pressurizedOceanstoneStairsRaw;
	public static Block			pressurizedOceanstoneStairsBricks;
	public static Block			pressurizedOceanstoneStairsTiles;
	public static Block			pressurizedOceanstone2;
	
	public static MBlockCustom	graniteSlate;
	public static Block			graniteSlateStairsRaw;
	public static Block			graniteSlateStairsBricks;
	public static Block			graniteSlateStairsTiles;
	public static Block			graniteSlate2;
	public static MBlockCustom	graniteSlateTin;
	public static Block			graniteSlateTinStairsRaw;
	public static Block			graniteSlateTinStairsBricks;
	public static Block			graniteSlateTinStairsTiles;
	public static Block			graniteSlateTin2;
	public static MBlockCustom	graniteSlateBronze;
	public static Block			graniteSlateBronzeStairsRaw;
	public static Block			graniteSlateBronzeStairsBricks;
	public static Block			graniteSlateBronzeStairsTiles;
	public static Block			graniteSlateBronze2;
	public static MBlockCustom	graniteSlateSteel;
	public static Block			graniteSlateSteelStairsRaw;
	public static Block			graniteSlateSteelStairsBricks;
	public static Block			graniteSlateSteelStairsTiles;
	public static Block			graniteSlateSteel2;
	public static MBlockCustom	graniteSlateMeurodite;
	public static Block			graniteSlateMeuroditeStairsRaw;
	public static Block			graniteSlateMeuroditeStairsBricks;
	public static Block			graniteSlateMeuroditeStairsTiles;
	public static Block			graniteSlateMeurodite2;
	
	public static MBlockCustom	sandstone;
	public static Block			sandstoneStairsBricks;
	public static Block			sandstoneStairsTiles;
	public static Block			sandstone2;
	public static MBlockCustom	redSandstone;
	public static Block			redSandstoneStairsRaw;
	public static Block			redSandstoneStairsBricks;
	public static Block			redSandstoneStairsTiles;
	public static Block			redSandstone2;
	public static MBlockCustom	flint;
	public static Block			flintStairsRaw;
	public static Block			flintStairsBricks;
	public static Block			flintStairsTiles;
	public static Block			flint2;
	public static MBlockCustom	lapis;
	public static Block			lapisStairsRaw;
	public static Block			lapisStairsBricks;
	public static Block			lapisStairsTiles;
	public static Block			lapis2;
	public static MBlockCustom	obsidian;
	public static Block			obsidianStairsRaw;
	public static Block			obsidianStairsBricks;
	public static Block			obsidianStairsTiles;
	public static Block			obsidian2;
	public static MBlockCustom	endstone;
	public static Block			endstoneStairsRaw;
	public static Block			endstoneStairsBricks;
	public static Block			endstoneStairsTiles;
	public static Block			endstoneStairsCracked;
	public static Block			endstone2;
	public static MBlockCustom	bedrock;
	public static Block			bedrockStairsRaw;
	public static Block			bedrockStairsBricks;
	public static Block			bedrockStairsTiles;
	public static Block			bedrock2;
	public static MBlockCustom	netherrack;
	public static Block			netherrackStairsRaw;
	public static Block			netherrackStairsTiles;
	public static Block			netherrack2;
	public static MBlockCustom	netherQuartz;
	public static Block			netherQuartzStairsBricks;
	public static Block			netherQuartzStairsTiles;
	public static Block			netherQuartz2;
	public static MBlockCustom	desertQuartz;
	public static Block			desertQuartzStairsRaw;
	public static Block			desertQuartzStairsBricks;
	public static Block			desertQuartzStairsTiles;
	public static Block			desertQuartz2;
	public static MBlockCustom	radiantQuartz;
	public static Block			radiantQuartzStairsRaw;
	public static Block			radiantQuartzStairsBricks;
	public static Block			radiantQuartzStairsTiles;
	public static Block			radiantQuartz2;
	
	public static MBlockCustom	clay;
	public static Block			clayStairsRaw;
	public static Block			clayStairsTiles;
	public static Block			clay2;
	public static MBlockCustom	blackClay;
	public static Block			blackClayStairsRaw;
	public static Block			blackClayStairsBricks;
	public static Block			blackClayStairsTiles;
	public static Block			blackClay2;
	public static MBlockCustom	blueClay;
	public static Block			blueClayStairsRaw;
	public static Block			blueClayStairsBricks;
	public static Block			blueClayStairsTiles;
	public static Block			blueClay2;
	public static MBlockCustom	brownClay;
	public static Block			brownClayStairsRaw;
	public static Block			brownClayStairsBricks;
	public static Block			brownClayStairsTiles;
	public static Block			brownClay2;
	public static MBlockCustom	cyanClay;
	public static Block			cyanClayStairsRaw;
	public static Block			cyanClayStairsBricks;
	public static Block			cyanClayStairsTiles;
	public static Block			cyanClay2;
	public static MBlockCustom	lightBlueClay;
	public static Block			lightBlueClayStairsRaw;
	public static Block			lightBlueClayStairsBricks;
	public static Block			lightBlueClayStairsTiles;
	public static Block			lightBlueClay2;
	public static MBlockCustom	limeClay;
	public static Block			limeClayStairsRaw;
	public static Block			limeClayStairsBricks;
	public static Block			limeClayStairsTiles;
	public static Block			limeClay2;
	public static MBlockCustom	magentaClay;
	public static Block			magentaClayStairsRaw;
	public static Block			magentaClayStairsBricks;
	public static Block			magentaClayStairsTiles;
	public static Block			magentaClay2;
	public static MBlockCustom	orangeClay;
	public static Block			orangeClayStairsRaw;
	public static Block			orangeClayStairsBricks;
	public static Block			orangeClayStairsTiles;
	public static Block			orangeClay2;
	public static MBlockCustom	pinkClay;
	public static Block			pinkClayStairsRaw;
	public static Block			pinkClayStairsBricks;
	public static Block			pinkClayStairsTiles;
	public static Block			pinkClay2;
	public static MBlockCustom	purpleClay;
	public static Block			purpleClayStairsRaw;
	public static Block			purpleClayStairsBricks;
	public static Block			purpleClayStairsTiles;
	public static Block			purpleClay2;
	public static MBlockCustom	redClay;
	public static Block			redClayStairsRaw;
	public static Block			redClayStairsBricks;
	public static Block			redClayStairsTiles;
	public static Block			redClay2;
	public static MBlockCustom	silverClay;
	public static Block			silverClayStairsRaw;
	public static Block			silverClayStairsBricks;
	public static Block			silverClayStairsTiles;
	public static Block			silverClay2;
	public static MBlockCustom	whiteClay;
	public static Block			whiteClayStairsRaw;
	public static Block			whiteClayStairsBricks;
	public static Block			whiteClayStairsTiles;
	public static Block			whiteClay2;
	public static MBlockCustom	yellowClay;
	public static Block			yellowClayStairsRaw;
	public static Block			yellowClayStairsBricks;
	public static Block			yellowClayStairsTiles;
	public static Block			yellowClay2;
	public static MBlockCustom	greenClay;
	public static Block			greenClayStairsRaw;
	public static Block			greenClayStairsBricks;
	public static Block			greenClayStairsTiles;
	public static Block			greenClay2;
	public static MBlockCustom	greyClay;
	public static Block			greyClayStairsRaw;
	public static Block			greyClayStairsBricks;
	public static Block			greyClayStairsTiles;
	public static Block			greyClay2;
	
	/* / {----- Wood Blocks -----} / */
	
	public static MBlockCustom	oak;
	public static Block			oakStairsBoards;
	public static Block			oak2;
	public static MBlockCustom	birch;
	public static Block			birchStairsBoards;
	public static Block			birch2;
	public static MBlockCustom	spruce;
	public static Block			spruceStairsBoards;
	public static Block			spruce2;
	public static MBlockCustom	jungleWood;
	public static Block			jungleWoodStairsBoards;
	public static Block			jungleWood2;
	public static MBlockCustom	acacia;
	public static Block			acaciaStairsBoards;
	public static Block			acacia2;
	public static MBlockCustom	darkOak;
	public static Block			darkOakStairsBoards;
	public static Block			darkOak2;
	public static MBlockCustom	redwood;
	public static Block			redwoodStairsBoards;
	public static Block			redwoodStairsPlanks;
	public static Block			redwood2;
	
	public static Block			redwoodLog;
	public static Block			redwoodLeaves;
	public static Block			redwoodSapling;
	
	/* / {----- EO Blocks -----} / */
	
	public static Block			copperOre;
	public static Block			tinOre;
	public static Block			titaniumOre;
	public static Block			uraniumOre;
	public static Block			plutoniumOre;
	public static Block			meuroditeOre;
	public static Block			sunstoneOre;
	public static Block			toriteOre;
	public static Block			blaziumOre;
	public static Block			soulOre;
	public static Block			radiantQuartzOre;
	
	public static Block			copperBlock;
	public static Block			tinBlock;
	public static Block			bronzeBlock;
	public static Block			titaniumBlock;
	public static Block			uraniumBlock;
	public static Block			uraniumInsulated;
	public static Block			plutoniumBlock;
	public static Block			plutoniumInsulated;
	public static Block			meuroditeBlock;
	public static Block			sunstoneBlock;
	public static Block			toriteBlock;
	public static Block			blaziumBlock;
	public static Block			steelBlock;
	public static Block			soulBlock;
	
	public static Block			tinPlate;
	public static Block			bronzePlate;
	public static Block			steelPlate;
	public static Block			meuroditePlate;
	
	public static Block			magma;
	
	public static Block			invincium;
	public static Block			godstone;
	public static Block			nuke;
	public static Block			melterIdle;
	public static Block			melterBurning;
	public static Block			stoneCutter;
	public static Block			sawmill;
	
	public static BlockLocked	lockedBlock;
	
	/* / {----- ED Blocks -----} / */
	
	public static Block			checkerTiles;
	public static Block			flintEndstoneStairs;
	public static Block			flintQuartzStairs;
	public static Block			obsidianEndstoneStairs;
	public static Block			obsidianQuartzStairs;
	public static Block			edgeStoneBrick;
	public static Block			snowBrick;
	public static Block			roads;
	
	public static Block			glowGlass;
	public static Block			glowGlassPane;
	public static Block			refinedGlass;
	public static Block			refinedGlassPane;
	public static Block			slowGlass;
	
	public static Block			gunpowderBlock;
	public static Block			sugarBlock;
	public static Block			meatBlock;
	public static Block			enderBlock;
	public static Block			slimeOoze;
	public static Block			magmaOoze;
	
	public static Block			goblet;
	public static Block			plate;
	public static Block			rope;
	public static Block			ropeCoil;
	public static Block			crate;
	public static Block			barrel;
	public static Block			cardboard;
	public static Block			cardboardBlock;
	
	public static Block			glassDoor;
	
	public static Block			craftingTable2;
	
	/* / {----- EE Blocks -----} / */
	
	public static Block			witherLayer;
	public static Block			witherBlock;
	public static Block			mossCover;

	public static void init()
	{
		addStoneBlocks();
		
		// EO Blocks
		
		copperOre = new MBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("copper_ore"));
		tinOre = new MBlock(Material.rock).setHardness(3F).setResistance(4F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("tin_ore"));
		titaniumOre = new MBlock(Material.rock).setHardness(6F).setResistance(6000000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("titanium_ore"));
		uraniumOre = new BlockUraniumOre(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("uranium_ore"));
		plutoniumOre = new BlockPlutoniumOre(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("plutonium_ore"));
		meuroditeOre = new MBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("meurodite_ore"));
		sunstoneOre = new BlockSunstoneOre().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("sunstone_ore"));
		toriteOre = new MBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("torite_ore"));
		blaziumOre = new BlockBlaziumOre().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("blazium_ore"));
		soulOre = new BlockSoulOre().setHardness(0.8F).setResistance(1F).setStepSound(Block.soundTypeSand).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("soul_gem_ore"));
		radiantQuartzOre = new MBlock(Material.rock).setHardness(3F).setResistance(6F).setLightLevel(0.3F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("radiant_quartz_ore"));
		
		copperBlock = new BlockCopper(Material.iron).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper");
		tinBlock = new BlockTin(Material.iron).setHardness(3F).setResistance(2F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("tin_block"));
		bronzeBlock = new MBlock(Material.iron).setHardness(7F).setResistance(20F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("bronze_block"));
		titaniumBlock = new MBlock(Material.iron).setHardness(10F).setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("titanium_block"));
		uraniumBlock = new BlockUraniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("uranium_block"));
		uraniumInsulated = new BlockUraniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeMetal);
		plutoniumBlock = new BlockPlutoniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("plutonium_block"));
		plutoniumInsulated = new BlockPlutoniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeMetal);
		meuroditeBlock = new MBlock(Material.iron).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("meurodite_block"));
		sunstoneBlock = new BlockSunstone(Material.glass).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("sunstone_block"));
		toriteBlock = new MBlock(Material.iron).setHardness(6F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("torite_block"));
		blaziumBlock = new BlockBlazium().setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("blazium_block")).setLightLevel(0.7F);
		steelBlock = new BlockSteel().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("steel_block_top"));
		soulBlock = new BlockSoulBlock().setHardness(65F).setResistance(30F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getMineralTexture("soul_gem_block"));
		
		tinPlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("tin_block"));
		bronzePlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("bronze_block"));
		steelPlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("steel_block_top"));
		meuroditePlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("meurodite_block"));
		
		magma = new BlockMagma();
		
		invincium = new BlockInvincium(Material.rock).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("invincium"));
		godstone = new BlockGodstone(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MAssetManager.getMineralTexture("godstone"));
		nuke = new BlockNuke().setHardness(0.0F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeGrass);
		melterIdle = new BlockMelter(false).setHardness(6F).setResistance(8.0F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeStone);
		melterBurning = new BlockMelter(true).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundTypeStone);
		
		lockedBlock = (BlockLocked) new BlockLocked().setBlockUnbreakable().setBlockTextureName("iron_block");
		
		stoneCutter = new BlockStonecutter().setCreativeTab(Minestrappolation.tabTech).setHardness(3.5F).setStepSound(Block.soundTypeStone);
		sawmill = new BlockSawmill().setCreativeTab(Minestrappolation.tabTech).setHardness(2.5F).setStepSound(Block.soundTypeWood);
		
		// ED Blocks
		
		checkerTiles = new BlockTiles().setCreativeTab(Minestrappolation.tabStoneDecor).setStepSound(Block.soundTypeStone);
		flintEndstoneStairs = new MBlockStairs(checkerTiles, 0).setCreativeTab(Minestrappolation.tabStoneDecor).setBlockName("stairs_flint_endstone");
		flintQuartzStairs = new MBlockStairs(checkerTiles, 1).setCreativeTab(Minestrappolation.tabStoneDecor).setBlockName("stairs_flint_quartz");
		obsidianEndstoneStairs = new MBlockStairs(checkerTiles, 2).setCreativeTab(Minestrappolation.tabStoneDecor).setBlockName("stairs_obsidian_endstone");
		obsidianQuartzStairs = new MBlockStairs(checkerTiles, 3).setCreativeTab(Minestrappolation.tabStoneDecor).setBlockName("stairs_obsidan_quartz");
		
		edgeStoneBrick = new BlockEdgeStoneBrick().setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabStoneDecor).setStepSound(Block.soundTypeStone);
		snowBrick = new BlockSnowBrick().setHardness(0.2F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeSnow).setBlockTextureName(MAssetManager.getTexture("snow_tiles"));
		roads = new BlockRoads().setCreativeTab(Minestrappolation.tabStoneDecor).setStepSound(Block.soundTypeStone);
		
		glowGlass = new BlockGlowGlass(Material.glass, true).setHardness(0.8F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeGlass).setBlockTextureName(MAssetManager.getTexture("glow_glass"));
		glowGlassPane = new MBlockPane(Material.glass, MAssetManager.getTexture("glow_glass"), MAssetManager.getTexture("glass_refined_pane"), false).setHardness(0.3F).setLightLevel(1F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabDecorationBlocks);
		refinedGlass = new BlockGlassRefined(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MAssetManager.getTexture("glass_refined"));
		refinedGlassPane = new MBlockPane(Material.glass, MAssetManager.getTexture("glass_refined"), MAssetManager.getTexture("glass_refined_pane"), false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabDecorationBlocks);
		slowGlass = new BlockSlowGlass(Material.glass, true).setHardness(0.5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeGlass).setBlockTextureName(MAssetManager.getTexture("slow_glass"));
		
		gunpowderBlock = new BlockGunpowderBlock(Material.ground).setHardness(0.6F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeGravel).setBlockTextureName(MAssetManager.getMineralTexture("gunpowder_block"));
		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeGravel).setBlockTextureName(MAssetManager.getFoodTexture("sugar_block"));
		meatBlock = new BlockMeatBlock().setHardness(0.8F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeCloth).setBlockTextureName(MAssetManager.getFoodTexture("meat_block"));
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeGlass).setBlockTextureName(MAssetManager.getMineralTexture("ender_block"));
		
		slimeOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeCloth).setBlockTextureName(MAssetManager.getTexture("ooze_slime"));
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeCloth).setBlockTextureName(MAssetManager.getTexture("ooze_magma"));
		
		redwoodLog = new MBlockLog().setBlockTextureName(MAssetManager.getWoodTexture("redwood_log")).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		redwoodLeaves = new MBlockLeaves(865539).setBlockTextureName(MAssetManager.getPlantTexture("redwood_leaves")).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		redwoodSapling = new BlockRedwoodSapling().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockTextureName(MAssetManager.getPlantTexture("redwood_sapling")).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		goblet = new BlockGoblet(Material.rock).setHardness(0.5F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setBlockTextureName(MAssetManager.getTexture("goblet"));
		plate = new BlockPlate(Material.rock).setHardness(0.7F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setBlockTextureName(MAssetManager.getTexture("plate"));
		rope = new BlockRope().setHardness(0.9F).setStepSound(Block.soundTypeCloth);
		ropeCoil = new BlockRopeCoil().setHardness(0.9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeCloth);
		crate = new BlockCrate().setHardness(2.5F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeWood);
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeWood);
		cardboard = new MBlockPane(Material.cloth, MAssetManager.getTexture("cardboard"), MAssetManager.getTexture("cardboard_pane_edge"), true).setHardness(0.3F).setCreativeTab(null);
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		glassDoor = new BlockGlassDoor(Material.glass).setHardness(1F);
		
		craftingTable2 = new BlockWorkbench2().setHardness(2.5F).setStepSound(Block.soundTypeWood).setBlockName("workbench");
		
		// EE Blocks
		
		witherLayer = new BlockWitherLayer().setHardness(0.1F).setStepSound(Block.soundTypeSnow).setBlockTextureName(MAssetManager.getMineralTexture("wither_ash_block"));
		witherBlock = new BlockWitherAsh().setHardness(0.2F).setStepSound(Block.soundTypeSnow).setBlockTextureName(MAssetManager.getMineralTexture("wither_ash_block"));
		mossCover = new BlockMossCover().setHardness(0.2F).setStepSound(Block.soundTypeSnow).setBlockTextureName(MAssetManager.getPlantTexture("moss_cover"));
	}
	
	public static void load()
	{
		CSBlocks.addBlock(copperOre, "copper_ore");
		CSBlocks.addBlock(tinOre, "tin_ore");
		CSBlocks.addBlock(titaniumOre, "titanium_ore");
		CSBlocks.addBlock(uraniumOre, "uranium_ore");
		CSBlocks.addBlock(plutoniumOre, "plutonium_ore");
		CSBlocks.addBlock(meuroditeOre, "meurodite_ore");
		CSBlocks.addBlock(sunstoneOre, "sunstone_ore");
		CSBlocks.addBlock(toriteOre, "torite_ore");
		CSBlocks.addBlock(blaziumOre, "blazium_ore");
		CSBlocks.addBlock(soulOre, "soul_ore");
		CSBlocks.addBlock(radiantQuartzOre, "radiant_quartz_ore");
		
		CSBlocks.addBlock(copperBlock, "copper_block");
		CSBlocks.addBlock(tinBlock, "tin_block");
		CSBlocks.addBlock(bronzeBlock, "bronze_block");
		CSBlocks.addBlock(titaniumBlock, "titanium_block");
		CSBlocks.addBlock(uraniumBlock, "uranium_block");
		CSBlocks.addBlock(uraniumInsulated, "insulated_uranium");
		CSBlocks.addBlock(plutoniumBlock, "plutonium_block");
		CSBlocks.addBlock(plutoniumInsulated, "insulated_plutonium");
		CSBlocks.addBlock(meuroditeBlock, "meurodite_block");
		CSBlocks.addBlock(sunstoneBlock, "sunstone_block");
		CSBlocks.addBlock(toriteBlock, "torite_block");
		CSBlocks.addBlock(blaziumBlock, "blazium_block");
		CSBlocks.addBlock(steelBlock, "steel_block");
		CSBlocks.addBlock(soulBlock, "soul_block");
		
		CSBlocks.addBlock(tinPlate, "tin_plate_block");
		CSBlocks.addBlock(bronzePlate, "bronze_plate_block");
		CSBlocks.addBlock(steelPlate, "steel_plate_block");
		CSBlocks.addBlock(meuroditePlate, "meurodite_plate_block");
		
		CSBlocks.addBlock(magma, "magma");
		
		CSBlocks.addBlock(invincium, "invincium");
		CSBlocks.addBlock(godstone, "godstone");
		CSBlocks.addBlock(nuke, "nuke");
		CSBlocks.addBlock(melterIdle, "melter");
		CSBlocks.addBlock(melterBurning, "melter_burning");
		CSBlocks.addBlock(stoneCutter, "stonecutter");
		CSBlocks.addBlock(sawmill, "sawmill");
		
		CSBlocks.addBlock(lockedBlock, "locked_block");
		
		CSBlocks.addBlock(checkerTiles, MCItemBlockMulti.class, "checker_tiles");
		CSBlocks.addBlock(flintQuartzStairs);
		CSBlocks.addBlock(flintEndstoneStairs);
		CSBlocks.addBlock(obsidianEndstoneStairs);
		CSBlocks.addBlock(obsidianQuartzStairs);
		
		CSBlocks.addBlock(edgeStoneBrick, MCItemBlockMulti.class, "edge_stone_brick");
		CSBlocks.addBlock(snowBrick, "snow_brick");
		CSBlocks.addBlock(roads, MCItemBlockMulti.class, "roads");
		
		CSBlocks.addBlock(glowGlass, "glow_glass");
		CSBlocks.addBlock(glowGlassPane, "glow_glass_pane");
		CSBlocks.addBlock(refinedGlass, "refined_glass");
		CSBlocks.addBlock(refinedGlassPane, "refined_glass_pane");
		CSBlocks.addBlock(slowGlass, "slow_glass");
		
		CSBlocks.addBlock(gunpowderBlock, "gunpowder_block");
		CSBlocks.addBlock(sugarBlock, "sugar_block");
		CSBlocks.addBlock(meatBlock, "meat_block");
		CSBlocks.addBlock(enderBlock, "ender_block");
		CSBlocks.addBlock(slimeOoze, "slime_ooze");
		CSBlocks.addBlock(magmaOoze, "magma_ooze");
		
		CSBlocks.addBlock(redwoodLog, "redwood_log");
		CSBlocks.addBlock(redwoodLeaves, "redwood_leaves");
		CSBlocks.addBlock(redwoodSapling, "redwood_sapling");
		
		CSBlocks.addBlock(goblet, "goblet");
		CSBlocks.addBlock(plate, "plate");
		CSBlocks.addBlock(rope, "rope_block");
		CSBlocks.addBlock(ropeCoil, "rope_coil");
		CSBlocks.addBlock(crate, "crate");
		CSBlocks.addBlock(barrel, "barrel");
		CSBlocks.addBlock(cardboard, "cardboard_pane");
		CSBlocks.addBlock(cardboardBlock, MCItemBlockMulti.class, "cardboard_block");
		
		CSBlocks.addBlock(glassDoor, "glass_door_block");
		
		CSBlocks.replaceBlock(Blocks.crafting_table, craftingTable2);
		
		CSBlocks.addBlock(witherBlock, "wither_block");
		CSBlocks.addBlock(witherLayer, "wither_layer");
		CSBlocks.addBlock(mossCover, "moss_cover");
		
		setFlammability();
	}
	
	private static void setFlammability()
	{
		Blocks.fire.setFireInfo(rope, 30, 60);
		Blocks.fire.setFireInfo(ropeCoil, 30, 60);
	}
	
	private static void addStoneBlocks()
	{
		CreativeTabs tab = Minestrappolation.tabStoneDecor;
		CreativeTabs tab_decor = Minestrappolation.tabBuildingBlocks;
		
		String[] types_stone = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", null, null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_stone_2 = new String[] { "pillar", null, null, "tile_slab", "refined_slab" };
		String[] types_deepstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", "bricks_cracked", "bricks_mossy", null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_deepstone_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_coldstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", "bricks_cracked", "bricks_mossy", null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_coldstone_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_redrock = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", "bricks_cracked", "bricks_mossy", null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_redrock_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_icestone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", "bricks_cracked", "bricks_mossy", null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_icestone_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
		String[] types_oceanstone = new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", "bricks_cracked", "bricks_mossy", null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] types_oceanstone_2 = new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
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
		String[] types_redwood = new String[] { "planks", "bevel", "boards", "panel", "mossy_planks", "mossy_boards", "mossy_panel", "rotten_planks", "rotten_boards", "rotten_panel" };
		String[] types_redwood_2 = new String[] { "planks_slab", "boards_slab" };
		
		stone = MBlockHelper.createStoneBlock(types_stone, "stone", 1.5F, 10.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.25F);
		stone2 = MBlockHelper.createStoneBlock2(types_stone_2, "stone", 1.5F, 10.0F, 0, tab);
		stoneStairsRaw = MBlockHelper.createStoneStair(Blocks.stone, "stone", 0, tab);
		stoneStairsTiles = MBlockHelper.createStoneStair(stone, 3, tab);
		deepstone = MBlockHelper.createStoneBlock(types_deepstone, "deepstone", 3F, 13.0F, 2, tab).setIsStone().setRoadWalkSpeed(1.25F);
		deepstone2 = MBlockHelper.createStoneBlock2(types_deepstone_2, "deepstone", 3F, 13.0F, 2, tab);
		deepstoneStairsRaw = MBlockHelper.createStoneStair(deepstone, 0, tab);
		deepstoneStairsBricks = MBlockHelper.createStoneStair(deepstone, 1, tab);
		deepstoneStairsTiles = MBlockHelper.createStoneStair(deepstone, 3, tab);
		coldstone = MBlockHelper.createStoneBlock(types_coldstone, "coldstone", 1.5F, 10.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.25F);
		coldstone2 = MBlockHelper.createStoneBlock2(types_coldstone_2, "coldstone", 1.5F, 10.0F, 0, tab);
		coldstoneStairsRaw = MBlockHelper.createStoneStair(coldstone, 0, tab);
		coldstoneStairsBricks = MBlockHelper.createStoneStair(coldstone, 1, tab);
		coldstoneStairsTiles = MBlockHelper.createStoneStair(coldstone, 3, tab);
		deepColdstone = MBlockHelper.createStoneBlock(types_coldstone, "deepcoldstone", 3F, 13.0F, 2, tab).setIsStone().setRoadWalkSpeed(1.25F);
		deepColdstone2 = MBlockHelper.createStoneBlock2(types_coldstone_2, "deepcoldstone", 3F, 13.0F, 2, tab);
		deepColdstoneStairsRaw = MBlockHelper.createStoneStair(deepColdstone, 0, tab);
		deepColdstoneStairsBricks = MBlockHelper.createStoneStair(deepColdstone, 1, tab);
		deepColdstoneStairsTiles = MBlockHelper.createStoneStair(deepColdstone, 3, tab);
		redrock = MBlockHelper.createStoneBlock(types_redrock, "redrock", 1.1F, 8.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.25F);
		redrock2 = MBlockHelper.createStoneBlock2(types_redrock_2, "redrock", 1.1F, 8.0F, 0, tab);
		redrockStairsRaw = MBlockHelper.createStoneStair(redrock, 0, tab);
		redrockStairsBricks = MBlockHelper.createStoneStair(redrock, 1, tab);
		redrockStairsTiles = MBlockHelper.createStoneStair(redrock, 3, tab);
		deepRedrock = MBlockHelper.createStoneBlock(types_redrock, "deepredrock", 2.2F, 11.0F, 2, tab).setIsStone().setRoadWalkSpeed(1.25F);
		deepRedrock2 = MBlockHelper.createStoneBlock2(types_redrock_2, "deepredrock", 2.2F, 11.0F, 2, tab);
		deepRedrockStairsRaw = MBlockHelper.createStoneStair(deepRedrock, 0, tab);
		deepRedrockStairsBricks = MBlockHelper.createStoneStair(deepRedrock, 1, tab);
		deepRedrockStairsTiles = MBlockHelper.createStoneStair(deepRedrock, 3, tab);
		icestone = MBlockHelper.createStoneBlock(types_icestone, "icestone", 1.7F, 10.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.25F);
		icestone2 = MBlockHelper.createStoneBlock2(types_icestone_2, "icestone", 1.7F, 10.0F, 0, tab);
		icestoneStairsRaw = MBlockHelper.createStoneStair(icestone, 0, tab);
		icestoneStairsBricks = MBlockHelper.createStoneStair(icestone, 1, tab);
		icestoneStairsTiles = MBlockHelper.createStoneStair(icestone, 3, tab);
		glacierrock = MBlockHelper.createStoneBlock(types_icestone, "glacierrock", 3.4F, 13.0F, 2, tab).setIsStone().setRoadWalkSpeed(1.25F);
		glacierrock2 = MBlockHelper.createStoneBlock2(types_icestone_2, "glacierrock", 3.4F, 13.0F, 2, tab);
		glacierrockStairsRaw = MBlockHelper.createStoneStair(glacierrock, 0, tab);
		glacierrockStairsBricks = MBlockHelper.createStoneStair(glacierrock, 1, tab);
		glacierrockStairsTiles = MBlockHelper.createStoneStair(glacierrock, 3, tab);
		oceanstone = MBlockHelper.createStoneBlock(types_oceanstone, "oceanstone", 1.3F, 12.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.25F);
		oceanstone2 = MBlockHelper.createStoneBlock2(types_oceanstone_2, "oceanstone", 1.3F, 12.0F, 0, tab);
		oceanstoneStairsRaw = MBlockHelper.createStoneStair(oceanstone, 0, tab);
		oceanstoneStairsBricks = MBlockHelper.createStoneStair(oceanstone, 1, tab);
		oceanstoneStairsTiles = MBlockHelper.createStoneStair(oceanstone, 3, tab);
		pressurizedOceanstone = MBlockHelper.createStoneBlock(types_oceanstone, "pressurizedoceanstone", 2.6F, 15.0F, 2, tab).setIsStone().setRoadWalkSpeed(1.25F);
		pressurizedOceanstone2 = MBlockHelper.createStoneBlock2(types_oceanstone_2, "pressurizedoceanstone", 2.6F, 15.0F, 2, tab);
		pressurizedOceanstoneStairsRaw = MBlockHelper.createStoneStair(pressurizedOceanstone, 0, tab);
		pressurizedOceanstoneStairsBricks = MBlockHelper.createStoneStair(pressurizedOceanstone, 1, tab);
		pressurizedOceanstoneStairsTiles = MBlockHelper.createStoneStair(pressurizedOceanstone, 3, tab);
		stoneTin = MBlockHelper.createStoneBlock("stone_tin", 1.7F, 11.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.33F);
		stoneTin2 = MBlockHelper.createStoneBlock2("stone_tin", 1.7F, 11.0F, 0, tab);
		stoneTinStairsRaw = MBlockHelper.createStoneStair(stoneTin, 0, tab);
		stoneTinStairsBricks = MBlockHelper.createStoneStair(stoneTin, 1, tab);
		stoneTinStairsTiles = MBlockHelper.createStoneStair(stoneTin, 3, tab);
		stoneTinStairsCracked = MBlockHelper.createStoneStair(stoneTin, 7, tab);
		stoneBronze = MBlockHelper.createStoneBlock("stone_bronze", 1.7F, 20.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.33F);
		stoneBronze2 = MBlockHelper.createStoneBlock2("stone_bronze", 1.7F, 20.0F, 0, tab);
		stoneBronzeStairsRaw = MBlockHelper.createStoneStair(stoneBronze, 0, tab);
		stoneBronzeStairsBricks = MBlockHelper.createStoneStair(stoneBronze, 1, tab);
		stoneBronzeStairsTiles = MBlockHelper.createStoneStair(stoneBronze, 3, tab);
		stoneBronzeStairsCracked = MBlockHelper.createStoneStair(stoneBronze, 7, tab);
		stoneSteel = MBlockHelper.createStoneBlock("stone_steel", 3F, 11.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.33F);
		stoneSteel2 = MBlockHelper.createStoneBlock2("stone_steel", 3F, 11.0F, 0, tab);
		stoneSteelStairsRaw = MBlockHelper.createStoneStair(stoneSteel, 0, tab);
		stoneSteelStairsBricks = MBlockHelper.createStoneStair(stoneSteel, 1, tab);
		stoneSteelStairsTiles = MBlockHelper.createStoneStair(stoneSteel, 3, tab);
		stoneSteelStairsCracked = MBlockHelper.createStoneStair(stoneSteel, 7, tab);
		stoneMeurodite = MBlockHelper.createStoneBlock("stone_meurodite", 2.3F, 15.0F, 0, tab).setIsStone().setRoadWalkSpeed(1.33F);
		stoneMeurodite2 = MBlockHelper.createStoneBlock2("stone_meurodite", 2.3F, 15.0F, 0, tab);
		stoneMeuroditeStairsRaw = MBlockHelper.createStoneStair(stoneMeurodite, 0, tab);
		stoneMeuroditeStairsBricks = MBlockHelper.createStoneStair(stoneMeurodite, 1, tab);
		stoneMeuroditeStairsTiles = MBlockHelper.createStoneStair(stoneMeurodite, 3, tab);
		stoneMeuroditeStairsCracked = MBlockHelper.createStoneStair(stoneMeurodite, 7, tab);
		
		graniteSlate = MBlockHelper.createStoneBlock(types_granite, "granite", 2F, 15.0F, 0, tab).setRoadWalkSpeed(1.33F);
		graniteSlate2 = MBlockHelper.createStoneBlock2("granite", 2F, 15.0F, 0, tab);
		graniteSlateStairsRaw = MBlockHelper.createStoneStair(graniteSlate, 0, tab);
		graniteSlateStairsBricks = MBlockHelper.createStoneStair(graniteSlate, 1, tab);
		graniteSlateStairsTiles = MBlockHelper.createStoneStair(graniteSlate, 3, tab);
		graniteSlateTin = MBlockHelper.createStoneBlock(types_granite, "granite_tin", 2.2F, 16.0F, 0, tab).setRoadWalkSpeed(1.4F);
		graniteSlateTin2 = MBlockHelper.createStoneBlock2("granite_tin", 2.2F, 16.0F, 0, tab);
		graniteSlateTinStairsRaw = MBlockHelper.createStoneStair(graniteSlateTin, 0, tab);
		graniteSlateTinStairsBricks = MBlockHelper.createStoneStair(graniteSlateTin, 1, tab);
		graniteSlateTinStairsTiles = MBlockHelper.createStoneStair(graniteSlateTin, 3, tab);
		graniteSlateBronze = MBlockHelper.createStoneBlock(types_granite, "granite_bronze", 2.2F, 30.0F, 0, tab).setRoadWalkSpeed(1.4F);
		graniteSlateBronze2 = MBlockHelper.createStoneBlock2("granite_bronze", 2.2F, 30.0F, 0, tab);
		graniteSlateBronzeStairsRaw = MBlockHelper.createStoneStair(graniteSlateBronze, 0, tab);
		graniteSlateBronzeStairsBricks = MBlockHelper.createStoneStair(graniteSlateBronze, 1, tab);
		graniteSlateBronzeStairsTiles = MBlockHelper.createStoneStair(graniteSlateBronze, 3, tab);
		graniteSlateSteel = MBlockHelper.createStoneBlock(types_granite, "granite_steel", 4F, 16.0F, 0, tab).setRoadWalkSpeed(1.4F);
		graniteSlateSteel2 = MBlockHelper.createStoneBlock2("granite_steel", 4F, 16.0F, 0, tab);
		graniteSlateSteelStairsRaw = MBlockHelper.createStoneStair(graniteSlateSteel, 0, tab);
		graniteSlateSteelStairsBricks = MBlockHelper.createStoneStair(graniteSlateSteel, 1, tab);
		graniteSlateSteelStairsTiles = MBlockHelper.createStoneStair(graniteSlateSteel, 3, tab);
		graniteSlateMeurodite = MBlockHelper.createStoneBlock(types_granite, "granite_meurodite", 3F, 22.5F, 0, tab).setRoadWalkSpeed(1.4F);
		graniteSlateMeurodite2 = MBlockHelper.createStoneBlock2("granite_meurodite", 3F, 22.5F, 0, tab);
		graniteSlateMeuroditeStairsRaw = MBlockHelper.createStoneStair(graniteSlateMeurodite, 0, tab);
		graniteSlateMeuroditeStairsBricks = MBlockHelper.createStoneStair(graniteSlateMeurodite, 1, tab);
		graniteSlateMeuroditeStairsTiles = MBlockHelper.createStoneStair(graniteSlateMeurodite, 3, tab);
		
		sandstone = MBlockHelper.createStoneBlock(types_sandstone, "sandstone", 0.8F, 1.33F, 0, tab).setRoadWalkSpeed(1.25F);
		sandstone2 = MBlockHelper.createStoneBlock2(types_sandstone_2, "sandstone", 0.8F, 1.33F, 0, tab);
		sandstoneStairsBricks = MBlockHelper.createStoneStair(sandstone, 1, tab);
		sandstoneStairsTiles = MBlockHelper.createStoneStair(sandstone, 3, tab);
		redSandstone = MBlockHelper.createStoneBlock(types_redsandstone, "red_sandstone", 0.8F, 1.33F, 0, tab).setIsRedSandstone().setRoadWalkSpeed(1.3F);
		redSandstone2 = MBlockHelper.createStoneBlock2(types_redsandstone_2, "red_sandstone", 0.8F, 1.33F, 0, tab).setIsRedSandstone();
		redSandstoneStairsRaw = MBlockHelper.createStoneStair(redSandstone, 0, tab);
		redSandstoneStairsBricks = MBlockHelper.createStoneStair(redSandstone, 1, tab);
		redSandstoneStairsTiles = MBlockHelper.createStoneStair(redSandstone, 3, tab);
		flint = MBlockHelper.createStoneBlock(types_flint, "flint", 1.8F, 15.0F, 1, tab).setRoadWalkSpeed(1.5F);
		flint2 = MBlockHelper.createStoneBlock2("flint", 1.8F, 15.0F, 1, tab);
		flintStairsRaw = MBlockHelper.createStoneStair(flint, 0, tab);
		flintStairsBricks = MBlockHelper.createStoneStair(flint, 1, tab);
		flintStairsTiles = MBlockHelper.createStoneStair(flint, 3, tab);
		lapis = MBlockHelper.createStoneBlock(types_lapis, "lapis", 3.0F, 5.0F, 1, tab).setChiseledSided().setRoadWalkSpeed(1.5F);
		lapis2 = MBlockHelper.createStoneBlock2("lapis", 3.0F, 5.0F, 1, tab);
		lapisStairsRaw = MBlockHelper.createStoneStair(Blocks.lapis_block, "lapis", 0, tab);
		lapisStairsBricks = MBlockHelper.createStoneStair(lapis, 1, tab);
		lapisStairsTiles = MBlockHelper.createStoneStair(lapis, 3, tab);
		obsidian = MBlockHelper.createStoneBlock(types_obsidian, "obsidian", 50.0F, 2000.0F, 3, tab).setEnderDragonCantDestroy().setRoadWalkSpeed(1.75F);
		obsidian2 = MBlockHelper.createStoneBlock2("obsidian", 50.0F, 2000.0F, 3, tab).setEnderDragonCantDestroy();
		obsidianStairsRaw = MBlockHelper.createStoneStair(Blocks.obsidian, "obsidian", 0, tab);
		obsidianStairsBricks = MBlockHelper.createStoneStair(obsidian, 1, tab);
		obsidianStairsTiles = MBlockHelper.createStoneStair(obsidian, 3, tab);
		endstone = MBlockHelper.createStoneBlock(types_endstone, "endstone", 3.0F, 15.0F, 0, tab).setChiseledSided().setEnderDragonCantDestroy().setRoadWalkSpeed(1.75F);
		endstone2 = MBlockHelper.createStoneBlock2("endstone", 3.0F, 15.0F, 0, tab).setEnderDragonCantDestroy();
		endstoneStairsRaw = MBlockHelper.createStoneStair(endstone, 0, tab);
		endstoneStairsBricks = MBlockHelper.createStoneStair(endstone, 1, tab);
		endstoneStairsTiles = MBlockHelper.createStoneStair(endstone, 3, tab);
		endstoneStairsCracked = MBlockHelper.createStoneStair(Blocks.end_stone, "endstone.cracked_stairs", 0, tab);
		bedrock = MBlockHelper.createStoneBlock(types_bedrock, "bedrock", 80F, 6000000.0F, 4, tab).setRoadWalkSpeed(1.5F).setEnderDragonCantDestroy().setRoadWalkSpeed(2.5F);
		bedrock2 = MBlockHelper.createStoneBlock2("bedrock", 80F, 6000000.0F, 4, tab).setEnderDragonCantDestroy();
		bedrockStairsRaw = MBlockHelper.createStoneStair(Blocks.bedrock, "bedrock", 0, tab);
		bedrockStairsBricks = MBlockHelper.createStoneStair(bedrock, 1, tab);
		bedrockStairsTiles = MBlockHelper.createStoneStair(bedrock, 3, tab);
		netherrack = MBlockHelper.createStoneBlock(types_netherrack, "netherrack", 0.4F, 0.67F, 0, tab).setIsNetherrack().setRoadWalkSpeed(1.5F);
		netherrack2 = MBlockHelper.createStoneBlock2(types_netherrack2, "netherrack", 0.4F, 0.67F, 0, tab).setIsNetherrack();
		netherrackStairsRaw = MBlockHelper.createStoneStair(Blocks.netherrack, "netherrack", 0, tab);
		netherrackStairsTiles = MBlockHelper.createStoneStair(netherrack, 3, tab);
		netherQuartz = MBlockHelper.createStoneBlock(types_netherquartz, "netherquartz", 0.8F, 1.33F, 0, tab).setChiseledSided().setRoadWalkSpeed(1.65F);
		netherQuartz2 = MBlockHelper.createStoneBlock2(types_netherquartz_2, "netherquartz", 0.8F, 1.33F, 0, tab);
		netherQuartzStairsBricks = MBlockHelper.createStoneStair(netherQuartz, 1, tab);
		netherQuartzStairsTiles = MBlockHelper.createStoneStair(netherQuartz, 3, tab);
		desertQuartz = MBlockHelper.createStoneBlock(types_desertquartz, "desertquartz", 1.7F, 4.0F, 1, tab).setChiseledSided().setRoadWalkSpeed(1.4F);
		desertQuartz2 = MBlockHelper.createStoneBlock2(types_desertquartz_2, "desertquartz", 1.7F, 4.0F, 1, tab).setRawSlabUnsided();
		desertQuartzStairsRaw = MBlockHelper.createStoneStair(desertQuartz, 0, tab);
		desertQuartzStairsBricks = MBlockHelper.createStoneStair(desertQuartz, 1, tab);
		desertQuartzStairsTiles = MBlockHelper.createStoneStair(desertQuartz, 3, tab);
		radiantQuartz = (MBlockCustom) MBlockHelper.createStoneBlock(types_radiantquartz, "radiant_quartz", 2F, 6.0F, 3, tab).setRoadWalkSpeed(2.0F).setBeaconBase().setLightLevel(0.5F);
		radiantQuartz2 = ((MBlockCustom2) MBlockHelper.createStoneBlock2(types_radiantquartz_2, "radiant_quartz", 2F, 6.0F, 3, tab).setBeaconBase().setLightLevel(0.5F)).setRawSlabUnsided();
		radiantQuartzStairsRaw = MBlockHelper.createStoneStair(radiantQuartz, 0, tab);
		radiantQuartzStairsBricks = MBlockHelper.createStoneStair(radiantQuartz, 1, tab);
		radiantQuartzStairsTiles = MBlockHelper.createStoneStair(radiantQuartz, 3, tab);
		
		clay = MBlockHelper.createStoneBlock(types_clay, "clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		clay2 = MBlockHelper.createStoneBlock2(types_clay_2, "clay", 1.25F, 7.0F, 0, tab);
		clayStairsRaw = MBlockHelper.createStoneStair(Blocks.hardened_clay, "clay", 0, tab);
		clayStairsTiles = MBlockHelper.createStoneStair(clay, 3, tab);
		blackClay = MBlockHelper.createStoneBlock(types_colored_clay, "black_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		blackClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "black_clay", 1.25F, 7.0F, 0, tab);
		blackClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "black_clay", 15, tab);
		blackClayStairsBricks = MBlockHelper.createStoneStair(blackClay, 1, tab);
		blackClayStairsTiles = MBlockHelper.createStoneStair(blackClay, 3, tab);
		blueClay = MBlockHelper.createStoneBlock(types_colored_clay, "blue_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		blueClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "blue_clay", 1.25F, 7.0F, 0, tab);
		blueClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "blue_clay", 11, tab);
		blueClayStairsBricks = MBlockHelper.createStoneStair(blueClay, 1, tab);
		blueClayStairsTiles = MBlockHelper.createStoneStair(blueClay, 3, tab);
		brownClay = MBlockHelper.createStoneBlock(types_colored_clay, "brown_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		brownClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "brown_clay", 1.25F, 7.0F, 0, tab);
		brownClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "brown_clay", 12, tab);
		brownClayStairsBricks = MBlockHelper.createStoneStair(brownClay, 1, tab);
		brownClayStairsTiles = MBlockHelper.createStoneStair(brownClay, 3, tab);
		cyanClay = MBlockHelper.createStoneBlock(types_colored_clay, "cyan_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		cyanClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "cyan_clay", 1.25F, 7.0F, 0, tab);
		cyanClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "cyan_clay", 9, tab);
		cyanClayStairsBricks = MBlockHelper.createStoneStair(cyanClay, 1, tab);
		cyanClayStairsTiles = MBlockHelper.createStoneStair(cyanClay, 3, tab);
		lightBlueClay = MBlockHelper.createStoneBlock(types_colored_clay, "lightblue_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		lightBlueClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "lightblue_clay", 1.25F, 7.0F, 0, tab);
		lightBlueClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "lightblue_clay", 3, tab);
		lightBlueClayStairsBricks = MBlockHelper.createStoneStair(lightBlueClay, 1, tab);
		lightBlueClayStairsTiles = MBlockHelper.createStoneStair(lightBlueClay, 3, tab);
		limeClay = MBlockHelper.createStoneBlock(types_colored_clay, "lime_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		limeClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "lime_clay", 1.25F, 7.0F, 0, tab);
		limeClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "lime_clay", 5, tab);
		limeClayStairsBricks = MBlockHelper.createStoneStair(limeClay, 1, tab);
		limeClayStairsTiles = MBlockHelper.createStoneStair(limeClay, 3, tab);
		magentaClay = MBlockHelper.createStoneBlock(types_colored_clay, "magenta_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		magentaClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "magenta_clay", 1.25F, 7.0F, 0, tab);
		magentaClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "magenta_clay", 2, tab);
		magentaClayStairsBricks = MBlockHelper.createStoneStair(magentaClay, 1, tab);
		magentaClayStairsTiles = MBlockHelper.createStoneStair(magentaClay, 3, tab);
		orangeClay = MBlockHelper.createStoneBlock(types_colored_clay, "orange_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		orangeClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "orange_clay", 1.25F, 7.0F, 0, tab);
		orangeClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "orange_clay", 1, tab);
		orangeClayStairsBricks = MBlockHelper.createStoneStair(orangeClay, 1, tab);
		orangeClayStairsTiles = MBlockHelper.createStoneStair(orangeClay, 3, tab);
		pinkClay = MBlockHelper.createStoneBlock(types_colored_clay, "pink_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		pinkClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "pink_clay", 1.25F, 7.0F, 0, tab);
		pinkClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "pink_clay", 6, tab);
		pinkClayStairsBricks = MBlockHelper.createStoneStair(pinkClay, 1, tab);
		pinkClayStairsTiles = MBlockHelper.createStoneStair(pinkClay, 3, tab);
		purpleClay = MBlockHelper.createStoneBlock(types_colored_clay, "purple_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		purpleClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "purple_clay", 1.25F, 7.0F, 0, tab);
		purpleClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "purple_clay", 10, tab);
		purpleClayStairsBricks = MBlockHelper.createStoneStair(purpleClay, 1, tab);
		purpleClayStairsTiles = MBlockHelper.createStoneStair(purpleClay, 3, tab);
		redClay = MBlockHelper.createStoneBlock(types_colored_clay, "red_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		redClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "red_clay", 1.25F, 7.0F, 0, tab);
		redClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "red_clay", 14, tab);
		redClayStairsBricks = MBlockHelper.createStoneStair(redClay, 1, tab);
		redClayStairsTiles = MBlockHelper.createStoneStair(redClay, 3, tab);
		silverClay = MBlockHelper.createStoneBlock(types_colored_clay, "silver_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		silverClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "silver_clay", 1.25F, 7.0F, 0, tab);
		silverClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "silver_clay", 8, tab);
		silverClayStairsBricks = MBlockHelper.createStoneStair(silverClay, 1, tab);
		silverClayStairsTiles = MBlockHelper.createStoneStair(silverClay, 3, tab);
		whiteClay = MBlockHelper.createStoneBlock(types_colored_clay, "white_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		whiteClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "white_clay", 1.25F, 7.0F, 0, tab);
		whiteClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "white_clay", 0, tab);
		whiteClayStairsBricks = MBlockHelper.createStoneStair(whiteClay, 1, tab);
		whiteClayStairsTiles = MBlockHelper.createStoneStair(whiteClay, 3, tab);
		yellowClay = MBlockHelper.createStoneBlock(types_colored_clay, "yellow_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		yellowClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "yellow_clay", 1.25F, 7.0F, 0, tab);
		yellowClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "yellow_clay", 4, tab);
		yellowClayStairsBricks = MBlockHelper.createStoneStair(yellowClay, 1, tab);
		yellowClayStairsTiles = MBlockHelper.createStoneStair(yellowClay, 3, tab);
		greenClay = MBlockHelper.createStoneBlock(types_colored_clay, "green_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		greenClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "green_clay", 1.25F, 7.0F, 0, tab);
		greenClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "green_clay", 13, tab);
		greenClayStairsBricks = MBlockHelper.createStoneStair(greenClay, 1, tab);
		greenClayStairsTiles = MBlockHelper.createStoneStair(greenClay, 3, tab);
		greyClay = MBlockHelper.createStoneBlock(types_colored_clay, "grey_clay", 1.25F, 7.0F, 0, tab).setIsClay().setRoadWalkSpeed(1.4F);
		greyClay2 = MBlockHelper.createStoneBlock2(types_colored_clay_2, "grey_clay", 1.25F, 7.0F, 0, tab);
		greyClayStairsRaw = MBlockHelper.createStoneStair(Blocks.stained_hardened_clay, "grey_clay", 7, tab);
		greyClayStairsBricks = MBlockHelper.createStoneStair(greyClay, 1, tab);
		greyClayStairsTiles = MBlockHelper.createStoneStair(greyClay, 3, tab);
		
		oak = MBlockHelper.createWoodBlock("oak", 2.0F, 5.0F, tab_decor);
		oak2 = MBlockHelper.createWoodBlock2("oak", 2.0F, 5.0F, tab_decor);
		oakStairsBoards = MBlockHelper.createWoodStair(oak, 1, tab_decor);
		birch = MBlockHelper.createWoodBlock("birch", 2.0F, 5.0F, tab_decor);
		birch2 = MBlockHelper.createWoodBlock2("birch", 2.0F, 5.0F, tab_decor);
		birchStairsBoards = MBlockHelper.createWoodStair(birch, 1, tab_decor);
		spruce = MBlockHelper.createWoodBlock("spruce", 2.0F, 5.0F, tab_decor);
		spruce2 = MBlockHelper.createWoodBlock2("spruce", 2.0F, 5.0F, tab_decor);
		spruceStairsBoards = MBlockHelper.createWoodStair(spruce, 1, tab_decor);
		jungleWood = MBlockHelper.createWoodBlock("jungle", 2.0F, 5.0F, tab_decor);
		jungleWood2 = MBlockHelper.createWoodBlock2("jungle", 2.0F, 5.0F, tab_decor);
		jungleWoodStairsBoards = MBlockHelper.createWoodStair(jungleWood, 1, tab_decor);
		acacia = MBlockHelper.createWoodBlock("acacia", 2.0F, 5.0F, tab_decor);
		acacia2 = MBlockHelper.createWoodBlock2("acacia", 2.0F, 5.0F, tab_decor);
		acaciaStairsBoards = MBlockHelper.createWoodStair(acacia, 1, tab_decor);
		darkOak = MBlockHelper.createWoodBlock("dark_oak", 2.0F, 5.0F, tab_decor);
		darkOak2 = MBlockHelper.createWoodBlock2("dark_oak", 2.0F, 5.0F, tab_decor);
		darkOakStairsBoards = MBlockHelper.createWoodStair(darkOak, 1, tab_decor);
		redwood = MBlockHelper.createWoodBlock(types_redwood, "redwood", 2.0F, 5.0F, tab_decor);
		redwood2 = MBlockHelper.createWoodBlock2(types_redwood_2, "redwood", 2.0F, 5.0F, tab_decor);
		redwoodStairsPlanks = MBlockHelper.createWoodStair(redwood, 0, tab_decor);
		redwoodStairsBoards = MBlockHelper.createWoodStair(redwood, 2, tab_decor);
	}
}
