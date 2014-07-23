package minestrapteam.mcore.lib;

import java.util.Arrays;
import java.util.List;

import clashsoft.brewingapi.BrewingAPI;

public class MCReference
{
	public static final String			CORE_MODID		= "mcore";
	public static final String			CORE_ACRONYM	= "MC";
	public static final String			CORE_NAME		= "Minestrappolation Core";
	public static final String			CORE_VERSION	= "3.1.1";
	public static final String			CORE_DEPENDENCY	= "required-after:" + BrewingAPI.MODID;
	
	public static final String			MODID			= "minestrappolation";
	public static final String			ACRONYM			= "M";
	public static final String			NAME			= "Minestrappolation";
	public static final String			VERSION			= "3.1.1";
	public static final String			DEPENDENCY		= "required-after:" + CORE_MODID;
	
	public static final List<String>	AUTHORS			= Arrays.asList("SoBiohazardous", "Clashsoft", "Delocuro", "Thewerty1124", "Triplg3");
}
