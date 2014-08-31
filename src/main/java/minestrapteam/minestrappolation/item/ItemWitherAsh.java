package minestrapteam.minestrappolation.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWitherAsh extends MItem
{
	public int	effectTick	= 0;
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int tick, boolean flag)
	{
		this.effectTick++;
		if (this.effectTick == itemRand.nextInt(400) + 200)
		{
			EntityPlayer player = (EntityPlayer) entity;
			player.addPotionEffect(new PotionEffect(Potion.wither.id, itemRand.nextInt(100) + 100));
			this.effectTick = 0;
		}
	}
}
