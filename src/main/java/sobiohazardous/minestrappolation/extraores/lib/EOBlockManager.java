package sobiohazardous.minestrappolation.extraores.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extraores.CreativeTabExtraoresBlocks;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.BlockBlazium;
import sobiohazardous.minestrappolation.extraores.block.BlockBlaziumOre;
import sobiohazardous.minestrappolation.extraores.block.BlockCopper;
import sobiohazardous.minestrappolation.extraores.block.BlockCopperTarnished;
import sobiohazardous.minestrappolation.extraores.block.BlockDoorOverwrite;
import sobiohazardous.minestrappolation.extraores.block.BlockGlowGlass;
import sobiohazardous.minestrappolation.extraores.block.BlockGodstone;
import sobiohazardous.minestrappolation.extraores.block.BlockInvincium;
import sobiohazardous.minestrappolation.extraores.block.BlockMagma;
import sobiohazardous.minestrappolation.extraores.block.BlockMelter;
import sobiohazardous.minestrappolation.extraores.block.BlockNuke;
import sobiohazardous.minestrappolation.extraores.block.BlockPinkChiseled;
import sobiohazardous.minestrappolation.extraores.block.BlockPinkPillar;
import sobiohazardous.minestrappolation.extraores.block.BlockPlate;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumInsulated;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumOre;
import sobiohazardous.minestrappolation.extraores.block.BlockPlutoniumRaw;
import sobiohazardous.minestrappolation.extraores.block.BlockRadiantPillar;
import sobiohazardous.minestrappolation.extraores.block.BlockSoulBlock;
import sobiohazardous.minestrappolation.extraores.block.BlockSoulOre;
import sobiohazardous.minestrappolation.extraores.block.BlockSteel;
import sobiohazardous.minestrappolation.extraores.block.BlockSunstone;
import sobiohazardous.minestrappolation.extraores.block.BlockSunstoneOre;
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
import sobiohazardous.minestrappolation.extraores.item.ItemSoulGem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class EOBlockManager {
	
	//Bridged Blocks
	public static Block glowGlass;
	
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
	
	public static Block meuroditePlate;
	
	//public static Block magma;
	
	public static Block soulBlock;
	
	public static Block doorWoodOverwrite;
	
	public static void addBlocks()
	{
		meuroditeOre = (new EOBlock(EOConfig.meuroditeOreId, Material.rock)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_MeuroditeOre");
		meuroditeBlock = (new EOBlock(EOConfig.meuroditeBlockId, Material.iron)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Meurodite");
			
		UraniumOre = (new BlockUraniumOre(EOConfig.uraniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("UraniumOre");
	
		RawUraniumBlock = (new BlockUraniumRaw(EOConfig.rawUraniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawUraniumBlock");
		
		PlutoniumOre = (new BlockPlutoniumOre(EOConfig.plutoniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("PlutoniumOre").setCreativeTab(tabOresBlocks);
		
		RawPlutoniumBlock = (new BlockPlutoniumRaw(EOConfig.rawPlutoniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawPlutoniumBlock");
		
		TitaniumOre = (new EOBlock(EOConfig.titaniumOreId, Material.rock)).setHardness(10F).setResistance(15F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TitaniumOre");
		
		TitaniumBlock = (new EOBlock(EOConfig.titaniumBlockId, Material.iron)).setHardness(10F).setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Titanium");
		
		Sunstone = (new BlockSunstone(EOConfig.sunstoneId,Material.glass)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setCreativeTab(tabOresBlocks).setLightValue(1.0F).setUnlocalizedName("Sunstone");
		
		SunstoneOre = (new BlockSunstoneOre(EOConfig.sunstoneOreId)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_SunstoneOre").setLightValue(1F);
		//Old Sunstone Ore code: SunstoneOre = (new BlockSunstoneOre(212, 40)).setHardness(7F).setStepSound(Block.soundStoneFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(1.0F).setBlockName("Sunstone Ore");
		
		ToriteOre = (new EOBlock(EOConfig.toriteOreId, Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_ToriteOre");
		
		ToriteBlock = (new EOBlock(EOConfig.toriteBlockId, Material.iron)).setHardness(6F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Torite");
	
		Granite = (new EOBlock(EOConfig.graniteId, Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_Granite");
		GraniteBrick = (new EOBlock(EOConfig.graniteBrickId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_GraniteBrick");
		
		Quartzite = (new EOBlock(EOConfig.quartziteId, Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_PinkQuartzRaw");
		QuartziteTile = (new EOBlock(EOConfig.quartziteTileId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_PinkQuartzTileRough");
	    SmoothQuartzite = (new EOBlock(EOConfig.smoothQuartziteId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_PinkQuartzSmooth");
		PillarQuartzite = (new BlockPinkPillar(EOConfig.pillarQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("QuartzitePillar");
		ChiseledQuartzite = (new BlockPinkChiseled(EOConfig.chiseledQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("ChiseledQuartzite");
		SmoothQuartzTile = (new EOBlock(EOConfig.smoothQuartzTileId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_PinkQuartzTileRefined");
		
		BlaziumOre = (new BlockBlaziumOre(EOConfig.blaziumOreId)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("block_BlaziumOre").setLightValue(0.5F);
		//Experimental Blazium Ore Code: BlaziumOre = (new BlockBlaziumOre(204, 5)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(0.5F).setBlockName("Blazium Ore");
		BlaziumBlock = (new BlockBlazium(EOConfig.blaziumBlockId, Material.iron)).setHardness(8F).setResistance(12F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("BlaziumBlock").setLightValue(0.7F);
		
		CopperOre = (new EOBlock(EOConfig.copperOreId, Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_CopperOre");
		CopperBlock = (new BlockCopper(EOConfig.copperBlockId, Material.iron)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlock");
		
		CopperBlockTarnished = (new BlockCopperTarnished(EOConfig.copperTarnishedId)).setHardness(6F).setResistance(12F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlockTarnished");
				
		TinOre = (new EOBlock(EOConfig.tinOreId, Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinOre");
		TinBlock = (new EOBlock(EOConfig.tinBlockId, Material.iron)).setHardness(3F).setResistance(2F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Tin");
		
		TinPlate = (new BlockPlate(EOConfig.tinPlateId)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Tin");
		BronzePlate = (new BlockPlate(EOConfig.bronzePlateId)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Bronze");
		SteelPlate = (new BlockPlate(EOConfig.steelPlateId)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelSide");
		meuroditePlate = (new BlockPlate(EOConfig.meuroditePlateID)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Meurodite");
		
		SteelBlock = (new BlockSteel(EOConfig.steelBlockId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setUnlocalizedName("SteelBlock");
		
		SoulOre = (new BlockSoulOre(EOConfig.soulOreId)).setHardness(2F).setResistance(3F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundSandFootstep).setUnlocalizedName("block_SoulOre");
		SoulGem = (new ItemSoulGem(EOConfig.soulGemId)).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("item_SoulGem");		
		
		TinPlatedCobble = (new EOBlock(EOConfig.tinPlatedCobbleId, Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinCobble");
		TinPlatedMossy = (new EOBlock(EOConfig.tinPlatedMossyId, Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinMossy");
		TinPlatedStoneBrick = (new EOBlock(EOConfig.tinPlatedStoneBrickId, Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinStoneBrick");
		TinPlatedChiseled = (new EOBlock(EOConfig.tinPlatedChiseledId, Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinChiseled");
		TinPlatedGranite = (new EOBlock(EOConfig.tinPlatedGraniteId, Material.rock)).setHardness(6F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_TinGraniteBrick");
	
		BronzeBlock = (new EOBlock(EOConfig.bronzeBlockId, Material.iron)).setHardness(7F).setResistance(20F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_Bronze");
		
		BronzePlatedCobble = (new EOBlock(EOConfig.bronzePlatedCobbleId, Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_BronzeCobble");
		BronzePlatedMossy = (new EOBlock(EOConfig.bronzePlatedMossyId, Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_BronzeMossy");
		BronzePlatedStoneBrick = (new EOBlock(EOConfig.bronzePlatedStoneBrickId, Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_BronzeStoneBrick");
		BronzePlatedChiseled = (new EOBlock(EOConfig.bronzePlatedChiseledId, Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_BronzeChiseled");
		BronzePlatedGranite = (new EOBlock(EOConfig.bronzePlatedGraniteId, Material.rock)).setHardness(6F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_BronzeGraniteBrick");
		
		Invincium = (new BlockInvincium(EOConfig.invinciumId, Material.rock)).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("block_Invincium");
		
		SteelPlatedCobble = (new EOBlock(EOConfig.steelPlatedCobbleId, Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelCobble");
		SteelPlatedMossy = (new EOBlock(EOConfig.steelPlatedMossyId, Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelMossy");
		SteelPlatedStoneBrick = (new EOBlock(EOConfig.steelPlatedStoneBrickId, Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelStoneBrick");
		SteelPlatedChiseled = (new EOBlock(EOConfig.steelPlatedChiseledId, Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelChiseled");
		SteelPlatedGranite = (new EOBlock(EOConfig.steelPlatedGraniteId, Material.rock)).setHardness(6F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_SteelGraniteBrick");	
		
		SoulBottle = (new ItemSoulBottle(EOConfig.soulBottleId)).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("SoulBottle");
		
		nuke = (new BlockNuke(EOConfig.nukeId)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nuke");
		
		SmoothRadiantQuartz = (new EOBlock(EOConfig.smoothRadiantQuartzId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("block_SmoothRadiantQuartz");
		ChiseledRadiantQuartz = (new EOBlock(EOConfig.chiseledRadiantQuartzId, Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("block_ChiseledRadiantQuartz");
		PillarRadiantQuartz = (new BlockRadiantPillar(EOConfig.pillarRadiantQuartzId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("PillarRadiantQuartz");
		RadiantQuartzOre = (new EOBlock(EOConfig.radiantQuartzOreId, Material.rock)).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(tabOresBlocks).setLightValue(0.4F).setUnlocalizedName("block_RadiantQuartzOre");
		
		RadiantQuartz = (new EItemFoiled(EOConfig.radiantQuartzId)).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("item_RadiantQuartz");
		
		Godstone = (new BlockGodstone(EOConfig.godstoneId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setLightValue(1F).setUnlocalizedName("Godstone");
		
		melterIdle = (new BlockMelter(EOConfig.melterIdleId, false)).setHardness(6F).setResistance(8.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter");
		melterBurning = (new BlockMelter(EOConfig.melterBurningId, true)).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter").setLightValue(1F);
	
		RadiantQuartzStairs = new EOBlockStairs(EOConfig.radiantQuartzStairsId, SmoothRadiantQuartz, 0).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzStairs");
		RadiantQuartzSingleSlab = (BlockHalfSlab) new RadiantQuartzSlab(EOConfig.radiantQuartzSingleSlabId, false).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		RadiantQuartzDoubleSlab = (BlockHalfSlab) new RadiantQuartzSlab(EOConfig.radiantQuartzDoubleSlabId, true).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzDoubleSlab");
	
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
		
		tinPlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.tinPlatedGraniteBrickStairsId, TinPlatedGranite, 0).setUnlocalizedName("tinPlatedGraniteBrickStairs");
		tinPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(EOConfig.tinPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("tinPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(EOConfig.tinPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("tinPlatedGraniteBrickDoubleSlab");
		
		steelPlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.steelPlatedGraniteBrickStairsId, SteelPlatedGranite, 0).setUnlocalizedName("steelPlatedGraniteBrickStairs");
		steelPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(EOConfig.steelPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("steelPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(EOConfig.steelPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("steelPlatedGraniteBrickDoubleSlab");
		
		bronzePlatedGraniteBrickStairs = new EOBlockStairs(EOConfig.bronzePlatedGraniteBrickStairsId, BronzePlatedGranite, 0).setUnlocalizedName("bronzePlatedGraniteBrickStairs");
		bronzePlatedGraniteBrickSingleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(EOConfig.bronzePlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("bronzePlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(EOConfig.bronzePlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("bronzePlatedGraniteBrickDoubleSlab");
		
		plutoniumInsulated = (new BlockPlutoniumInsulated(EOConfig.plutoniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("plutoniumInsulated");
		uraniumInsulated = (new BlockUraniumInsulated(EOConfig.uraniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("uraniumInsulated");      
	
		//magma = new BlockMagma(EOConfig.magmaId).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("magma").setLightValue(1F);
		
		soulBlock = new BlockSoulBlock(EOConfig.soulBlockId).setUnlocalizedName("block_SoulBlock").setHardness(65F).setResistance(30F).setLightValue(1F);
	}
	
	public static void loadVanillaOverwrites()
	{
		/*
		Block.blocksList[Block.doorWood.blockID] = null;
		doorWoodOverwrite = new BlockDoorOverwrite(64, Material.wood).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("doorWood").setTextureName("door_wood");
		GameRegistry.registerBlock(doorWoodOverwrite, "doorWood");
		*/
	}
	
	public static void addSlabs()
	{
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
	
	public static void loadBridgedBlocks() throws Exception{
		if(Loader.isModLoaded("ExtraDecor")){
			glowGlass = new BlockGlowGlass(EOConfig.glowGlassID,Material.glass,true).setUnlocalizedName("block_GlowGlass").setLightValue(0.7F).setStepSound(Block.soundGlassFootstep).setHardness(.8F);
			GameRegistry.registerBlock(glowGlass,"block_GlowGlass");
			LanguageRegistry.addName(glowGlass, "Glow Glass");
		}
	
	}

}
