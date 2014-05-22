package com.minestrappolation.inventory;

import com.minestrappolation.tileentity.TileEntityBarrel;

import clashsoft.cslib.minecraft.inventory.ContainerInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerBarrel extends ContainerInventory
{
	public ContainerBarrel(EntityPlayer player, TileEntityBarrel barrel)
	{
		super(player, barrel);
		
		this.addInventorySlots(0, 21);
		for (int j = 0; j < 4; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(barrel, k + j * 9, 8 + k * 18, 19 + j * 18));
			}
		}
	}
}