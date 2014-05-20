package com.minestrappolation.block;

import java.util.List;

import com.minestrappolation.Minestrappolation;
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

public class BlockEndStone extends Block
{
	private IIcon	refined;
	private IIcon	smooth;
	private IIcon	brick;
	
	public BlockEndStone()
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.brick = iconRegister.registerIcon(MCAssetManager.getSCTexture("Endstone_Bricks_0_0"));
		this.refined = iconRegister.registerIcon(MCAssetManager.getSCTexture("Endstone_Refined_0_0"));
		this.smooth = iconRegister.registerIcon(MCAssetManager.getSCTexture("Endstone_Raw_0_0"));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			return this.brick;
		}
		else if (metadata == 1)
		{
			return this.smooth;
		}
		else
		{
			return this.refined;
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
	}
	
}