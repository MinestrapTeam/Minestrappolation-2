package clashsoft.cslib.minecraft.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CSLibProxy extends BaseProxy
{
	public void displayUpdatesGUI()
	{
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
