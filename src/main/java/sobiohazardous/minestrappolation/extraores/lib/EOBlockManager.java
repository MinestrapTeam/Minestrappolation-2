package sobiohazardous.minestrappolation.extraores.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
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
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class EOBlockManager 
{	
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
	public static BlockSlab RadiantQuartzSingleSlab;
	public static BlockSlab RadiantQuartzDoubleSlab;
	
	public static Block PinkQuartzStairs;
	public static BlockSlab PinkQuartzSingleSlab;
	public static BlockSlab PinkQuartzDoubleSlab;
	
	public static Block graniteBrickStairs;
	public static BlockSlab graniteBrickSingleSlab;
	public static BlockSlab graniteBrickDoubleSlab;
	
	public static Block tinPlatedCobbleStairs;
	public static BlockSlab tinPlatedCobbleSingleSlab;
	public static BlockSlab tinPlatedCobbleDoubleSlab;
	
	public static Block steelPlatedCobbleStairs;
	public static BlockSlab steelPlatedCobbleSingleSlab;
	public static BlockSlab steelPlatedCobbleDoubleSlab;
	
	public static Block bronzePlatedCobbleStairs;
	public static BlockSlab bronzePlatedCobbleSingleSlab;
	public static BlockSlab bronzePlatedCobbleDoubleSlab;
	
	public static Block tinPlatedStoneBrickStairs;
	public static BlockSlab tinPlatedStoneBrickSingleSlab;
	public static BlockSlab tinPlatedStoneBrickDoubleSlab;
	
	public static Block steelPlatedStoneBrickStairs;
	public static BlockSlab steelPlatedStoneBrickSingleSlab;
	public static BlockSlab steelPlatedStoneBrickDoubleSlab;
	
	public static Block bronzePlatedStoneBrickStairs;
	public static BlockSlab bronzePlatedStoneBrickSingleSlab;
	public static BlockSlab bronzePlatedStoneBrickDoubleSlab;
	
	public static Block tinPlatedGraniteBrickStairs;
	public static BlockSlab tinPlatedGraniteBrickSingleSlab;
	public static BlockSlab tinPlatedGraniteBrickDoubleSlab;
	
	public static Block steelPlatedGraniteBrickStairs;
	public static BlockSlab steelPlatedGraniteBrickSingleSlab;
	public static BlockSlab steelPlatedGraniteBrickDoubleSlab;
	
	public static Block bronzePlatedGraniteBrickStairs;
	public static BlockSlab bronzePlatedGraniteBrickSingleSlab;
	public static BlockSlab bronzePlatedGraniteBrickDoubleSlab;
	
	public static Block plutoniumInsulated;
	public static Block uraniumInsulated;
	
	public static Block meuroditePlate;
	
	//public static Block magma;
	
	public static Block soulBlock;
	
	public static Block doorWoodOverwrite;
	
	public static void addBlocks()
	{
		meuroditeOre = (new EOBlock(Material.rock)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("oreMeurodite").setBlockTextureName(MAssetManager.getEOTexture("oreMeurodite"));
		meuroditeBlock = (new EOBlock(Material.iron)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("blockMeurodite").setBlockTextureName(MAssetManager.getEOTexture("blockMeurodite"));
			
		UraniumOre = (new BlockUraniumOre(Material.rock)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreUranium").setBlockTextureName(MAssetManager.getEOTexture("oreUranium"));
	
		RawUraniumBlock = (new BlockUraniumRaw(Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockUranium").setBlockTextureName(MAssetManager.getEOTexture("blockUranium"));
		
		PlutoniumOre = (new BlockPlutoniumOre(Material.rock)).setHardness(5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("orePlutonium").setBlockTextureName(MAssetManager.getEOTexture("orePlutonium")).setCreativeTab(tabOresBlocks);
		
		RawPlutoniumBlock = (new BlockPlutoniumRaw(Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockPlutonium").setBlockTextureName(MAssetManager.getEOTexture("blockPlutonium"));
		
		TitaniumOre = (new EOBlock(Material.rock)).setHardness(10F).setResistance(15F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTitanium").setBlockTextureName(MAssetManager.getEOTexture("oreTitanium"));
		
		TitaniumBlock = (new EOBlock(Material.iron)).setHardness(10F).setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTitanium").setBlockTextureName(MAssetManager.getEOTexture("blockTitanium"));
		
		Sunstone = (new BlockSunstone(Material.glass)).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabOresBlocks).setLightValue(1.0F).setBlockName("blockSunstone").setBlockTextureName(MAssetManager.getEOTexture("blockSunstone"));
		
		SunstoneOre = (new BlockSunstoneOre()).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreSunstone").setBlockTextureName(MAssetManager.getEOTexture("oreSunstone")).setLightValue(1F);
		//Old Sunstone Ore code: SunstoneOre = (new BlockSunstoneOre(212, 40)).setHardness(7F).setStepSound(Block.soundStoneFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(1.0F).setBlockName("Sunstone Ore");
		
		ToriteOre = (new EOBlock(Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreTorite").setBlockTextureName(MAssetManager.getEOTexture("oreTorite"));
		
		ToriteBlock = (new EOBlock(Material.iron)).setHardness(6F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTorite").setBlockTextureName(MAssetManager.getEOTexture("blockTorite"));
	
		Granite = (new EOBlock(Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("graniteRaw").setBlockTextureName(MAssetManager.getEOTexture("Granite_Raw_0_0"));
		GraniteBrick = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("graniteBricks").setBlockTextureName(MAssetManager.getEOTexture("Granite_Bricks_0_0"));
		
		Quartzite = (new EOBlock(Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzRaw").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_Raw_0_0"));
		QuartziteTile = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzTilesRaw").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_TilesRaw_0_0"));
	    SmoothQuartzite = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzRefined").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_Refined_0_0"));
		PillarQuartzite = (new BlockPinkPillar()).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzPillar").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_Pillar_Side_0"));
		ChiseledQuartzite = (new BlockPinkChiseled()).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzChiseled").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_Chiseled_Side_0"));
		SmoothQuartzTile = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("desertQuartzTilesRefined").setBlockTextureName(MAssetManager.getEOTexture("DesertQuartz_TilesRefined_0_0"));
		
		BlaziumOre = (new BlockBlaziumOre()).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("oreBlazium").setBlockTextureName(MAssetManager.getEOTexture("oreBlazium")).setLightValue(0.5F);
		//Experimental Blazium Ore Code: BlaziumOre = (new BlockBlaziumOre(204, 5)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(0.5F).setBlockName("Blazium Ore");
		BlaziumBlock = (new BlockBlazium()).setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("blockBlazium").setBlockTextureName(MAssetManager.getEOTexture("blockBlazium")).setLightValue(0.7F);
		
		CopperOre = (new EOBlock(Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreCopper").setBlockTextureName(MAssetManager.getEOTexture("oreCopper"));
		CopperBlock = (new BlockCopper(Material.iron)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper").setBlockTextureName(MAssetManager.getEOTexture("blockCopper"));
		
		CopperBlockTarnished = (new BlockCopperTarnished()).setHardness(6F).setResistance(12F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopperTarnished").setBlockTextureName(MAssetManager.getEOTexture("blockCopperTarnishedTop"));
				
		TinOre = (new EOBlock(Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTin").setBlockTextureName(MAssetManager.getEOTexture("oreTin"));
		TinBlock = (new EOBlock(Material.iron)).setHardness(3F).setResistance(2F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTin").setBlockTextureName(MAssetManager.getEOTexture("blockTin"));
		
		TinPlate = (new BlockPlate()).setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingTin").setBlockTextureName(MAssetManager.getEOTexture("blockTin"));
		BronzePlate = (new BlockPlate()).setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingBronze").setBlockTextureName(MAssetManager.getEOTexture("blockBronze"));
		SteelPlate = (new BlockPlate()).setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingSteel").setBlockTextureName(MAssetManager.getEOTexture("blockSteelTop"));
		meuroditePlate = (new BlockPlate()).setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingMeurodite").setBlockTextureName(MAssetManager.getEOTexture("blockMeurodite"));
		
		SteelBlock = (new BlockSteel()).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setBlockName("blockSteel").setBlockTextureName(MAssetManager.getEOTexture("blockSteelTop"));
		
		SoulOre = (new BlockSoulOre()).setHardness(2F).setResistance(3F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreSoulGem").setBlockTextureName(MAssetManager.getEOTexture("oreSoulGem"));
		SoulGem = (new ItemSoulGem()).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("item_SoulGem");		
		
		TinPlatedCobble = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledTin").setBlockTextureName(MAssetManager.getEOTexture("Stone_Cobbled_0_Tin"));
		TinPlatedMossy = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneCobbledMossyTin").setBlockTextureName(MAssetManager.getEOTexture("Stone_CobbledMossy_0_Tin"));
		TinPlatedStoneBrick = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneBricksTin").setBlockTextureName(MAssetManager.getEOTexture("Stone_Bricks_0_Tin"));
		TinPlatedChiseled = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("stoneChiseledTin").setBlockTextureName(MAssetManager.getEOTexture("Stone_Chiseled_0_Tin"));
		TinPlatedGranite = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setBlockName("graniteBricksTin").setBlockTextureName(MAssetManager.getEOTexture("Granite_Bricks_0_Tin"));
	
		BronzeBlock = (new EOBlock(Material.iron)).setHardness(7F).setResistance(20F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_Bronze");
		
		BronzePlatedCobble = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_BronzeCobble");
		BronzePlatedMossy = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_BronzeMossy");
		BronzePlatedStoneBrick = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_BronzeStoneBrick");
		BronzePlatedChiseled = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_BronzeChiseled");
		BronzePlatedGranite = (new EOBlock(Material.rock)).setHardness(6F).setResistance(30.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_BronzeGraniteBrick");
		
		Invincium = (new BlockInvincium(Material.rock)).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_Invincium");
		
		SteelPlatedCobble = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_SteelCobble");
		SteelPlatedMossy = (new EOBlock(Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_SteelMossy");
		SteelPlatedStoneBrick = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_SteelStoneBrick");
		SteelPlatedChiseled = (new EOBlock(Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_SteelChiseled");
		SteelPlatedGranite = (new EOBlock(Material.rock)).setHardness(6F).setResistance(20.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("block_SteelGraniteBrick");	
		
		SoulBottle = (new ItemSoulBottle()).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("SoulBottle");
		
		nuke = (new BlockNuke()).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("nuke");
		
		SmoothRadiantQuartz = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("block_SmoothRadiantQuartz");
		ChiseledRadiantQuartz = (new EOBlock(Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("block_ChiseledRadiantQuartz");
		PillarRadiantQuartz = (new BlockRadiantPillar()).setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("PillarRadiantQuartz");
		RadiantQuartzOre = (new EOBlock(Material.rock)).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(tabOresBlocks).setLightValue(0.4F).setUnlocalizedName("block_RadiantQuartzOre");
		
		RadiantQuartz = (new EItemFoiled()).setCreativeTab(EOItemManager.tabOresItems).setUnlocalizedName("item_RadiantQuartz");
		
		Godstone = (new BlockGodstone(Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setLightValue(1F).setUnlocalizedName("Godstone");
		
		melterIdle = (new BlockMelter(false)).setHardness(6F).setResistance(8.0F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundTypeStone).setUnlocalizedName("melter");
		melterBurning = (new BlockMelter(true)).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("melter").setLightValue(1F);
	
		RadiantQuartzStairs = new EOBlockStairs(SmoothRadiantQuartz, 0).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzStairs");
		RadiantQuartzSingleSlab = (BlockSlab) new RadiantQuartzSlab(false).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		RadiantQuartzDoubleSlab = (BlockSlab) new RadiantQuartzSlab(true).setLightValue(0.5F).setUnlocalizedName("RadiantQuartzDoubleSlab");
	
		PinkQuartzStairs = new EOBlockStairs(SmoothQuartzite, 0).setUnlocalizedName("PinkQuartzStairs");
		PinkQuartzSingleSlab = (BlockSlab) new PinkQuartzSlab(false).setUnlocalizedName("PinkQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		PinkQuartzDoubleSlab = (BlockSlab) new PinkQuartzSlab(true).setUnlocalizedName("PinkQuartzDoubleSlab");
		
		graniteBrickStairs = new EOBlockStairs(GraniteBrick, 0).setUnlocalizedName("graniteBrickStairs");
		graniteBrickSingleSlab = (BlockSlab) new GraniteBrickSlab(false).setUnlocalizedName("graniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		graniteBrickDoubleSlab = (BlockSlab) new GraniteBrickSlab(true).setUnlocalizedName("graniteBrickDoubleSlab");
		
		tinPlatedCobbleStairs = new EOBlockStairs(TinPlatedCobble, 0).setUnlocalizedName("tinPlatedCobbleStairs");
		tinPlatedCobbleSingleSlab = (BlockSlab) new TinPlatedCobbleSlab(false).setUnlocalizedName("tinPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedCobbleDoubleSlab = (BlockSlab) new TinPlatedCobbleSlab(true).setUnlocalizedName("tinPlatedCobbleDoubleSlab");
		
		steelPlatedCobbleStairs = new EOBlockStairs(SteelPlatedCobble, 0).setUnlocalizedName("steelPlatedCobbleStairs");
		steelPlatedCobbleSingleSlab = (BlockSlab) new SteelPlatedCobbleSlab(false).setUnlocalizedName("steelPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedCobbleDoubleSlab = (BlockSlab) new SteelPlatedCobbleSlab(true).setUnlocalizedName("steelPlatedCobbleDoubleSlab");
		
		bronzePlatedCobbleStairs = new EOBlockStairs(BronzePlatedCobble, 0).setUnlocalizedName("bronzePlatedCobbleStairs");
		bronzePlatedCobbleSingleSlab = (BlockSlab) new BronzePlatedCobbleSlab(false).setUnlocalizedName("bronzePlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedCobbleDoubleSlab = (BlockSlab) new BronzePlatedCobbleSlab(true).setUnlocalizedName("bronzePlatedCobbleDoubleSlab");
		
		tinPlatedStoneBrickStairs = new EOBlockStairs(TinPlatedStoneBrick, 0).setUnlocalizedName("tinPlatedStoneBrickStairs");
		tinPlatedStoneBrickSingleSlab = (BlockSlab) new TinPlatedStoneBrickSlab(false).setUnlocalizedName("tinPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedStoneBrickDoubleSlab = (BlockSlab) new TinPlatedStoneBrickSlab(true).setUnlocalizedName("tinPlatedStoneBrickDoubleSlab");
		
		steelPlatedStoneBrickStairs = new EOBlockStairs(SteelPlatedStoneBrick, 0).setUnlocalizedName("steelPlatedStoneBrickStairs");
		steelPlatedStoneBrickSingleSlab = (BlockSlab) new SteelPlatedStoneBrickSlab(false).setUnlocalizedName("steelPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedStoneBrickDoubleSlab = (BlockSlab) new SteelPlatedStoneBrickSlab(true).setUnlocalizedName("steelPlatedStoneBrickDoubleSlab");
		
		bronzePlatedStoneBrickStairs = new EOBlockStairs(BronzePlatedStoneBrick, 0).setUnlocalizedName("bronzePlatedStoneBrickStairs");
		bronzePlatedStoneBrickSingleSlab = (BlockSlab) new BronzePlatedStoneBrickSlab(false).setUnlocalizedName("bronzePlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedStoneBrickDoubleSlab = (BlockSlab) new BronzePlatedStoneBrickSlab(true).setUnlocalizedName("bronzePlatedStoneBrickDoubleSlab");
		
		tinPlatedGraniteBrickStairs = new EOBlockStairs(TinPlatedGranite, 0).setUnlocalizedName("tinPlatedGraniteBrickStairs");
		tinPlatedGraniteBrickSingleSlab = (BlockSlab) new TinPlatedGraniteBrickSlab(false).setUnlocalizedName("tinPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedGraniteBrickDoubleSlab = (BlockSlab) new TinPlatedGraniteBrickSlab(true).setUnlocalizedName("tinPlatedGraniteBrickDoubleSlab");
		
		steelPlatedGraniteBrickStairs = new EOBlockStairs(SteelPlatedGranite, 0).setUnlocalizedName("steelPlatedGraniteBrickStairs");
		steelPlatedGraniteBrickSingleSlab = (BlockSlab) new SteelPlatedGraniteBrickSlab(false).setUnlocalizedName("steelPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedGraniteBrickDoubleSlab = (BlockSlab) new SteelPlatedGraniteBrickSlab(true).setUnlocalizedName("steelPlatedGraniteBrickDoubleSlab");
		
		bronzePlatedGraniteBrickStairs = new EOBlockStairs(BronzePlatedGranite, 0).setUnlocalizedName("bronzePlatedGraniteBrickStairs");
		bronzePlatedGraniteBrickSingleSlab = (BlockSlab) new BronzePlatedGraniteBrickSlab(false).setUnlocalizedName("bronzePlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedGraniteBrickDoubleSlab = (BlockSlab) new BronzePlatedGraniteBrickSlab(true).setUnlocalizedName("bronzePlatedGraniteBrickDoubleSlab");
		
		plutoniumInsulated = (new BlockPlutoniumInsulated(Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("plutoniumInsulated");
		uraniumInsulated = (new BlockUraniumInsulated(Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("uraniumInsulated");      
	
		//magma = new BlockMagma(EOConfig.magmaId).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("magma").setLightValue(1F);
		
		soulBlock = new BlockSoulBlock().setUnlocalizedName("block_SoulBlock").setHardness(65F).setResistance(30F).setLightValue(1F);
	}
	
	public static void registerBlocks()
	{
		
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
		/*
		Item.itemsList[RadiantQuartzSingleSlab.blockID] = (new ItemSlab(RadiantQuartzSingleSlab.blockID - 256, (BlockSlab)RadiantQuartzSingleSlab, (BlockSlab)RadiantQuartzDoubleSlab, false));
		Item.itemsList[PinkQuartzSingleSlab.blockID] = (new ItemSlab(PinkQuartzSingleSlab.blockID - 256, (BlockSlab)PinkQuartzSingleSlab, (BlockSlab)PinkQuartzDoubleSlab, false));
		Item.itemsList[graniteBrickSingleSlab.blockID] = (new ItemSlab(graniteBrickSingleSlab.blockID - 256, (BlockSlab)graniteBrickSingleSlab, (BlockSlab)graniteBrickDoubleSlab, false));
		Item.itemsList[tinPlatedCobbleSingleSlab.blockID] = (new ItemSlab(tinPlatedCobbleSingleSlab.blockID - 256, (BlockSlab)tinPlatedCobbleSingleSlab, (BlockSlab)tinPlatedCobbleDoubleSlab, false));
		Item.itemsList[steelPlatedCobbleSingleSlab.blockID] = (new ItemSlab(steelPlatedCobbleSingleSlab.blockID - 256, (BlockSlab)steelPlatedCobbleSingleSlab, (BlockSlab)steelPlatedCobbleDoubleSlab, false));
		Item.itemsList[bronzePlatedCobbleSingleSlab.blockID] = (new ItemSlab(bronzePlatedCobbleSingleSlab.blockID - 256, (BlockSlab)bronzePlatedCobbleSingleSlab, (BlockSlab)bronzePlatedCobbleDoubleSlab, false));
		Item.itemsList[tinPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(tinPlatedStoneBrickSingleSlab.blockID - 256, (BlockSlab)tinPlatedStoneBrickSingleSlab, (BlockSlab)tinPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[steelPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(steelPlatedStoneBrickSingleSlab.blockID - 256, (BlockSlab)steelPlatedStoneBrickSingleSlab, (BlockSlab)steelPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[bronzePlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(bronzePlatedStoneBrickSingleSlab.blockID - 256, (BlockSlab)bronzePlatedStoneBrickSingleSlab, (BlockSlab)bronzePlatedStoneBrickDoubleSlab, false));
		Item.itemsList[tinPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(tinPlatedGraniteBrickSingleSlab.blockID - 256, (BlockSlab)tinPlatedGraniteBrickSingleSlab, (BlockSlab)tinPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[steelPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(steelPlatedGraniteBrickSingleSlab.blockID - 256, (BlockSlab)steelPlatedGraniteBrickSingleSlab, (BlockSlab)steelPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[bronzePlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(bronzePlatedGraniteBrickSingleSlab.blockID - 256, (BlockSlab)bronzePlatedGraniteBrickSingleSlab, (BlockSlab)bronzePlatedGraniteBrickDoubleSlab, false));
		*/
	}
	
	public static void loadBridgedBlocks() throws Exception{
		if(Loader.isModLoaded("ExtraDecor")){
			glowGlass = new BlockGlowGlass(Material.glass,true).setUnlocalizedName("block_GlowGlass").setLightValue(0.7F).setStepSound(Block.soundTypeGlass).setHardness(.8F);
			GameRegistry.registerBlock(glowGlass,"block_GlowGlass");
		}
	
	}

}
