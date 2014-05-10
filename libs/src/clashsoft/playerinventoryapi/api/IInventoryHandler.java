package clashsoft.playerinventoryapi.api;

import clashsoft.cslib.math.Point2i;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

/**
 * A basic inventory modification handler.
 * 
 * @author Clashsoft
 */
public interface IInventoryHandler
{
	/**
	 * This method is called before vanilla slots are added. Use it to adjust
	 * modify slot positions and other properties like window size.
	 * 
	 * @param slots
	 *            the slots
	 * @param player
	 *            the player
	 * @param creative
	 *            true, if the player is in creative mode
	 */
	public void pre(Point2i[] slots, EntityPlayer player, boolean creative);
	
	/**
	 * Override this method to add new inventory slots. This method is called
	 * after adding vanilla slots. Therefore it should not be used to modify
	 * slot positions, instead
	 * {@link IInventoryHandler#pre(EntityPlayer, boolean)} should be used for
	 * that.
	 * 
	 * @param container
	 *            the container
	 * @param player
	 *            the player
	 * @param creative
	 *            true, if the player is in creative mode
	 */
	public void addSlots(ISlotList container, EntityPlayer player, boolean creative);
	
	/**
	 * This method is called when a button is pressed on the creative or
	 * survival inventory
	 * 
	 * @param button
	 *            the button
	 * @param player
	 *            the player
	 * @param creative
	 *            true, if the player is in creative mode
	 */
	public void buttonPressed(GuiButton button, EntityPlayer player, boolean creative);
}
