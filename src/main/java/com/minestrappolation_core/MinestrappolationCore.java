package com.minestrappolation_core;

import clashsoft.brewingapi.BrewingAPI;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.update.reader.SimpleUpdateReader;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;

import com.minestrappolation_core.common.MCCommonProxy;
import com.minestrappolation_core.common.MCEventHandler;
import com.minestrappolation_core.common.MCVersionChecker;
import com.minestrappolation_core.lib.*;
import com.minestrappolation_core.tileentity.TileEntityStonecutter;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;

@Mod(modid = MCReference.MINESTRAP_CORE_ID, name = MCReference.MINESTRAP_CORE_NAME, version = MCReference.MINESTRAP_CORE_VERSION, dependencies = "required-after:" + BrewingAPI.MODID)
public class MinestrappolationCore
{
	@Instance(MCReference.MINESTRAP_CORE_ID)
	public static MinestrappolationCore	instance;
	
	@SidedProxy(modId = MCReference.MINESTRAP_CORE_ID, clientSide = "com.minestrappolation.core.client.MCClientProxy", serverSide = "com.minestrappolation.core.common.MCCommonProxy")
	public static MCCommonProxy			proxy;
	
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
		CSUpdate.updateCheck(new ModUpdater(MCReference.MINESTRAP_CORE_NAME, "MAPI", MCReference.MINESTRAP_VERSION, MCVersionChecker.versionURL, SimpleUpdateReader.instance));
	}
}
