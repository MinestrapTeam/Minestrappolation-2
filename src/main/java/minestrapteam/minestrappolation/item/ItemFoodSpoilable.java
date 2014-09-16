package minestrapteam.minestrappolation.item;

import java.util.List;

import minestrapteam.minestrappolation.item.MItemFood.FoodType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemFoodSpoilable extends ItemFood
{	
	private ItemStack spoiledItem;
	
	private FoodType foodType;
	
	public ItemFoodSpoilable(FoodType type, int healAmount, float saturation, ItemStack spoiledItem)
	{
		super(healAmount, saturation, type.isWolfMeat());
		this.spoiledItem = spoiledItem;

		this.setMaxStackSize(1);
	}

	public static void setFrozen(ItemStack stack, boolean frozen)
	{
		boolean flag = isFrozen(stack);
		if (flag != frozen)
		{
			setUpdateTicks(stack, 0L);
		}
		stack.setTagInfo("frozen", new NBTTagByte(frozen ? (byte) 1 : (byte) 0));
	}

	public static boolean isFrozen(ItemStack stack)
	{
		return stack.hasTagCompound() && stack.getTagCompound().getByte("frozen") != 0;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.setTagInfo("updateTicks", new NBTTagLong(0L));
		stack.setTagInfo("lastDimension", new NBTTagInt(player.dimension));
		stack.setTagInfo("lastWorldTime", new NBTTagLong(world.getTotalWorldTime()));
	}

	public static long getUpdateTicks(ItemStack stack)
	{
		return stack.hasTagCompound() ? stack.getTagCompound().getLong("updateTicks") : 0L;
	}

	public static void setUpdateTicks(ItemStack stack, long ticks)
	{
		stack.setTagInfo("updateTicks", new NBTTagLong(ticks));
	}

	public static long incrementTick(ItemStack stack)
	{
		long ticks = getUpdateTicks(stack);
		setUpdateTicks(stack, ++ticks);
		return ticks;
	}

	public static long getExtraTicks(ItemStack stack, World world, int dimension)
	{
		long extraTicks = 0L;
		NBTTagCompound tagCompound = stack.getTagCompound();
		if (tagCompound != null)
		{
			if (tagCompound.hasKey("lastDimension") && tagCompound.hasKey("lastWorldTime") && tagCompound.getInteger("lastDimension") == dimension)
			{
				extraTicks = world.getTotalWorldTime() - tagCompound.getLong("lastWorldTime");
			}
		}
		stack.setTagInfo("lastDimension", new NBTTagInt(dimension));
		stack.setTagInfo("lastWorldTime", new NBTTagLong(world.getTotalWorldTime()));
		return extraTicks;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		if (!(entity instanceof EntityPlayer))
		{
			return;
		}

		boolean frozen = isFrozen(stack);
		long ticks = !frozen || world.rand.nextInt(20) == 0 ? incrementTick(stack) : getUpdateTicks(stack);
		long extraTicks = getExtraTicks(stack, world, entity.dimension);
		if (frozen)
			extraTicks /= 20L;
		if (extraTicks > 0)
		{
			ticks += extraTicks;
			setUpdateTicks(stack, ticks);
		}
		
		if (ticks >= this.foodType.getMaxSpoiling())
		{
			EntityPlayer player = (EntityPlayer) entity;
			IInventory inventory = player.inventory;
			inventory.setInventorySlotContents(slot, this.spoiledItem.copy());
		}

		if (isFrozen(stack) && slot >= 0)
		{
			setFrozen(stack, false);
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		boolean frozen = isFrozen(stack);

		if (getUpdateTicks(stack) >= 0)
		{
			int seconds = (int) ((this.foodType.getMaxSpoiling() - getUpdateTicks(stack)) / 20);
			list.add(EnumChatFormatting.RED + "Spoils in: " + seconds + " Seconds");
			if (frozen)
			{
				list.add(EnumChatFormatting.BLUE + "Frozen");
			}
			if (!frozen)
			{
				list.add(EnumChatFormatting.BLUE + "Not Frozen");
			}
		}
	}

}