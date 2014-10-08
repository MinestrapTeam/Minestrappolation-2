package minestrapteam.minestrappolation;

import clashsoft.cslib.minecraft.block.ore.OreBase;
import clashsoft.cslib.minecraft.init.BaseMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.update.reader.SimpleUpdateReader;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import minestrapteam.minestrappolation.common.*;
import minestrapteam.minestrappolation.crafting.FreezerRecipeLoader;
import minestrapteam.minestrappolation.crafting.MelterRecipeLoader;
import minestrapteam.minestrappolation.creativetab.*;
import minestrapteam.minestrappolation.lib.*;
import minestrapteam.minestrappolation.network.MNetHandler;
import minestrapteam.minestrappolation.spell.SpellList;
import minestrapteam.minestrappolation.util.MAssetManager;
import minestrapteam.minestrappolation.world.MWorldGenerator;

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
	
	public static MelterRecipeLoader	melterRecipeLoader	= new MelterRecipeLoader("melter");
	public static FreezerRecipeLoader	freezerRecipeLoader	= new FreezerRecipeLoader("freezer");
	
	public static OreBase				stone				= new OreBase("stone").setIconName(MAssetManager.getStonecutterTexture("stone")).register(OreBase.TYPE_OVERWORLD, 0);
	public static OreBase				deepStone			= new OreBase("deepstone").setIconName(MAssetManager.getStonecutterTexture("deepstone")).register(OreBase.TYPE_OVERWORLD, 5);
	public static OreBase				redrock				= new OreBase("redrock").setIconName(MAssetManager.getStonecutterTexture("redrock")).register(OreBase.TYPE_OVERWORLD, 6);
	public static OreBase				deepRedrock			= new OreBase("deepredrock").setIconName(MAssetManager.getStonecutterTexture("deepredrock")).register(OreBase.TYPE_OVERWORLD, 7);
	public static OreBase				coldstone			= new OreBase("coldstone").setIconName(MAssetManager.getStonecutterTexture("coldstone")).register(OreBase.TYPE_OVERWORLD, 8);
	public static OreBase				deepColdstone		= new OreBase("deepcoldstone").setIconName(MAssetManager.getStonecutterTexture("deepcoldstone")).register(OreBase.TYPE_OVERWORLD, 9);
	public static OreBase				icestone			= new OreBase("icestone").setIconName(MAssetManager.getStonecutterTexture("icestone")).register(OreBase.TYPE_OVERWORLD, 10);
	public static OreBase				glacierrock			= new OreBase("glacierrock").setIconName(MAssetManager.getStonecutterTexture("glacierrock")).register(OreBase.TYPE_OVERWORLD, 11);
	public static OreBase				oceanstone			= new OreBase("oceanstone").setIconName(MAssetManager.getStonecutterTexture("oceanstone")).register(OreBase.TYPE_OVERWORLD, 12);
	public static OreBase				deepOceanstone		= new OreBase("pressurizedoceanstone").setIconName(MAssetManager.getStonecutterTexture("pressurizedoceanstone")).register(OreBase.TYPE_OVERWORLD, 13);
	
	public Minestrappolation()
	{
		super(proxy, MReference.MODID, MReference.NAME, MReference.ACRONYM, MReference.VERSION);
		this.authors = MReference.AUTHORS;
		this.eventHandler = new MEventHandler();
		this.netHandlerClass = MNetHandler.class;
		
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
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		SpellList.init();
		
		MConfig.load();
		
		MFluids.init();
		
		MBlocks.init();
		MItems.init();
		MTools.init();
		
		MBlocks.load();
		MItems.load();
		MTools.load();
		
		MRecipes.load();
		MOreDictionary.load();
		MEntities.load();
		MFluids.load();
		
		melterRecipeLoader.load();
		freezerRecipeLoader.load();
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		GameRegistry.registerWorldGenerator(new MWorldGenerator(), 0);
		
		MBiomes.load();
		MPotions.load();
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(1, new LibrarianTradeHandler());
		
		GameRegistry.registerFuelHandler(new MFuelHandler());
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
		MRecipes.removeRecipes();
	}
}
