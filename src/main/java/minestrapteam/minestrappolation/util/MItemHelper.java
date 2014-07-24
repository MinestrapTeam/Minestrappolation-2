package minestrapteam.minestrappolation.util;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.lib.MReference;

import net.minecraft.item.Item;

/**
 * A utility class for items.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MItemHelper
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
	 * Gets a Item from Minestrappolation based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static Item get(String name)
	{
		return GameRegistry.findItem(MReference.MODID, name);
	}
	
	public static String getUniqueName(Item item)
	{
		return GameData.getItemRegistry().getNameForObject(item);
	}
}
