package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlockPillar;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockRadiantPillar extends MBlockPillar
{
	private IIcon	top;
	
	/**
	 * @Deprecated due to the 1.7.2 update, please instantiate BlockPillar
	 */
	@Deprecated
	public BlockRadiantPillar()
	{
		super(MAssetManager.getEOStonecutterTexture("RadiantQuartz_Pillar_Side_0"), MAssetManager.getEOStonecutterTexture("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
