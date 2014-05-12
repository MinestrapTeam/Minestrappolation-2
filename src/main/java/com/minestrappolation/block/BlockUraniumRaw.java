package com.minestrappolation.block;

import com.minestrappolation.core.util.MCAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class BlockUraniumRaw extends BlockPlutoniumRaw
{
	public BlockUraniumRaw(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("blockUranium"));
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntityZombie)
		{
			living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 180, 2, false));
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 300, 1, false));
		}
	}
}