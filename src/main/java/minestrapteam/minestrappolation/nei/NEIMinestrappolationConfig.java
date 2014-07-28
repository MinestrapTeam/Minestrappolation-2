package minestrapteam.minestrappolation.nei;

import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(new NEIStonecutterRecipeManager());
		API.registerUsageHandler(new NEIStonecutterRecipeManager());
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
