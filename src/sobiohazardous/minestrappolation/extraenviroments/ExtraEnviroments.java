package sobiohazardous.minestrappolation.extraenviroments;

import net.minecraft.world.biome.BiomeGenBase;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
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
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=MAPIReference.MODID_EE, name=MAPIReference.MODNAME_EE, version=MAPIReference.VERSION_EE)
public class ExtraEnviroments 
{
	@Instance("ExtraEnviroments")
	public ExtraEnviroments instance;
	
	@SidedProxy(clientSide="sobiohazardous.minestrappolation.extraenviroments.proxy.ClientProxy", serverSide="sobiohazardous.minestrappolation.extraenviroments.proxy.ClientProxy")
	public static CommonProxy proxy;

	public static BiomeGenBase redwood;
	
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
		
		redwood = new BiomeGenRedwood(115).setBiomeName("redwood");
		//TODO Find alternative!
		//GameRegistry.addBiome(redwood);
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
