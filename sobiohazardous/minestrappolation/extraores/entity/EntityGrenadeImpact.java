package sobiohazardous.minestrappolation.extraores.entity;

import java.util.List;

import sobiohazardous.minestrappolation.extraores.item.ItemGrenade;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGrenadeImpact extends EntityThrowableExplosive
{
    private int fuse = 60;
    
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
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if(worldObj.isRemote)
        {
            explodeGrenade();
        }
    }

    public String getTexture()
    {
        return "/mods/extraores/textures/items/item_NukeGrenade.png";
    }
    
    protected void explodeGrenade()
    {
    	if(!exploded)
    	{
	    	exploded = true;
	        worldObj.createExplosion(null, posX, posY, posZ, 2F, true);
    	}
    }

   
}
