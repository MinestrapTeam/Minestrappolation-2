package sobiohazardous.mods.minestrappolation.core.item;

import net.minecraft.item.ItemFood;

public class MItemFood extends ItemFood
{
	@Deprecated
	public MItemFood(int healAmt, float sat)
	{
		super(healAmt, sat, false);
	}
}