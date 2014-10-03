package minestrapteam.minestrappolation.lib;

import java.io.File;

import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.io.CSWeb;
import clashsoft.cslib.logging.CSLog;

public class MConfig
{
	public static boolean	vanillaTextures;
	
	public static boolean	oreEffects;
	public static int		daysUntilTarnish;
	public static int		daysUntilMossy;
	public static int		bedrockDamage;
	
	public static boolean	showDurability;
	public static boolean	foodSpoiling;
	public static int		spoilTimeRounding;
	
	public static boolean	generateBiomeStone;
	public static boolean	generateInvincium;
	
	public static void load()
	{
		vanillaTextures = CSConfig.getBool("textures", "Use Altered Vanilla Textures", true);
		
		daysUntilTarnish = CSConfig.getInt("blocks", "Copper Tarnish Days", "Days until Copper Blocks tarnish", 3);
		oreEffects = CSConfig.getBool("blocks", "Ore Effects", "Should Uranium and Plutonium Ores affect the player", true);
		daysUntilMossy = CSConfig.getInt("blocks", "Mossy Planks Days", "Days until Planks get mossy", 3);
		bedrockDamage = CSConfig.getInt("blocks", "Bedrock Damage", 2000);
		
		showDurability = CSConfig.getBool("items", "Show Tool Durability", true);
		foodSpoiling = CSConfig.getBool("items", "Food Spoiling", true);
		spoilTimeRounding = CSConfig.getInt("items", "Spoil Time Rounding", "The amount of seconds in which Spoilable Food Items are stackable.", 500);
		
		generateBiomeStone = CSConfig.getBool("gen", "Replace Biome Stone", true);
		generateInvincium = CSConfig.getBool("gen", "Generate Invincium", true);
		
		updateVanillaTextures(vanillaTextures);
	}
	
	protected static void updateVanillaTextures(final boolean use)
	{
		new Thread()
		{
			@Override
			public void run()
			{
				File file = new File("resourcepacks/Minestrappolation Vanilla Textures.zip");
				if (file.exists())
				{
					if (!use)
					{
						file.delete();
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
				}
			}
		}.start();
	}
}