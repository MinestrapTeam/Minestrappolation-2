package sobiohazardous.mods.minestrappolation.extradecor.lib;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.core.item.MItemMulti;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.item.EDItemDoor;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

public class EDItems
{
	public static Item	cardboardItem;
	public static Item	sandstoneBrickItem;
	public static Item	gobletItem;
	public static Item	glassDoor;
	
	public static Item	brickClay;
	
	public static void addItems()
	{
		cardboardItem = new ItemReed(EDBlocks.cardboard).setCreativeTab(EDBlocks.tabDecor).setUnlocalizedName("item_Cardboard").setTextureName(MAssetManager.getEDTexture("cardboard"));
		GameRegistry.registerItem(cardboardItem, "cardboardItem");
		sandstoneBrickItem = new MItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(EDBlocks.tabDecor).setTextureName(MAssetManager.getEDTexture("brickSandstone"));
		GameRegistry.registerItem(sandstoneBrickItem, "sandstoneBrickItem");
		gobletItem = new ItemReed(EDBlocks.Goblet).setCreativeTab(EDBlocks.tabDecor).setUnlocalizedName("item_GobletEmpty").setTextureName(MAssetManager.getEDTexture("goblet"));
		GameRegistry.registerItem(gobletItem, "gobletItem");
		glassDoor = new EDItemDoor(EDBlocks.GlassDoor).setUnlocalizedName("item_GlassDoor").setTextureName(MAssetManager.getEDTexture("doorGlass"));
		GameRegistry.registerItem(glassDoor, "glassDoorItem");
		
		brickClay = new MItemMulti(new String[] { MAssetManager.getEDTexture("brickClayBlack"), MAssetManager.getEDTexture("brickClayBlue"), MAssetManager.getEDTexture("brickClayBrown"), MAssetManager.getEDTexture("brickClayCyan"), MAssetManager.getEDTexture("brickClayGray"), MAssetManager.getEDTexture("brickClayGreen"), MAssetManager.getEDTexture("brickClayLightBlue"), MAssetManager.getEDTexture("brickClayLime"), MAssetManager.getEDTexture("brickClayMagenta"), MAssetManager.getEDTexture("brickClayOrange"), MAssetManager.getEDTexture("brickClayPink"), MAssetManager.getEDTexture("brickClayPurple"), MAssetManager.getEDTexture("brickClayRed"), MAssetManager.getEDTexture("brickClaySilver"), MAssetManager.getEDTexture("brickClayWhite"), MAssetManager.getEDTexture("brickClayYellow") }).setCreativeTab(Minestrappolation.creativeTabStone).setUnlocalizedName("brickClay");
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
}
