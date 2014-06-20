package minestrapteam.minestrappolation.common;

import clashsoft.cslib.minecraft.common.BaseProxy;
import minestrapteam.minestrappolation.inventory.ContainerBarrel;
import minestrapteam.minestrappolation.inventory.ContainerCrate;
import minestrapteam.minestrappolation.inventory.ContainerMelter;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCommonProxy extends BaseProxy
{
	public static int	fire;
	public static int	tin;
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
