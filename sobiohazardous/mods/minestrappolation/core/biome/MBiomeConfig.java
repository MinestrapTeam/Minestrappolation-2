package sobiohazardous.mods.minestrappolation.core.biome;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MBiomeConfig 
{	
	public void initilize(FMLPreInitializationEvent event)
	{
	 	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	 	config.load();
	 	
	 	
	 	config.save();
	}

}
