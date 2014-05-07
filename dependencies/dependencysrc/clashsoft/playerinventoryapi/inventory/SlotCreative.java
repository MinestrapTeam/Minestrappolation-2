package clashsoft.playerinventoryapi.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

@SideOnly(Side.CLIENT)
public class SlotCreative extends Slot
{
	private final Slot	theSlot;
	
	public SlotCreative(Slot slot, int slotIndex)
	{
		super(slot.inventory, slotIndex, slot.xDisplayPosition, slot.yDisplayPosition);
		this.theSlot = slot;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		this.theSlot.onPickupFromSlot(player, stack);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return this.theSlot.isItemValid(stack);
	}
	
	@Override
	public ItemStack getStack()
	{
		return this.theSlot.getStack();
	}
	
	@Override
	public boolean getHasStack()
	{
		return this.theSlot.getHasStack();
	}
	
	@Override
	public void putStack(ItemStack stack)
	{
		this.theSlot.putStack(stack);
	}
	
	@Override
	public void onSlotChanged()
	{
		this.theSlot.onSlotChanged();
	}
	
	@Override
	public int getSlotStackLimit()
	{
		return this.theSlot.getSlotStackLimit();
	}
	
	@Override
	public IIcon getBackgroundIconIndex()
	{
		return this.theSlot.getBackgroundIconIndex();
	}
	
	@Override
	public ItemStack decrStackSize(int amount)
	{
		return this.theSlot.decrStackSize(amount);
	}
	
	@Override
	public boolean isSlotInInventory(IInventory inventory, int slotID)
	{
		return this.theSlot.isSlotInInventory(inventory, slotID);
	}
	
	public Slot getSlot()
	{
		return this.theSlot;
	}
}
