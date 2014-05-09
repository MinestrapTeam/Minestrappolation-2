package sobiohazardous.mods.minestrappolation.extradecor.container;

import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import clashsoft.cslib.minecraft.inventory.ContainerInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerBarrel extends ContainerInventory
{
	public ContainerBarrel(EntityPlayer player, TileEntityBarrel barrel)
	{
		super(player, barrel);
		
		this.addInventorySlots(0, 0);
		for (int j = 0; j < 4; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(barrel, k + j * 9, 8 + k * 18, 18 + j * 18 - 10));
			}
		}
	}
}