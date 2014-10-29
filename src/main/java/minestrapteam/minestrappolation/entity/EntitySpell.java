package minestrapteam.minestrappolation.entity;

import java.util.UUID;

import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.variety.SpellVariety;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntitySpell extends Entity
{
	protected Spell				spell;
	protected EntityLivingBase	spellCaster;
	
	public EntitySpell(World world)
	{
		super(world);
	}
	
	public EntitySpell(World world, EntityLivingBase living)
	{
		super(world);
		this.setSpellCaster(living);
	}
	
	public void setSpellCaster(EntityLivingBase living)
	{
		this.spellCaster = living;
		this.dataWatcher.updateObject(11, living.getUniqueID().toString());
	}
	
	public EntityLivingBase getSpellCaster()
	{
		if (this.spellCaster == null || this.dataWatcher.hasChanges())
		{
			UUID uuid = UUID.fromString(this.dataWatcher.getWatchableObjectString(11));
			if (uuid != null)
			{
				this.spellCaster = this.worldObj.func_152378_a(uuid);
			}
		}
		return this.spellCaster;
	}
	
	public void setSpell(Spell spell)
	{
		this.spell = spell;
		updateSpell(this.dataWatcher, spell);
	}
	
	public Spell getSpell()
	{
		if (this.spell == null || this.dataWatcher.hasChanges())
		{
			this.spell = getSpell(this.dataWatcher);
		}
		return this.spell;
	}
	
	@Override
	protected void entityInit()
	{
		this.dataWatcher.addObject(11, "");
		initSpell(this.dataWatcher);
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.dataWatcher.updateObject(11, nbt.getString("SpellCaster"));
		this.spell = SpellHandler.readFromNBT(nbt);
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setString("SpellCaster", this.dataWatcher.getWatchableObjectString(11));
		SpellHandler.writeToNBT(this.spell, nbt);
	}
	
	public static void initSpell(DataWatcher watcher)
	{
		watcher.addObject(12, (byte) 0);
		watcher.addObject(13, (byte) 0);
		for (int i = 0; i < SpellType.spellTypes.length; i++)
		{
			watcher.addObject(14 + i, 0);
		}
	}
	
	public static void updateSpell(DataWatcher watcher, Spell spell)
	{
		watcher.updateObject(12, Byte.valueOf(spell == null ? -1 : spell.variety.id));
		watcher.updateObject(13, Byte.valueOf(spell == null ? -1 : spell.enhancement == null ? -1 : spell.enhancement.id));
		
		if (spell == null)
		{
			for (int i = 0; i < SpellType.spellTypes.length; i++)
			{
				watcher.updateObject(14 + i, 0);
			}
		}
		else
		{
			int[] potencies = spell.getPotencies();
			for (int i = 0; i < SpellType.spellTypes.length; i++)
			{
				watcher.updateObject(14 + i, potencies[i]);
			}
		}
	}
	
	public static Spell getSpell(DataWatcher watcher)
	{
		SpellVariety variety = SpellVariety.get(watcher.getWatchableObjectByte(12));
		SpellEnhancement enhancement = SpellEnhancement.get(watcher.getWatchableObjectByte(13));
		
		int len = SpellType.spellTypes.length;
		int[] potencies = new int[len];
		for (int i = 0; i < len; i++)
		{
			potencies[i] = watcher.getWatchableObjectInt(14 + i);
		}
		
		return new Spell(variety.category, variety, enhancement, potencies);
	}
}
