package clashsoft.cslib.util;

/**
 * The Class CSUtil. This class adds several util methods.
 */
public class CSUtil
{
	/**
	 * Logs an object.
	 * 
	 * @Deprecated Use {@link CSLog#info(Object)}
	 * @param o
	 *            the object to log
	 */
	@Deprecated
	public static void log(Object o)
	{
		CSLog.info(o);
	}
	
	/**
	 * Returns set color average of an array of colors.
	 * 
	 * @param colors
	 *            the color array
	 * @return the color
	 */
	public static int combineColors(int... colors)
	{
		int r = 0;
		int g = 0;
		int b = 0;
		
		for (int i : colors)
		{
			r += (i >> 16) & 255;
			g += (i >> 8) & 255;
			b += (i >> 0) & 255;
		}
		r /= colors.length;
		g /= colors.length;
		b /= colors.length;
		
		return ((r & 255) << 16) | ((g & 255) << 8) | ((b & 255) << 0);
	}
	
	/**
	 * Creates the color code for a color.
	 * 
	 * @param light
	 *            the light
	 * @param r
	 *            the r
	 * @param g
	 *            the g
	 * @param b
	 *            the b
	 * @return the color code
	 */
	public static String fontColor(int light, int r, int g, int b)
	{
		return "\u00a7" + Integer.toHexString(fontColorInt(light, r, g, b));
	}
	
	/**
	 * Creates the color code integer for a color.
	 * 
	 * @param light
	 *            the light
	 * @param r
	 *            the r
	 * @param g
	 *            the g
	 * @param b
	 *            the b
	 * @return the color code integer
	 */
	public static int fontColorInt(int light, int r, int g, int b)
	{
		int i = b > 0 ? 1 : 0;
		if (g > 0)
			i |= 2;
		if (r > 0)
			i |= 4;
		if (light > 0)
			i |= 8;
		return i;
	}
	
	/**
	 * Converts a color name to a color code.
	 * 
	 * @param fontColor
	 *            the font color
	 * @return the color code
	 */
	public static String fontColor(EnumFontColor fontColor)
	{
		return fontColor(fontColor.getLight(), fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue());
	}
	
	/**
	 * Converts a color name to a color code integer.
	 * 
	 * @param fontColor
	 *            the font color
	 * @return the color code integer
	 */
	public static int fontColorInt(EnumFontColor fontColor)
	{
		return fontColorInt(fontColor.getLight(), fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue());
	}
	
	public static String getAppdataDirectory()
	{
		String OS = System.getProperty("os.name").toUpperCase();
		if (OS.contains("WIN"))
		{
			return System.getenv("APPDATA");
		}
		else if (OS.contains("MAC"))
		{
			return System.getProperty("user.home") + "/Library/Application Support";
		}
		else if (OS.contains("NUX"))
		{
			return System.getProperty("user.home");
		}
		return System.getProperty("user.dir");
	}
}
