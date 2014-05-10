package sobiohazardous.mods.minestrappolation.core.util;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;

public class MBlockHelper
{
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
		return GameRegistry.findBlock(MReference.MAPI_MODID, name);
	}
	
	public static String getUniqueName(Block block)
	{
		return GameData.getBlockRegistry().getNameForObject(block);
	}
}
