package sobiohazardous.mods.minestrappolation.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.container.ContainerBarrel;
import sobiohazardous.mods.minestrappolation.container.ContainerCrate;
import sobiohazardous.mods.minestrappolation.container.ContainerMelter;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityMelter;
import cpw.mods.fml.common.network.IGuiHandler;

public class MCommonProxy implements IGuiHandler
{
	public void registerRenderers()
	{
	}
	
	public static int addArmor(String armor)
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
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
