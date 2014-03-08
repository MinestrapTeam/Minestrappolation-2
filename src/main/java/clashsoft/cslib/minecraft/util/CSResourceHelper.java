package clashsoft.cslib.minecraft.util;

import java.util.HashMap;
import java.util.Map;

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
			rl = resources.get(resource);
		return rl;
	}
	
	/**
	 * Returns a new icon with the given icon name, if no stored icon is found a new one is
	 * registered and stored using the given icon register.
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
	 * Returns a new icon with the given icon name, if no stored icon is found a new one is
	 * registered and stored using the stored icon register.
	 * <p>
	 * <b>Warning!</b>
	 * <p>
	 * If you call this method before an icon register is stored, it will cause a crash! Make sure
	 * to use {@link CSResourceHelper#getIcon(IconRegister, String)} at least once!
	 * 
	 * @param iconName
	 *            the icon name
	 * @return the icon
	 */
	public static IIcon getIcon(String iconName)
	{
		return getIcon(iconRegister, iconName);
	}
}
