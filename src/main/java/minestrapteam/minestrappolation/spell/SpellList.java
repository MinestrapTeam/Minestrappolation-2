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
		for (int v = 0; v < varieties; v++)
		{
			for (int t = 0; t < types; t++)
			{
				for (int c = 0; c < enhancements; c++)
				{
					SpellVariety variety = SpellVariety.get(v);
					SpellEnhancement enhancement = SpellEnhancement.get(c);
					
					if (enhancement.canApply(variety))
					{
						int[] potencies = new int[types];
						potencies[t] = 255;
						spells.add(new Spell(variety.category, variety, enhancement, potencies));
					}
				}
			}
		}
	}
	
	public static Spell getRandomSpell(String name, Random random)
	{
		SpellVariety variety = SpellVariety.random(random);
		SpellEnhancement enhancement = SpellEnhancement.random(random);
		int type = random.nextInt(SpellType.spellTypes.length);
		int[] potencies = new int[8];
		potencies[type] = 255;
		
		return new Spell(name, variety.category, variety, enhancement, potencies);
	}
}
