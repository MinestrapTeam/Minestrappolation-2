package sobiohazardous.minestrappolation.extraores.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowableExplosive
{
    private int fuse = 60;
    
	public EntityGrenade(World par1World)
    {
        super(par1World);
    }

    public EntityGrenade(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityGrenade(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 0;
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);   
        }
        /*if (!this.worldObj.isRemote)
        {            
                AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
                List list1 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, axisalignedbb);

                if (list1 != null && !list1.isEmpty())
                {
                    Iterator iterator = list1.iterator();

                    while (iterator.hasNext())
                    {
                        EntityLiving entityliving = (EntityLiving)iterator.next();
                        double d0 = this.getDistanceSqToEntity(entityliving);

                        if (d0 < 16.0D)
                        {
                            double d1 = 1.0D - Math.sqrt(d0) / 4.0D;

                            if (entityliving == par1MovingObjectPosition.entityHit)
                            {
                                d1 = 1.0D;
                            }

                            
                                    
                                        entityliving.addPotionEffect(new PotionEffect(Potion.poison.getId(), 180, 2, false));
                                    
                                
                            
                        }
                    }
                }
            
        }*/
    }

}
