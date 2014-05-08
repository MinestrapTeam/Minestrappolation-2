package sobiohazardous.mods.minestrappolation.core.inventory;

import sobiohazardous.mods.minestrappolation.core.recipes.StonecutterCraftingManager;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerStonecutter extends Container
{
	public InventoryCrafting				craftMatrix	= new InventoryCrafting(this, 3, 3);
	public IInventory						craftResult	= new InventoryCraftResult();
	public IInventory	extraSlot	= new InventoryBasic("ExtraSlot", true, 1);
	public TileEntityStonecutter stoneCutter;
	
	public ContainerStonecutter(InventoryPlayer inventory, TileEntityStonecutter te)
	{
		this.stoneCutter = te;
		
		this.addSlotToContainer(new SlotStonecutterCrafting(inventory.player, this.craftMatrix, this.craftResult, this.extraSlot, 0, 124 + 14, 35));
		int l;
		int i1;
		
		for (l = 0; l < 3; ++l)
		{
			for (i1 = 0; i1 < 3; ++i1)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18 + 14, 17 + l * 18));
			}
		}
		
		for (l = 0; l < 3; ++l)
		{
			for (i1 = 0; i1 < 9; ++i1)
			{
				this.addSlotToContainer(new Slot(inventory, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
			}
		}
		
		for (l = 0; l < 9; ++l)
		{
			this.addSlotToContainer(new Slot(inventory, l, 8 + l * 18, 142));
		}
		
		// extra slot
		this.addSlotToContainer(new Slot(this.extraSlot, 37, 8, 35));
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory par1IInventory)
	{
		this.craftResult.setInventorySlotContents(0, StonecutterCraftingManager.instance.findMatchingRecipe(this.craftMatrix, this.extraSlot.getStackInSlot(0), this.stoneCutter.getWorldObj()));
	}
	
	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{
		super.onContainerClosed(par1EntityPlayer);
		
		if (!this.stoneCutter.getWorldObj().isRemote)
		{
			for (int i = 0; i < 9; ++i)
			{
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
				
				if (itemstack != null)
				{
					par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, true);
				}
			}
			
			ItemStack extraItem = this.extraSlot.getStackInSlotOnClosing(0);
			if (extraItem != null)
			{
				par1EntityPlayer.dropPlayerItemWithRandomChoice(extraItem, true);
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.stoneCutter.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotID == 0)
			{
				if (!this.mergeItemStack(itemstack1, 10, 46, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotID >= 10 && slotID < 37)
			{
				if (!this.mergeItemStack(itemstack1, 37, 46, false))
				{
					return null;
				}
			}
			else if (slotID >= 37 && slotID < 46)
			{
				if (!this.mergeItemStack(itemstack1, 10, 37, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 10, 46, false))
			{
				return null;
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
	
	@Override
	public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
	{
		return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
	}
}
