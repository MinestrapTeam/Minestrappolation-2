package sobiohazardous.mods.minestrappolation.extraores.client.gui;

import java.util.Iterator;
import sobiohazardous.mods.minestrappolation.extraores.MelterRecipes;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMelter extends Container
{
	private TileEntityMelter	goldOven;
	private int					lastGoldOvenCookTime;
	private int					lastGoldOvenBurnTime;
	private int					lastGoldOvenItemBurnTime;
	
	public ContainerMelter(InventoryPlayer par1InventoryPlayer, TileEntityMelter par2TileEntityGoldOven)
	{
		this.lastGoldOvenCookTime = 0;
		this.lastGoldOvenBurnTime = 0;
		this.lastGoldOvenItemBurnTime = 0;
		this.goldOven = par2TileEntityGoldOven;
		// burn
		this.addSlotToContainer(new Slot(par2TileEntityGoldOven, 1, 47, 53));
		// fuel
		this.addSlotToContainer(new Slot(par2TileEntityGoldOven, 0, 56, 17));
		// result
		this.addSlotToContainer(new SlotMelter(par1InventoryPlayer.player, par2TileEntityGoldOven, 2, 116, 35));
		// bucket
		this.addSlotToContainer(new Slot(par2TileEntityGoldOven, 3, 66, 53));
		
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		
		for (int j = 0; j < 9; j++)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
		}
	}
	
	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		Iterator var1 = this.crafters.iterator();
		while (var1.hasNext())
		{
			ICrafting var2 = (ICrafting) var1.next();
			if (this.lastGoldOvenCookTime != this.goldOven.goldCookTime)
			{
				var2.sendProgressBarUpdate(this, 0, this.goldOven.goldCookTime);
			}
			if (this.lastGoldOvenBurnTime != this.goldOven.goldBurnTime)
			{
				var2.sendProgressBarUpdate(this, 1, this.goldOven.goldBurnTime);
			}
			if (this.lastGoldOvenItemBurnTime != this.goldOven.goldItemBurnTime)
			{
				var2.sendProgressBarUpdate(this, 2, this.goldOven.goldItemBurnTime);
			}
		}
		this.lastGoldOvenCookTime = this.goldOven.goldCookTime;
		this.lastGoldOvenBurnTime = this.goldOven.goldBurnTime;
		this.lastGoldOvenItemBurnTime = this.goldOven.goldItemBurnTime;
	}
	
	@Override
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.goldOven.goldCookTime = par2;
		}
		
		if (par1 == 1)
		{
			this.goldOven.goldBurnTime = par2;
		}
		
		if (par1 == 2)
		{
			this.goldOven.goldItemBurnTime = par2;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return this.goldOven.isUseableByPlayer(par1EntityPlayer);
	}
	
	/**
	 * Called to transfer a stack from one inventory to the other eg. when shift
	 * clicking.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotnumber);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotnumber == 1 || slotnumber == 0)
			{
				if (!this.mergeItemStack(itemstack1, 3, 30, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			
			else if (slotnumber == 1 || slotnumber == 0)
			{
				if (!this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			else if (MelterRecipes.smelting().getSmeltingResult(itemstack1) != null)
			{
				if (!this.mergeItemStack(itemstack1, 1, 2, false))
				{
					return null;
				}
			}
			else if (TileEntityMelter.isItemFuel(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 0, 1, false))
				{
					return null;
				}
			}
			
			else if (slotnumber == 2 || slotnumber == 1 || slotnumber == 0)
			{
				if (!this.mergeItemStack(itemstack1, 3, 39, false))
				{
					return null;
				}
			}
			else if (slotnumber >= 3 && slotnumber < 30)
			{
				if (!this.mergeItemStack(itemstack1, 30, 39, false))
				{
					return null;
				}
			}
			else if (slotnumber >= 30 && slotnumber < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
			{
				return null;
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack);
		}
		
		return itemstack;
	}
	
	public TileEntityMelter getentity()
	{
		return this.goldOven;
	}
}