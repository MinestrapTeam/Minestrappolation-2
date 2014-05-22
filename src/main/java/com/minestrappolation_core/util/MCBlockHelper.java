package com.minestrappolation_core.util;

import com.minestrappolation_core.block.MCBlockStone;
import com.minestrappolation_core.block.MCBlockStone2;
import com.minestrappolation_core.item.block.MCItemBlockStone;
import com.minestrappolation_core.item.block.MCItemBlockStone2;
import com.minestrappolation_core.lib.MCReference;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MCBlockHelper
{
	public static Block createStoneBlock(String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStone(name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock2(String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc2_" + name;
		Block block = new MCBlockStone2(name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone2.class, name1);
		return block;
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
