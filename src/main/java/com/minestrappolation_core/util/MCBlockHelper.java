package com.minestrappolation_core.util;

import com.minestrappolation_core.block.MCBlockStone;
import com.minestrappolation_core.block.MCBlockStone2;
import com.minestrappolation_core.block.MCBlockStoneCustom;
import com.minestrappolation_core.block.MCBlockStoneCustom2;
import com.minestrappolation_core.item.block.MCItemBlockStone;
import com.minestrappolation_core.item.block.MCItemBlockStone2;
import com.minestrappolation_core.lib.MCReference;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MCBlockHelper
{
	public static Block createStoneBlock(String[] types, String name, float hardness, boolean isChiseledSided, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStoneCustom(types, name, hardness, isChiseledSided);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String[] types, String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStoneCustom(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String[] types, String name, float hardness, boolean isChiseledSided)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStoneCustom(types, name, hardness, isChiseledSided);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String[] types, String name, float hardness)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStoneCustom(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String name, float hardness, boolean isChiseledSided, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStone(name, hardness, isChiseledSided);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStone(name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String name, float hardness, boolean isChiseledSided)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStone(name, hardness, isChiseledSided);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static Block createStoneBlock(String name, float hardness)
	{
		String name1 = "sc_" + name;
		Block block = new MCBlockStone(name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
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
	
	public static Block createStoneBlock2(String name, float hardness)
	{
		String name1 = "sc2_" + name;
		Block block = new MCBlockStone2(name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		GameRegistry.registerBlock(block, MCItemBlockStone2.class, name1);
		return block;
	}
	
	public static Block createStoneBlock2(String[] types, String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc2_" + name;
		Block block = new MCBlockStoneCustom2(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone2.class, name1);
		return block;
	}
	
	public static Block createStoneBlock2(String[] types, String name, float hardness)
	{
		String name1 = "sc2_" + name;
		Block block = new MCBlockStoneCustom2(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name));
		GameRegistry.registerBlock(block, MCItemBlockStone2.class, name1);
		return block;
	}
	
	/**
	 * Gets a block from MinestrappolationCore based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block getMCoreBlock(String name)
	{
		return GameRegistry.findBlock(MCReference.CORE_MODID, name);
	}
	
	/**
	 * Gets a block from MinestrappolationCore based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Block getMinestrappolationBlock(String name)
	{
		return GameRegistry.findBlock(MCReference.MODID, name);
	}
	
	public static String getUniqueName(Block block)
	{
		return GameData.getBlockRegistry().getNameForObject(block);
	}
}
