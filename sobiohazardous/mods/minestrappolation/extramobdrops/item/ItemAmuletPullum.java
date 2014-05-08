package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmuletPullum extends ItemAmulet
{
	public ItemAmuletPullum()
	{
		super(50);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (world.isRemote)
			return;
		
		EntityPlayer player = (EntityPlayer) entity;
		double rand = Math.random();
		if (player.inventory.hasItem(this))
		{
			if (rand < 0.33)
			{
				// FIXME temp fix. Needs to damage item when player doesn't take
				// fall damage
				if (player.isAirBorne)
				{
					if (player.motionY > 1.2)
					{
						player.fallDistance = 0;
						stack.damageItem(1, player);
					}
				}
			}
		}
	}
}
