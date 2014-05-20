package com.minestrappolation_core.lib;

import com.minestrappolation_core.block.MCBlockStonecutter;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;

public class MCBlocks
{
	public static Block	stoneCutter;
	
	public static void init()
	{
		stoneCutter = new MCBlockStonecutter().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
	}
}
