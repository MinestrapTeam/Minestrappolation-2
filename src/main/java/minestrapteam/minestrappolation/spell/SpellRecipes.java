package minestrapteam.minestrappolation.spell;

import scala.actors.threadpool.Arrays;
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
		return 100 * stack.stackSize;
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
	
	public static int[] combinePotencies(int[] potencies)
	{
		potencies = Arrays.copyOf(potencies, 8);
		combinePotencies(potencies, SpellType.WATER, SpellType.FIRE, SpellType.WIND);
		combinePotencies(potencies, SpellType.WATER, SpellType.ELECTRICITY, SpellType.ELECTRICITY);
		combinePotencies(potencies, SpellType.EARTH, SpellType.ELECTRICITY, SpellType.EARTH);
		combinePotencies(potencies, SpellType.FROST, SpellType.FIRE, SpellType.WATER);
		return potencies;
	}
	
	private static void combinePotencies(int[] potencies, SpellType type1, SpellType type2, SpellType type3)
	{
		int i1 = type1.id;
		int p1 = potencies[i1];
		if (p1 > 0)
		{
			int i2 = type2.id;
			int p2 = potencies[i2];
			if (p2 > 0)
			{
				potencies[i1] = 0;
				potencies[i2] = 0;
				potencies[type3.id] += p1 + p2;
			}
		}
	}
}
