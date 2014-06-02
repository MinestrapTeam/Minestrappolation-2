package minestrapteam.minestrap_core.potion;

import clashsoft.cslib.minecraft.potion.CustomPotion;

public class MCPotion extends CustomPotion
{
	public MCPotion(String name, int color, boolean bad)
	{
		super(name, color, bad);
	}
	
	public MCPotion(int id, String name, int color, boolean bad)
	{
		super(id, name, color, bad);
	}
}