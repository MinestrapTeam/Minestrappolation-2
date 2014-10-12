package minestrapteam.minestrappolation.spell;

import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

public class SpellPreset extends Spell
{
	public SpellPreset(SpellVariety variety, SpellEnhancement enhancement, SpellType type)
	{
		super(variety, enhancement, getPotencies(type, 255));
	}
	
	public SpellPreset(SpellVariety variety, SpellEnhancement enhancement, SpellType type, String name)
	{
		super(variety, enhancement, getPotencies(type, 255), name);
	}
	
	private static int[] getPotencies(SpellType type, int potency)
	{
		int[] potencies = new int[SpellType.spellTypes.length];
		potencies[type.id] = potency;
		return potencies;
	}
}
