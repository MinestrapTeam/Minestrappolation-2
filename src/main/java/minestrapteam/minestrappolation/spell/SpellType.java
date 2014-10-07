package minestrapteam.minestrappolation.spell;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.util.EnumChatFormatting;

public class SpellType
{
	public static final SpellType[]	SPELL_TYPES	= new SpellType[8];
	
	public static final SpellType	WATER		= new SpellType(0, "water", 0x347A9D, EnumChatFormatting.DARK_AQUA);
	public static final SpellType	FIRE		= new SpellType(1, "fire", 0x9D6834, EnumChatFormatting.GOLD);
	public static final SpellType	EARTH		= new SpellType(2, "earth", 0x699D34, EnumChatFormatting.GREEN);
	public static final SpellType	WIND		= new SpellType(3, "wind", 0x819898, EnumChatFormatting.GRAY);
	public static final SpellType	FROST		= new SpellType(4, "frost", 0x69B6B6, EnumChatFormatting.AQUA);
	public static final SpellType	ELECTRICITY	= new SpellType(5, "electricity", 0xDCB643, EnumChatFormatting.YELLOW);
	public static final SpellType	LIFE		= new SpellType(6, "life", 0xC13030, EnumChatFormatting.RED);
	public static final SpellType	ARCANE		= new SpellType(7, "arcane", 0x4848C2, EnumChatFormatting.DARK_PURPLE);
	
	public int						id;
	public String					name;
	public int						color;
	public EnumChatFormatting		chatColor;
	
	public SpellType(int id, String name, int color, EnumChatFormatting chatColor)
	{
		this.id = id;
		this.name = name;
		this.color = color;
		this.chatColor = chatColor;
		
		SPELL_TYPES[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spelltype." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName() + ".name");
	}
	
	public List<Spell> getSpells(PlayerSpells spells)
	{
		List<Spell> list = new ArrayList();
		
		Iterator<Spell> iterator;
		if (spells.player.capabilities.isCreativeMode)
		{
			iterator = Spell.spellRegistry.iterator();
		}
		else
		{
			iterator = spells.spells.iterator();
		}
		while (iterator.hasNext())
		{
			Spell spell = iterator.next();
			if (spell.type == this)
			{
				list.add(spell);
			}
		}
		
		return list;
	}
	
	public static SpellType get(int id)
	{
		return SPELL_TYPES[id];
	}
}
