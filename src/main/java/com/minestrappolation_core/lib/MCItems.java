package com.minestrappolation_core.lib;

import com.minestrappolation_core.util.MCAssetManager;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;

public class MCItems
{
	public static Item	brickStone;
	
	public static void init()
	{
		brickStone = new Item().setTextureName(MCAssetManager.getMAPITexture("brickStone")).setUnlocalizedName("brickStone");
		GameRegistry.registerItem(brickStone, "brickStone");
	}
}
