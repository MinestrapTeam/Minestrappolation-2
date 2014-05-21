package com.minestrappolation.block;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlowGlass extends BlockGlass
{
	public BlockGlowGlass(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("glow_glass"));
		this.setCreativeTab(Minestrappolation.tabDecorationBlocks);
	}
}
