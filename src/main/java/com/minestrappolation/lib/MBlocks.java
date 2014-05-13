package com.minestrappolation.lib;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation.block.*;
import com.minestrappolation.block.slab.BlockClaySlab;
import com.minestrappolation.block.slab.BlockWoodBoardSlab;
import com.minestrappolation.core.MinestrappolationCore;
import com.minestrappolation.core.block.*;
import com.minestrappolation.core.itemblocks.MCItemBlockMulti;
import com.minestrappolation.core.itemblocks.MCItemBlockSlab;
import com.minestrappolation.core.util.MCAssetManager;
import com.minestrappolation.item.ItemSoulBottle;
import com.minestrappolation.item.ItemSoulGem;
import com.minestrappolation.item.MItemFoiled;
import com.minestrappolation.itemblocks.ItemBlockClaySlab;
import com.minestrappolation.itemblocks.ItemBlockWoodBoardSlab;
import com.minestrappolation.material.MaterialOoze;
import com.minestrappolation.tileentity.TileEntityPlate;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MBlocks
{
	// TODO: ORGANIZE EO BLOCKS.
	
	// Bridged Blocks
	public static Block				glowGlass;
	
	public static Block				meuroditeOre;
	public static Block				meuroditeBlock;
	
	public static Block				UraniumOre;
	
	public static Block				RawUraniumBlock;
	
	public static Block				PlutoniumOre;
	
	public static Block				RawPlutoniumBlock;
	
	public static Block				TitaniumOre;
	
	public static Block				TitaniumBlock;
	
	public static Block				Sunstone;
	
	public static Block				SunstoneOre;
	
	public static Block				ToriteOre;
	
	public static Block				ToriteBlock;
	
	public static Block				Granite;
	public static Block				GraniteBrick;
	
	public static Block				Quartzite;
	public static Block				QuartziteTile;
	
	public static Block				BlaziumOre;
	public static Block				BlaziumBlock;
	
	public static Block				CopperOre;
	public static Block				CopperBlock;
	
	public static Block				CopperBlockTarnished;
	
	public static Block				TinOre;
	
	public static Block				TinBlock;
	
	public static Item				SoulGem;
	public static Block				TinPlate;
	public static Block				BronzePlate;
	public static Block				SteelPlate;
	public static Block				SteelBlock;
	public static Block				SoulOre;
	
	public static Block				SmoothQuartzite;
	public static Block				PillarQuartzite;
	public static Block				ChiseledQuartzite;
	public static Block				SmoothQuartzTile;
	
	public static Block				TinPlatedCobble;
	public static Block				TinPlatedMossy;
	public static Block				TinPlatedStoneBrick;
	public static Block				TinPlatedChiseled;
	public static Block				TinPlatedGranite;
	
	public static Block				BronzeBlock;
	
	public static Block				BronzePlatedCobble;
	public static Block				BronzePlatedMossy;
	public static Block				BronzePlatedStoneBrick;
	public static Block				BronzePlatedChiseled;
	public static Block				BronzePlatedGranite;
	
	public static Block				Invincium;
	
	public static Block				SteelPlatedCobble;
	public static Block				SteelPlatedMossy;
	public static Block				SteelPlatedStoneBrick;
	public static Block				SteelPlatedChiseled;
	public static Block				SteelPlatedGranite;
	
	public static Item				SoulBottle;
	
	public static Block				nuke;
	
	public static Block				SmoothRadiantQuartz;
	public static Block				ChiseledRadiantQuartz;
	public static Block				PillarRadiantQuartz;
	public static Block				RadiantQuartzOre;
	
	public static Item				RadiantQuartz;
	
	public static Block				Godstone;
	
	public static Block				melterIdle;
	public static Block				melterBurning;
	
	public static Block				RadiantQuartzStairs;
	public static BlockSlab			RadiantQuartzSingleSlab;
	public static BlockSlab			RadiantQuartzDoubleSlab;
	
	public static Block				PinkQuartzStairs;
	public static BlockSlab			PinkQuartzSingleSlab;
	public static BlockSlab			PinkQuartzDoubleSlab;
	
	public static Block				graniteBrickStairs;
	public static BlockSlab			graniteBrickSingleSlab;
	public static BlockSlab			graniteBrickDoubleSlab;
	
	public static Block				tinPlatedCobbleStairs;
	public static BlockSlab			tinPlatedCobbleSingleSlab;
	public static BlockSlab			tinPlatedCobbleDoubleSlab;
	
	public static Block				steelPlatedCobbleStairs;
	public static BlockSlab			steelPlatedCobbleSingleSlab;
	public static BlockSlab			steelPlatedCobbleDoubleSlab;
	
	public static Block				bronzePlatedCobbleStairs;
	public static BlockSlab			bronzePlatedCobbleSingleSlab;
	public static BlockSlab			bronzePlatedCobbleDoubleSlab;
	
	public static Block				tinPlatedStoneBrickStairs;
	public static BlockSlab			tinPlatedStoneBrickSingleSlab;
	public static BlockSlab			tinPlatedStoneBrickDoubleSlab;
	
	public static Block				steelPlatedStoneBrickStairs;
	public static BlockSlab			steelPlatedStoneBrickSingleSlab;
	public static BlockSlab			steelPlatedStoneBrickDoubleSlab;
	
	public static Block				bronzePlatedStoneBrickStairs;
	public static BlockSlab			bronzePlatedStoneBrickSingleSlab;
	public static BlockSlab			bronzePlatedStoneBrickDoubleSlab;
	
	public static Block				tinPlatedGraniteBrickStairs;
	public static BlockSlab			tinPlatedGraniteBrickSingleSlab;
	public static BlockSlab			tinPlatedGraniteBrickDoubleSlab;
	
	public static Block				steelPlatedGraniteBrickStairs;
	public static BlockSlab			steelPlatedGraniteBrickSingleSlab;
	public static BlockSlab			steelPlatedGraniteBrickDoubleSlab;
	
	public static Block				bronzePlatedGraniteBrickStairs;
	public static BlockSlab			bronzePlatedGraniteBrickSingleSlab;
	public static BlockSlab			bronzePlatedGraniteBrickDoubleSlab;
	
	public static Block				plutoniumInsulated;
	public static Block				uraniumInsulated;
	
	public static Block				meuroditePlate;
	
	// public static Block magma;
	
	public static Block				soulBlock;
	
	public static Block				doorWoodOverwrite;
	
	// TODO: ORGANIZE ED BLOCKS
	public static final Material	materialOoze	= new MaterialOoze(MapColor.foliageColor);
	
	// bridged blocks
	public static Block				bedrockBrick;
	public static Block				stonePillar;
	public static Block				stoneLamp;
	public static Block				stones;
	
	public static Block				Tiles;
	
	public static Block				Goblet;
	public static Block				Plate;
	
	public static Block				edgeStoneBrick;
	
	public static Block				snowBrick;
	public static Block				endstone;
	
	public static Block				glassRefined;
	public static Block				glassRefinedPane;
	
	public static Block				woodPanel;
	
	public static Block				woodBeveled;
	public static Block				gunpowderBlock;
	
	public static Block				rope;
	public static Block				ropeCoil;
	
	public static Block				oozeSlime;
	
	public static Block				sandstoneBricks;
	public static Block				sandstonePillar;
	
	public static Block				woodBoards;
	
	public static Block				sugarBlock;
	public static Block				meatBlock;
	
	public static Block				magmaOoze;
	
	public static Block				enderBlock;
	
	public static Block				crate;
	public static Block				barrel;
	
	public static Block				cardboard;
	public static Block				cardboardBlock;
	
	public static Block				woodBoardsStairsOak;
	public static Block				woodBoardsStairsBirch;
	public static Block				woodBoardsStairsSpruce;
	public static Block				woodBoardsStairsJungle;
	public static BlockSlab			woodBoardsSingleSlab;
	public static BlockSlab			woodBoardsDoubleSlab;
	
	public static Block				checkerTileStairs;
	
	public static Block				stainedBrick;
	
	public static Block				cobbledRoad;
	public static Block				infertileDirt;
	public static Block				refinedRoad;
	
	public static Block				sandyRoad;
	public static Block				sandstoneRoad;
	public static Block				gravelRoad;
	public static Block				netherroad;
	public static Block				refinedNetherroad;
	
	public static Block				woodPlanksMossy;
	
	public static Block				GlassDoor;
	
	public static Block				bedrockBlocks;
	public static Block				bedrockLamps;
	public static Block				bedrockPillars;
	public static Block				bedrockRoads;
	public static MCBlockMultiSlab	bedrockSlabsSingle;
	public static MCBlockMultiSlab	bedrockSlabsDouble;
	
	public static Block				clayBricks;
	public static Block				refinedClay;
	public static Block				clayPatternedBricks;
	public static Block				clayTiles;
	public static Block				clayPillars;
	public static Block				clayPillars2;
	public static Block				clayPillars3;
	public static Block				clayPillars4;
	public static Block				clayRoads;
	public static Block				clayChiseled;
	public static MCBlockMultiSlab	claySlabsSingle1;
	public static MCBlockMultiSlab	claySlabsSingle2;
	public static MCBlockMultiSlab	claySlabsSingle3;
	public static MCBlockMultiSlab	claySlabsSingle4;
	public static MCBlockMultiSlab	claySlabsDouble1;
	public static MCBlockMultiSlab	claySlabsDouble2;
	public static MCBlockMultiSlab	claySlabsDouble3;
	public static MCBlockMultiSlab	claySlabsDouble4;
	public static MCBlockMultiSlab	refinedClaySlabsSingle1;
	public static MCBlockMultiSlab	refinedClaySlabsSingle2;
	public static MCBlockMultiSlab	refinedClaySlabsSingle3;
	public static MCBlockMultiSlab	refinedClaySlabsSingle4;
	public static MCBlockMultiSlab	refinedClaySlabsDouble1;
	public static MCBlockMultiSlab	refinedClaySlabsDouble2;
	public static MCBlockMultiSlab	refinedClaySlabsDouble3;
	public static MCBlockMultiSlab	refinedClaySlabsDouble4;
	
	public static Block				endstoneBlocks;
	public static Block				endstonePillars;
	public static Block				endstoneRoads;
	public static Block				endstoneChiseled;
	public static MCBlockMultiSlab	endstoneSlabSingle;
	public static MCBlockMultiSlab	endstoneSlabDouble;
	
	public static Block				flintBlocks;
	public static Block				flintLamps;
	public static Block				flintPillars;
	public static Block				flintRoads;
	public static MCBlockMultiSlab	flintSlabSingle;
	public static MCBlockMultiSlab	flintSlabDouble;
	
	public static Block				graniteBlocks;
	public static Block				granitePillars;
	public static Block				granitePillars2;
	public static Block				graniteRoads;
	public static Block				graniteRoads2;
	public static MCBlockMultiSlab	graniteSlabSingle;
	public static MCBlockMultiSlab	graniteSlabDouble;
	public static MCBlockMultiSlab	graniteSlabSingle2;
	public static MCBlockMultiSlab	graniteSlabDouble2;
	
	public static Block				lapisBlocks;
	public static Block				lapisPillars;
	public static Block				lapisRoads;
	public static Block				lapisChiseled;
	public static MCBlockMultiSlab	lapisSlabSingle;
	public static MCBlockMultiSlab	lapisSlabDouble;
	
	public static Block				netherQuartzBlocks;
	public static Block				netherQuartzPillars;
	public static Block				netherQuartzRoads;
	public static Block				netherQuartzChiseled;
	public static MCBlockMultiSlab	netherQuartzSlabSingle;
	public static MCBlockMultiSlab	netherQuartzSlabDouble;
	
	public static Block				netherrackBlocks;
	public static Block				netherrackPillars;
	public static Block				netherrackRoads;
	public static MCBlockMultiSlab	netherrackSlabSingle;
	public static MCBlockMultiSlab	netherrackSlabDouble;
	
	public static Block				obsidianBlocks;
	public static Block				obsidianLamps;
	public static Block				obsidianPillars;
	public static Block				obsidianRoads;
	public static MCBlockMultiSlab	obsidianSlabSingle;
	public static MCBlockMultiSlab	obsidianSlabDouble;
	
	public static Block				redSandstoneBlocks;
	public static Block				redSandstonePillars;
	public static Block				redSandstoneRoads;
	public static MCBlockMultiSlab	redSandstoneSlabSingle;
	public static MCBlockMultiSlab	redSandstoneSlabDouble;
	
	public static void init()
	{
		meuroditeOre = new EOBlock(Material.rock).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("oreMeurodite").setBlockTextureName(MCAssetManager.getTexture("oreMeurodite"));
		GameRegistry.registerBlock(meuroditeOre, "oreMeurodite");
		meuroditeBlock = new EOBlock(Material.iron).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("blockMeurodite").setBlockTextureName(MCAssetManager.getTexture("blockMeurodite"));
		GameRegistry.registerBlock(meuroditeBlock, "blockMeurodite");
		UraniumOre = new BlockUraniumOre(Material.rock).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreUranium").setBlockTextureName(MCAssetManager.getTexture("oreUranium"));
		GameRegistry.registerBlock(UraniumOre, "oreUranium");
		RawUraniumBlock = new BlockUraniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockUranium").setBlockTextureName(MCAssetManager.getTexture("blockUranium"));
		GameRegistry.registerBlock(RawUraniumBlock, "blockUraniumRaw");
		PlutoniumOre = new BlockPlutoniumOre(Material.rock).setHardness(5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("orePlutonium").setBlockTextureName(MCAssetManager.getTexture("orePlutonium")).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		GameRegistry.registerBlock(PlutoniumOre, "orePlutonium");
		RawPlutoniumBlock = new BlockPlutoniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockPlutonium").setBlockTextureName(MCAssetManager.getTexture("blockPlutonium"));
		GameRegistry.registerBlock(RawPlutoniumBlock, "blockPlutoniumRaw");
		TitaniumOre = new EOBlock(Material.rock).setHardness(10F).setResistance(15F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTitanium").setBlockTextureName(MCAssetManager.getTexture("oreTitanium"));
		GameRegistry.registerBlock(TitaniumOre, "oreTitanium");
		TitaniumBlock = new EOBlock(Material.iron).setHardness(10F).setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTitanium").setBlockTextureName(MCAssetManager.getTexture("blockTitanium"));
		GameRegistry.registerBlock(TitaniumBlock, "blockTitanium");
		Sunstone = new BlockSunstone(Material.glass).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(1.0F).setBlockName("blockSunstone").setBlockTextureName(MCAssetManager.getTexture("blockSunstone"));
		GameRegistry.registerBlock(Sunstone, "blockSunstone");
		SunstoneOre = new BlockSunstoneOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreSunstone").setBlockTextureName(MCAssetManager.getTexture("oreSunstone")).setLightLevel(1F);
		GameRegistry.registerBlock(SunstoneOre, "oreSunstone");
		
		ToriteOre = new EOBlock(Material.rock).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreTorite").setBlockTextureName(MCAssetManager.getTexture("oreTorite"));
		GameRegistry.registerBlock(ToriteOre, "oreTorite");
		ToriteBlock = new EOBlock(Material.iron).setHardness(6F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTorite").setBlockTextureName(MCAssetManager.getTexture("blockTorite"));
		GameRegistry.registerBlock(ToriteBlock, "blockTorite");
		Granite = new EOBlock(Material.rock).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("graniteRaw").setBlockTextureName(MCAssetManager.getSCTexture("Granite_Raw_0_0"));
		GameRegistry.registerBlock(Granite, "granite");
		GraniteBrick = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("graniteBricks").setBlockTextureName(MCAssetManager.getSCTexture("Granite_Bricks_0_0"));
		GameRegistry.registerBlock(GraniteBrick, "brickGranite");
		Quartzite = new EOBlock(Material.rock).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzRaw").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_Raw_0_0"));
		GameRegistry.registerBlock(Quartzite, "quartzDesert");
		QuartziteTile = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzTilesRaw").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_TilesRaw_0_0"));
		GameRegistry.registerBlock(QuartziteTile, "quartzDesertTile");
		SmoothQuartzite = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzRefined").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_Refined_0_0"));
		GameRegistry.registerBlock(SmoothQuartzite, "quartzDesertSmooth");
		PillarQuartzite = new BlockDesertQuartzPillar().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzPillar").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_Pillar_Side_0"));
		GameRegistry.registerBlock(PillarQuartzite, "quartzDesertPillar");
		ChiseledQuartzite = new BlockDesertQuartzChiseled().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzChiseled").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_Chiseled_Side_0"));
		GameRegistry.registerBlock(ChiseledQuartzite, "quartzDesertChiseled");
		SmoothQuartzTile = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("desertQuartzTilesRefined").setBlockTextureName(MCAssetManager.getSCTexture("DesertQuartz_TilesRefined_0_0"));
		GameRegistry.registerBlock(SmoothQuartzTile, "quartzDesertSmoothTile");
		
		BlaziumOre = new BlockBlaziumOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreBlazium").setBlockTextureName(MCAssetManager.getTexture("oreBlazium")).setLightLevel(0.5F);
		GameRegistry.registerBlock(BlaziumOre, "oreBlazium");
		BlaziumBlock = new BlockBlazium().setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("blockBlazium").setBlockTextureName(MCAssetManager.getTexture("blockBlazium")).setLightLevel(0.7F);
		GameRegistry.registerBlock(BlaziumBlock, "blockBlazium");
		
		CopperOre = new EOBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreCopper").setBlockTextureName(MCAssetManager.getTexture("oreCopper"));
		GameRegistry.registerBlock(CopperOre, "oreCopper");
		CopperBlock = new BlockCopper(Material.iron).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper").setBlockTextureName(MCAssetManager.getTexture("blockCopper"));
		GameRegistry.registerBlock(CopperBlock, "blockCopper");
		CopperBlockTarnished = new BlockCopperTarnished().setHardness(6F).setResistance(12F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopperTarnished").setBlockTextureName(MCAssetManager.getTexture("blockCopperTarnishedTop"));
		GameRegistry.registerBlock(CopperBlockTarnished, "blockCopperTarnished");
		TinOre = new EOBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTin").setBlockTextureName(MCAssetManager.getTexture("oreTin"));
		GameRegistry.registerBlock(TinOre, "oreTin");
		TinBlock = new EOBlock(Material.iron).setHardness(3F).setResistance(2F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTin").setBlockTextureName(MCAssetManager.getTexture("blockTin"));
		GameRegistry.registerBlock(TinBlock, "blockTin");
		TinPlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingTin").setBlockTextureName(MCAssetManager.getTexture("blockTin"));
		GameRegistry.registerBlock(TinPlate, "plateTin");
		BronzePlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingBronze").setBlockTextureName(MCAssetManager.getTexture("blockBronze"));
		GameRegistry.registerBlock(BronzePlate, "plateBronze");
		SteelPlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingSteel").setBlockTextureName(MCAssetManager.getTexture("blockSteelTop"));
		GameRegistry.registerBlock(SteelPlate, "plateSteel");
		meuroditePlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingMeurodite").setBlockTextureName(MCAssetManager.getTexture("blockMeurodite"));
		GameRegistry.registerBlock(meuroditePlate, "plateMeurodite");
		SteelBlock = new BlockSteel().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("blockSteel").setBlockTextureName(MCAssetManager.getTexture("blockSteelTop"));
		GameRegistry.registerBlock(SteelBlock, "blockSteel");
		SoulOre = new BlockSoulOre().setHardness(2F).setResistance(3F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreSoulGem").setBlockTextureName(MCAssetManager.getTexture("oreSoulGem"));
		GameRegistry.registerBlock(SoulOre, "oreSoul");
		SoulGem = new ItemSoulGem().setCreativeTab(Minestrappolation.tabMaterials).setUnlocalizedName("item_SoulGem").setTextureName(MCAssetManager.getTexture("gemSoulGem"));
		GameRegistry.registerItem(SoulGem, "gemSoul");
		TinPlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledTin").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Cobbled_0_Tin"));
		GameRegistry.registerBlock(TinPlatedCobble, "cobbleTin");
		TinPlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledMossyTin").setBlockTextureName(MCAssetManager.getSCTexture("Stone_CobbledMossy_0_Tin"));
		GameRegistry.registerBlock(TinPlatedMossy, "cobbleMossyTin");
		TinPlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneBricksTin").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Bricks_0_Tin"));
		GameRegistry.registerBlock(TinPlatedStoneBrick, "stoneBrickTin");
		TinPlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneChiseledTin").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Chiseled_0_Tin"));
		GameRegistry.registerBlock(TinPlatedChiseled, "stoneBrickChiseledTin");
		TinPlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(10.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("graniteBricksTin").setBlockTextureName(MCAssetManager.getSCTexture("Granite_Bricks_0_Tin"));
		GameRegistry.registerBlock(TinPlatedGranite, "graniteTin");
		BronzeBlock = new EOBlock(Material.iron).setHardness(7F).setResistance(20F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Bronze").setBlockTextureName(MCAssetManager.getTexture("blockBronze"));
		GameRegistry.registerBlock(BronzeBlock, "blockBronze");
		BronzePlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(30.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeCobble").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Cobbled_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedCobble, "cobbleBronze");
		BronzePlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(30.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeMossy").setBlockTextureName(MCAssetManager.getSCTexture("Stone_CobbledMossy_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedMossy, "cobbleMossyBronze");
		BronzePlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(30.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeStoneBrick").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Bricks_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedStoneBrick, "stoneBrickBronze");
		BronzePlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(30.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeChiseled").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Chiseled_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedChiseled, "stoneBrickChiseledBronze");
		BronzePlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(30.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeGraniteBrick").setBlockTextureName(MCAssetManager.getSCTexture("Granite_Bricks_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedGranite, "graniteBronze");
		Invincium = new BlockInvincium(Material.rock).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Invincium").setBlockTextureName(MCAssetManager.getTexture("invincium"));
		GameRegistry.registerBlock(Invincium, "invincium");
		SteelPlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(20.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelCobble").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Cobbled_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedCobble, "cobbleSteel");
		SteelPlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(20.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelMossy").setBlockTextureName(MCAssetManager.getSCTexture("Stone_CobbledMossy_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedMossy, "cobbleMossySteel");
		SteelPlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(20.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelStoneBrick").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Bricks_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedStoneBrick, "stoneBrickSteel");
		SteelPlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(20.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelChiseled").setBlockTextureName(MCAssetManager.getSCTexture("Stone_Chiseled_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedChiseled, "stoneBrickChiseledSteel");
		SteelPlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(20.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelGraniteBrick").setBlockTextureName(MCAssetManager.getSCTexture("Granite_Bricks_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedGranite, "graniteSteel");
		SoulBottle = new ItemSoulBottle().setCreativeTab(Minestrappolation.tabMaterials).setUnlocalizedName("SoulBottle").setTextureName(MCAssetManager.getTexture("utilitySoulBottle"));
		GameRegistry.registerItem(SoulBottle, "soulBottle");
		nuke = new BlockNuke().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("nuke");
		GameRegistry.registerBlock(nuke, "nuke");
		SmoothRadiantQuartz = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(0.5F).setBlockName("block_SmoothRadiantQuartz").setBlockTextureName(MCAssetManager.getSCTexture("RadiantQuartz_Raw_0_0"));
		GameRegistry.registerBlock(SmoothRadiantQuartz, "quartzRadiantSmooth");
		ChiseledRadiantQuartz = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(0.5F).setBlockName("block_ChiseledRadiantQuartz").setBlockTextureName(MCAssetManager.getSCTexture("RadiantQuartz_Chiseled_0_0"));
		GameRegistry.registerBlock(ChiseledRadiantQuartz, "quartzRadiantChiseled");
		PillarRadiantQuartz = new BlockRadiantPillar().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(0.5F).setBlockName("PillarRadiantQuartz");
		GameRegistry.registerBlock(PillarRadiantQuartz, "quartzRadiantPillar");
		RadiantQuartzOre = new EOBlock(Material.rock).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(0.4F).setBlockName("block_RadiantQuartzOre").setBlockTextureName(MCAssetManager.getTexture("oreRadiantQuartz"));
		GameRegistry.registerBlock(RadiantQuartzOre, "oreQuartzRadiant");
		RadiantQuartz = new MItemFoiled().setCreativeTab(Minestrappolation.tabMaterials).setUnlocalizedName("item_RadiantQuartz").setTextureName(MCAssetManager.getTexture("gemRadiantQuartz"));
		GameRegistry.registerItem(RadiantQuartz, "quartzRadiant");
		Godstone = new BlockGodstone(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setLightLevel(1F).setBlockName("Godstone").setBlockTextureName(MCAssetManager.getTexture("godstone"));
		GameRegistry.registerBlock(Godstone, "godstone");
		melterIdle = new BlockMelter(false).setHardness(6F).setResistance(8.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("melter");
		GameRegistry.registerBlock(melterIdle, "melterIdle");
		melterBurning = new BlockMelter(true).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setBlockName("melter").setLightLevel(1F);
		GameRegistry.registerBlock(melterBurning, "melterBurning");
		
		/*
		 * RadiantQuartzStairs = new EOBlockStairs(SmoothRadiantQuartz,
		 * 0).setLightLevel(0.5F).setBlockName("RadiantQuartzStairs");
		 * GameRegistry.registerBlock(RadiantQuartzStairs,
		 * "quartzRadiantStairs"); RadiantQuartzSingleSlab = (BlockSlab) new
		 * RadiantQuartzSlab
		 * (false).setLightLevel(0.5F).setBlockName("RadiantQuartzSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * RadiantQuartzDoubleSlab = (BlockSlab) new
		 * RadiantQuartzSlab(true).setLightLevel(0.5F).setBlockName
		 * ("RadiantQuartzDoubleSlab"); registerBlock(RadiantQuartzSingleSlab,
		 * MItemslab.class, (BlockSlab)RadiantQuartzSingleSlab,
		 * (BlockSlab)RadiantQuartzDoubleSlab);
		 * registerBlock(RadiantQuartzDoubleSlab, MItemslab.class,
		 * (BlockSlab)RadiantQuartzSingleSlab,
		 * (BlockSlab)RadiantQuartzDoubleSlab); PinkQuartzStairs = new
		 * EOBlockStairs(SmoothQuartzite, 0).setBlockName("PinkQuartzStairs");
		 * GameRegistry.registerBlock(PinkQuartzStairs, "quartzDesertStairs");
		 * PinkQuartzSingleSlab = (BlockSlab) new
		 * PinkQuartzSlab(false).setBlockName
		 * ("PinkQuartzSingleSlab").setCreativeTab
		 * (Minestrappolation.tabBuildingBlocks); PinkQuartzDoubleSlab =
		 * (BlockSlab) new
		 * PinkQuartzSlab(true).setBlockName("PinkQuartzDoubleSlab");
		 * registerBlock(PinkQuartzSingleSlab, MItemslab.class,
		 * (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab);
		 * registerBlock(PinkQuartzDoubleSlab, MItemslab.class,
		 * (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab);
		 * graniteBrickStairs = new EOBlockStairs(GraniteBrick,
		 * 0).setBlockName("graniteBrickStairs");
		 * GameRegistry.registerBlock(graniteBrickStairs,"graniteBrickStairs");
		 * graniteBrickSingleSlab = (BlockSlab) new
		 * GraniteBrickSlab(false).setBlockName
		 * ("graniteBrickSingleSlab").setCreativeTab
		 * (Minestrappolation.tabBuildingBlocks); graniteBrickDoubleSlab =
		 * (BlockSlab) new
		 * GraniteBrickSlab(true).setBlockName("graniteBrickDoubleSlab");
		 * registerBlock(graniteBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)graniteBrickSingleSlab,
		 * (BlockSlab)graniteBrickDoubleSlab);
		 * registerBlock(graniteBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)graniteBrickSingleSlab,
		 * (BlockSlab)graniteBrickDoubleSlab); tinPlatedCobbleStairs = new
		 * EOBlockStairs(TinPlatedCobble,
		 * 0).setBlockName("tinPlatedCobbleStairs");
		 * GameRegistry.registerBlock(tinPlatedCobbleStairs,"cobbleStairsTin");
		 * tinPlatedCobbleSingleSlab = (BlockSlab) new
		 * TinPlatedCobbleSlab(false)
		 * .setBlockName("tinPlatedCobbleSingleSlab").setCreativeTab
		 * (Minestrappolation.tabBuildingBlocks); tinPlatedCobbleDoubleSlab =
		 * (BlockSlab) new
		 * TinPlatedCobbleSlab(true).setBlockName("tinPlatedCobbleDoubleSlab");
		 * registerBlock(tinPlatedCobbleSingleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedCobbleSingleSlab,
		 * (BlockSlab)tinPlatedCobbleDoubleSlab);
		 * registerBlock(tinPlatedCobbleDoubleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedCobbleSingleSlab,
		 * (BlockSlab)tinPlatedCobbleDoubleSlab); steelPlatedCobbleStairs = new
		 * EOBlockStairs(SteelPlatedCobble,
		 * 0).setBlockName("steelPlatedCobbleStairs");
		 * GameRegistry.registerBlock(steelPlatedCobbleStairs,
		 * "stairsCobbleSteel"); steelPlatedCobbleSingleSlab = (BlockSlab) new
		 * SteelPlatedCobbleSlab
		 * (false).setBlockName("steelPlatedCobbleSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * steelPlatedCobbleDoubleSlab = (BlockSlab) new
		 * SteelPlatedCobbleSlab(true
		 * ).setBlockName("steelPlatedCobbleDoubleSlab" );
		 * registerBlock(steelPlatedCobbleSingleSlab, MItemslab.class,
		 * (BlockSlab)steelPlatedCobbleSingleSlab,
		 * (BlockSlab)steelPlatedCobbleDoubleSlab);
		 * registerBlock(steelPlatedCobbleDoubleSlab,
		 * MItemslab.class,(BlockSlab) steelPlatedCobbleSingleSlab,
		 * (BlockSlab)steelPlatedCobbleDoubleSlab); bronzePlatedCobbleStairs =
		 * new EOBlockStairs(BronzePlatedCobble,
		 * 0).setBlockName("bronzePlatedCobbleStairs");
		 * GameRegistry.registerBlock(bronzePlatedCobbleStairs,
		 * "cobbleStairsBronze"); bronzePlatedCobbleSingleSlab = (BlockSlab) new
		 * BronzePlatedCobbleSlab
		 * (false).setBlockName("bronzePlatedCobbleSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * bronzePlatedCobbleDoubleSlab = (BlockSlab) new
		 * BronzePlatedCobbleSlab(
		 * true).setBlockName("bronzePlatedCobbleDoubleSlab" );
		 * registerBlock(bronzePlatedCobbleSingleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedCobbleSingleSlab,
		 * (BlockSlab)bronzePlatedCobbleDoubleSlab);
		 * registerBlock(bronzePlatedCobbleDoubleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedCobbleSingleSlab,
		 * (BlockSlab)bronzePlatedCobbleDoubleSlab); tinPlatedStoneBrickStairs =
		 * new EOBlockStairs(TinPlatedStoneBrick,
		 * 0).setBlockName("tinPlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(tinPlatedStoneBrickStairs,
		 * "stoneBrickStairsTin"); tinPlatedStoneBrickSingleSlab = (BlockSlab)
		 * new TinPlatedStoneBrickSlab(false).setBlockName(
		 * "tinPlatedStoneBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * tinPlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * TinPlatedStoneBrickSlab
		 * (true).setBlockName("tinPlatedStoneBrickDoubleSlab");
		 * registerBlock(tinPlatedStoneBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedStoneBrickSingleSlab,
		 * (BlockSlab)tinPlatedStoneBrickDoubleSlab);
		 * registerBlock(tinPlatedStoneBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedStoneBrickSingleSlab,
		 * (BlockSlab)tinPlatedStoneBrickDoubleSlab);
		 * steelPlatedStoneBrickStairs = new
		 * EOBlockStairs(SteelPlatedStoneBrick,
		 * 0).setBlockName("steelPlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(steelPlatedStoneBrickStairs,
		 * "stoneBrickStairsSteel"); steelPlatedStoneBrickSingleSlab =
		 * (BlockSlab) new SteelPlatedStoneBrickSlab(false).setBlockName(
		 * "steelPlatedStoneBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * steelPlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * SteelPlatedStoneBrickSlab
		 * (true).setBlockName("steelPlatedStoneBrickDoubleSlab");
		 * registerBlock(steelPlatedStoneBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)steelPlatedStoneBrickSingleSlab,
		 * (BlockSlab)steelPlatedStoneBrickDoubleSlab);
		 * registerBlock(steelPlatedStoneBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)steelPlatedStoneBrickSingleSlab,
		 * (BlockSlab)steelPlatedStoneBrickDoubleSlab);
		 * bronzePlatedStoneBrickStairs = new
		 * EOBlockStairs(BronzePlatedStoneBrick,
		 * 0).setBlockName("bronzePlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(bronzePlatedStoneBrickStairs,
		 * "stoneBrickStairsBronze"); bronzePlatedStoneBrickSingleSlab =
		 * (BlockSlab) new BronzePlatedStoneBrickSlab(false).setBlockName(
		 * "bronzePlatedStoneBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * bronzePlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * BronzePlatedStoneBrickSlab
		 * (true).setBlockName("bronzePlatedStoneBrickDoubleSlab");
		 * registerBlock(bronzePlatedStoneBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedStoneBrickSingleSlab,
		 * (BlockSlab)bronzePlatedStoneBrickDoubleSlab);
		 * registerBlock(bronzePlatedStoneBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedStoneBrickSingleSlab,
		 * (BlockSlab)bronzePlatedStoneBrickDoubleSlab);
		 * tinPlatedGraniteBrickStairs = new EOBlockStairs(TinPlatedGranite,
		 * 0).setBlockName("tinPlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(tinPlatedGraniteBrickStairs,
		 * "graniteStairsTin"); tinPlatedGraniteBrickSingleSlab = (BlockSlab)
		 * new TinPlatedGraniteBrickSlab(false).setBlockName(
		 * "tinPlatedGraniteBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * tinPlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * TinPlatedGraniteBrickSlab
		 * (true).setBlockName("tinPlatedGraniteBrickDoubleSlab");
		 * registerBlock(tinPlatedGraniteBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)tinPlatedGraniteBrickDoubleSlab);
		 * registerBlock(tinPlatedGraniteBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)tinPlatedGraniteBrickSingleSlab,(BlockSlab)
		 * tinPlatedGraniteBrickDoubleSlab); steelPlatedGraniteBrickStairs = new
		 * EOBlockStairs(SteelPlatedGranite,
		 * 0).setBlockName("steelPlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(steelPlatedGraniteBrickStairs,
		 * "graniteBrickStairsSteel"); steelPlatedGraniteBrickSingleSlab =
		 * (BlockSlab) new SteelPlatedGraniteBrickSlab(false).setBlockName(
		 * "steelPlatedGraniteBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * steelPlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * SteelPlatedGraniteBrickSlab
		 * (true).setBlockName("steelPlatedGraniteBrickDoubleSlab");
		 * registerBlock(steelPlatedGraniteBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)steelPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)steelPlatedGraniteBrickDoubleSlab);
		 * registerBlock(steelPlatedGraniteBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)steelPlatedGraniteBrickSingleSlab,(BlockSlab)
		 * steelPlatedGraniteBrickDoubleSlab); bronzePlatedGraniteBrickStairs =
		 * new EOBlockStairs(BronzePlatedGranite,
		 * 0).setBlockName("bronzePlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(bronzePlatedGraniteBrickStairs,
		 * "graniteBrickStairsBronze"); bronzePlatedGraniteBrickSingleSlab =
		 * (BlockSlab) new BronzePlatedGraniteBrickSlab(false).setBlockName(
		 * "bronzePlatedGraniteBrickSingleSlab"
		 * ).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		 * bronzePlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * BronzePlatedGraniteBrickSlab
		 * (true).setBlockName("bronzePlatedGraniteBrickDoubleSlab");
		 * registerBlock(bronzePlatedGraniteBrickSingleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedGraniteBrickSingleSlab,
		 * (BlockSlab)bronzePlatedGraniteBrickDoubleSlab);
		 * registerBlock(bronzePlatedGraniteBrickDoubleSlab, MItemslab.class,
		 * (BlockSlab)bronzePlatedGraniteBrickSingleSlab,
		 * (BlockSlab)bronzePlatedGraniteBrickDoubleSlab);
		 */
		
		plutoniumInsulated = new BlockPlutoniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal).setBlockName("plutoniumInsulated");
		GameRegistry.registerBlock(plutoniumInsulated, "plutoniumInsulated");
		uraniumInsulated = new BlockUraniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal).setBlockName("uraniumInsulated");
		GameRegistry.registerBlock(uraniumInsulated, "uraniumInsulated");
		// magma = new
		// BlockMagma(EOConfig.magmaId).setHardness(100.0F).setLightOpacity(3).setBlockName("magma").setLightLevel(1F);
		
		soulBlock = new BlockSoulBlock().setBlockName("block_SoulBlock").setHardness(65F).setResistance(30F).setLightLevel(1F).setBlockTextureName(MCAssetManager.getTexture("blockSoulGem"));
		GameRegistry.registerBlock(soulBlock, "blockSoul");
		
		glowGlass = new BlockGlowGlass(Material.glass, true).setBlockName("block_GlowGlass").setLightLevel(0.7F).setStepSound(Block.soundTypeGlass).setHardness(.8F);
		GameRegistry.registerBlock(glowGlass, "block_GlowGlass");
		
		// TODO: ORGANIZE ED BLOCKS
		
		stonePillar = new MCBlockPillar(MCAssetManager.getSCTexture("Stone_Pillar_Side_0"), MCAssetManager.getSCTexture("Stone_Pillar_Top_0")).setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stonePillar");
		stoneLamp = new BlockStoneLamp().setHardness(1.5F).setResistance(8F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setBlockName("stoneLamp");
		stones = new BlockStones().setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stones");
		
		Tiles = new BlockTiles().setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("tiles");
		
		edgeStoneBrick = new BlockEdgeStoneBrick().setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrick");
		
		snowBrick = new BlockSnowBrick().setHardness(0.3F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeSnow).setBlockName("tilesSnow").setBlockTextureName(MCAssetManager.getTexture("tilesSnow"));
		
		endstone = new BlockEndStone().setHardness(3.0F).setResistance(15.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("Endstone");
		
		glassRefined = new BlockGlassRefined(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("glassRefined");
		glassRefinedPane = new EDBlockPane("ClearGlass", "clearGlassPaneEdge", Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("glassRefinedPane");
		gunpowderBlock = new BlockGunpowderBlock(Material.ground).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("GunpowderBlock").setBlockTextureName(MCAssetManager.getTexture("blockGunpowder"));
		
		rope = new BlockRope().setHardness(0.9F).setStepSound(Block.soundTypeCloth).setBlockName("rope");
		ropeCoil = new BlockRopeCoil().setHardness(0.9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeCloth).setBlockName("ropeCoil");
		
		oozeSlime = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("SlimeOoze").setBlockTextureName(MCAssetManager.getTexture("oozeSlime"));
		
		woodPanel = new BlockWoodPanel().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPanel");
		
		woodBeveled = new BlockWoodBeveled().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodBeveled");
		
		sandstoneBricks = new BlockSandstoneBrick().setHardness(1F).setStepSound(Block.soundTypeStone).setBlockName("sandstoneBrick");
		sandstonePillar = new MCBlockPillar(MCAssetManager.getSCTexture("Sandstone_Pillar_Side_0"), MCAssetManager.getSCTexture("Sandstone_Pillar_Top_0")).setBlockName("sandstonePillar").setHardness(1F).setStepSound(Block.soundTypeStone);
		
		woodBoards = new BlockWoodBoards().setHardness(2.0F).setResistance(5.0F).setBlockName("woodBoards").setStepSound(Block.soundTypeWood);
		// TODO add the rest of the boards after Extrapolated Enviroments
		
		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("SugarBlock").setBlockTextureName(MCAssetManager.getTexture("blockSugar"));
		meatBlock = new BlockMeatBlock().setHardness(0.8F).setStepSound(Block.soundTypeCloth).setBlockName("MeatBlock").setBlockTextureName(MCAssetManager.getTexture("blockRawMeat"));
		
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("MagmaOoze").setBlockTextureName(MCAssetManager.getTexture("oozeMagma"));
		
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setBlockName("EnderBlock").setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getTexture("blockEnderPearl"));
		
		crate = new BlockCrate().setHardness(2.5F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("crate");
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("barrel");
		
		cardboard = new EDBlockPane("cardboard", "cardboardPaneEdge", Material.cloth, true).setHardness(0.3F).setBlockName("cardboard");
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setBlockName("CardboardBlock").setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodBoardsStairsOak = new EDBlockStairs(woodBoards, 0).setBlockName("woodBoardsStairsOak").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsBirch = new EDBlockStairs(woodBoards, 1).setBlockName("woodBoardsStairsBirch").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsSpruce = new EDBlockStairs(woodBoards, 2).setBlockName("woodBoardsStairsSpruce").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsJungle = new EDBlockStairs(woodBoards, 3).setBlockName("woodBoardsStairsJungle").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodBoardsSingleSlab = (BlockSlab) new BlockWoodBoardSlab(false).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		woodBoardsDoubleSlab = (BlockSlab) new BlockWoodBoardSlab(true).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		
		checkerTileStairs = new EDBlockStairs(Tiles, 3).setBlockName("checkerTileStairs").setHardness(3F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		stainedBrick = new BlockStainedBrick().setHardness(2F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("stainedBrick");
		
		cobbledRoad = new EDBlockRoad().setHardness(1).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("cobbledRoad");
		infertileDirt = new MCBlock(Material.grass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("InfertileSoil").setHardness(.4F).setStepSound(Block.soundTypeGrass).setBlockTextureName(MCAssetManager.getTexture("grasslessDirt"));
		refinedRoad = new EDBlockRoad().setHardness(2F).setResistance(5F).setBlockName("RefinedRoad").setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		sandyRoad = new EDBlockRoad().setHardness(0.8F).setResistance(4F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandyRoad");
		sandstoneRoad = new EDBlockRoad().setHardness(1).setResistance(4.5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandstoneRoad");
		gravelRoad = new EDBlockRoad().setHardness(1.5F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("gravelRoad");
		netherroad = new EDBlockRoad().setHardness(2.2F).setResistance(4F).setBlockName("netherroad").setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		refinedNetherroad = new EDBlockRoad().setHardness(2.8F).setResistance(6F).setBlockName("refinedNetherroad").setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodPlanksMossy = new BlockMossyWood().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPlanksMossy").setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		Goblet = new BlockGoblet(Material.rock).setHardness(.5F).setBlockName("goblet");
		Plate = new BlockPlate(Material.rock).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("plate");
		
		GlassDoor = new BlockGlassDoor(Material.glass).setHardness(1F).setBlockName("doorGlass");
		
		bedrockBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Bedrock_Bricks_0_0"), MCAssetManager.getSCTexture("Bedrock_PatternBricks_0_0"), MCAssetManager.getSCTexture("Bedrock_Refined_0_0"), MCAssetManager.getSCTexture("Bedrock_Tiles_0_0") }).setBlockName("bedrockBlocks").setHardness(40F).setResistance(400F);
		bedrockLamps = new MCBlockMultiLamp(Material.rock, new String[] { MCAssetManager.getSCTexture("Bedrock_LampGlowstone_0_0"), MCAssetManager.getSCTexture("Bedrock_LampSunstone_0_0") }).setBlockName("bedrockLamps").setHardness(40F).setResistance(400F);
		bedrockPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Bedrock_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Bedrock_Pillar_Top_0") }).setBlockName("bedrockPillars").setHardness(40F).setResistance(400F);
		bedrockRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Bedrock_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Bedrock_PatternBricks_0_0") }, new String[] { MCAssetManager.getTexture("grasslessDirt") }).setBlockName("bedrockRoad").setHardness(40F).setResistance(400F);
		bedrockSlabsSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Bedrock_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Bedrock_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Bedrock_Refined_0_0"), MCAssetManager.getSCTexture("Bedrock_RawSlab_Top_0") }).setBlockName("bedrockSlabSingle").setCreativeTab(MinestrappolationCore.creativeTabStone);
		bedrockSlabsDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Bedrock_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Bedrock_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Bedrock_Refined_0_0"), MCAssetManager.getSCTexture("Bedrock_RawSlab_Top_0") }).setBlockName("bedrockSlabDouble");
		
		clayBricks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Bricks_0_Black"), MCAssetManager.getSCTexture("Clay_Bricks_0_Blue"), MCAssetManager.getSCTexture("Clay_Bricks_0_Brown"), MCAssetManager.getSCTexture("Clay_Bricks_0_Cyan"), MCAssetManager.getSCTexture("Clay_Bricks_0_Green"), MCAssetManager.getSCTexture("Clay_Bricks_0_Grey"), MCAssetManager.getSCTexture("Clay_Bricks_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Bricks_0_Lime"), MCAssetManager.getSCTexture("Clay_Bricks_0_Magenta"), MCAssetManager.getSCTexture("Clay_Bricks_0_Orange"), MCAssetManager.getSCTexture("Clay_Bricks_0_Pink"), MCAssetManager.getSCTexture("Clay_Bricks_0_Purple"), MCAssetManager.getSCTexture("Clay_Bricks_0_Red"), MCAssetManager.getSCTexture("Clay_Bricks_0_Silver"), MCAssetManager.getSCTexture("Clay_Bricks_0_White"), MCAssetManager.getSCTexture("Clay_Bricks_0_Yellow"), }).setBlockName("clayBlocks").setHardness(2.0F).setResistance(8.0F);
		refinedClay = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Black"), MCAssetManager.getSCTexture("Clay_Refined_0_Blue"), MCAssetManager.getSCTexture("Clay_Refined_0_Brown"), MCAssetManager.getSCTexture("Clay_Refined_0_Cyan"), MCAssetManager.getSCTexture("Clay_Refined_0_Green"), MCAssetManager.getSCTexture("Clay_Refined_0_Grey"), MCAssetManager.getSCTexture("Clay_Refined_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Refined_0_Lime"), MCAssetManager.getSCTexture("Clay_Refined_0_Magenta"), MCAssetManager.getSCTexture("Clay_Refined_0_Orange"), MCAssetManager.getSCTexture("Clay_Refined_0_Pink"), MCAssetManager.getSCTexture("Clay_Refined_0_Purple"), MCAssetManager.getSCTexture("Clay_Refined_0_Red"), MCAssetManager.getSCTexture("Clay_Refined_0_Silver"), MCAssetManager.getSCTexture("Clay_Refined_0_White"), MCAssetManager.getSCTexture("Clay_Refined_0_Yellow"), }).setBlockName("clayBlocks2").setHardness(2.0F).setResistance(8.0F);
		clayPatternedBricks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_PatternBricks_0_Black"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Blue"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Brown"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Cyan"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Green"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Grey"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_LightBlue"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Lime"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Magenta"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Orange"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Pink"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Purple"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Red"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Silver"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_White"),
				MCAssetManager.getSCTexture("Clay_PatternBricks_0_Yellow"), }).setBlockName("clayBlocks3").setHardness(2.0F).setResistance(8.0F);
		clayTiles = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Tiles_0_Black"), MCAssetManager.getSCTexture("Clay_Tiles_0_Blue"), MCAssetManager.getSCTexture("Clay_Tiles_0_Brown"), MCAssetManager.getSCTexture("Clay_Tiles_0_Cyan"), MCAssetManager.getSCTexture("Clay_Tiles_0_Green"), MCAssetManager.getSCTexture("Clay_Tiles_0_Grey"), MCAssetManager.getSCTexture("Clay_Tiles_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Tiles_0_Lime"), MCAssetManager.getSCTexture("Clay_Tiles_0_Magenta"), MCAssetManager.getSCTexture("Clay_Tiles_0_Orange"), MCAssetManager.getSCTexture("Clay_Tiles_0_Pink"), MCAssetManager.getSCTexture("Clay_Tiles_0_Purple"), MCAssetManager.getSCTexture("Clay_Tiles_0_Red"), MCAssetManager.getSCTexture("Clay_Tiles_0_Silver"), MCAssetManager.getSCTexture("Clay_Tiles_0_White"), MCAssetManager.getSCTexture("Clay_Tiles_0_Yellow") }).setBlockName("clayBlocks4").setHardness(2.0F).setResistance(8.0F);
		
		clayPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Side_Black"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Blue"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Brown"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Cyan") }, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Top_Black"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Blue"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Brown"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Cyan") }).setBlockName("clayPillars").setHardness(2.0F).setResistance(8.0F);
		clayPillars2 = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Side_Green"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Grey"), MCAssetManager.getSCTexture("Clay_Pillar_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Lime") }, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Top_Green"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Grey"), MCAssetManager.getSCTexture("Clay_Pillar_Top_LightBlue"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Lime") }).setBlockName("clayPillars2").setHardness(2.0F).setResistance(8.0F);
		clayPillars3 = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Side_Magenta"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Orange"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Pink"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Purple") }, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Top_Magenta"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Orange"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Pink"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Purple") }).setBlockName("clayPillars3").setHardness(2.0F).setResistance(8.0F);
		clayPillars4 = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Side_Red"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Silver"), MCAssetManager.getSCTexture("Clay_Pillar_Side_White"), MCAssetManager.getSCTexture("Clay_Pillar_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_Pillar_Top_Red"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Silver"), MCAssetManager.getSCTexture("Clay_Pillar_Top_White"), MCAssetManager.getSCTexture("Clay_Pillar_Top_Yellow") }).setBlockName("clayPillars4").setHardness(2.0F).setResistance(8.0F);
		
		clayRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Clay_Road_Side_Black"), MCAssetManager.getSCTexture("Clay_Road_Side_Blue"), MCAssetManager.getSCTexture("Clay_Road_Side_Brown"), MCAssetManager.getSCTexture("Clay_Road_Side_Cyan"), MCAssetManager.getSCTexture("Clay_Road_Side_Green"), MCAssetManager.getSCTexture("Clay_Road_Side_Grey"), MCAssetManager.getSCTexture("Clay_Road_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_Road_Side_Lime"), MCAssetManager.getSCTexture("Clay_Road_Side_Magenta"), MCAssetManager.getSCTexture("Clay_Road_Side_Orange"), MCAssetManager.getSCTexture("Clay_Road_Side_Pink"), MCAssetManager.getSCTexture("Clay_Road_Side_Purple"), MCAssetManager.getSCTexture("Clay_Road_Side_Red"), MCAssetManager.getSCTexture("Clay_Road_Side_Silver"), MCAssetManager.getSCTexture("Clay_Road_Side_White"), MCAssetManager.getSCTexture("Clay_Road_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_PatternBricks_0_Black"),
				MCAssetManager.getSCTexture("Clay_PatternBricks_0_Blue"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Brown"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Cyan"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Green"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Grey"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_LightBlue"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Lime"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Magenta"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Orange"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Pink"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Purple"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Red"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Silver"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_White"), MCAssetManager.getSCTexture("Clay_PatternBricks_0_Yellow") }, new String[] { MCAssetManager.getTexture("grasslessDirt"),
				MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt"), MCAssetManager.getTexture("grasslessDirt") }).setBlockName("clayRoads").setHardness(2.0F).setResistance(8.0F);
		clayChiseled = new MCBlockMultiPillarStationary(Material.rock,
				new String[] { MCAssetManager.getSCTexture("Clay_Chiseled_Side_Black"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Blue"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Brown"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Cyan"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Green"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Grey"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Lime"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Magenta"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Orange"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Pink"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Purple"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Red"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Silver"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_White"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Yellow") }, new String[] {
						MCAssetManager.getSCTexture("Clay_Refined_0_Black"), MCAssetManager.getSCTexture("Clay_Refined_0_Blue"), MCAssetManager.getSCTexture("Clay_Refined_0_Brown"), MCAssetManager.getSCTexture("Clay_Refined_0_Cyan"), MCAssetManager.getSCTexture("Clay_Refined_0_Green"), MCAssetManager.getSCTexture("Clay_Refined_0_Grey"), MCAssetManager.getSCTexture("Clay_Refined_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Refined_0_Lime"), MCAssetManager.getSCTexture("Clay_Refined_0_Magenta"), MCAssetManager.getSCTexture("Clay_Refined_0_Orange"), MCAssetManager.getSCTexture("Clay_Refined_0_Pink"), MCAssetManager.getSCTexture("Clay_Refined_0_Purple"), MCAssetManager.getSCTexture("Clay_Refined_0_Red"), MCAssetManager.getSCTexture("Clay_Refined_0_Silver"), MCAssetManager.getSCTexture("Clay_Refined_0_White"), MCAssetManager.getSCTexture("Clay_Refined_0_Yellow"), }).setBlockName("clayChiseled").setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle1 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Black"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Blue"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Brown"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Cyan") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Black"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Blue"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Brown"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Cyan") }).setBlockName("claySlabsSingle").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle2 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Green"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Grey"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Lime") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Green"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Grey"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_LightBlue"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Lime") }).setBlockName("claySlabsSingle2").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle3 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Magenta"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Orange"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Pink"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Purple") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Magenta"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Orange"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Pink"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Purple") }).setBlockName("claySlabsSingle3").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle4 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Red"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Silver"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_White"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Red"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Silver"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_White"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Yellow"), }).setBlockName("claySlabsSingle4").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble1 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Black"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Blue"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Brown"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Cyan") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Black"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Blue"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Brown"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Cyan") }).setBlockName("claySlabsDouble").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble2 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Green"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Grey"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Lime") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Green"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Grey"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_LightBlue"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Lime") }).setBlockName("claySlabsDouble2").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble3 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Magenta"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Orange"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Pink"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Purple") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Magenta"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Orange"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Pink"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Purple") }).setBlockName("claySlabsDouble3").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble4 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Side_Red"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Silver"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_White"), MCAssetManager.getSCTexture("Clay_RawSlab_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_RawSlab_Top_Red"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Silver"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_White"), MCAssetManager.getSCTexture("Clay_RawSlab_Top_Yellow"), }).setBlockName("claySlabsDouble4").setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsSingle1 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Black"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Blue"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Brown"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Cyan") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Black"), MCAssetManager.getSCTexture("Clay_Refined_0_Blue"), MCAssetManager.getSCTexture("Clay_Refined_0_Brown"), MCAssetManager.getSCTexture("Clay_Refined_0_Cyan") }).setBlockName("claySlabsSingle5").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsSingle2 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Green"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Grey"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Lime") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Green"), MCAssetManager.getSCTexture("Clay_Refined_0_Grey"), MCAssetManager.getSCTexture("Clay_Refined_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Refined_0_Lime") }).setBlockName("claySlabsSingle6").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsSingle3 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Magenta"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Orange"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Pink"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Purple") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Magenta"), MCAssetManager.getSCTexture("Clay_Refined_0_Orange"), MCAssetManager.getSCTexture("Clay_Refined_0_Pink"), MCAssetManager.getSCTexture("Clay_Refined_0_Purple") }).setBlockName("claySlabsSingle7").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsSingle4 = (MCBlockMultiSlab) new BlockClaySlab(false, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Red"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Silver"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_White"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Red"), MCAssetManager.getSCTexture("Clay_Refined_0_Silver"), MCAssetManager.getSCTexture("Clay_Refined_0_White"), MCAssetManager.getSCTexture("Clay_Refined_0_Yellow"), }).setBlockName("claySlabsSingle8").setCreativeTab(MinestrappolationCore.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsDouble1 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Black"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Blue"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Brown"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Cyan") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Black"), MCAssetManager.getSCTexture("Clay_Refined_0_Blue"), MCAssetManager.getSCTexture("Clay_Refined_0_Brown"), MCAssetManager.getSCTexture("Clay_Refined_0_Cyan") }).setBlockName("claySlabsDouble5").setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsDouble2 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Green"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Grey"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Lime") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Green"), MCAssetManager.getSCTexture("Clay_Refined_0_Grey"), MCAssetManager.getSCTexture("Clay_Refined_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Refined_0_Lime") }).setBlockName("claySlabsDouble6").setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsDouble3 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Magenta"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Orange"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Pink"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Purple") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Magenta"), MCAssetManager.getSCTexture("Clay_Refined_0_Orange"), MCAssetManager.getSCTexture("Clay_Refined_0_Pink"), MCAssetManager.getSCTexture("Clay_Refined_0_Purple") }).setBlockName("claySlabsDouble7").setHardness(2.0F).setResistance(8.0F);
		refinedClaySlabsDouble4 = (MCBlockMultiSlab) new BlockClaySlab(true, new String[] { MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Red"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Silver"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_White"), MCAssetManager.getSCTexture("Clay_RefinedSlab_Side_Yellow") }, new String[] { MCAssetManager.getSCTexture("Clay_Refined_0_Red"), MCAssetManager.getSCTexture("Clay_Refined_0_Silver"), MCAssetManager.getSCTexture("Clay_Refined_0_White"), MCAssetManager.getSCTexture("Clay_Refined_0_Yellow"), }).setBlockName("claySlabsDouble8").setHardness(2.0F).setResistance(8.0F);
		clayChiseled = new MCBlockMultiPillarStationary(Material.rock,
				new String[] { MCAssetManager.getSCTexture("Clay_Chiseled_Side_Black"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Blue"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Brown"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Cyan"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Green"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Grey"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_LightBlue"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Lime"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Magenta"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Orange"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Pink"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Purple"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Red"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Silver"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_White"), MCAssetManager.getSCTexture("Clay_Chiseled_Side_Yellow") }, new String[] {
						MCAssetManager.getSCTexture("Clay_Refined_0_Black"), MCAssetManager.getSCTexture("Clay_Refined_0_Blue"), MCAssetManager.getSCTexture("Clay_Refined_0_Brown"), MCAssetManager.getSCTexture("Clay_Refined_0_Cyan"), MCAssetManager.getSCTexture("Clay_Refined_0_Green"), MCAssetManager.getSCTexture("Clay_Refined_0_Grey"), MCAssetManager.getSCTexture("Clay_Refined_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Refined_0_Lime"), MCAssetManager.getSCTexture("Clay_Refined_0_Magenta"), MCAssetManager.getSCTexture("Clay_Refined_0_Orange"), MCAssetManager.getSCTexture("Clay_Refined_0_Pink"), MCAssetManager.getSCTexture("Clay_Refined_0_Purple"), MCAssetManager.getSCTexture("Clay_Refined_0_Red"), MCAssetManager.getSCTexture("Clay_Refined_0_Silver"), MCAssetManager.getSCTexture("Clay_Refined_0_White"), MCAssetManager.getSCTexture("Clay_Refined_0_Yellow"), }).setBlockName("clayChiseled").setHardness(2.0F).setResistance(8.0F);
		
		endstoneBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Endstone_Bricks_0_0"), MCAssetManager.getSCTexture("Endstone_PatternBricks_0_0"), MCAssetManager.getSCTexture("Endstone_Raw_0_0"), MCAssetManager.getSCTexture("Endstone_Refined_0_0"), MCAssetManager.getSCTexture("Endstone_Tiles_0_0") }).setBlockName("endstoneBlocks").setHardness(1.5F).setResistance(2.0F);
		endstonePillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Endstone_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Endstone_Pillar_Top_0") }).setHardness(1.5F).setResistance(2.0F).setBlockName("endstonePillars");
		endstoneRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Endstone_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Endstone_PatternBricks_0_0") }, new String[] { "obsidian" }).setHardness(1.5F).setResistance(2.0F).setBlockName("endstoneRoads");
		endstoneChiseled = new MCBlockMultiPillarStationary(Material.rock, new String[] { MCAssetManager.getSCTexture("Endstone_Chiseled_Side_0") }, new String[] { MCAssetManager.getSCTexture("Endstone_Chiseled_Side_0") }).setBlockName("endstoneChiseled").setHardness(1.5F).setResistance(2.0F);
		endstoneSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Endstone_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Endstone_RawSlab_Top_0") }).setBlockName("endstoneSlabSingle").setHardness(1.5F).setResistance(2.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		endstoneSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Endstone_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Endstone_RawSlab_Top_0") }).setBlockName("endstoneSlabDouble").setHardness(1.5F).setResistance(2.0F);
		
		flintBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Flint_Bricks_0_0"), MCAssetManager.getSCTexture("Flint_Chiseled_0_0"), MCAssetManager.getSCTexture("Flint_PatternBricks_0_0"), MCAssetManager.getSCTexture("Flint_Tiles_0_0"), MCAssetManager.getSCTexture("Flint-NetherQuartz_TileChecker_0_0") }).setBlockName("flintBlocks").setHardness(2.0F).setResistance(5.0F);
		flintLamps = new MCBlockMultiLamp(Material.rock, new String[] { MCAssetManager.getSCTexture("Flint_LampGlowstone_0_0"), MCAssetManager.getSCTexture("Flint_LampSunstone_0_0") }).setBlockName("flintLamps").setHardness(2.0F).setResistance(5.0F);
		flintPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Flint_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Flint_Pillar_Top_0") }).setBlockName("flintPillars").setHardness(2.0F).setResistance(5.0F);
		flintRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Flint_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Flint_PatternBricks_0_0") }, new String[] { "gravel" }).setBlockName("flintRoads").setHardness(2.0F).setResistance(5.0F);
		flintSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Flint_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Flint_Refined_0_0") }).setBlockName("flintSlabSingle").setHardness(2.0F).setResistance(5.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		flintSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Flint_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Flint_Refined_0_0") }).setBlockName("flintSlabDouble").setHardness(2.0F).setResistance(5.0F);
		
		graniteBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Granite_Chiseled_0_0"), MCAssetManager.getSCTexture("Granite_Chiseled_0_Bronze"), MCAssetManager.getSCTexture("Granite_Chiseled_0_Meurodite"), MCAssetManager.getSCTexture("Granite_Chiseled_0_Steel"), MCAssetManager.getSCTexture("Granite_Refined_0_0"), MCAssetManager.getSCTexture("Granite_Refined_0_Bronze"), MCAssetManager.getSCTexture("Granite_Refined_0_Meurodite"), MCAssetManager.getSCTexture("Granite_Refined_0_Steel"), MCAssetManager.getSCTexture("Granite_Refined_0_Tin"), MCAssetManager.getSCTexture("Granite_Tiles_0_0"), MCAssetManager.getSCTexture("Granite_Tiles_0_Bronze"), MCAssetManager.getSCTexture("Granite_Tiles_0_Meurodite"), MCAssetManager.getSCTexture("Granite_Tiles_0_Steel"), MCAssetManager.getSCTexture("Granite_Tiles_0_Tin") }).setBlockName("graniteBlocks").setHardness(2.5F).setResistance(5.0F);
		granitePillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Granite_Pillar_Side_0"), MCAssetManager.getSCTexture("Granite_Pillar_Side_Bronze"), MCAssetManager.getSCTexture("Granite_Pillar_Side_Meurodite"), MCAssetManager.getSCTexture("Granite_Pillar_Side_Steel"), MCAssetManager.getSCTexture("Granite_Pillar_Side_Tin") }, new String[] { MCAssetManager.getSCTexture("Granite_Pillar_Top_0"), MCAssetManager.getSCTexture("Granite_Pillar_Top_Bronze"), MCAssetManager.getSCTexture("Granite_Pillar_Top_Meurodite"), MCAssetManager.getSCTexture("Granite_Pillar_Top_Steel") }).setBlockName("granitePillars").setHardness(2.5F).setResistance(5.0F);
		granitePillars2 = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Granite_Pillar_Side_Tin") }, new String[] { MCAssetManager.getSCTexture("Granite_Pillar_Top_Tin") }).setBlockName("granitePillars2").setHardness(2.5F).setResistance(5.0F);
		graniteRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Granite_Road_Side_0"), MCAssetManager.getSCTexture("Granite_Road_Side_Bronze"), MCAssetManager.getSCTexture("Granite_Road_Side_Meurodite"), MCAssetManager.getSCTexture("Granite_Road_Side_Steel") }, new String[] { MCAssetManager.getSCTexture("Granite_PatternBricks_0_0"), MCAssetManager.getSCTexture("Granite_PatternBricks_0_Bronze"), MCAssetManager.getSCTexture("Granite_PatternBricks_0_Meurodite"), MCAssetManager.getSCTexture("Granite_PatternBricks_0_Steel") }, new String[] { "dirt", "dirt", "dirt", "dirt", "dirt" }).setHardness(2.5F).setResistance(5.0F).setBlockName("graniteRoads");
		graniteRoads2 = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Granite_Road_Side_Tin") }, new String[] { MCAssetManager.getSCTexture("Granite_Refined_0_Tin") }, new String[] { "dirt" }).setHardness(2.5F).setResistance(5.0F).setBlockName("graniteRoads2");
		graniteSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Bronze"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Meurodite"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Steel") }, new String[] { MCAssetManager.getSCTexture("Granite_Refined_0_0"), MCAssetManager.getSCTexture("Granite_Refined_0_Bronze"), MCAssetManager.getSCTexture("Granite_Refined_0_Meurodite"), MCAssetManager.getSCTexture("Granite_Refined_0_Steel") }).setBlockName("graniteSlabSingle").setHardness(2.5F).setResistance(5.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		graniteSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Bronze"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Meurodite"), MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Steel") }, new String[] { MCAssetManager.getSCTexture("Granite_Refined_0_0"), MCAssetManager.getSCTexture("Granite_Refined_0_Bronze"), MCAssetManager.getSCTexture("Granite_Refined_0_Meurodite"), MCAssetManager.getSCTexture("Granite_Refined_0_Steel") }).setBlockName("graniteSlabDouble").setHardness(2.5F).setResistance(5.0F);
		graniteSlabSingle2 = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Tin") }, new String[] { MCAssetManager.getSCTexture("Granite_Refined_0_Tin") }).setBlockName("graniteSlabSingle2").setHardness(2.5F).setResistance(5.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		graniteSlabDouble2 = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Granite_RefinedSlab_Side_Tin") }, new String[] { MCAssetManager.getSCTexture("Granite_Refined_0_Tin") }).setBlockName("graniteSlabDouble2").setHardness(2.5F).setResistance(5.0F);
		
		lapisBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Lapis_Bricks_0_0"), MCAssetManager.getSCTexture("Lapis_PatternBricks_0_0"), MCAssetManager.getSCTexture("Lapis_Refined_0_0"), MCAssetManager.getSCTexture("Lapis_Tiles_0_0"), MCAssetManager.getSCTexture("Lapis_TilesGilded_0_0") }).setBlockName("lapisBlocks").setHardness(2.0F).setResistance(4.0F);
		lapisPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Lapis_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Lapis_Pillar_Top_0") }).setBlockName("lapisPillars").setHardness(2.0F).setResistance(4.0F);
		lapisRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Lapis_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Lapis_PatternBricks_0_0") }, new String[] { "sand" }).setBlockName("lapisRoads").setHardness(2.0F).setResistance(4.0F);
		lapisChiseled = new MCBlockMultiPillarStationary(Material.rock, new String[] { MCAssetManager.getSCTexture("Lapis_Chiseled_Side_0") }, new String[] { MCAssetManager.getSCTexture("Lapis_Chiseled_Top_0") }).setBlockName("lapisChiseled").setHardness(2.0F).setResistance(4.0F);
		lapisSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Lapis_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Lapis_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Lapis_Refined_0_0"), MCAssetManager.getSCTexture("Lapis_RawSlab_Top") }).setBlockName("lapisSlabSingle").setHardness(2.0F).setResistance(4.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		lapisSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Lapis_RefinedSlab_Side_0"), MCAssetManager.getSCTexture("Lapis_RawSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Lapis_Refined_0_0"), MCAssetManager.getSCTexture("Lapis_RawSlab_Top") }).setBlockName("lapisSlabDouble").setHardness(2.0F).setResistance(4.0F);
		
		netherQuartzBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Bricks_0_0"), MCAssetManager.getSCTexture("NetherQuartz_PatternBricks_0_0"), MCAssetManager.getSCTexture("NetherQuartz_Refined_0_0"), MCAssetManager.getSCTexture("NetherQuartz_Tiles_0_0") }).setBlockName("netherQuartzBlocks").setHardness(2.0F).setResistance(3.5F);
		netherQuartzPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Pillar_Top_0") }).setBlockName("netherQuartzPillars").setHardness(2.0F).setResistance(3.5F);
		netherQuartzRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("NetherQuartz_PatternBricks_0_0") }, new String[] { "soul_sand" }).setBlockName("netherQuartzRoads").setHardness(2.0F).setResistance(3.5F);
		netherQuartzChiseled = new MCBlockMultiPillarStationary(Material.rock, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Chiseled_Side_0") }, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Chiseled_Top_0") }).setBlockName("netherQuartzChiseled").setHardness(2.0F).setResistance(3.5F);
		netherQuartzSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("NetherQuartz_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Refined_0_0") }).setBlockName("netherQuartzSlabSingle").setHardness(2.0F).setResistance(3.5F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		netherQuartzSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("NetherQuartz_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("NetherQuartz_Refined_0_0") }).setBlockName("netherQuartzSlabDouble").setHardness(2.0F).setResistance(3.5F);
		
		netherrackBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Netherrack_Chiseled_0_0"), MCAssetManager.getSCTexture("Netherrack_PatternBricks_0_0"), MCAssetManager.getSCTexture("Netherrack_Refined_0_0"), MCAssetManager.getSCTexture("Netherrack_Tiles_0_0") }).setBlockName("netherrackBlocks").setHardness(1.0F).setResistance(1.5F);
		netherrackPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Netherrack_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Netherrack_Pillar_Top_0") }).setBlockName("netherrackPillars").setHardness(1.0F).setResistance(1.5F);
		netherrackRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Netherrack_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Netherrack_PatternBricks_0_0") }, new String[] { "soul_sand" }).setBlockName("netherrackRoads").setHardness(1.0F).setResistance(1.5F);
		netherrackSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Netherrack_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Netherrack_Refined_0_0") }).setBlockName("netherrackSlabSingle").setHardness(1.0F).setResistance(1.5F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		netherrackSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Netherrack_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Netherrack_Refined_0_0") }).setBlockName("netherrackSlabDouble").setHardness(1.0F).setResistance(1.5F);
		
		obsidianBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("Obsidian_Bricks_0_0"), MCAssetManager.getSCTexture("Obsidian_Chiseled_0_0"), MCAssetManager.getSCTexture("Obsidian_PatternBricks_0_0"), MCAssetManager.getSCTexture("Obsidian_Refined_0_0"), MCAssetManager.getSCTexture("Obsidian_Tiles_0_0"), MCAssetManager.getSCTexture("Obsidian-Endstone_TileChecker_0_0") }).setHardness(50.0F).setResistance(2000.0F).setBlockName("obsidianBlocks");
		obsidianLamps = new MCBlockMultiLamp(Material.rock, new String[] { MCAssetManager.getSCTexture("Obsidian_LampGodstone_0_0") }).setHardness(50.0F).setResistance(2000.0F).setBlockName("obsidianLamps");
		obsidianPillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("Obsidian_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("Obsidian_Pillar_Top_0") }).setBlockName("ObsidianPillars").setHardness(50.0F).setResistance(2000.0F).setBlockName("obsidianPillars");
		obsidianRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("Obsidian_Road_Side_0") }, new String[] { MCAssetManager.getSCTexture("Obsidian_PatternBricks_0_0") }, new String[] { "end_stone" }).setBlockName("obsidianRoads").setHardness(50.0F).setResistance(2000.0F);
		obsidianSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("Obsidian_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Obsidian_Refined_0_0") }).setBlockName("obsidianSlabSingle").setHardness(50.0F).setResistance(2000.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		obsidianSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("Obsidian_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("Obsidian_Refined_0_0") }).setBlockName("obsidianSlabDouble").setHardness(50.0F).setResistance(2000.0F);
		
		redSandstoneBlocks = new MCBlockMulti(Material.rock, new String[] { MCAssetManager.getSCTexture("RedSandstone_Bricks_0_0"), MCAssetManager.getSCTexture("RedSandstone_Bricks_0_0"), MCAssetManager.getSCTexture("RedSandstone_BricksMossy_0_0"), MCAssetManager.getSCTexture("RedSandstone_Heiroglyph1_0_0"), MCAssetManager.getSCTexture("RedSandstone_Heiroglyph2_0_0"), MCAssetManager.getSCTexture("RedSandstone_PatternBricks_0_0"), MCAssetManager.getSCTexture("RedSandstone_Tiles_0_0") }).setBlockName("redSandstoneBricks").setHardness(1.5F).setResistance(2.0F);
		redSandstonePillars = new MCBlockMultiPillar(Material.rock, new String[] { MCAssetManager.getSCTexture("RedSandstone_Pillar_Side_0") }, new String[] { MCAssetManager.getSCTexture("RedSandstone_Pillar_Top_0") }).setBlockName("redSandstonePillars").setHardness(1.5F).setResistance(2.0F);
		redSandstoneRoads = new MCBlockMultiRoad(Material.rock, new String[] { MCAssetManager.getSCTexture("RedSandstone_Road_Side_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Side_0"), MCAssetManager.getSCTexture("RedSandstone_Chiseled_Side_0"), MCAssetManager.getSCTexture("RedSandstone_Refined_Side_0") }, new String[] { MCAssetManager.getSCTexture("RedSandstone_PatternBricks_0_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Top_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Top_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Top_0") }, new String[] { "sand_red", MCAssetManager.getSCTexture("RedSandstone_Raw_Bottom_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Bottom_0"), MCAssetManager.getSCTexture("RedSandstone_Raw_Bottom_0") }).setBlockName("redSandstoneRoads").setHardness(1.5F).setResistance(2.0F);
		redSandstoneSlabSingle = (MCBlockMultiSlab) new MCBlockMultiSlab(false, new String[] { MCAssetManager.getSCTexture("RedSandstone_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("RedSandstone_Raw_Top_0") }).setBlockName("redSandstoneSlabSingle").setHardness(1.5F).setResistance(2.0F).setCreativeTab(MinestrappolationCore.creativeTabStone);
		redSandstoneSlabDouble = (MCBlockMultiSlab) new MCBlockMultiSlab(true, new String[] { MCAssetManager.getSCTexture("RedSandstone_RefinedSlab_Side_0") }, new String[] { MCAssetManager.getSCTexture("RedSandstone_Raw_Top_0") }).setBlockName("redSandstoneSlabDouble").setHardness(1.5F).setResistance(2.0F);
	}
	
	public static void load()
	{
		// TODO: ORGANIZE ED BLOCKS;
		GameRegistry.registerTileEntity(TileEntityPlate.class, "Plate");
		
		GameRegistry.registerBlock(stones, MCItemBlockMulti.class, "Stones");
		GameRegistry.registerBlock(Tiles, MCItemBlockMulti.class, "tiles");
		GameRegistry.registerBlock(checkerTileStairs, "checkerTileStairs");
		GameRegistry.registerBlock(stonePillar, "stonePillar");
		
		GameRegistry.registerBlock(cobbledRoad, "cobbledRoad");
		GameRegistry.registerBlock(refinedRoad, "refinedRoad");
		
		GameRegistry.registerBlock(stoneLamp, MCItemBlockMulti.class, "stoneLamp");
		GameRegistry.registerBlock(edgeStoneBrick, "edgeStoneBrick");
		
		GameRegistry.registerBlock(snowBrick, "snowBrick");
		
		GameRegistry.registerBlock(GlassDoor, "GlassDoor");
		GameRegistry.registerBlock(glassRefined, "glassRefined");
		GameRegistry.registerBlock(glassRefinedPane, "glassRefinedPane");
		
		GameRegistry.registerBlock(gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(sugarBlock, "sugarBlock");
		GameRegistry.registerBlock(meatBlock, "meatBlock");
		GameRegistry.registerBlock(enderBlock, "enderBlock");
		
		GameRegistry.registerBlock(rope, "rope");
		GameRegistry.registerBlock(ropeCoil, "ropeCoil");
		
		GameRegistry.registerBlock(oozeSlime, "oozeSlime");
		GameRegistry.registerBlock(magmaOoze, "magmaOoze");
		
		GameRegistry.registerBlock(woodBoards, MCItemBlockMulti.class, "woodBoards");
		
		GameRegistry.registerBlock(crate, "crate");
		GameRegistry.registerBlock(barrel, "barrel");
		GameRegistry.registerBlock(cardboard, "cardboard");
		GameRegistry.registerBlock(cardboardBlock, "cardboardBlock");
		
		GameRegistry.registerBlock(infertileDirt, "infertileDirt");
		
		GameRegistry.registerBlock(sandyRoad, "sandyRoad");
		GameRegistry.registerBlock(sandstoneRoad, "sandstoneRoad");
		GameRegistry.registerBlock(gravelRoad, "gravelRoad");
		GameRegistry.registerBlock(netherroad, "netherroad");
		GameRegistry.registerBlock(refinedNetherroad, "refinedNetherroad");
		
		GameRegistry.registerBlock(woodPanel, MCItemBlockMulti.class, "woodPanel");
		GameRegistry.registerBlock(woodBeveled, MCItemBlockMulti.class, "woodBeveled");
		GameRegistry.registerBlock(woodPlanksMossy, MCItemBlockMulti.class, "woodPlanksMossy");
		GameRegistry.registerBlock(woodBoardsStairsOak, "woodBoardStairsOak");
		GameRegistry.registerBlock(woodBoardsStairsBirch, "woodBoardStairsBirch");
		GameRegistry.registerBlock(woodBoardsStairsSpruce, "woodBoardStairsSpruce");
		GameRegistry.registerBlock(woodBoardsStairsJungle, "woodBoardStairsJungle");
		GameRegistry.registerBlock(woodBoardsSingleSlab, ItemBlockWoodBoardSlab.class, "woodBoardsSlabSingle", null, woodBoardsSingleSlab, woodBoardsDoubleSlab);
		GameRegistry.registerBlock(woodBoardsDoubleSlab, ItemBlockWoodBoardSlab.class, "woodBoardsSlabDouble", null, woodBoardsSingleSlab, woodBoardsDoubleSlab);
		
		GameRegistry.registerBlock(Goblet, MCItemBlockMulti.class, "Goblet");
		GameRegistry.registerBlock(Plate, "Plate");
		
		GameRegistry.registerBlock(sandstoneBricks, MCItemBlockMulti.class, "sandstoneBricks");
		GameRegistry.registerBlock(sandstonePillar, "sandstonePillar");
		
		GameRegistry.registerBlock(bedrockBlocks, MCItemBlockMulti.class, "bedrockBlocks");
		GameRegistry.registerBlock(bedrockLamps, MCItemBlockMulti.class, "bedrockLamps");
		GameRegistry.registerBlock(bedrockPillars, MCItemBlockMulti.class, "bedrockPillars");
		GameRegistry.registerBlock(bedrockRoads, MCItemBlockMulti.class, "bedrockRoads");
		GameRegistry.registerBlock(bedrockSlabsSingle, MCItemBlockSlab.class, "bedrockSlabsSingle", null, bedrockSlabsSingle, bedrockSlabsDouble);
		GameRegistry.registerBlock(bedrockSlabsDouble, MCItemBlockSlab.class, "bedrockSlabsDouble", null, bedrockSlabsSingle, bedrockSlabsDouble);
		
		GameRegistry.registerBlock(stainedBrick, MCItemBlockMulti.class, "stainedBrick");
		
		GameRegistry.registerBlock(clayBricks, MCItemBlockMulti.class, "clayBlocks");
		GameRegistry.registerBlock(refinedClay, MCItemBlockMulti.class, "clayBlocks2");
		GameRegistry.registerBlock(clayPatternedBricks, MCItemBlockMulti.class, "clayBlocks3");
		GameRegistry.registerBlock(clayTiles, MCItemBlockMulti.class, "clayBlocks4");
		
		GameRegistry.registerBlock(clayPillars, MCItemBlockMulti.class, "clayPillars");
		GameRegistry.registerBlock(clayPillars2, MCItemBlockMulti.class, "clayPillars2");
		GameRegistry.registerBlock(clayPillars3, MCItemBlockMulti.class, "clayPillars3");
		GameRegistry.registerBlock(clayPillars4, MCItemBlockMulti.class, "clayPillars4");
		
		GameRegistry.registerBlock(clayRoads, MCItemBlockMulti.class, "clayRoads");
		GameRegistry.registerBlock(clayChiseled, MCItemBlockMulti.class, "clayChiseled");
		
		GameRegistry.registerBlock(claySlabsSingle1, ItemBlockClaySlab.class, "claySlabsSingle", null, claySlabsSingle1, claySlabsDouble1);
		GameRegistry.registerBlock(claySlabsSingle2, ItemBlockClaySlab.class, "claySlabsSingle2", null, claySlabsSingle2, claySlabsDouble2);
		GameRegistry.registerBlock(claySlabsSingle3, ItemBlockClaySlab.class, "claySlabsSingle3", null, claySlabsSingle3, claySlabsDouble3);
		GameRegistry.registerBlock(claySlabsSingle4, ItemBlockClaySlab.class, "claySlabsSingle4", null, claySlabsSingle4, claySlabsDouble4);
		
		GameRegistry.registerBlock(claySlabsDouble1, ItemBlockClaySlab.class, "claySlabsDouble", null, claySlabsSingle1, claySlabsDouble1);
		GameRegistry.registerBlock(claySlabsDouble2, ItemBlockClaySlab.class, "claySlabsDouble2", null, claySlabsSingle2, claySlabsDouble2);
		GameRegistry.registerBlock(claySlabsDouble3, ItemBlockClaySlab.class, "claySlabsDouble3", null, claySlabsSingle3, claySlabsDouble3);
		GameRegistry.registerBlock(claySlabsDouble4, ItemBlockClaySlab.class, "claySlabsDouble4", null, claySlabsSingle4, claySlabsDouble4);
		
		GameRegistry.registerBlock(refinedClaySlabsSingle1, ItemBlockClaySlab.class, "claySlabsSingle5", null, refinedClaySlabsSingle1, refinedClaySlabsDouble1);
		GameRegistry.registerBlock(refinedClaySlabsSingle2, ItemBlockClaySlab.class, "claySlabsSingle6", null, refinedClaySlabsSingle2, refinedClaySlabsDouble2);
		GameRegistry.registerBlock(refinedClaySlabsSingle3, ItemBlockClaySlab.class, "claySlabsSingle7", null, refinedClaySlabsSingle3, refinedClaySlabsDouble3);
		GameRegistry.registerBlock(refinedClaySlabsSingle4, ItemBlockClaySlab.class, "claySlabsSingle8", null, refinedClaySlabsSingle4, refinedClaySlabsDouble4);
		
		GameRegistry.registerBlock(refinedClaySlabsDouble1, ItemBlockClaySlab.class, "claySlabsDouble5", null, refinedClaySlabsSingle1, refinedClaySlabsDouble1);
		GameRegistry.registerBlock(refinedClaySlabsDouble2, ItemBlockClaySlab.class, "claySlabsDouble6", null, refinedClaySlabsSingle2, refinedClaySlabsDouble2);
		GameRegistry.registerBlock(refinedClaySlabsDouble3, ItemBlockClaySlab.class, "claySlabsDouble7", null, refinedClaySlabsSingle3, refinedClaySlabsDouble3);
		GameRegistry.registerBlock(refinedClaySlabsDouble4, ItemBlockClaySlab.class, "claySlabsDouble8", null, refinedClaySlabsSingle4, refinedClaySlabsDouble4);
		
		GameRegistry.registerBlock(endstone, MCItemBlockMulti.class, "endstone");
		GameRegistry.registerBlock(endstoneBlocks, MCItemBlockMulti.class, "endstoneBlocks");
		GameRegistry.registerBlock(endstonePillars, MCItemBlockMulti.class, "endstonePillars");
		GameRegistry.registerBlock(endstoneRoads, MCItemBlockMulti.class, "endstoneRoads");
		GameRegistry.registerBlock(endstoneChiseled, MCItemBlockMulti.class, "endstoneChiseled");
		GameRegistry.registerBlock(endstoneSlabSingle, MCItemBlockSlab.class, "endstoneSlabsSingle", null, endstoneSlabSingle, endstoneSlabDouble);
		GameRegistry.registerBlock(endstoneSlabDouble, MCItemBlockSlab.class, "endstoneSlabsDouble", null, endstoneSlabSingle, endstoneSlabDouble);
		
		GameRegistry.registerBlock(flintBlocks, MCItemBlockMulti.class, "flintBlocks");
		GameRegistry.registerBlock(flintLamps, MCItemBlockMulti.class, "flintLamps");
		GameRegistry.registerBlock(flintPillars, MCItemBlockMulti.class, "flintPillars");
		GameRegistry.registerBlock(flintRoads, MCItemBlockMulti.class, "flintRoads");
		GameRegistry.registerBlock(flintSlabSingle, MCItemBlockSlab.class, "flintSlabsSingle", null, flintSlabSingle, flintSlabDouble);
		GameRegistry.registerBlock(flintSlabDouble, MCItemBlockSlab.class, "flintSlabsDouble", null, flintSlabSingle, flintSlabDouble);
		
		GameRegistry.registerBlock(graniteBlocks, MCItemBlockMulti.class, "graniteBlocks");
		GameRegistry.registerBlock(granitePillars, MCItemBlockMulti.class, "granitePillar");
		GameRegistry.registerBlock(granitePillars2, MCItemBlockMulti.class, "granitePillar2");
		GameRegistry.registerBlock(graniteRoads, MCItemBlockMulti.class, "graniteRoads");
		GameRegistry.registerBlock(graniteRoads2, MCItemBlockMulti.class, "graniteRoads2");
		GameRegistry.registerBlock(graniteSlabSingle, MCItemBlockSlab.class, "graniteSlabsSingle", null, graniteSlabSingle, graniteSlabDouble);
		GameRegistry.registerBlock(graniteSlabSingle2, MCItemBlockSlab.class, "graniteSlabsSingle2", null, graniteSlabSingle2, graniteSlabDouble2);
		GameRegistry.registerBlock(graniteSlabDouble, MCItemBlockSlab.class, "graniteSlabDouble", null, graniteSlabSingle, graniteSlabDouble);
		GameRegistry.registerBlock(graniteSlabDouble2, MCItemBlockSlab.class, "graniteSlabDouble2", null, graniteSlabSingle2, graniteSlabDouble2);
		
		GameRegistry.registerBlock(lapisBlocks, MCItemBlockMulti.class, "lapisBlocks");
		GameRegistry.registerBlock(lapisPillars, MCItemBlockMulti.class, "lapisPillars");
		GameRegistry.registerBlock(lapisRoads, MCItemBlockMulti.class, "lapisRoads");
		GameRegistry.registerBlock(lapisChiseled, MCItemBlockMulti.class, "lapisChiseled");
		GameRegistry.registerBlock(lapisSlabSingle, MCItemBlockSlab.class, "lapisSlabSingle", null, lapisSlabSingle, lapisSlabDouble);
		GameRegistry.registerBlock(lapisSlabDouble, MCItemBlockSlab.class, "lapisSlabDouble", null, lapisSlabSingle, lapisSlabDouble);
		
		GameRegistry.registerBlock(netherQuartzBlocks, MCItemBlockMulti.class, "netherQuartzBlocks");
		GameRegistry.registerBlock(netherQuartzPillars, MCItemBlockMulti.class, "netherQuartzPillars");
		GameRegistry.registerBlock(netherQuartzRoads, MCItemBlockMulti.class, "netherQuartzRoads");
		GameRegistry.registerBlock(netherQuartzChiseled, MCItemBlockMulti.class, "netherQuartzChiseled");
		GameRegistry.registerBlock(netherQuartzSlabSingle, MCItemBlockSlab.class, "netherQuartzSlabSingle", null, netherQuartzSlabSingle, netherQuartzSlabDouble);
		GameRegistry.registerBlock(netherQuartzSlabDouble, MCItemBlockSlab.class, "netherQuartzSlabDouble", null, netherQuartzSlabSingle, netherQuartzSlabDouble);
		
		GameRegistry.registerBlock(netherrackBlocks, MCItemBlockMulti.class, "netherrackBlocks");
		GameRegistry.registerBlock(netherrackPillars, MCItemBlockMulti.class, "netherrackPillars");
		GameRegistry.registerBlock(netherrackRoads, MCItemBlockMulti.class, "netherrackRoads");
		GameRegistry.registerBlock(netherrackSlabSingle, MCItemBlockSlab.class, "netherrackSlabSingle", null, netherrackSlabSingle, netherrackSlabDouble);
		GameRegistry.registerBlock(netherrackSlabDouble, MCItemBlockSlab.class, "netherrackSlabDouble", null, netherrackSlabSingle, netherrackSlabDouble);
		
		GameRegistry.registerBlock(obsidianBlocks, MCItemBlockMulti.class, "obsidianBlocks");
		GameRegistry.registerBlock(obsidianLamps, MCItemBlockMulti.class, "obsidianLamps");
		GameRegistry.registerBlock(obsidianPillars, MCItemBlockMulti.class, "obsidianPillars");
		GameRegistry.registerBlock(obsidianRoads, MCItemBlockMulti.class, "obsidianRoads");
		GameRegistry.registerBlock(obsidianSlabSingle, MCItemBlockSlab.class, "obsidianSlabSingle", null, obsidianSlabSingle, obsidianSlabDouble);
		GameRegistry.registerBlock(obsidianSlabDouble, MCItemBlockSlab.class, "obsidianSlabDouble", null, obsidianSlabSingle, obsidianSlabDouble);
		
		GameRegistry.registerBlock(redSandstoneBlocks, MCItemBlockMulti.class, "redSandstoneBlocks");
		GameRegistry.registerBlock(redSandstonePillars, MCItemBlockMulti.class, "redSandstonePillars");
		GameRegistry.registerBlock(redSandstoneRoads, MCItemBlockMulti.class, "redSandstoneRoads");
		GameRegistry.registerBlock(redSandstoneSlabSingle, MCItemBlockSlab.class, "redSandstoneSlabSingle", null, redSandstoneSlabSingle, redSandstoneSlabDouble);
		GameRegistry.registerBlock(redSandstoneSlabDouble, MCItemBlockSlab.class, "redSandstoneSlabDouble", null, redSandstoneSlabSingle, redSandstoneSlabDouble);
	}
	
	public static void loadVanillaOverwrites()
	{
		/*
		 * Block.blocksList[Block.doorWood.blockID] = null; doorWoodOverwrite =
		 * new BlockDoorOverwrite(64,
		 * Material.wood).setHardness(3.0F).setStepSound
		 * (Block.soundWoodFootstep)
		 * .setBlockName("doorWood").setTextureName("door_wood");
		 * GameRegistry.registerBlock(doorWoodOverwrite, "doorWood");
		 */
	}
	
}
