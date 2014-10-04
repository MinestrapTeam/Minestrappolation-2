package minestrapteam.minestrappolation.lib;

import java.io.File;

import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.io.CSWeb;
import clashsoft.cslib.logging.CSLog;
import cpw.mods.fml.common.FMLCommonHandler;
import minestrapteam.minestrappolation.world.MWorldGenerator;

import net.minecraft.client.Minecraft;

public class MConfig
{
	public static File		configFile		= new File("config/Minestrappolation/mod.cfg");
	public static File		genConfigFile	= new File("config/Minestrappolation/worldgen.cfg");
	public static File		dropsConfigFile	= new File("config/Minestrappolation/mobdrops.cfg");
	
	public static boolean	vanillaTextures;
	public static boolean	vanillaRecipes;
	
	public static boolean	oreEffects;
	public static int		daysUntilTarnish;
	public static int		daysUntilMossy;
	public static boolean	isBedrockBreakable;
	public static int		bedrockDamage;
	
	public static boolean	showDurability;
	public static boolean	foodSpoiling;
	public static int		spoilTimeRounding;
	
	public static void load()
	{
		// Mod Config
		
		CSConfig.loadConfig(configFile, "Minestrappolation");
		
		vanillaTextures = CSConfig.getBool("vanilla", "Use Altered Vanilla Textures", true);
		vanillaRecipes = CSConfig.getBool("vanilla", "Use Altered Vanilla Recipes", true);
		
		daysUntilTarnish = CSConfig.getInt("blocks", "Copper Tarnish Days", "Days until Copper Blocks tarnish", 3);
		oreEffects = CSConfig.getBool("blocks", "Ore Effects", "Should Uranium and Plutonium Ores affect the player", true);
		daysUntilMossy = CSConfig.getInt("blocks", "Mossy Planks Days", "Days until Planks get mossy", 3);
		isBedrockBreakable = CSConfig.getBool("blocks", "Is Bedrock Breakable", true);
		bedrockDamage = CSConfig.getInt("blocks", "Bedrock Damage", 2000);
		
		showDurability = CSConfig.getBool("items", "Show Tool Durability", true);
		foodSpoiling = CSConfig.getBool("items", "Food Spoiling", true);
		spoilTimeRounding = CSConfig.getInt("items", "Spoil Time Rounding", "The amount of seconds in which Spoilable Food Items are stackable.", 500);
		
		updateVanillaTextures(vanillaTextures);
		
		CSConfig.saveConfig();
		
		// World Gen Config
		
		CSConfig.loadConfig(genConfigFile, "Minestrappolation World Gen");
		MWorldGenerator.loadConfig();
		CSConfig.saveConfig();
		
		// Mob Drop Config
		
		CSConfig.loadConfig(dropsConfigFile, "Minestrappolation Mob Drops");
		MDrops.loadConfig();
		CSConfig.saveConfig();
	}
	
	protected static void updateVanillaTextures(final boolean use)
	{
		if (!FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			return;
		}
		
		new Thread()
		{
			@Override
			public void run()
			{
				File file = new File("resourcepacks/Minestrappolation AVT.zip");
				if (file.exists())
				{
					if (!use)
					{
						file.delete();
						
						Minecraft.getMinecraft().gameSettings.resourcePacks.remove("Minestrappolation AVT.zip");
					}
				}
				else if (use)
				{
					String url = String.format("https://github.com/MinestrapTeam/Minestrappolation-2/releases/download/%1$s/Minestrappolation-%1$s-avt.zip", MReference.VERSION);
					try
					{
						CSWeb.download(url, file);
						CSLog.info("Successfully downloaded Minestrappolation AVT");
					}
					catch (Exception ex)
					{
						CSLog.error("Failed to download Minestrappolation AVT: " + ex.getMessage());
					}
					
					Minecraft.getMinecraft().gameSettings.resourcePacks.add("Minestrappolation AVT.zip");
				}
			}
		}.start();
	}
}
