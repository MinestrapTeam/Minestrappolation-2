package sobiohazardous.minestrappolation.extraores;

import java.util.Map;
import java.util.Random;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.logging.Level;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import sobiohazardous.minestrappolation.extraores.block.*;
import sobiohazardous.minestrappolation.extraores.client.renderer.RenderGrenade;
import sobiohazardous.minestrappolation.extraores.client.renderer.RenderNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.minestrappolation.extraores.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.ClientTickHandler;
import sobiohazardous.minestrappolation.extraores.handler.GuiHandler;
import sobiohazardous.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.RenderingHandler;
import sobiohazardous.minestrappolation.extraores.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extraores.item.*;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockRegister;
import sobiohazardous.minestrappolation.extraores.lib.EOFuelHandler;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.minestrappolation.extraores.lib.EONameManager;
import sobiohazardous.minestrappolation.extraores.lib.EORecipeManager;
import sobiohazardous.minestrappolation.extraores.proxy.CommonProxy;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStep;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
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
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extroresChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraOres", name="Extrapolated Ores", version="B1.3", dependencies = "required-after:Minestrappolation")
public class ExtraOres 
{	
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extraores.proxy.CommonProxy")
    public static CommonProxy proxy;
		
	
	

	
	public static int plateRenderId = RenderingRegistry.getNextAvailableRenderId();
	
	
	

	@Instance("ExtraOres")
	public static ExtraOres instance;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	@Mod.EventHandler
    public void myNewPreLoadMethod(FMLPreInitializationEvent evt)	
   {    

		EOConfig.initilize(evt);
	    
	    Block.bedrock.setHardness(80F);
	    
		GameRegistry.registerWorldGenerator(new EOOreGenerator());
		EntityRegistry.registerModEntity(EntityInstantExplosion.class, "Plutonium", 4, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 3, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
		EOBlockManager.addBlocks();
		EOItemManager.addItems();
		EOItemManager.setHarvestLevels();
        EONameManager.loadNames();
		EORecipeManager.loadRecipes();
		EOBlockRegister.registerBlocks();		
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

}
