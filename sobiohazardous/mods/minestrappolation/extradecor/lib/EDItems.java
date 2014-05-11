package sobiohazardous.mods.minestrappolation.extradecor.lib;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.core.item.MItemMulti;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.creativetab.CreativeTabEDItems;
import sobiohazardous.mods.minestrappolation.extradecor.item.EDItemDoor;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

public class EDItems
{
	public static CreativeTabs	tabItems	= new CreativeTabEDItems(CreativeTabs.getNextID(), "ed_items");
	
	public static Item			ropeItem;
	public static Item			cardboardItem;
	public static Item			sandstoneBrick;
	public static Item			goblet;
	public static Item			glassDoor;
	
	public static Item			brickClay;
	
	public static void init()
	{
		ropeItem = new ItemReed(EDBlocks.rope).setUnlocalizedName("rope").setCreativeTab(tabItems).setTextureName(MAssetManager.getEDTexture("rope"));
		cardboardItem = new ItemReed(EDBlocks.cardboard).setCreativeTab(tabItems).setUnlocalizedName("item_Cardboard").setTextureName(MAssetManager.getEDTexture("cardboard"));
		sandstoneBrick = new MItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(tabItems).setTextureName(MAssetManager.getEDTexture("brickSandstone"));
		goblet = new ItemReed(EDBlocks.Goblet).setCreativeTab(tabItems).setUnlocalizedName("item_GobletEmpty").setTextureName(MAssetManager.getEDTexture("goblet"));
		glassDoor = new EDItemDoor(EDBlocks.GlassDoor).setUnlocalizedName("item_GlassDoor").setTextureName(MAssetManager.getEDTexture("doorGlass"));
		
		brickClay = new MItemMulti(new String[] { MAssetManager.getEDTexture("brickClayBlack"), MAssetManager.getEDTexture("brickClayBlue"), MAssetManager.getEDTexture("brickClayBrown"), MAssetManager.getEDTexture("brickClayCyan"), MAssetManager.getEDTexture("brickClayGray"), MAssetManager.getEDTexture("brickClayGreen"), MAssetManager.getEDTexture("brickClayLightBlue"), MAssetManager.getEDTexture("brickClayLime"), MAssetManager.getEDTexture("brickClayMagenta"), MAssetManager.getEDTexture("brickClayOrange"), MAssetManager.getEDTexture("brickClayPink"), MAssetManager.getEDTexture("brickClayPurple"), MAssetManager.getEDTexture("brickClayRed"), MAssetManager.getEDTexture("brickClaySilver"), MAssetManager.getEDTexture("brickClayWhite"), MAssetManager.getEDTexture("brickClayYellow") }).setCreativeTab(Minestrappolation.creativeTabStone).setUnlocalizedName("brickClay");
		
		GameRegistry.registerItem(ropeItem, "itemRope");
		GameRegistry.registerItem(cardboardItem, "cardboardItem");
		GameRegistry.registerItem(sandstoneBrick, "sandstoneBrickItem");
		GameRegistry.registerItem(goblet, "gobletItem");
		GameRegistry.registerItem(glassDoor, "glassDoorItem");
		GameRegistry.registerItem(brickClay, "brickClay");
	}
	
	public static void load()
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
