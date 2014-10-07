package minestrapteam.minestrappolation.spell;

public class SpellType
{
	public static final SpellType[]	SPELL_TYPES	= new SpellType[8];
	
	public static final SpellType	WATER		= new SpellType(0, "water", 0x347A9D);
	public static final SpellType	FIRE		= new SpellType(1, "fire", 0x9D6834);
	public static final SpellType	EARTH		= new SpellType(2, "earth", 0x699D34);
	public static final SpellType	WIND		= new SpellType(3, "wind", 0x819898);
	public static final SpellType	FROST		= new SpellType(4, "frost", 0x69B6B6);
	public static final SpellType	ELECTRICITY	= new SpellType(5, "electricity", 0xDCB643);
	public static final SpellType	LIFE		= new SpellType(6, "life", 0xC13030);
	public static final SpellType	ARCANE		= new SpellType(7, "arcane", 0x4848C2);
	
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
