package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static NEIShapedStonecutterManager	stonecutterManager	= new NEIShapedStonecutterManager();
	public static NEIPlatingManager		platingManager		= new NEIPlatingManager();
	
	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(stonecutterManager);
		API.registerUsageHandler(stonecutterManager);
		API.registerGuiOverlay(GuiStonecutter.class, "stonecutter");
		
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
