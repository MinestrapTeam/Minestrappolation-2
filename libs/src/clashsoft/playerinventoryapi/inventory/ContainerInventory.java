package clashsoft.playerinventoryapi.inventory;

import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.math.Point2i;
import clashsoft.playerinventoryapi.CreativeInventory;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.SurvivalInventory;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.ISlotList;
import clashsoft.playerinventoryapi.lib.FakeArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerInventory extends Container implements ISlotList
{
	public InventoryCrafting	craftMatrix	= new InventoryCrafting(this, 2, 2);
	public IInventory			craftResult	= new InventoryCraftResult();
	
	public final EntityPlayer	thePlayer;
	public boolean				isCreative;
	
	public ContainerInventory(InventoryPlayer inventory, EntityPlayer player)
	{
		this.thePlayer = player;
		
		if (PlayerInventoryAPI.proxy.isClient())
		{
			this.inventorySlots = new FakeArrayList(45);
		}
		
		this.onContainerOpened(player);
		this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	@Override
	public Slot addSlot(Slot slot)
	{
		this.addSlotToContainer(slot);
		return slot;
	}
	
	@Override
	protected Slot addSlotToContainer(Slot slot)
	{
		super.addSlotToContainer(slot);
		if (this.isCreative)
		{
			CreativeInventory.setSlot(slot.slotNumber, slot.xDisplayPosition, slot.yDisplayPosition);
		}
		else
		{
			SurvivalInventory.setSlot(slot.slotNumber, slot.xDisplayPosition, slot.yDisplayPosition);
		}
		return slot;
	}
	
	public void reloadSlots()
	{
		boolean creative = this.isCreative;
		List<IInventoryHandler> handlers;
		Point2i[] slotPositions;
		
		if (creative)
		{
			handlers = CreativeInventory.handlers;
			slotPositions = CreativeInventory.getSlots();
		}
		else
		{
			handlers = SurvivalInventory.handlers;
			slotPositions = SurvivalInventory.getSlots();
		}
		
		for (IInventoryHandler handler : handlers)
		{
			handler.pre(slotPositions, this.thePlayer, creative);
		}
		
		this.inventorySlots.clear();
		
		List<Slot> slots = this.createSlots(slotPositions);
		
		for (Slot slot : slots)
		{
			this.addSlotToContainer(slot);
		}
		
		for (IInventoryHandler handler : handlers)
		{
			handler.addSlots(this, this.thePlayer, this.isCreative);
		}
	}
	
	public List<Slot> createSlots(Point2i[] pos)
	{
		List<Slot> slots = new ArrayList<Slot>(pos.length);
		slots.add(new SlotCrafting(this.thePlayer, this.craftMatrix, this.craftResult, 0, pos[0].getX(), pos[0].getY()));
		
		int i;
		int j;
		int k;
		
		for (i = 0; i < 2; ++i)
		{
			for (j = 0; j < 2; ++j)
			{
				k = j + i * 2;
				slots.add(new Slot(this.craftMatrix, k, pos[k + 1].getX(), pos[k + 1].getY()));
			}
		}
		
		for (i = 0; i < 4; ++i)
		{
			k = 5 + i;
			slots.add(new SlotCustomArmor(this.thePlayer, this.thePlayer.inventory, 39 - i, pos[k].getX(), pos[k].getY(), i));
		}
		
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				k = 9 + j + i * 9;
				slots.add(new Slot(this.thePlayer.inventory, k, pos[k].getX(), pos[k].getY()));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			k = i + 36;
			slots.add(new Slot(this.thePlayer.inventory, i, pos[k].getX(), pos[k].getY()));
		}
		
		return slots;
	}
	
	@Override
	public ItemStack slotClick(int i, int j, int k, EntityPlayer player)
	{
		player.openContainer = this;
		return super.slotClick(i, j, k, player);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventory)
	{
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.thePlayer.worldObj));
	}
	
	public void onContainerOpened(EntityPlayer player)
	{
		this.isCreative = player.capabilities.isCreativeMode;
		this.reloadSlots();
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		
		for (int i = 0; i < 4; ++i)
		{
			ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
			
			if (itemstack != null)
			{
				player.dropPlayerItemWithRandomChoice(itemstack, false);
			}
		}
		this.craftResult.setInventorySlotContents(0, (ItemStack) null);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
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
			int size = this.inventorySlots.size();
			
			if (itemstack.stackSize == 0)
			{
				return null;
			}
			
			int armorSlotID = -1;
			
			if (itemstack.getItem() instanceof ItemArmor)
			{
				ItemArmor itemArmor = (ItemArmor) itemstack.getItem();
				int armorType = itemArmor.armorType;
				
				if (armorType < 4)
				{
					Slot armorSlot = (Slot) this.inventorySlots.get(5 + armorType);
					if (!armorSlot.getHasStack())
					{
						armorSlotID = 5 + armorType;
					}
				}
				else
				{
					for (int i = 45; i < size; i++)
					{
						Slot armorSlot = (Slot) this.inventorySlots.get(i);
						
						if (!armorSlot.getHasStack() && armorSlot.isItemValid(itemstack1))
						{
							armorSlotID = i;
							break;
						}
					}
				}
			}
			
			if (slotID == 0) // Crafting output
			{
				if (!this.mergeItemStack(itemstack1, 9, 45, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotID >= 1 && slotID < 5) // Crafting grid
			{
				if (!this.mergeItemStack(itemstack1, 9, 45, false))
				{
					return null;
				}
			}
			else if (slotID >= 5 && slotID < 9) // Armor slots
			{
				if (!this.mergeItemStack(itemstack1, 9, 45, false))
				{
					return null;
				}
			}
			else if (slotID >= 45)
			{
				if (!this.mergeItemStack(itemstack1, 9, 45, false))
				{
					return null;
				}
			}
			else if (itemstack.getItem() instanceof ItemArmor && armorSlotID != -1) // Armor
			{
				if (!this.mergeItemStack(itemstack1, armorSlotID, armorSlotID + 1, false))
				{
					return null;
				}
			}
			else if ((slotID >= 9 && slotID < 36)) // Normal inventory
			{
				if (!this.mergeItemStack(itemstack1, 36, 45, false))
				{
					return null;
				}
			}
			else if (slotID >= 36 && slotID < 45) // Hotbar
			{
				if (!this.mergeItemStack(itemstack1, 9, 36, false) && !this.mergeItemStack(itemstack1, 45, size, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 9, 45, false))
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
	public boolean func_94530_a(ItemStack stack, Slot slot)
	{
		return slot.inventory != this.craftResult;
	}
}
