package clashsoft.playerinventoryapi.api;

import clashsoft.cslib.math.Point2i;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

/**
 * An empty implementation for {@link IInventoryHandler}.
 */
public class InventoryAdapter implements IInventoryHandler
{
	@Override
	public void pre(Point2i[] slots, EntityPlayer player, boolean creative)
	{
	}
	
	@Override
	public void addSlots(ISlotList container, EntityPlayer player, boolean creative)
	{
	}
	
	@Override
	public void buttonPressed(GuiButton button, EntityPlayer player, boolean creative)
	{
	}
}
