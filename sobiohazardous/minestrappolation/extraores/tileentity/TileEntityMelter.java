package sobiohazardous.minestrappolation.extraores.tileentity;

import sobiohazardous.minestrappolation.extraores.MelterRecipes;
import sobiohazardous.minestrappolation.extraores.block.BlockMelter;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.minestrappolation.extraores.lib.ModdedMelterRecipeLoader;
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

public class TileEntityMelter extends TileEntity implements IInventory
	{
	private ItemStack goldItemStacks[];

	/** The number of ticks that the furnace will keep burning */
	public int goldBurnTime;

	public static boolean isActive;
	
	ModdedMelterRecipeLoader meltr = new ModdedMelterRecipeLoader();

		/**
         * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
         */
	public int goldItemBurnTime;

	/** The number of ticks that the current item has been cooking for */
	public int goldCookTime;

	public int front;
	
	public static boolean hasBucket;


	public TileEntityMelter()
	{
         goldItemStacks = new ItemStack[4];
         goldBurnTime = 0;
         goldItemBurnTime = 0;
         goldCookTime = 0;
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
         return goldItemStacks.length;
	}

/**
         * Returns the stack in slot i
         */
	public ItemStack getStackInSlot(int par1)
	{
         return goldItemStacks[par1];
	}
/**
         * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
         * stack.
         */
	public ItemStack decrStackSize(int par1, int par2)
	{
         if (goldItemStacks[par1] != null)
         {
                 if (goldItemStacks[par1].stackSize <= par2)
                 {
                         ItemStack itemstack = goldItemStacks[par1];
                         goldItemStacks[par1] = null;
                         return itemstack;
                 }

                 ItemStack itemstack1 = goldItemStacks[par1].splitStack(par2);

                 if (goldItemStacks[par1].stackSize == 0)
                 {
                         goldItemStacks[par1] = null;
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
         if (goldItemStacks[par1] != null)
         {
                 ItemStack itemstack = goldItemStacks[par1];
                 goldItemStacks[par1] = null;
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
         goldItemStacks[par1] = par2ItemStack;

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
         goldItemStacks = new ItemStack[getSizeInventory()];

         for (int i = 0; i < nbttaglist.tagCount(); i++)
         {
                 NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
                 byte byte0 = nbttagcompound.getByte("Slot");

                 if (byte0 >= 0 && byte0 < goldItemStacks.length)
                 {
                         goldItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
                 }
         }
        
         front = par1NBTTagCompound.getInteger("FrontDirection");
         goldBurnTime = par1NBTTagCompound.getShort("BurnTime");
         goldCookTime = par1NBTTagCompound.getShort("CookTime");
         goldItemBurnTime = getItemBurnTime(goldItemStacks[1]);
        
         System.out.println("front:" + front);
	}

/**
         * Writes a tile entity to NBT.
         */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
         super.writeToNBT(par1NBTTagCompound);
         par1NBTTagCompound.setInteger("FrontDirection", (int)front);
         par1NBTTagCompound.setShort("BurnTime", (short)goldBurnTime);
         par1NBTTagCompound.setShort("CookTime", (short)goldCookTime);
         NBTTagList nbttaglist = new NBTTagList();

         for (int i = 0; i < goldItemStacks.length; i++)
         {
                 if (goldItemStacks[i] != null)
                 {
                         NBTTagCompound nbttagcompound = new NBTTagCompound();
                         nbttagcompound.setByte("Slot", (byte)i);
                         goldItemStacks[i].writeToNBT(nbttagcompound);
                         nbttaglist.appendTag(nbttagcompound);
                 }
         }

         par1NBTTagCompound.setTag("Items", nbttaglist);
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
		return (goldCookTime * par1) / 200;
	}

	/**
         * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
         * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
         */
	public int getBurnTimeRemainingScaled(int par1)
	{
         if (goldItemBurnTime == 0)
         {
                 goldItemBurnTime = 200;
         }

         return (goldBurnTime * par1) / goldItemBurnTime;
	}

		/**
         * Returns true if the furnace is currently burning
         */
	public boolean isBurning()
	{
         return goldBurnTime > 0;
	}

		/**
         * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
         * ticks and creates a new spawn inside its implementation.
         */
	public void updateEntity()
	{
		//System.out.println(needBucket);
         boolean var1 = this.goldBurnTime > 0;
         boolean var2 = false;
         if(goldItemStacks[3]==null)
    	 {
        	 //System.out.println("no bucket");
    		 hasBucket = false;
    		 //System.out.println("Has Bucket = "+hasBucket);
    	 }
    	 
    	 if(goldItemStacks[3] != null && goldItemStacks[3].getItem() == Item.bucketEmpty)
    	 {
    		// System.out.println("Bucket found");
    		 hasBucket = true;
    		 //System.out.println("Has Bucket = "+hasBucket);
    	 }
    	 
         if (this.goldBurnTime > 0)
         {
                 --this.goldBurnTime;
         }
         if (!this.worldObj.isRemote)
         {
                 if (this.goldBurnTime == 0 && this.canSmelt())
                 {
                         this.goldItemBurnTime = this.goldBurnTime = getItemBurnTime(this.goldItemStacks[1]);
                         if (this.goldBurnTime > 0)
                         {
                                 var2 = true;
                                 if (this.goldItemStacks[1] != null)
                                 {
                                         --this.goldItemStacks[1].stackSize;
                                         if (this.goldItemStacks[1].stackSize == 0)
                                         {
                                                 this.goldItemStacks[1] = this.goldItemStacks[1].getItem().getContainerItemStack(goldItemStacks[1]);
                                         }
                                 }
                         }
                 }
                 if (this.isBurning() && this.canSmelt())
                 {
                         ++this.goldCookTime;
                         if (this.goldCookTime == 200)
                         {
                                 this.goldCookTime = 0;
                                 this.smeltItem();
                                 var2 = true;
                         }
                 }
                 else
                 {
                         this.goldCookTime = 0;
                 }
                 if (var1 != this.goldBurnTime > 0)
                 {
                         var2 = true;
                         this.validate();
                         BlockMelter.updateFurnaceBlockState(this.goldBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
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
		  
       
        
       
        
         if (goldItemStacks[0] == null)
         {
       
                 return false;
         }if(!hasBucket){
        	 return false;
         }else{
        	// if(hasBucket == true) return true; 
        	  ItemStack itemstack = MelterRecipes.smelting().getSmeltingResult(goldItemStacks[0].getItem().itemID);      	
        	  if(itemstack == null) return false;       	     
        	  if(this.goldItemStacks[2] == null) return true;
        	  if(!this.goldItemStacks[2].isItemEqual(itemstack)) return false;
        	  if (goldItemStacks[0] == null && goldItemStacks[3].getItem() == Item.bucketEmpty) return false;
        	  if(goldItemStacks[2].stackSize == goldItemStacks[2].getMaxStackSize()) return false;
        	  int result = goldItemStacks[2].stackSize + itemstack.stackSize;
        	  return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        	 
         }
         
       
      

       
	}

/**
         * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
         */
	public void smeltItem()
	{
         if (this.canSmelt() == true)
         {
                 ItemStack itemstack = MelterRecipes.smelting().getSmeltingResult(this.goldItemStacks[0].getItem().itemID);
                 if (this.goldItemStacks[2] == null)
                 {
                     this.goldItemStacks[2] = itemstack.copy();
                 }
                 else if (this.goldItemStacks[2].isItemEqual(itemstack))
                 {
                     goldItemStacks[2].stackSize += itemstack.stackSize;
                 }

                 --this.goldItemStacks[0].stackSize;

                 if (this.goldItemStacks[0].stackSize <= 0)
                 {
                     this.goldItemStacks[0] = null;
                 }
                 
                 
                 
                 
                 
                 
                 if(this.goldItemStacks[3].stackSize <= 1){
                	 goldItemStacks[3] = null;
                 }else{
                	 --this.goldItemStacks[3].stackSize; 
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

         if (i < 256 && Block.blocksList[i].blockMaterial == Material.wood)
         {
                 return 300;
         }

         if (i == Item.stick.itemID)
         {
                 return 100;
         }

         if (i == Item.coal.itemID)
         {
                 return 1600;
         }

         if (i == Item.bucketLava.itemID)
         {
                 return 20000;
         }

         if (i == Block.sapling.blockID)
         {
                 return 100;
         }

         if (i == Item.blazeRod.itemID)
         {
                 return 2400;
         }
         else
         {
                 return ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage());
         }
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