package sobiohazardous.mods.minestrappolation.client;

import sobiohazardous.mods.minestrappolation.client.gui.GuiBarrel;
import sobiohazardous.mods.minestrappolation.client.gui.GuiCrate;
import sobiohazardous.mods.minestrappolation.client.gui.GuiMelter;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderGoblet;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderHangGlider;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderNukePrimed;
import sobiohazardous.mods.minestrappolation.client.renderer.RenderPlate;
import sobiohazardous.mods.minestrappolation.common.MCommonProxy;
import sobiohazardous.mods.minestrappolation.entity.*;
import sobiohazardous.mods.minestrappolation.lib.MItems;
import sobiohazardous.mods.minestrappolation.tileentity.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MClientProxy extends MCommonProxy implements IGuiHandler
{
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RenderGoblet());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RenderPlate());
		RenderingRegistry.registerEntityRenderingHandler(EntityHangGlider.class, new RenderHangGlider());
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(MItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeImpact.class, new RenderSnowball(MItems.grenadeImpact));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSticky.class, new RenderSnowball(MItems.grenadeSticky));
		
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
