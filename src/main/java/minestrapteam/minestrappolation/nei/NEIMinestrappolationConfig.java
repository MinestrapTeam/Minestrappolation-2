package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import minestrapteam.minestrappolation.client.gui.GuiMelter;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.nei.handler.*;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static ShapeStonecuttingHandler		shapedStonecutterManager	= new ShapeStonecuttingHandler();
	public static ShapelessStonecuttingHandler	shapelessStonecutterManager	= new ShapelessStonecuttingHandler();
	public static MelterRecipeHandler			melterManager				= new MelterRecipeHandler();
	public static MelterFuelHandler				melterFuelManager			= new MelterFuelHandler();
	public static PlatingRecipeHandler			platingManager				= new PlatingRecipeHandler();
	
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
