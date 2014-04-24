package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.item.MItemMulti;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.item.ItemGDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

public class EDItems 
{
	public static Item cardboardItem;	
	public static Item sandstoneBrickItem;
	public static Item gobletItem;
	public static Item gDoor;
	
	public static Item brickClay;
	
	public static void addItems()
	{
		cardboardItem = new ItemReed(EDBlocks.cardboard).setCreativeTab(EDBlocks.tabDecor).setUnlocalizedName("item_Cardboard").setTextureName(MAssetManager.getEDTexture("cardboard"));
		GameRegistry.registerItem(cardboardItem, "cardboardItem");
		sandstoneBrickItem = new MItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(EDBlocks.tabDecor).setTextureName(MAssetManager.getEDTexture("brickSandstone"));
		GameRegistry.registerItem(sandstoneBrickItem, "sandstoneBrickItem");
		gobletItem = new ItemReed(EDBlocks.Goblet).setCreativeTab(EDBlocks.tabDecor).setUnlocalizedName("item_GobletEmpty").setTextureName(MAssetManager.getEDTexture("goblet"));
		GameRegistry.registerItem(gobletItem, "gobletItem");
		gDoor = new ItemGDoor(Material.glass).setUnlocalizedName("item_GlassDoor").setTextureName(MAssetManager.getEDTexture("doorGlass"));
		GameRegistry.registerItem(gDoor, "glassDoorItem");
		
		brickClay = new MItemMulti(new String[]{MAssetManager.getEDTexture("brickClayBlack"), MAssetManager.getEDTexture("brickClayBlue"), MAssetManager.getEDTexture("brickClayBrown"), MAssetManager.getEDTexture("brickClayCyan"), MAssetManager.getEDTexture("brickClayGray"), MAssetManager.getEDTexture("brickClayGreen"), MAssetManager.getEDTexture("brickClayLightBlue"), MAssetManager.getEDTexture("brickClayLime"), MAssetManager.getEDTexture("brickClayMagenta"), MAssetManager.getEDTexture("brickClayOrange"), MAssetManager.getEDTexture("brickClayPink"), MAssetManager.getEDTexture("brickClayPurple"), MAssetManager.getEDTexture("brickClayRed"), MAssetManager.getEDTexture("brickClaySilver"), MAssetManager.getEDTexture("brickClayWhite"), MAssetManager.getEDTexture("brickClayYellow")}).setCreativeTab(Minestrappolation.creativeTabStone).setUnlocalizedName("brickClay");
		GameRegistry.registerItem(brickClay, "brickClay");
	}
	
