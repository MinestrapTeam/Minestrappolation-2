package sobiohazardous.minestrappolation.extradecor;

import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.extradecor.block.*;
import sobiohazardous.minestrappolation.extradecor.bridge.EDBridgeRecipes;
import sobiohazardous.minestrappolation.extradecor.gen.EDOreGenerator;
import sobiohazardous.minestrappolation.extradecor.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extradecor.handler.EDGuiHandler;
import sobiohazardous.minestrappolation.extradecor.handler.EDPriestTradeHandler;
import sobiohazardous.minestrappolation.extradecor.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDConfig;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDRecipeManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDTileEntityManager;
import sobiohazardous.minestrappolation.extradecor.proxy.CommonProxy;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */
@Mod ( modid = MAPIReference.MODID_ED, name=MAPIReference.MODNAME_ED, version=MAPIReference.VERSION_ED, dependencies = "required-after:Minestrappolation")
public class ExtraDecor 
{
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extradecor.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extradecor.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	@Instance("ExtraDecor")
	public static ExtraDecor instance;
		
	public static int paneRenderId = RenderingRegistry.getNextAvailableRenderId();
	public static int ropeRenderId = RenderingRegistry.getNextAvailableRenderId();
	public static int stairsRenderId = RenderingRegistry.getNextAvailableRenderId();
		
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		//load libs
		EDConfig.initilize(event);			
		EDBlockManager.createBlocks();
	    EDBlockManager.registerBlocks();
	    EDBlockManager.addNames();
	    EDItemManager.addItems();
		EDItemManager.addItemNames();
		EDRecipeManager.loadAllRecipes();
		EDOreRegistry.addOreRecipes();
		EDRecipeManager.removeRecipes();
		EDItemManager.setHarvestLevels();	
	}	
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		EDOreRegistry.oreRegistration();
		//TODO find alternative
		//NetworkRegistry.instance().registerGuiHandler(this, new EDGuiHandler());	
		EDTileEntityManager.registerTileEntitys();		
		//TODO Find alternative
		//MinecraftForge.setToolClass(Items.shears, "shears", 0);
		GameRegistry.registerWorldGenerator(new EDOreGenerator(), 0);
		VillagerRegistry.instance().registerVillageTradeHandler(2, new EDPriestTradeHandler());
		EDBlockManager.loadVanillaOverwrites();
		proxy.registerRenderThings();	
	}

	@Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent evt)
	{
		EDItemManager.addItemsToItemList();
		
		try 
		{
			EDBlockManager.loadBridgedBlocks();
			EDBridgeRecipes.loadBridgeRecipes();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	
}
