package clashsoft.cslib.minecraft.update;

import java.io.File;

import clashsoft.cslib.minecraft.util.CSWeb;
import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

/**
 * The class InstallUpdateThread.
 * 
 * @author Clashsoft
 */
public class InstallUpdateThread extends Thread
{
	/** The mod update to install. */
	private ModUpdate		update;
	
	/** The player used for chat message notifications. */
	private EntityPlayer	player;
	
	public InstallUpdateThread(ModUpdate update, EntityPlayer player)
	{
		this.update = update;
		this.player = player;
	}
	
	@Override
	public void run()
	{
		if (this.update.isValid() && this.update.hasDownload())
		{
			this.update.installStatus = 1;
			
			String modName = this.update.getModName();
			String newVersion = this.update.getNewVersion();
			String mod = this.update.getName();
			
			this.player.addChatMessage(new ChatComponentTranslation("update.install", modName, newVersion));
			
			File dataDir;
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				dataDir = Minecraft.getMinecraft().mcDataDir;
			}
			else
			{
				dataDir = new File(MinecraftServer.getServer().getFolderName());
			}
			
			File modsDir = new File(dataDir, "mods");
			
			try
			{
				File output = new File(modsDir, this.update.getDownloadedFileName());
				
				if (output.exists())
				{
					this.player.addChatMessage(new ChatComponentTranslation("update.install.skipping", mod));
					this.update.installStatus = 2;
					return;
				}
				
				for (File f : modsDir.listFiles())
				{
					String fileName = f.getName();
					if (fileName.startsWith(modName))
					{
						this.player.addChatMessage(new ChatComponentTranslation("update.install.oldversion", modName, fileName));
						f.delete();
					}
				}
				
				CSWeb.download(this.update.getUpdateURL(), output);
				
				this.player.addChatMessage(new ChatComponentTranslation("update.install.success", mod));
				this.update.installStatus = 2;
			}
			catch (Exception ex)
			{
				CSLog.error(ex);
				this.player.addChatMessage(new ChatComponentTranslation("update.install.failure", mod, ex.getMessage()));
				this.update.installStatus = -1;
			}
		}
	}
}
