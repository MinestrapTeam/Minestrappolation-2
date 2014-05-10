package sobiohazardous.mods.minestrappolation.extraenviroments;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEBlocks;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEConfig;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEItems;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EERecipes;
import sobiohazardous.mods.minestrappolation.extraenviroments.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid = MReference.EE_MODID, name = MReference.EE_MODNAME, version = MReference.EE_VERSION)
public class ExtraEnviroments
{
	@Instance(MReference.EE_MODID)
	public ExtraEnviroments		instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extraenviroments.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extraenviroments.proxy.ClientProxy")
	public static CommonProxy	proxy;
	
	public static BiomeGenBase	redwood;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// init libs
		EEConfig.initilize(event);
		EEBlocks.loadBlocks();
		EEBlocks.registerBlocks();
		EERecipes.loadRecipes();
		EEItems.loadItems();
		EEItems.loadItemNames();
		
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		try
		{
			EERecipes.loadBridgeRecipes();
		}
		catch (Exception e)
		{
			System.err.println("Could not load bridge recipes.");
			e.printStackTrace();
		}
	}
}
