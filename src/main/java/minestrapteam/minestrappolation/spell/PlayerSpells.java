package minestrapteam.minestrappolation.spell;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerSpells implements IExtendedEntityProperties
{
	public static final int	WATER			= 0;
	public static final int	FIRE			= 1;
	public static final int	EARTH			= 2;
	public static final int	WIND			= 3;
	public static final int	FROST			= 4;
	public static final int	ELECTRICITY		= 5;
	public static final int	LIFE			= 6;
	public static final int	ARCANE			= 7;
	
	public EntityPlayer		player;
	
	public int[]			manaLevels		= new int[] { 16, 16, 16, 16, 16, 16, 16, 16 };
	public int[]			maxManaLevels	= new int[] { 16, 16, 16, 16, 16, 16, 16, 16 };
	
	public PlayerSpells(Entity entity)
	{
		this.player = (EntityPlayer) entity;
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
