package minestrapteam.minestrappolation.block;

import minestrapteam.minestrap_core.util.MCAssetManager;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;

public class BlockUraniumInsulated extends BlockInsulatedRadiation
{
	private IIcon	topIcon;
	
	public BlockUraniumInsulated(Material material)
	{
		super(material);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getMineralTexture("uranium_insulated"));
		this.topIcon = iconRegister.registerIcon("iron_block");
	}
	
	@Override
	public IIcon getIcon(int i, int j)
	{
		if (i == 0 || i == 1)
		{
			return this.topIcon;
		}
		
		return this.blockIcon;
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntityZombie)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 300, 1, false));
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 180, 2, false));
		}
		
	}
	
	@Override
	public float getRange()
	{
		return 6F;
	}
}