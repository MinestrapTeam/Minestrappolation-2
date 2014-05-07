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

public class SurvivalInventory implements SlotConstants
{
	protected static Point2i[]				slots;
	
	public static int						windowWidth		= 176;
	public static int						windowHeight	= 166;
	public static int						playerDisplayX	= 25;
	public static int						playerDisplayY	= 7;
	public static int						craftArrowX		= 125;
	public static int						craftArrowY		= 37;
	public static float						craftArrowRot	= 0F;
	public static int						craftLabelX		= 87;
	public static int						craftLabelY		= 16;
	
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
		
		// 0 = Crafting output
		pos[CRAFTING_OUTPUT] = new Point2i(144, 36);
		pos[CRAFTING_TOP_LEFT] = new Point2i(88, 26);
		pos[CRAFTING_TOP_RIGHT] = new Point2i(106, 26);
		pos[CRAFTING_BOTTOM_LEFT] = new Point2i(88, 44);
		pos[CRAFTING_BOTTOM_RIGHT] = new Point2i(106, 44);
		
		pos[HELMET] = new Point2i(8, 8);
		pos[CHESTPLATE] = new Point2i(8, 26);
		pos[LEGGINGS] = new Point2i(8, 44);
		pos[BOOTS] = new Point2i(8, 62);
		
		// 9 - 35 = Inventory
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				pos[9 + j + i * 9] = new Point2i(8 + j * 18, 84 + i * 18);
			}
		}
		
		// 36 - 44 = Hotbar
		for (i = 0; i < 9; ++i)
		{
			pos[36 + i] = new Point2i(8 + i * 18, 142);
		}
	}
	
	/**
	 * Sets the position of a slot in the survival player inventory.
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
	 * Sets the position of the armor slots in the survival inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setArmor(int x, int y)
	{
		setSlot(HELMET, x, y);
		setSlot(CHESTPLATE, x, y + 18);
		setSlot(LEGGINGS, x, y + 36);
		setSlot(BOOTS, x, y + 54);
	}
	
	/**
	 * Sets the position of the crafting grid in the survival inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setCraftingGrid(int x, int y)
	{
		int x2 = x + 18;
		int y2 = y + 18;
		setSlot(CRAFTING_TOP_LEFT, x, y);
		setSlot(CRAFTING_TOP_RIGHT, x2, y);
		setSlot(CRAFTING_BOTTOM_LEFT, x, y2);
		setSlot(CRAFTING_BOTTOM_RIGHT, x2, y2);
	}
	
	/**
	 * Sets the position and rotation of the crafting arrow in the survival
	 * inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * @param rotation
	 *            the ratation
	 */
	public static void setCraftArrow(int x, int y, float rotation)
	{
		craftArrowX = x;
		craftArrowY = y;
		craftArrowRot = rotation;
	}
	
	/**
	 * Sets the position of the crafting label in the survival inventory.
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setCraftLabel(int x, int y)
	{
		craftLabelX = x;
		craftLabelY = y;
	}
	
	/**
	 * Moves the crafting grid, the crafting output slot and the crafting arrow
	 * to the left of the survival inventory. The crafting arrow is rotated by
	 * 90 degrees and the crafting label is hidden.
	 */
	public static void compactCraftingGrid()
	{
		setCraftingGrid(134, 8);
		setSlot(CRAFTING_OUTPUT, 143, 64);
		setCraftLabel(-2000, -2000);
		setCraftArrow(143, 46, 90F);
	}
	
	/**
	 * Sets the size of the survival inventory window.
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
	 * Adds a button to the survival inventory.
	 * 
	 * @param button
	 *            the button
	 */
	public static void addButton(Object button)
	{
		buttons.add(button);
	}
	
	/**
	 * Adds an {@link IInventoryObject} to the survival inventory.
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
	 * <li>The crafting arrow position and rotation
	 * <li>The crafting label position
	 * <li>The positions of all vanilla slots
	 * <li>The buttons
	 * <li>The renderable objects.
	 * </ul>
	 */
	public static void reset()
	{
		windowWidth = 176;
		windowHeight = 166;
		playerDisplayX = 25;
		playerDisplayY = 7;
		craftArrowX = 125;
		craftArrowY = 37;
		craftArrowRot = 0F;
		craftLabelX = 87;
		craftLabelY = 16;
		
		buttons.clear();
		objects.clear();
	}
}
