package sobiohazardous.mods.minestrappolation.extramobdrops;

import clashsoft.brewingapi.BrewingAPI;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDFuelHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDConfig;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDPotions;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDRecipes;
import sobiohazardous.mods.minestrappolation.extramobdrops.packet.EMDPacketHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.packet.EMDPacketPipeline;
import sobiohazardous.mods.minestrappolation.extramobdrops.proxy.CommonProxy;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MReference.MODID_EMD, name = MReference.MODNAME_EMD, version = MReference.VERSION_EMD, dependencies = "required-after:Minestrappolation")
public class ExtraMobDrops
{
	@Instance(MReference.MODID_EMD)
	public static ExtraMobDrops				instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extramobdrops.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extramobdrops.proxy.CommonProxy")
	public static CommonProxy				proxy;
	
	public static final EMDPacketPipeline	packets	= new EMDPacketPipeline();
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent e)
	{
		// Lib init
		EMDConfig.initConfig(e);
		EMDItems.loadItems();
		EMDRecipes.loadRecipes();
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e)
	{
		EntityRegistry.registerGlobalEntityID(EntityHangGlider.class, "hangGlider", EntityRegistry.findGlobalUniqueEntityId());
		
		proxy.registerRenderThings();
		packets.initialise();
		
		GameRegistry.registerFuelHandler(new EMDFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());
		
		BrewingAPI.registerEffectHandler(new EMDPotions());
		EMDPotions.loadPotions();
		EMDPotions.loadBrewingRecipes();
	}
	
	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent e)
	{
		packets.postInitialise();
		packets.registerPacket(EMDPacketHangGlider.class);
		
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
