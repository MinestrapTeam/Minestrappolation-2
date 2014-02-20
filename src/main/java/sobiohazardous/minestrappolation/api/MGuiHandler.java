package sobiohazardous.minestrappolation.api;

import sobiohazardous.minestrappolation.api.client.gui.GuiStonecutter;
import sobiohazardous.minestrappolation.api.tileentity.ContainerStonecutter;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MGuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityStonecutter)
		{
			return new ContainerStonecutter(player.inventory,(TileEntityStonecutter)tile_entity, world, x, y, z);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityStonecutter)
		{
			return new GuiStonecutter(player.inventory, (TileEntityStonecutter)tile_entity, world, x, y, z);
		}

		return null;
	}
}