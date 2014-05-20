package com.minestrappolation.block;

import com.minestrappolation_core.block.MCBlockPillar;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.creativetab.CreativeTabs;

public class BlockRadiantPillar extends MCBlockPillar
{
	public BlockRadiantPillar()
	{
		super(MCAssetManager.getSCTexture("RadiantQuartz_Pillar_Side_0"), MCAssetManager.getSCTexture("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
