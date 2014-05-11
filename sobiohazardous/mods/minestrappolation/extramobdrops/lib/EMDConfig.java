package sobiohazardous.mods.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class EMDConfig
{
	public static void init(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		
		config.save();
	}
}
