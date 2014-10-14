package minestrapteam.minestrappolation.spell;

import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

public class SpellPreset extends Spell
{
	public SpellPreset(SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, SpellType type)
	{
		super(category, variety, enhancement, getPotencies(type, 255));
	}
	
	public SpellPreset(String name, SpellCategory category, SpellVariety variety, SpellEnhancement enhancement, SpellType type)
	{
		super(name, category, variety, enhancement, getPotencies(type, 255));
	}
	
	private static int[] getPotencies(SpellType type, int potency)
	{
		int[] potencies = new int[SpellType.spellTypes.length];
		potencies[type.id] = potency;
		return potencies;
	}
}
