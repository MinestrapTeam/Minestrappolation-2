package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityNukePrimed extends Entity
{
	public int				fuse;
	public EntityLivingBase	placedBy;
	
	public EntityNukePrimed(World world)
	{
		super(world);
		this.preventEntitySpawning = true;
		this.yOffset = this.height / 2.0F;
		this.setSize(0.98F, 0.98F);
	}
	
	public EntityNukePrimed(World world, double x, double y, double z, EntityLivingBase placedBy)
	{
		this(world);
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * Math.PI * 2.0D);
		this.motionX = Math.sin(f) * -0.02D;
		this.motionY = 0.20000000298023224D;
		this.motionZ = Math.cos(f) * -0.2D;
		this.fuse = 120;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.placedBy = placedBy;
	}
	
	@Override
	protected void entityInit()
	{
	}
	
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}
	
	@Override
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}
	
	@Override
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		
		if (this.onGround)
		{
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}
		
		if (this.fuse-- <= 0)
		{
			this.setDead();
			
			if (!this.worldObj.isRemote)
			{
				this.explode();
			}
		}
		else
		{
			this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
		}
	}
	
	private void explode()
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 32F, true);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setShort("Fuse", (byte) this.fuse);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.fuse = nbt.getShort("Fuse");
	}
	
	@Override
	public float getShadowSize()
	{
		return 1F;
	}
	
	public EntityLivingBase getPlacedBy()
	{
		return this.placedBy;
	}
}