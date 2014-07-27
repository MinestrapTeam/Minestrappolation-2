package minestrapteam.minestrappolation.common;

import cpw.mods.fml.common.IFuelHandler;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		Item item = fuel.getItem();
		if (item == MItems.plutonium)
		{
			return 35000;
		}
		else if (item == MItems.uranium)
		{
			return 30000;
		}
		else if (item == MItems.guano)
		{
			return 2000;
		}
		return 0;
	}
}
