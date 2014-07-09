package minestrapteam.minestrappolation;

import clashsoft.brewingapi.BrewingAPI;
import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.minecraft.entity.CSEntities;
import clashsoft.cslib.minecraft.init.BaseMod;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import minestrapteam.mcore.crafting.CustomRecipeLoader;
import minestrapteam.mcore.lib.MCReference;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.crafting.MelterRecipeLoader;
import minestrapteam.minestrappolation.creativetab.*;
import minestrapteam.minestrappolation.entity.*;
import minestrapteam.minestrappolation.handler.BlacksmithTradeHandler;
import minestrapteam.minestrappolation.handler.FuelHandler;
import minestrapteam.minestrappolation.handler.MEventHandler;
import minestrapteam.minestrappolation.handler.PriestTradeHandler;
import minestrapteam.minestrappolation.lib.*;
import minestrapteam.minestrappolation.tileentity.TileEntityLocked;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.world.MOreGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = MCReference.MODID, name = MCReference.NAME, version = MCReference.VERSION, dependencies = MCReference.DEPENDENCY)
public class Minestrappolation extends BaseMod
{
	@Instance(MCReference.MODID)
	public static Minestrappolation		instance;
	
	public static MCommonProxy			proxy				= createProxy("minestrapteam.minestrappolation.client.MClientProxy", "minestrapteam.minestrappolation.common.MCommonProxy");
	
	public static CreativeTabs			tabBuildingBlocks	= new MCreativeTabBuildingBlocks("minestrap_building_blocks");
	public static CreativeTabs			tabStoneDecor		= new MCreativeTabStoneDecor("minestrap_stone_decor");
	public static CreativeTabs			tabDecorationBlocks	= new MCreativeTabDecoration("minestrap_decoration_blocks");
	public static CreativeTabs			tabTech				= new MCreativeTabTech("minestrap_tech");
	public static CreativeTabs			tabFood				= new MCreativeTabFood("minestrap_food");
	public static CreativeTabs			tabMaterials		= new MCreativeTabMaterials("minestrap_materials");
	public static CreativeTabs			tabCombat			= new MCreativeTabCombat("minestrap_combat");
	public static CreativeTabs			tabTools			= new MCreativeTabTools("minestrap_tools");
	public static CreativeTabs			tabBrewing			= new MCreativeTabBrewing("minestrap_brewing");
	public static CreativeTabs			tabMisc				= new MCreativeTabMisc("minestrap_misc");
	
	public static CustomRecipeLoader	smelter				= new CustomRecipeLoader("furnace");
	public static MelterRecipeLoader	melter				= new MelterRecipeLoader("melter");
	
	public static Fluid					magmaFluid;
	
	public static boolean				shouldOresEffect	= true;
	public static int					daysUntilTarnish;
	public static int					daysUntilMossy;
	public static int					bedrockDamage		= 2000;
	
	public Minestrappolation()
	{
		super(proxy, MCReference.MODID, MCReference.NAME, MCReference.ACRONYM, MCReference.VERSION);
		this.eventHandler = new MEventHandler();
		this.hasConfig = true;
	}
	
	@Override
	public void readConfig()
	{
		daysUntilTarnish = CSConfig.getInt("misc", "Days until copper tarnish", 3);
		shouldOresEffect = CSConfig.getBool("misc", "Should Plutonium/Uranium ores affect the player", true);
		daysUntilMossy = CSConfig.getInt("misc", "Days Until Planks Get Mossy", 3);
		bedrockDamage = CSConfig.getInt("blocks", "Bedrock Damage", 2000);
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		magmaFluid = new Fluid("Magma").setViscosity(6500).setDensity(3);
		FluidRegistry.registerFluid(magmaFluid);
		
		smelter.load();
		
		MBlocks.init();
		MItems.init();
		MTools.init();
		
		MBlocks.load();
		MItems.load();
		MTools.load();
		
		MRecipes.load();
		MOreDictionary.load();
		
		// FluidContainerRegistry.registerFluidContainer(eoFluid, new
		// ItemStack(EOItemManager.bucketMagma), new
		// ItemStack(Item.bucketEmpty));
		
		GameRegistry.registerTileEntity(TileEntityLocked.class, "Locked");
		
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 6, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		MTileEntities.registerTileEntitys();
		GameRegistry.registerWorldGenerator(new MOreGenerator(), 0);
		BrewingAPI.registerEffectHandler(new MPotions());
		
		MPotions.loadPotions();
		MPotions.loadBrewingRecipes();
		
		CSEntities.register("HangGlider", 700, EntityHangGlider.class);
		GameRegistry.registerTileEntity(TileEntityMelter.class, "Melter");
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
		MRecipes.removeRecipes();
	}
}
