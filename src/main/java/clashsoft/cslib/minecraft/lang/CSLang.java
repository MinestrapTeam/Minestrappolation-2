package clashsoft.cslib.minecraft.lang;

import java.util.Properties;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;

/**
 * The Class CSLang
 * <p>
 * This class adds several utils for adding localizations.
 * 
 * @deprecated
 * 
 * @author Clashsoft
 */
public class CSLang extends LanguageRegistry
{
	public static void addName(Object key, String value)
	{
		try
		{
			LanguageRegistry.addName(key, value);
		}
		catch (IllegalArgumentException ex)
		{
			addLocalizationUS(key.toString(), value);
		}
	}
	
	public static void addLangPack(Properties pack, String lang)
	{
		LanguageRegistry.instance().addStringLocalization(pack, lang);
	}
	
	public static void add(String key, String value)
	{
		addLocalizationUS(key, value);
	}
	
	/**
	 * Adds a localization.
	 * 
	 * @see LanguageRegistry.addLocalization(String, String, String)
	 * @param key
	 *            the key
	 * @param lang
	 *            the lang
	 * @param value
	 *            the value
	 */
	public static void addLocalization(String key, String lang, String value)
	{
		LanguageRegistry.instance().addStringLocalization(key, lang, value);
	}
	
	/**
	 * Adds an english localization.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void addLocalizationUS(String key, String value)
	{
		addLocalization(key, "en_US", value);
	}
	
	/**
	 * Adds a german localization.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void addLocalizationDE(String key, String value)
	{
		addLocalization(key, "de_DE", value);
	}
	
	/**
	 * Adds an achievement.
	 * 
	 * @deprecated
	 * @param achievement
	 *            the achievement
	 * @param lang
	 *            the lang
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	@Deprecated
	@SideOnly(Side.CLIENT)
	public static void addAchievement(Achievement achievement, String lang, String name, String description)
	{
		// TODO
	}
	
	/**
	 * Adds an english achievement.
	 * 
	 * @param achievement
	 *            the achievement
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	@SideOnly(Side.CLIENT)
	public static void addAchievementUS(Achievement achievement, String name, String description)
	{
		addAchievement(achievement, "en_US", name, description);
	}
	
	/**
	 * Adds a german achievement.
	 * 
	 * @param achievement
	 *            the achievement
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	@SideOnly(Side.CLIENT)
	public static void addAchievementDE(Achievement achievement, String name, String description)
	{
		addAchievement(achievement, "de_DE", name, description);
	}
	
	/**
	 * Adds a potion name.
	 * 
	 * @param potion
	 *            the potion
	 * @param lang
	 *            the lang
	 * @param name
	 *            the name
	 * @param effectname
	 *            the effectname
	 * @param description
	 *            the description
	 */
	public static void addPotion(Potion potion, String lang, String name, String effectname, String description)
	{
		String potionname = potion.getName();
		addLocalization(potionname, lang, effectname);
		addLocalization(potionname + ".postfix", lang, name);
		addLocalization(potionname + ".description", lang, name);
	}
	
	/**
	 * Adds an english potion name.
	 * 
	 * @param potion
	 *            the potion
	 * @param name
	 *            the name
	 * @param effectname
	 *            the effectname
	 * @param description
	 *            the description
	 */
	public static void addPotionUS(Potion potion, String name, String effectname, String description)
	{
		addPotion(potion, "en_US", name, effectname, description);
	}
	
	/**
	 * Adds the a german potion name.
	 * 
	 * @param potion
	 *            the potion
	 * @param name
	 *            the name
	 * @param effectname
	 *            the effectname
	 * @param description
	 *            the description
	 */
	public static void addPotionDE(Potion potion, String name, String effectname, String description)
	{
		addPotion(potion, "de_DE", name, effectname, description);
	}
}
