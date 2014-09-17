package minestrapteam.minestrappolation.item;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemFood extends ItemFood
{
	public static enum FoodType
	{
		BAKED(600, false), RAW_MEAT(1000, false), COOKED_MEAT(2000, true), RAW_FISH(400, false), COOKED_FISH(800, true), VEGETABLE(1200, false), COOKED_VEGETABLE(1600, false), FRUIT(1000, false), MISC(600, false);
		
		private int		maxSpoiling;
		private boolean	isCooked;
		private int	poisonDuration = 20 * 45;
		
		private FoodType(int maxSpoiling, boolean cooked)
		{
			this.maxSpoiling = maxSpoiling;
			this.isCooked = cooked;
		}
		
		public boolean isCooked()
		{
			return this.isCooked;
		}
		
		public int getMaxSpoiling()
		{
			return this.maxSpoiling;
		}
		
		public boolean isWolfMeat()
		{
			return this == RAW_MEAT || this == COOKED_MEAT;
		}
		
		public boolean isFriable()
		{
			return this == COOKED_MEAT || this == COOKED_FISH || this == VEGETABLE || this == FRUIT;
		}
		
		public void setPoisonDuration(int duration)
		{
			this.poisonDuration = duration;
		}
	}
	
	public FoodType	foodType;
	
	public IIcon	spoiledIcon;
	public IIcon	friedIcon;
	
	//public boolean	spoiled = false;
	
	public MItemFood(FoodType type, int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, type.isWolfMeat());
		this.foodType = type;
	}
	
	public FoodType getType(ItemStack stack)
	{
		return this.foodType;
	}
	
	public static boolean isFried(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getBoolean("Fried");
		}
		return false;
	}
	
	public static void setFried(ItemStack stack, boolean fried)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setBoolean("Fried", fried);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.iconString);
		this.spoiledIcon = iconRegister.registerIcon(this.iconString + "_spoiled");
		if (this.foodType.isFriable())
		{
			this.friedIcon = iconRegister.registerIcon(this.iconString + "_fried");
		}
	}
	
	@Override
	public IIcon getIconIndex(ItemStack stack)
	{
		if (isFried(stack))
		{
			return this.friedIcon;
		}
		if (stack.getTagCompound() != null && stack.getTagCompound().getInteger("spoiled") == 1)
		{
			return this.spoiledIcon;
		}
		return this.itemIcon;
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass)
	{
		return this.getIconIndex(stack);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if (isFried(stack))
		{
			player.getFoodStats().addStats(3, 0.05F);
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 15, 0));
		}
		
		if (stack.getTagCompound().getInteger("spoiled") == 1)
		{
			player.addPotionEffect(new PotionEffect(Potion.poison.id, foodType.poisonDuration, 0));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		StringBuilder builder = new StringBuilder();
		
		if (isFried(stack))
		{
			builder.append(I18n.getString("item.food.fried")).append(' ');
		}
		if (stack.getTagCompound() != null && stack.getTagCompound().getInteger("spoiled") == 1)
		{
			builder.append(I18n.getString("item.food.spoiled")).append(' ');
		}
		builder.append(I18n.getString(this.getUnlocalizedName(stack) + ".name"));
		
		return builder.toString();
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
		return stack.hasTagCompound() && stack.getTagCompound().getInteger("frozen") != 0;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.setTagInfo("updateTicks", new NBTTagLong(0L));
		stack.setTagInfo("lastDimension", new NBTTagInt(player.dimension));
		stack.setTagInfo("lastWorldTime", new NBTTagLong(world.getTotalWorldTime()));
		//0 Not spoiled, 1 spoiled. I guess no boolean tag?
		stack.setTagInfo("spoiled", new NBTTagInt(0));
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
		if (extraTicks > 0 && stack.getTagCompound().getInteger("spoiled") == 0)
		{
			ticks += extraTicks;
			setUpdateTicks(stack, ticks);
		}
		
		if (ticks >= this.foodType.getMaxSpoiling())
		{
			stack.setTagInfo("spoiled", new NBTTagInt(1));
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

		if (getUpdateTicks(stack) >= 0 && stack.getTagCompound() != null)
		{
			int seconds = (int) ((this.foodType.getMaxSpoiling() - getUpdateTicks(stack)) / 20);
			if(stack.getTagCompound().getInteger("spoiled") == 0)
			{
				list.add(EnumChatFormatting.RED + "Spoils in: " + seconds + " Seconds");
			}
			else if(stack.getTagCompound().getInteger("spoiled") == 1)
			{
				list.add(EnumChatFormatting.RED + "Spoiled.");
			}
			if (frozen)
			{
				list.add(EnumChatFormatting.BLUE + "Frozen");
			}
			else if (!frozen)
			{
				list.add(EnumChatFormatting.BLUE + "Not Frozen");
			}
		}			
	}

}
