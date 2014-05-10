package clashsoft.cslib.minecraft.lang;

import net.minecraft.util.StatCollector;

public class I18n
{
	public static String getString(String key)
	{
		return StatCollector.translateToLocal(key);
	}
	
	public static String getString(String key, Object... params)
	{
		return getStringParams(key, params);
	}
	
	public static String getStringParams(String key, Object... params)
	{
		return StatCollector.translateToLocalFormatted(key, params);
	}
}
