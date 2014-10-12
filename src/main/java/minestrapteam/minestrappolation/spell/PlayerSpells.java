package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.entity.CSEntities;
import minestrapteam.minestrappolation.spell.data.SpellType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerSpells implements IExtendedEntityProperties
{
	public EntityPlayer	player;
	
	public int			currentSpell	= 0;
	public Spell[]		selectedSpells	= new Spell[9];
	public List<Spell>	spells			= new ArrayList();
	
	public int[]		manaLevels		= new int[SpellType.spellTypes.length];
	public int[]		maxManaLevels	= new int[SpellType.spellTypes.length];
	
	public PlayerSpells(Entity entity)
	{
		this.player = (EntityPlayer) entity;
		
		for (int i = 0; i < SpellType.spellTypes.length; i++)
		{
			this.manaLevels[i] = 16;
			this.maxManaLevels[i] = 16;
		}
	}
	
	public static PlayerSpells get(EntityPlayer player)
	{
		return (PlayerSpells) CSEntities.getProperties("MPlayerSpells", player);
	}
	
	public void updateCurrentSpell(int dwheel)
	{
		if (dwheel > 0)
		{
			this.currentSpell--;
		}
		else
		{
			this.currentSpell++;
		}
		
		if (this.currentSpell >= 9)
		{
			this.currentSpell -= 9;
		}
		if (this.currentSpell < 0)
		{
			this.currentSpell += 9;
		}
	}
	
	public Spell getCurrentSpell()
	{
		return this.selectedSpells[this.currentSpell];
	}
	
	public Spell getSpell(int slot)
	{
		return this.selectedSpells[slot];
	}
	
	public void setSpell(int slot, Spell spell)
	{
		this.selectedSpells[slot] = spell;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		nbt.setIntArray("ManaLevels", this.manaLevels);
		nbt.setIntArray("MaxManaLevels", this.maxManaLevels);
		
		NBTTagList list = new NBTTagList();
		for (Spell spell : this.spells)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			SpellHandler.writeToNBT(spell, nbt1);
			list.appendTag(nbt1);
		}
		nbt.setTag("Spells", list);
		
		int[] selectedSpells = new int[9];
		for (int i = 0; i < 9; i++)
		{
			Spell spell = this.selectedSpells[i];
			selectedSpells[i] = this.spells.indexOf(spell);
		}
		nbt.setIntArray("SelectedSpells", selectedSpells);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		this.manaLevels = nbt.getIntArray("ManaLevels");
		this.maxManaLevels = nbt.getIntArray("MaxManaLevels");
		
		NBTTagList list = (NBTTagList) nbt.getTag("Spells");
		int len = list.tagCount();
		this.spells = new ArrayList(len);
		for (int i = 0; i < len; i++)
		{
			NBTTagCompound nbt1 = list.getCompoundTagAt(i);
			Spell spell = SpellHandler.readFromNBT(nbt1);
			this.spells.add(spell);
		}
		
		int[] selectedSpells = nbt.getIntArray("SelectedSpells");
		this.selectedSpells = new Spell[9];
		for (int i = 0; i < 9; i++)
		{
			int index = selectedSpells[i];
			if (index >= 0 && index < len)
			{
				Spell spell = this.spells.get(index);
				this.selectedSpells[i] = spell;
			}
		}
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
}
