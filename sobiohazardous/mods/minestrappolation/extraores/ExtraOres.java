package sobiohazardous.mods.minestrappolation.extraores;

import sobiohazardous.mods.minestrappolation.core.customrecipes.CustomRecipeLoader;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraores.common.EOCommonProxy;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.mods.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.mods.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.mods.minestrappolation.extraores.lib.*;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MReference.MODID_EO, name = MReference.MODNAME_EO, version = MReference.VERSION_EO, dependencies = "required-after:Minestrappolation")
public class ExtraOres
{
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extraores.proxy.CommonProxy")
	public static EOCommonProxy	proxy;
	
	public static CustomRecipeLoader		smelter			= new CustomRecipeLoader("furnace");
	
	@Instance(MReference.MODID_EO)
	public static ExtraOres		instance;
	
	public static Fluid			eoFluid;
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent evt)
	{
		// MinecraftForge.EVENT_BUS.register(new EOBucketHandler());
		Blocks.bedrock.setHardness(80F);
		eoFluid = new Fluid("EO Fluid").setViscosity(6500).setDensity(3);
		FluidRegistry.registerFluid(eoFluid);
		EOConfig.init(evt);
		
		// Lib adding
		this.smelter.load();
		
		EOBlocks.addBlocks();
		EOItems.addItems();
		EOOreDictionary.init();
		EORecipes.loadRecipes();
		EORecipes.loadPlatedRecipes();
		EOItems.setHarvestLevels();
		// FluidContainerRegistry.registerFluidContainer(eoFluid, new
		// ItemStack(EOItemManager.bucketMagma), new
		// ItemStack(Item.bucketEmpty));
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 6, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
		
		GameRegistry.registerWorldGenerator(new EOOreGenerator(), 0);
		EOItems.addItemsToChests();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		
		GameRegistry.registerFuelHandler(new EOFuelHandler());
		GameRegistry.registerTileEntityWithAlternatives(TileEntityMelter.class, "Melter", "tileEntityMelter");
		
		EOBlocks.loadVanillaOverwrites();
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		EOBlocks.addSlabs();
	}
	
	public void loadBridgedRecipesAndBlocks() throws Exception
	{
		EOBlocks.loadBridgedBlocks();
		EORecipes.loadBridgedRecipes();
	}
	
}
