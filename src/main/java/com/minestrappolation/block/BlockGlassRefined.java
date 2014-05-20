package com.minestrappolation.block;

import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class BlockGlassRefined extends BlockGlass
{
	public BlockGlassRefined(Material material, boolean flag)
	{
		super(material, flag);
		this.setBlockTextureName(MCAssetManager.getTexture("clearGlass"));
	}
}
