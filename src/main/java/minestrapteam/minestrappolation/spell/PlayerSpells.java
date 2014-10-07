package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.entity.CSEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerSpells implements IExtendedEntityProperties
{
	public EntityPlayer		player;
	
	public int				currentSpell	= 0;
	public Spell[]			selectedSpells	= new Spell[9];
	protected List<Spell>	spells			= new ArrayList();
	
	protected int[]			manaLevels		= new int[SpellType.SPELL_TYPES.length];
	protected int[]			maxManaLevels	= new int[SpellType.SPELL_TYPES.length];
	
	public PlayerSpells(Entity entity)
	{
		this.player = (EntityPlayer) entity;
		
		for (int i = 0; i < SpellType.SPELL_TYPES.length; i++)
		{
			this.manaLevels[i] = 16;
			this.maxManaLevels[i] = 16;
		}
	}
	
	public static PlayerSpells get(EntityPlayer player)
	{
		return (PlayerSpells) CSEntities.getProperties("MPlayerSpells", player);
	}
	
	public int getManaLevel(int type)
	{
		return this.manaLevels[type];
	}
	
	public int getMaxManaLevel(int type)
	{
		return this.maxManaLevels[type];
	}
	
	public void setManaLevel(int type, int value)
	{
		this.manaLevels[type] = value;
	}
	
	public void setMaxManaLevel(int type, int value)
	{
		this.maxManaLevels[type] = value;
	}
	
	public void addManaLevel(int type, int value)
	{
		this.maxManaLevels[type] += value;
	}
	
	public void addMaxManaLevel(int type, int value)
	{
		this.maxManaLevels[type] += value;
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
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		this.manaLevels = nbt.getIntArray("ManaLevels");
		this.maxManaLevels = nbt.getIntArray("MaxManaLevels");
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
}
