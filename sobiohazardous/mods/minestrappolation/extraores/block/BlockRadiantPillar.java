package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlockPillar;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

import net.minecraft.creativetab.CreativeTabs;

public class BlockRadiantPillar extends MBlockPillar
{
	public BlockRadiantPillar()
	{
		super(MAssetManager.getEOTextureSC("RadiantQuartz_Pillar_Side_0"), MAssetManager.getEOTextureSC("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
