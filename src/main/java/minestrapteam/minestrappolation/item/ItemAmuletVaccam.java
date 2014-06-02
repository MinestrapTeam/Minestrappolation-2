package minestrapteam.minestrappolation.item;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemAmuletVaccam extends ItemAmulet
{
	Random	rand	= new Random();
	
	public ItemAmuletVaccam()
	{
		super(50);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		EntityPlayer player = (EntityPlayer) entity;
		// not a crit
		if (entity.attackEntityFrom(DamageSource.generic, 1.0F))
		{
			if (this.rand.nextInt(10) < 2)
			{
				player.onCriticalHit(attacker);
				stack.damageItem(1, player);
			}
		}
		
		return true;
	}
}
