package com.minestrappolation.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockMossyWood extends Block
{
	public static final String[]	types	= new String[] { "Oak", "Spruce", "Birch", "Jungle" };
	
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	
	public BlockMossyWood()
	{
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return this.iconArray[metadata % this.iconArray.length];
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[types.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(MCAssetManager.getTexture("mossyPlanks") + types[i]);
		}
	}
}
