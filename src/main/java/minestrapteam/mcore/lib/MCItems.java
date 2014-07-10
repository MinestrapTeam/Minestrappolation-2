package minestrapteam.mcore.lib;

import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.mcore.item.MCItem;
import minestrapteam.mcore.item.MCItemMulti;
import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.item.Item;


/**
* Minestrappolation Core's Items (Mostly Stonecutter Things).<br>
* Stained Clay Brick Item Metadata:
* <ul>
* <li>0: Black
* <li>1: Blue
* <li>2: Brown
* <li>3: Cyan
* <li>4: Grey
* <li>5: Green
* <li>6: Light Blue
* <li>7: Lime
* <li>8: Magenta
* <li>9: Orange
* <li>10: Pink
* <li>11: Purple
* <li>12: Red
* <li>13: Light Grey
* <li>14: White
* <li>15: Yellow
* </ul>
*/
public class MCItems
{
	public static Item	brickStone;
	public static Item	brickStoneTin;
	public static Item	brickStoneBronze;
	public static Item	brickStoneSteel;
	public static Item	brickStoneMeurodite;
	public static Item	brickSandstone;
	public static Item	brickRedSandstone;
	public static Item	brickClay;
	public static Item	brickColoredClay;
	public static Item  brickFlint;
	public static Item  brickLapis;
	public static Item  brickSlate;
	
	public static void init()
	{
		brickStone = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick"));
		brickStoneTin = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick_tin"));
		brickStoneBronze = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick_bronze"));
		brickStoneSteel = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick_steel"));
		brickStoneMeurodite = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick_meurodite"));
		brickSandstone = new MCItem().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("sandstone_brick"));
		brickRedSandstone = new MCItem().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("red_sandstone_brick"));
		brickColoredClay = new MCItemMulti(null, new String[] { MCAssetManager.getStonecutterTexture("black_clay_brick"), MCAssetManager.getStonecutterTexture("blue_clay_brick"), MCAssetManager.getStonecutterTexture("brown_clay_brick"), MCAssetManager.getStonecutterTexture("cyan_clay_brick"), MCAssetManager.getStonecutterTexture("grey_clay_brick"), MCAssetManager.getStonecutterTexture("green_clay_brick"), MCAssetManager.getStonecutterTexture("lightblue_clay_brick"), MCAssetManager.getStonecutterTexture("lime_clay_brick"), MCAssetManager.getStonecutterTexture("magenta_clay_brick"), MCAssetManager.getStonecutterTexture("orange_clay_brick"), MCAssetManager.getStonecutterTexture("pink_clay_brick"), MCAssetManager.getStonecutterTexture("purple_clay_brick"), MCAssetManager.getStonecutterTexture("red_clay_brick"), MCAssetManager.getStonecutterTexture("silver_clay_brick"), MCAssetManager.getStonecutterTexture("white_clay_brick"), MCAssetManager.getStonecutterTexture("yellow_clay_brick") })
				.setUnlocalizedName("clay_brick").setCreativeTab(Minestrappolation.tabStoneDecor);
		brickFlint = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("flint_brick"));
		brickLapis = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("lapis_brick"));
		brickSlate = new Item().setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("granite_brick"));
		
		CSItems.addItem(brickStone, "stone_brick");
		CSItems.addItem(brickStoneTin, "stone_brick_tin");
		CSItems.addItem(brickStoneBronze, "stone_brick_bronze");
		CSItems.addItem(brickStoneSteel, "stone_brick_steel");
		CSItems.addItem(brickStoneMeurodite, "stone_brick_meurodite");
		CSItems.addItem(brickSandstone, "sandstone_brick");
		CSItems.addItem(brickRedSandstone, "red_sandstone_brick");
		CSItems.addItem(brickColoredClay, "clay_brick");
		CSItems.addItem(brickFlint, "flint_brick");
		CSItems.addItem(brickLapis, "lapis_brick");
		CSItems.addItem(brickSlate, "granite_brick");
	}
}
