package minestrapteam.minestrappolation.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
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
	public static enum FoodType
	{
		BAKED(600, false), 
		RAW_MEAT(1000, false), 
		COOKED_MEAT(2000, true), 
		RAW_FISH(400, false), 
		COOKED_FISH(800, true), 
		VEGETABLE(1200, false), 
		COOKED_VEGETABLE(1600, false), 
		FRUIT(1000, false),
		MISC(600, false);
		
		private int		ticksToSpoil;
		private boolean	isCooked;
		
		private FoodType(int ticksToSpoil, boolean cooked)
		{
			this.ticksToSpoil = ticksToSpoil;
			this.isCooked = cooked;
		}
		
		public boolean isCooked()
		{
			return this.isCooked;
		}
		
		public int getTicksToSpoils()
		{
			return this.ticksToSpoil;
		}
		
		public boolean isWolfMeat()
		{
			return this == RAW_MEAT || this == COOKED_MEAT;
		}
		
		public boolean isFriable()
		{
			return this == COOKED_MEAT || this == COOKED_FISH || this == VEGETABLE || this == FRUIT;
		}
	}
	
	private ItemStack spoiledItem;
	
	private FoodType foodType;
	
	public ItemFoodSpoilable(FoodType type, int healAmount, float saturation, ItemStack spoiledItem)
	{
		super(healAmount, saturation, type.isWolfMeat());
		this.spoiledItem = spoiledItem;

		this.setMaxStackSize(1);
	}

	public static void setFrozen(ItemStack par1ItemStack, boolean frozen)
	{
		boolean flag = isFrozen(par1ItemStack);
		if (flag ^ frozen)
		{
			setUpdateTicks(par1ItemStack, 0L);
		}
		par1ItemStack.setTagInfo("frozen", new NBTTagByte(frozen ? (byte) 1 : (byte) 0));
	}

	public static boolean isFrozen(ItemStack par1ItemStack)
	{
		return par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().getByte("frozen") != 0;
	}

	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par1ItemStack.setTagInfo("updateTicks", new NBTTagLong(0L));
		par1ItemStack.setTagInfo("lastDimension", new NBTTagInt(par3EntityPlayer.dimension));
		par1ItemStack.setTagInfo("lastWorldTime", new NBTTagLong(par2World.getTotalWorldTime()));
	}

	public static long getUpdateTicks(ItemStack par1ItemStack)
	{
		return par1ItemStack.hasTagCompound() ? par1ItemStack.getTagCompound().getLong("updateTicks") : 0L;
	}

	public static void setUpdateTicks(ItemStack par1ItemStack, long ticks)
	{
		par1ItemStack.setTagInfo("updateTicks", new NBTTagLong(ticks));
	}

	public static long incrementTick(ItemStack par1ItemStack)
	{
		long ticks = getUpdateTicks(par1ItemStack);
		setUpdateTicks(par1ItemStack, ++ticks);
		return ticks;
	}

	public static long getExtraTicks(ItemStack par1ItemStack, World par2World, int dimension)
	{
		long extraTicks = 0L;
		NBTTagCompound tagCompound = par1ItemStack.getTagCompound();
		if (tagCompound != null)
		{
			if (tagCompound.hasKey("lastDimension") && tagCompound.hasKey("lastWorldTime") && tagCompound.getInteger("lastDimension") == dimension)
			{
				extraTicks = par2World.getTotalWorldTime() - tagCompound.getLong("lastWorldTime");
			}
		}
		par1ItemStack.setTagInfo("lastDimension", new NBTTagInt(dimension));
		par1ItemStack.setTagInfo("lastWorldTime", new NBTTagLong(par2World.getTotalWorldTime()));
		return extraTicks;
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!(par3Entity instanceof EntityPlayer))
		{
			return;
		}

		boolean frozen = isFrozen(par1ItemStack);
		long ticks = !frozen || par2World.rand.nextInt(20) == 0 ? incrementTick(par1ItemStack) : getUpdateTicks(par1ItemStack);
		long extraTicks = getExtraTicks(par1ItemStack, par2World, par3Entity.dimension);
		if (frozen)
			extraTicks /= 20L;
		if (extraTicks > 0)
		{
			ticks += extraTicks;
			setUpdateTicks(par1ItemStack, ticks);
		}
		
		if (ticks >= foodType.getTicksToSpoils())
		{
			EntityPlayer player = (EntityPlayer) par3Entity;
			IInventory inventory = player.inventory;
			inventory.setInventorySlotContents(par4, this.spoiledItem.copy());
		}

		if (this.isFrozen(par1ItemStack) && par4 >= 0)
		{
			this.setFrozen(par1ItemStack, false);
		}
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		boolean frozen = isFrozen(par1ItemStack);

		if (getUpdateTicks(par1ItemStack) >= 0)
		{
			par3List.add(EnumChatFormatting.RED + "Spoils in: " + Integer.toString(((int)foodType.getTicksToSpoils()/20) - ((int)getUpdateTicks(par1ItemStack)/20)) + " Seconds");
			if (frozen)
			{
				par3List.add(EnumChatFormatting.BLUE + "Frozen");
			}
			if (!frozen)
			{
				par3List.add(EnumChatFormatting.BLUE + "Not Frozen");
			}
		}
	}

}