package minestrapteam.minestrappolation.lib;

import clashsoft.cslib.minecraft.entity.CSEntities;
import clashsoft.cslib.minecraft.entity.CSEntities.EntityProperties;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.entity.*;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.variety.SpellVarietyAreaShield.SpellAreaShield;
import minestrapteam.minestrappolation.spell.variety.SpellVarietyBlockBreak.SpellBlockBreak;
import minestrapteam.minestrappolation.spell.variety.SpellVarietyProjectile.SpellProjectile;
import minestrapteam.minestrappolation.tileentity.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MEntities
{
	public static void load()
	{
		// Entities
		
		EntityRegistry.registerModEntity(EntityHangGlider.class, "HangGlider", 0, Minestrappolation.instance, 50, 2, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 1, Minestrappolation.instance, 50, 5, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, Minestrappolation.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeNuke.class, "GrenadeNuke", 6, Minestrappolation.instance, 40, 3, true);
		
		EntityRegistry.registerModEntity(SpellProjectile.class, "Spell_Projectile", 20, Minestrappolation.instance, 50, 1, false);
		EntityRegistry.registerModEntity(SpellAreaShield.class, "Spell_AreaShield", 27, Minestrappolation.instance, 30, 3, false);
		EntityRegistry.registerModEntity(SpellBlockBreak.class, "Spell_BlockBreak", 30, Minestrappolation.instance, 50, 2, false);
		
		CSEntities.registerProperties(new EntityProperties("MPlayerSpells", PlayerSpells.class)
		{
			@Override
			public IExtendedEntityProperties createProperties(Entity entity)
			{
				if (entity instanceof EntityPlayer)
				{
					return new PlayerSpells(entity);
				}
				return null;
			}
		});
		
		// Tile Entities
		
		GameRegistry.registerTileEntity(TileEntityCrate.class, "Crate");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "Barrel");
		GameRegistry.registerTileEntity(TileEntityGoblet.class, "Goblet");
		GameRegistry.registerTileEntity(TileEntityPlate.class, "Plate");
		
		GameRegistry.registerTileEntity(TileEntityMelter.class, "Melter");
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "StoneCutter");
		GameRegistry.registerTileEntity(TileEntitySawmill.class, "Sawmill");
		GameRegistry.registerTileEntity(TileEntityLocked.class, "Locked");
		GameRegistry.registerTileEntity(TileEntityWorkbench2.class, "Workbench2");
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "Freezer");
		GameRegistry.registerTileEntity(TileEntityArcaneForge.class, "ArcaneForge");
	}
}
