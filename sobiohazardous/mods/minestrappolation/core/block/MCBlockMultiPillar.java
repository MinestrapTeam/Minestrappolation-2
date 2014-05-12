package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.MinestrappolationCore;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MCBlockMultiPillar extends BlockRotatedPillar
{
	protected IIcon[]	sideIcons;
	protected IIcon[]	topIcons;
	
	private String[]	sideIconNames;
	private String[]	topIconNames;
	
	public MCBlockMultiPillar(Material mat, String[] sideIcons, String[] topIcons)
	{
		super(Material.wood);
		this.setCreativeTab(MinestrappolationCore.creativeTabStone);
		this.sideIconNames = sideIcons;
		this.topIconNames = topIcons;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.sideIcons = new IIcon[this.sideIconNames.length];
		this.topIcons = new IIcon[this.topIconNames.length];
		
		for (int i = 0; i < this.sideIcons.length; ++i)
		{
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
		
		for (int i = 0; i < this.topIcons.length; ++i)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
		}
	}
	
	@Override
	protected IIcon getSideIcon(int meta)
	{
		return this.sideIcons[meta % this.sideIcons.length];
	}
	
	@Override
	protected IIcon getTopIcon(int meta)
	{
		return this.topIcons[meta % this.topIcons.length];
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.topIconNames.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
