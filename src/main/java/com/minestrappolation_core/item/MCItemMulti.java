package com.minestrappolation_core.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MCItemMulti extends Item
{
	private final String[]	iconNames;
	private IIcon[]			icons;
	
	public MCItemMulti(String[] iconNames)
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.iconNames = iconNames;
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.icons[metadata % this.icons.length];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.iconNames.length; ++i)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.iconNames.length];
		
		for (int i = 0; i < this.iconNames.length; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
		}
	}
}
