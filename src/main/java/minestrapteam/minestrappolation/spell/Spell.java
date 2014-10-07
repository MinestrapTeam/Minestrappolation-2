package minestrapteam.minestrappolation.spell;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.util.CSRegistry;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Spell
{
	public static CSRegistry	spellRegistry	= new CSRegistry();
	
	public static final Spell	test			= new Spell("test").setIconName("minecraft:diamond");
	
	static
	{
		registerSpell(test, "test");
	}
	
	public String				name;
	public String				iconName;
	
	protected IIcon				icon;
	
	public Spell(String name)
	{
		this.name = name;
	}
	
	public static void registerSpell(Spell spell, String name)
	{
		int id = spellRegistry.getFreeID();
		spellRegistry.addObject(id, name, spell);
	}
	
	public static Spell getSpellByName(String name)
	{
		return (Spell) spellRegistry.getObject(name);
	}
	
	public static Spell getSpellByID(int id)
	{
		return (Spell) spellRegistry.getObjectById(id);
	}
	
	public Spell setIconName(String name)
	{
		this.iconName = name;
		return this;
	}
	
	public String getUnlocalizedName()
	{
		return "spell." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName() + ".name");
	}
	
	public void registerIcons(IIconRegister register)
	{
		this.icon = register.registerIcon(this.iconName);
	}
	
	public IIcon getIcon()
	{
		return this.icon;
	}
}
