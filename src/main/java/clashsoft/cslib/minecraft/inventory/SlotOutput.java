package clashsoft.cslib.minecraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot2
{
	public SlotOutput(IInventory inventory, int slotID, int x, int y)
	{
		super(inventory, slotID, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return false;
	}
}
