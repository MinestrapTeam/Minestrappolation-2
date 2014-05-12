package sobiohazardous.mods.minestrappolation;

import clashsoft.brewingapi.BrewingAPI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import sobiohazardous.mods.minestrappolation.common.MCommonProxy;
import sobiohazardous.mods.minestrappolation.core.MinestrappolationCore;
import sobiohazardous.mods.minestrappolation.core.customrecipes.CustomRecipeLoader;
import sobiohazardous.mods.minestrappolation.core.lib.MCReference;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.entity.EntityHangGlider;
import sobiohazardous.mods.minestrappolation.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.gen.MOreGenerator;
import sobiohazardous.mods.minestrappolation.handler.BlacksmithTradeHandler;
import sobiohazardous.mods.minestrappolation.handler.EDPriestTradeHandler;
import sobiohazardous.mods.minestrappolation.handler.MEventHandler;
import sobiohazardous.mods.minestrappolation.handler.MPlayerTickHandler;
import sobiohazardous.mods.minestrappolation.handler.PriestTradeHandler;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;
import sobiohazardous.mods.minestrappolation.lib.MItems;
import sobiohazardous.mods.minestrappolation.lib.MPotions;
import sobiohazardous.mods.minestrappolation.lib.MRecipes;
import sobiohazardous.mods.minestrappolation.lib.MTileEntities;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityMelter;

@Mod(modid=MCReference.MINESTRAPPOLATION_ID, name=MCReference.MINESTRAPPOLATION_NAME, version=MCReference.MINESTRAPPOLATION_VERSION, dependencies=MCReference.DEPENDENCY)
public class Minestrappolation
{
	@Instance(MCReference.MINESTRAPPOLATION_ID)
	public static MinestrappolationCore	instance;
	
	@SidedProxy(modId = MCReference.MINESTRAPPOLATION_ID, clientSide = "sobiohazardous.mods.minestrappolation.client.MClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.common.MCommonProxy")
	public static MCommonProxy	proxy;
	
	public static CreativeTabs tabBuildingBlocks;
	public static CreativeTabs tabStoneDecor;
	public static CreativeTabs tabDecorationBlocks;
	public static CreativeTabs tabTech;
	public static CreativeTabs tabFood;
	public static CreativeTabs tabMaterials;
	public static CreativeTabs tabCombat;
	public static CreativeTabs tabTools;
	public static CreativeTabs tabBrewing;

	public static CustomRecipeLoader		smelter			= new CustomRecipeLoader("furnace");
	public static Fluid			eoFluid;

	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		Blocks.bedrock.setHardness(80F);
		// MinecraftForge.EVENT_BUS.register(new EOBucketHandler());
		eoFluid = new Fluid("EO Fluid").setViscosity(6500).setDensity(3);
		FluidRegistry.registerFluid(eoFluid);
		
		smelter.load();

		MBlocks.init();
		MBlocks.load();
		MItems.init();
		MItems.load();
		MRecipes.load();
		
		// FluidContainerRegistry.registerFluidContainer(eoFluid, new
		// ItemStack(EOItemManager.bucketMagma), new
		// ItemStack(Item.bucketEmpty));
		
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 6, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
		
		MItems.addItemsToChests();

	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt)
	{
		MTileEntities.registerTileEntitys();						
		GameRegistry.registerWorldGenerator(new MOreGenerator(), 0);
		BrewingAPI.registerEffectHandler(new MPotions());
		MPotions.loadPotions();
		MPotions.loadBrewingRecipes();
		MinecraftForge.EVENT_BUS.register(new MEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		FMLCommonHandler.instance().bus().register(new MPlayerTickHandler());
		
		EntityRegistry.registerGlobalEntityID(EntityHangGlider.class, "hangGlider", EntityRegistry.findGlobalUniqueEntityId());
		GameRegistry.registerTileEntityWithAlternatives(TileEntityMelter.class, "Melter", "tileEntityMelter");

		VillagerRegistry.instance().registerVillageTradeHandler(2, new EDPriestTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		proxy.registerRenderers();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		MBlocks.loadVanillaOverwrites();
		MRecipes.removeRecipes();
	}
}
