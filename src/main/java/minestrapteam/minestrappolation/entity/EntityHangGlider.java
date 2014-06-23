package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityHangGlider extends Entity
{
	public String	owner;
	
	private boolean	initCheck	= true;
	private boolean	checking	= false;
	
	public EntityHangGlider(World world)
	{
		super(world);
	}
	
	public EntityHangGlider(World world, EntityPlayer owner)
	{
		super(world);
		this.setPosition(owner.posX, owner.posY, owner.posZ);
		this.owner = owner.getDisplayName();
		owner.mountEntity(this);
	}
	
	@Override
	public void onUpdate()
	{
		System.out.println("Hangglider @ " + this.posX + ";" + this.posY + ";" + this.posZ);
		
		Entity player = this.riddenByEntity;
		if (player != null)
		{
			double absX = Math.abs(player.motionX);
			double absZ = Math.abs(player.motionZ);
			player.motionY *= 0.645D;
			player.fallDistance = 0;
			
			if (absX < 0.9D)
			{
				player.motionX *= 1.06D;
			}
			else if (absX < 0.15D)
			{
				player.motionX *= 1.1D;
			}
			
			if (absZ < 0.9D)
			{
				player.motionZ *= 1.06D;
			}
			else if (absZ < 0.15D)
			{
				player.motionZ *= 1.1D;
			}
			
			if (this.initCheck && absX + absZ > 0.15D)
			{
				this.checking = true;
				this.initCheck = false;
			}
			else if (!player.isCollidedHorizontally)
			{
				this.checking = false;
				this.initCheck = true;
			}
			
			// The problem for no damage is that player.isCollidedHorizontally
			// only
			// works client side, so it damages only client side, and not server
			// side. these packets do nothing.
			if (this.checking && player.isCollidedHorizontally)
			{
				player.motionX = 0D;
				player.motionZ = 0D;
				this.checking = false;
				this.initCheck = true;
			}
			
			// wall colision
			/*
			 * if((Math.abs(prev2XMotion) > 0.3 || Math.abs(prev2ZMotion) > 0.3
			 * || (Math.abs(prev2XMotion) > 0.3 && Math.abs(prev2ZMotion) >
			 * 0.3)) && player.isCollidedHorizontally &&
			 * Math.abs(player.motionY) > 0.13) { par1ItemStack.damageItem(1,
			 * Minecraft.getMinecraft().thePlayer); }
			 */
		}
	}
	
	@Override
	protected void entityInit()
	{
		
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.owner = nbt.getString("owner");
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setString(this.owner, "owner");
	}
}
