package sobiohazardous.minestrappolation.api;

import clashsoft.brewingapi.BrewingAPI;
import sobiohazardous.minestrappolation.api.creativetabs.CreativeTabMAPI;
import sobiohazardous.minestrappolation.api.creativetabs.CreativeTabStonecutterBlocks;
import sobiohazardous.minestrappolation.api.lib.MAPIBlocks;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.lib.MAPIRecipes;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MAPIReference.MODID_MAPI, name = MAPIReference.MODNAME_MAPI, version = MAPIReference.VERSION_MAPI, dependencies = "required-after:" + BrewingAPI.MODID)
public class Minestrappolation
{	
	@Instance(MAPIReference.MODID_MAPI)
	public static Minestrappolation	instance;
	private MGuiHandler guiHandler = new MGuiHandler();
	
	@SidedProxy(modId = MAPIReference.MODID_MAPI, clientSide = "sobiohazardous.minestrappolation.api.ClientProxy", serverSide = "sobiohazardous.minestrappolation.api.CommonProxy")
	public static CommonProxy	proxy;		
		
	public static CreativeTabMAPI creativeTabMAPI;
	public static CreativeTabStonecutterBlocks creativeTabStonecutterBlocks;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MAPIConfig.initConfig(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{		
		creativeTabMAPI = new CreativeTabMAPI(CreativeTabs.getNextID(), "MAPI");
		creativeTabStonecutterBlocks = new CreativeTabStonecutterBlocks(CreativeTabs.getNextID(), "Stonecutter Blocks");

		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "tileEntityStoneCutter");
		
		MAPIBlocks.loadBlocks();
		MAPIRecipes.loadRecipes();

		FMLCommonHandler.instance().bus().register(new MAPIEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new MGuiHandler());
		Blocks.bedrock.setHardness(80F);

		proxy.registerRenderers();	
	}
	
	@EventHandler
	public void postLoad(FMLPostInitializationEvent evt)
	{
	}
}
