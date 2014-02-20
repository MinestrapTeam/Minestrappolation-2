package clashsoft.cslib.minecraft.update;

import java.util.*;

import clashsoft.cslib.minecraft.CSLib;
import clashsoft.cslib.minecraft.util.CSWeb;
import clashsoft.cslib.util.CSString;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

/**
 * The class CSUpdate.
 * <p>
 * This class adds several utils for updating mods.
 * 
 * @author Clashsoft
 */
public class CSUpdate
{
	/** The updates already found. */
	public static Map<String, ModUpdate>	updates					= new HashMap();
	
	/** The Constant CURRENT_VERSION. */
	public static final String				CURRENT_VERSION			= "1.7.2";
	
	/** The Constant CLASHSOFT_ADFLY. */
	public static final String				CLASHSOFT_ADFLY			= "http://adf.ly/2175784/";
	
	/** The Constant CLASHSOFT_UPDATE_NOTES. */
	public static final String				CLASHSOFT_UPDATE_NOTES	= "https://dl.dropboxusercontent.com/s/pxm1ki6wbtxlvuv/update.txt";
	
	/**
	 * Creates a Clashsoft Unique Version (e.g. v1.6.4-4)
	 * 
	 * @param rev
	 *            the rev
	 * @return the string
	 */
	public static String version(int rev)
	{
		return CURRENT_VERSION + "-" + rev;
	}
	
	public static ModUpdate readUpdateLine(String line, String modName, String acronym, String version)
	{
		int i0 = line.indexOf(':');
		int i1 = line.indexOf('=');
		int i2 = line.lastIndexOf('@');
		
		if (i0 == -1)
		{
			return null;
		}
		
		String key = line.substring(0, i0);
		
		if (modName == null)
		{
			modName = key;
		}
		
		if (key.equals(modName) || key.equals(acronym))
		{
			String newVersion = line.substring(i0 + 1, i1);
			if (version == null || !newVersion.equals(version))
			{
				String updateNotes = null;
				String updateUrl = null;
				if (i1 != -1)
				{
					updateNotes = line.substring(i1 + 1, i2 == -1 ? line.length() : i2);
				}
				if (i2 != -1)
				{
					updateUrl = line.substring(i2 + 1);
				}
				
				return new ModUpdate(modName, version, newVersion, updateNotes, updateUrl);
			}
		}
		return null;
	}
	
	public static List<ModUpdate> getUpdates(boolean invalidUpdates)
	{
		Collection<ModUpdate> collection = updates.values();
		List<ModUpdate> list = new ArrayList(collection.size());
		
		if (invalidUpdates)
		{
			list.addAll(collection);
		}
		else
		{
			for (ModUpdate update : collection)
			{
				if (update.isValid())
				{
					list.add(update);
				}
			}
		}
		
		return list;
	}
	
	public static ModUpdate getUpdate(String modName)
	{
		return updates.get(modName);
	}
	
	public static ModUpdate addUpdate(ModUpdate update)
	{
		if (update != null)
		{
			ModUpdate update1 = getUpdate(update.modName);
			if (update1 != null)
			{
				update1.combine(update);
				return update1;
			}
			else
			{
				updates.put(update.modName, update);
			}
		}
		return update;
	}
	
	public static ModUpdate getUpdate(String modName, String acronym, String version, String[] updateFile)
	{
		ModUpdate update = getUpdate(modName);
		
		if (update != null)
		{
			return update;
		}
		
		for (String line : updateFile)
		{
			update = readUpdateLine(line, modName, acronym, version);
			if (update != null)
			{
				return addUpdate(update);
			}
		}
		return null;
	}
	
	public static void updateCheck(String url)
	{
		updateCheck(CSWeb.readWebsite(url));
	}
	
	public static void updateCheck(String[] updateFile)
	{
		for (String line : updateFile)
		{
			ModUpdate update = readUpdateLine(line, null, null, null);
			addUpdate(update);
		}
	}
	
	public static void updateCheckCS(String modName, String acronym, String version)
	{
		updateCheck(modName, acronym, version, CLASHSOFT_UPDATE_NOTES);
	}
	
	public static void updateCheck(String modName, String version, String url)
	{
		updateCheck(modName, CSString.getAcronym(modName), version, url);
	}
	
	public static void updateCheck(String modName, String acronym, String version, String url)
	{
		if (CSLib.updateCheck)
		{
			new CheckUpdateThread(modName, acronym, version, url).start();
		}
	}
	
	public static void updateCheck(String modName, String acronym, String version, String[] updateLines)
	{
		if (CSLib.updateCheck)
		{
			new CheckUpdateThread(modName, acronym, version, updateLines).start();
		}
	}
	
	public static void notifyAllUpdates(EntityPlayer player)
	{
		if (player.worldObj.isRemote)
		{
			player.addChatMessage(new ChatComponentTranslation("update.found"));
			for (ModUpdate update : updates.values())
			{
				notifyUpdate(player, update);
			}
		}
	}
	
	public static void notifyUpdate(EntityPlayer player, ModUpdate update)
	{
		if (player.worldObj.isRemote && update != null && update.isValid())
		{
			player.addChatMessage(new ChatComponentTranslation("update.notification", update.modName, update.newVersion, update.version));
			
			if (!update.updateNotes.isEmpty())
			{
				player.addChatMessage(new ChatComponentTranslation("update.notes"));
				
				for (String line : update.updateNotes)
				{
					player.addChatMessage(new ChatComponentText(line));
				}
			}
			
			if (CSLib.autoUpdate)
			{
				update.install(player);
			}
			else
			{
				player.addChatMessage(new ChatComponentTranslation("update.automatic.disabled", update.modName));
			}
		}
	}
	
	public static void update(EntityPlayer player, String modName)
	{
		ModUpdate update = getUpdate(modName);
		if (update != null)
		{
			update.install(player);
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("update.none", modName));
		}
	}
	
	public static int compareVersion(String version1, String version2)
	{
		if (version1 == null)
		{
			return -1;
		}
		if (version2 == null)
		{
			return 1;
		}
		
		String s1 = version1.replace(".", "").replace("-", ".");
		String s2 = version2.replace(".", "").replace("-", ".");
		float f1 = Float.parseFloat(s1);
		float f2 = Float.parseFloat(s2);
		
		return Float.compare(f1, f2);
	}
}
