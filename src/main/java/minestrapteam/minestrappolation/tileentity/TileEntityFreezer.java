package minestrapteam.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import minestrapteam.minestrappolation.crafting.FreezerRecipes;
import minestrapteam.minestrappolation.item.MItemFood;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityFreezer extends TileEntityInventory implements ISidedInventory
{
	/*
	 * 0 = Input 1 = Fuel 2 = Output 3, 4, 5, 6, 7, 8 = Mini Fridge
	 */
	
	public int					energyTime;
	public int					maxEnergyTime;
	public int					freezeTime;
	
	private static final int[]	topInputSlot	= new int[] { 0 };
	private static final int[]	outputSlots		= new int[] { 2 };
	private static final int[]	inputSlots		= new int[] { 1 };
	
	public TileEntityFreezer()
	{
		super(9);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 9;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.energyTime = nbt.getShort("BurnTime");
		this.freezeTime = nbt.getShort("CookTime");
		this.maxEnergyTime = getItemEnergy(this.itemStacks[1]);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setShort("BurnTime", (short) this.energyTime);
		nbt.setShort("CookTime", (short) this.freezeTime);
	}
	
	public int getProgressScaled(int scalar)
	{
		return this.freezeTime * scalar / 200;
	}
	
	public int getEnergyTimeScaled(int scalar)
	{
		if (this.maxEnergyTime == 0)
		{
			this.maxEnergyTime = 200;
		}
		
		return this.energyTime * scalar / this.maxEnergyTime;
	}
	
	public boolean hasEnergy()
	{
		return this.energyTime > 0;
	}
	
	@Override
	public void updateEntity()
	{
		boolean burning = this.energyTime > 0;
		
		if (burning)
		{
			this.energyTime--;
		}
		
		if (this.worldObj.isRemote)
		{
			return;
		}
		
		for (int i = 3; i < 9; i++)
		{
			ItemStack stack = this.itemStacks[i];
			if (stack != null && stack.getItem() instanceof MItemFood && stack.stackTagCompound != null)
			{
				// "Freezes" the items by incresing their "creation time", effectively stopping their spoiling timer.
				long time = stack.stackTagCompound.getLong("SpoilTime");
				time++;
				stack.stackTagCompound.setLong("SpoilTime", time);
			}
		}
		
		if (this.canFreeze())
		{
			if (this.energyTime == 0)
			{
				ItemStack fuel = this.itemStacks[1];
				this.maxEnergyTime = this.energyTime = getItemEnergy(fuel);
				if (this.energyTime > 0)
				{
					this.markDirty();
					if (fuel != null)
					{
						--fuel.stackSize;
						if (fuel.stackSize == 0)
						{
							this.itemStacks[1] = fuel.getItem().getContainerItem(fuel);
						}
					}
				}
			}
			else if (this.hasEnergy())
			{
				++this.freezeTime;
				if (this.freezeTime >= 200)
				{
					this.freezeTime = 0;
					this.freezeItem();
					this.markDirty();
				}
			}
			else
			{
				this.freezeTime = 0;
			}
		}
		else
		{
			this.freezeTime = 0;
		}
		
		if (burning != this.energyTime > 0)
		{
			this.markDirty();
			this.validate();
		}
	}
	
	private boolean canFreeze()
	{
		ItemStack stack = this.itemStacks[0];
		if (stack != null)
		{
			ItemStack output = FreezerRecipes.instance.getResult(stack);
			
			if (output != null)
			{
				ItemStack outputSlot = this.itemStacks[2];
				if (outputSlot == null)
				{
					return true;
				}
				if (!outputSlot.isItemEqual(output))
				{
					return false;
				}
				int result = outputSlot.stackSize + output.stackSize;
				return result <= output.getMaxStackSize();
			}
		}
		return false;
	}
	
	public void freezeItem()
	{
		if (this.canFreeze())
		{
			ItemStack input = this.itemStacks[0];
			ItemStack output = FreezerRecipes.instance.getResult(input);
			ItemStack outputSlot = this.itemStacks[2];
			
			if (outputSlot == null)
			{
				this.itemStacks[2] = output.copy();
			}
			else if (outputSlot.isItemEqual(output))
			{
				outputSlot.stackSize += output.stackSize;
			}
			
			input.stackSize--;
			if (input.stackSize <= 0)
			{
				this.itemStacks[0] = null;
			}
		}
	}
	
	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemEnergy(stack) > 0;
	}
	
	public static int getItemEnergy(ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		
		Item item = stack.getItem();
		if (item == Items.snowball)
		{
			return 200;
		}
		else if (item == Items.redstone)
		{
			return 2400;
		}
		else if (item == MItems.coolantBottle)
		{
			return 12800;
		}
		else
		{
			Block block = Block.getBlockFromItem(item);
			if (block == Blocks.snow_layer)
			{
				return 400;
			}
			else if (block == Blocks.snow)
			{
				return 800;
			}
			else if (block == Blocks.ice)
			{
				return 1600;
			}
		}
		
		return 0;
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