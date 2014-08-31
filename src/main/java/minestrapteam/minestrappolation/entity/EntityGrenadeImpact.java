package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeImpact extends EntityThrowableExplosive
{
	public EntityGrenadeImpact(World world)
	{
		super(world);
		this.fuse = -1;
	}
	
	public EntityGrenadeImpact(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
		this.fuse = -1;
	}
	
	public EntityGrenadeImpact(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		this.fuse = -1;
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
