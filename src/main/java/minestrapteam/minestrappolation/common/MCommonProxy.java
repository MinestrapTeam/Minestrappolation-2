package minestrapteam.minestrappolation.common;

import clashsoft.cslib.minecraft.common.BaseProxy;
import minestrapteam.minestrappolation.inventory.*;
import minestrapteam.minestrappolation.tileentity.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCommonProxy extends BaseProxy
{
	public static int	platingRenderID;
	public static int	custom2RenderID;
	public static int	lockedRenderID;
	
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
		else if (id == 2)
		{
			return new ContainerMelter(player, (TileEntityMelter) world.getTileEntity(x, y, z));
		}
		else if (id == 3)
		{
			return new ContainerStonecutter(player.inventory, (TileEntityStonecutter) world.getTileEntity(x, y, z));
		}
		else if (id == 4)
		{
			return new ContainerSawmill(player.inventory, (TileEntitySawmill) world.getTileEntity(x, y, z));
		}
		else if (id == 5)
		{
			return new ContainerFreezer(player.inventory, (TileEntityFreezer) world.getTileEntity(x, y, z));
		}
		else if (id == 7)
		{
			return new ContainerArcaneForge(player, (TileEntityArcaneForge) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
