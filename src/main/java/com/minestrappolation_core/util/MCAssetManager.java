package com.minestrappolation_core.util;

import com.minestrappolation_core.lib.MCReference;

import net.minecraft.util.ResourceLocation;

/**
 * The main class for getting textures and models.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MCAssetManager
{
	public static ResourceLocation getMAPIResource(String name)
	{
		return new ResourceLocation(MCReference.CORE_MODID, name);
	}
	
	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(MCReference.MODID, name);
	}
	
	public static ResourceLocation getModelResource(String name)
	{
		return new ResourceLocation(MCReference.MODID, "textures/model/" + name + ".png");
	}
	
	public static String getMCoreTexture(String name)
	{
		return MCReference.CORE_MODID + ":" + name;
	}
	
	// Minestrappolation Blocks and Items Icons
	
	public static String getTexture(String name)
	{
		return MCReference.MODID + ":" + name;
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
		return MCReference.MODID + ":stonecutter/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getArmorTexture(String name)
	{
		return MCReference.MODID + ":armor/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getDrinkTexture(String name)
	{
		return MCReference.MODID + ":drinks/" + name;
	}
	
	public static String getFoodTexture(String name)
	{
		return MCReference.MODID + ":food/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLampTexture(String name)
	{
		return MCReference.MODID + ":lamps/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLiquidTexture(String name)
	{
		return MCReference.MODID + ":liquids/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getMachineTexture(String name)
	{
		return MCReference.MODID + ":drinks/" + name;
	}
	
	public static String getMineralTexture(String name)
	{
		return MCReference.MODID + ":minerals/" + name;
	}
	
	public static String getMobDropTexture(String name)
	{
		return MCReference.MODID + ":mobs/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getPlantTexture(String name)
	{
		return MCReference.MODID + ":plants/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getToolTexture(String name)
	{
		return MCReference.MODID + ":tools/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getWeaponTexture(String name)
	{
		return MCReference.MODID + ":weapons/" + name;
	}
	
	public static String getWoodTexture(String name)
	{
		return MCReference.MODID + ":wood/" + name;
	}
	
	// Minestrappolation Models
	
	public static String getArmorModel(String name)
	{
		return MCReference.MODID + ":textures/armor/" + name + ".png";
	}
	
	public static String getModel(String name)
	{
		return MCReference.MODID + ":textures/model/" + name + ".png";
	}
}
