package sobiohazardous.mods.minestrappolation.core.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryStonecutterExtraSlot implements IInventory
{
	private Container	container;
	
	public InventoryStonecutterExtraSlot(Container container)
	{
		this.container = container;
	}
	
	/** A list of one item containing the result of the crafting formula */
	private ItemStack[]	stackInSlot	= new ItemStack[1];
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory()
	{
		return 1;
	}
	
	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int par1)
	{
		return this.stackInSlot[0];
	}
	
	/**
	 * Returns the name of the inventory
	 */
	@Override
	public String getInventoryName()
	{
		return "Extra";
	}
	
	/**
	 * Returns if the inventory name is localized
	 */
	public boolean isInventoryNameLocalized()
	{
		return false;
	}
	
	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.stackInSlot[0] != null)
		{
			ItemStack var3 = this.stackInSlot[0];
			this.stackInSlot[0] = null;
			this.container.onCraftMatrixChanged(this);
			return var3;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.stackInSlot[0] != null)
		{
			ItemStack var2 = this.stackInSlot[0];
			this.stackInSlot[0] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.stackInSlot[0] = par2ItemStack;
		this.container.onCraftMatrixChanged(this);
	}
	
	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	/**
	 * Called when an the contents of an Inventory change, usually
	 */
	public void onInventoryChanged()
	{
	}
	
	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return true;
	}
	
	@Override
	public void openInventory()
	{
	}
	
	@Override
	public void closeInventory()
	{
	}
	
	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
	{
		return true;
	}
	
	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}
	
	@Override
	public void markDirty()
	{
		
	}
}
