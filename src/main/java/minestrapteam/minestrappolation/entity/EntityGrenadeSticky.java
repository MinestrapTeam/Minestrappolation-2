package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeSticky extends EntityThrowableExplosive
{
	private MovingObjectPosition	impact;
	
	public EntityGrenadeSticky(World world)
	{
		super(world);
		this.fuse = 120;
	}
	
	public EntityGrenadeSticky(World world, EntityLivingBase living)
	{
		super(world, living);
		this.fuse = 120;
	}
	
	public EntityGrenadeSticky(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		this.fuse = 120;
	}
	
	@Override
	public void onUpdate()
	{
		if (this.isImpacted(this.impact))
		{
			MovingObjectPosition mop = this.impact;
			
			this.posX = mop.hitVec.xCoord + this.motionX;
			this.posY = mop.hitVec.yCoord + this.motionY;
			this.posZ = mop.hitVec.zCoord + this.motionZ;
			
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
			
			this.updateFuse();
			
			return;
		}
		
		this.impact = null;
		super.onUpdate();
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		if (this.impact == null)
		{
			this.impact = mop;
		}
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
		living.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1);
	}
}
