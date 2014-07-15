package minestrapteam.minestrappolation.block;

import minestrapteam.mcore.block.MCBlockPillar;
import minestrapteam.mcore.util.MCAssetManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class BlockRadiantPillar extends MCBlockPillar
{
	public BlockRadiantPillar()
	{
		super(MCAssetManager.getStonecutterTexture("RadiantQuartz_Pillar_Side_0"), MCAssetManager.getStonecutterTexture("RadiantQuartz_Raw_0_0"));
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
