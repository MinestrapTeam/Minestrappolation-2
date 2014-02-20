package sobiohazardous.minestrappolation.extrafoods.block.freezer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFreezer extends TileEntity implements IInventory
	{
	private ItemStack itemstacks[];

	/** The number of ticks that the furnace will keep burning */
	public int fridgeIceTime;

	private boolean isActive;

		/**
         * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
         */
	public int fridgeItemFreezeTime;

	/** The number of ticks that the current item has been cooking for */
	public int fridgeFreezeTime;

	public int front;

	public TileEntityFreezer()
	{
         itemstacks = new ItemStack[9];
         fridgeIceTime = 0;
         fridgeItemFreezeTime = 0;
         fridgeFreezeTime = 0;
	}

	public void setFrontDirection(int f)
	{
         this.front = f;
	}

	public int getFrontDirection()
	{
         return this.front;
	}

	/**
         * Returns the number of slots in the inventory.
         */
	public int getSizeInventory()
	{
         return itemstacks.length;
	}

	/**
         * Returns the stack in slot i
         */
	public ItemStack getStackInSlot(int par1)
	{
         return itemstacks[par1];
	}
	/**
         * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
         * stack.
         */
	public ItemStack decrStackSize(int par1, int par2)
	{
         if (itemstacks[par1] != null)
         {
                 if (itemstacks[par1].stackSize <= par2)
                 {
                         ItemStack itemstack = itemstacks[par1];
                         itemstacks[par1] = null;
                         return itemstack;
                 }

                 ItemStack itemstack1 = itemstacks[par1].splitStack(par2);

                 if (itemstacks[par1].stackSize == 0)
                 {
                         itemstacks[par1] = null;
                 }

                 return itemstack1;
         }
         else
         {
                 return null;
         }
	}

	/**
         * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
         * like when you close a workbench GUI.
         */
	public ItemStack getStackInSlotOnClosing(int par1)
	{
         if (itemstacks[par1] != null)
         {
                 ItemStack itemstack = itemstacks[par1];
                 itemstacks[par1] = null;
                 return itemstack;
         }
         else
         {
                 return null;
         }
	}

	/**
         * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
         */
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
         itemstacks[par1] = par2ItemStack;

         if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
         {
                 par2ItemStack.stackSize = getInventoryStackLimit();
         }
	}

	/**
         * Returns the name of the inventory.
         */
	public String getInvName()
	{
         return "container.goldOven";
	}

	/**
         * Reads a tile entity from NBT.
         */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
         super.readFromNBT(par1NBTTagCompound);
         NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
         itemstacks = new ItemStack[getSizeInventory()];

         for (int i = 0; i < nbttaglist.tagCount(); i++)
         {
                 NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
                 byte byte0 = nbttagcompound.getByte("Slot");

                 if (byte0 >= 0 && byte0 < itemstacks.length)
                 {
                         itemstacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
                 }
         }
        
         front = par1NBTTagCompound.getInteger("FrontDirection");
         fridgeIceTime = par1NBTTagCompound.getShort("BurnTime");
         fridgeFreezeTime = par1NBTTagCompound.getShort("CookTime");
         fridgeItemFreezeTime = getItemBurnTime(itemstacks[1]);
        
         System.out.println("front:" + front);
	}

/**
         * Writes a tile entity to NBT.
         */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
         super.writeToNBT(par1NBTTagCompound);
         par1NBTTagCompound.setInteger("FrontDirection", (int)front);
         par1NBTTagCompound.setShort("BurnTime", (short)fridgeIceTime);
         par1NBTTagCompound.setShort("CookTime", (short)fridgeFreezeTime);
         NBTTagList nbttaglist = new NBTTagList();

         for (int i = 0; i < itemstacks.length; i++)
         {
                 if (itemstacks[i] != null)
                 {
                         NBTTagCompound nbttagcompound = new NBTTagCompound();
                         nbttagcompound.setByte("Slot", (byte)i);
                         itemstacks[i].writeToNBT(nbttagcompound);
                         nbttaglist.appendTag(nbttagcompound);
                 }
         }

         par1NBTTagCompound.setTag("Items", nbttaglist);
         System.out.println("write:" + front);
         System.out.println("burn:" + fridgeIceTime);
	}

/**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
         * this more of a set than a get?*
         */
	public int getInventoryStackLimit()
	{
         return 64;
	}

/**
         * Returns an integer between 0 and the passed value representing how close the current item is to being completely
         * cooked
         */
	public int getCookProgressScaled(int par1)
	{
         return (fridgeFreezeTime * par1) / 200;
	}

