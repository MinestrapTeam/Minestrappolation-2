package sobiohazardous.mods.minestrappolation.extramobdrops;

import java.util.EnumSet;

import clashsoft.brewingapi.BrewingAPI;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extramobdrops.bridge.EMDBridgeRecipes;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDFuelHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDConfig;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDPotionManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDRecipeManager;
import sobiohazardous.mods.minestrappolation.extramobdrops.packet.EMDPacketHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.packet.EMDPacketPipeline;
import sobiohazardous.mods.minestrappolation.extramobdrops.proxy.CommonProxy;

/**
 * @author SoBiohazardous
 */
@Mod ( modid = MReference.MODID_EMD, name=MReference.MODNAME_EMD, version=MReference.VERSION_EMD, dependencies = "required-after:Minestrappolation")
public class ExtraMobDrops 
{
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy")
    public static CommonProxy proxy;
	@Instance("ExtraMobDrops")
	public static ExtraMobDrops instance;
	public static final EMDPacketPipeline packets = new EMDPacketPipeline();
	
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
		EntityRegistry.registerGlobalEntityID(EntityHangGlider.class, "hangGlider", EntityRegistry.findGlobalUniqueEntityId());

		proxy.registerRenderThings();		
		packets.initialise();
				
		GameRegistry.registerFuelHandler(new EMDFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());	
		
		
		BrewingAPI.registerEffectHandler(new EMDPotionManager());
		EMDPotionManager.loadPotions();
		EMDPotionManager.loadBrewingRecipes();
	}

	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent e)
	{
		packets.postInitialise();
		packets.registerPacket(EMDPacketHangGlider.class);

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
