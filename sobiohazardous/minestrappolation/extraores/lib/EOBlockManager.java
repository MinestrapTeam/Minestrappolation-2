package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.CreativeTabExtraoresBlocks;
import sobiohazardous.minestrappolation.extraores.EOConfig;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.BlockBlazium;
import sobiohazardous.minestrappolation.extraores.block.BlockCopper;
import sobiohazardous.minestrappolation.extraores.block.BlockCopperTarnished;
import sobiohazardous.minestrappolation.extraores.block.BlockGodstone;
import sobiohazardous.minestrappolation.extraores.block.BlockMelter;
import sobiohazardous.minestrappolation.extraores.block.BlockNuke;
import sobiohazardous.minestrappolation.extraores.block.BlockPinkChiseled;
import sobiohazardous.minestrappolation.extraores.block.BlockPinkPillar;
import sobiohazardous.minestrappolation.extraores.block.BlockPlate;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumInsulated;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumOre;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumRaw;
import sobiohazardous.minestrappolation.extraores.block.BlockRadiantPillar;
import sobiohazardous.minestrappolation.extraores.block.BlockSteel;
import sobiohazardous.minestrappolation.extraores.block.BlockSunstone;
import sobiohazardous.minestrappolation.extraores.block.BlockUraniumInsulated;
import sobiohazardous.minestrappolation.extraores.block.BlockUraniumOre;
import sobiohazardous.minestrappolation.extraores.block.BlockUraniumRaw;
import sobiohazardous.minestrappolation.extraores.block.BronzePlatedCobbleSlab;
import sobiohazardous.minestrappolation.extraores.block.BronzePlatedGraniteBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.BronzePlatedStoneBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.EOBlock;
import sobiohazardous.minestrappolation.extraores.block.EOBlockStairs;
import sobiohazardous.minestrappolation.extraores.block.GraniteBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.PinkQuartzSlab;
import sobiohazardous.minestrappolation.extraores.block.RadiantQuartzSlab;
import sobiohazardous.minestrappolation.extraores.block.SteelPlatedCobbleSlab;
import sobiohazardous.minestrappolation.extraores.block.SteelPlatedGraniteBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.SteelPlatedStoneBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.TinPlatedCobbleSlab;
import sobiohazardous.minestrappolation.extraores.block.TinPlatedGraniteBrickSlab;
import sobiohazardous.minestrappolation.extraores.block.TinPlatedStoneBrickSlab;
import sobiohazardous.minestrappolation.extraores.item.EItemFoiled;
import sobiohazardous.minestrappolation.extraores.item.ItemSoulBottle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class EOBlockManager {
	
	public static CreativeTabs tabOresBlocks = new CreativeTabExtraoresBlocks(CreativeTabs.getNextID(),"Extrappolated Ores - Blocks");
	public static Block meuroditeOre;
	public static Block meuroditeBlock;
	

	
	public static  Block UraniumOre;
	
	public static Block RawUraniumBlock;
	
	public static Block PlutoniumOre;

	public static Block RawPlutoniumBlock;
	
	public static Block TitaniumOre;

	
	public static Block TitaniumBlock;
	
	public static Block Sunstone;
	
	public static Block SunstoneOre;
	
	public static Block ToriteOre; 

	public static Block ToriteBlock;
	
	
	
	public static Block Granite;
	public static Block GraniteBrick;
	
	public static Block Quartzite;
	public static Block QuartziteTile;
	
	public static Block BlaziumOre;
	public static Block BlaziumBlock;

	
	public static Block CopperOre;
	public static Block CopperBlock;

	
	public static  Block CopperBlockTarnished;
	
	
	public static Block TinOre;
	
	public static Block TinBlock;
	
	

	public static Item SoulGem;
	public static Block TinPlate;
	public static Block BronzePlate;
	public static Block SteelPlate;
	public static Block SteelBlock;
	public static Block SoulOre;
	
	
	public static Block SmoothQuartzite;
	public static Block PillarQuartzite;
	public static Block ChiseledQuartzite;
	public static Block SmoothQuartzTile;
	
	public static Block TinPlatedCobble;
	public static Block TinPlatedMossy;
	public static Block TinPlatedStoneBrick;
	public static Block TinPlatedChiseled;
	public static Block TinPlatedGranite;
	
	
	public static Block BronzeBlock;
	
	public static Block BronzePlatedCobble;
	public static Block BronzePlatedMossy;
	public static Block BronzePlatedStoneBrick;
	public static Block BronzePlatedChiseled;
	public static Block BronzePlatedGranite;
	
	public static Block Invincium;

	
	
	public static Block SteelPlatedCobble;
	public static Block SteelPlatedMossy;
	public static Block SteelPlatedStoneBrick;
	public static Block SteelPlatedChiseled;
	public static Block SteelPlatedGranite;
	
	
	
	public static Item SoulBottle;
	
	public static Block nuke;
	
	
	public static Block SmoothRadiantQuartz;
	public static Block ChiseledRadiantQuartz;
	public static Block PillarRadiantQuartz;
	public static Block RadiantQuartzOre;
	
	public static Item RadiantQuartz;
	
	public static Block Godstone;
	
	public static Block melterIdle;
	public static Block melterBurning;
	
	public static Block RadiantQuartzStairs;
	public static BlockHalfSlab RadiantQuartzSingleSlab;
	public static BlockHalfSlab RadiantQuartzDoubleSlab;
	
	public static Block PinkQuartzStairs;
	public static BlockHalfSlab PinkQuartzSingleSlab;
	public static BlockHalfSlab PinkQuartzDoubleSlab;
	
	public static Block graniteBrickStairs;
	public static BlockHalfSlab graniteBrickSingleSlab;
	public static BlockHalfSlab graniteBrickDoubleSlab;
	
	public static Block tinPlatedCobbleStairs;
	public static BlockHalfSlab tinPlatedCobbleSingleSlab;
	public static BlockHalfSlab tinPlatedCobbleDoubleSlab;
	
	public static Block steelPlatedCobbleStairs;
	public static BlockHalfSlab steelPlatedCobbleSingleSlab;
	public static BlockHalfSlab steelPlatedCobbleDoubleSlab;
	
	public static Block bronzePlatedCobbleStairs;
	public static BlockHalfSlab bronzePlatedCobbleSingleSlab;
	public static BlockHalfSlab bronzePlatedCobbleDoubleSlab;
	
	public static Block tinPlatedStoneBrickStairs;
	public static BlockHalfSlab tinPlatedStoneBrickSingleSlab;
	public static BlockHalfSlab tinPlatedStoneBrickDoubleSlab;
	
	public static Block steelPlatedStoneBrickStairs;
	public static BlockHalfSlab steelPlatedStoneBrickSingleSlab;
	public static BlockHalfSlab steelPlatedStoneBrickDoubleSlab;
	
	public static Block bronzePlatedStoneBrickStairs;
	public static BlockHalfSlab bronzePlatedStoneBrickSingleSlab;
	public static BlockHalfSlab bronzePlatedStoneBrickDoubleSlab;
	
	public static Block tinPlatedGraniteBrickStairs;
	public static BlockHalfSlab tinPlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab tinPlatedGraniteBrickDoubleSlab;
	
	public static Block steelPlatedGraniteBrickStairs;
	public static BlockHalfSlab steelPlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab steelPlatedGraniteBrickDoubleSlab;
	
	public static Block bronzePlatedGraniteBrickStairs;
	public static BlockHalfSlab bronzePlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab bronzePlatedGraniteBrickDoubleSlab;
	
	public static Block plutoniumInsulated;
	public static Block uraniumInsulated;
	
	public void addBlocks(){

		meuroditeOre = (new EOBlock(EOConfig.meuroditeOreId, "block_MeuroditeOre", Material.rock)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MeuroditeOre");
		meuroditeBlock = (new EOBlock(EOConfig.meuroditeBlockId, "block_Meurodite", Material.iron)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MeuroditeBlock");
		
			
		UraniumOre = (new BlockUraniumOre(EOConfig.uraniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("UraniumOre");
	
		RawUraniumBlock = (new BlockUraniumRaw(EOConfig.rawUraniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawUraniumBlock");
		
		PlutoniumOre = (new BlockPlutoniumOre(EOConfig.plutoniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("PlutoniumOre").setCreativeTab(tabOresBlocks);
		
		RawPlutoniumBlock = (new BlockPlutoniumRaw(EOConfig.rawPlutoniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawPlutoniumBlock");
		
		TitaniumOre = (new EOBlock(EOConfig.titaniumOreId, "block_TitaniumOre", Material.rock)).setHardness(10F).setResistance(15F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TitaniumOre");
		
		TitaniumBlock = (new EOBlock(EOConfig.titaniumBlockId, "block_Titanium", Material.iron)).setHardness(10F).setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Titanium Block");
		
		Sunstone = (new BlockSunstone(EOConfig.sunstoneId,Material.glass)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setCreativeTab(tabOresBlocks).setLightValue(1.0F).setUnlocalizedName("Sunstone");
		
		SunstoneOre = (new EOBlock(EOConfig.sunstoneOreId, "block_SunstoneOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("SunstoneOre").setLightValue(1F);
		//Old Sunstone Ore code: SunstoneOre = (new BlockSunstoneOre(212, 40)).setHardness(7F).setStepSound(Block.soundStoneFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(1.0F).setBlockName("Sunstone Ore");
		
		ToriteOre = (new EOBlock(EOConfig.toriteOreId, "block_ToriteOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("ToriteOre");
		
		ToriteBlock = (new EOBlock(EOConfig.toriteBlockId, "block_Torite", Material.iron)).setHardness(6F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("ToriteBlock");
	
		Granite = (new EOBlock(EOConfig.graniteId, "block_Granite", Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("Granite");
		GraniteBrick = (new EOBlock(EOConfig.graniteBrickId, "block_GraniteBrick", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("GraniteBrick");
		
		Quartzite = (new EOBlock(EOConfig.quartziteId, "block_PinkQuartzRaw", Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("Quartzite");
		QuartziteTile = (new EOBlock(EOConfig.quartziteTileId, "block_PinkQuartzTileRough", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("QuartziteTile");
	    SmoothQuartzite = (new EOBlock(EOConfig.smoothQuartziteId, "block_PinkQuartzSmooth", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("SmoothQuartzite");
		PillarQuartzite = (new BlockPinkPillar(EOConfig.pillarQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("QuartzitePillar");
		ChiseledQuartzite = (new BlockPinkChiseled(EOConfig.chiseledQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("ChiseledQuartzite");
		SmoothQuartzTile = (new EOBlock(EOConfig.smoothQuartzTileId, "block_PinkQuartzTileRefined", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("SmoothQuartzTile");
		
		BlaziumOre = (new EOBlock(EOConfig.blaziumOreId, "block_BlaziumOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("BlaziumOre").setLightValue(0.5F);
		//Experimental Blazium Ore Code: BlaziumOre = (new BlockBlaziumOre(204, 5)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(0.5F).setBlockName("Blazium Ore");
		BlaziumBlock = (new BlockBlazium(EOConfig.blaziumBlockId, Material.iron)).setHardness(8F).setResistance(12F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("BlaziumBlock").setLightValue(0.7F);
		
		CopperOre = (new EOBlock(EOConfig.copperOreId, "block_CopperOre", Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperOre");
		CopperBlock = (new BlockCopper(EOConfig.copperBlockId, Material.iron)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlock");
		
		CopperBlockTarnished = (new BlockCopperTarnished(EOConfig.copperTarnishedId)).setHardness(6F).setResistance(12F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlockTarnished");
		
		
		TinOre = (new EOBlock(EOConfig.tinOreId, "block_TinOre", Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinOre");
		TinBlock = (new EOBlock(EOConfig.tinBlockId, "block_Tin", Material.iron)).setHardness(3F).setResistance(2F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinBlock");
		
		TinPlate = (new BlockPlate(EOConfig.tinPlateId,"block_Tin")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlate");
		BronzePlate = (new BlockPlate(EOConfig.bronzePlateId, "block_Bronze")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlate");
		SteelPlate = (new BlockPlate(EOConfig.steelPlateId, "block_SteelSide")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlate");
		
	
		SteelBlock = (new BlockSteel(EOConfig.steelBlockId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("SteelBlock");
		
		SoulOre = (new EOBlock(EOConfig.soulOreId, "block_SoulOre", Material.sand)).setHardness(2F).setResistance(3F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundSandFootstep).setUnlocalizedName("SoulOre");
		SoulGem = (new EItemFoiled(EOConfig.soulGemId, "item_SoulGem")).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("SoulGem");
		
		
		TinPlatedCobble = (new EOBlock(EOConfig.tinPlatedCobbleId, "block_TinCobble", Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedCobble");
		TinPlatedMossy = (new EOBlock(EOConfig.tinPlatedMossyId, "block_TinMossy", Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedMossy");
		TinPlatedStoneBrick = (new EOBlock(EOConfig.tinPlatedStoneBrickId, "block_TinStoneBrick", Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedStoneBrick");
		TinPlatedChiseled = (new EOBlock(EOConfig.tinPlatedChiseledId, "block_TinChiseled", Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedChiseled");
		TinPlatedGranite = (new EOBlock(EOConfig.tinPlatedGraniteId,"block_TinGraniteBrick", Material.rock)).setHardness(6F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedGranite");
	
		BronzeBlock = (new EOBlock(EOConfig.bronzeBlockId, "block_Bronze", Material.iron)).setHardness(7F).setResistance(20F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzeBlock");
		
		BronzePlatedCobble = (new EOBlock(EOConfig.bronzePlatedCobbleId, "block_BronzeCobble", Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedCobble");
		BronzePlatedMossy = (new EOBlock(EOConfig.bronzePlatedMossyId, "block_BronzeMossy", Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedMossy");
		BronzePlatedStoneBrick = (new EOBlock(EOConfig.bronzePlatedStoneBrickId, "block_BronzeStoneBrick", Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedStoneBrick");
		BronzePlatedChiseled = (new EOBlock(EOConfig.bronzePlatedChiseledId, "block_BronzeChiseled", Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedChiseled");
		BronzePlatedGranite = (new EOBlock(EOConfig.bronzePlatedGraniteId, "block_BronzeGraniteBrick", Material.rock)).setHardness(6F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedGranite");
		
		Invincium = (new EOBlock(EOConfig.invinciumId, "block_Invincium", Material.rock)).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Invincium");
		//Replacement block for vanilla Bedrock to make it breakable. Currently modifies net.minecraft.world.gen.ChunkProviderGenerate, net.minecraft.world.gen.ChunkProviderHell, and net.minecraft.world.gen.feature.WorldGenSpikes.
		//TODO: Find a solution to removing Bedrock invincibility that doesn't edit base classes.
		
		SteelPlatedCobble = (new EOBlock(EOConfig.steelPlatedCobbleId, "block_SteelCobble", Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedCobble");
		SteelPlatedMossy = (new EOBlock(EOConfig.steelPlatedMossyId, "block_SteelMossy", Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedMossy");
		SteelPlatedStoneBrick = (new EOBlock(EOConfig.steelPlatedStoneBrickId, "block_SteelStoneBrick", Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedStoneBrick");
		SteelPlatedChiseled = (new EOBlock(EOConfig.steelPlatedChiseledId, "block_SteelChiseled", Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedChiseled");
		SteelPlatedGranite = (new EOBlock(EOConfig.steelPlatedGraniteId, "block_SteelGraniteBrick", Material.rock)).setHardness(6F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedGranite");
		
		
		SoulBottle = (new ItemSoulBottle(EOConfig.soulBottleId)).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("SoulBottle");
		
		nuke = (new BlockNuke(EOConfig.nukeId)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nuke");
		
		SmoothRadiantQuartz = (new EOBlock(EOConfig.smoothRadiantQuartzId, "block_SmoothRadiantQuartz", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("SmoothRadiantQuartz");
		ChiseledRadiantQuartz = (new EOBlock(EOConfig.chiseledRadiantQuartzId, "block_ChiseledRadiantQuartz", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("ChiseledRadiantQuartz");
		PillarRadiantQuartz = (new BlockRadiantPillar(EOConfig.pillarRadiantQuartzId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("PillarRadiantQuartz");
		RadiantQuartzOre = (new EOBlock(EOConfig.radiantQuartzOreId, "block_RadiantQuartzOre", Material.rock)).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.4F).setUnlocalizedName("RadiantQuartzOre");
		
		RadiantQuartz = (new EItemFoiled(EOConfig.radiantQuartzId, "item_RadiantQuartz")).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("RadiantQuartz");
		
		Godstone = (new BlockGodstone(EOConfig.godstoneId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setLightValue(1F).setUnlocalizedName("Godstone");
		
		melterIdle = (new BlockMelter(EOConfig.melterIdleId, false)).setHardness(6F).setResistance(8.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter");
		melterBurning = (new BlockMelter(EOConfig.melterBurningId, true)).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter");
	
		RadiantQuartzStairs = new EOBlockStairs(EOConfig.radiantQuartzStairsId, SmoothRadiantQuartz, 0).setUnlocalizedName("RadiantQuartzStairs");
		RadiantQuartzSingleSlab = (BlockHalfSlab) new RadiantQuartzSlab(EOConfig.radiantQuartzSingleSlabId, false).setUnlocalizedName("RadiantQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		RadiantQuartzDoubleSlab = (BlockHalfSlab) new RadiantQuartzSlab(EOConfig.radiantQuartzDoubleSlabId, true).setUnlocalizedName("RadiantQuartzDoubleSlab");
	
		PinkQuartzStairs = new EOBlockStairs(EOConfig.pinkQuartzStairsId, SmoothQuartzite, 0).setUnlocalizedName("PinkQuartzStairs");
		PinkQuartzSingleSlab = (BlockHalfSlab) new PinkQuartzSlab(EOConfig.pinkQuartzSingleSlabId, false).setUnlocalizedName("PinkQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		PinkQuartzDoubleSlab = (BlockHalfSlab) new PinkQuartzSlab(EOConfig.pinkQuartzDoubleSlabId, true).setUnlocalizedName("PinkQuartzDoubleSlab");
		
		graniteBrickStairs = new EOBlockStairs(EOConfig.graniteBrickStairsId, GraniteBrick, 0).setUnlocalizedName("graniteBrickStairs");
		graniteBrickSingleSlab = (BlockHalfSlab) new GraniteBrickSlab(EOConfig.graniteBrickSingleSlabId, false).setUnlocalizedName("graniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		graniteBrickDoubleSlab = (BlockHalfSlab) new GraniteBrickSlab(EOConfig.graniteBrickDoubleSlabId, true).setUnlocalizedName("graniteBrickDoubleSlab");
		
		tinPlatedCobbleStairs = new EOBlockStairs(EOConfig.tinPlatedCobbleStairsId, TinPlatedCobble, 0).setUnlocalizedName("tinPlatedCobbleStairs");
		tinPlatedCobbleSingleSlab = (BlockHalfSlab) new TinPlatedCobbleSlab(EOConfig.tinPlatedCobbleSingleSlabId, false).setUnlocalizedName("tinPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedCobbleDoubleSlab = (BlockHalfSlab) new TinPlatedCobbleSlab(EOConfig.tinPlatedCobbleDoubleSlabId, true).setUnlocalizedName("tinPlatedCobbleDoubleSlab");
		
		steelPlatedCobbleStairs = new EOBlockStairs(EOConfig.steelPlatedCobbleStairsId, SteelPlatedCobble, 0).setUnlocalizedName("steelPlatedCobbleStairs");
		steelPlatedCobbleSingleSlab = (BlockHalfSlab) new SteelPlatedCobbleSlab(EOConfig.steelPlatedCobbleSingleSlabId, false).setUnlocalizedName("steelPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedCobbleDoubleSlab = (BlockHalfSlab) new SteelPlatedCobbleSlab(EOConfig.steelPlatedCobbleDoubleSlabId, true).setUnlocalizedName("steelPlatedCobbleDoubleSlab");
		
		bronzePlatedCobbleStairs = new EOBlockStairs(EOConfig.bronzePlatedCobbleStairsId, BronzePlatedCobble, 0).setUnlocalizedName("bronzePlatedCobbleStairs");
		bronzePlatedCobbleSingleSlab = (BlockHalfSlab) new BronzePlatedCobbleSlab(EOConfig.bronzePlatedCobbleSingleSlabId, false).setUnlocalizedName("bronzePlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedCobbleDoubleSlab = (BlockHalfSlab) new BronzePlatedCobbleSlab(EOConfig.bronzePlatedCobbleDoubleSlabId, true).setUnlocalizedName("bronzePlatedCobbleDoubleSlab");
		
		tinPlatedStoneBrickStairs = new EOBlockStairs(EOConfig.tinPlatedStoneBrickStairsId, TinPlatedStoneBrick, 0).setUnlocalizedName("tinPlatedStoneBrickStairs");
		tinPlatedStoneBrickSingleSlab = (BlockHalfSlab) new TinPlatedStoneBrickSlab(EOConfig.tinPlatedStoneBrickSingleSlabId, false).setUnlocalizedName("tinPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedStoneBrickDoubleSlab = (BlockHalfSlab) new TinPlatedStoneBrickSlab(EOConfig.tinPlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("tinPlatedStoneBrickDoubleSlab");
		
		steelPlatedStoneBrickStairs = new EOBlockStairs(EOConfig.steelPlatedStoneBrickStairsId, SteelPlatedStoneBrick, 0).setUnlocalizedName("steelPlatedStoneBrickStairs");
		steelPlatedStoneBrickSingleSlab = (BlockHalfSlab) new SteelPlatedStoneBrickSlab(EOConfig.steelPlatedStoneBrickSingleSlabId, false).setUnlocalizedName("steelPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedStoneBrickDoubleSlab = (BlockHalfSlab) new SteelPlatedStoneBrickSlab(EOConfig.steelPlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("steelPlatedStoneBrickDoubleSlab");
		
		bronzePlatedStoneBrickStairs = new EOBlockStairs(EOConfig.bronzePlatedStoneBrickStairsId, BronzePlatedStoneBrick, 0).setUnlocalizedName("bronzePlatedStoneBrickStairs");
		bronzePlatedStoneBrickSingleSlab = (BlockHalfSlab) new BronzePlatedStoneBrickSlab(EOConfig.bronzePlatedStoneBrickSingleSlabId, false).setUnlocalizedName("bronzePlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedStoneBrickDoubleSlab = (BlockHalfSlab) new BronzePlatedStoneBrickSlab(EOConfig.bronzePlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("bronzePlatedStoneBrickDoubleSlab");
		
		tinPlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.tinPlatedGraniteBrickStairsId, this.TinPlatedGranite, 0).setUnlocalizedName("tinPlatedGraniteBrickStairs");
		tinPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(EOConfig.tinPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("tinPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(EOConfig.tinPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("tinPlatedGraniteBrickDoubleSlab");
		
		steelPlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.steelPlatedGraniteBrickStairsId, this.SteelPlatedGranite, 0).setUnlocalizedName("steelPlatedGraniteBrickStairs");
		steelPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(EOConfig.steelPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("steelPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(EOConfig.steelPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("steelPlatedGraniteBrickDoubleSlab");
		
		bronzePlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.bronzePlatedGraniteBrickStairsId, this.BronzePlatedGranite, 0).setUnlocalizedName("bronzePlatedGraniteBrickStairs");
		bronzePlatedGraniteBrickSingleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(EOConfig.bronzePlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("bronzePlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(EOConfig.bronzePlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("bronzePlatedGraniteBrickDoubleSlab");
		
		plutoniumInsulated = (new BlockPlutoniumInsulated(EOConfig.plutoniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("plutoniumInsulated");
		uraniumInsulated = (new BlockUraniumInsulated(EOConfig.uraniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("uraniumInsulated");
          
	}
	
	public static void addSlabs(){
		Item.itemsList[RadiantQuartzSingleSlab.blockID] = (new ItemSlab(RadiantQuartzSingleSlab.blockID - 256, (BlockHalfSlab)RadiantQuartzSingleSlab, (BlockHalfSlab)RadiantQuartzDoubleSlab, false));
		Item.itemsList[PinkQuartzSingleSlab.blockID] = (new ItemSlab(PinkQuartzSingleSlab.blockID - 256, (BlockHalfSlab)PinkQuartzSingleSlab, (BlockHalfSlab)PinkQuartzDoubleSlab, false));
		Item.itemsList[graniteBrickSingleSlab.blockID] = (new ItemSlab(graniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)graniteBrickSingleSlab, (BlockHalfSlab)graniteBrickDoubleSlab, false));
		Item.itemsList[tinPlatedCobbleSingleSlab.blockID] = (new ItemSlab(tinPlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedCobbleSingleSlab, (BlockHalfSlab)tinPlatedCobbleDoubleSlab, false));
		Item.itemsList[steelPlatedCobbleSingleSlab.blockID] = (new ItemSlab(steelPlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedCobbleSingleSlab, (BlockHalfSlab)steelPlatedCobbleDoubleSlab, false));
		Item.itemsList[bronzePlatedCobbleSingleSlab.blockID] = (new ItemSlab(bronzePlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedCobbleSingleSlab, (BlockHalfSlab)bronzePlatedCobbleDoubleSlab, false));
		Item.itemsList[tinPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(tinPlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedStoneBrickSingleSlab, (BlockHalfSlab)tinPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[steelPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(steelPlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedStoneBrickSingleSlab, (BlockHalfSlab)steelPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[bronzePlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(bronzePlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedStoneBrickSingleSlab, (BlockHalfSlab)bronzePlatedStoneBrickDoubleSlab, false));
		Item.itemsList[tinPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(tinPlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedGraniteBrickSingleSlab, (BlockHalfSlab)tinPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[steelPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(steelPlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedGraniteBrickSingleSlab, (BlockHalfSlab)steelPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[bronzePlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(bronzePlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedGraniteBrickSingleSlab, (BlockHalfSlab)bronzePlatedGraniteBrickDoubleSlab, false));
	}

}
