package com.minestrappolation_core.item;

import com.minestrappolation.Minestrappolation;

import net.minecraft.item.ItemFood;

public class MCItemFood extends ItemFood
{
	@Deprecated
	public MCItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
		this.setCreativeTab(Minestrappolation.tabFood);
	}
}
