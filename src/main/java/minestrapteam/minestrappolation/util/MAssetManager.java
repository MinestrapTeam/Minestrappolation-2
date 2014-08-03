package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.lib.MReference;

import net.minecraft.util.ResourceLocation;

/**
 * The main class for getting textures and models.
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class MAssetManager
{
	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(MReference.MODID, name);
	}
	
	public static ResourceLocation getModelResource(String name)
	{
		return new ResourceLocation(MReference.MODID, "textures/model/" + name + ".png");
	}
	
	public static ResourceLocation getGUIResource(String name)
	{
		return new ResourceLocation(MReference.MODID, "textures/gui/" + name + ".png");
	}
	
	// Minestrappolation Blocks and Items Icons
	
	public static String getTexture(String name)
	{
		return MReference.MODID + ":" + name;
	}
	
	public static String getMobTexture(String name)
	{
		return getTexture("mobs/" + name);
	}
	
	public static String getModelTexture(String name)
	{
		return getTexture("model/" + name);
	}
	
	public static String getDrinksTexture(String name)
	{
		return getTexture("drinks/" + name);
	}
	
	public static String getStonecutterTexture(String name)
	{
		return MReference.MODID + ":stonecutter/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getArmorTexture(String name)
	{
		return MReference.MODID + ":armor/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getDrinkTexture(String name)
	{
		return MReference.MODID + ":drinks/" + name;
	}
	
	public static String getFoodTexture(String name)
	{
		return MReference.MODID + ":food/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLampTexture(String name)
	{
		return MReference.MODID + ":lamps/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getLiquidTexture(String name)
	{
		return MReference.MODID + ":liquids/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getMachineTexture(String name)
	{
		return MReference.MODID + ":machines/" + name;
	}
	
	public static String getMineralTexture(String name)
	{
		return MReference.MODID + ":minerals/" + name;
	}
	
	public static String getMobDropTexture(String name)
	{
		return MReference.MODID + ":mobs/" + name;
	}
	
	/**
	 * Only for blocks.
	 */
	public static String getPlantTexture(String name)
	{
		return MReference.MODID + ":plants/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getToolTexture(String name)
	{
		return MReference.MODID + ":tools/" + name;
	}
	
	/**
	 * Only for items.
	 */
	public static String getWeaponTexture(String name)
	{
		return MReference.MODID + ":weapons/" + name;
	}
	
	public static String getWoodTexture(String name)
	{
		return MReference.MODID + ":wood/" + name;
	}
	
	// Minestrappolation Models
	public static String getModel(String name)
	{
		return MReference.MODID + ":textures/model/" + name + ".png";
	}
	
	public static String getArmorModel(String name)
	{
		return MReference.MODID + ":textures/armor/" + name + ".png";
	}
	
	public static String getBlockModel(String name)
	{
		return MReference.MODID + ":textures/blocks/model/" + name + ".png";
	}
}
