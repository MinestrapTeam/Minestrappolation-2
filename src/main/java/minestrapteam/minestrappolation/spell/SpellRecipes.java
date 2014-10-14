package minestrapteam.minestrappolation.spell;

import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.item.ItemStack;

public class SpellRecipes
{
	public static int getPotency(SpellType type, ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		// FIXME
		return 255;
	}
	
	public static SpellCategory getCategory(ItemStack stack)
	{
		if (stack == null)
		{
			return null;
		}
		// FIXME
		return SpellCategory.OFFENSE;
	}
	
	public static SpellVariety getVariety(ItemStack stack, SpellCategory category)
	{
		if (stack == null)
		{
			return null;
		}
		// FIXME
		return SpellVariety.PROJECTILE;
	}
	
	public static SpellEnhancement getEnhancement(ItemStack stack, SpellVariety variety)
	{
		if (stack == null)
		{
			return null;
		}
		// FIXME
		return null;
	}
}
