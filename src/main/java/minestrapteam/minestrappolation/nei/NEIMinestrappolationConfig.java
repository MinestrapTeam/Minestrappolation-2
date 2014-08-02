package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import minestrapteam.minestrappolation.client.gui.GuiMelter;
import minestrapteam.minestrappolation.client.gui.GuiSawmill;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.nei.handler.*;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static ShapedStonecuttingHandler		shapedStonecuttingManager		= new ShapedStonecuttingHandler();
	public static ShapelessStonecuttingHandler	shapelessStonecuttingManager	= new ShapelessStonecuttingHandler();
	public static ShapedSawingHandler			shapedSawingManager				= new ShapedSawingHandler();
	public static ShapelessSawingHandler		shapelessSawingManager			= new ShapelessSawingHandler();
	public static MelterRecipeHandler			melterManager					= new MelterRecipeHandler();
	public static MelterFuelHandler				melterFuelManager				= new MelterFuelHandler();
	public static PlatingRecipeHandler			platingManager					= new PlatingRecipeHandler();
	
	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(shapedStonecuttingManager);
		API.registerUsageHandler(shapedStonecuttingManager);
		API.registerRecipeHandler(shapelessStonecuttingManager);
		API.registerUsageHandler(shapelessStonecuttingManager);
		API.registerRecipeHandler(shapedSawingManager);
		API.registerUsageHandler(shapedSawingManager);
		API.registerRecipeHandler(shapelessSawingManager);
		API.registerUsageHandler(shapelessSawingManager);
		API.registerRecipeHandler(melterManager);
		API.registerUsageHandler(melterManager);
		API.registerRecipeHandler(melterFuelManager);
		API.registerUsageHandler(melterFuelManager);
		
		API.registerGuiOverlay(GuiStonecutter.class, "stonecutter");
		API.registerGuiOverlay(GuiSawmill.class, "sawmill");
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
