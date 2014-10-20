package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.entity.CSEntities;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.network.SpellDataPacket;
import minestrapteam.minestrappolation.spell.data.SpellType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
	
	public boolean addSpell(Spell spell)
	{
		if (!this.spells.contains(spell))
		{
			return this.spells.add(spell);
		}
		return false;
	}
	
	public void onRespawn()
	{
		for (int i = 0; i < SpellType.spellTypes.length; i++)
		{
			this.manaLevels[i] = Math.max(16, this.maxManaLevels[i] / 2);
		}
		
		this.sync();
	}
	
	public void sync()
	{
		Minestrappolation.instance.netHandler.sendTo(new SpellDataPacket(this), (EntityPlayerMP) this.player);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		NBTTagCompound compound = new NBTTagCompound();
		nbt.setTag("Spells", compound);
		nbt = compound;
		
		NBTTagList list = new NBTTagList();
		for (Spell spell : this.spells)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			SpellHandler.writeToNBT(spell, nbt1);
			list.appendTag(nbt1);
		}
		nbt.setTag("Spells", list);
		
		list = new NBTTagList();
		for (Spell spell : this.selectedSpells)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			if (spell != null)
			{
				SpellHandler.writeToNBT(spell, nbt1);
			}
			list.appendTag(nbt1);
		}
		nbt.setTag("HotbarSpells", list);
		
		nbt.setIntArray("ManaLevels", this.manaLevels);
		nbt.setIntArray("MaxManaLevels", this.maxManaLevels);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		nbt = nbt.getCompoundTag("Spells");
		
		NBTTagList list = (NBTTagList) nbt.getTag("Spells");
		if (list != null)
		{
			int len = list.tagCount();
			this.spells = new ArrayList(len);
			for (int i = 0; i < len; i++)
			{
				NBTTagCompound nbt1 = list.getCompoundTagAt(i);
				Spell spell = SpellHandler.readFromNBT(nbt1);
				this.spells.add(spell);
			}
		}
		
		list = (NBTTagList) nbt.getTag("HotbarSpells");
		this.selectedSpells = new Spell[9];
		if (list != null)
		{
			for (int i = 0; i < 9; i++)
			{
				NBTTagCompound nbt1 = list.getCompoundTagAt(i);
				Spell spell = SpellHandler.readFromNBT(nbt1);
				this.selectedSpells[i] = spell;
			}
		}
		
		this.manaLevels = nbt.getIntArray("ManaLevels");
		this.maxManaLevels = nbt.getIntArray("MaxManaLevels");
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
}
