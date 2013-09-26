package sobiohazardous.minestrappolation.extraores;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.extraores.bridge.EOBridgeRecipes;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.minestrappolation.extraores.fluids.EOFluids;
import sobiohazardous.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.minestrappolation.extraores.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.ClientTickHandler;
import sobiohazardous.minestrappolation.extraores.handler.GuiHandler;
import sobiohazardous.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockRegister;
import sobiohazardous.minestrappolation.extraores.lib.EOBucketHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOConfig;
import sobiohazardous.minestrappolation.extraores.lib.EOFuelHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.minestrappolation.extraores.lib.EONameManager;
import sobiohazardous.minestrappolation.extraores.lib.EORecipeManager;
import sobiohazardous.minestrappolation.extraores.proxy.CommonProxy;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */

@NetworkMod(clientSideRequired = true, serverSideRequired = true,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresCChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresSChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraOres", name="Extrapolated Ores", version="B1.3", dependencies = "required-after:Minestrappolation")
public class ExtraOres 
{	
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extraores.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	public static int plateRenderId = RenderingRegistry.getNextAvailableRenderId();

	@Instance("ExtraOres")
	public static ExtraOres instance;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	public static Fluid eoFluid;
	@Mod.EventHandler
    public void myNewPreLoadMethod(FMLPreInitializationEvent evt)	
	{    
		MinecraftForge.EVENT_BUS.register(new EOBucketHandler());
	    Block.bedrock.setHardness(80F);
	    eoFluid = new EOFluids("EO Fluid").setViscosity(6500).setDensity(3);
		EOConfig.initilize(evt);
	    	    
		//Lib adding
		EOBlockManager.addBlocks();
		EOItemManager.addItems();
        EONameManager.loadNames();
		EORecipeManager.loadRecipes();
		try {
			loadBridgedRecipesAndBlocks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EOBlockRegister.registerBlocks();
		EOItemManager.setHarvestLevels();
		 FluidContainerRegistry.registerFluidContainer(eoFluid, new ItemStack(EOItemManager.bucketMagma), new ItemStack(Item.bucketEmpty));
		EntityRegistry.registerModEntity(EntityInstantExplosion.class, "Plutonium", 4, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 3, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);

		GameRegistry.registerWorldGenerator(new EOOreGenerator());
	}
	
	@Mod.EventHandler
    public void loadNew(FMLInitializationEvent event)
    {		
		
        proxy.registerRenderThings(); //this allows seperate renderings for server and client
        TickRegistry.registerTickHandler(new ClientTickHandler(EnumSet.of(TickType.CLIENT)), Side.CLIENT);
        TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);

        GameRegistry.registerFuelHandler(new EOFuelHandler());
    	GameRegistry.registerTileEntity(TileEntityMelter.class, "tileEntityMelter");

		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		NetworkRegistry.instance().registerConnectionHandler(new sobiohazardous.minestrappolation.extraores.handler.NetworkHandler());
		
	}
	
	@Mod.EventHandler
    public void myNewPostLoadMethod(FMLPostInitializationEvent evt)
    {
		EOBlockManager.addSlabs();
    }
	
	public void loadBridgedRecipesAndBlocks() throws Exception{
		EOBlockManager.loadBridgedBlocks();
		EOBridgeRecipes.loadBridgedRecipes();
	}

}
