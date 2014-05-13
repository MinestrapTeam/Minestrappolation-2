package com.minestrappolation.item;

import com.minestrappolation.core.item.MCItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.ItemStack;

public class MItemFoiled extends MCItem
{
	public MItemFoiled()
	{
		super();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
}