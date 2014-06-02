package minestrapteam.minestrap_core.item;

import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.item.ItemFood;

public class MCItemFood extends ItemFood
{
	@Deprecated
	public MCItemFood(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, false);
		this.setCreativeTab(Minestrappolation.tabFood);
	}
}
