package minestrapteam.minestrappolation;

import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.minecraft.init.BaseMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.update.reader.SimpleUpdateReader;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import minestrapteam.minestrappolation.common.BlacksmithTradeHandler;
import minestrapteam.minestrappolation.common.LibrarianTradeHandler;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.common.MEventHandler;
import minestrapteam.minestrappolation.common.PriestTradeHandler;
import minestrapteam.minestrappolation.crafting.MelterRecipeLoader;
import minestrapteam.minestrappolation.creativetab.*;
import minestrapteam.minestrappolation.lib.*;
import minestrapteam.minestrappolation.network.MNetHandler;
import minestrapteam.minestrappolation.world.MOreGenerator;

import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = MReference.MODID, name = MReference.NAME, version = MReference.VERSION, dependencies = MReference.DEPENDENCY)
public class Minestrappolation extends BaseMod
{
	@Instance(MReference.MODID)
	public static Minestrappolation		instance;
	
	public static MCommonProxy			proxy				= createProxy("minestrapteam.minestrappolation.client.MClientProxy", "minestrapteam.minestrappolation.common.MCommonProxy");
	
	public static CreativeTabs			tabBuildingBlocks	= new MTabBuildingBlocks("minestrap_building_blocks");
	public static CreativeTabs			tabStoneDecor		= new MTabStoneDecor("minestrap_stone_decor");
	public static CreativeTabs			tabDecorationBlocks	= new MTabDecoration("minestrap_decoration_blocks");
	public static CreativeTabs			tabTech				= new MTabTech("minestrap_tech");
	public static CreativeTabs			tabMisc				= new MTabMisc("minestrap_misc");
	public static CreativeTabs			tabFood				= new MTabFood("minestrap_food");
	public static CreativeTabs			tabTools			= new MTabTools("minestrap_tools");
	public static CreativeTabs			tabCombat			= new MTabCombat("minestrap_combat");
	public static CreativeTabs			tabBrewing			= new MTabBrewing("minestrap_brewing");
	public static CreativeTabs			tabMaterials		= new MTabMaterials("minestrap_materials");
	
	public static MelterRecipeLoader	melter				= new MelterRecipeLoader("melter");
		
	public static boolean				showDurability;
	public static boolean				shouldOresEffect	= true;
	public static int					daysUntilTarnish;
	public static int					daysUntilMossy;
	public static int					bedrockDamage		= 2000;
	
	public Minestrappolation()
	{
		super(proxy, MReference.MODID, MReference.NAME, MReference.ACRONYM, MReference.VERSION);
		this.authors = MReference.AUTHORS;
		this.eventHandler = new MEventHandler();
		this.netHandlerClass = MNetHandler.class;
		this.hasConfig = true;
		
		this.description = "Making Vanilla more vanilla.";
		this.logoFile = "/assets/minestrappolation/logo.png";
		this.credits = "The Minestrappolation Team";
	}
	
	@Override
	public void updateCheck()
	{
		final String url = "https://raw.githubusercontent.com/MinestrapTeam/Minestrappolation-2/master/version.txt";
		CSUpdate.updateCheck(new ModUpdater(this.name, this.acronym, this.version, url, SimpleUpdateReader.instance));
	}
	
	@Override
	public void readConfig()
	{
		showDurability = CSConfig.getBool("tools", "Show Durability", true);
		daysUntilTarnish = CSConfig.getInt("blocks", "Days until copper tarnish", 3);
		shouldOresEffect = CSConfig.getBool("blocks", "Should Plutonium/Uranium ores affect the player", true);
		daysUntilMossy = CSConfig.getInt("blocks", "Days Until Planks Get Mossy", 3);
		bedrockDamage = CSConfig.getInt("blocks", "Bedrock Damage", 2000);
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
				
		MLiquids.init();
		MLiquids.load();
		
		MBlocks.init();
		MItems.init();
		MTools.init();
		
		MBlocks.load();
		MItems.load();
		MTools.load();
		
		MRecipes.load();
		MOreDictionary.load();
		MEntities.load();
		
		MLiquids.registerFluidContainers();
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		GameRegistry.registerWorldGenerator(new MOreGenerator(), 0);
		
		MBiomes.load();
		MPotions.load();
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(1, new LibrarianTradeHandler());
		
		GameRegistry.registerFuelHandler((IFuelHandler) this.eventHandler);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
		MRecipes.removeRecipes();
	}
}
