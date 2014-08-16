package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUraniumOre extends BlockRadiation
{
	public BlockUraniumOre(Material material)
	{
		super(material);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.uranium;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(2);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (Minestrappolation.shouldOresEffect)
		{
			if (living instanceof EntityZombie)
			{
				living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 180, 1, false));
				living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 0, false));
			}
			else
			{
				living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 120, 1, false));
			}
		}
	}
	
	public void spawnParticle(World world, int x, int y, int z)
	{
		MUtil.spawnParticle2(world, x, y, z, world.rand, "smoke");
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		return 5 + fortune;
	}
	
	@Override
	public float getRange()
	{
		return 1.5F;
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		world.createExplosion(null, x, y, z, 4F, true);
	}
}