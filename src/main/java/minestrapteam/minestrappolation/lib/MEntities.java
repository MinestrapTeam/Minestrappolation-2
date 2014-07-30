package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.entity.*;
import minestrapteam.minestrappolation.tileentity.*;

public class MEntities
{
	public static void load()
	{
		// Entities
		
		EntityRegistry.registerModEntity(EntityHangGlider.class, "HangGlider", 0, Minestrappolation.instance, 200, 2, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 1, Minestrappolation.instance, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeNuke.class, "GrenadeNuke", 6, Minestrappolation.instance, 40, 3, true);
		
		// Tile Entities
		
		GameRegistry.registerTileEntityWithAlternatives(TileEntityCrate.class, "Crate", "tileEntityCrate");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityBarrel.class, "Barrel", "tileEntityBarrel");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityGoblet.class, "Goblet", "tileEntitygoblet");
		
		GameRegistry.registerTileEntity(TileEntityMelter.class, "Melter");
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "StoneCutter");
		GameRegistry.registerTileEntity(TileEntityLocked.class, "Locked");
	}
}
