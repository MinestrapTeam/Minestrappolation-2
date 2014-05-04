package sobiohazardous.mods.minestrappolation.extraores.lib;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EOConfig
{
	public static boolean shouldOresEffect = true;
	public static int daysUntilTarnish;

	public static void initilize(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		daysUntilTarnish = config.get("Misc", "Days until copper tarnish", 3).getInt();	
		shouldOresEffect = config.get("Misc", "should Plutonium/Uranium ores effect player", true).getBoolean(true);		
		
		config.save();
	}

}
