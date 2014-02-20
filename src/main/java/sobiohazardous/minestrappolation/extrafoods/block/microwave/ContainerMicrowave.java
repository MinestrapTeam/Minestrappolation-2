package sobiohazardous.minestrappolation.extrafoods.block.microwave;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMicrowave extends Container {

	private TileEntityMicrowave furnace;
	private int lastCookTime = 0;
	public int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerMicrowave(InventoryPlayer inventoryPlayer, TileEntityMicrowave tileFurnace)
	{
		this.furnace = tileFurnace;
		this.addSlotToContainer(new Slot(tileFurnace, TileEntityMicrowave.INGOT_SLOT_1_INDEX, 37, 17));
		this.addSlotToContainer(new Slot(tileFurnace, TileEntityMicrowave.INGOT_SLOT_2_INDEX, 56, 17));
		this.addSlotToContainer(new Slot(tileFurnace, TileEntityMicrowave.FUEL_INVENTORY_INDEX, 46, 53));
		this.addSlotToContainer(new SlotMicrowave(inventoryPlayer.player,tileFurnace, TileEntityMicrowave.OUTPUT_INVENTORY_INDEX, 116, 35));

		for (int invRow = 0; invRow < 3; ++invRow)
		{
			for (int invCol = 0; invCol < 9; ++invCol)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
			}
		}

		for (int actionBar = 0; actionBar < 9; ++actionBar) {
			this.addSlotToContainer(new Slot(inventoryPlayer, actionBar, 8 + actionBar * 18, 142));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.furnace.furnaceCookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
			}

			if (this.lastBurnTime != this.furnace.furnaceBurnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.furnace.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.furnace.furnaceCookTime;
		this.lastBurnTime = this.furnace.furnaceBurnTime;
		this.lastItemBurnTime = this.furnace.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.furnace.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.furnace.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.furnace.currentItemBurnTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (par2 != 1 && par2 != 0) {
				if (MicrowaveRecipes.smelting().getDoubleSmeltingResult(itemstack1, itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
				} else if (TileEntityMicrowave.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(entityPlayer, itemstack1);
		}

		return itemstack;

	}



}