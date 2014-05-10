package sobiohazardous.mods.minestrappolation.core.util;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;

import net.minecraft.util.ResourceLocation;

/**
 * @author SoBiohazardous
 */
public class MAssetManager
{
	public static ResourceLocation getMAPIResource(String name)
	{
		return new ResourceLocation(MReference.MAPI_MODID, name);
	}
	
	public static ResourceLocation getEOResource(String name)
	{
		return new ResourceLocation(MReference.EO_MODID, name);
	}
	
	public static ResourceLocation getEDResource(String name)
	{
		return new ResourceLocation(MReference.ED_MODID, name);
	}
	
	public static ResourceLocation getEMDResource(String name)
	{
		return new ResourceLocation(MReference.EMD_MODID, name);
	}
	
	public static String getMAPITexture(String name)
	{
		return MReference.MAPI_MODID + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MReference.EO_MODID + ":" + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MReference.ED_MODID + ":" + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MReference.EMD_MODID + ":" + name;
	}
	
	public static String getEDTextureSC(String name)
	{
		return MReference.ED_MODID + ":stoneCutter/" + name;
	}
	
	public static String getEOTextureSC(String name)
	{
		return MReference.EO_MODID + ":stoneCutter/" + name;
	}
}
