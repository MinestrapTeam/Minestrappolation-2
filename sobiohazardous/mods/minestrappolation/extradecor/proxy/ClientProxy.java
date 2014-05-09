package sobiohazardous.mods.minestrappolation.extradecor.proxy;

import sobiohazardous.mods.minestrappolation.extradecor.client.gui.GuiBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.client.gui.GuiCrate;
import sobiohazardous.mods.minestrappolation.extradecor.client.renderer.tileentity.RenderGoblet;
import sobiohazardous.mods.minestrappolation.extradecor.client.renderer.tileentity.RenderPlate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityPlate;
import cpw.mods.fml.client.registry.ClientRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoblet.class, new RenderGoblet());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new RenderPlate());
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
		return null;
	}
}
