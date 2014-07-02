package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrap_core.util.MCUtil;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlutoniumOre extends BlockRadiation
{
	public BlockPlutoniumOre(Material material)
	{
		super(material);
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
		if (Minestrappolation.shouldOresEffect && living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 6, 1, false));
			living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 20 * 6, 0, false));

		}
		else if (Minestrappolation.shouldOresEffect)
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 20, 1, false));
		}
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		this.spawnParticle(par1World, par2, par3, par4);
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
	}
	
	public void spawnParticle(World world, int x, int y, int z)
	{
		MCUtil.spawnParticle(world, x, y, z, world.rand, "mobSpell");
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
}