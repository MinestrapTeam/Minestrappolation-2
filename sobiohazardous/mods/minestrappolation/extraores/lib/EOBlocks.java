package sobiohazardous.mods.minestrappolation.extraores.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.CreativeTabExtraoresBlocks;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockBlazium;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockBlaziumOre;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockCopper;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockCopperTarnished;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockGlowGlass;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockGodstone;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockInvincium;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockMelter;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockNuke;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockDesertQuartzChiseled;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockDesertQuartzPillar;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockPlate;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockPlutoniumInsulated;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockPlutoniumOre;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockPlutoniumRaw;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockRadiantPillar;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockSoulBlock;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockSoulOre;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockSteel;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockSunstone;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockSunstoneOre;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockUraniumInsulated;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockUraniumOre;
import sobiohazardous.mods.minestrappolation.extraores.block.BlockUraniumRaw;
import sobiohazardous.mods.minestrappolation.extraores.block.EOBlock;
import sobiohazardous.mods.minestrappolation.extraores.item.EItemFoiled;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemSoulBottle;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemSoulGem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class EOBlocks
{
	// Bridged Blocks
	public static Block			glowGlass;
	
	public static CreativeTabs	tabOresBlocks	= new CreativeTabExtraoresBlocks(CreativeTabs.getNextID(), "Extrappolated Ores - Blocks");
	
	public static Block			meuroditeOre;
	public static Block			meuroditeBlock;
	
	public static Block			UraniumOre;
	
	public static Block			RawUraniumBlock;
	
	public static Block			PlutoniumOre;
	
	public static Block			RawPlutoniumBlock;
	
	public static Block			TitaniumOre;
	
	public static Block			TitaniumBlock;
	
	public static Block			Sunstone;
	
	public static Block			SunstoneOre;
	
	public static Block			ToriteOre;
	
	public static Block			ToriteBlock;
	
	public static Block			Granite;
	public static Block			GraniteBrick;
	
	public static Block			Quartzite;
	public static Block			QuartziteTile;
	
	public static Block			BlaziumOre;
	public static Block			BlaziumBlock;
	
	public static Block			CopperOre;
	public static Block			CopperBlock;
	
	public static Block			CopperBlockTarnished;
	
	public static Block			TinOre;
	
	public static Block			TinBlock;
	
	public static Item			SoulGem;
	public static Block			TinPlate;
	public static Block			BronzePlate;
	public static Block			SteelPlate;
	public static Block			SteelBlock;
	public static Block			SoulOre;
	
	public static Block			SmoothQuartzite;
	public static Block			PillarQuartzite;
	public static Block			ChiseledQuartzite;
	public static Block			SmoothQuartzTile;
	
	public static Block			TinPlatedCobble;
	public static Block			TinPlatedMossy;
	public static Block			TinPlatedStoneBrick;
	public static Block			TinPlatedChiseled;
	public static Block			TinPlatedGranite;
	
	public static Block			BronzeBlock;
	
	public static Block			BronzePlatedCobble;
	public static Block			BronzePlatedMossy;
	public static Block			BronzePlatedStoneBrick;
	public static Block			BronzePlatedChiseled;
	public static Block			BronzePlatedGranite;
	
	public static Block			Invincium;
	
	public static Block			SteelPlatedCobble;
	public static Block			SteelPlatedMossy;
	public static Block			SteelPlatedStoneBrick;
	public static Block			SteelPlatedChiseled;
	public static Block			SteelPlatedGranite;
	
	public static Item			SoulBottle;
	
	public static Block			nuke;
	
	public static Block			SmoothRadiantQuartz;
	public static Block			ChiseledRadiantQuartz;
	public static Block			PillarRadiantQuartz;
	public static Block			RadiantQuartzOre;
	
	public static Item			RadiantQuartz;
	
	public static Block			Godstone;
	
	public static Block			melterIdle;
	public static Block			melterBurning;
	
	public static Block			RadiantQuartzStairs;
	public static BlockSlab		RadiantQuartzSingleSlab;
	public static BlockSlab		RadiantQuartzDoubleSlab;
	
	public static Block			PinkQuartzStairs;
	public static BlockSlab		PinkQuartzSingleSlab;
	public static BlockSlab		PinkQuartzDoubleSlab;
	
	public static Block			graniteBrickStairs;
	public static BlockSlab		graniteBrickSingleSlab;
	public static BlockSlab		graniteBrickDoubleSlab;
	
	public static Block			tinPlatedCobbleStairs;
	public static BlockSlab		tinPlatedCobbleSingleSlab;
	public static BlockSlab		tinPlatedCobbleDoubleSlab;
	
	public static Block			steelPlatedCobbleStairs;
	public static BlockSlab		steelPlatedCobbleSingleSlab;
	public static BlockSlab		steelPlatedCobbleDoubleSlab;
	
	public static Block			bronzePlatedCobbleStairs;
	public static BlockSlab		bronzePlatedCobbleSingleSlab;
	public static BlockSlab		bronzePlatedCobbleDoubleSlab;
	
	public static Block			tinPlatedStoneBrickStairs;
	public static BlockSlab		tinPlatedStoneBrickSingleSlab;
	public static BlockSlab		tinPlatedStoneBrickDoubleSlab;
	
	public static Block			steelPlatedStoneBrickStairs;
	public static BlockSlab		steelPlatedStoneBrickSingleSlab;
	public static BlockSlab		steelPlatedStoneBrickDoubleSlab;
	
	public static Block			bronzePlatedStoneBrickStairs;
	public static BlockSlab		bronzePlatedStoneBrickSingleSlab;
	public static BlockSlab		bronzePlatedStoneBrickDoubleSlab;
	
	public static Block			tinPlatedGraniteBrickStairs;
	public static BlockSlab		tinPlatedGraniteBrickSingleSlab;
	public static BlockSlab		tinPlatedGraniteBrickDoubleSlab;
	
	public static Block			steelPlatedGraniteBrickStairs;
	public static BlockSlab		steelPlatedGraniteBrickSingleSlab;
	public static BlockSlab		steelPlatedGraniteBrickDoubleSlab;
	
	public static Block			bronzePlatedGraniteBrickStairs;
	public static BlockSlab		bronzePlatedGraniteBrickSingleSlab;
	public static BlockSlab		bronzePlatedGraniteBrickDoubleSlab;
	
	public static Block			plutoniumInsulated;
	public static Block			uraniumInsulated;
	
	public static Block			meuroditePlate;
	
	// public static Block magma;
	
	public static Block			soulBlock;
	
	public static Block			doorWoodOverwrite;
	
	public static void addBlocks()
	{
		meuroditeOre = new EOBlock(Material.rock).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("oreMeurodite").setBlockTextureName(MAssetManager.getEOTexture("oreMeurodite"));
		GameRegistry.registerBlock(meuroditeOre, "oreMeurodite");
		meuroditeBlock = new EOBlock(Material.iron).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("blockMeurodite").setBlockTextureName(MAssetManager.getEOTexture("blockMeurodite"));
		GameRegistry.registerBlock(meuroditeBlock, "blockMeurodite");
		UraniumOre = new BlockUraniumOre(Material.rock).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreUranium").setBlockTextureName(MAssetManager.getEOTexture("oreUranium"));
		GameRegistry.registerBlock(UraniumOre, "oreUranium");
		RawUraniumBlock = new BlockUraniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockUranium").setBlockTextureName(MAssetManager.getEOTexture("blockUranium"));
		GameRegistry.registerBlock(RawUraniumBlock, "blockUraniumRaw");
		PlutoniumOre = new BlockPlutoniumOre(Material.rock).setHardness(5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("orePlutonium").setBlockTextureName(MAssetManager.getEOTexture("orePlutonium")).setCreativeTab(tabOresBlocks);
		GameRegistry.registerBlock(PlutoniumOre, "orePlutonium");
		RawPlutoniumBlock = new BlockPlutoniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockPlutonium").setBlockTextureName(MAssetManager.getEOTexture("blockPlutonium"));
		GameRegistry.registerBlock(RawPlutoniumBlock, "blockPlutoniumRaw");
		TitaniumOre = new EOBlock(Material.rock).setHardness(10F).setResistance(15F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTitanium").setBlockTextureName(MAssetManager.getEOTexture("oreTitanium"));
		GameRegistry.registerBlock(TitaniumOre, "oreTitanium");
		TitaniumBlock = new EOBlock(Material.iron).setHardness(10F).setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTitanium").setBlockTextureName(MAssetManager.getEOTexture("blockTitanium"));
		GameRegistry.registerBlock(TitaniumBlock, "blockTitanium");
		Sunstone = new BlockSunstone(Material.glass).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabOresBlocks).setLightLevel(1.0F).setBlockName("blockSunstone").setBlockTextureName(MAssetManager.getEOTexture("blockSunstone"));
		GameRegistry.registerBlock(Sunstone, "blockSunstone");
		SunstoneOre = new BlockSunstoneOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreSunstone").setBlockTextureName(MAssetManager.getEOTexture("oreSunstone")).setLightLevel(1F);
		GameRegistry.registerBlock(SunstoneOre, "oreSunstone");
		// Old Sunstone Ore code: SunstoneOre = (new BlockSunstoneOre(212,
		// 40)).setHardness(7F).setStepSound(Block.soundStoneFootstep).setCreativeTab(ExtraOres.tabExtra).setLightLevel(1.0F).setBlockName("Sunstone Ore");
		
		ToriteOre = new EOBlock(Material.rock).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreTorite").setBlockTextureName(MAssetManager.getEOTexture("oreTorite"));
		GameRegistry.registerBlock(ToriteOre, "oreTorite");
		ToriteBlock = new EOBlock(Material.iron).setHardness(6F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTorite").setBlockTextureName(MAssetManager.getEOTexture("blockTorite"));
		GameRegistry.registerBlock(ToriteBlock, "blockTorite");
		Granite = new EOBlock(Material.rock).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("graniteRaw").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Granite_Raw_0_0"));
		GameRegistry.registerBlock(Granite, "granite");
		GraniteBrick = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("graniteBricks").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Granite_Bricks_0_0"));
		GameRegistry.registerBlock(GraniteBrick, "brickGranite");
		Quartzite = new EOBlock(Material.rock).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzRaw").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_Raw_0_0"));
		GameRegistry.registerBlock(Quartzite, "quartzDesert");
		QuartziteTile = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzTilesRaw").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_TilesRaw_0_0"));
		GameRegistry.registerBlock(QuartziteTile, "quartzDesertTile");
		SmoothQuartzite = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzRefined").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_Refined_0_0"));
		GameRegistry.registerBlock(SmoothQuartzite, "quartzDesertSmooth");
		PillarQuartzite = new BlockDesertQuartzPillar().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzPillar").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_Pillar_Side_0"));
		GameRegistry.registerBlock(PillarQuartzite, "quartzDesertPillar");
		ChiseledQuartzite = new BlockDesertQuartzChiseled().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzChiseled").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_Chiseled_Side_0"));
		GameRegistry.registerBlock(ChiseledQuartzite, "quartzDesertChiseled");
		SmoothQuartzTile = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzTilesRefined").setBlockTextureName(MAssetManager.getEOStonecutterTexture("DesertQuartz_TilesRefined_0_0"));
		GameRegistry.registerBlock(SmoothQuartzTile, "quartzDesertSmoothTile");
		
		BlaziumOre = new BlockBlaziumOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreBlazium").setBlockTextureName(MAssetManager.getEOTexture("oreBlazium")).setLightLevel(0.5F);
		GameRegistry.registerBlock(BlaziumOre, "oreBlazium");
		// Experimental Blazium Ore Code: BlaziumOre = (new BlockBlaziumOre(204,
		// 5)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabExtra).setLightLevel(0.5F).setBlockName("Blazium Ore");
		BlaziumBlock = new BlockBlazium().setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("blockBlazium").setBlockTextureName(MAssetManager.getEOTexture("blockBlazium")).setLightLevel(0.7F);
		GameRegistry.registerBlock(BlaziumBlock, "blockBlazium");
		
		CopperOre = new EOBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreCopper").setBlockTextureName(MAssetManager.getEOTexture("oreCopper"));
		GameRegistry.registerBlock(CopperOre, "oreCopper");
		CopperBlock = new BlockCopper(Material.iron).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper").setBlockTextureName(MAssetManager.getEOTexture("blockCopper"));
		GameRegistry.registerBlock(CopperBlock, "blockCopper");
		CopperBlockTarnished = new BlockCopperTarnished().setHardness(6F).setResistance(12F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopperTarnished").setBlockTextureName(MAssetManager.getEOTexture("blockCopperTarnishedTop"));
		GameRegistry.registerBlock(CopperBlockTarnished, "blockCopperTarnished");
		TinOre = new EOBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTin").setBlockTextureName(MAssetManager.getEOTexture("oreTin"));
		GameRegistry.registerBlock(TinOre, "oreTin");
		TinBlock = new EOBlock(Material.iron).setHardness(3F).setResistance(2F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTin").setBlockTextureName(MAssetManager.getEOTexture("blockTin"));
		GameRegistry.registerBlock(TinBlock, "blockTin");
		TinPlate = new BlockPlate().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingTin").setBlockTextureName(MAssetManager.getEOTexture("blockTin"));
		GameRegistry.registerBlock(TinPlate, "plateTin");
		BronzePlate = new BlockPlate().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingBronze").setBlockTextureName(MAssetManager.getEOTexture("blockBronze"));
		GameRegistry.registerBlock(BronzePlate, "plateBronze");
		SteelPlate = new BlockPlate().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingSteel").setBlockTextureName(MAssetManager.getEOTexture("blockSteelTop"));
		GameRegistry.registerBlock(SteelPlate, "plateSteel");
		meuroditePlate = new BlockPlate().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingMeurodite").setBlockTextureName(MAssetManager.getEOTexture("blockMeurodite"));
		GameRegistry.registerBlock(meuroditePlate, "plateMeurodite");
		SteelBlock = new BlockSteel().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("blockSteel").setBlockTextureName(MAssetManager.getEOTexture("blockSteelTop"));
		GameRegistry.registerBlock(SteelBlock, "blockSteel");
		SoulOre = new BlockSoulOre().setHardness(2F).setResistance(3F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreSoulGem").setBlockTextureName(MAssetManager.getEOTexture("oreSoulGem"));
		GameRegistry.registerBlock(SoulOre, "oreSoul");
		SoulGem = new ItemSoulGem().setCreativeTab(EOItems.tabOresItems).setUnlocalizedName("item_SoulGem").setTextureName(MAssetManager.getEOTexture("gemSoulGem"));
		GameRegistry.registerItem(SoulGem, "gemSoul");
		TinPlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledTin").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Cobbled_0_Tin"));
		GameRegistry.registerBlock(TinPlatedCobble, "cobbleTin");
		TinPlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledMossyTin").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_CobbledMossy_0_Tin"));
		GameRegistry.registerBlock(TinPlatedMossy, "cobbleMossyTin");
		TinPlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneBricksTin").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Bricks_0_Tin"));
		GameRegistry.registerBlock(TinPlatedStoneBrick, "stoneBrickTin");
		TinPlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneChiseledTin").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Chiseled_0_Tin"));
		GameRegistry.registerBlock(TinPlatedChiseled, "stoneBrickChiseledTin");
		TinPlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("graniteBricksTin").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Granite_Bricks_0_Tin"));
		GameRegistry.registerBlock(TinPlatedGranite, "graniteTin");
		BronzeBlock = new EOBlock(Material.iron).setHardness(7F).setResistance(20F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Bronze").setBlockTextureName(MAssetManager.getEOTexture("blockBronze"));
		GameRegistry.registerBlock(BronzeBlock, "blockBronze");
		BronzePlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeCobble").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Cobbled_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedCobble, "cobbleBronze");
		BronzePlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeMossy").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_CobbledMossy_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedMossy, "cobbleMossyBronze");
		BronzePlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeStoneBrick").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Bricks_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedStoneBrick, "stoneBrickBronze");
		BronzePlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeChiseled").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Chiseled_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedChiseled, "stoneBrickChiseledBronze");
		BronzePlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_BronzeGraniteBrick").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Granite_Bricks_0_Bronze"));
		GameRegistry.registerBlock(BronzePlatedGranite, "graniteBronze");
		Invincium = new BlockInvincium(Material.rock).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Invincium").setBlockTextureName(MAssetManager.getEOTexture("invincium"));
		GameRegistry.registerBlock(Invincium, "invincium");
		SteelPlatedCobble = new EOBlock(Material.rock).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelCobble").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Cobbled_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedCobble, "cobbleSteel");
		SteelPlatedMossy = new EOBlock(Material.rock).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelMossy").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_CobbledMossy_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedMossy, "cobbleMossySteel");
		SteelPlatedStoneBrick = new EOBlock(Material.rock).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelStoneBrick").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Bricks_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedStoneBrick, "stoneBrickSteel");
		SteelPlatedChiseled = new EOBlock(Material.rock).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelChiseled").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Stone_Chiseled_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedChiseled, "stoneBrickChiseledSteel");
		SteelPlatedGranite = new EOBlock(Material.rock).setHardness(6F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_SteelGraniteBrick").setBlockTextureName(MAssetManager.getEOStonecutterTexture("Granite_Bricks_0_Steel"));
		GameRegistry.registerBlock(SteelPlatedGranite, "graniteSteel");
		SoulBottle = new ItemSoulBottle().setCreativeTab(EOItems.tabOresItems).setUnlocalizedName("SoulBottle").setTextureName(MAssetManager.getEOTexture("utilitySoulBottle"));
		GameRegistry.registerItem(SoulBottle, "soulBottle");
		nuke = new BlockNuke().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("nuke");
		GameRegistry.registerBlock(nuke, "nuke");
		SmoothRadiantQuartz = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightLevel(0.5F).setBlockName("block_SmoothRadiantQuartz").setBlockTextureName(MAssetManager.getEOStonecutterTexture("RadiantQuartz_Raw_0_0"));
		GameRegistry.registerBlock(SmoothRadiantQuartz, "quartzRadiantSmooth");
		ChiseledRadiantQuartz = new EOBlock(Material.rock).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightLevel(0.5F).setBlockName("block_ChiseledRadiantQuartz").setBlockTextureName(MAssetManager.getEOStonecutterTexture("RadiantQuartz_Chiseled_0_0"));
		GameRegistry.registerBlock(ChiseledRadiantQuartz, "quartzRadiantChiseled");
		PillarRadiantQuartz = new BlockRadiantPillar().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightLevel(0.5F).setBlockName("PillarRadiantQuartz");
		GameRegistry.registerBlock(PillarRadiantQuartz, "quartzRadiantPillar");
		RadiantQuartzOre = new EOBlock(Material.rock).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightLevel(0.4F).setBlockName("block_RadiantQuartzOre").setBlockTextureName(MAssetManager.getEOTexture("oreRadiantQuartz"));
		GameRegistry.registerBlock(RadiantQuartzOre, "oreQuartzRadiant");
		RadiantQuartz = new EItemFoiled().setCreativeTab(EOItems.tabOresItems).setUnlocalizedName("item_RadiantQuartz").setTextureName(MAssetManager.getEOTexture("gemRadiantQuartz"));
		GameRegistry.registerItem(RadiantQuartz, "quartzRadiant");
		Godstone = new BlockGodstone(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setLightLevel(1F).setBlockName("Godstone").setBlockTextureName(MAssetManager.getEOTexture("godstone"));
		GameRegistry.registerBlock(Godstone, "godstone");
		melterIdle = new BlockMelter(false).setHardness(6F).setResistance(8.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("melter");
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
		 * ).setCreativeTab(tabOresBlocks); RadiantQuartzDoubleSlab =
		 * (BlockSlab) new
		 * RadiantQuartzSlab(true).setLightLevel(0.5F).setBlockName
		 * ("RadiantQuartzDoubleSlab"); registerBlock(RadiantQuartzSingleSlab,
		 * EOItemSlab.class, (BlockSlab)RadiantQuartzSingleSlab,
		 * (BlockSlab)RadiantQuartzDoubleSlab);
		 * registerBlock(RadiantQuartzDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)RadiantQuartzSingleSlab,
		 * (BlockSlab)RadiantQuartzDoubleSlab); PinkQuartzStairs = new
		 * EOBlockStairs(SmoothQuartzite, 0).setBlockName("PinkQuartzStairs");
		 * GameRegistry.registerBlock(PinkQuartzStairs, "quartzDesertStairs");
		 * PinkQuartzSingleSlab = (BlockSlab) new
		 * PinkQuartzSlab(false).setBlockName
		 * ("PinkQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		 * PinkQuartzDoubleSlab = (BlockSlab) new
		 * PinkQuartzSlab(true).setBlockName("PinkQuartzDoubleSlab");
		 * registerBlock(PinkQuartzSingleSlab, EOItemSlab.class,
		 * (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab);
		 * registerBlock(PinkQuartzDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab);
		 * graniteBrickStairs = new EOBlockStairs(GraniteBrick,
		 * 0).setBlockName("graniteBrickStairs");
		 * GameRegistry.registerBlock(graniteBrickStairs,"graniteBrickStairs");
		 * graniteBrickSingleSlab = (BlockSlab) new
		 * GraniteBrickSlab(false).setBlockName
		 * ("graniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * graniteBrickDoubleSlab = (BlockSlab) new
		 * GraniteBrickSlab(true).setBlockName("graniteBrickDoubleSlab");
		 * registerBlock(graniteBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)graniteBrickSingleSlab,
		 * (BlockSlab)graniteBrickDoubleSlab);
		 * registerBlock(graniteBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)graniteBrickSingleSlab,
		 * (BlockSlab)graniteBrickDoubleSlab); tinPlatedCobbleStairs = new
		 * EOBlockStairs(TinPlatedCobble,
		 * 0).setBlockName("tinPlatedCobbleStairs");
		 * GameRegistry.registerBlock(tinPlatedCobbleStairs,"cobbleStairsTin");
		 * tinPlatedCobbleSingleSlab = (BlockSlab) new
		 * TinPlatedCobbleSlab(false)
		 * .setBlockName("tinPlatedCobbleSingleSlab").setCreativeTab
		 * (tabOresBlocks); tinPlatedCobbleDoubleSlab = (BlockSlab) new
		 * TinPlatedCobbleSlab(true).setBlockName("tinPlatedCobbleDoubleSlab");
		 * registerBlock(tinPlatedCobbleSingleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedCobbleSingleSlab,
		 * (BlockSlab)tinPlatedCobbleDoubleSlab);
		 * registerBlock(tinPlatedCobbleDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedCobbleSingleSlab,
		 * (BlockSlab)tinPlatedCobbleDoubleSlab); steelPlatedCobbleStairs = new
		 * EOBlockStairs(SteelPlatedCobble,
		 * 0).setBlockName("steelPlatedCobbleStairs");
		 * GameRegistry.registerBlock(steelPlatedCobbleStairs,
		 * "stairsCobbleSteel"); steelPlatedCobbleSingleSlab = (BlockSlab) new
		 * SteelPlatedCobbleSlab
		 * (false).setBlockName("steelPlatedCobbleSingleSlab"
		 * ).setCreativeTab(tabOresBlocks); steelPlatedCobbleDoubleSlab =
		 * (BlockSlab) new
		 * SteelPlatedCobbleSlab(true).setBlockName("steelPlatedCobbleDoubleSlab"
		 * ); registerBlock(steelPlatedCobbleSingleSlab, EOItemSlab.class,
		 * (BlockSlab)steelPlatedCobbleSingleSlab,
		 * (BlockSlab)steelPlatedCobbleDoubleSlab);
		 * registerBlock(steelPlatedCobbleDoubleSlab,
		 * EOItemSlab.class,(BlockSlab) steelPlatedCobbleSingleSlab,
		 * (BlockSlab)steelPlatedCobbleDoubleSlab); bronzePlatedCobbleStairs =
		 * new EOBlockStairs(BronzePlatedCobble,
		 * 0).setBlockName("bronzePlatedCobbleStairs");
		 * GameRegistry.registerBlock(bronzePlatedCobbleStairs,
		 * "cobbleStairsBronze"); bronzePlatedCobbleSingleSlab = (BlockSlab) new
		 * BronzePlatedCobbleSlab
		 * (false).setBlockName("bronzePlatedCobbleSingleSlab"
		 * ).setCreativeTab(tabOresBlocks); bronzePlatedCobbleDoubleSlab =
		 * (BlockSlab) new
		 * BronzePlatedCobbleSlab(true).setBlockName("bronzePlatedCobbleDoubleSlab"
		 * ); registerBlock(bronzePlatedCobbleSingleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedCobbleSingleSlab,
		 * (BlockSlab)bronzePlatedCobbleDoubleSlab);
		 * registerBlock(bronzePlatedCobbleDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedCobbleSingleSlab,
		 * (BlockSlab)bronzePlatedCobbleDoubleSlab); tinPlatedStoneBrickStairs =
		 * new EOBlockStairs(TinPlatedStoneBrick,
		 * 0).setBlockName("tinPlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(tinPlatedStoneBrickStairs,
		 * "stoneBrickStairsTin"); tinPlatedStoneBrickSingleSlab = (BlockSlab)
		 * new TinPlatedStoneBrickSlab(false).setBlockName(
		 * "tinPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * tinPlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * TinPlatedStoneBrickSlab
		 * (true).setBlockName("tinPlatedStoneBrickDoubleSlab");
		 * registerBlock(tinPlatedStoneBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedStoneBrickSingleSlab,
		 * (BlockSlab)tinPlatedStoneBrickDoubleSlab);
		 * registerBlock(tinPlatedStoneBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedStoneBrickSingleSlab,
		 * (BlockSlab)tinPlatedStoneBrickDoubleSlab);
		 * steelPlatedStoneBrickStairs = new
		 * EOBlockStairs(SteelPlatedStoneBrick,
		 * 0).setBlockName("steelPlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(steelPlatedStoneBrickStairs,
		 * "stoneBrickStairsSteel"); steelPlatedStoneBrickSingleSlab =
		 * (BlockSlab) new SteelPlatedStoneBrickSlab(false).setBlockName(
		 * "steelPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * steelPlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * SteelPlatedStoneBrickSlab
		 * (true).setBlockName("steelPlatedStoneBrickDoubleSlab");
		 * registerBlock(steelPlatedStoneBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)steelPlatedStoneBrickSingleSlab,
		 * (BlockSlab)steelPlatedStoneBrickDoubleSlab);
		 * registerBlock(steelPlatedStoneBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)steelPlatedStoneBrickSingleSlab,
		 * (BlockSlab)steelPlatedStoneBrickDoubleSlab);
		 * bronzePlatedStoneBrickStairs = new
		 * EOBlockStairs(BronzePlatedStoneBrick,
		 * 0).setBlockName("bronzePlatedStoneBrickStairs");
		 * GameRegistry.registerBlock(bronzePlatedStoneBrickStairs,
		 * "stoneBrickStairsBronze"); bronzePlatedStoneBrickSingleSlab =
		 * (BlockSlab) new BronzePlatedStoneBrickSlab(false).setBlockName(
		 * "bronzePlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * bronzePlatedStoneBrickDoubleSlab = (BlockSlab) new
		 * BronzePlatedStoneBrickSlab
		 * (true).setBlockName("bronzePlatedStoneBrickDoubleSlab");
		 * registerBlock(bronzePlatedStoneBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedStoneBrickSingleSlab,
		 * (BlockSlab)bronzePlatedStoneBrickDoubleSlab);
		 * registerBlock(bronzePlatedStoneBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedStoneBrickSingleSlab,
		 * (BlockSlab)bronzePlatedStoneBrickDoubleSlab);
		 * tinPlatedGraniteBrickStairs = new EOBlockStairs(TinPlatedGranite,
		 * 0).setBlockName("tinPlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(tinPlatedGraniteBrickStairs,
		 * "graniteStairsTin"); tinPlatedGraniteBrickSingleSlab = (BlockSlab)
		 * new TinPlatedGraniteBrickSlab(false).setBlockName(
		 * "tinPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * tinPlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * TinPlatedGraniteBrickSlab
		 * (true).setBlockName("tinPlatedGraniteBrickDoubleSlab");
		 * registerBlock(tinPlatedGraniteBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)tinPlatedGraniteBrickDoubleSlab);
		 * registerBlock(tinPlatedGraniteBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)tinPlatedGraniteBrickSingleSlab,(BlockSlab)
		 * tinPlatedGraniteBrickDoubleSlab); steelPlatedGraniteBrickStairs = new
		 * EOBlockStairs(SteelPlatedGranite,
		 * 0).setBlockName("steelPlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(steelPlatedGraniteBrickStairs,
		 * "graniteBrickStairsSteel"); steelPlatedGraniteBrickSingleSlab =
		 * (BlockSlab) new SteelPlatedGraniteBrickSlab(false).setBlockName(
		 * "steelPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * steelPlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * SteelPlatedGraniteBrickSlab
		 * (true).setBlockName("steelPlatedGraniteBrickDoubleSlab");
		 * registerBlock(steelPlatedGraniteBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)steelPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)steelPlatedGraniteBrickDoubleSlab);
		 * registerBlock(steelPlatedGraniteBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)steelPlatedGraniteBrickSingleSlab,(BlockSlab)
		 * steelPlatedGraniteBrickDoubleSlab); bronzePlatedGraniteBrickStairs =
		 * new EOBlockStairs(BronzePlatedGranite,
		 * 0).setBlockName("bronzePlatedGraniteBrickStairs");
		 * GameRegistry.registerBlock(bronzePlatedGraniteBrickStairs,
		 * "graniteBrickStairsBronze"); bronzePlatedGraniteBrickSingleSlab =
		 * (BlockSlab) new BronzePlatedGraniteBrickSlab(false).setBlockName(
		 * "bronzePlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		 * bronzePlatedGraniteBrickDoubleSlab = (BlockSlab) new
		 * BronzePlatedGraniteBrickSlab
		 * (true).setBlockName("bronzePlatedGraniteBrickDoubleSlab");
		 * registerBlock(bronzePlatedGraniteBrickSingleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedGraniteBrickSingleSlab,
		 * (BlockSlab)bronzePlatedGraniteBrickDoubleSlab);
		 * registerBlock(bronzePlatedGraniteBrickDoubleSlab, EOItemSlab.class,
		 * (BlockSlab)bronzePlatedGraniteBrickSingleSlab,
		 * (BlockSlab)bronzePlatedGraniteBrickDoubleSlab);
		 */
		
		plutoniumInsulated = new BlockPlutoniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeMetal).setBlockName("plutoniumInsulated");
		GameRegistry.registerBlock(plutoniumInsulated, "plutoniumInsulated");
		uraniumInsulated = new BlockUraniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeMetal).setBlockName("uraniumInsulated");
		GameRegistry.registerBlock(uraniumInsulated, "uraniumInsulated");
		// magma = new
		// BlockMagma(EOConfig.magmaId).setHardness(100.0F).setLightOpacity(3).setBlockName("magma").setLightLevel(1F);
		
		soulBlock = new BlockSoulBlock().setBlockName("block_SoulBlock").setHardness(65F).setResistance(30F).setLightLevel(1F).setBlockTextureName(MAssetManager.getEOTexture("blockSoulGem"));
		GameRegistry.registerBlock(soulBlock, "blockSoul");
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
	
	public static void addSlabs()
	{
		/*
		 * Item.itemsList[RadiantQuartzSingleSlab.blockID] = (new
		 * ItemSlab(RadiantQuartzSingleSlab.blockID - 256,
		 * (BlockSlab)RadiantQuartzSingleSlab,
		 * (BlockSlab)RadiantQuartzDoubleSlab, false));
		 * Item.itemsList[PinkQuartzSingleSlab.blockID] = (new
		 * ItemSlab(PinkQuartzSingleSlab.blockID - 256,
		 * (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab,
		 * false)); Item.itemsList[graniteBrickSingleSlab.blockID] = (new
		 * ItemSlab(graniteBrickSingleSlab.blockID - 256,
		 * (BlockSlab)graniteBrickSingleSlab, (BlockSlab)graniteBrickDoubleSlab,
		 * false)); Item.itemsList[tinPlatedCobbleSingleSlab.blockID] = (new
		 * ItemSlab(tinPlatedCobbleSingleSlab.blockID - 256,
		 * (BlockSlab)tinPlatedCobbleSingleSlab,
		 * (BlockSlab)tinPlatedCobbleDoubleSlab, false));
		 * Item.itemsList[steelPlatedCobbleSingleSlab.blockID] = (new
		 * ItemSlab(steelPlatedCobbleSingleSlab.blockID - 256,
		 * (BlockSlab)steelPlatedCobbleSingleSlab,
		 * (BlockSlab)steelPlatedCobbleDoubleSlab, false));
		 * Item.itemsList[bronzePlatedCobbleSingleSlab.blockID] = (new
		 * ItemSlab(bronzePlatedCobbleSingleSlab.blockID - 256,
		 * (BlockSlab)bronzePlatedCobbleSingleSlab,
		 * (BlockSlab)bronzePlatedCobbleDoubleSlab, false));
		 * Item.itemsList[tinPlatedStoneBrickSingleSlab.blockID] = (new
		 * ItemSlab(tinPlatedStoneBrickSingleSlab.blockID - 256,
		 * (BlockSlab)tinPlatedStoneBrickSingleSlab,
		 * (BlockSlab)tinPlatedStoneBrickDoubleSlab, false));
		 * Item.itemsList[steelPlatedStoneBrickSingleSlab.blockID] = (new
		 * ItemSlab(steelPlatedStoneBrickSingleSlab.blockID - 256,
		 * (BlockSlab)steelPlatedStoneBrickSingleSlab,
		 * (BlockSlab)steelPlatedStoneBrickDoubleSlab, false));
		 * Item.itemsList[bronzePlatedStoneBrickSingleSlab.blockID] = (new
		 * ItemSlab(bronzePlatedStoneBrickSingleSlab.blockID - 256,
		 * (BlockSlab)bronzePlatedStoneBrickSingleSlab,
		 * (BlockSlab)bronzePlatedStoneBrickDoubleSlab, false));
		 * Item.itemsList[tinPlatedGraniteBrickSingleSlab.blockID] = (new
		 * ItemSlab(tinPlatedGraniteBrickSingleSlab.blockID - 256,
		 * (BlockSlab)tinPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)tinPlatedGraniteBrickDoubleSlab, false));
		 * Item.itemsList[steelPlatedGraniteBrickSingleSlab.blockID] = (new
		 * ItemSlab(steelPlatedGraniteBrickSingleSlab.blockID - 256,
		 * (BlockSlab)steelPlatedGraniteBrickSingleSlab,
		 * (BlockSlab)steelPlatedGraniteBrickDoubleSlab, false));
		 * Item.itemsList[bronzePlatedGraniteBrickSingleSlab.blockID] = (new
		 * ItemSlab(bronzePlatedGraniteBrickSingleSlab.blockID - 256,
		 * (BlockSlab)bronzePlatedGraniteBrickSingleSlab,
		 * (BlockSlab)bronzePlatedGraniteBrickDoubleSlab, false));
		 */
	}
	
	public static void loadBridgedBlocks() throws Exception
	{
		if (Loader.isModLoaded("ExtraDecor"))
		{
			glowGlass = new BlockGlowGlass(Material.glass, true).setBlockName("block_GlowGlass").setLightLevel(0.7F).setStepSound(Block.soundTypeGlass).setHardness(.8F);
			GameRegistry.registerBlock(glowGlass, "block_GlowGlass");
		}
	}
	
	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass, Object... constructorArgs)
	{
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName(), null, constructorArgs);
	}
	
}
