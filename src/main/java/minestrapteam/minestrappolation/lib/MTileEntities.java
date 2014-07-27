package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.tileentity.*;

public class MTileEntities
{
	public static void registerTileEntitys()
	{
		GameRegistry.registerTileEntityWithAlternatives(TileEntityCrate.class, "Crate", "tileEntityCrate");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityBarrel.class, "Barrel", "tileEntityBarrel");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityGoblet.class, "Goblet", "tileEntitygoblet");

		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "StoneCutter");
		GameRegistry.registerTileEntity(TileEntityLocked.class, "Locked");
	}
}
