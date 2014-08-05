package minestrapteam.minestrappolation.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityGrenadeNuke extends EntityThrowableExplosive
{
	public EntityGrenadeNuke(World world)
	{
		super(world);
		this.explosionRange = 8F;
	}
	
	public EntityGrenadeNuke(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
		this.explosionRange = 8F;
	}
	
	public EntityGrenadeNuke(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		this.explosionRange = 8F;
	}
	
	@Override
	public void affectEntity(EntityLivingBase living)
	{
		living.addPotionEffect(new PotionEffect(Potion.poison.id, 10 * 20, 2));
	}
}
