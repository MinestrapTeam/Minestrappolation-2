package com.minestrappolation.item;

import com.minestrappolation.core.item.MCItemFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCalimari extends MCItemFood
{
	public ItemCalimari(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.heal(2F);
		super.onEaten(stack, world, player);
		return super.onEaten(stack, world, player);
	}
	
}
