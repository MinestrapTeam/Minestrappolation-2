package minestrapteam.minestrappolation.entity;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityThrowableExplosive extends EntityThrowable
{
	private int		fuse			= 60;
	private double	bounceFactor	= 0.5D;
	protected float	explosionRange	= 4F;
	
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
		this.moveEntity(prevVelX, prevVelY, prevVelZ);
		
		Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
		
		if (movingobjectposition != null)
		{
			this.onImpact(movingobjectposition);
		}
		
		if (this.motionX != prevVelX)
		{
			this.motionX = -this.bounceFactor * prevVelX;
		}
		if (this.motionY != prevVelY)
		{
			this.motionY = -this.bounceFactor * prevVelY;
		}
		if (this.motionZ != prevVelZ)
		{
			this.motionZ = -this.bounceFactor * prevVelZ;
		}
		
		// Apply gravity
		this.motionY -= 0.04;
		
		// Air friction
		this.motionX *= 0.9;
		this.motionY *= 0.9;
		this.motionZ *= 0.9;
		
		this.updateFuse();
	}
	
	protected final void updateFuse()
	{
		// Spawn smoke particles
		this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0F, 0.0D);
		
		// Are we going to explode?
		if (this.fuse-- <= 0 && !this.worldObj.isRemote)
		{
			this.setDead();
			this.explode();
		}
	}
	
	private void explode()
	{
		this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.explosionRange, true);
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(this.explosionRange, this.explosionRange, this.explosionRange);
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
