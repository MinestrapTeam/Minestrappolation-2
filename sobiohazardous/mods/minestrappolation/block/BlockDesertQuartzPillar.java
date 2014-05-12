package sobiohazardous.mods.minestrappolation.block;

import net.minecraft.creativetab.CreativeTabs;
import sobiohazardous.mods.minestrappolation.core.block.MCBlockPillar;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;

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