	public static void setHarvestLevels()
	{
		EDBlocks.snowBrick.setHarvestLevel("shovel", 0);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 1);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 3);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 5);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 3, 0);
		EDBlocks.gunpowderBlock.setHarvestLevel("shovel", 0);
		EDBlocks.sugarBlock.setHarvestLevel("shovel", 0);
		EDBlocks.ropeCoil.setHarvestLevel("shears", 0);
		EDBlocks.rope.setHarvestLevel("shears", 0);
		EDBlocks.checkerTileStairs.setHarvestLevel("pickaxe", 1);
		EDBlocks.oozeSlime.setHarvestLevel("shovel", 0);
		EDBlocks.magmaOoze.setHarvestLevel("shovel", 0);
		EDBlocks.cobbledRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.refinedRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandyRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandstoneRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.gravelRoad.setHarvestLevel("shovel", 0);
		EDBlocks.netherroad.setHarvestLevel("pickaxe", 0);
		EDBlocks.refinedNetherroad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 0);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 1);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 2);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 3);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 4);
		EDBlocks.infertileDirt.setHarvestLevel("shovel", 0);
	}
	
	public static void addItemsToItemList()
	{
		/* old 1.6.4 code
		Item.itemsList[EDBlockManager.stoneLamp.blockID] = (new ItemMultiTextureTile(EDBlockManager.stoneLamp.blockID - 256, EDBlockManager.stoneLamp, BlockStoneLamp.lampType)).setUnlocalizedName("stoneLamp");
		Item.itemsList[EDBlockManager.woodPanel.blockID] = (new ItemMultiTextureTile(EDBlockManager.woodPanel.blockID - 256, EDBlockManager.woodPanel, BlockWoodPanel.woodType)).setUnlocalizedName("woodPanel");
		Item.itemsList[EDBlockManager.woodBeveled.blockID] = (new ItemMultiTextureTile(EDBlockManager.woodBeveled.blockID - 256, EDBlockManager.woodBeveled, BlockWoodBeveled.woodType)).setUnlocalizedName("woodBeveled");
		Item.itemsList[EDBlockManager.sandstoneBricks.blockID] = (new ItemMultiTextureTile(EDBlockManager.sandstoneBricks.blockID - 256, EDBlockManager.sandstoneBricks, BlockSandstoneBrick.sandType)).setUnlocalizedName("sandstoneBrick");
		Item.itemsList[EDBlockManager.woodBoards.blockID] = (new ItemMultiTextureTile(EDBlockManager.woodBoards.blockID - 256, EDBlockManager.woodBoards, BlockWoodBoards.woodType)).setUnlocalizedName("woodBoards");
		Item.itemsList[EDBlockManager.stainedBrick.blockID] = (new ItemMultiTextureTile(EDBlockManager.stainedBrick.blockID - 256, EDBlockManager.stainedBrick, BlockStainedBrick.brickType)).setUnlocalizedName("stainedBrick");
		Item.itemsList[EDBlockManager.edgeStoneBrickCorner.blockID] = (new ItemMultiTextureTile(EDBlockManager.edgeStoneBrickCorner.blockID - 256, EDBlockManager.edgeStoneBrickCorner,BlockEdgeStoneCorner.cType)).setUnlocalizedName("stainedBrick");
		Item.itemsList[EDBlockManager.woodPlanksMossy.blockID] = (new ItemMultiTextureTile(EDBlockManager.woodPlanksMossy.blockID - 256, EDBlockManager.woodPlanksMossy, BlockMossyWood.woodType)).setUnlocalizedName("woodPlanksMossy");
		Item.itemsList[EDBlockManager.stones.blockID] = (new ItemMultiTextureTile(EDBlockManager.stones.blockID - 256, EDBlockManager.stones,BlockStones.brickType)).setUnlocalizedName("Stones");
		Item.itemsList[EDBlockManager.endstone.blockID] = (new ItemMultiTextureTile(EDBlockManager.endstone.blockID - 256, EDBlockManager.endstone,BlockEndStone.bType)).setUnlocalizedName("EndStone");
		Item.itemsList[EDBlockManager.Tiles.blockID] = (new ItemMultiTextureTile(EDBlockManager.Tiles.blockID - 256, EDBlockManager.Tiles,BlockTiles.brickType)).setUnlocalizedName("Tiles");
		Item.itemsList[EDBlockManager.Goblet.blockID] = (new ItemMultiTextureTile(EDBlockManager.Goblet.blockID - 256, EDBlockManager.Goblet,BlockGoblet.g)).setUnlocalizedName("Goblets");
		//this for testing unlimited metadata
		//Item.itemsList[EDBlockManager.infertileDirt.blockID] = (new ItemMultiTextureTile(EDBlockManager.infertileDirt.blockID - 256, EDBlockManager.infertileDirt,Block100.brickType)).setUnlocalizedName("test");
		//TODO Forms of adding slabs
		Item.itemsList[EDBlockManager.woodBoardsSingleSlab.blockID] = (new ItemSlab(EDBlockManager.woodBoardsSingleSlab.blockID - 256, (BlockSlab)EDBlockManager.woodBoardsSingleSlab, (BlockSlab)EDBlockManager.woodBoardsDoubleSlab, false));
		*/
	}

}
