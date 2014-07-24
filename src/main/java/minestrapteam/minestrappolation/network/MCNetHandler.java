package minestrapteam.minestrappolation.network;

import clashsoft.cslib.minecraft.network.CSNetHandler;

public class MCNetHandler extends CSNetHandler
{
	public MCNetHandler()
	{
		super("MCore");

		this.registerPacket(GobletPacket.class);
		this.registerPacket(PlatePacket.class);
	}
}
