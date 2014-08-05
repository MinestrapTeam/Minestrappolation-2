package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.util.MAssetManager;

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
	private IIcon	bottomIcon;
	
	public BlockPlutoniumInsulated(Material material)
	{
		super(material);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getMineralTexture("plutonium_insulated"));
		this.topIcon = iconRegister.registerIcon(MAssetManager.getMineralTexture("steel_block_top"));
		this.bottomIcon = iconRegister.registerIcon(MAssetManager.getMineralTexture("steel_block_bottom"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1)
		{
			return this.topIcon;
		}
		if (side == 0)
		{
			return this.bottomIcon;
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
	
	@Override
	public float getRange()
	{
		return 6F;
	}
}