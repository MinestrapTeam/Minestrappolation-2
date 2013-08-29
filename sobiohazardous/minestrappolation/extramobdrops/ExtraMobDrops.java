package sobiohazardous.minestrappolation.extramobdrops;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.extramobdrops.bridge.EMDBridgeRecipes;
import sobiohazardous.minestrappolation.extramobdrops.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDPotionEffectManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDRecipeManager;

/**
 * 
 * 
 * 
 * @author Crzyguitardude
 */
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extroresChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraMobDrops", name="Extrappolated Mob Drops", version="B1.0", dependencies = "required-after:Minestrappolation")
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
		EMDItemManager.loadNames();
		EMDPotionEffectManager.loadPotions();
		EMDRecipeManager.loadRecipes();			
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e)
	{
		proxy.registerRenderThings();
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());
	}

	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent e)
	{
		try
		{
			EMDBridgeRecipes.loadBridgeRecipes();
		}
		catch(Exception ex)
		{
			System.err.println("ExtraMobDrops: Could not load bridge recipes. Heres why: ");
			ex.printStackTrace();
		}
		
	}
}
