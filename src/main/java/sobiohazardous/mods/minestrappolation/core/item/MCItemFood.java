package sobiohazardous.mods.minestrappolation.core.item;

import net.minecraft.item.ItemFood;

public class MCItemFood extends ItemFood
{
	@Deprecated
	public MCItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
	}
}
