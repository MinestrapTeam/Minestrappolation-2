package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeImpact extends EntityThrowableExplosive
{
	public EntityGrenadeImpact(World world)
	{
		super(world);
	}
	
	public EntityGrenadeImpact(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
	}
	
	public EntityGrenadeImpact(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition impact)
	{
		this.explode();
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
	}
}
