package clashsoft.cslib.minecraft.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.commons.io.Charsets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

/**
 * The Class CSResourceHelper.
 * <p>
 * This class is a factory for {@link ResourceLocation}s
 * 
 * @author Clashsoft
 */
public class CSResourceHelper
{
	/** The resources. */
	public static Map<String, ResourceLocation>	resources		= new HashMap<String, ResourceLocation>();
	
	/** The icons. */
	public static Map<String, IIcon>			icons			= new HashMap<String, IIcon>();
	
	public static IIconRegister					iconRegister	= null;
	
	/**
	 * Returns a resource, may already be stored.
	 * 
	 * @param resource
	 *            the resource
	 * @return the resource
	 */
	public static ResourceLocation getResource(String resource)
	{
		ResourceLocation rl;
		if (!resources.containsKey(resource))
		{
			rl = new ResourceLocation(resource);
			resources.put(resource, rl);
		}
		else
		{
			rl = resources.get(resource);
		}
		return rl;
	}
	
	public static ResourceLocation getResource(String domain, String resource)
	{
		if (domain != null && !domain.isEmpty())
		{
			resource = domain + ":" + resource;
		}
		return getResource(resource);
	}
	
	/**
	 * Returns a new icon with the given icon name, if no stored icon is found a
	 * new one is registered and stored using the given icon register.
	 * 
	 * @param iconRegister
	 *            the icon register
	 * @param iconName
	 *            the icon name
	 * @return the icon
	 */
	public static IIcon getIcon(IIconRegister iconRegister, String iconName)
	{
		CSResourceHelper.iconRegister = iconRegister;
		
		IIcon ic;
		if (!icons.containsKey(iconName))
		{
			ic = iconRegister.registerIcon(iconName);
			icons.put(iconName, ic);
		}
		else
		{
			ic = icons.get(iconName);
		}
		return ic;
	}
	
	/**
	 * Returns a new icon with the given icon name, if no stored icon is found a
	 * new one is registered and stored using the stored icon register.
	 * <p>
	 * <b>Warning!</b>
	 * <p>
	 * If you call this method before an icon register is stored, it will cause
	 * a crash! Make sure to use
	 * {@link CSResourceHelper#getIcon(IconRegister, String)} at least once!
	 * 
	 * @param iconName
	 *            the icon name
	 * @return the icon
	 */
	public static IIcon getIcon(String iconName)
	{
		return getIcon(iconRegister, iconName);
	}
	
	public static List<String> readAllLines(ResourceLocation rl)
	{
		BufferedReader bufferedreader = null;
		try
		{
			bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream(), Charsets.UTF_8));
			ArrayList arraylist = new ArrayList();
			String s;
			
			while ((s = bufferedreader.readLine()) != null)
			{
				arraylist.add(s);
			}
			
			return arraylist;
			
		}
		catch (IOException ioexception)
		{
		}
		finally
		{
			if (bufferedreader != null)
			{
				try
				{
					bufferedreader.close();
				}
				catch (IOException ioexception)
				{
				}
			}
		}
		return Collections.EMPTY_LIST;
	}
}
