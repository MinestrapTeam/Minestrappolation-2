package clashsoft.cslib.minecraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class Slot2 extends Slot
{
	public int	maxStackSize = 64;
	
	public Slot2(IInventory inventory, int slotID, int x, int y)
	{
		super(inventory, slotID, x, y);
	}
	
	public Slot2 setMaxStackSize(int maxStackSize)
	{
		this.maxStackSize = maxStackSize;
		return this;
	}
	
	@Override
	public int getSlotStackLimit()
	{
		return this.maxStackSize;
	}
}
