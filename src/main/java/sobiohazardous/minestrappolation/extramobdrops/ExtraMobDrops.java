package sobiohazardous.minestrappolation.extramobdrops;

import java.util.EnumSet;

import clashsoft.brewingapi.BrewingAPI;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.extramobdrops.bridge.EMDBridgeRecipes;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDFuelHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDPlayerTickHandler;
import sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDConfig;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDPotionManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDRecipeManager;

/**
 * @author SoBiohazardous
 */
@Mod ( modid = MAPIReference.MODID_EMD, name=MAPIReference.MODNAME_EMD, version=MAPIReference.VERSION_EMD, dependencies = "required-after:Minestrappolation")
public class ExtraMobDrops 
{
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy")
    public static CommonProxy proxy;
	@Instance("ExtraMobDrops")
	public static ExtraMobDrops instance;
		
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent e)
	{
		//Lib init
		EMDConfig.initConfig(e);
		EMDItemManager.loadItems();		
		EMDRecipeManager.loadRecipes();			
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e)
	{
		proxy.registerRenderThings();
		GameRegistry.registerFuelHandler(new EMDFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());	
		FMLCommonHandler.instance().bus().register(new EMDPlayerTickHandler());
				
		BrewingAPI.registerEffectHandler(new EMDPotionManager());
		EMDPotionManager.loadPotions();
		EMDPotionManager.loadBrewingRecipes();
		
		
	}

	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent e)
	{
		try
		{
			EMDRecipeManager.loadBridgeRecipes();
			EMDItemManager.loadBridgedItems();
		}
		catch(Exception ex)
		{
			System.err.println("ExtraMobDrops: Could not load bridge recipes/items. Heres why: ");
			ex.printStackTrace();
		}		
	}
}
