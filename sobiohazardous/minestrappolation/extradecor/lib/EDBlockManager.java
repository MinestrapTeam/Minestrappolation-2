package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.block.BlockPillar;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.item.MItemBlockPlacer;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extradecor.CreativeTabExtraDecorBlocks;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.block.*;
import sobiohazardous.minestrappolation.extradecor.material.MaterialOoze;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class EDBlockManager {
	
	public static final Material materialOoze = new MaterialOoze(MapColor.foliageColor);
	//bridged blocks
	public static Block bedrockBrick;
	public static Block stonePillar;
	public static Block stoneLamp;
	public static Block stones;
	
	public static Block Tiles;
	
	public static Block StatueTest;
	
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
	public static BlockHalfSlab woodBoardsSingleSlab;
	public static BlockHalfSlab woodBoardsDoubleSlab;
	
	public static Block checkerTileStairs;
	
	public static Block stainedBrick;
	
	public static Block cobbledRoad;
	public static Block infertileDirt;
	public static Block refinedRoad;
	
	public static Block sandyRoad;
	public static Block sandstoneRoad;
	public static Block gravelRoad;
	
	public static Block woodPlanksMossy;
	public static Block woodPlanksOverwrite;
	public static Block stairsWoodOakM;
	public static Block stairsWoodSpruceM;
	public static Block stairsWoodBirchM;
	public static Block stairsWoodJungleM;
	public static BlockHalfSlab woodDoubleSlabM;
	public static BlockHalfSlab woodSingleSlabM;

	public static CreativeTabs tabDecorBlocks = new CreativeTabExtraDecorBlocks(CreativeTabs.getNextID(),"Extrappolated Decor");
	public static void createBlocks()
	{
		stonePillar = (new BlockPillar(EDConfig.stonePillarId, "block_StonePillar", "block_StoneRefined")).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stonePillar");
		stoneLamp = (new BlockStoneLamp(EDConfig.stoneLampId)).setHardness(1.5F).setResistance(8F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F).setUnlocalizedName("stoneLamp");
		stones = new BlockStones(EDConfig.stoneTileId).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep);
		
		Tiles = new BlockTiles(EDConfig.obsidianTileId).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep);
	
		edgeStoneBrick = (new BlockEdgeStoneBrick(EDConfig.edgeStoneBrickId)).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("block_edgeStoneBrick");
		edgeStoneBrickCorner = (new BlockEdgeStoneCorner(EDConfig.edgeStoneCornerID)).setHardness(1.5F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("block_edgeStoneBrickCorner");
	
		snowBrick = (new BlockSnowBrick(EDConfig.snowBrickId)).setHardness(0.3F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundSnowFootstep).setUnlocalizedName("block_SnowBrick");
	
		endstone = (new BlockEndStone(EDConfig.endstoneSmoothId)).setHardness(3.0F).setResistance(15.0F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("block_Endstone");
	
		glassRefined = (new BlockGlassRefined(EDConfig.glassRefinedId, Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setCreativeTab(tabDecorBlocks).setUnlocalizedName("glassRefined");
		glassRefinedPane = (new EDBlockPane(EDConfig.glassRefinedPaneId, "block_ClearGlass", "block_ClearGlassTop", Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setCreativeTab(tabDecorBlocks).setUnlocalizedName("glassRefinedPane");
		gunpowderBlock = (new BlockGunpowderBlock(EDConfig.gunpowderBlockId, Material.ground)).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("block_GunpowderBlock");
	
		rope = (new BlockRope(EDConfig.ropeId)).setHardness(0.9F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("rope");
		itemRope = (new MItemBlockPlacer(EDConfig.itemRopeId, rope)).setUnlocalizedName("item_Rope").setCreativeTab(tabDecorBlocks);
		ropeCoil = (new BlockRopeCoil(EDConfig.ropeCoilId)).setHardness(0.9F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundClothFootstep).setUnlocalizedName("ropeCoil");
	
		oozeSlime = (new BlockOoze(EDConfig.oozeSlimeId, materialOoze)).setHardness(1F).setResistance(2000F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("block_SlimeOoze");
	
		woodPanel = (new BlockWoodPanel(EDConfig.woodPanelId)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodPanel");
		
		woodBeveled = (new BlockWoodBeveled(EDConfig.woodBeveledId)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodBeveled");
	
		sandstoneBricks = (new BlockSandstoneBrick(EDConfig.sandstoneBrickId)).setHardness(1F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sandstoneBrick");
		sandstonePillar = new BlockPillar(EDConfig.sandstonePillarId, "block_SandstonePillarSide", "block_SandstonePillarTop").setUnlocalizedName("sandstonePillar").setHardness(1F).setStepSound(Block.soundStoneFootstep);
	
		woodBoards = new BlockWoodBoards(EDConfig.woodBoardsId).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("woodBoards").setStepSound(Block.soundWoodFootstep);
		//TODO add the rest of the boards after Extrapolated Nature

		sugarBlock = new BlockSugarBlock(EDConfig.sugarBlockId).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("block_SugarBlock");
		meatBlock = new BlockMeatBlock(EDConfig.meatBlockId, "block_MeatBlock").setHardness(0.8F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("block_MeatBlock");
	
		magmaOoze = new BlockOoze(EDConfig.magmaOozeId, materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("block_MagmaOoze");
	
		enderBlock = new BlockEnderblock(EDConfig.enderBlockId).setHardness(3.0F).setResistance(4.0F).setUnlocalizedName("block_EnderBlock").setStepSound(Block.soundGlassFootstep).setCreativeTab(tabDecorBlocks);
	
		crate = new BlockCrate(EDConfig.crateId).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks).setUnlocalizedName("crate");
		barrel = new BlockBarrel(EDConfig.barrelId).setHardness(3F).setResistance(6.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks).setUnlocalizedName("barrel");
	
		cardboard = new EDBlockPane(EDConfig.cardboardId, "block_CardboardBlock", "block_CardboardEdge", Material.cloth, true).setHardness(0.3F).setUnlocalizedName("cardboard");
		cardboardBlock = new BlockCardboard(EDConfig.cardboardBlockId, Material.cloth).setHardness(0.4F).setUnlocalizedName("block_CardboardBlock").setCreativeTab(tabDecorBlocks);
		cardboardWet = new BlockCardboardWet(EDConfig.cardboardWetId, Material.cloth).setCreativeTab(tabDecorBlocks).setHardness(0.2F).setResistance(0.8F).setUnlocalizedName("cardboardWet");
		
		woodBoardsStairsOak = new EDBlockStairs(EDConfig.woodBoardsStairsOakId, woodBoards, 0).setUnlocalizedName("woodBoardsStairsOak").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsBirch = new EDBlockStairs(EDConfig.woodBoardsStairsBirchId, woodBoards, 1).setUnlocalizedName("woodBoardsStairsBirch").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsSpruce = new EDBlockStairs(EDConfig.woodBoardsStairsSpruceId, woodBoards, 2).setUnlocalizedName("woodBoardsStairsSpruce").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsJungle = new EDBlockStairs(EDConfig.woodBoardsStairsJungleId, woodBoards, 3).setUnlocalizedName("woodBoardsStairsJungle").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(tabDecorBlocks);
		woodBoardsSingleSlab = (BlockHalfSlab) new BlockWoodBoardSlab(EDConfig.woodBoardsSingleSlabId, false).setUnlocalizedName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep);
		woodBoardsDoubleSlab = (BlockHalfSlab) new BlockWoodBoardSlab(EDConfig.woodBoardsDoubleSlabId, true).setUnlocalizedName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep);

		checkerTileStairs = new EDBlockStairs(EDConfig.checkerTileStairsId, Tiles, 3).setUnlocalizedName("checkerTileStairs").setHardness(3F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabDecorBlocks);
	
		stainedBrick = (new BlockStainedBrick(EDConfig.stainedBrickId)).setHardness(2F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stainedBrick");
	
		cobbledRoad = (new BlockCobbledRoad(EDConfig.cobbledRoadId)).setHardness(1).setResistance(5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("cobbledRoad");
		infertileDirt = new MBlock(EDConfig.infertiledirtId,Material.grass).setCreativeTab(tabDecorBlocks).setUnlocalizedName("block_InfertileSoil").setHardness(.4F).setStepSound(Block.soundGrassFootstep);
		refinedRoad = (new BlockRefinedRoad(EDConfig.refinedRoadID)).setResistance(1F).setHardness(5F).setUnlocalizedName("block_RefinedRoad").setStepSound(Block.soundStoneFootstep).setCreativeTab(tabDecorBlocks);
		
		sandyRoad = (new BlockSandyRoad(EDConfig.sandyRoadId)).setHardness(0.8F).setResistance(4F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sandyRoad");
		sandstoneRoad = (new BlockSandyRoad(EDConfig.sandstoneRoadId)).setHardness(1).setResistance(4.5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sandstoneRoad");
		gravelRoad = (new BlockSandyRoad(EDConfig.gravelRoadId)).setHardness(1.5F).setResistance(5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("gravelRoad");

		woodPlanksMossy = new BlockMossyWood(EDConfig.woodPlanksMossyId).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodPlanksMossy").setCreativeTab(tabDecorBlocks);
		
		//Test
		StatueTest = new BlockStatueTest(999,Material.rock);
	}
	
	public static void loadVanillaOverwrites()
	{
		Block.blocksList[Block.planks.blockID] = null;
	    woodPlanksOverwrite = (new BlockWoodOverwrite(5)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("wood").setTextureName("planks");
	    GameRegistry.registerBlock(woodPlanksOverwrite, "wood");
	    LanguageRegistry.instance().addStringLocalization("tile.wood.oak.name", "Oak Wood Planks");
		LanguageRegistry.instance().addStringLocalization("tile.wood.birch.name", "Birch Wood Plank");
		LanguageRegistry.instance().addStringLocalization("tile.wood.spruce.name", "Spruce Wood Planks");
		LanguageRegistry.instance().addStringLocalization("tile.wood.jungle.name", "Jungle Wood Planks");
		Block.blocksList[Block.stairsWoodOak.blockID] = null;
		stairsWoodOakM = (new EDBlockStairs(53, woodPlanksOverwrite, 0)).setUnlocalizedName("stairsWood");
	    GameRegistry.registerBlock(stairsWoodOakM, "stairsWood");
	    LanguageRegistry.addName(stairsWoodOakM, "Oak Wood Stairs");
		Block.blocksList[Block.stairsWoodSpruce.blockID] = null;
		stairsWoodSpruceM = (new EDBlockStairs(134, woodPlanksOverwrite, 1)).setUnlocalizedName("stairsWoodSpruce");
	    GameRegistry.registerBlock(stairsWoodSpruceM, "stairsWoodSpruce");
	    LanguageRegistry.addName(stairsWoodSpruceM, "Spruce Wood Stairs");
	    Block.blocksList[Block.stairsWoodBirch.blockID] = null;
		stairsWoodBirchM = (new EDBlockStairs(135, woodPlanksOverwrite, 2)).setUnlocalizedName("stairsWoodBirch");
	    GameRegistry.registerBlock(stairsWoodBirchM, "stairsWoodBirch");
	    LanguageRegistry.addName(stairsWoodBirchM, "Birch Wood Stairs");
	    Block.blocksList[Block.stairsWoodJungle.blockID] = null;
		stairsWoodJungleM = (new EDBlockStairs(136, woodPlanksOverwrite, 3)).setUnlocalizedName("stairsWoodJungle");
	    GameRegistry.registerBlock(stairsWoodJungleM, "stairsWoodJungle");
	    LanguageRegistry.addName(stairsWoodJungleM, "Jungle Wood Stairs");
	    
	    Block.blocksList[Block.woodDoubleSlab.blockID] = null;
	    woodDoubleSlabM = (BlockHalfSlab)(new BlockWoodSlabOverwrite(125, true)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodSlab");
	    GameRegistry.registerBlock(woodDoubleSlabM, "woodSlabD");
	    Block.blocksList[Block.woodSingleSlab.blockID] = null;
	    woodSingleSlabM = (BlockHalfSlab)(new BlockWoodSlabOverwrite(126, false)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodSlab");
	    GameRegistry.registerBlock(woodSingleSlabM, "woodSlab");
	    LanguageRegistry.addName(woodSingleSlabM, "Wood Slab");
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(edgeStoneBrickCorner,"Edge corner");
		GameRegistry.registerBlock(refinedRoad,"Refined Road");
		GameRegistry.registerBlock(stoneLamp, "stoneLamp");
		GameRegistry.registerBlock(edgeStoneBrick, "edgeStoneBrick");
		GameRegistry.registerBlock(snowBrick, "snowBrick");
		GameRegistry.registerBlock(endstone, "endstone");
		GameRegistry.registerBlock(glassRefined, "glassRefined");
		GameRegistry.registerBlock(glassRefinedPane, "glassRefinedPane");
		GameRegistry.registerBlock(gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(rope, "rope");
		GameRegistry.registerBlock(ropeCoil, "ropeCoil");
		GameRegistry.registerBlock(woodPanel, "woodPanel");
		GameRegistry.registerBlock(woodBeveled, "woodBeveled");
		GameRegistry.registerBlock(oozeSlime, "oozeSlime");
		GameRegistry.registerBlock(sandstoneBricks, "sandstoneBrick");
		GameRegistry.registerBlock(sandstonePillar, "sandstonePillar");
		GameRegistry.registerBlock(stonePillar, "stonePillar");
		GameRegistry.registerBlock(woodBoards, "woodBoards");
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
		GameRegistry.registerBlock(woodBoardsSingleSlab, "woodBoardsSingleSlab");
		GameRegistry.registerBlock(woodBoardsDoubleSlab, "woodBoardsDoubleSlab");
		GameRegistry.registerBlock(checkerTileStairs, "checkerTileStairs");
		GameRegistry.registerBlock(stainedBrick, "stainedBrick");
		GameRegistry.registerBlock(cobbledRoad, "cobbledRoad");
		GameRegistry.registerBlock(infertileDirt,"Infertile Dirt");
		GameRegistry.registerBlock(sandyRoad, "sandyRoad");
		GameRegistry.registerBlock(sandstoneRoad, "sandstoneRoad");
		GameRegistry.registerBlock(gravelRoad, "gravelRoad");
		//GameRegistry.registerBlock(StatueTest,"Test");
		GameRegistry.registerBlock(woodPlanksMossy, "woodPlanksMossy");
		GameRegistry.registerBlock(stones,"Stones");
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(refinedRoad, "Refined Road");
		LanguageRegistry.addName(infertileDirt, "Infertile Dirt");
		LanguageRegistry.addName(edgeStoneBrick, "Edge Stone Bricks");
		LanguageRegistry.addName(Tiles, "Tiles");
		LanguageRegistry.addName(snowBrick, "Snow Bricks");
		LanguageRegistry.addName(glassRefined, "Refined Glass");
		LanguageRegistry.addName(glassRefinedPane, "Refined Glass Pane");
		LanguageRegistry.addName(gunpowderBlock, "Block of Gunpowder");
		LanguageRegistry.addName(itemRope, "Rope");
		LanguageRegistry.addName(ropeCoil, "Rope Coil");
		LanguageRegistry.addName(oozeSlime, "Slime Ooze");
		LanguageRegistry.addName(oozeSlime, "Slime Ooze");
		LanguageRegistry.instance().addStringLocalization("tile.stoneLamp.glowstone.name", "Glowstone Stone Lamp");
		LanguageRegistry.instance().addStringLocalization("tile.stoneLamp.sunstone.name", "Sunstone Stone Lamp");
		LanguageRegistry.instance().addStringLocalization("tile.woodPanel.oak.name", "Oak Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodPanel.birch.name", "Birch Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodPanel.spruce.name", "Spruce Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodPanel.jungle.name", "Jungle Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodBeveled.oak.name", "Beveled Oak Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodBeveled.birch.name", "Beveled Birch Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodBeveled.spruce.name", "Beveled Spruce Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.woodBeveled.jungle.name", "Beveled Jungle Wood Panel");
		LanguageRegistry.instance().addStringLocalization("tile.sandstoneBrick.brick.name", "Sandstone Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.sandstoneBrick.chiseled.name", "Patterned Sandstone Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.sandstoneBrick.mossy.name", "Mossy Sandstone Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.sandstoneBrick.heiroglyph.name", "Sandstone Heiroglyphs");
		LanguageRegistry.instance().addStringLocalization("tile.sandstoneBrick.heiroglyph_2.name", "Sandstone Heiroglyphs");
		LanguageRegistry.addName(sandstonePillar, "Sandstone Pillar");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoards.oak.name", "Oak Wood Boards");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoards.birch.name", "Birch Wood Boards");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoards.spruce.name", "Spruce Wood Boards");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoards.jungle.name", "Jungle Wood Boards");
		LanguageRegistry.addName(sugarBlock, "Block of Sugar");
		LanguageRegistry.addName(meatBlock, "Block of Meat");
		LanguageRegistry.addName(magmaOoze, "Magma Ooze");
		LanguageRegistry.addName(enderBlock, "Ender Block");
		LanguageRegistry.addName(crate, "Crate");
		LanguageRegistry.addName(barrel, "Barrel");
		//LanguageRegistry.addName(EDItemManager.cardboardItem, "Cardboard");
		LanguageRegistry.addName(cardboardBlock, "Cardboard Block");
		LanguageRegistry.addName(cardboardWet, "Wet Cardboard");
		
		LanguageRegistry.addName(woodBoardsStairsOak, "Oak Board Stairs");
		LanguageRegistry.addName(woodBoardsStairsBirch, "Birch Board Stairs");
		LanguageRegistry.addName(woodBoardsStairsSpruce, "Spruce Board Stairs");
		LanguageRegistry.addName(woodBoardsStairsJungle, "Jungle Board Stairs");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoardsSingleSlab.oak.name", "Oak Board Slab");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoardsSingleSlab.birch.name", "Birch Board Slab");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoardsSingleSlab.spruce.name", "Spruce Board Slab");
		LanguageRegistry.instance().addStringLocalization("tile.woodBoardsSingleSlab.jungle.name", "Jungle Board Slab");	
		LanguageRegistry.addName(checkerTileStairs, "Checker Tile Stairs");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.white.name", "White Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.lightGrey.name", "Light Grey Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.darkGrey.name", "Grey Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.black.name", "Black Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.brown.name", "Brown Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.pink.name", "Pink Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.red.name", "Red Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.orange.name", "Orange Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.yellow.name", "Yellow Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.lime.name", "Lime Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.green.name", "Green Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.cyan.name", "Cyan Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.lightBlue.name", "Light Blue Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.blue.name", "Blue Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.purple.name", "Purple Stained Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.stainedBrick.magenta.name", "Magenta Stained Bricks");
		LanguageRegistry.addName(cobbledRoad, "Cobbled Road");
		LanguageRegistry.addName(sandyRoad, "Sandy Road");
		LanguageRegistry.addName(sandstoneRoad, "Sandstone Road");
		LanguageRegistry.addName(gravelRoad, "Gravel Road");
		LanguageRegistry.addName(StatueTest, "Test");
		LanguageRegistry.instance().addStringLocalization("tile.woodPlanksMossy.Oak.name", "Mossy Oak Wood Planks");
		LanguageRegistry.instance().addStringLocalization("tile.woodPlanksMossy.Birch.name", "Mossy Birch Wood Planks");
		LanguageRegistry.instance().addStringLocalization("tile.woodPlanksMossy.Spruce.name", "Mossy Spruce Wood Planks");
		LanguageRegistry.instance().addStringLocalization("tile.woodPlanksMossy.Jungle.name", "Mossy Jungle Wood Planks");
		
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.0.name", "Corner 0");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.1.name", "Corner 1");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.2.name", "Corner 2");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.3.name", "Corner 3");
		
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.4.name", "End 0");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.5.name", "End 1");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.6.name", "End 2");
		LanguageRegistry.instance().addStringLocalization("tile.block_edgeStoneBrickCorner.7.name", "End 3");
		
		LanguageRegistry.instance().addStringLocalization("tile.null.tile.name", "Stone Tiles");
		LanguageRegistry.instance().addStringLocalization("tile.null.refined.name", "Refined Stone");
		
		LanguageRegistry.instance().addStringLocalization("tile.block_Endstone.smooth.name", "Smooth End Stone");
		LanguageRegistry.instance().addStringLocalization("tile.block_Endstone.refined.name", "Refined End Stone");
		LanguageRegistry.instance().addStringLocalization("tile.block_Endstone.brick.name", "End Stone Bricks");
		
		LanguageRegistry.instance().addStringLocalization("tile.null.obsidian.name", "Obsidian Tile");
		LanguageRegistry.instance().addStringLocalization("tile.null.flint.name", "Flint Tile");
		LanguageRegistry.instance().addStringLocalization("tile.null.nether.name", "Nether Quartz Tile");
		LanguageRegistry.instance().addStringLocalization("tile.null.checker.name", "Checker Tiles");
		LanguageRegistry.instance().addStringLocalization("tile.null.brick.name", "Patterned Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.null.fb.name", "Block of Flint");
		LanguageRegistry.instance().addStringLocalization("tile.null.nb.name", "Patterned Nether Bricks");
		
		LanguageRegistry.instance().addStringLocalization("tile.stonePillar.name", "Stone Pillar");
	
		
	}
	
	public static void loadBridgedBlocks() throws Exception
	{
		if(Loader.isModLoaded("ExtraOres"))
		{
			bedrockBrick = new BlockBedrockBrick(EDConfig.bedrockBrickID).setUnlocalizedName("block_BedrockBrick").setStepSound(Block.soundStoneFootstep).setResistance(100000000F).setHardness(80F).setCreativeTab(tabDecorBlocks);
			GameRegistry.registerBlock(bedrockBrick,"block_BedrockBrick");
			MinecraftForge.setBlockHarvestLevel(EDBlockManager.bedrockBrick, "pickaxe", 4);
			LanguageRegistry.addName(bedrockBrick, "Bedrock Bricks");
		}
	
	}
}
