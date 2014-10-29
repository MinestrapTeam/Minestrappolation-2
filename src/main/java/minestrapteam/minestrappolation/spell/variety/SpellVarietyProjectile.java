package minestrapteam.minestrappolation.spell.variety;

import clashsoft.cslib.math.CSMath;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.entity.EntitySpell;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellHandler;
import minestrapteam.minestrappolation.spell.data.SpellCategory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SpellVarietyProjectile extends SpellVariety
{
	public SpellVarietyProjectile(int id, String name)
	{
		super(id, SpellCategory.OFFENSE, name);
	}
	
	@Override
	public void cast(Spell spell, EntityPlayer player, World world)
	{
		if (!world.isRemote)
		{
			SpellProjectile projectile = new SpellProjectile(world, player);
			projectile.setSpell(spell);
			world.spawnEntityInWorld(projectile);
		}
	}
	
	public static class SpellProjectile extends EntityThrowable
	{
		public Spell	spell;
		
		public SpellProjectile(World world)
		{
			super(world);
		}
		
		public SpellProjectile(World world, EntityLivingBase living)
		{
			super(world, living);
		}
		
		public SpellProjectile(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}
		
		@Override
		protected void entityInit()
		{
			EntitySpell.initSpell(this.dataWatcher);
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
		protected void onImpact(MovingObjectPosition mop)
		{
			if (mop.entityHit != null)
			{
				mop.entityHit.attackEntityFrom(DamageSource.magic, 0.005F * this.spell.getTotalPotency());
			}
			this.setDead();
		}
		
		@Override
		public void readEntityFromNBT(NBTTagCompound nbt)
		{
			this.spell = SpellHandler.readFromNBT(nbt);
		}
		
		@Override
		public void writeEntityToNBT(NBTTagCompound nbt)
		{
			SpellHandler.writeToNBT(this.spell, nbt);
		}
		
		@Override
		protected float getGravityVelocity()
		{
			return 0F;
		}
	}
}
