package sobiohazardous.minestrappolation.api;

import clashsoft.brewingapi.BrewingAPI;
import sobiohazardous.minestrappolation.api.lib.MAPIBlocks;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = MAPIReference.MODID_MAPI, name = MAPIReference.MODNAME_MAPI, version = MAPIReference.VERSION_MAPI, dependencies = "required-after:" + BrewingAPI.MODID)
public class Minestrappolation
{	
	@Instance("Minestrappolation")
	public static Minestrappolation	instance;
	private MGuiHandler guiHandler = new MGuiHandler();
	
	@SidedProxy(modId = "Minestrappolation", clientSide = "sobiohazardous.minestrappolation.api.ClientProxy", serverSide = "sobiohazardous.minestrappolation.api.CommonProxy")
	public static CommonProxy	proxy;		
		
	public static MAPICreativeTab creativeTab;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		MAPIConfig.initConfig(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{		
		creativeTab = new MAPICreativeTab(CreativeTabs.getNextID(), "mapi");
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "tileEntityStoneCutter");
		
		MAPIBlocks.loadBlocks();

		FMLCommonHandler.instance().bus().register(new MAPIEventHandler());
		
		Block.getBlockFromName("bedrock").setHardness(80F);

		//NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
		//NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		proxy.registerRenderers();	
	}
}