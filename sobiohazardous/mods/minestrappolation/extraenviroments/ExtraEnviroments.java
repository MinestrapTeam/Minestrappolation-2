package sobiohazardous.mods.minestrappolation.extraenviroments;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEBlocks;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEConfig;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEItems;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EERecipes;
import sobiohazardous.mods.minestrappolation.extraenviroments.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid = MReference.MODID_EE, name = MReference.MODNAME_EE, version = MReference.VERSION_EE)
public class ExtraEnviroments
{
	@Instance(MReference.MODID_EE)
	public ExtraEnviroments		instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extraenviroments.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extraenviroments.proxy.ClientProxy")
	public static CommonProxy	proxy;
	
	public static BiomeGenBase	redwood;
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent evt)
	{
		// init libs
		EEConfig.initilize(evt);
		EEBlocks.loadBlocks();
		EEBlocks.registerBlocks();
		EERecipes.loadRecipes();
		EEItems.loadItems();
		EEItems.loadItemNames();
		
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
		// TODO Find alternative!
		// GameRegistry.addBiome(redwood);
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
			EERecipes.loadBridgeRecipes();
		}
		catch (Exception e)
		{
			System.err.println("Could not load bridge recipes.");
			e.printStackTrace();
		}
	}
}
