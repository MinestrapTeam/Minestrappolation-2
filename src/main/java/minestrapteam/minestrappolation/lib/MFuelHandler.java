package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.IFuelHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		Item item = fuel.getItem();
		if (item == MItems.Plutonium)
		{
			return 35000;
		}
		else if (item == MItems.Uranium)
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
