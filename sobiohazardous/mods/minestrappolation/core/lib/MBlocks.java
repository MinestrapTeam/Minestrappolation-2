package sobiohazardous.mods.minestrappolation.core.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.block.MBlockStonecutter;
import net.minecraft.block.Block;

public class MBlocks
{
	public static Block	stoneCutter;
	
	public static void init()
	{
		stoneCutter = new MBlockStonecutter().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
	}
	
}
