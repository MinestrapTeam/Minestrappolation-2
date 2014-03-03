package sobiohazardous.minestrappolation.extradecor.handler;

import sobiohazardous.minestrappolation.extradecor.client.gui.*;
import sobiohazardous.minestrappolation.extradecor.container.*;
import sobiohazardous.minestrappolation.extradecor.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EDGuiHandler implements IGuiHandler
{
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch(id)
		{
			case 0: return tile_entity instanceof TileEntityCrate ? new ContainerCrate((TileEntityCrate) tile_entity, player.inventory) : null;
			case 1: return tile_entity instanceof TileEntityBarrel ? new ContainerBarrel((TileEntityBarrel)tile_entity, player.inventory) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch(id)
		{
			case 0: return tile_entity instanceof TileEntityCrate ? new GuiCrate(player.inventory, (TileEntityCrate)tile_entity) : null;
			case 1: return tile_entity instanceof TileEntityBarrel ?  new GuiBarrel(player.inventory, (TileEntityBarrel)tile_entity) : null;
		}
		
		return null;
	}

}