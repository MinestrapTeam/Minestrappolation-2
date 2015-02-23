package minestrapteam.minestrappolation.inventory;

import clashsoft.cslib.minecraft.inventory.ContainerInventory;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrate extends ContainerInventory
{
	public ContainerCrate(EntityPlayer player, TileEntityCrate crate)
	{
		super(player, crate);
		
		for (int j = 0; j < 2; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(crate, k + j * 9, 8 + k * 18, 18 + j * 18 - 1));
			}
		}
		this.addInventorySlot(0, -18);
	}
	
	@Override
	public int[] merge(EntityPlayer player, int slot, ItemStack stack)
	{
		return new int[] { 0, 18 };
	}
}