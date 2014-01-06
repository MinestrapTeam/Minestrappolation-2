package sobiohazardous.minestrappolation.api;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.jadarstudios.developercapes.DevCapesUtil;

import sobiohazardous.minestrappolation.api.brewing.api.IIngredientHandler;
import sobiohazardous.minestrappolation.api.brewing.api.IPotionEffectHandler;
import sobiohazardous.minestrappolation.api.brewing.api.IPotionEffectHandler.PotionQueue;
import sobiohazardous.minestrappolation.api.brewing.block.BlockBrewingStand2;
import sobiohazardous.minestrappolation.api.brewing.brewing.PotionList;
import sobiohazardous.minestrappolation.api.brewing.brewing.PotionType;
import sobiohazardous.minestrappolation.api.brewing.entity.EntityPotion2;
import sobiohazardous.minestrappolation.api.brewing.item.ItemBrewingStand2;
import sobiohazardous.minestrappolation.api.brewing.item.ItemGlassBottle2;
import sobiohazardous.minestrappolation.api.brewing.item.ItemPotion2;
import sobiohazardous.minestrappolation.api.brewing.lib.DispenserBehaviorPotion2;
import sobiohazardous.minestrappolation.api.brewing.tileentity.TileEntityBrewingStand2;
import sobiohazardous.minestrappolation.api.common.MAPIPacketHandler;
import sobiohazardous.minestrappolation.api.lib.MAPIBlocks;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

@Mod(modid = "Minestrappolation", name = "Minestrappolation API", version = "1.2")
@NetworkMod(channels = { "MAPI" }, packetHandler = MAPIPacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class Minestrappolation
{
	@Instance("Minestrappolation")
	public static Minestrappolation		instance;
	
	@SidedProxy(modId = "Minestrappolation", clientSide = "sobiohazardous.minestrappolation.api.ClientProxy", serverSide = "sobiohazardous.minestrappolation.api.CommonProxy")
	public static CommonProxy		proxy;		
		
	public static MAPICreativeTab	creativeTab;
	
	public static Block				brewingStand2;
	public static Item				brewingStand2Item;
	
	public static ItemPotion2		potion2;
	public static ItemGlassBottle2	glassBottle2;
	
	public static final int			POTION_LIST_LENGTH		= 1024;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		expandPotionList();
		//Lib init
		MAPIBlocks.loadBlocks();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		DevCapesUtil.addFileUrl("https://raw.github.com/SoBiohazardous/Minestrappolation-Recode/master/Capes_Info.txt");	    
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		Minestrappolation.load();
		
		creativeTab = new MAPICreativeTab(CreativeTabs.getNextID(), "morepotions");
		
		GameRegistry.registerTileEntity(TileEntityBrewingStand2.class, "BrewingStand2");
		EntityRegistry.registerGlobalEntityID(EntityPotion2.class, "SplashPotion2", MAPIConfig.splashPotion2ID);
		EntityRegistry.registerModEntity(EntityPotion2.class, "SplashPotion2", MAPIConfig.splashPotion2ID, this, 100, 20, true);
		GameRegistry.registerTileEntity(TileEntityStonecutter.class, "tileEntityStoneCutter");
		
		Block.blocksList[Block.brewingStand.blockID] = null;
		brewingStand2 = (new BlockBrewingStand2(Block.brewingStand.blockID)).setHardness(0.5F).setLightValue(0.125F).setUnlocalizedName("brewingStand");
		ModLoader.registerBlock(brewingStand2);
		
		Item.itemsList[Item.brewingStand.itemID] = null;
		brewingStand2Item = (new ItemBrewingStand2(123)).setUnlocalizedName("brewingStand").setCreativeTab(CreativeTabs.tabBrewing);
		
		Item.itemsList[Item.potion.itemID - 256] = null;
		potion2 = (ItemPotion2) (new ItemPotion2(117)).setUnlocalizedName("potion");
		
		Item.itemsList[Item.glassBottle.itemID - 256] = null;
		glassBottle2 = (ItemGlassBottle2) (new ItemGlassBottle2(118)).setUnlocalizedName("glassBottle");
		
		Block.bedrock.setHardness(80F);

		NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
		MinecraftForge.EVENT_BUS.register(this);
		ModLoader.addDispenserBehavior(potion2, new DispenserBehaviorPotion2());
		proxy.registerRenderInformation();
		proxy.registerRenderers();
		
	}
	
	public static void load()
	{
		if (!hasLoaded)
		{
			PotionList.initializeBrewings();
			PotionList.registerBrewings();
			hasLoaded = true;
		}
	}
	
	// API Stuff
	
	public static boolean MORE_POTIONS_MOD()
	{
		try
		{
			Class.forName("clashsoft.mods.morepotions.MorePotionsMod");
			return true;
		}
		catch (ClassNotFoundException e)
		{
			return false;
		}
	}
	
	public static boolean CLASHSOFT_API()
	{
		try
		{
			Class.forName("clashsoft.clashsoftapi.ClashsoftMod");
			return true;
		}
		catch (ClassNotFoundException e)
		{
			return false;
		}
	}
	
	public static boolean						hasLoaded			= false;
	
	public static List<IPotionEffectHandler>	effectHandlers		= new LinkedList<IPotionEffectHandler>();
	public static List<IIngredientHandler>		ingredientHandlers	= new LinkedList<IIngredientHandler>();
	
	public static PotionType addBrewing(PotionType potionType)
	{
		return potionType.register();
	}
	
	public static void registerIngredientHandler(IIngredientHandler par1iIngredientHandler)
	{
		if (ingredientHandlers.contains(par1iIngredientHandler))
		{
			System.out.println("Ingredient handler \"" + par1iIngredientHandler + "\" registered");
			ingredientHandlers.add(par1iIngredientHandler);
		}
	}
	
	public static void registerEffectHandler(IPotionEffectHandler par1iPotionEffectHandler)
	{
		if (!effectHandlers.contains(par1iPotionEffectHandler))
		{
			System.out.println("Effect handler \"" + par1iPotionEffectHandler + "\" registered");
			effectHandlers.add(par1iPotionEffectHandler);
		}
	}
	
	private static PotionQueue	queue	= new PotionQueue();
	
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving != null && !event.entityLiving.worldObj.isRemote)
		{
			Collection<PotionEffect> c = event.entityLiving.getActivePotionEffects();
			
			for (PotionEffect effect : c)
			{
				for (IPotionEffectHandler handler : effectHandlers)
				{
					if (handler.canHandle(effect))
						handler.onPotionUpdate(queue, event.entityLiving, effect);
				}
			}
			
			//queue.updateEntity(event.entityLiving);
		}
	}
	
	public static void expandPotionList()
	{
		Potion[] potionTypes = null;
		
		if (Potion.potionTypes.length != POTION_LIST_LENGTH)
		{
			for (Field f : Potion.class.getDeclaredFields())
			{
				f.setAccessible(true);
				try
				{
					if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
					{
						Field modfield = Field.class.getDeclaredField("modifiers");
						modfield.setAccessible(true);
						modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
						
						potionTypes = (Potion[]) f.get(null);
						final Potion[] newPotionTypes = new Potion[POTION_LIST_LENGTH];
						for (int i = 0; i < newPotionTypes.length; i++)
						{
							if (i < Potion.potionTypes.length)
								newPotionTypes[i] = Potion.potionTypes[i];
							else
								newPotionTypes[i] = null;
						}
						f.set(null, newPotionTypes);
					}
				}
				catch (Exception e)
				{
					System.err.println("Severe error, please report this to the mod author:");
					System.err.println(e);
				}
			}
		}
	}
}
