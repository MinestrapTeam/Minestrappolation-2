package clashsoft.cslib.util;

/**
 * The Enum EnumFontColor.
 */
public enum EnumFontColor
{
	/** The black. */
	BLACK(0, 0, 0, 0),
	/** The blue. */
	BLUE(0, 0, 0, 1),
	/** The green. */
	GREEN(0, 0, 1, 0),
	/** The cyan. */
	CYAN(0, 0, 1, 1),
	/** The red. */
	RED(0, 1, 0, 0),
	/** The purple. */
	PURPLE(0, 1, 0, 1),
	/** The orange. */
	ORANGE(0, 1, 1, 0),
	/** The lightgray. */
	LIGHTGRAY(0, 1, 1, 1),
	/** The darkgray. */
	DARKGRAY(1, 0, 0, 0),
	/** The lightblue. */
	LIGHTBLUE(1, 0, 0, 1),
	/** The lightgreen. */
	LIGHTGREEN(1, 0, 1, 0),
	/** The lightcyan. */
	LIGHTCYAN(1, 0, 1, 1),
	/** The lightred. */
	LIGHTRED(1, 1, 0, 0),
	/** The pink. */
	PINK(1, 1, 0, 1),
	/** The yellow. */
	YELLOW(1, 1, 1, 0),
	/** The white. */
	WHITE(1, 1, 1, 1);
	
	/** The light. */
	private int	light;
	
	/** The red. */
	private int	red;
	
	/** The green. */
	private int	green;
	
	/** The blue. */
	private int	blue;
	
	/**
	 * Instantiates a new enum font color.
	 * 
	 * @param l
	 *            the l
	 * @param r
	 *            the r
	 * @param g
	 *            the g
	 * @param b
	 *            the b
	 */
	private EnumFontColor(int l, int r, int g, int b)
	{
		this.light = l;
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	/**
	 * Gets the light.
	 * 
	 * @return the light
	 */
	public int getLight()
	{
		return this.light;
	}
	
	/**
	 * Gets the red.
	 * 
	 * @return the red
	 */
	public int getRed()
	{
		return this.red;
	}
	
	/**
	 * Gets the green.
	 * 
	 * @return the green
	 */
	public int getGreen()
	{
		return this.green;
	}
	
	/**
	 * Gets the blue.
	 * 
	 * @return the blue
	 */
	public int getBlue()
	{
		return this.blue;
	}
}