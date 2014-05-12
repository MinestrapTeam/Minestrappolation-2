package com.minestrappolation.core.util;

import com.minestrappolation.core.lib.MCReference;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;

public class MCItemHelper
{
	/**
	 * Gets a Item from modId based on name
	 * 
	 * @param modId
	 * @param name
	 * @return
	 */
	public static Item get(String modId, String name)
	{
		return GameRegistry.findItem(modId, name);
	}
	
	/**
	 * Gets a Item from MAPI based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Item get(String name)
	{
		return GameRegistry.findItem(MCReference.MINESTRAP_CORE_ID, name);
	}
	
	public static String getUniqueName(Item item)
	{
		return GameData.getItemRegistry().getNameForObject(item);
	}
}
