package sobiohazardous.mods.minestrappolation.extradecor.lib;

import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDTileEntityManager
{
	public static void registerTileEntitys()
	{
		GameRegistry.registerTileEntityWithAlternatives(TileEntityCrate.class, "Crate", "tileEntityCrate");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityBarrel.class, "Barrel", "tileEntityBarrel");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityGoblet.class, "Goblet", "tileEntitygoblet");
	}
}
