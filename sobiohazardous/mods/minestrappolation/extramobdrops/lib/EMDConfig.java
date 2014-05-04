package sobiohazardous.mods.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

public class EMDConfig 
{
	public static void initConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();

		config.save();
	}
}
