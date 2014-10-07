package minestrapteam.minestrappolation.spell;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerSpells implements IExtendedEntityProperties
{
	public EntityPlayer	player;
	
	protected int[]		manaLevels		= new int[SpellType.SPELL_TYPES.length];
	protected int[]		maxManaLevels	= new int[SpellType.SPELL_TYPES.length];
	
	public PlayerSpells(Entity entity)
	{
		this.player = (EntityPlayer) entity;
		
		for (int i = 0; i < SpellType.SPELL_TYPES.length; i++)
		{
			this.manaLevels[i] = 16;
			this.maxManaLevels[i] = 16;
		}
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
