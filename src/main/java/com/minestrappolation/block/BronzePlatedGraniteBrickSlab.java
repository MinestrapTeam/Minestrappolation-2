package com.minestrappolation.block;

import java.util.List;
import java.util.Random;

import com.minestrappolation.core.util.MCAssetManager;
import com.minestrappolation.lib.MBlocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BronzePlatedGraniteBrickSlab extends BlockSlab
{
	public static final String[]	woodType	= { "bronzePlatedGraniteBrick" };
	
	public BronzePlatedGraniteBrickSlab(boolean par2)
	{
		super(par2, Material.rock);
		// setBurnProperties(this, 5, 20);
		this.useNeighborBrightness = true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MCAssetManager.getSCTexture("Granite_Bricks_0_Bronze"));
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(MBlocks.bronzePlatedGraniteBrickSingleSlab);
	}
	
	@Override
	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(Item.getItemFromBlock(MBlocks.bronzePlatedGraniteBrickSingleSlab), 2, par1 & 7);
	}
	
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != Item.getItemFromBlock(MBlocks.bronzePlatedGraniteBrickDoubleSlab))
		{
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}
	
	@Override
	public String func_150002_b(int p_150002_1_)
	{
		if (p_150002_1_ < 0 || p_150002_1_ >= woodType.length)
		{
			p_150002_1_ = 0;
		}
		
		return super.getUnlocalizedName() + "." + woodType[p_150002_1_];
	}
}