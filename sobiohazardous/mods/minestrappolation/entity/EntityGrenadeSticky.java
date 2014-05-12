package sobiohazardous.mods.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGrenadeSticky extends EntityThrowableExplosive
{
	public EntityGrenadeSticky(World world)
	{
		super(world);
	}
	
	public EntityGrenadeSticky(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityGrenadeSticky(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
		living.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1);
	}
}
