package clashsoft.playerinventoryapi;

import gnu.trove.set.hash.TCustomHashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import clashsoft.cslib.math.Point2i;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.invobject.IInventoryObject;
import clashsoft.playerinventoryapi.inventory.SlotConstants;
import clashsoft.playerinventoryapi.lib.ButtonHashingStrategy;

public class CreativeInventory implements SlotConstants
{
	protected static Point2i[]				slots;
	
	public static int						windowWidth		= 195;
	public static int						windowHeight	= 136;
	public static int						playerDisplayX	= 8;
	public static int						playerDisplayY	= 5;
	public static int						binSlotX		= 173;
	public static int						binSlotY		= 112;
	
	public static Set						buttons			= new TCustomHashSet(ButtonHashingStrategy.instance);
	public static List<IInventoryHandler>	handlers		= new ArrayList();
	public static List<IInventoryObject>	objects			= new ArrayList();
	
	public static Point2i[] getSlots()
	{
		if (slots == null)
		{
			slots = new Point2i[64];
			getSlots(slots);
		}
		return slots;
	}
	
	protected static void getSlots(Point2i[] pos)
	{
		int i;
		int j;
		
		pos[CRAFTING_OUTPUT] = new Point2i(-2000, -2000);
		pos[CRAFTING_TOP_LEFT] = new Point2i(-2000, -2000);
		pos[CRAFTING_TOP_RIGHT] = new Point2i(-2000, -2000);
		pos[CRAFTING_BOTTOM_LEFT] = new Point2i(-2000, -2000);
		pos[CRAFTING_BOTTOM_RIGHT] = new Point2i(-2000, -2000);
		
		pos[HELMET] = new Point2i(45, 6);
		pos[CHESTPLATE] = new Point2i(63, 6);
		pos[LEGGINGS] = new Point2i(81, 6);
		pos[BOOTS] = new Point2i(99, 6);
		
		// 9 - 35 = Inventory
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				pos[9 + j + i * 9] = new Point2i(9 + j * 18, 54 + i * 18);
			}
		}
		
		// 36 - 44 = Hotbar
		for (i = 0; i < 9; ++i)
		{
			pos[36 + i] = new Point2i(9 + i * 18, 112);
		}
	}
	
	/**
	 * Sets the position of a slot in the creative player inventory.
	 * 
	 * @param slotID
	 *            the ID of the slot
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setSlot(int slotID, int x, int y)
	{
		Point2i[] array = slots;
		if (slotID >= array.length)
		{
			array = Arrays.copyOf(array, slotID + 1);
			slots = array;
		}
		
		if (array[slotID] == null)
		{
			array[slotID] = new Point2i(x, y);
		}
		else
		{
			array[slotID].setX(x).setY(y);
		}
	}
	
	/**
	 * Sets the position of the player display in the survival inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setPlayer(int x, int y)
	{
		playerDisplayX = x;
		playerDisplayY = y;
	}
	
	/**
	 * Sets the position of the bin slot in the creative inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setBinSlot(int x, int y)
	{
		binSlotX = x;
		binSlotY = y;
	}
	
	/**
	 * Sets the position of the armor slots in the creative inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setArmor(int x, int y)
	{
		setSlot(HELMET, x, y);
		setSlot(CHESTPLATE, x + 18, y);
		setSlot(LEGGINGS, x + 36, y);
		setSlot(BOOTS, x + 54, y);
	}
	
	/**
	 * Sets the size of the creative inventory window.
	 * 
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public static void setWindowSize(int width, int height)
	{
		windowWidth = width;
		windowHeight = height;
	}
	
	/**
	 * Registers a new {@link IInventoryHandler}.
	 * 
	 * @param handler
	 */
	public static void addHandler(IInventoryHandler handler)
	{
		handlers.add(handler);
	}
	
	/**
	 * Adds a button to the creative inventory.
	 * 
	 * @param button
	 *            the button
	 */
	public static void addButton(Object button)
	{
		buttons.add(button);
	}
	
	/**
	 * Adds an {@link IInventoryObject} to the creative inventory.
	 * 
	 * @param object
	 *            the object
	 */
	public static void addObject(IInventoryObject object)
	{
		objects.add(object);
	}
	
	/**
	 * Resets the creative inventory to its vanilla state. This resets
	 * <ul>
	 * <li>The window size
	 * <li>The player display position
	 * <li>The bin slot position
	 * <li>The positions of all vanilla slots
	 * <li>The buttons
	 * <li>The renderable objects.
	 * </ul>
	 */
	public static void reset()
	{
		windowWidth = 195;
		windowHeight = 136;
		playerDisplayX = 8;
		playerDisplayY = 5;
		binSlotX = 173;
		binSlotY = 112;
		
		getSlots(slots);
		
		buttons.clear();
		objects.clear();
	}
}
