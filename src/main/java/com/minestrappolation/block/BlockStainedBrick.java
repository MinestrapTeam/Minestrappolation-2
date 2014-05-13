package com.minestrappolation.block;

import java.util.List;

import com.minestrappolation.core.util.MCAssetManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStainedBrick extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	public static final String[]	stainedBrickTextures	= new String[] { MCAssetManager.getSCTexture("Clay_Bricks_0_Black"), MCAssetManager.getSCTexture("Clay_Bricks_0_Blue"), MCAssetManager.getSCTexture("Clay_Bricks_0_Brown"), MCAssetManager.getSCTexture("Clay_Bricks_0_Cyan"), MCAssetManager.getSCTexture("Clay_Bricks_0_Green"), MCAssetManager.getSCTexture("Clay_Bricks_0_Grey"), MCAssetManager.getSCTexture("Clay_Bricks_0_LightBlue"), MCAssetManager.getSCTexture("Clay_Bricks_0_Lime"), MCAssetManager.getSCTexture("Clay_Bricks_0_Magenta"), MCAssetManager.getSCTexture("Clay_Bricks_0_Orange"), MCAssetManager.getSCTexture("Clay_Bricks_0_Pink"), MCAssetManager.getSCTexture("Clay_Bricks_0_Purple"), MCAssetManager.getSCTexture("Clay_Bricks_0_Red"), MCAssetManager.getSCTexture("Clay_Bricks_0_Silver"),
			MCAssetManager.getSCTexture("Clay_Bricks_0_White"), MCAssetManager.getSCTexture("Clay_Bricks_0_Yellow") };

	public BlockStainedBrick()
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
		for (int i = 0; i < 16; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[stainedBrickTextures.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(stainedBrickTextures[i]);
		}
	}
}