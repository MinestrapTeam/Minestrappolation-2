package minestrapteam.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import minestrapteam.minestrappolation.block.BlockMelter;
import minestrapteam.minestrappolation.crafting.MelterRecipes;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityMelter extends TileEntityInventory implements ISidedInventory
{
	public int					burnTime;
	public int					maxBurnTime;
	public int					meltTime;
	public int					front;
	
	public boolean				hasPower;
	public boolean				hasBucket;
	
	private static final int[]	topInputSlot	= new int[] { 0 };
	private static final int[]	outputSlots		= new int[] { 2, 1 };
	private static final int[]	inputSlots		= new int[] { 1 };
	
	public TileEntityMelter()
	{
		super(4);
		this.burnTime = 0;
		this.maxBurnTime = 0;
		this.meltTime = 0;
		this.hasPower = false;
	}
	
	public void setFrontDirection(int f)
	{
		this.front = f;
	}
	
	public int getFrontDirection()
	{
		return this.front;
	}
	
	@Override
	public int getSizeInventory()
	{
		return 4;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.front = nbt.getInteger("FrontDirection");
		this.burnTime = nbt.getShort("BurnTime");
		this.meltTime = nbt.getShort("CookTime");
		this.maxBurnTime = this.getItemBurnTime(this.itemStacks[1]);
		this.hasPower = nbt.getBoolean("hasPower");
	}
	
	public boolean isPowered()
	{
		return this.hasPower;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setInteger("FrontDirection", this.front);
		nbt.setShort("BurnTime", (short) this.burnTime);
		nbt.setShort("CookTime", (short) this.meltTime);
		nbt.setBoolean("hasPower", this.hasPower);
	}
	
	public int getProgressScaled(int scalar)
	{
		if (!this.hasPower)
		{
			return this.meltTime * scalar / 200 * 64;
		}
		return this.meltTime * scalar / 200 * 32;
	}
	
	public int getBurnTimeRemainingScaled(int scalar)
	{
		if (this.maxBurnTime == 0)
		{
			this.maxBurnTime = 200;
		}
		
		return this.burnTime * scalar / this.maxBurnTime;
	}
	
	public boolean isBurning()
	{
		return this.burnTime > 0;
	}
	
	@Override
	public void updateEntity()
	{
		boolean var1 = this.burnTime > 0;
		boolean var2 = false;
		if (this.itemStacks[3] == null)
		{
			this.hasBucket = false;
		}
		else if (this.itemStacks[3].getItem() == Items.bucket)
		{
			this.hasBucket = true;
		}
		
		if (this.burnTime > 0)
		{
			--this.burnTime;
		}
		if (!this.worldObj.isRemote)
		{
			if (this.burnTime == 0 && this.canSmelt())
			{
				this.maxBurnTime = this.burnTime = this.getItemBurnTime(this.itemStacks[1]);
				if (this.burnTime > 0)
				{
					var2 = true;
					if (this.itemStacks[1] != null)
					{
						--this.itemStacks[1].stackSize;
						if (this.itemStacks[1].stackSize == 0)
						{
							this.itemStacks[1] = this.itemStacks[1].getItem().getContainerItem(this.itemStacks[1]);
						}
					}
				}
			}
			if (this.isBurning() && this.canSmelt())
			{
				++this.meltTime;
				if (this.meltTime == 200)
				{
					this.meltTime = 0;
					this.smeltItem();
					var2 = true;
				}
			}
			else
			{
				this.meltTime = 0;
			}
			if (var1 != this.burnTime > 0)
			{
				var2 = true;
				this.validate();
				BlockMelter.updateFurnaceBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if (var2)
		{
			this.markDirty();
		}
		this.hasPower = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord);
	}
	
	private boolean canSmelt()
	{
		if (this.itemStacks[0] != null && this.hasBucket)
		{
			ItemStack itemstack = MelterRecipes.instance.getResult(this.itemStacks[0]);
			if (itemstack == null)
			{
				return false;
			}
			if (this.itemStacks[2] == null)
			{
				return true;
			}
			if (!this.itemStacks[2].isItemEqual(itemstack))
			{
				return false;
			}
			if (this.itemStacks[0] == null && this.itemStacks[3].getItem() == Items.bucket)
			{
				return false;
			}
			if (this.itemStacks[2].stackSize == this.itemStacks[2].getMaxStackSize())
			{
				return false;
			}
			int result = this.itemStacks[2].stackSize + itemstack.stackSize;
			return result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize();
		}
		return false;
	}
	
	public void smeltItem()
	{
		if (this.canSmelt())
		{
			ItemStack itemstack = MelterRecipes.instance.getResult(this.itemStacks[0]);
			if (this.itemStacks[2] == null)
			{
				this.itemStacks[2] = itemstack.copy();
			}
			else if (this.itemStacks[2].isItemEqual(itemstack))
			{
				this.itemStacks[2].stackSize += itemstack.stackSize;
			}
			
			--this.itemStacks[0].stackSize;
			
			if (this.itemStacks[0].stackSize <= 0)
			{
				this.itemStacks[0] = null;
			}
			
			if (this.itemStacks[3].stackSize <= 1)
			{
				this.itemStacks[3] = null;
			}
			else
			{
				--this.itemStacks[3].stackSize;
			}
			
		}
	}
	
	public boolean isItemFuel(ItemStack stack)
	{
		return this.getItemBurnTime(stack) > 0;
	}
	
	public int getItemBurnTime(ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		
		int i = TileEntityFurnace.getItemBurnTime(stack);
		if (i == 0)
		{
			Item item = stack.getItem();
			if (item == MItems.Uranium)
			{
				i = 150000;
			}
			else if (item == MItems.Plutonium)
			{
				i = 200000;
			}
		}
		if (this.hasPower)
		{
			i *= 2;
		}
		
		return i;
	}
	
	@Override
	public boolean canInsertItem(int slotID, ItemStack stack, int side)
	{
		return this.isItemValidForSlot(slotID, stack);
	}
	
	@Override
	public boolean canExtractItem(int slotID, ItemStack stack, int side)
	{
		return side == 0 && slotID != 1 || stack.getItem() == Items.bucket;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return side == 0 ? outputSlots : side == 1 ? topInputSlot : inputSlots;
	}
}