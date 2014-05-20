package com.minestrappolation.block;

import java.util.List;

import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStones extends Block
{
	private IIcon	refined;
	
	public BlockStones()
	{
		super(Material.rock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getSCTexture("Stone_Tiles_0_0"));
		this.refined = iconRegister.registerIcon(MCAssetManager.getSCTexture("Stone_Refined_0_0"));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 1)
		{
			return this.refined;
		}
		return this.blockIcon;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
