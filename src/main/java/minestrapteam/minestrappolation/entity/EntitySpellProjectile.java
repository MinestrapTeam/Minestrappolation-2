package minestrapteam.minestrappolation.entity;

import java.util.UUID;

import clashsoft.cslib.math.CSMath;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntitySpellProjectile extends EntityThrowable
{
	protected Spell				spell;
	protected EntityLivingBase	spellCaster;
	
	public EntitySpellProjectile(World world)
	{
		super(world);
	}
	
	public EntitySpellProjectile(World world, EntityLivingBase living)
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
		EntitySpell.updateSpell(this.dataWatcher, spell);
	}
	
	public Spell getSpell()
	{
		if (this.spell == null || this.dataWatcher.hasChanges())
		{
			this.spell = EntitySpell.getSpell(this.dataWatcher);
		}
		return this.spell;
	}
	
	@Override
	protected void entityInit()
	{
		this.dataWatcher.addObject(11, "");
		EntitySpell.initSpell(this.dataWatcher);
	}
	
	@Override
	public void onEntityUpdate()
	{
		Spell spell = this.getSpell();
		if (this.worldObj.isRemote && spell != null)
		{
			float f = 0.25F;
			for (int i = 0; i < 4; i++)
			{
				double d = i * f;
				double x = CSMath.interpolate(this.posX, this.prevPosX, d);
				double y = CSMath.interpolate(this.posY, this.prevPosY, d);
				double z = CSMath.interpolate(this.posZ, this.prevPosZ, d);
				
				Minestrappolation.proxy.spawnSpellParticle(spell, x, y, z);
			}
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.dataWatcher.updateObject(11, nbt.getString("SpellCaster"));
		this.spell = SpellHandler.readFromNBT(nbt);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setString("SpellCaster", this.dataWatcher.getWatchableObjectString(11));
		SpellHandler.writeToNBT(this.spell, nbt);
	}
	
	@Override
	protected float getGravityVelocity()
	{
		return 0F;
	}
}
