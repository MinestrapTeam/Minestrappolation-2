package sobiohazardous.mods.minestrappolation.core.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.mods.minestrappolation.core.block.MBlockStonecutter;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import net.minecraft.block.Block;

public class MBlocks 
{
	public static Block stoneCutter;
		
	public static void loadBlocks()
	{
		stoneCutter = new MBlockStonecutter().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
	}
	
}
