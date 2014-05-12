package sobiohazardous.mods.minestrappolation.client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import sobiohazardous.mods.minestrappolation.client.gui.GuiBarrel;
import sobiohazardous.mods.minestrappolation.client.gui.GuiCrate;
import sobiohazardous.mods.minestrappolation.client.gui.GuiMelter;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderGoblet;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderNukePrimed;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderPlate;
import sobiohazardous.mods.minestrappolation.common.MCommonProxy;
import sobiohazardous.mods.minestrappolation.core.client.render.RenderHangGlider;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityGoblet;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityMelter;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityPlate;

public class MClientProxy extends MCommonProxy implements IGuiHandler
{
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RenderGoblet());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RenderPlate());
		RenderingRegistry.registerEntityRenderingHandler(EntityHangGlider.class, new RenderHangGlider());
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(EOItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderSnowball(EOItems.grenadeImpact));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderSnowball(EOItems.grenadeSticky));

	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new GuiCrate(player, (TileEntityCrate) world.getTileEntity(x, y, z));
		}
		else if (id == 1)
		{
			return new GuiBarrel(player, (TileEntityBarrel) world.getTileEntity(x, y, z));
		}
		if (id == 2)
		{
			return new GuiMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		return null;
	}
	
	public static int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