/**
         * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
         * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
         */
	public int getBurnTimeRemainingScaled(int par1)
	{
         if (fridgeItemFreezeTime == 0)
         {
                 fridgeItemFreezeTime = 200;
         }

         return (fridgeIceTime * par1) / fridgeItemFreezeTime;
	}

/**
         * Returns true if the furnace is currently burning
         */
	public boolean isBurning()
	{
         return fridgeIceTime > 0;
	}

/**
         * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
         * ticks and creates a new spawn inside its implementation.
         */
	public void updateEntity()
	{
         boolean var1 = this.fridgeIceTime > 0;
         boolean var2 = false;
         if (this.fridgeIceTime > 0)
         {
                 --this.fridgeIceTime;
         }
         if (!this.worldObj.isRemote)
         {
                 if (this.fridgeIceTime == 0 && this.canSmelt())
                 {
                         this.fridgeItemFreezeTime = this.fridgeIceTime = getItemBurnTime(this.itemstacks[1]);
                         if (this.fridgeIceTime > 0)
                         {
                                 var2 = true;
                                 if (this.itemstacks[1] != null)
                                 {
                                         --this.itemstacks[1].stackSize;
                                         if (this.itemstacks[1].stackSize == 0)
                                         {
                                                 Item var3 = this.itemstacks[1].getItem().getContainerItem();
                                                 this.itemstacks[1] = var3 == null ? null : new ItemStack(var3);
                                         }
                                 }
                         }
                 }
                 if (this.isBurning() && this.canSmelt())
                 {
                         ++this.fridgeFreezeTime;
                         if (this.fridgeFreezeTime == 200)
                         {
                                 this.fridgeFreezeTime = 0;
                                 this.smeltItem();
                                 var2 = true;
                         }
                 }
                 else
                 {
                         this.fridgeFreezeTime = 0;
                 }
                 if (var1 != this.fridgeIceTime > 0)
                 {
                         var2 = true;
                         this.validate();
                 }
         }
         boolean check = isActive;
         isActive = isBurning();
         if(isActive != check)
         {
                 this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
         }
         if (var2)
         {
                 this.onInventoryChanged();
         }
	}

	/**
         * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
         */
	private boolean canSmelt()
	{
         if (itemstacks[0] == null)
         {
                 return false;
         }

         ItemStack itemstack = FreezerRecipes.smelting().getSmeltingResult(itemstacks[0].getItem().itemID);

         if (itemstack == null)
         {
                 return false;
         }

         if (itemstacks[2] == null)
         {
                 return true;
         }

         if (!itemstacks[2].isItemEqual(itemstack))
         {
                 return false;
         }

         if (itemstacks[2].stackSize < getInventoryStackLimit() && itemstacks[2].stackSize < itemstacks[2].getMaxStackSize())
         {
                 return true;
         }

         return itemstacks[2].stackSize < itemstack.getMaxStackSize();
}

	/**
         * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
         */
	public void smeltItem()
	{
         if (this.canSmelt())
         {
                 ItemStack var1 = FreezerRecipes.smelting().getSmeltingResult(this.itemstacks[0].getItem().itemID);
                 if (this.itemstacks[2] == null)
                 {
                         this.itemstacks[2] = var1.copy();
                 }
                 else if (this.itemstacks[2].itemID == var1.itemID)
                 {
                         ++this.itemstacks[2].stackSize;
                 }
                 --this.itemstacks[0].stackSize;
                 if (this.itemstacks[0].stackSize == 0)
                 {
                         Item var2 = this.itemstacks[0].getItem().getContainerItem();
                         this.itemstacks[0] = var2 == null ? null : new ItemStack(var2);
                 }
         }
	}

/**
         * Return true if item is a fuel source (getItemBurnTime() > 0).
         */
	public static boolean isItemFuel(ItemStack par0ItemStack)
	{
         return getItemBurnTime(par0ItemStack) > 0;
	}

/**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
	public static int getItemBurnTime(ItemStack par1ItemStack)
	{
         if (par1ItemStack == null)
         {
                 return 0;
         }

         int i = par1ItemStack.getItem().itemID;

         if (i == Item.snowball.itemID)
         {
                 return 400;
         }

         if (i == Block.snow.blockID)
         {
                 return 1600;
         }

         if (i == Block.ice.blockID)
         {
                 return 4000;
         }

         return 0;
	}
/**
         * Do not make give this method the name canInteractWith because it clashes with Container
         */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
         if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
         {
                 return false;
         }

         return par1EntityPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
	}

	public void openChest()
	{
	}

	public void closeChest()
	{
	}
	public boolean isActive()
	{
		return this.isActive;
	}

	@Override
	public boolean isInvNameLocalized() 
	{
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
		return false;
	}
}