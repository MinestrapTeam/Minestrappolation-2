package com.minestrappolation.core.util;

import com.minestrappolation.core.block.MCBlockStone;
import com.minestrappolation.core.block.MCBlockStone2;
import com.minestrappolation.core.itemblocks.MCItemBlockMulti;
import com.minestrappolation.core.itemblocks.MCItemBlockStone2;
import com.minestrappolation.core.lib.MCReference;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MCBlockHelper
{
	public static Block createStoneBlock(String name, float hardness, CreativeTabs tab)
	{
		String name1 = "stone_" + name;
		Block block1 = new MCBlockStone(name, hardness).setBlockName(name1).setCreativeTab(tab);
		GameRegistry.registerBlock(block1, MCItemBlockMulti.class, name1);
		return block1;
	}
	
	public static Block createStoneBlock2(String name, float hardness, CreativeTabs tab)
	{
		String name2 = "stone2_" + name;
		Block block2 = new MCBlockStone2(name, hardness).setBlockName(name2).setCreativeTab(tab);
		GameRegistry.registerBlock(block2, MCItemBlockStone2.class, name2);
		return block2;
	}
	
	/**
	 * Gets a block from modId based on name.
	 * 
	 * @param modId
	 * @param name
	 * @return
	 */
	public static Block get(String modId, String name)
	{
		return GameRegistry.findBlock(modId, name);
	}
	
	/**
	 * Gets a block from MAPI based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block get(String name)
	{
		return GameRegistry.findBlock(MCReference.MINESTRAP_CORE_ID, name);
	}
	
	public static String getUniqueName(Block block)
	{
		return GameData.getBlockRegistry().getNameForObject(block);
	}
}
