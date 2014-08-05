package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeSticky extends EntityThrowableExplosive
{
	private boolean	impacted;
	
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
	public void onUpdate()
	{
		if (this.impacted)
		{
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
			
			this.updateFuse();
		}
		else
		{
			super.onUpdate();
		}
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		this.impacted = true;
		this.posX = mop.hitVec.xCoord + this.motionX;
		this.posY = mop.hitVec.yCoord + this.motionY;
		this.posZ = mop.hitVec.zCoord + this.motionZ;
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
		living.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1);
	}
}
