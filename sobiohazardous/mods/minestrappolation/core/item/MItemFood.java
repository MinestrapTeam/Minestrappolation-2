package sobiohazardous.mods.minestrappolation.core.item;

import net.minecraft.item.ItemFood;

public class MItemFood extends ItemFood
{
	@Deprecated
	public MItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
	}
}
