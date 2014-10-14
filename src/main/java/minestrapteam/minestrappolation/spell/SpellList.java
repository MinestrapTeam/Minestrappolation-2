package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

public class SpellList
{
	public static final List<Spell>	spells	= new ArrayList();
	
	private SpellList()
	{
	}
	
	public static void init()
	{
		int varieties = SpellVariety.spellVarieties.length;
		int enhancements = SpellEnhancement.spellEnhancements.length;
		int types = SpellType.spellTypes.length;
		
		for (int t = 0; t < types; t++)
		{
			SpellType type = SpellType.get(t);
			for (int v = 0; v < varieties; v++)
			{
				SpellVariety variety = SpellVariety.get(v);
				
				// Default, no Enhancement
				spells.add(new SpellPreset(variety.category, variety, null, type));
				
				for (int c = 0; c < enhancements; c++)
				{
					SpellEnhancement enhancement = SpellEnhancement.get(c);
					
					// Apply all Enhancements that work with the current variety
					if (enhancement != null && enhancement.canApply(variety))
					{
						spells.add(new SpellPreset(variety.category, variety, enhancement, type));
					}
				}
			}
		}
	}
	
	public static Spell getRandomSpell(String name, Random random)
	{
		SpellVariety variety = SpellVariety.random(random);
		SpellEnhancement enhancement = SpellEnhancement.random(random);
		SpellType type = SpellType.random(random);
		
		return new SpellPreset(name, variety.category, variety, enhancement, type);
	}
}
