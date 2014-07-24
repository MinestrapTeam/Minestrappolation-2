package minestrapteam.minestrappolation.potion;

import clashsoft.cslib.minecraft.potion.CustomPotion;

public class MPotion extends CustomPotion
{
	public MPotion(String name, int color, boolean bad)
	{
		super(name, color, bad);
	}
	
	public MPotion(int id, String name, int color, boolean bad)
	{
		super(id, name, color, bad);
	}
}