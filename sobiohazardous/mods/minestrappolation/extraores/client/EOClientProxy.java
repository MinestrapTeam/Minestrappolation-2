package sobiohazardous.mods.minestrappolation.extraores.client;

import sobiohazardous.mods.minestrappolation.extraores.client.gui.GuiMelter;
import sobiohazardous.mods.minestrappolation.extraores.client.renderer.RenderNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.common.EOCommonProxy;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EOClientProxy extends EOCommonProxy
{
	public static String	armorPrefix;
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(EOItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderSnowball(EOItems.grenadeImpact));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderSnowball(EOItems.grenadeSticky));
	}
	
	public static int addArmor(String armor)
	{
		armorPrefix = armor;
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new GuiMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
