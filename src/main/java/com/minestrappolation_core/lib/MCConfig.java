package com.minestrappolation_core.lib;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MCConfig
{
	public static boolean	showDur	= true;
	
	public static void initConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		showDur = config.get("Misc", "Show Durability", true).getBoolean(true);
		
		config.save();
	}
}
