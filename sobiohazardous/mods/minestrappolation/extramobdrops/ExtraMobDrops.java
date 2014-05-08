package sobiohazardous.mods.minestrappolation.extramobdrops;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extramobdrops.common.CommonProxy;
import sobiohazardous.mods.minestrappolation.extramobdrops.common.EMDEventHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDFuelHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDConfig;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDPotions;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDRecipes;
import clashsoft.brewingapi.BrewingAPI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.MinecraftForge;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MReference.MODID_EMD, name = MReference.MODNAME_EMD, version = MReference.VERSION_EMD, dependencies = "required-after:Minestrappolation")
public class ExtraMobDrops
{
	@Instance(MReference.MODID_EMD)
	public static ExtraMobDrops				instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extramobdrops.client.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extramobdrops.common.CommonProxy")
	public static CommonProxy				proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Lib init
		EMDConfig.initConfig(event);
		EMDItems.loadItems();
		EMDRecipes.loadRecipes();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		EntityRegistry.registerGlobalEntityID(EntityHangGlider.class, "hangGlider", EntityRegistry.findGlobalUniqueEntityId());
		
		proxy.registerRenderThings();
		
		GameRegistry.registerFuelHandler(new EMDFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());
		
		BrewingAPI.registerEffectHandler(new EMDPotions());
		EMDPotions.loadPotions();
		EMDPotions.loadBrewingRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{	
		try
		{
			EMDRecipes.loadBridgeRecipes();
			EMDItems.loadBridgedItems();
		}
		catch (Exception ex)
		{
			System.err.println("ExtraMobDrops: Could not load bridge recipes/items. Heres why: ");
			ex.printStackTrace();
		}
	}
}
