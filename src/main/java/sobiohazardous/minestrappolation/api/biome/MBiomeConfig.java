package sobiohazardous.minestrappolation.api.biome;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class MBiomeConfig {
	
	public void initilize(FMLPreInitializationEvent event){
	 	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	 	config.load();
	 	
	 	
	 	config.save();
	}

}
