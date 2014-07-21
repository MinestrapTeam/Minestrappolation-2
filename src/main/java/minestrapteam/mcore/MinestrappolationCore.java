package minestrapteam.mcore;

import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.minecraft.init.BaseMod;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.mcore.common.MCCommonProxy;
import minestrapteam.mcore.common.MCEventHandler;
import minestrapteam.mcore.lib.MCBlocks;
import minestrapteam.mcore.lib.MCItems;
import minestrapteam.mcore.lib.MCRecipes;
import minestrapteam.mcore.lib.MCReference;
import minestrapteam.mcore.tileentity.TileEntityStonecutter;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = MCReference.CORE_MODID, name = MCReference.CORE_NAME, version = MCReference.CORE_VERSION, dependencies = MCReference.CORE_DEPENDENCY)
public class MinestrappolationCore extends BaseMod
{
	@Instance(MCReference.CORE_MODID)
	public static MinestrappolationCore	instance;
	
	public static MCCommonProxy			proxy	= createProxy("minestrapteam.mcore.client.MCClientProxy", "minestrapteam.mcore.common.MCCommonProxy");
	
	public static boolean				showDurability;
	
	public MinestrappolationCore()
	{
		super(proxy, MCReference.CORE_MODID, MCReference.CORE_NAME, MCReference.CORE_ACRONYM, MCReference.CORE_VERSION);
		this.authors = MCReference.AUTHORS;
	}
	
	@Override
	public void readConfig()
	{
		showDurability = CSConfig.getBool("misc", "Show Durability", true);
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.proxy = proxy;
		
		super.preInit(event);
		
		MCBlocks.init();
		MCItems.init();
		MCRecipes.init();
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		Blocks.bedrock.setHardness(80F);
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "StoneCutter");
		
		FMLCommonHandler.instance().bus().register(new MCEventHandler());
		MinecraftForge.EVENT_BUS.register(new MCEventHandler());
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
