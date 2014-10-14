package minestrapteam.minestrappolation.spell.data;

import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.util.EnumChatFormatting;

public class SpellType
{
	public static SpellType[]		spellTypes	= new SpellType[8];
	
	public static final SpellType	WATER		= new SpellType(0, "water", 0x608FEE, EnumChatFormatting.DARK_AQUA);
	public static final SpellType	FIRE		= new SpellType(1, "fire", 0xFEAF11, EnumChatFormatting.GOLD);
	public static final SpellType	EARTH		= new SpellType(2, "earth", 0x72A73C, EnumChatFormatting.GREEN);
	public static final SpellType	WIND		= new SpellType(3, "wind", 0x828F8F, EnumChatFormatting.GRAY);
	public static final SpellType	FROST		= new SpellType(4, "frost", 0x4FA4A4, EnumChatFormatting.AQUA);
	public static final SpellType	ELECTRICITY	= new SpellType(5, "electricity", 0xE1E134, EnumChatFormatting.YELLOW);
	public static final SpellType	LIFE		= new SpellType(6, "life", 0xEF6060, EnumChatFormatting.RED);
	public static final SpellType	ARCANE		= new SpellType(7, "arcane", 0xB765E1, EnumChatFormatting.DARK_PURPLE);
	
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
		
		spellTypes[id] = this;
	}
	
	public String getUnlocalizedName()
	{
		return "spelltype." + this.name;
	}
	
	public String getDisplayName()
	{
		return I18n.getString(this.getUnlocalizedName() + ".name");
	}
	
	public static SpellType get(int id)
	{
		return spellTypes[id];
	}
	
	public static SpellType random(Random random)
	{
		return get(random.nextInt(spellTypes.length));
	}
}
