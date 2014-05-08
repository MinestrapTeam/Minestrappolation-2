package sobiohazardous.mods.minestrappolation.extraores.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeImpact extends EntityThrowableExplosive
{
	private int	fuse	= 60;
	
	public EntityGrenadeImpact(World par1World)
	{
		super(par1World);
	}
	
	public EntityGrenadeImpact(World par1World, EntityLivingBase par2EntityLiving)
	{
		super(par1World, par2EntityLiving);
	}
	
	public EntityGrenadeImpact(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (this.worldObj.isRemote)
		{
			this.explodeGrenade();
		}
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
