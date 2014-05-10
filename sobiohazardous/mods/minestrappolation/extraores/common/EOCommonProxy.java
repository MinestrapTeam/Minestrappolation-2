package sobiohazardous.mods.minestrappolation.extraores.common;

import sobiohazardous.mods.minestrappolation.extraores.inventory.ContainerMelter;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class EOCommonProxy implements IGuiHandler
{
	public static String	armorPrefix;
	
	
	public void registerRenderers()
	{
	}
	
	public void registerRenders()
	{
	}
	
	public static int addArmor(String armor)
	{
		armorPrefix = armor;
		return 0;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new ContainerMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		return null;
	}
}