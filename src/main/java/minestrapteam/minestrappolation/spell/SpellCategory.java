package minestrapteam.minestrappolation.spell;

import clashsoft.cslib.minecraft.lang.I18n;

public enum SpellCategory
{
	ATTACK("spellcategory.attack"),
	DEFENSE("spellcategory.defense"),
	ALTERATION("spellcategory.alteration"),
	SUMMONING("spellcategory.summoning");
	
	protected String name;
	
	private SpellCategory(String name)
	{
		this.name = name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.name);
	}
}
