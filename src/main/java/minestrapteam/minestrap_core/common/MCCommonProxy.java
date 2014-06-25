package minestrapteam.minestrap_core.common;

import clashsoft.cslib.minecraft.common.BaseProxy;
import minestrapteam.minestrap_core.inventory.ContainerStonecutter;
import minestrapteam.minestrap_core.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCCommonProxy extends BaseProxy
{
	public static int	custom2RenderType;
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == 0)
		{
			return new ContainerStonecutter(player.inventory, (TileEntityStonecutter) world.getTileEntity(x, y, z));
		}
		
		return null;
	}
}