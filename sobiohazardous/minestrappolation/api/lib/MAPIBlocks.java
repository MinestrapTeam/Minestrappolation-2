package sobiohazardous.minestrappolation.api.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.block.BlockStonecutter;
import net.minecraft.block.Block;

public class MAPIBlocks 
{
	public static Block stoneCutter;
	
	public static void loadBlocks()
	{
		stoneCutter = new BlockStonecutter(MAPIConfig.stoneCutterId).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
		LanguageRegistry.addName(stoneCutter, "Stone Cutter");
	}
}
