package sobiohazardous.mods.minestrappolation.extraenviroments;

import net.minecraft.world.biome.BiomeGenBase;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEBlockManager;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEConfig;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EEItemManager;
import sobiohazardous.mods.minestrappolation.extraenviroments.lib.EERecipeManager;
import sobiohazardous.mods.minestrappolation.extraenviroments.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=MReference.MODID_EE, name=MReference.MODNAME_EE, version=MReference.VERSION_EE)
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
