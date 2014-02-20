package sobiohazardous.minestrappolation.extradecor.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.item.BlockPlacer;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.item.MItemBlockPlacer;
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
import sobiohazardous.minestrappolation.extraenviroments.lib.ItemGDoor;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTextureTile;
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
		cardboardItem = new MItemBlockPlacer(EDConfig.cardboardItemId, EDBlockManager.cardboard).setCreativeTab(EDBlockManager.tabDecorBlocks).setUnlocalizedName("item_Cardboard");
		sandstoneBrickItem = new MItem(EDConfig.sandstoneBrickItemId).setUnlocalizedName("item_SandstoneBrick").setCreativeTab(EDBlockManager.tabDecorBlocks);
		stoneBrickItem = new MItem(EDConfig.stoneBrickItemId).setUnlocalizedName("item_StoneBrick").setCreativeTab(EDBlockManager.tabDecorBlocks);
		gobletItem = new BlockPlacer(EDConfig.gobletId,EDBlockManager.Goblet.blockID,0).setCreativeTab(EDBlockManager.tabDecorBlocks).setUnlocalizedName("item_GobletEmpty");
		gDoor = new ItemGDoor(EDConfig.glassDoorItemId, Material.glass).setUnlocalizedName("item_GlassDoor");
	}
	
	public static void addItemNames()
	{
		LanguageRegistry.addName(cardboardItem, "Cardboard");
		LanguageRegistry.addName(sandstoneBrickItem, "Sandstone Brick");
		LanguageRegistry.addName(stoneBrickItem, "Stone Brick");
		LanguageRegistry.addName(gobletItem, "Goblet");
		LanguageRegistry.addName(gDoor, "Glass Door");
	}
	
	public static void setHarvestLevels()
	{
		MinecraftForge.setToolClass(Item.shears, "shears", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.snowBrick, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.Tiles,5, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.Tiles,0, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.gunpowderBlock, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sugarBlock, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.ropeCoil, "shears", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.rope, "shears", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.Tiles,1, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.Tiles,3, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.checkerTileStairs, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.oozeSlime, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.magmaOoze, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.cobbledRoad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.refinedRoad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandyRoad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneRoad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.gravelRoad, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.netherroad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.refinedNetherroad, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneBricks,0, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneBricks,1, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneBricks,2, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneBricks,3, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.sandstoneBricks,4, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EDBlockManager.infertileDirt, "shovel", 0);
	}
	
	public static void addItemsToItemList()
	{
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
		Item.itemsList[EDBlockManager.woodBoardsSingleSlab.blockID] = (new ItemSlab(EDBlockManager.woodBoardsSingleSlab.blockID - 256, (BlockHalfSlab)EDBlockManager.woodBoardsSingleSlab, (BlockHalfSlab)EDBlockManager.woodBoardsDoubleSlab, false));
	}

}
