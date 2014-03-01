package sobiohazardous.minestrappolation.api.util;

import sobiohazardous.minestrappolation.api.lib.MAPIReference;

public class MAssetManager 
{
	public static String getMAPITexture(String name)
	{
		return MAPIReference.MODID_MAPI + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MAPIReference.MODID_EO + ":"  + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MAPIReference.MODID_ED + ":"  + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MAPIReference.MODID_EMD + ":"  + name;
	}
}
