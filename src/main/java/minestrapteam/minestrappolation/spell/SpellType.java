package minestrapteam.minestrappolation.spell;

public class SpellType
{
	public static final SpellType[]	SPELL_TYPES	= new SpellType[8];
	
	public static final SpellType	WATER		= new SpellType(0, "water", 0xFFFFFF);
	public static final SpellType	FIRE		= new SpellType(1, "fire", 0xFFFFFF);
	public static final SpellType	EARTH		= new SpellType(2, "earth", 0xFFFFFF);
	public static final SpellType	WIND		= new SpellType(3, "wind", 0xFFFFFF);
	public static final SpellType	FROST		= new SpellType(4, "frost", 0xFFFFFF);
	public static final SpellType	ELECTRICITY	= new SpellType(5, "electricity", 0xFFFFFF);
	public static final SpellType	LIFE		= new SpellType(6, "life", 0xFFFFFF);
	public static final SpellType	ARCANE		= new SpellType(7, "arcane", 0xFFFFFF);
	
	public int						id;
	public String					name;
	public int						color;
	
	public SpellType(int id, String name, int color)
	{
		this.id = id;
		this.name = name;
		this.color = color;
		
		SPELL_TYPES[id] = this;
	}
	
	public static SpellType get(int id)
	{
		return SPELL_TYPES[id];
	}
}
