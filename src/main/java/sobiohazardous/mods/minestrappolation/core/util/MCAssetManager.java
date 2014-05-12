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
		return new ResourceLocation(MCReference.MINESTRAP_CORE_ID, name);
	}
	
	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(MCReference.MINESTRAP_ID, name);
	}
	
	public static ResourceLocation getModelResource(String name)
	{
		return new ResourceLocation(MCReference.MINESTRAP_ID, "textures/model/" + name + ".png");
	}
	
	public static String getMAPITexture(String name)
	{
		return MCReference.MINESTRAP_CORE_ID + ":" + name;
	}
	
	public static String getTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":" + name;
	}
	
	public static String getSCTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":stoneCutter/" + name;
	}
	
	public static String getArmorTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":textures/armor/" + name + ".png";
	}
	
	public static String getModelTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":textures/model/" + name + ".png";
	}
}
