package com.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowableExplosive
{
	public EntityGrenade(World world)
	{
		super(world);
	}
	
	public EntityGrenade(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
	}
	
	public EntityGrenade(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
		living.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1);
	}
}
