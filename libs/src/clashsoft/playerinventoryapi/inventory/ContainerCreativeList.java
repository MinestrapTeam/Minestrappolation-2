package clashsoft.playerinventoryapi.inventory;

import java.util.ArrayList;
import java.util.List;

import clashsoft.playerinventoryapi.client.gui.GuiCreativeInventory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@SideOnly(Side.CLIENT)
public class ContainerCreativeList extends Container
{
	public List	itemList	= new ArrayList();
	
	public ContainerCreativeList(EntityPlayer player)
	{
		InventoryPlayer inventoryplayer = player.inventory;
		int i;
		
		for (i = 0; i < 5; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(GuiCreativeInventory.getInventory(), i * 9 + j, 9 + j * 18, 18 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryplayer, i, 9 + i * 18, 112));
		}
		
		this.scrollTo(0.0F);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
	/**
	 * Updates the gui slots ItemStack's based on scroll position.
	 */
	public void scrollTo(float pos)
	{
		int i = this.itemList.size() / 9 - 4;
		int j = (int) (pos * i + 0.5D);
		
		if (j < 0)
		{
			j = 0;
		}
		
		for (int k = 0; k < 5; ++k)
		{
			for (int l = 0; l < 9; ++l)
			{
				int m = l + (k + j) * 9;
				int n = l + k * 9;
				
				if (m >= 0 && m < this.itemList.size())
				{
					ItemStack stack = (ItemStack) this.itemList.get(m);
					GuiCreativeInventory.getInventory().setInventorySlotContents(n, stack);
				}
				else
				{
					GuiCreativeInventory.getInventory().setInventorySlotContents(l + k * 9, (ItemStack) null);
				}
			}
		}
	}
	
	public boolean hasMoreThanOnePage()
	{
		return this.itemList.size() > 45;
	}
	
	@Override
	protected void retrySlotClick(int slotID, int var1, boolean flag, EntityPlayer player)
	{
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		if (slotID >= this.inventorySlots.size() - 9 && slotID < this.inventorySlots.size())
		{
			Slot slot = (Slot) this.inventorySlots.get(slotID);
			
			if (slot != null && slot.getHasStack())
			{
				slot.putStack((ItemStack) null);
			}
		}
		
		return null;
	}
	
	@Override
	public boolean func_94530_a(ItemStack stack, Slot slot)
	{
		return slot.yDisplayPosition > 90;
	}
	
	@Override
	public boolean canDragIntoSlot(Slot slot)
	{
		return slot.inventory instanceof InventoryPlayer || slot.yDisplayPosition > 90 && slot.xDisplayPosition <= 162;
	}
}
