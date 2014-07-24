package minestrapteam.minestrappolation.network;

import clashsoft.cslib.minecraft.network.CSNetHandler;

public class MNetHandler extends CSNetHandler
{
	public MNetHandler()
	{
		super("MCore");

		this.registerPacket(GobletPacket.class);
		this.registerPacket(PlatePacket.class);
	}
}
