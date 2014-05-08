package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;
import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MBlockMultiRoad extends Block
{
	private IIcon[]		sideIcons;
	private IIcon[]		topIcons;
	private IIcon[]		bottomIcons;
	
	private String[]	sideIconNames;
	private String[]	topIconNames;
	private String[]	bottomIconNames;
	
	public MBlockMultiRoad(Material mat, String[] sideIcons, String[] topIcons, String[] bottomIcons)
	{
		super(Material.rock);
		this.sideIconNames = sideIcons;
		this.topIconNames = topIcons;
		this.bottomIconNames = bottomIcons;
		this.setCreativeTab(Minestrappolation.creativeTabStone);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.sideIcons = new IIcon[this.sideIconNames.length];
		this.topIcons = new IIcon[this.topIconNames.length];
		this.bottomIcons = new IIcon[this.bottomIconNames.length];
		
		for (int i = 0; i < this.sideIcons.length; ++i)
		{
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
		
		for (int i = 0; i < this.topIcons.length; ++i)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
		}
		
		for (int i = 0; i < this.bottomIcons.length; ++i)
		{
			this.bottomIcons[i] = iconRegister.registerIcon(this.bottomIconNames[i]);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0)
		{
			return this.bottomIcons[meta];
		}
		else if (side == 1)
		{
			return this.topIcons[meta];
		}
		return this.sideIcons[meta];
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
