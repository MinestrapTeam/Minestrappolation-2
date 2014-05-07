package sobiohazardous.mods.minestrappolation.extraores;

import sobiohazardous.mods.minestrappolation.core.customrecipes.CustomSmeltingLoader;
import sobiohazardous.mods.minestrappolation.core.customrecipes.PluginFolder;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.mods.minestrappolation.extraores.fluids.EOFluids;
import sobiohazardous.mods.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.mods.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.mods.minestrappolation.extraores.handler.GuiHandler;
import sobiohazardous.mods.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOConfig;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOFuelHandler;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOIngotAndOreRegistration;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import sobiohazardous.mods.minestrappolation.extraores.lib.EORecipes;
import sobiohazardous.mods.minestrappolation.extraores.proxy.CommonProxy;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

/**
 * @author SoBiohazardous
 */
@Mod(modid = MReference.MODID_EO, name = MReference.MODNAME_EO, version = MReference.VERSION_EO, dependencies = "required-after:Minestrappolation")
public class ExtraOres
{
	@SidedProxy(clientSide = "sobiohazardous.mods.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.mods.minestrappolation.extraores.proxy.CommonProxy")
	public static CommonProxy	proxy;
	
	CustomSmeltingLoader		smelter			= new CustomSmeltingLoader();
	PluginFolder				plug			= new PluginFolder();
	public static int			plateRenderId	= RenderingRegistry.getNextAvailableRenderId();
	
	@Instance("ExtraOres")
	public static ExtraOres		instance;
	
	private GuiHandler			guiHandler		= new GuiHandler();
	
	public static Fluid			eoFluid;
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent evt)
	{
		// MinecraftForge.EVENT_BUS.register(new EOBucketHandler());
		Blocks.bedrock.setHardness(80F);
		eoFluid = new EOFluids("EO Fluid").setViscosity(6500).setDensity(3);
		EOConfig.initilize(evt);
		
		// Lib adding
		this.plug.createPluginFolder();
		this.plug.createVanillaandMinestrappolationAlias();
		this.smelter.loadCustomFuels();
		EOBlocks.addBlocks();
		EOItems.addItems();
		EOIngotAndOreRegistration.registerOresAndIngots();
		EORecipes.loadRecipes();
		EORecipes.loadPlatedRecipes();
		EOItems.setHarvestLevels();
		// FluidContainerRegistry.registerFluidContainer(eoFluid, new
		// ItemStack(EOItemManager.bucketMagma), new
		// ItemStack(Item.bucketEmpty));
		EntityRegistry.registerModEntity(EntityInstantExplosion.class, "Plutonium", 4, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 6, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
		
		GameRegistry.registerWorldGenerator(new EOOreGenerator(), 0);
		EOItems.addItemsToChests();
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		GameRegistry.registerFuelHandler(new EOFuelHandler());
		GameRegistry.registerTileEntity(TileEntityMelter.class, "tileEntityMelter");
		
		EOBlocks.loadVanillaOverwrites();
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
	}
	
	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent evt)
	{
		EOBlocks.addSlabs();
	}
	
	public void loadBridgedRecipesAndBlocks() throws Exception
	{
		EOBlocks.loadBridgedBlocks();
		EORecipes.loadBridgedRecipes();
	}
	
}
