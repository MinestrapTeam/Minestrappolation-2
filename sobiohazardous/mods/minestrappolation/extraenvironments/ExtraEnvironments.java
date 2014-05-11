package sobiohazardous.mods.minestrappolation.extraenvironments;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraenvironments.biome.BiomeGenRedwood;
import sobiohazardous.mods.minestrappolation.extraenvironments.common.EECommonProxy;
import sobiohazardous.mods.minestrappolation.extraenvironments.lib.EEBlocks;
import sobiohazardous.mods.minestrappolation.extraenvironments.lib.EEConfig;
import sobiohazardous.mods.minestrappolation.extraenvironments.lib.EEItems;
import sobiohazardous.mods.minestrappolation.extraenvironments.lib.EERecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid = MReference.EE_MODID, name = MReference.EE_NAME, version = MReference.EE_VERSION)
public class ExtraEnvironments
{
	@Instance(MReference.EE_MODID)
	public ExtraEnvironments		instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extraenvironments.client.EEClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extraenvironments.client.EEClientProxy")
	public static EECommonProxy	proxy;
	
	public static BiomeGenBase	redwood;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// init libs
		EEConfig.init(event);
		EEBlocks.init();
		EEItems.init();
		EEBlocks.load();
		EEItems.load();
		EERecipes.loadRecipes();
		
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
