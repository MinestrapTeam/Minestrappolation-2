package com.minestrappolation.item;

import com.minestrappolation.core.item.MCItemFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAirSack extends MCItemFood
{
	public ItemAirSack()
	{
		super(0, 0);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if (player.isInWater())
		{
			player.setAir(player.getAir() + 60);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isInWater())
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
}
