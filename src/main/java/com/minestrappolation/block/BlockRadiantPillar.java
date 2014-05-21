package com.minestrappolation.block;

import com.minestrappolation_core.block.MCBlockPillar;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.creativetab.CreativeTabs;

public class BlockRadiantPillar extends MCBlockPillar
{
	public BlockRadiantPillar()
	{
		super(MCAssetManager.getStonecutterTexture("RadiantQuartz_Pillar_Side_0"), MCAssetManager.getStonecutterTexture("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
