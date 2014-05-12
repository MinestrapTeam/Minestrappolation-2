package com.minestrappolation.lib;

import com.minestrappolation.tileentity.TileEntityBarrel;
import com.minestrappolation.tileentity.TileEntityCrate;
import com.minestrappolation.tileentity.TileEntityGoblet;

import cpw.mods.fml.common.registry.GameRegistry;

public class MTileEntities
{
	public static void registerTileEntitys()
	{
		GameRegistry.registerTileEntityWithAlternatives(TileEntityCrate.class, "Crate", "tileEntityCrate");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityBarrel.class, "Barrel", "tileEntityBarrel");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityGoblet.class, "Goblet", "tileEntitygoblet");
	}
}
