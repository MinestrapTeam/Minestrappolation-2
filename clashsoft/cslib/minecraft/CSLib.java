package clashsoft.cslib.minecraft;

import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = "ClashsoftAPI", name = "Clashsoft Lib", version = CSLib.VERSION)
public class CSLib
{
	public static final int		REVISION	= 8;
	public static final String	VERSION		= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance("ClashsoftAPI")
	public static CSLib			instance;
	
	public static boolean		updateCheck	= true;
	public static boolean		autoUpdate	= true;
	
	static
	{
		CSLog.logger.setParent(FMLLog.getLogger());
	}
	
	private void test()
	{
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		test();
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		autoUpdate = config.get("Updates", "Auto Updates", true, "Disables automatic updates").getBoolean(true);
		updateCheck = config.get("Updates", "Update Check", true, "Disables update checks for ALL mods").getBoolean(true);
		
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		//Hidden.hidden();
	}
	
	@ForgeSubscribe
	public void playerJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			CSUpdate.doClashsoftUpdateCheck((EntityPlayer) event.entity, "Clashsoft API", "csapi", CSLib.VERSION);
		}
	}
	
	@ForgeSubscribe
	public void chatMessageSent(ServerChatEvent event)
	{
		String message = event.message;
		
		if (message.startsWith(">Update "))
		{
			String modName = message.substring(message.indexOf(' ') + 1);
			CSUpdate.update(event.player, modName);
			event.setCanceled(true);
		}
		if (message.startsWith(">Restart"))
		{
			try
			{
				Minecraft.getMinecraft().statFileWriter.readStat(StatList.leaveGameStat, 1);
				Minecraft.getMinecraft().theWorld.sendQuittingDisconnectingPacket();
				Minecraft.getMinecraft().loadWorld((WorldClient) null);
				
				Minecraft.getMinecraft().shutdown();
			}
			catch (Exception ex)
			{
			}
		}
	}
}
