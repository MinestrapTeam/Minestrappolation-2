package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class SpellBarPacket extends CSPacket
{
	public int		slot;
	public Spell	spell;
	
	public SpellBarPacket()
	{
	}
	
	public SpellBarPacket(int slot, Spell spell)
	{
		this.slot = slot;
		this.spell = spell;
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.slot = buf.readInt();
		this.spell = Spell.getSpellByName(buf.readStringFromBuffer(0xFF));
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		buf.writeInt(this.slot);
		buf.writeStringToBuffer(Spell.spellRegistry.getNameForObject(this.spell));
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		PlayerSpells spells = PlayerSpells.get(player);
		spells.setSpell(this.slot, this.spell);
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		this.handleClient(player);
	}
}
