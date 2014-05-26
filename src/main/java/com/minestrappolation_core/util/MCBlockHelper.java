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
	public static final String[]	types	= new String[] { "raw", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", "cracked", "mossy", null, null, null, null, null, "glowstone_lamp", "sunstone_lamp" };
	public static final String[]	types2	= new String[] { "pillar", "raw_slab", "brick_slab", "tile_slab", "refined_slab" };
	
	public static MCBlockStone createStoneBlock(String name, float hardness, CreativeTabs tab)
	{
		return createStoneBlock(types, name, hardness, tab);
	}
	
	public static MCBlockStone createStoneBlock(String[] types, String name, float hardness, CreativeTabs tab)
	{
		String name1 = "sc_" + name;
		MCBlockStone block = new MCBlockStone(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
		GameRegistry.registerBlock(block, MCItemBlockStone.class, name1);
		return block;
	}
	
	public static MCBlockStone2 createStoneBlock2(String name, float hardness, CreativeTabs tab)
	{
		return createStoneBlock2(types2, name, hardness, tab);
	}
	
	public static MCBlockStone2 createStoneBlock2(String[] types, String name, float hardness, CreativeTabs tab)
	{
		
		String name1 = "sc2_" + name;
		MCBlockStone2 block = new MCBlockStone2(types, name, hardness);
		block.setBlockName(name1).setBlockTextureName(MCAssetManager.getStonecutterTexture(name)).setCreativeTab(tab);
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
