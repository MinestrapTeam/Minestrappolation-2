package com.minestrappolation.core.common;

import com.minestrappolation.core.inventory.ContainerStonecutter;
import com.minestrappolation.core.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class MCCommonProxy implements IGuiHandler
{
	public static int stone2RenderType;
	
	public void registerRenderers()
	{
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityStonecutter)
		{
			return new ContainerStonecutter(player.inventory, (TileEntityStonecutter) te);
		}
		
		return null;
	}
}