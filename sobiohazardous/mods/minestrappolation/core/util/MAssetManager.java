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
		return new ResourceLocation(MReference.MODID_MAPI, name);
	}
	
	public static String getMAPITexture(String name)
	{
		return MReference.MODID_MAPI + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MReference.MODID_EO + ":" + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MReference.MODID_ED + ":" + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MReference.MODID_EMD + ":" + name;
	}
	
	public static String getEDStonecutterTexture(String name)
	{
		return MReference.MODID_ED + ":" + "stoneCutter/" + name;
	}
	
	public static String getEOStonecutterTexture(String name)
	{
		return MReference.MODID_EO + ":" + "stoneCutter/" + name;
	}
}
