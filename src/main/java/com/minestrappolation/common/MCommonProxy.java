package com.minestrappolation.common;

import clashsoft.cslib.minecraft.common.BaseProxy;

import com.minestrappolation.inventory.ContainerBarrel;
import com.minestrappolation.inventory.ContainerCrate;
import com.minestrappolation.inventory.ContainerMelter;
import com.minestrappolation.tileentity.TileEntityBarrel;
import com.minestrappolation.tileentity.TileEntityCrate;
import com.minestrappolation.tileentity.TileEntityMelter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCommonProxy extends BaseProxy
{
	public static int	fire;
	public static int	bronze;
	public static int	steel;
	public static int	titanium;
	public static int	meurodite;
	public static int	torite;
	
	public int addArmor(String armor)
	{
		return 0;
	}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new ContainerCrate(player, (TileEntityCrate) world.getTileEntity(x, y, z));
		}
		else if (id == 1)
		{
			return new ContainerBarrel(player, (TileEntityBarrel) world.getTileEntity(x, y, z));
		}
		if (id == 3)
		{
			return new ContainerMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
