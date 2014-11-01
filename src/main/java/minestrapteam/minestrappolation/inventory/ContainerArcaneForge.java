package minestrapteam.minestrappolation.inventory;

import clashsoft.cslib.minecraft.inventory.ContainerInventory;
import minestrapteam.minestrappolation.tileentity.TileEntityArcaneForge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerArcaneForge extends ContainerInventory
{
	public TileEntityArcaneForge	arcaneForge;
	
	public ContainerArcaneForge(EntityPlayer player, TileEntityArcaneForge arcaneForge)
	{
		super(player, arcaneForge);
		this.arcaneForge = arcaneForge;
		
		// Elemental Potency Slots
		this.addSlotToContainer(new Slot(arcaneForge, 0, 59, 18));
		this.addSlotToContainer(new Slot(arcaneForge, 1, 101, 18));
		this.addSlotToContainer(new Slot(arcaneForge, 2, 129, 46));
		this.addSlotToContainer(new Slot(arcaneForge, 3, 129, 88));
		this.addSlotToContainer(new Slot(arcaneForge, 4, 101, 116));
		this.addSlotToContainer(new Slot(arcaneForge, 5, 59, 116));
		this.addSlotToContainer(new Slot(arcaneForge, 6, 31, 88));
		this.addSlotToContainer(new Slot(arcaneForge, 7, 31, 46));
		
		// Category Slot
		this.addSlotToContainer(new Slot(arcaneForge, 8, 80, 39));
		
		// Variety Slot
		this.addSlotToContainer(new Slot(arcaneForge, 9, 108, 67));
		
		// Enhancement Slot
		this.addSlotToContainer(new Slot(arcaneForge, 10, 80, 95));
		
		// Naming Slot
		this.addSlotToContainer(new Slot(arcaneForge, 11, 52, 67));
		
		this.addInventorySlots(8, 137, 195);
	}
}
