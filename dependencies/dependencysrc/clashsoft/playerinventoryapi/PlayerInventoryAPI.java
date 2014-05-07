package clashsoft.playerinventoryapi;

import clashsoft.cslib.minecraft.ClashsoftMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.invobject.IInventoryObject;
import clashsoft.playerinventoryapi.common.PIEventHandler;
import clashsoft.playerinventoryapi.common.PIProxy;
import clashsoft.playerinventoryapi.inventory.ContainerInventory;
import clashsoft.playerinventoryapi.network.PINetHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PlayerInventoryAPI.MODID, name = PlayerInventoryAPI.NAME, version = PlayerInventoryAPI.VERSION)
public class PlayerInventoryAPI extends ClashsoftMod
{
	public static final String			MODID					= "piapi";
	public static final String			NAME					= "Player Inventory API";
	public static final String			ACRONYM					= "piapi";
	public static final String			VERSION					= CSUpdate.CURRENT_VERSION + "-1.0.0";
	
	@Instance(MODID)
	public static PlayerInventoryAPI	instance;
	
	@SidedProxy(clientSide = "clashsoft.playerinventoryapi.client.PIClientProxy", serverSide = "clashsoft.playerinventoryapi.common.PIProxy")
	public static PIProxy				proxy;
	
	public static boolean				customSurvivalInventory	= true;
	public static boolean				customCreativeInventory	= true;
	
	public static boolean				itemTooltip				= false;
	public static boolean				buffTooltip				= true;
	public static boolean				playerTooltip			= true;
	
	public PlayerInventoryAPI()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.hasConfig = true;
		this.eventHandler = new PIEventHandler();
		this.netHandlerClass = PINetHandler.class;
		this.url = "https://github.com/Clashsoft/Player-Inventory-API/wiki/";
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	@Override
	public void readConfig()
	{
		itemTooltip = CSConfig.getBool("tooltip", "Item Tooltip", itemTooltip);
		buffTooltip = CSConfig.getBool("tooltip", "Buff Tooltip", buffTooltip);
		playerTooltip = CSConfig.getBool("tooltip", "Player Tooltip", playerTooltip);
	}
	
	// ---------- API ---------- \\
	
	/**
	 * Sets the position of a slot in the both the survival and the creative
	 * player inventory.
	 * 
	 * @see PlayerInventoryAPI#setSurvivalSlot(int, int, int)
	 * @see PlayerInventoryAPI#setCreativeSlot(int, int, int)
	 * @param slotID
	 *            the ID of the slot
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setSlot(int slotID, int x, int y)
	{
		SurvivalInventory.setSlot(slotID, x, y);
		CreativeInventory.setSlot(slotID, x, y);
	}
	
	/**
	 * Registers a new {@link IInventoryHandler}.
	 * 
	 * @param handler
	 *            the inventory handler
	 */
	public static void addInventoryHandler(IInventoryHandler handler)
	{
		SurvivalInventory.addHandler(handler);
		CreativeInventory.addHandler(handler);
	}
	
	/**
	 * Adds a button to both the survival and the creative inventory.
	 * 
	 * @param button
	 *            the button
	 */
	public static void addButton(Object button)
	{
		SurvivalInventory.addButton(button);
		CreativeInventory.addButton(button);
	}
	
	/**
	 * Adds an {@link IInventoryObject} to both the survival and the creative
	 * inventory.
	 * 
	 * @param object
	 *            the object
	 */
	public static void addObject(IInventoryObject object)
	{
		SurvivalInventory.addObject(object);
		CreativeInventory.addObject(object);
	}
}
