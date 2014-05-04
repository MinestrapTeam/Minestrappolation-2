package sobiohazardous.mods.minestrappolation.core.util;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MItemHelper 
{
	/**
	 * Gets a Item from modId based on name
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
	 * @param name
	 * @return
	 */
	public static Item get(String name)
    {
        return GameRegistry.findItem("minestrappolaton", name);
    }
    
    public static String getUniqueName(Item item)
    {
        return GameData.itemRegistry.getNameForObject(item);
    }
}
