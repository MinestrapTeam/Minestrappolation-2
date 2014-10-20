package minestrapteam.minestrappolation.network;

import clashsoft.cslib.minecraft.network.CSNetHandler;

public class MNetHandler extends CSNetHandler
{
	public MNetHandler()
	{
		super("MCore");
		
		this.registerPacket(GobletPacket.class);
		this.registerPacket(PlatePacket.class);
		this.registerPacket(LockedPacket.class);
		
		this.registerPacket(SpellDataPacket.class);
		this.registerPacket(SpellBarPacket.class);
		this.registerPacket(SpellUsePacket.class);
		this.registerPacket(SpellAddPacket.class);
		this.registerPacket(ManaLevelPacket.class);
	}
}
