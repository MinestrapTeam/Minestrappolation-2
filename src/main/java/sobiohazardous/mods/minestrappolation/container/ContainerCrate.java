package sobiohazardous.mods.minestrappolation.container;

import sobiohazardous.mods.minestrappolation.tileentity.TileEntityCrate;
import clashsoft.cslib.minecraft.inventory.ContainerInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerCrate extends ContainerInventory
{
	public ContainerCrate(EntityPlayer player, TileEntityCrate crate)
	{
		super(player, crate);
		
		this.addInventorySlots(0, -18);
		for (int j = 0; j < 2; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(crate, k + j * 9, 8 + k * 18, 18 + j * 18 - 1));
			}
		}
	}
}