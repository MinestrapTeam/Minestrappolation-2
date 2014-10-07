package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class ManaLevelPacket extends CSPacket
{
	public int type;
	public int manaLevel;
	public int maxManaLevel;
	
	public ManaLevelPacket()
	{
	}
	
	public ManaLevelPacket(int type, PlayerSpells spells)
	{
		this.type = type;
		this.manaLevel = spells.manaLevels[type];
		this.maxManaLevel = spells.maxManaLevels[type];
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.type = buf.readByte();
		this.manaLevel = buf.readInt();
		this.maxManaLevel = buf.readInt();
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		buf.writeByte((byte) this.type);
		buf.writeInt(this.manaLevel);
		buf.writeInt(this.maxManaLevel);
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		PlayerSpells spells = PlayerSpells.get(player);
		spells.manaLevels[this.type] = this.manaLevel;
		spells.maxManaLevels[this.type] = this.maxManaLevel;
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		this.handleClient(player);
	}
}
