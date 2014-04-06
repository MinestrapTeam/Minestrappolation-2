package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extradecor.block.Block100;
import sobiohazardous.minestrappolation.extradecor.block.BlockEdgeStoneCorner;
import sobiohazardous.minestrappolation.extradecor.block.BlockEndStone;
import sobiohazardous.minestrappolation.extradecor.block.BlockGoblet;
import sobiohazardous.minestrappolation.extradecor.block.BlockMossyWood;
import sobiohazardous.minestrappolation.extradecor.block.BlockSandstoneBrick;
import sobiohazardous.minestrappolation.extradecor.block.BlockStainedBrick;
import sobiohazardous.minestrappolation.extradecor.block.BlockStoneLamp;
import sobiohazardous.minestrappolation.extradecor.block.BlockStones;
import sobiohazardous.minestrappolation.extradecor.block.BlockTiles;
import sobiohazardous.minestrappolation.extradecor.block.BlockWoodBeveled;
import sobiohazardous.minestrappolation.extradecor.block.BlockWoodBoards;
import sobiohazardous.minestrappolation.extradecor.block.BlockWoodPanel;
import sobiohazardous.minestrappolation.extradecor.bridge.EDBridgeRecipes;
import sobiohazardous.minestrappolation.extradecor.item.ItemGDoor;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.MinecraftForge;

public class EDItemManager 
{
	public static Item cardboardItem;	
	public static Item sandstoneBrickItem;
	public static Item stoneBrickItem;
	public static Item gobletItem;
	public static Item gDoor;
	
	public static void addItems()
	{
		cardboardItem = new ItemReed(EDBlockManager.cardboard).setCreativeTab(EDBlockManager.tabDecorBlocks).setUnlocalizedName("item_Cardboard");
		sandstoneBrickItem = new MItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(EDBlockManager.tabDecorBlocks);
		GameRegistry.registerItem(sandstoneBrickItem, "sandstoneBrickItem");
		stoneBrickItem = new MItem().setUnlocalizedName("item_StoneBrick").setCreativeTab(EDBlockManager.tabDecorBlocks);
		GameRegistry.registerItem(stoneBrickItem, "stoneBrickItem");
		gobletItem = new ItemReed(EDBlockManager.Goblet).setCreativeTab(EDBlockManager.tabDecorBlocks).setUnlocalizedName("item_GobletEmpty");
		gDoor = new ItemGDoor(Material.glass).setUnlocalizedName("item_GlassDoor");
		GameRegistry.registerItem(gDoor, "glassDoorItem");
	}
	
	public static void setHarvestLevels()
	{
		EDBlockManager.snowBrick.setHarvestLevel("shovel", 0);
		EDBlockManager.Tiles.setHarvestLevel("pickaxe", 1, 1);
		EDBlockManager.Tiles.setHarvestLevel("pickaxe", 1, 3);
		EDBlockManager.Tiles.setHarvestLevel("pickaxe", 1, 5);
		EDBlockManager.Tiles.setHarvestLevel("pickaxe", 3, 0);
		EDBlockManager.gunpowderBlock.setHarvestLevel("shovel", 0);
		EDBlockManager.sugarBlock.setHarvestLevel("shovel", 0);
		EDBlockManager.ropeCoil.setHarvestLevel("shears", 0);
		EDBlockManager.rope.setHarvestLevel("shears", 0);
		EDBlockManager.checkerTileStairs.setHarvestLevel("pickaxe", 1);
		EDBlockManager.oozeSlime.setHarvestLevel("shovel", 0);
		EDBlockManager.magmaOoze.setHarvestLevel("shovel", 0);
		EDBlockManager.cobbledRoad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.refinedRoad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.sandyRoad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.sandstoneRoad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.gravelRoad.setHarvestLevel("shovel", 0);
		EDBlockManager.netherroad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.refinedNetherroad.setHarvestLevel("pickaxe", 0);
		EDBlockManager.sandstoneBricks.setHarvestLevel("pickaxe", 0, 0);
		EDBlockManager.sandstoneBricks.setHarvestLevel("pickaxe", 0, 1);
		EDBlockManager.sandstoneBricks.setHarvestLevel("pickaxe", 0, 2);
		EDBlockManager.sandstoneBricks.setHarvestLevel("pickaxe", 0, 3);
		EDBlockManager.sandstoneBricks.setHarvestLevel("pickaxe", 0, 4);
		EDBlockManager.infertileDirt.setHarvestLevel("shovel", 0);
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
