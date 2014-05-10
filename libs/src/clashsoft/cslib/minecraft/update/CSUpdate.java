package clashsoft.cslib.minecraft.update;

import java.util.*;

import clashsoft.cslib.minecraft.CSLib;
import clashsoft.cslib.minecraft.update.updater.IUpdater;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;
import clashsoft.cslib.minecraft.update.updater.URLUpdater;

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
	public static Map<String, Update>	updates					= new HashMap();
	
	public static Map<String, IUpdater> updaters = new HashMap();
	
	/** The Constant CURRENT_VERSION. Value: {@value} */
	public static final String				CURRENT_VERSION			= "1.7.2";
	
	/** The Constant CLASHSOFT_ADFLY. Value: {@value} */
	public static final String				CLASHSOFT_ADFLY			= "http://adf.ly/2175784/";
	
	/** The Constant CLASHSOFT_UPDATE_NOTES. Value: {@value} */
	public static final String				CLASHSOFT_UPDATE_NOTES	= "https://dl.dropboxusercontent.com/s/pxm1ki6wbtxlvuv/update.txt";
	
	/**
	 * Creates a version String for Clashsoft mods.
	 * 
	 * @param rev
	 *            the rev
	 * @return the string
	 */
	public static String version(int rev)
	{
		return CURRENT_VERSION + "-" + rev;
	}
	
	public static String version(int major, int minor, int rev)
	{
		return String.format("%s_%d.%d.%d", CURRENT_VERSION, major, minor, rev);
	}
	
	public static String version(String version)
	{
		return String.format("%s_%s", CURRENT_VERSION, version);
	}
	
	public static List<Update> getUpdates(boolean invalidUpdates)
	{
		Collection<Update> collection = updates.values();
		List<Update> list = new ArrayList(collection.size());
		
		if (invalidUpdates)
		{
			list.addAll(collection);
		}
		else
		{
			for (Update update : collection)
			{
				if (update.isValid())
				{
					list.add(update);
				}
			}
		}
		
		return list;
	}
	
	public static Update addUpdate(Update update)
	{
		if (update != null)
		{
			updates.put(update.getModName(), update);
		}
		return update;
	}
	
	public static Update getUpdate(String modName)
	{
		return updates.get(modName);
	}
	
	public static IUpdater getUpdater(String modName)
	{
		return updaters.get(modName);
	}
	
	public static void updateCheck(String url)
	{
		updateCheck(new URLUpdater(url));
	}
	
	public static void updateCheck(String[] updateFile)
	{
		URLUpdater updater = new URLUpdater(null);
		updater.setUpdateFile(updateFile);
		updateCheck(updater);
	}
	
	public static void updateCheck(String modName, String acronym, String version, String url)
	{
		updateCheck(new ModUpdater(modName, acronym, version, url));
	}
	
	public static void updateCheck(String modName, String acronym, String version, String[] updateFile)
	{
		ModUpdater updater = new ModUpdater(modName, acronym, version, null);
		updater.setUpdateFile(updateFile);
		updateCheck(updater);
	}
	
	public static void updateCheck(IUpdater updater)
	{
		updaters.put(updater.getName(), updater);
		new CheckUpdateThread(updater).start();
	}
	
	public static void notifyAll(EntityPlayer player)
	{
		List<Update> updates = getUpdates(false);
		if (!updates.isEmpty())
		{
			player.addChatMessage(new ChatComponentTranslation("update.found"));
			for (Update update : updates)
			{
				notify(player, update);
			}
		}
	}
	
	public static void notify(EntityPlayer player, Update update)
	{
		if (update != null && update.isValid())
		{
			player.addChatMessage(new ChatComponentTranslation("update.notification", update.getModName(), update.getNewVersion(), update.getVersion()));
			
			if (update.getUpdateNotes().size() > 0)
			{
				player.addChatMessage(new ChatComponentTranslation("update.notes"));
				
				for (String line : update.getUpdateNotes())
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
				player.addChatMessage(new ChatComponentTranslation("update.automatic.disabled", update.getModName()));
			}
		}
	}
	
	public static void update(EntityPlayer player, String modName)
	{
		Update update = getUpdate(modName);
		if (update != null)
		{
			update.install(player);
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("update.none", modName));
		}
	}
	
	public static void updateAll(EntityPlayer player)
	{
		if (!updates.isEmpty())
		{
			for (Update update : updates.values())
			{
				update.install(player);
			}
		}
	}
	
	public static int compareVersion(String version1, String version2)
	{
		if (version1 == null)
		{
			return version2 == null ? 0 : -1;
		}
		else if (version2 == null)
		{
			return 1;
		}
		else if (version1.equals(version2))
		{
			return 0;
		}
		
		String[] split1 = version1.split("\\p{Punct}");
		String[] split2 = version2.split("\\p{Punct}");
		
		int len = Math.max(split1.length, split2.length);
		int[] ints1 = new int[len];
		int[] ints2 = new int[len];
		
		for (int i = 0; i < split1.length; i++)
		{
			ints1[i] = versionNumber(split1[i]);
		}
		for (int i = 0; i < split2.length; i++)
		{
			ints2[i] = versionNumber(split2[i]);
		}
		
		for (int i = len - 1; i >= 0; i--)
		{
			int compare = Integer.compare(ints1[i], ints2[i]);
			if (compare != 0)
			{
				return compare;
			}
		}
		
		return 0;
	}
	
	protected static int versionNumber(String s)
	{
		try
		{
			return Integer.parseInt(s);
		}
		catch (NumberFormatException ex)
		{
			if ("dev".equalsIgnoreCase(s))
			{
				return -4;
			}
			else if ("pre".equalsIgnoreCase(s))
			{
				return -3;
			}
			else if ("alpha".equalsIgnoreCase(s))
			{
				return -2;
			}
			else if ("beta".equalsIgnoreCase(s))
			{
				return -1;
			}
		}
		return 0;
	}
}
