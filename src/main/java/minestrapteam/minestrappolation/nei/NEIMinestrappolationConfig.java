package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static NEIStonecutterManager stonecutterManager = new NEIStonecutterManager();
	
	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(stonecutterManager);
		API.registerUsageHandler(stonecutterManager);
		API.registerGuiOverlay(GuiStonecutter.class, "stonecutter");
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
