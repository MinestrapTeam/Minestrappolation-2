package sobiohazardous.mods.minestrappolation.core;

import sobiohazardous.mods.minestrappolation.core.common.MCCommonProxy;
import sobiohazardous.mods.minestrappolation.core.common.MCEventHandler;
import sobiohazardous.mods.minestrappolation.core.common.MCVersionChecker;
import sobiohazardous.mods.minestrappolation.core.creativetab.MCCreativeTabStone;
import sobiohazardous.mods.minestrappolation.core.lib.*;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;
import clashsoft.brewingapi.BrewingAPI;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.update.SimpleUpdateReader;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

@Mod(modid = MCReference.MINESTRAPPOLATION_CORE_ID, name = MCReference.MINESTRAPPOLATION_CORE_NAME, version = MCReference.MINESTRAPPOLATION_CORE_VERSION, dependencies = "required-after:" + BrewingAPI.MODID)
public class MinestrappolationCore
{
	@Instance(MCReference.MINESTRAPPOLATION_CORE_ID)
	public static MinestrappolationCore	instance;
	
	@SidedProxy(modId = MCReference.MINESTRAPPOLATION_CORE_ID, clientSide = "sobiohazardous.mods.minestrappolation.core.client.MCClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.core.common.MCCommonProxy")
	public static MCCommonProxy		proxy;
	
	public static CreativeTabs		creativeTabStone	= new MCCreativeTabStone(CreativeTabs.getNextID(), "minestrap_stone");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MCConfig.initConfig(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "StoneCutter");
		
		MCBlocks.init();
		MCItems.init();
		MCRecipes.init();
		
		FMLCommonHandler.instance().bus().register(new MCEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		Blocks.bedrock.setHardness(80F);
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		CSUpdate.updateCheck(new ModUpdater(MCReference.MINESTRAPPOLATION_CORE_NAME, "MAPI", MCReference.MINESTRAPPOLATION_VERSION, MCVersionChecker.versionURL, SimpleUpdateReader.instance));
	}
}
