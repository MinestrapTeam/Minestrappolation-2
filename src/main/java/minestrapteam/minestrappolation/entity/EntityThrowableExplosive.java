package minestrapteam.minestrappolation.entity;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityThrowableExplosive extends EntityThrowable
{
	protected int		fuse			= 60;
	protected double	bounceFactor	= 0.5D;
	protected float		explosionRange	= 4F;
	
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
		
		Vec3 src = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		Vec3 dest = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition impact = this.worldObj.rayTraceBlocks(src, dest);
		
		if (this.isImpacted(impact))
		{
			this.onImpact(impact);
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
			this.explode();
		}
	}
	
	protected void explode()
	{
		this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.explosionRange, true);
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(this.explosionRange, this.explosionRange, this.explosionRange);
		List<EntityLivingBase> list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		for (EntityLivingBase living : list)
		{
			this.affectEntity(living);
		}
		
		this.setDead();
	}
	
	public boolean isImpacted(MovingObjectPosition impact)
	{
		if (impact == null)
		{
			return false;
		}
		switch (impact.typeOfHit)
		{
		case MISS:
			return false;
		case BLOCK:
			return this.worldObj.getBlock(impact.blockX, impact.blockY, impact.blockZ).isOpaqueCube();
		case ENTITY:
			return true;
		}
		return false;
	}
	
	public abstract void affectEntity(EntityLivingBase living);
	
	@Override
	protected void onImpact(MovingObjectPosition impact)
	{
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		
		nbt.setShort("Fuse", (short) this.fuse);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		
		this.fuse = nbt.getShort("Fuse");
	}
}
