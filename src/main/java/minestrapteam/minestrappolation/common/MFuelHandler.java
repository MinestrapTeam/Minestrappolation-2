package minestrapteam.minestrappolation.common;

import cpw.mods.fml.common.IFuelHandler;
import minestrapteam.minestrappolation.block.MBlockCustom;
import minestrapteam.minestrappolation.block.MBlockCustom2;
import minestrapteam.minestrappolation.item.block.MCItemBlockCustom;
import minestrapteam.minestrappolation.item.block.MCItemBlockCustom2;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == MItems.guano)
		{
			return 2000;
		}
		if (fuel.getItem() == MItems.uranium)
		{
			return 24000;
		}
		else if (fuel.getItem() == MItems.plutonium)
		{
			return 32000;
		}
		else if (fuel.getItem() instanceof MCItemBlockCustom)
		{
			MCItemBlockCustom item = (MCItemBlockCustom) fuel.getItem();
			MBlockCustom block = item.theBlock;
			if (block != null && block.getMaterial() == Material.wood)
			{
				return 300;
			}
		}
		else if (fuel.getItem() instanceof MCItemBlockCustom2)
		{
			MCItemBlockCustom2 item = (MCItemBlockCustom2) fuel.getItem();
			MBlockCustom2 block = item.theBlock;
			if (block != null && block.getMaterial() == Material.wood)
			{
				String type = block.getType(fuel.getItemDamage());
				if ("pillar".equals(type))
				{
					return 300;
				}
				else
				{
					return 150;
				}
			}
		}
		else if (fuel.getItem() == MItems.cardboardItem)
		{
			return 50;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(MBlocks.cardboardBlock))
		{
			return 200;
		}
		return 0;
	}
}
