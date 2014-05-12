package sobiohazardous.mods.minestrappolation.lib;

import sobiohazardous.mods.minestrappolation.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityGoblet;
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
