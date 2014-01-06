package sobiohazardous.minestrappolation.api.lib;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MAPIConfig 
{
	public static boolean			multiPotions			= false;
	public static boolean			advancedPotionInfo		= false;
	public static boolean			animatedPotionLiquid	= true;
	public static boolean			showAllBaseBrewings		= false;
	public static boolean			defaultAwkwardBrewing	= false;
	public static int				potionStackSize			= 1;
	
	public static int				brewingStand2ID		= 11;
	public static int				splashPotion2ID		= EntityRegistry.findGlobalUniqueEntityId();
	
	public static boolean showDur = true;
	
	public static int stoneCutterId;

	public static void initConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		brewingStand2ID = config.get("TileEntityIDs", "BrewingStand2TEID", 11).getInt();		
		multiPotions = config.get("Potions", "MultiPotions", false, "If true, potions with 2 different effects are shown in the creative inventory.").getBoolean(false);
		advancedPotionInfo = config.get("Potions", "AdvancedPotionInfo", true).getBoolean(true);
		animatedPotionLiquid = config.get("Potions", "AnimatedPotionLiquid", true).getBoolean(true);
		showAllBaseBrewings = config.get("Potions", "ShowAllBaseBrewings", false, "If true, all base potions are shown in creative inventory.").getBoolean(false);
		defaultAwkwardBrewing = config.get("Potions", "DefaultAwkwardBrewing", false, "If true, all potions can be brewed with an awkward potion.").getBoolean(false);
		potionStackSize = config.get("Potions", "PotionStackSize", 1).getInt();
		showDur = config.get("Misc", "Show Durability", true).getBoolean(true);
		
		stoneCutterId = config.getBlock("Stone Cutter", 1000).getInt();
		
		config.save();
	}
}
