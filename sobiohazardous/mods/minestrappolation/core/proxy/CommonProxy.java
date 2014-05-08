package sobiohazardous.mods.minestrappolation.core.proxy;

import sobiohazardous.mods.minestrappolation.core.tileentity.ContainerStonecutter;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
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