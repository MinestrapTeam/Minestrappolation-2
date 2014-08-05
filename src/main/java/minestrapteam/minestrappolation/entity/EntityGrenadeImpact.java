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
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (!this.worldObj.isRemote)
		{
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 2F, true);
			this.setDead();
		}
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
	}
}
