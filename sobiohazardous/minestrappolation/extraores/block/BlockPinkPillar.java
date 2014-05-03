package sobiohazardous.minestrappolation.extraores.block;

import net.minecraft.creativetab.CreativeTabs;
import sobiohazardous.minestrappolation.api.block.BlockPillar;
import sobiohazardous.minestrappolation.api.util.MAssetManager;

public class BlockPinkPillar extends BlockPillar
{
	/**
	 * @Deprecated due to the 1.7.2 update, please instantiate BlockPillar
	 */
	@Deprecated
	public BlockPinkPillar()
	{
		super(MAssetManager.getEOStonecutterTexture("DesertQuartz_Pillar_Side_0"), MAssetManager.getEOStonecutterTexture("DesertQuartz_Pillar_Top_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
