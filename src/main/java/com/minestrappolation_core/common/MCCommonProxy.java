package com.minestrappolation_core.common;

import clashsoft.cslib.minecraft.common.BaseProxy;

import com.minestrappolation_core.inventory.ContainerStonecutter;
import com.minestrappolation_core.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MCCommonProxy extends BaseProxy
{
	public static int stone2RenderType;
	
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