package sobiohazardous.minestrappolation.extraores;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.api.customrecipes.CustomSmeltingLoader;
import sobiohazardous.minestrappolation.api.customrecipes.PluginFolder;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.minestrappolation.extraores.fluids.EOFluids;
import sobiohazardous.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.minestrappolation.extraores.handler.GuiHandler;
import sobiohazardous.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOConfig;
import sobiohazardous.minestrappolation.extraores.lib.EOFuelHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOIngotAndOreRegistration;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.minestrappolation.extraores.lib.EORecipeManager;
import sobiohazardous.minestrappolation.extraores.proxy.CommonProxy;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
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
import cpw.mods.fml.relauncher.Side;

/**
 * @author SoBiohazardous
 */
@Mod ( modid = MAPIReference.MODID_EO, name=MAPIReference.MODNAME_EO, version=MAPIReference.VERSION_EO, dependencies = "required-after:Minestrappolation")
public class ExtraOres 
{	
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extraores.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	CustomSmeltingLoader smelter = new CustomSmeltingLoader();
	PluginFolder plug = new PluginFolder();
	public static int plateRenderId = RenderingRegistry.getNextAvailableRenderId();

	@Instance("ExtraOres")
	public static ExtraOres instance;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	public static Fluid eoFluid;
	@Mod.EventHandler
    public void myNewPreLoadMethod(FMLPreInitializationEvent evt)	
	{    
		//MinecraftForge.EVENT_BUS.register(new EOBucketHandler());
	    Blocks.bedrock.setHardness(80F);
	    eoFluid = new EOFluids("EO Fluid").setViscosity(6500).setDensity(3);
		EOConfig.initilize(evt);
	    	    
		//Lib adding
		plug.createPluginFolder();
		plug.createVanillaandMinestrappolationAlias();
		smelter.loadCustomFuels();
		EOBlockManager.addBlocks();
		EOItemManager.addItems();
		EOIngotAndOreRegistration.registerOresAndIngots();
		EORecipeManager.loadRecipes();
		EOBlockManager.registerBlocks();
		EOItemManager.setHarvestLevels();
		// FluidContainerRegistry.registerFluidContainer(eoFluid, new ItemStack(EOItemManager.bucketMagma), new ItemStack(Item.bucketEmpty));
		EntityRegistry.registerModEntity(EntityInstantExplosion.class, "Plutonium", 4, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 6, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);

		GameRegistry.registerWorldGenerator(new EOOreGenerator(),0);
		EOItemManager.addItemsToChests();
	}
	
	@Mod.EventHandler
    public void loadNew(FMLInitializationEvent event)
    {				
        proxy.registerRenderThings();
 
        GameRegistry.registerFuelHandler(new EOFuelHandler());
    	GameRegistry.registerTileEntity(TileEntityMelter.class, "tileEntityMelter");
    	
    	EOBlockManager.loadVanillaOverwrites();
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
	}
	
	@Mod.EventHandler
    public void myNewPostLoadMethod(FMLPostInitializationEvent evt)
    {
		EOBlockManager.addSlabs();
    }
	
	public void loadBridgedRecipesAndBlocks() throws Exception
	{
		EOBlockManager.loadBridgedBlocks();
		EORecipeManager.loadBridgedRecipes();
	}

}
