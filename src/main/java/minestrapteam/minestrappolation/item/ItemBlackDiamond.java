package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlackDiamond extends Item
{
	public ItemBlackDiamond()
	{
		this.setMaxDamage(6);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase living)
	{
		if (MUtil.transformMob(living))
		{
			stack.damageItem(1, player);
			player.worldObj.playSoundAtEntity(player, "mob.wither.death", 1F, 1F);
			player.worldObj.playAuxSFX(2000, (int) living.posX, (int) living.posY, (int) living.posZ, 64);
			return true;
		}
		return false;
	}
}
