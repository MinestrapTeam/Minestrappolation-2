package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockPlutoniumRaw extends BlockRadiation
{
	public BlockPlutoniumRaw(Material material)
	{
		super(material);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		if (random.nextInt(500) == 0 && !MUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			world.createExplosion(null, x, y, z, 5F, true);
		}
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		world.createExplosion(null, x, y, z, 5F, true);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 180, 2, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 1, false));
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.id, 40, 1, false));
		}
	}
	
	@Override
	public float getRange()
	{
		return 5F;
	}
}