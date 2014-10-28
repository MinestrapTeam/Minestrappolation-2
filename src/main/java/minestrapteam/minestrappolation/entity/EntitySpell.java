package minestrapteam.minestrappolation.entity;

import java.util.UUID;

import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntitySpell extends Entity
{
	public Spell				spell;
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
		if (this.spellCaster == null)
		{
			UUID uuid = UUID.fromString(this.dataWatcher.getWatchableObjectString(11));
			if (uuid != null)
			{
				this.spellCaster = this.worldObj.func_152378_a(uuid);
			}
		}
		return this.spellCaster;
	}
	
	@Override
	protected void entityInit()
	{
		this.dataWatcher.addObject(11, "");
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
}
