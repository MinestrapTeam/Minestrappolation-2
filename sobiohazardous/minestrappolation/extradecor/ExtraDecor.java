package sobiohazardous.minestrappolation.extradecor;

import sobiohazardous.minestrappolation.extradecor.block.*;
import sobiohazardous.minestrappolation.extradecor.gen.EDOreGenerator;
import sobiohazardous.minestrappolation.extradecor.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extradecor.handler.EDGuiHandler;
import sobiohazardous.minestrappolation.extradecor.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDConfig;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDRecipeManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDTileEntityManager;
import sobiohazardous.minestrappolation.extradecor.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extradecorChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extradecorChanS"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraDecor", name="Extrappolated Decor", version="B1.2", dependencies = "required-after:Minestrappolation")
public class ExtraDecor 
{
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extradecor.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extradecor.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	@Instance("ExtraDecor")
	public static ExtraDecor instance;
		
	public static int paneRenderId = RenderingRegistry.getNextAvailableRenderId();
	public static int ropeRenderId = RenderingRegistry.getNextAvailableRenderId();
		
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		EDConfig.initilize(event);		
	}	
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
				
		NetworkRegistry.instance().registerGuiHandler(this, new EDGuiHandler());
		
		EDTileEntityManager.registerTileEntitys();
		
		MinecraftForge.setToolClass(Item.shears, "shears", 0);
		//Load Libs
		
		EDItemManager.addItems();
		EDItemManager.addItemNames();
		EDItemManager.setHarvestLevels();
		EDBlockManager.createBlocks();
	    EDBlockManager.registerBlocks();
	    EDBlockManager.addNames();
		EDRecipeManager.loadAllRecipes();
		EDOreRegistry.oreRegistration();
		EDOreRegistry.addOreRecipes();
		
		GameRegistry.registerWorldGenerator(new EDOreGenerator());	
	}

	@Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent evt)
	{
		EDItemManager.addItemsToItemList();
		
		try 
		{
			EDBlockManager.loadBridgedBlocks();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
