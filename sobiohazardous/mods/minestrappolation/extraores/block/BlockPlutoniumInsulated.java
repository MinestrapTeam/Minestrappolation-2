package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;

public class BlockPlutoniumInsulated extends BlockInsulatedRadiation
{
	private IIcon	topIcon;
	
	public BlockPlutoniumInsulated(Material material)
	{
		super(material);
		this.range = 6F;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("plutoniumInsulatedSide"));
		this.topIcon = iconRegister.registerIcon("iron_block");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.topIcon;
		}
		
		return this.blockIcon;
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 180, 2, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 2, false));
			living.removePotionEffect(Potion.wither.getId());
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 40, 2, false));
		}
	}
}