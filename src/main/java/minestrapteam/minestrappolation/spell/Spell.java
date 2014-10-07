package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.minecraft.util.CSRegistry;
import clashsoft.cslib.util.CSString;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class Spell
{
	public static CSRegistry	spellRegistry	= new CSRegistry();
	
	public static final Spell	test			= new Spell(SpellType.ARCANE, "test").setIconName("minecraft:diamond");
	
	static
	{
		registerSpell(test, "test");
	}
	
	public SpellType			type;
	
	public String				name;
	public String				iconName;
	
	protected IIcon				icon;
	
	public Spell(SpellType type, String name)
	{
		this.type = type;
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
	
	public int getDisplayColor()
	{
		return this.type.color;
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.common;
	}
	
	public List<String> getTooltip(int level)
	{
		List<String> list = new ArrayList();
		StringBuilder buf = new StringBuilder(20);
		
		buf.append(this.getRarity().rarityColor).append(this.getDisplayName());
		if (level > 0)
		{
			buf.append(' ').append(CSString.convertToRoman(level + 1));
		}
		
		list.add(buf.toString());
		buf.delete(0, buf.length());
		
		buf.append(this.type.chatColor).append(EnumChatFormatting.ITALIC).append(this.type.getDisplayName());
		buf.append(' ').append(I18n.getString("spell.spell"));
		
		list.add(buf.toString());
		this.addInformation(list, level);
		
		return list;
	}
	
	public void addInformation(List<String> list, int level)
	{
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
