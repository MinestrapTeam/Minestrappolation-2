package sobiohazardous.mods.minestrappolation.extraores.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeSticky extends EntityThrowableExplosive
{
	private int	fuse	= 60;
	
	public EntityGrenadeSticky(World par1World)
	{
		super(par1World);
	}
	
	public EntityGrenadeSticky(World par1World, EntityLivingBase par2EntityLiving)
	{
		super(par1World, par2EntityLiving);
	}
	
	public EntityGrenadeSticky(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
		{
			byte b0 = 0;
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
		}
		
		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;
	}
	
	public String getTexture()
	{
		return "/mods/extraores/textures/items/item_NukeGrenade.png";
	}
	
	protected void explodeGrenade()
	{
		if (!this.exploded)
		{
			this.exploded = true;
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 2F, true);
		}
	}
	
}
