package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.block.BlockPillar;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.CreativeTabExtraDecorBlocks;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.block.*;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockEdgeStoneCorner;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockEndstone;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockGoblet;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockMossyWood;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockSandstoneBrick;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockStainedBrick;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockStoneLamp;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockStones;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockTiles;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockWoodBeveled;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockWoodBoardSlab;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockWoodBoards;
import sobiohazardous.minestrappolation.extradecor.itemblocks.ItemBlockWoodPanel;
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

public class EDBlockManager 
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

	public static CreativeTabs tabDecorBlocks = new CreativeTabExtraDecorBlocks(CreativeTabs.getNextID(),"Extrappolated Decor");
	public static void createBlocks()
	{
		stonePillar = (new BlockPillar(MAssetManager.getEDStonecutterTexture("Stone_Pillar_Side_0"), MAssetManager.getEDStonecutterTexture("Stone_Pillar_Top_0"))).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("stonePillar");
		stoneLamp = (new BlockStoneLamp()).setHardness(1.5F).setResistance(8F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setBlockName("stoneLamp");
		stones = new BlockStones().setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone);
		
		Tiles = new BlockTiles().setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("tiles");
	
		edgeStoneBrick = (new BlockEdgeStoneBrick()).setHardness(1.5F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrick");
		edgeStoneBrickCorner = (new BlockEdgeStoneCorner()).setHardness(1.5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrickCorner");
	
		snowBrick = (new BlockSnowBrick()).setHardness(0.3F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeSnow).setBlockName("tilesSnow").setBlockTextureName(MAssetManager.getEDTexture("tilesSnow"));
	
		endstone = (new BlockEndStone()).setHardness(3.0F).setResistance(15.0F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("Endstone");
	
		glassRefined = (new BlockGlassRefined(Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecorBlocks).setBlockName("glassRefined");
		glassRefinedPane = (new EDBlockPane("ClearGlass", "ClearGlassTop", Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecorBlocks).setBlockName("glassRefinedPane");
		gunpowderBlock = (new BlockGunpowderBlock(Material.ground)).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("GunpowderBlock").setBlockTextureName(MAssetManager.getEDTexture("blockGunpowder"));
	
		rope = (new BlockRope()).setHardness(0.9F).setStepSound(Block.soundTypeCloth).setBlockName("rope");
		itemRope = (new ItemReed(rope)).setUnlocalizedName("rope").setCreativeTab(tabDecorBlocks).setTextureName(MAssetManager.getEDTexture("rope"));
		ropeCoil = (new BlockRopeCoil()).setHardness(0.9F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeCloth).setBlockName("ropeCoil");
	
		oozeSlime = (new BlockOoze(materialOoze)).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("SlimeOoze").setBlockTextureName(MAssetManager.getEDTexture("oozeSlime"));
	
		woodPanel = (new BlockWoodPanel()).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPanel");
		
		woodBeveled = (new BlockWoodBeveled()).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodBeveled");
	
		sandstoneBricks = (new BlockSandstoneBrick()).setHardness(1F).setStepSound(Block.soundTypeStone).setBlockName("sandstoneBrick");
		sandstonePillar = new BlockPillar(MAssetManager.getEDStonecutterTexture("Sandstone_Pillar_Side_0"), MAssetManager.getEDStonecutterTexture("Sandstone_Pillar_Top_0")).setBlockName("sandstonePillar").setHardness(1F).setStepSound(Block.soundTypeStone);
	
		woodBoards = new BlockWoodBoards().setHardness(2.0F).setResistance(5.0F).setBlockName("woodBoards").setStepSound(Block.soundTypeWood);
		//TODO add the rest of the boards after Extrapolated Nature

		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("SugarBlock").setBlockTextureName(MAssetManager.getEDTexture("blockSugar"));
		meatBlock = new BlockMeatBlock("MeatBlock").setHardness(0.8F).setStepSound(Block.soundTypeCloth).setBlockName("MeatBlock").setBlockTextureName(MAssetManager.getEDTexture("blockRawMeat"));
	
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("MagmaOoze").setBlockTextureName(MAssetManager.getEDTexture("oozeMagma"));
	
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setBlockName("EnderBlock").setStepSound(Block.soundTypeGlass).setCreativeTab(tabDecorBlocks).setBlockTextureName(MAssetManager.getEDTexture("blockEnderPearl"));
	
		crate = new BlockCrate().setHardness(2.5F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks).setBlockName("crate");
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks).setBlockName("barrel");
	
		cardboard = new EDBlockPane("CardboardBlock", "CardboardEdge", Material.cloth, true).setHardness(0.3F).setBlockName("cardboard");
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setBlockName("CardboardBlock").setCreativeTab(tabDecorBlocks);
		cardboardWet = new BlockCardboardWet(Material.cloth).setCreativeTab(tabDecorBlocks).setHardness(0.2F).setResistance(0.8F).setBlockName("cardboardWet");
		
		woodBoardsStairsOak = new EDBlockStairs(woodBoards, 0).setBlockName("woodBoardsStairsOak").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsBirch = new EDBlockStairs(woodBoards, 1).setBlockName("woodBoardsStairsBirch").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsSpruce = new EDBlockStairs(woodBoards, 2).setBlockName("woodBoardsStairsSpruce").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks);
		woodBoardsStairsJungle = new EDBlockStairs(woodBoards, 3).setBlockName("woodBoardsStairsJungle").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabDecorBlocks);
		woodBoardsSingleSlab = (BlockSlab) new BlockWoodBoardSlab(false).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		woodBoardsDoubleSlab = (BlockSlab) new BlockWoodBoardSlab( true).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);

		checkerTileStairs = new EDBlockStairs(Tiles, 3).setBlockName("checkerTileStairs").setHardness(3F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabDecorBlocks);
	
		stainedBrick = (new BlockStainedBrick()).setHardness(2F).setResistance(10F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("stainedBrick");
	
		cobbledRoad = (new BlockCobbledRoad()).setHardness(1).setResistance(5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("cobbledRoad");
		infertileDirt = new MBlock(Material.grass).setCreativeTab(tabDecorBlocks).setBlockName("InfertileSoil").setHardness(.4F).setStepSound(Block.soundTypeGrass).setBlockTextureName(MAssetManager.getEDTexture("grasslessDirt"));
		refinedRoad = (new BlockRefinedRoad()).setHardness(2F).setResistance(5F).setBlockName("RefinedRoad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecorBlocks);
		
		sandyRoad = (new BlockSandyRoad()).setHardness(0.8F).setResistance(4F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandyRoad");
		sandstoneRoad = (new BlockSandyRoad()).setHardness(1).setResistance(4.5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandstoneRoad");
		gravelRoad = (new BlockSandyRoad()).setHardness(1.5F).setResistance(5F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundTypeStone).setBlockName("gravelRoad");
		netherroad = (new BlockRefinedRoad()).setHardness(2.2F).setResistance(4F).setBlockName("netherroad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecorBlocks);
		refinedNetherroad = (new BlockRefinedRoad()).setHardness(2.8F).setResistance(6F).setBlockName("refinedNetherroad").setStepSound(Block.soundTypeStone).setCreativeTab(tabDecorBlocks);

		woodPlanksMossy = new BlockMossyWood().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPlanksMossy").setCreativeTab(tabDecorBlocks);
		
		//Test
		Goblet = new BlockGoblet(Material.rock).setHardness(.5F);
		Plate = new BlockPlate(Material.rock);
		
		GlassDoor = (new BlockGlassDoor(Material.glass)).setHardness(1F);

	}
	
	public static void loadVanillaOverwrites()
	{
		//add vanilla overwrites	    
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(GlassDoor ,"GlassDoor");
		GameRegistry.registerBlock(edgeStoneBrickCorner, ItemBlockEdgeStoneCorner.class, "edgeCorner");
		GameRegistry.registerBlock(refinedRoad,"refinedRoad");
		registerBlock(stoneLamp, ItemBlockStoneLamp.class);
		GameRegistry.registerBlock(edgeStoneBrick, "edgeStoneBrick");
		GameRegistry.registerBlock(snowBrick, "snowBrick");
		registerBlock(endstone, ItemBlockEndstone.class);
		GameRegistry.registerBlock(glassRefined, "glassRefined");
		GameRegistry.registerBlock(glassRefinedPane, "glassRefinedPane");
		GameRegistry.registerBlock(gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(rope, "rope");
		GameRegistry.registerBlock(ropeCoil, "ropeCoil");
		registerBlock(woodPanel, ItemBlockWoodPanel.class);
		registerBlock(woodBeveled, ItemBlockWoodBeveled.class);
		GameRegistry.registerBlock(oozeSlime, "oozeSlime");
		registerBlock(sandstoneBricks, ItemBlockSandstoneBrick.class);
		GameRegistry.registerBlock(sandstonePillar, "sandstonePillar");
		GameRegistry.registerBlock(stonePillar, "stonePillar");
		registerBlock(woodBoards, ItemBlockWoodBoards.class);
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
		registerBlock(woodBoardsSingleSlab, ItemBlockWoodBoardSlab.class);
		registerBlock(woodBoardsDoubleSlab, ItemBlockWoodBoardSlab.class);
		GameRegistry.registerBlock(checkerTileStairs, "checkerTileStairs");
		registerBlock(stainedBrick, ItemBlockStainedBrick.class);
		GameRegistry.registerBlock(cobbledRoad, "cobbledRoad");
		GameRegistry.registerBlock(infertileDirt,"Infertile Dirt");
		GameRegistry.registerBlock(sandyRoad, "sandyRoad");
		GameRegistry.registerBlock(sandstoneRoad, "sandstoneRoad");
		GameRegistry.registerBlock(gravelRoad, "gravelRoad");
		GameRegistry.registerBlock(netherroad, "netherroad");
		GameRegistry.registerBlock(refinedNetherroad, "refinedNetherroad");
		GameRegistry.registerBlock(Goblet, ItemBlockGoblet.class, "Goblet");
		GameRegistry.registerBlock(Plate,"Plate");
		registerBlock(woodPlanksMossy, ItemBlockMossyWood.class);
		GameRegistry.registerBlock(stones, ItemBlockStones.class, "Stones");
		registerBlock(Tiles, ItemBlockTiles.class);
	}
	
	public static void loadBridgedBlocks() throws Exception
	{
		if(Loader.isModLoaded(MAPIReference.MODID_EO))
		{
			bedrockBrick = new BlockBedrockBrick().setBlockName("BedrockBrick").setStepSound(Block.soundTypeStone).setResistance(100000000F).setHardness(80F).setCreativeTab(tabDecorBlocks).setBlockTextureName(MAssetManager.getEDStonecutterTexture("Bedrock_Tiles_0_0"));
			GameRegistry.registerBlock(bedrockBrick,"BedrockBrick");
			bedrockBrick.setHarvestLevel("pickaxe", 4);
		}
	
	}
	
	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass, Object... constructorArgs)
    {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName(), "ExtraDecor", constructorArgs);
    }
}
