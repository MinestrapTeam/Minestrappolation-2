package clashsoft.cslib.minecraft.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import clashsoft.cslib.util.CSLogger;

public class Log4JLogger extends CSLogger
{
	public static org.apache.logging.log4j.Logger	logger	= LogManager.getLogger();
	
	public static Level convertLevel(java.util.logging.Level level)
	{
		if (level == java.util.logging.Level.OFF)
		{
			return Level.OFF;
		}
		if (level == java.util.logging.Level.SEVERE)
		{
			return Level.FATAL;
		}
		if (level == java.util.logging.Level.WARNING)
		{
			return Level.WARN;
		}
		if (level == java.util.logging.Level.INFO || level == java.util.logging.Level.CONFIG)
		{
			return Level.INFO;
		}
		if (level == java.util.logging.Level.FINE)
		{
			return Level.DEBUG;
		}
		if (level == java.util.logging.Level.FINER || level == java.util.logging.Level.FINEST)
		{
			return Level.TRACE;
		}
		if (level == java.util.logging.Level.ALL)
		{
			return Level.ALL;
		}
		int i = level.intValue() / 100;
		Level[] values = Level.values();
		return i < values.length ? values[i] : Level.INFO;
	}
	
	@Override
	public void log(java.util.logging.Level level, String msg)
	{
		logger.log(convertLevel(level), msg);
	}
	
	@Override
	public void log(java.util.logging.Level level, Throwable error)
	{
		logger.throwing(convertLevel(level), error);
	}
}
