package sobiohazardous.mods.minestrappolation.core.util;

import sobiohazardous.mods.minestrappolation.core.lib.MCReference;

import net.minecraft.util.ResourceLocation;

/**
 * @author SoBiohazardous
 */
public class MCAssetManager
{
	public static ResourceLocation getMAPIResource(String name)
	{
		return new ResourceLocation(MCReference.MINESTRAPPOLATION_CORE_ID, name);
	}
	
	public static ResourceLocation getEOResource(String name)
	{
		return new ResourceLocation(MCReference.EO_MODID, name);
	}
	
	public static ResourceLocation getEDResource(String name)
	{
		return new ResourceLocation(MCReference.ED_MODID, name);
	}
	
	public static ResourceLocation getEMDResource(String name)
	{
		return new ResourceLocation(MCReference.EMD_MODID, name);
	}
	
	public static String getMAPITexture(String name)
	{
		return MCReference.MINESTRAPPOLATION_CORE_ID + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MCReference.EO_MODID + ":" + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MCReference.ED_MODID + ":" + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MCReference.EMD_MODID + ":" + name;
	}
	
	public static String getEDTextureSC(String name)
	{
		return MCReference.ED_MODID + ":stoneCutter/" + name;
	}
	
	public static String getEOTextureSC(String name)
	{
		return MCReference.EO_MODID + ":stoneCutter/" + name;
	}
}
