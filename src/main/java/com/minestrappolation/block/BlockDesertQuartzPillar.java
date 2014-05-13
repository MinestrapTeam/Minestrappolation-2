package com.minestrappolation.block;

import com.minestrappolation.core.block.MCBlockPillar;
import com.minestrappolation.core.util.MCAssetManager;

import net.minecraft.creativetab.CreativeTabs;

public class BlockDesertQuartzPillar extends MCBlockPillar
{
	/**
	 * @Deprecated due to the 1.7.2 update, please instantiate BlockPillar
	 */
	@Deprecated
	public BlockDesertQuartzPillar()
	{
		super(MCAssetManager.getSCTexture("DesertQuartz_Pillar_Side_0"), MCAssetManager.getSCTexture("DesertQuartz_Pillar_Top_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
