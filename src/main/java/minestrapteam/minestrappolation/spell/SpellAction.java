package minestrapteam.minestrappolation.spell;

import clashsoft.cslib.minecraft.lang.I18n;

public enum SpellAction
{
	ATTACK("spellaction.attack"),
	DEFENSE("spellaction.defense"),
	SPECIAL("spellaction.special");
	
	protected String name;
	
	private SpellAction(String name)
	{
		this.name = name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.name);
	}
}
