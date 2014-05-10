package sobiohazardous.mods.minestrappolation.extradecor.common;

import sobiohazardous.mods.minestrappolation.extradecor.container.ContainerBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.container.ContainerCrate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EDCommonProxy implements IGuiHandler
{	
	public void registerRenderThings()
	{
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
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}