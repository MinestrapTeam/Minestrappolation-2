package com.minestrappolation.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmuletPorcum extends ItemAmulet
{
	int	tick	= 0;
	
	public ItemAmuletPorcum()
	{
		super(50);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (world.isRemote)
		{
			return;
		}
		
		EntityPlayer player = (EntityPlayer) entity;
		Random rand = new Random();
		int randnum = rand.nextInt(61);
		this.tick++;
		if (player.inventory.hasItem(this))
		{
			if (this.tick > 60)
			{
				if (randnum > 59)
				{
					this.tick = 0;
					if (player.getFoodStats().needFood())
					{
						player.getFoodStats().addStats(1, 0F);
						stack.damageItem(1, player);
					}
				}
			}
			else if (this.tick > 120)
			{
				this.tick = 0;
			}
		}
	}
}
