package com.minestrappolation_core.util;

import com.minestrappolation_core.lib.MCReference;

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
	
	public static String getMineralTexture(String name)
	{
		return getTexture("minerals/" + name);
	}
	
	public static String getFoodTexture(String name)
	{
		return getTexture("food/" + name);
	}
	
	public static String getLiquidTexture(String name)
	{
		return getTexture("liquid/" + name);
	}
	
	public static String getMachineTexture(String name)
	{
		return getTexture("machine/" + name);
	}
	
	public static String getMobTexture(String name)
	{
		return getTexture("mobs/" + name);
	}
	
	public static String getPlantsTexture(String name)
	{
		return getTexture("model/" + name);
	}
	
	public static String getWoodTexture(String name)
	{
		return getTexture("wood/" + name);
	}
	
	public static String getDrinksTexture(String name)
	{
		return getTexture("drinks/" + name);
	}
	
	public static String getToolsTexture(String name)
	{
		return getTexture("tools/" + name);
	}
	
	public static String getWeaponTexture(String name)
	{
		return getTexture("weapons/" + name);
	}
	
	public static String getStonecutterTexture(String name)
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
