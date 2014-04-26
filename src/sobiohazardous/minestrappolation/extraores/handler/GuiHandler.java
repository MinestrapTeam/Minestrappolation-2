package sobiohazardous.minestrappolation.extraores.handler;

import sobiohazardous.minestrappolation.extraores.client.gui.ContainerMelter;
import sobiohazardous.minestrappolation.extraores.client.gui.GuiMelter;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		if (tile_entity instanceof TileEntityMelter)
		{
			return new ContainerMelter(player.inventory, (TileEntityMelter) tile_entity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if (tile_entity instanceof TileEntityMelter)
		{
			return new GuiMelter(player.inventory, (TileEntityMelter) tile_entity);
		}

		return null;
	}
}