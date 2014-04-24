package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.block.BlockMulti;
import sobiohazardous.minestrappolation.api.block.BlockMultiLamp;
import sobiohazardous.minestrappolation.api.block.BlockMultiPillar;
import sobiohazardous.minestrappolation.api.block.BlockMultiPillarStationary;
import sobiohazardous.minestrappolation.api.block.BlockMultiRoad;
import sobiohazardous.minestrappolation.api.block.BlockMultiSlab;
import sobiohazardous.minestrappolation.api.block.BlockPillar;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.itemblocks.ItemBlockMulti;
import sobiohazardous.minestrappolation.api.itemblocks.ItemBlockMultiSlab;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.CreativeTabExtraDecorBlocks;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.block.*;
import sobiohazardous.minestrappolation.extradecor.material.MaterialOoze;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class EDBlocks 
{	
	public static final Material materialOoze = new MaterialOoze(MapColor.foliageColor);
	
	//bridged blocks
	public static Block bedrockBrick;
	public static Block stonePillar;
	public static Block stoneLamp;
	public static Block stones;
	
	public static Block Tiles;
	
	public static Block Goblet;
	public static Block Plate;
	
	public static Block edgeStoneBrick;
	public static Block edgeStoneBrickCorner;
	
	public static Block snowBrick;
	public static Block endstone;
	
	public static Block glassRefined;
	public static Block glassRefinedPane;
	
	public static Block woodPanel;
	
	public static Block woodBeveled;
	public static Block gunpowderBlock;
	
	public static Block rope;
	public static Item itemRope;
	public static Block ropeCoil;
	
	public static Block oozeSlime;
	
	public static Block sandstoneBricks;	
	public static Block sandstonePillar;
	
	public static Block woodBoards;
	
	public static Block sugarBlock;
	public static Block meatBlock;
	
	public static Block magmaOoze;
	
	public static Block enderBlock;
	
	public static Block crate;
	public static Block barrel;
	
	public static Block cardboard;
	public static Block cardboardBlock;
	public static Block cardboardWet;
		
	public static Block woodBoardsStairsOak;
	public static Block woodBoardsStairsBirch;
	public static Block woodBoardsStairsSpruce;
	public static Block woodBoardsStairsJungle;
	public static BlockSlab woodBoardsSingleSlab;
	public static BlockSlab woodBoardsDoubleSlab;
	
	public static Block checkerTileStairs;
	
	public static Block stainedBrick;
	
	public static Block cobbledRoad;
	public static Block infertileDirt;
	public static Block refinedRoad;
	
	public static Block sandyRoad;
	public static Block sandstoneRoad;
	public static Block gravelRoad;
	public static Block netherroad;
	public static Block refinedNetherroad;
	
	public static Block woodPlanksMossy;
	
	public static Block GlassDoor;
	
	public static Block bedrockBlocks;
	public static Block bedrockLamps;
	public static Block bedrockPillars;
	public static Block bedrockRoads;
	public static BlockMultiSlab bedrockSlabsSingle;
	public static BlockMultiSlab bedrockSlabsDouble;
	
	public static Block clayBlocks;
	public static Block clayBlocks2;
	public static Block clayBlocks3;
	public static Block clayBlocks4;
	public static Block clayPillars;
	public static Block clayPillars2;
	public static Block clayPillars3;
	public static Block clayPillars4;
	public static Block clayRoads;
	public static Block clayChiseled;
	public static BlockMultiSlab claySlabsSingle;
	public static BlockMultiSlab claySlabsSingle2;
	public static BlockMultiSlab claySlabsSingle3;
	public static BlockMultiSlab claySlabsSingle4;
	public static BlockMultiSlab claySlabsDouble;
	public static BlockMultiSlab claySlabsDouble2;
	public static BlockMultiSlab claySlabsDouble3;
	public static BlockMultiSlab claySlabsDouble4;

	public static Block endstoneBlocks;
	public static Block endstonePillars;
	public static Block endstoneRoads;
	public static Block endstoneChiseled;
	public static BlockMultiSlab endstoneSlabSingle;
	public static BlockMultiSlab endstoneSlabDouble;
	
	public static CreativeTabs tabDecor = new CreativeTabExtraDecorBlocks(CreativeTabs.getNextID(),"Extrappolated Decor");

	public static void createBlocks()
	{
		stonePillar = (new BlockPillar(MAssetManager.getEDStonecutterTexture("Stone_Pillar_Side_0"), MAssetManager.getEDStonecutterTexture("Stone_Pillar_Top_0"))).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("stonePillar");
		stoneLamp = (new BlockStoneLamp()).setHardness(1.5F).setResistance(8F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setBlockName("stoneLamp");
		stones = new BlockStones().setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("stones");
		
		Tiles = new BlockTiles().setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("tiles");
	
		edgeStoneBrick = (new BlockEdgeStoneBrick()).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrick");
		edgeStoneBrickCorner = (new BlockEdgeStoneCorner()).setHardness(1.5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrickCorner");
	
		snowBrick = (new BlockSnowBrick()).setHardness(0.3F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeSnow).setBlockName("tilesSnow").setBlockTextureName(MAssetManager.getEDTexture("tilesSnow"));
	
		endstone = (new BlockEndStone()).setHardness(3.0F).setResistance(15.0F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("Endstone");
	
		glassRefined = (new BlockGlassRefined(Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecor).setBlockName("glassRefined");
		glassRefinedPane = (new EDBlockPane("ClearGlass", "clearGlassPaneEdge", Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecor).setBlockName("glassRefinedPane");
		gunpowderBlock = (new BlockGunpowderBlock(Material.ground)).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("GunpowderBlock").setBlockTextureName(MAssetManager.getEDTexture("blockGunpowder"));
	
		rope = (new BlockRope()).setHardness(0.9F).setStepSound(Block.soundTypeCloth).setBlockName("rope");
		itemRope = (new ItemReed(rope)).setUnlocalizedName("rope").setCreativeTab(tabDecor).setTextureName(MAssetManager.getEDTexture("rope"));
		ropeCoil = (new BlockRopeCoil()).setHardness(0.9F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeCloth).setBlockName("ropeCoil");
	
		oozeSlime = (new BlockOoze(materialOoze)).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("SlimeOoze").setBlockTextureName(MAssetManager.getEDTexture("oozeSlime"));
	
		woodPanel = (new BlockWoodPanel()).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPanel");
		
		woodBeveled = (new BlockWoodBeveled()).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodBeveled");
	
		sandstoneBricks = (new BlockSandstoneBrick()).setHardness(1F).setStepSound(Block.soundTypeStone).setBlockName("sandstoneBrick");
		sandstonePillar = new BlockPillar(MAssetManager.getEDStonecutterTexture("Sandstone_Pillar_Side_0"), MAssetManager.getEDStonecutterTexture("Sandstone_Pillar_Top_0")).setBlockName("sandstonePillar").setHardness(1F).setStepSound(Block.soundTypeStone);
	
		woodBoards = new BlockWoodBoards().setHardness(2.0F).setResistance(5.0F).setBlockName("woodBoards").setStepSound(Block.soundTypeWood);
		//TODO add the rest of the boards after Extrapolated Enviroments

		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("SugarBlock").setBlockTextureName(MAssetManager.getEDTexture("blockSugar"));
		meatBlock = new BlockMeatBlock("MeatBlock").setHardness(0.8F).setStepSound(Block.soundTypeCloth).setBlockName("MeatBlock").setBlockTextureName(MAssetManager.getEDTexture("blockRawMeat"));
	
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("MagmaOoze").setBlockTextureName(MAssetManager.getEDTexture("oozeMagma"));
	
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setBlockName("EnderBlock").setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecor).setBlockTextureName(MAssetManager.getEDTexture("blockEnderPearl"));
	
		crate = new BlockCrate().setHardness(2.5F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor).setBlockName("crate");
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor).setBlockName("barrel");
	
		cardboard = new EDBlockPane("cardboard", "cardboardPaneEdge", Material.cloth, true).setHardness(0.3F).setBlockName("cardboard");
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setBlockName("CardboardBlock").setCreativeTab(tabDecor);
		cardboardWet = new BlockCardboardWet(Material.cloth).setCreativeTab(tabDecor).setHardness(0.2F).setResistance(0.8F).setBlockName("cardboardWet");
		
		woodBoardsStairsOak = new EDBlockStairs(woodBoards, 0).setBlockName("woodBoardsStairsOak").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor);
		woodBoardsStairsBirch = new EDBlockStairs(woodBoards, 1).setBlockName("woodBoardsStairsBirch").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor);
		woodBoardsStairsSpruce = new EDBlockStairs(woodBoards, 2).setBlockName("woodBoardsStairsSpruce").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor);
		woodBoardsStairsJungle = new EDBlockStairs(woodBoards, 3).setBlockName("woodBoardsStairsJungle").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecor);
		woodBoardsSingleSlab = (BlockSlab) new BlockWoodBoardSlab(false).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		woodBoardsDoubleSlab = (BlockSlab) new BlockWoodBoardSlab( true).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);

		checkerTileStairs = new EDBlockStairs(Tiles, 3).setBlockName("checkerTileStairs").setHardness(3F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabDecor);
	
		stainedBrick = (new BlockStainedBrick()).setHardness(2F).setResistance(10F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("stainedBrick");
	
		cobbledRoad = (new BlockCobbledRoad()).setHardness(1).setResistance(5F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("cobbledRoad");
		infertileDirt = new MBlock(Material.grass).setCreativeTab(tabDecor).setBlockName("InfertileSoil").setHardness(.4F).setStepSound(Block.soundTypeGrass).setBlockTextureName(MAssetManager.getEDTexture("grasslessDirt"));
		refinedRoad = (new BlockRefinedRoad()).setHardness(2F).setResistance(5F).setBlockName("RefinedRoad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecor);
		
		sandyRoad = (new BlockSandyRoad()).setHardness(0.8F).setResistance(4F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("sandyRoad");
		sandstoneRoad = (new BlockSandyRoad()).setHardness(1).setResistance(4.5F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("sandstoneRoad");
		gravelRoad = (new BlockSandyRoad()).setHardness(1.5F).setResistance(5F).setCreativeTab(tabDecor).setStepSound(Block.soundTypeStone).setBlockName("gravelRoad");
		netherroad = (new BlockRefinedRoad()).setHardness(2.2F).setResistance(4F).setBlockName("netherroad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecor);
		refinedNetherroad = (new BlockRefinedRoad()).setHardness(2.8F).setResistance(6F).setBlockName("refinedNetherroad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecor);

		woodPlanksMossy = new BlockMossyWood().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPlanksMossy").setCreativeTab(tabDecor);
		
		//Test
		Goblet = new BlockGoblet(Material.rock).setHardness(.5F).setBlockName("goblet");
		Plate = new BlockPlate(Material.rock).setCreativeTab(tabDecor).setBlockName("plate");
		
		GlassDoor = (new BlockGlassDoor(Material.glass)).setHardness(1F).setBlockName("doorGlass");
		
		bedrockBlocks = new BlockMulti(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Bricks_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_PatternBricks_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_Refined_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_Tiles_0_0")}).setBlockName("bedrockBlocks").setHardness(40F).setResistance(400F);
		bedrockLamps = new BlockMultiLamp(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_LampGlowstone_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_LampSunstone_0_0")}).setBlockName("bedrockLamps").setHardness(40F).setResistance(400F);
		bedrockPillars = new BlockMultiPillar(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Pillar_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Pillar_Top_0")}).setBlockName("bedrockPillars").setHardness(40F).setResistance(400F);
		bedrockRoads = new BlockMultiRoad(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Road_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_PatternBricks_0_0")}, new String[]{MAssetManager.getEDTexture("grasslessDirt")}).setBlockName("bedrockRoad").setHardness(40F).setResistance(400F);
		bedrockSlabsSingle = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_RefinedSlab_Side_0"), MAssetManager.getEDStonecutterTexture("Bedrock_RawSlab_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Refined_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_RawSlab_Top_0")}).setBlockName("bedrockSlabSingle").setCreativeTab(Minestrappolation.creativeTabStone);
		bedrockSlabsDouble = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_RefinedSlab_Side_0"), MAssetManager.getEDStonecutterTexture("Bedrock_RawSlab_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Bedrock_Refined_0_0"), MAssetManager.getEDStonecutterTexture("Bedrock_RawSlab_Top_0")}).setBlockName("bedrockSlabDouble");
		
		clayBlocks = new BlockMulti(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Bricks_0_Yellow"),
				}).setBlockName("clayBlocks").setHardness(2.0F).setResistance(8.0F);
		clayBlocks2 = new BlockMulti(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Yellow"),
				}).setBlockName("clayBlocks2").setHardness(2.0F).setResistance(8.0F);
		clayBlocks3 = new BlockMulti(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_White"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Yellow"),
				}).setBlockName("clayBlocks3").setHardness(2.0F).setResistance(8.0F);
		clayBlocks4 = new BlockMulti(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Tiles_0_Yellow")		
				}).setBlockName("clayBlocks4").setHardness(2.0F).setResistance(8.0F);
		clayPillars = new BlockMultiPillar(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Cyan")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Black"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Cyan")
				}).setBlockName("clayPillars").setHardness(2.0F).setResistance(8.0F);
		clayPillars2 = new BlockMultiPillar(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Lime")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Green"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Lime")
				}).setBlockName("clayPillars2").setHardness(2.0F).setResistance(8.0F);
		clayPillars3 = new BlockMultiPillar(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Purple")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Purple")
				}).setBlockName("clayPillars3").setHardness(2.0F).setResistance(8.0F);
		clayPillars4 = new BlockMultiPillar(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Red"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_White"), MAssetManager.getEDStonecutterTexture("Clay_Pillar_Top_Yellow")
				}).setBlockName("clayPillars4").setHardness(2.0F).setResistance(8.0F);
		clayRoads = new BlockMultiRoad(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_Road_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_White"), MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_Yellow")}, new String[]{
				MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt"), MAssetManager.getEDTexture("grasslessDirt")
				}).setBlockName("clayRoads").setHardness(2.0F).setResistance(8.0F);
		clayChiseled = new BlockMultiPillarStationary(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Yellow"),
				}).setBlockName("clayChiseled").setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Cyan")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Cyan")
				}).setBlockName("claySlabsSingle").setCreativeTab(Minestrappolation.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle2 = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Lime")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Lime")
				}).setBlockName("claySlabsSingle2").setCreativeTab(Minestrappolation.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle3 = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Purple")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Purple")
				}).setBlockName("claySlabsSingle3").setCreativeTab(Minestrappolation.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsSingle4 = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Yellow"),
				}).setBlockName("claySlabsSingle4").setCreativeTab(Minestrappolation.creativeTabStone).setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Cyan")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Cyan")
				}).setBlockName("claySlabsDouble").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble2 = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Lime")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Lime")
				}).setBlockName("claySlabsDouble2").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble3 = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Purple")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Purple")
				}).setBlockName("claySlabsDouble3").setHardness(2.0F).setResistance(8.0F);
		claySlabsDouble4 = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_RawSlab_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Yellow"),
				}).setBlockName("claySlabsDouble4").setHardness(2.0F).setResistance(8.0F);
		clayChiseled = new BlockMultiPillarStationary(Material.rock, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Black"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Green"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Red"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_White"), MAssetManager.getEDStonecutterTexture("Clay_Chiseled_Side_Yellow")}, new String[]{
				MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Black"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Blue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Brown"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Cyan"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Green"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Grey"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_LightBlue"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Lime"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Magenta"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Orange"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Pink"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Purple"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Red"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Silver"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_White"), MAssetManager.getEDStonecutterTexture("Clay_Refined_0_Yellow"),
				}).setBlockName("clayChiseled").setHardness(2.0F).setResistance(8.0F);
		
		endstoneBlocks = new BlockMulti(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Bricks_0_0"), MAssetManager.getEDStonecutterTexture("Endstone_PatternBricks_0_0"), MAssetManager.getEDStonecutterTexture("Endstone_Raw_0_0"), MAssetManager.getEDStonecutterTexture("Endstone_Refined_0_0"), MAssetManager.getEDStonecutterTexture("Endstone_Tiles_0_0")}).setBlockName("endstoneBlocks").setHardness(1.5F).setResistance(2.0F);
		endstonePillars = new BlockMultiPillar(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Pillar_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Pillar_Top_0")}).setHardness(1.5F).setResistance(2.0F).setBlockName("endstonePillars");
		endstoneRoads = new BlockMultiRoad(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Road_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_PatternBricks_0_0")}, new String[]{"obsidian"}).setHardness(1.5F).setResistance(2.0F).setBlockName("endstoneRoads");
		endstoneChiseled = new BlockMultiPillarStationary(Material.rock, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Pillar_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_Pillar_Side_0")}).setBlockName("endstoneChiseled").setHardness(1.5F).setResistance(2.0F);
		endstoneSlabSingle = (BlockMultiSlab) new BlockMultiSlab(false, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_RawSlab_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_RawSlab_Top_0")}).setBlockName("endstoneSlabSingle").setHardness(1.5F).setResistance(2.0F).setCreativeTab(Minestrappolation.creativeTabStone);
		endstoneSlabDouble = (BlockMultiSlab) new BlockMultiSlab(true, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_RawSlab_Side_0")}, new String[]{MAssetManager.getEDStonecutterTexture("Endstone_RawSlab_Top_0")}).setBlockName("endstoneSlabDouble").setHardness(1.5F).setResistance(2.0F);

	}
	
	public static void loadVanillaOverwrites()
	{
		//add vanilla overwrites	    
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(GlassDoor ,"GlassDoor");
		GameRegistry.registerBlock(edgeStoneBrickCorner, ItemBlockMulti.class, "edgeCorner");
		GameRegistry.registerBlock(refinedRoad,"refinedRoad");
		GameRegistry.registerBlock(stoneLamp, ItemBlockMulti.class, "stoneLamp");
		GameRegistry.registerBlock(edgeStoneBrick, "edgeStoneBrick");
		GameRegistry.registerBlock(snowBrick, "snowBrick");
		GameRegistry.registerBlock(endstone, ItemBlockMulti.class, "endstone");
		GameRegistry.registerBlock(glassRefined, "glassRefined");
		GameRegistry.registerBlock(glassRefinedPane, "glassRefinedPane");
		GameRegistry.registerBlock(gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(rope, "rope");
		GameRegistry.registerItem(itemRope, "itemRope");
		GameRegistry.registerBlock(ropeCoil, "ropeCoil");
		GameRegistry.registerBlock(woodPanel, ItemBlockMulti.class, "woodPanel");
		GameRegistry.registerBlock(woodBeveled, ItemBlockMulti.class, "woodBeveled");
		GameRegistry.registerBlock(oozeSlime, "oozeSlime");
		GameRegistry.registerBlock(sandstoneBricks, ItemBlockMulti.class, "sandstoneBricks");
		GameRegistry.registerBlock(sandstonePillar, "sandstonePillar");
		GameRegistry.registerBlock(stonePillar, "stonePillar");
		GameRegistry.registerBlock(woodBoards, ItemBlockMulti.class, "woodBoards");
		GameRegistry.registerBlock(sugarBlock, "sugarBlock");
		GameRegistry.registerBlock(meatBlock, "meatBlock");
		GameRegistry.registerBlock(magmaOoze, "magmaOoze");
		GameRegistry.registerBlock(enderBlock, "enderBlock");
		GameRegistry.registerBlock(crate, "crate");
		GameRegistry.registerBlock(barrel, "barrel");
		GameRegistry.registerBlock(cardboard, "cardboard");
		GameRegistry.registerBlock(cardboardBlock, "cardboardBlock");
		GameRegistry.registerBlock(cardboardWet, "cardboardWet");
		GameRegistry.registerBlock(woodBoardsStairsOak, "woodBoardStairsOak");
		GameRegistry.registerBlock(woodBoardsStairsBirch, "woodBoardStairsBirch");
		GameRegistry.registerBlock(woodBoardsStairsSpruce, "woodBoardStairsSpruce");
		GameRegistry.registerBlock(woodBoardsStairsJungle, "woodBoardStairsJungle");
		GameRegistry.registerBlock(woodBoardsSingleSlab, ItemBlockMulti.class, "woodBoardsSlabSingle");
		GameRegistry.registerBlock(woodBoardsDoubleSlab, ItemBlockMulti.class, "woodBoardsSlabDouble");
		GameRegistry.registerBlock(checkerTileStairs, "checkerTileStairs");
		GameRegistry.registerBlock(stainedBrick, ItemBlockMulti.class, "stainedBrick");
		GameRegistry.registerBlock(cobbledRoad, "cobbledRoad");
		GameRegistry.registerBlock(infertileDirt,"Infertile Dirt");
		GameRegistry.registerBlock(sandyRoad, "sandyRoad");
		GameRegistry.registerBlock(sandstoneRoad, "sandstoneRoad");
		GameRegistry.registerBlock(gravelRoad, "gravelRoad");
		GameRegistry.registerBlock(netherroad, "netherroad");
		GameRegistry.registerBlock(refinedNetherroad, "refinedNetherroad");
		GameRegistry.registerBlock(Goblet, ItemBlockMulti.class, "Goblet", "goblet");
		GameRegistry.registerBlock(Plate,"Plate");
		GameRegistry.registerBlock(woodPlanksMossy, ItemBlockMulti.class, "woodPlanksMossy");
		GameRegistry.registerBlock(stones, ItemBlockMulti.class, "Stones");
		GameRegistry.registerBlock(Tiles, ItemBlockMulti.class, "tiles");
		
		GameRegistry.registerBlock(bedrockBlocks, ItemBlockMulti.class, "bedrockBlocks");
		GameRegistry.registerBlock(bedrockLamps, ItemBlockMulti.class, "bedrockLamps");
		GameRegistry.registerBlock(bedrockPillars, ItemBlockMulti.class, "bedrockPillars");
		GameRegistry.registerBlock(bedrockRoads, ItemBlockMulti.class, "bedrockRoads");
		GameRegistry.registerBlock(bedrockSlabsSingle, ItemBlockMultiSlab.class, "bedrockSlabsSingle", null, bedrockSlabsSingle, bedrockSlabsDouble);
		GameRegistry.registerBlock(bedrockSlabsDouble, ItemBlockMultiSlab.class, "bedrockSlabsDouble", null, bedrockSlabsSingle, bedrockSlabsDouble);

		GameRegistry.registerBlock(clayBlocks, ItemBlockMulti.class, "clayBlocks");
		GameRegistry.registerBlock(clayBlocks2, ItemBlockMulti.class, "clayBlocks2");
		GameRegistry.registerBlock(clayBlocks3, ItemBlockMulti.class, "clayBlocks3");
		GameRegistry.registerBlock(clayBlocks4, ItemBlockMulti.class, "clayBlocks4");
		GameRegistry.registerBlock(clayPillars, ItemBlockMulti.class, "clayPillars");
		GameRegistry.registerBlock(clayPillars2, ItemBlockMulti.class, "clayPillars2");
		GameRegistry.registerBlock(clayPillars3, ItemBlockMulti.class, "clayPillars3");
		GameRegistry.registerBlock(clayPillars4, ItemBlockMulti.class, "clayPillars4");
		GameRegistry.registerBlock(clayRoads, ItemBlockMulti.class, "clayRoads");
		GameRegistry.registerBlock(clayChiseled, ItemBlockMulti.class, "clayChiseled");
		GameRegistry.registerBlock(claySlabsSingle, ItemBlockMultiSlab.class, "claySlabsSingle", null, claySlabsSingle, claySlabsDouble);
		GameRegistry.registerBlock(claySlabsDouble, ItemBlockMultiSlab.class, "claySlabsDouble", null, claySlabsSingle, claySlabsDouble);
		GameRegistry.registerBlock(claySlabsSingle2, ItemBlockMultiSlab.class, "claySlabsSingle2", null, claySlabsSingle2, claySlabsDouble2);
		GameRegistry.registerBlock(claySlabsDouble2, ItemBlockMultiSlab.class, "claySlabsDouble2", null, claySlabsSingle2, claySlabsDouble2);
		GameRegistry.registerBlock(claySlabsSingle3, ItemBlockMultiSlab.class, "claySlabsSingle3", null, claySlabsSingle3, claySlabsDouble3);
		GameRegistry.registerBlock(claySlabsDouble3, ItemBlockMultiSlab.class, "claySlabsDouble3", null, claySlabsSingle3, claySlabsDouble3);
		GameRegistry.registerBlock(claySlabsSingle4, ItemBlockMultiSlab.class, "claySlabsSingle4", null, claySlabsSingle4, claySlabsDouble4);
		GameRegistry.registerBlock(claySlabsDouble4, ItemBlockMultiSlab.class, "claySlabsDouble4", null, claySlabsSingle4, claySlabsDouble4);
		
		GameRegistry.registerBlock(endstoneBlocks, ItemBlockMulti.class, "endstoneBlocks");
		GameRegistry.registerBlock(endstonePillars, ItemBlockMulti.class, "endstonePillars");
		GameRegistry.registerBlock(endstoneRoads, ItemBlockMulti.class, "endstoneRoads");
		GameRegistry.registerBlock(endstoneChiseled, ItemBlockMulti.class, "endstoneChiseled");
		GameRegistry.registerBlock(endstoneSlabSingle, ItemBlockMultiSlab.class, "endstoneSlabsSingle", null, endstoneSlabSingle, endstoneSlabDouble);
		GameRegistry.registerBlock(endstoneSlabDouble, ItemBlockMultiSlab.class, "endstoneSlabsDouble", null, endstoneSlabSingle, endstoneSlabDouble);

	}
	
	public static void loadBridgedBlocks() throws Exception
	{
		if(Loader.isModLoaded(MAPIReference.MODID_EO))
		{
			bedrockBrick = new BlockBedrockBrick().setBlockName("BedrockBrick").setStepSound(Block.soundTypeStone).setResistance(100000000F).setHardness(80F).setCreativeTab(tabDecor).setBlockTextureName(MAssetManager.getEDStonecutterTexture("Bedrock_Bricks_0_0"));
			GameRegistry.registerBlock(bedrockBrick,"BedrockBrick");
			bedrockBrick.setHarvestLevel("pickaxe", 4);
		}	
	}
}
