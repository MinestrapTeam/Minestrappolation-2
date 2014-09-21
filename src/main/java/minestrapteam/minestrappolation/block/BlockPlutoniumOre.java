package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlutoniumOre extends BlockRadiationOre
{
	public BlockPlutoniumOre()
	{

	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.plutonium;
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
			if (living instanceof EntitySkeleton)
			{
				living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 6, 1, false));
				living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 20 * 6, 0, false));
				
			}
			else
			{
				living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 40, 0, false));
			}
		}
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		this.spawnParticle(world, x, y, z);
		super.onBlockClicked(world, x, y, z, player);
	}
	
	public void spawnParticle(World world, int x, int y, int z)
	{
		MUtil.spawnParticle(world, x, y, z, world.rand, "mobSpell");
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