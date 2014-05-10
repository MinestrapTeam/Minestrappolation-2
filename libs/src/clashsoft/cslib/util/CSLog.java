package clashsoft.cslib.util;

import java.util.logging.Level;

public class CSLog
{
	public static CSLogger logger = new CSLogger();
	
	public static void print(String string)
	{
		logger.log(Level.INFO, string);
	}
	
	public static void info(String string)
	{
		logger.log(Level.INFO, string);
	}
	
	public static void warning(String string)
	{
		logger.log(Level.WARNING, string);
	}
	
	public static void error(String string)
	{
		logger.log(Level.SEVERE, string);
	}
	
	public static void print(Object object)
	{
		print(String.valueOf(object));
	}
	
	public static void info(Object object)
	{
		info(String.valueOf(object));
	}
	
	public static void warning(Object object)
	{
		warning(String.valueOf(object));
	}
	
	public static void error(Object object)
	{
		error(String.valueOf(object));
	}
	
	public static void error(Throwable throwable)
	{
		logger.log(Level.SEVERE, throwable);
	}
	
	public static void print(String format, Object... args)
	{
		print(String.format(format, args));
	}
	
	public static void info(String format, Object... args)
	{
		info(String.format(format, args));
	}
	
	public static void warning(String format, Object... args)
	{
		warning(String.format(format, args));
	}
	
	public static void error(String format, Object... args)
	{
		error(String.format(format, args));
	}
}
