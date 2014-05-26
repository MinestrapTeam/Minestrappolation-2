package com.minestrappolation_core.lib;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.item.MCItem;
import com.minestrappolation_core.item.MCItemMulti;
import com.minestrappolation_core.util.MCAssetManager;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;

public class MCItems
{
	public static Item	brickStone;
	
	public static Item	brickSandstone;
	public static Item	brickClay;
	public static Item	brickColoredClay;
	
	public static void init()
	{
		brickStone = new Item().setUnlocalizedName("stone_brick").setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getMCoreTexture("stone_brick"));
		brickSandstone = new MCItem().setUnlocalizedName("sandstone_brick").setCreativeTab(Minestrappolation.tabStoneDecor).setTextureName(MCAssetManager.getStonecutterTexture("sandstone_brick"));
		brickColoredClay = new MCItemMulti("stonecutter", new String[] { MCAssetManager.getTexture("black_clay_brick"), MCAssetManager.getTexture("blue_clay_brick"), MCAssetManager.getTexture("brown_clay_brick"), MCAssetManager.getTexture("cyan_clay_brick"), MCAssetManager.getTexture("grey_clay_brick"), MCAssetManager.getTexture("green_clay_brick"), MCAssetManager.getTexture("lightblue_clay_brick"), MCAssetManager.getTexture("lime_clay_brick"), MCAssetManager.getTexture("magenta_clay_brick"), MCAssetManager.getTexture("orange_clay_brick"), MCAssetManager.getTexture("pink_clay_brick"), MCAssetManager.getTexture("purple_clay_brick"), MCAssetManager.getTexture("red_clay_brick"), MCAssetManager.getTexture("silver_clay_brick"), MCAssetManager.getTexture("white_clay_brick"), MCAssetManager.getTexture("yellow_clay_brick") }).setUnlocalizedName("clay_brick").setCreativeTab(Minestrappolation.tabStoneDecor);
		
		GameRegistry.registerItem(brickStone, "stone_brick");
		GameRegistry.registerItem(brickSandstone, "sandstone_brick");
		GameRegistry.registerItem(brickColoredClay, "clay_brick");
	}
}
