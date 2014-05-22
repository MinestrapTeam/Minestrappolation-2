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
	
	public static String getMCoreTexture(String name)
	{
		return MCReference.MINESTRAP_CORE_ID + ":" + name;
	}
	
	// Minestrappolation Blocks and Items Icons
	
	public static String getTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":" + name;
	}
	
	public static String getMobTexture(String name)
	{
		return getTexture("mobs/" + name);
	}
	
	public static String getPlantsTexture(String name)
	{
		return getTexture("model/" + name);
	}
	
	public static String getDrinksTexture(String name)
	{
		return getTexture("drinks/" + name);
	}
	
	public static String getStonecutterTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":stonecutter/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getArmorTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":armor/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getDrinkTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":drinks/" + name;
	}
	
	public static String getFoodTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":food/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLampTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":lamps/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLiquidTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":liquids/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getMachineTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":drinks/" + name;
	}
	
	public static String getMineralTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":minerals/" + name;
	}
	
	public static String getMobDropTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":mobs/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getPlantTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":plants/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getToolTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":tools/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getWeaponTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":weapons/" + name;
	}
	
	public static String getWoodTexture(String name)
	{
		return MCReference.MINESTRAP_ID + ":wood/" + name;
	}
	
	// Minestrappolation Models
	
	public static String getArmorModel(String name)
	{
		return MCReference.MINESTRAP_ID + ":textures/armor/" + name + ".png";
	}
	
	public static String getModel(String name)
	{
		return MCReference.MINESTRAP_ID + ":textures/model/" + name + ".png";
	}
}
