package minestrapteam.minestrappolation.spell.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import minestrapteam.minestrappolation.spell.ISpell;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.SpellPreset;
import clashsoft.cslib.minecraft.lang.I18n;

public class SpellVariety
{
	public static SpellVariety[]	SPELL_VARIETIES	= new SpellVariety[8];
	
	public static SpellVariety		PROJECTILE		= new SpellVariety(0, "projectile");
	public static SpellVariety		BEAM			= new SpellVariety(1, "beam");
	public static SpellVariety		SPRAY			= new SpellVariety(2, "spray");
	public static SpellVariety		VORTEX			= new SpellVariety(3, "vortex");
	public static SpellVariety		BODY_ARMOR		= new SpellVariety(4, "body_armor");
	public static SpellVariety		ABRASIVE_ARMOR	= new SpellVariety(5, "abrasive_armor");
	public static SpellVariety		MIRROR_SHIELD	= new SpellVariety(6, "mirror_shield");
	public static SpellVariety		AREA_SHIELD		= new SpellVariety(7, "area_shield");
	
	public final int				id;
	public String					name;
	
	public SpellVariety(int id, String name)
	{
		this.id = id;
		this.name = name;
		
		SPELL_VARIETIES[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spellvariety." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
	
	public static SpellVariety get(int id)
	{
		return SPELL_VARIETIES[id];
	}
	
	public List<ISpell> getSpells(PlayerSpells spells)
	{
		List<ISpell> list = new ArrayList();
		
		Iterator<? extends ISpell> iterator;
		if (spells.player.capabilities.isCreativeMode)
		{
			iterator = SpellPreset.presets.values().iterator();
		}
		else
		{
			iterator = spells.spells.iterator();
		}
		while (iterator.hasNext())
		{
			ISpell spell = iterator.next();
			if (spell.hasVariety(this))
			{
				list.add(spell);
			}
		}
		
		return list;
	}
}
