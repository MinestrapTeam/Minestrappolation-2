package sobiohazardous.mods.minestrappolation.lib;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MConfig
{
	public static boolean	shouldOresEffect	= true;
	public static int		daysUntilTarnish;
	public static int		daysUntilMossy;
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		daysUntilTarnish = config.get("Misc", "Days until copper tarnish", 3).getInt();
		shouldOresEffect = config.get("Misc", "should Plutonium/Uranium ores effect player", true).getBoolean(true);
		daysUntilMossy = config.get("Misc", "Days Until Planks Get Mossy", 3).getInt();
		
		config.save();
	}
}
