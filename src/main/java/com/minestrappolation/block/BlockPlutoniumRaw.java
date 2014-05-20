package com.minestrappolation.block;

import com.minestrappolation_core.util.MCUtil;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
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
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("Minestrappolation:block_PlutoniumRaw");
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 180, 2, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 1, false));
			living.removePotionEffect(Potion.wither.getId());
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.id, 40, 2, false));
			// living.addPotionEffect(new
			// PotionEffect(Potion.poison.getId(),200,10));
		}
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return this.canPlaceBlockAt(world, x, y, z);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		if (!world.isRemote && !MCUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			world.createExplosion(null, x, y, z, 4F, false);
		}
		return true;
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int side)
	{
		this.canPlaceBlockAt(world, x, y, z);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		this.canPlaceBlockAt(world, x, y, z);
	}
}