package clashsoft.playerinventoryapi.lib;

import java.util.Arrays;

import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.network.EIPacket;
import clashsoft.playerinventoryapi.network.EISlotPacket;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * Extended Inventory class. Stores extra slot data of a custom player inventory
 * 
 * @author Clashsoft
 */
public class ExtendedInventory implements IExtendedEntityProperties, IInventory
{
	public static final String	IDENTIFIER	= "PIAPI-EI";
	
	public EntityPlayer			entity;
	
	public ItemStack[]			itemStacks	= new ItemStack[16];
	
	public ExtendedInventory(EntityPlayer entity)
	{
		this.entity = entity;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		NBTTagList list = new NBTTagList();
		int len = this.itemStacks.length;
		
		for (int i = 0; i < len; i++)
		{
			ItemStack stack = this.itemStacks[i];
			if (stack != null)
			{
				NBTTagCompound nbt1 = new NBTTagCompound();
				stack.writeToNBT(nbt1);
				nbt1.setInteger("Slot", i);
				list.appendTag(nbt1);
			}
		}
		nbt.setTag("Slots", list);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagList list = (NBTTagList) compound.getTag("Slots");
		int len = list.tagCount();
		
		this.checkSize(len);
		for (int i = 0; i < len; i++)
		{
			NBTTagCompound nbt = list.getCompoundTagAt(i);
			int slot = nbt.getInteger("Slot");
			ItemStack stack = ItemStack.loadItemStackFromNBT(nbt);
			this.itemStacks[slot] = stack;
		}
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
	
	/**
	 * Called each tick to update items
	 */
	public void onUpdate()
	{
		for (ItemStack stack : this.itemStacks)
		{
			if (stack != null && stack.getItem() != null)
			{
				stack.getItem().onUpdate(stack, this.entity.worldObj, this.entity, this.entity.inventory.currentItem, false);
				stack.getItem().onArmorTick(this.entity.worldObj, this.entity, stack);
			}
		}
	}
	
	/**
	 * Returns the {@link ExtendedInventory} of the player. Note the this method
	 * may return {@code null} if an {@link ExtendedInventory} hasn't already
	 * been applied to the player.
	 * 
	 * @see Entity#getExtendedProperties(String)
	 * @param player
	 * @return
	 */
	protected static ExtendedInventory get_(EntityPlayer player)
	{
		return (ExtendedInventory) player.getExtendedProperties(IDENTIFIER);
	}
	
	/**
	 * Returns the {@link ExtendedInventory} of the player. If the player
	 * doesn't already have an {@link ExtendedInventory}, a new one is created
	 * and applied to the player.
	 * 
	 * @see ExtendedInventory#get_(EntityPlayer)
	 * @see ExtendedInventory#set_(EntityPlayer, ExtendedInventory)
	 * @param player
	 *            the player
	 * @return the extended inventory
	 */
	public static ExtendedInventory get(EntityPlayer player)
	{
		ExtendedInventory props = get_(player);
		return props == null ? set_(player, new ExtendedInventory(player)) : props;
	}
	
	/**
	 * Sets the {@link ExtendedInventory} of the player and applies it.
	 * 
	 * @see Entity#registerExtendedProperties(String, IExtendedEntityProperties)
	 * @param player
	 *            the player
	 * @param ei
	 *            the extended inventory
	 * @return the extended inventory
	 */
	protected static ExtendedInventory set_(EntityPlayer player, ExtendedInventory ei)
	{
		player.registerExtendedProperties(IDENTIFIER, ei);
		return ei;
	}
	
	/**
	 * Sets the {@link ExtendedInventory} of the player and applies it. If the
	 * player already has an {@link ExtendedInventory}, the data of the given
	 * {@link ExtendedInventory} is copied to the existing one using
	 * {@link #copy(ExtendedInventory, ExtendedInventory)}. Otherwise, the given
	 * {@link ExtendedInventory} is directly applied using
	 * {@link #set_(EntityPlayer, ExtendedInventory)}
	 * 
	 * @param player
	 * @param ei
	 * @return
	 */
	public static ExtendedInventory set(EntityPlayer player, ExtendedInventory ei)
	{
		ExtendedInventory ei2 = get_(player);
		if (ei2 == null)
		{
			return set_(player, ei);
		}
		else
		{
			copy(ei, ei2);
			return ei2;
		}
	}
	
	public static void copy(ExtendedInventory source, ExtendedInventory dest)
	{
		dest.itemStacks = source.itemStacks;
		dest.entity = source.entity;
	}
	
	/**
	 * Syncs all slots with the player.
	 * 
	 * @param player
	 */
	public void sync()
	{
		PlayerInventoryAPI.instance.netHandler.send(new EIPacket(this));
	}
	
	/**
	 * Syncs slot # {@code slot} with the player.
	 * 
	 * @param player
	 * @param slot
	 */
	public void sync(int slot)
	{
		// The survival inventory syncs the slot on its own, but the creative
		// inventory doesn't.
		if (this.entity.capabilities.isCreativeMode)
		{
			PlayerInventoryAPI.instance.netHandler.send(new EISlotPacket(this, slot));
		}
	}
	
	public void checkSize(int slot)
	{
		int len = this.itemStacks.length;
		if (slot >= len)
		{
			ItemStack[] stacks = new ItemStack[slot + 1];
			System.arraycopy(this.itemStacks, 0, stacks, 0, len);
			this.itemStacks = stacks;
		}
	}
	
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		this.checkSize(slot);
		
		return this.itemStacks[slot];
	}
	
	@Override
	public int getSizeInventory()
	{
		return this.itemStacks.length;
	}
	
	public void clear()
	{
		Arrays.fill(this.itemStacks, null);
		this.sync();
	}
	
	public void dropAllItems()
	{
		for (int i = 0; i < this.itemStacks.length; i++)
		{
			this.entity.func_146097_a(this.itemStacks[i], true, false);
			this.itemStacks[i] = null;
		}
		this.sync();
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		this.checkSize(slot);
		
		ItemStack stack = this.itemStacks[slot];
		if (stack != null)
		{
			if (stack.stackSize <= amount)
			{
				this.itemStacks[slot] = null;
				this.sync(slot);
				return stack;
			}
			else
			{
				ItemStack stack1 = stack.splitStack(amount);
				if (stack.stackSize == 0)
				{
					this.itemStacks[slot] = null;
				}
				this.sync(slot);
				return stack1;
			}
		}
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		return this.getStackInSlot(slot);
	}
	
	public boolean addItemStack(ItemStack stack)
	{
		CSStacks.mergeItemStack(this.itemStacks, 0, stack);
		this.sync();
		return stack.stackSize > 0;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.checkSize(slot);
		
		if (itemstack != null && itemstack.stackSize <= 0)
		{
			itemstack = null;
		}
		this.itemStacks[slot] = itemstack;
		this.sync(slot);
	}
	
	@Override
	public String getInventoryName()
	{
		return IDENTIFIER;
	}
	
	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public void markDirty()
	{
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}
	
	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemstack)
	{
		return true;
	}
	
	@Override
	public void openInventory()
	{
	}
	
	@Override
	public void closeInventory()
	{
	}
}
