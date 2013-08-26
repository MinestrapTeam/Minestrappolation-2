package sobiohazardous.minestrappolation.extramobdrops.potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */
public class PotionManager 
{
	public static Potion greasePotion;
	
	public static void loadPotionEffects()
	{
		greasePotion = new EMDPotionEffect(32, false).setIconIndex(0, 0).setPotionName("potion.grease");
	}
	
	public static void definePotionEffects(LivingUpdateEvent event)
	{
		if (event.entityLiving.isPotionActive(greasePotion)) 
		{
			if (event.entityLiving.worldObj.rand.nextInt(20) == 0) 
			{
				System.out.println("greasy");
			}
		}
	}
	
	public static void loadPotionNames()
	{
		addPotionEffectName("potion.grease", "Grease Potion");
		addPotionName("potion.grease", "Potion of Grease");
	}
	
	/**
	 * Uses Binary operators to expand to potionTypes array to 256
	 */
	public static void expandPotionEffectArray()
	{	
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) 
		{
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[])f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			}
			catch (Exception e) 
			{
				System.err.println("ExtraMobDrops: Unable to expand potion effect array. Please report this to the mod author.");
				System.err.println(e);
			}
		}
	}
	
	
	/**
	 * Adds the name of the potion effect to display when the player has the effect
	 * @param unlocalizedEffectName unlocalized name of the potion
	 * @param newname what you want to display when player has your potion
	 */
	public static void addPotionEffectName(String unlocalizedEffectName, String newname)
	{
		LanguageRegistry.instance().addStringLocalization(unlocalizedEffectName, newname);
	}
	
	/**
	 * Adds the name for the potion. Unlocalized name must have potion. prefix for this to work.
	 * @param unlocalizedEffectName
	 * @param newname
	 */
	public static void addPotionName(String unlocalizedEffectName, String newname)
	{
		LanguageRegistry.instance().addStringLocalization(unlocalizedEffectName + ".postfix", newname);
	}
}
