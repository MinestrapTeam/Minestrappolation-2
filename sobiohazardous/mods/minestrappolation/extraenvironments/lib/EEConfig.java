package sobiohazardous.mods.minestrappolation.extraenvironments.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class EEConfig
{
	public static void initilize(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		config.save();
	}
}
