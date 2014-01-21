package clashsoft.cslib.minecraft.util;

import net.minecraft.client.Minecraft;

/**
 * The class CSString
 * <p>
 * Extension for {@link clashsoft.cslib.util.CSString} adding String utils only usable with Minecraft.
 * 
 * @author Clashsoft
 */
public class CSString extends clashsoft.cslib.util.CSString
{
	/**
	 * Trims a string to the given render width.
	 * <p>
	 * If the renderer string length is longer than the maximum render width
	 * given, the last chars will be replaced with "...".
	 * 
	 * @param string
	 *            the string
	 * @param maxRenderWidth
	 *            the max render width
	 * @return the string
	 */
	public static String trimStringToRenderWidth(String string, int maxRenderWidth)
	{
		Minecraft mc = Minecraft.getMinecraft();
		int i = mc.fontRenderer.getStringWidth("...");
		boolean flag = false;
		while (string.length() > 0 && mc.fontRenderer.getStringWidth(string) + i > maxRenderWidth - 6)
		{
			string = string.substring(0, string.length() - 1);
			flag = true;
		}
		if (flag)
			string += "...";
		
		return string;
	}
}
