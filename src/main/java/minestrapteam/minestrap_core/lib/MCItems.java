package minestrapteam.minestrap_core.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrap_core.item.MCItem;
import minestrapteam.minestrap_core.item.MCItemMulti;
import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.item.Item;

public class MCItems
{
	public static Item	brickStone;
	
	public static Item	brickSandstone;
	public static Item	brickClay;
	public static Item	brickColoredClay;
	
	public static void init()
	{
		brickStone = new Item().setUnlocalizedName("stone_brick").setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("stone_brick"));
		brickSandstone = new MCItem().setUnlocalizedName("sandstone_brick").setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("sandstone_brick"));
		brickColoredClay = new MCItemMulti("stonecutter", new String[] {
				MCAssetManager.getStonecutterTexture("black_clay_brick"),
				MCAssetManager.getStonecutterTexture("blue_clay_brick"),
				MCAssetManager.getStonecutterTexture("brown_clay_brick"),
				MCAssetManager.getStonecutterTexture("cyan_clay_brick"),
				MCAssetManager.getStonecutterTexture("grey_clay_brick"),
				MCAssetManager.getStonecutterTexture("green_clay_brick"),
				MCAssetManager.getStonecutterTexture("lightblue_clay_brick"),
				MCAssetManager.getStonecutterTexture("lime_clay_brick"),
				MCAssetManager.getStonecutterTexture("magenta_clay_brick"),
				MCAssetManager.getStonecutterTexture("orange_clay_brick"),
				MCAssetManager.getStonecutterTexture("pink_clay_brick"),
				MCAssetManager.getStonecutterTexture("purple_clay_brick"),
				MCAssetManager.getStonecutterTexture("red_clay_brick"),
				MCAssetManager.getStonecutterTexture("silver_clay_brick"),
				MCAssetManager.getStonecutterTexture("white_clay_brick"),
				MCAssetManager.getStonecutterTexture("yellow_clay_brick") }).setUnlocalizedName("clay_brick").setCreativeTab(Minestrappolation.tabStoneDecor);
		
		GameRegistry.registerItem(brickStone, "stone_brick");
		GameRegistry.registerItem(brickSandstone, "sandstone_brick");
		GameRegistry.registerItem(brickColoredClay, "clay_brick");
	}
}
