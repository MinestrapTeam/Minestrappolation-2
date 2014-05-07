package clashsoft.playerinventoryapi.network;

import clashsoft.cslib.minecraft.network.CSNetHandler;

public class PINetHandler extends CSNetHandler
{
	public PINetHandler()
	{
		super("PIAPI");
		
		this.registerPacket(EISlotPacket.class);
		this.registerPacket(EIPacket.class);
	}
}
