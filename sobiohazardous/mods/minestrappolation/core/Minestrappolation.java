package sobiohazardous.mods.minestrappolation.core;

import sobiohazardous.mods.minestrappolation.core.creativetabs.MCreativeTabStone;
import sobiohazardous.mods.minestrappolation.core.lib.*;
import sobiohazardous.mods.minestrappolation.core.proxy.CommonProxy;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;
import clashsoft.brewingapi.BrewingAPI;
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

@Mod(modid = MReference.MODID_MAPI, name = MReference.MODNAME_MAPI, version = MReference.VERSION_MAPI, dependencies = "required-after:" + BrewingAPI.MODID)
public class Minestrappolation
{
	@Instance(MReference.MODID_MAPI)
	public static Minestrappolation	instance;
	private MGuiHandler				guiHandler			= new MGuiHandler();
	
	@SidedProxy(modId = MReference.MODID_MAPI, clientSide = "sobiohazardous.mods.minestrappolation.core.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.core.proxy.CommonProxy")
	public static CommonProxy		proxy;
	
	public static CreativeTabs		creativeTabStone	= new MCreativeTabStone(CreativeTabs.getNextID(), "Minestrappolation - Stone");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MConfig.initConfig(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "tileEntityStoneCutter");
		
		MBlocks.loadBlocks();
		MItems.loadItems();
		MRecipes.loadRecipes();
		
		FMLCommonHandler.instance().bus().register(new MEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new MGuiHandler());
		Blocks.bedrock.setHardness(80F);
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postLoad(FMLPostInitializationEvent evt)
	{
	}
}
