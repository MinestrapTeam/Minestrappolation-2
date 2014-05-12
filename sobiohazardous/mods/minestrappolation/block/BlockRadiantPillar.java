package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.block.MCBlockPillar;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;

import net.minecraft.creativetab.CreativeTabs;

public class BlockRadiantPillar extends MCBlockPillar
{
	public BlockRadiantPillar()
	{
		super(MCAssetManager.getSCTexture("RadiantQuartz_Pillar_Side_0"), MCAssetManager.getSCTexture("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
