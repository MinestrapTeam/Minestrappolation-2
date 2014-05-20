package com.minestrappolation.block;

import java.util.List;

import com.minestrappolation_core.util.MCAssetManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStoneLamp extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	public static final String[]	stoneLampTextures	= new String[] { MCAssetManager.getSCTexture("Stone_LampGlowstone_0_0"), MCAssetManager.getSCTexture("Stone_LampSunstone_0_0") };

	public BlockStoneLamp()
	{
		super(Material.rock);
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
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[stoneLampTextures.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(stoneLampTextures[i]);
		}
	}
}
