package sobiohazardous.mods.minestrappolation.extradecor.lib;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EDConfig
{
	public static int	daysUntilMossy;
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		daysUntilMossy = config.get("Misc", "Days Until Planks Get Mossy", 3).getInt();
		
		config.save();
	}
	
}
