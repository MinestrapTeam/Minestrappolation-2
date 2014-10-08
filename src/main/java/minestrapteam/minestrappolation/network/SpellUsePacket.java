package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.ISpell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class SpellUsePacket extends CSPacket
{
	public int	spell;
	
	public SpellUsePacket()
	{
	}
	
	public SpellUsePacket(PlayerSpells spells)
	{
		this.spell = spells.currentSpell;
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.spell = buf.readInt();
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		buf.writeInt(this.spell);
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		PlayerSpells spells = PlayerSpells.get(player);
		spells.currentSpell = this.spell;
		ISpell spell = spells.getCurrentSpell();
		if (spell != null)
		{
			spell.onSpellRightClick(spells, player);
		}
	}
}
