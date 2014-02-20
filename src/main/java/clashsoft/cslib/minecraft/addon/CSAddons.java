package clashsoft.cslib.minecraft.addon;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clashsoft.cslib.util.CSLog;
import clashsoft.cslib.util.CSSource;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * The class CSAddons.
 * <p>
 * Loads and stores loaded {@link Addon}.
 * 
 * @author Clashsoft
 */
public class CSAddons
{
	protected static Map<String, List<Class<?>>>	classes				= new HashMap();
	
	protected static Multimap<String, String>		preLoadedAddons		= HashMultimap.create();
	protected static Multimap<String, String>		loadedAddons		= HashMultimap.create();
	protected static Multimap<String, String>		postLoadedAddons	= HashMultimap.create();
	
	public static void loadAddons(String modName, String modPackage)
	{
		loadAddons(modName, modPackage, AddonLoad.class, loadedAddons);
	}
	
	public static void preLoadAddons(String modName, String modPackage)
	{
		loadAddons(modName, modPackage, AddonPreload.class, preLoadedAddons);
	}
	
	public static void postLoadAddons(String modName, String modPackage)
	{
		loadAddons(modName, modPackage, AddonPostload.class, postLoadedAddons);
	}
	
	public static boolean isAddonLoaded(String modName, String addonName)
	{
		return isAddonLoaded(modName, addonName, loadedAddons);
	}
	
	public static boolean isAddonPreloaded(String modName, String addonName)
	{
		return isAddonLoaded(modName, addonName, preLoadedAddons);
	}
	
	public static boolean isAddonPostloaded(String modName, String addonName)
	{
		return isAddonLoaded(modName, addonName, postLoadedAddons);
	}
	
	protected static void loadAddons(String modName, String modPackage, Class loadAnnotation, Multimap<String, String> map)
	{
		List<Class<?>> classes = getClassesForPackage(modPackage);
		
		for (Class c : classes)
		{
			Addon addon = (Addon) c.getAnnotation(Addon.class);
			if (addon != null)
			{
				String addonModName = addon.modName();
				String addonName = addon.addonName();
				
				if (modName.equals(addonModName) && !isAddonLoaded(modName, addonName, map))
				{
					map.put(modName, addonName);
					
					for (Method method : c.getDeclaredMethods())
					{
						if (method.isAnnotationPresent(loadAnnotation))
						{
							try
							{
								method.invoke(null, new Object[0]);
							}
							catch (Exception ex)
							{
								CSLog.error(ex);
							}
						}
					}
				}
			}
		}
	}
	
	public static List<Class<?>> getClassesForPackage(String packageName)
	{
		List<Class<?>> result = classes.get(packageName);
		if (result == null)
		{
			result = CSSource.getClassesForPackage(Package.getPackage(packageName));
			classes.put(packageName, result);
		}
		return result;
	}
	
	protected static boolean isAddonLoaded(String modName, String addonName, Multimap<String, String> map)
	{
		return map.get(modName).contains(addonName);
	}
}
