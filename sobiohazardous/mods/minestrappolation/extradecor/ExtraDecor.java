package sobiohazardous.mods.minestrappolation.extradecor;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extradecor.block.EDOreRegistry;
import sobiohazardous.mods.minestrappolation.extradecor.bridge.EDBridgeRecipes;
import sobiohazardous.mods.minestrappolation.extradecor.common.EDCommonProxy;
import sobiohazardous.mods.minestrappolation.extradecor.gen.EDOreGenerator;
import sobiohazardous.mods.minestrappolation.extradecor.handler.EDPriestTradeHandler;
import sobiohazardous.mods.minestrappolation.extradecor.lib.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MReference.MODID_ED, name = MReference.MODNAME_ED, version = MReference.VERSION_ED, dependencies = "required-after:Minestrappolation")
public class ExtraDecor
{
	@Instance(MReference.MODID_ED)
	public static ExtraDecor	instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extradecor.client.EDClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extradecor.common.EDCommonProxy")
	public static EDCommonProxy	proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// load libs
		EDConfig.initilize(event);
		EDBlocks.createBlocks();
		EDBlocks.registerBlocks();
		EDItems.addItems();
		EDRecipes.loadAllRecipes();
		EDOreRegistry.addOreRecipes();
		EDRecipes.removeRecipes();
		EDItems.setHarvestLevels();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		EDOreRegistry.oreRegistration();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		EDTileEntityManager.registerTileEntitys();
		GameRegistry.registerWorldGenerator(new EDOreGenerator(), 0);
		VillagerRegistry.instance().registerVillageTradeHandler(2, new EDPriestTradeHandler());
		EDBlocks.loadVanillaOverwrites();
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		try
		{
			EDBlocks.loadBridgedBlocks();
			EDBridgeRecipes.loadBridgeRecipes();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
