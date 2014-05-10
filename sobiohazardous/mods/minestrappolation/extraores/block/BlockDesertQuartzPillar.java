package sobiohazardous.mods.minestrappolation.extraores.block;

import net.minecraft.creativetab.CreativeTabs;
import sobiohazardous.mods.minestrappolation.core.block.MBlockPillar;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

public class BlockDesertQuartzPillar extends MBlockPillar
{
	/**
	 * @Deprecated due to the 1.7.2 update, please instantiate BlockPillar
	 */
	@Deprecated
	public BlockDesertQuartzPillar()
	{
		super(MAssetManager.getEOTextureSC("DesertQuartz_Pillar_Side_0"), MAssetManager.getEOTextureSC("DesertQuartz_Pillar_Top_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
