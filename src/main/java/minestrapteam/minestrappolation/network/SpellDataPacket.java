package minestrapteam.minestrappolation.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;
import minestrapteam.minestrappolation.spell.data.SpellType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public class SpellDataPacket extends CSPacket
{
	public int			currentSpell;
	public Spell[]		selectedSpells;
	public List<Spell>	spells;
	public int[]		manaLevels;
	public int[]		maxManaLevels;
	
	public SpellDataPacket()
	{
	}
	
	public SpellDataPacket(PlayerSpells spells)
	{
		this.currentSpell = spells.currentSpell;
		this.selectedSpells = spells.selectedSpells;
		this.spells = spells.spells;
		this.manaLevels = spells.manaLevels;
		this.maxManaLevels = spells.maxManaLevels;
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.currentSpell = buf.readByte();
		
		// Selected Spells
		this.selectedSpells = new Spell[9];
		for (int i = 0; i < 9; i++)
		{
			this.selectedSpells[i] = SpellHandler.readFromBuffer(buf);
		}
		
		// Spells
		int len = buf.readInt();
		this.spells = new ArrayList(len);
		for (int i = 0; i < len; i++)
		{
			this.spells.add(SpellHandler.readFromBuffer(buf));
		}
		
		// Mana Levels
		len = SpellType.spellTypes.length;
		this.manaLevels = new int[len];
		this.maxManaLevels = new int[len];
		for (int i = 0; i < len; i++)
		{
			this.manaLevels[i] = buf.readInt();
			this.maxManaLevels[i] = buf.readInt();
		}
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		buf.writeByte(this.currentSpell);
		
		// Selected Spells
		for (int i = 0; i < 9; i++)
		{
			SpellHandler.writeToBuffer(this.selectedSpells[i], buf);
		}
		
		// Spells
		int len = this.spells.size();
		buf.writeInt(len);
		for (int i = 0; i < len; i++)
		{
			SpellHandler.writeToBuffer(this.spells.get(i), buf);
		}
		
		// Mana Levels
		len = SpellType.spellTypes.length;
		for (int i = 0; i < len; i++)
		{
			buf.writeInt(this.manaLevels[i]);
			buf.writeInt(this.maxManaLevels[i]);
		}
	}
	
	@Override
	public void handle(EntityPlayer player)
	{
		PlayerSpells spells = PlayerSpells.get(player);
		spells.currentSpell = this.currentSpell;
		spells.selectedSpells = this.selectedSpells;
		spells.spells = this.spells;
		spells.manaLevels = this.manaLevels;
		spells.maxManaLevels = this.maxManaLevels;
	}
}
