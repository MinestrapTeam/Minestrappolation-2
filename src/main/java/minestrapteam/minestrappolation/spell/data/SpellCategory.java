package minestrapteam.minestrappolation.spell.data;

import clashsoft.cslib.minecraft.lang.I18n;

public class SpellCategory
{
	public static SpellCategory[]	SPELL_CATEGORIES	= new SpellCategory[4];
	
	public static SpellCategory		ATTACK				= new SpellCategory(0, "attack");
	public static SpellCategory		DEFENSE				= new SpellCategory(1, "defense");
	public static SpellCategory		ALTERATION			= new SpellCategory(2, "alteration");
	public static SpellCategory		SUMMONING			= new SpellCategory(3, "summoning");
	
	public final int				id;
	public String					name;
	
	private SpellCategory(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String getUnlocalizedName()
	{
		return "spellcategory." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
	
	public static SpellCategory get(int id)
	{
		return SPELL_CATEGORIES[id];
	}
}
