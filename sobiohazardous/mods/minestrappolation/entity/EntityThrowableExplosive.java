package sobiohazardous.mods.minestrappolation.entity;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class EntityThrowableExplosive extends EntityThrowable
{
	private int		fuse			= 60;
	private double	bounceFactor	= 0.5;
	
	public EntityThrowableExplosive(World world)
	{
		super(world);
	}
	
	public EntityThrowableExplosive(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
	}
	
	public EntityThrowableExplosive(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	public void onUpdate()
	{
		double prevVelX = this.motionX;
		double prevVelY = this.motionY;
		double prevVelZ = this.motionZ;
		super.onUpdate();
		
		// Take into account bouncing (normal displacement just sets them to 0)
		if (this.motionX != prevVelX)
		{
			this.motionX = -this.bounceFactor * prevVelX;
		}
		
		if (this.motionY != prevVelY)
		{
			this.motionY = -this.bounceFactor * prevVelY;
		}
		else
		{
			this.motionY -= 0.04; // Apply gravity.
			this.worldObj.spawnParticle("", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0F, 0.0D);
		}
		
		if (this.motionZ != prevVelZ)
		{
			this.motionZ = -this.bounceFactor * prevVelZ;
		}
		
		// Air friction
		this.motionX *= 0.89;
		this.motionY *= 0.89;
		this.motionZ *= 0.89;
		
		// Are we going to explode?
		if (this.fuse-- <= 0)
		{
			if (!this.worldObj.isRemote)
			{
				this.setDead();
				this.explode();
			}
		}
	}
	
	private void explode()
	{
		this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 4F, true);
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
		List<EntityLivingBase> list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		for (EntityLivingBase living : list)
		{
			this.affectEntity(living);
		}
	}
	
	public abstract void affectEntity(EntityLivingBase living);
	
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
	}
}
