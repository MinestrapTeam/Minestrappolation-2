package sobiohazardous.minestrappolation.extraenviroments;

import sobiohazardous.minestrappolation.extraenviroments.lib.EEBlockManager;
import sobiohazardous.minestrappolation.extraenviroments.lib.EEConfig;
import sobiohazardous.minestrappolation.extraenviroments.lib.EEItemManager;
import sobiohazardous.minestrappolation.extraenviroments.lib.EERecipeManager;
import sobiohazardous.minestrappolation.extraenviroments.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid="ExtraEnviroments", name="Extra Enviroments", version="B1.0")
public class ExtraEnviroments 
{
	@Instance("ExtraEnviroments")
	public ExtraEnviroments instance;
	
	@SidedProxy(clientSide="sobiohazardous.minestrappolation.extraenviroments.proxy.ClientProxy", serverSide="sobiohazardous.minestrappolation.extraenviroments.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent evt)
	{
		//init libs
		EEConfig.initilize(evt);
		EEBlockManager.loadBlocks();
		EEBlockManager.registerBlocks();
		EERecipeManager.loadRecipes();
		EEItemManager.loadItems();
		EEItemManager.loadItemNames();
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent evt)
	{
		proxy.registerRenderThings();
	}
	
	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent evt)
	{
		try
		{
			EERecipeManager.loadBridgeRecipes();
		}catch(Exception e)
		{
			System.err.println("Could not load bridge recipes.");
			e.printStackTrace();
		}
		
	}
}
