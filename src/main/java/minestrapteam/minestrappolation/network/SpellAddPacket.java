package minestrapteam.minestrappolation.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.inventory.ContainerArcaneForge;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class SpellAddPacket extends CSPacket
{
	public Spell	spell;
	
	public SpellAddPacket()
	{
	}
	
	public SpellAddPacket(Spell spell)
	{
		this.spell = spell;
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.spell = SpellHandler.readFromBuffer(buf);
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		SpellHandler.writeToBuffer(this.spell, buf);
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		PlayerSpells spells = PlayerSpells.get(player);
		if (spells.addSpell(this.spell) && player.openContainer instanceof ContainerArcaneForge)
		{
			// Makes sure to consume the items on the server
			((ContainerArcaneForge) player.openContainer).arcaneForge.onSpellCrafted(player);
		}
	}
}
