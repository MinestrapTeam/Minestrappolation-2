package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import minestrapteam.minestrappolation.client.gui.GuiMelter;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static NEIShapedStonecutterManager		shapedStonecutterManager	= new NEIShapedStonecutterManager();
	public static NEIShapelessStonecutterManager	shapelessStonecutterManager	= new NEIShapelessStonecutterManager();
	public static NEIMelterManager					melterManager				= new NEIMelterManager();
	public static NEIMelterFuelManager				melterFuelManager			= new NEIMelterFuelManager();
	public static NEIPlatingManager					platingManager				= new NEIPlatingManager();
	
	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(shapedStonecutterManager);
		API.registerUsageHandler(shapedStonecutterManager);
		API.registerRecipeHandler(shapelessStonecutterManager);
		API.registerUsageHandler(shapelessStonecutterManager);
		API.registerRecipeHandler(melterManager);
		API.registerUsageHandler(melterManager);
		API.registerRecipeHandler(melterFuelManager);
		API.registerUsageHandler(melterFuelManager);
		
		API.registerGuiOverlay(GuiStonecutter.class, "stonecutter");
		API.registerGuiOverlay(GuiMelter.class, "melting");
		
		API.registerRecipeHandler(platingManager);
		API.registerUsageHandler(platingManager);
	}
	
	@Override
	public String getName()
	{
		return MReference.NAME;
	}
	
	@Override
	public String getVersion()
	{
		return MReference.VERSION;
	}
}
