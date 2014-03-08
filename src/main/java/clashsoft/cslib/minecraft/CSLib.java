package clashsoft.cslib.minecraft;

import clashsoft.cslib.minecraft.common.CSLProxy;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.cslib.minecraft.util.Convenience;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = CSLib.MODID, name = CSLib.NAME, version = CSLib.VERSION)
public class CSLib
{
	public static final String	MODID		= "cslib";
	public static final String	NAME		= "Clashsoft Lib";
	public static final String	ACRONYM		= MODID;
	public static final int		REVISION	= 0;
	public static final String	VERSION		= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance(MODID)
	public static CSLib			instance;
	
	@SidedProxy(clientSide = "clashsoft.cslib.minecraft.client.CSLClientProxy", serverSide = "clashsoft.cslib.minecraft.common.CSLProxy")
	public static CSLProxy		proxy;
	
	public static boolean		updateCheck	= true;
	public static boolean		autoUpdate	= true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		CSConfig.loadConfig(event.getSuggestedConfigurationFile(), NAME);
		
		autoUpdate = CSConfig.getBool("updates", "Auto Updates", "Disables automatic updates", true);
		updateCheck = CSConfig.getBool("updates", "Update Check", "Disables update checks for ALL mods", true);
		
		CSConfig.saveConfig();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		CSUpdate.updateCheck(CSUpdate.CLASHSOFT_UPDATE_NOTES);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void chatMessageSent(ServerChatEvent event)
	{
		String message = event.message;
		
		if (message.startsWith(">updates"))
		{
			proxy.displayUpdatesGUI();
			event.setCanceled(true);
		}
		else if (message.startsWith(">update "))
		{
			String modName = message.substring(8);
			CSUpdate.update(event.player, modName);
			event.setCanceled(true);
		}
		else if (message.startsWith(">restart"))
		{
			Convenience.shutdown();
		}
	}
	
	@SubscribeEvent
	public void playerJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			CSUpdate.notifyAllUpdates((EntityPlayer) event.entity);
		}
	}
}
