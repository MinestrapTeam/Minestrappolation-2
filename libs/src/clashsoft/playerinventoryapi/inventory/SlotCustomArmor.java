package clashsoft.playerinventoryapi.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SlotCustomArmor extends Slot
{
	public int			armorType;
	public EntityPlayer	player;
	
	public IIcon		backgroundIcon;
	
	public SlotCustomArmor(EntityPlayer player, IInventory inventory, int slotIndex, int x, int y, int armorType)
	{
		super(inventory, slotIndex, x, y);
		this.player = player;
		this.armorType = armorType;
		
		try
		{
			this.backgroundIcon = ItemArmor.func_94602_b(armorType);
		}
		catch (NoSuchMethodError ex)
		{
		}
	}
	
	public SlotCustomArmor(EntityPlayer player, IInventory inventory, int slotIndex, int x, int y, int armorType, IIcon backgroundIcon)
	{
		super(inventory, slotIndex, x, y);
		this.armorType = armorType;
		this.backgroundIcon = backgroundIcon;
	}
	
	@Override
	public int getSlotStackLimit()
	{
		return 1;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		Item item = stack == null ? null : stack.getItem();
		return item != null && item.isValidArmor(stack, this.armorType, this.player);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getBackgroundIconIndex()
	{
		return this.backgroundIcon;
	}
}
