package minestrapteam.minestrappolation.item;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class MItemFood extends ItemFood
{
	public static enum FoodType
	{
		BAKED(600, false), RAW_MEAT(1000, false), COOKED_MEAT(2000, true), RAW_FISH(400, false), COOKED_FISH(800, true), VEGETABLE(1200, false), COOKED_VEGETABLE(1600, false), FRUIT(1000, false), MISC(600, false);
		
		private int		maxSpoiling;
		private boolean	isCooked;
		private int		poisonDuration	= 20 * 45;
		
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
	
	public MItemFood(FoodType type, int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier, type.isWolfMeat());
		this.foodType = type;
	}
	
	public FoodType getType(ItemStack stack)
	{
		return this.foodType;
	}
	
	// NBT ACCESS
	
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
	
	public static boolean isFrozen(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getBoolean("Frozen");
		}
		return false;
	}
	
	public static void setFrozen(ItemStack stack, boolean frozen)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setBoolean("Frozen", frozen);
	}
	
	public boolean isSpoiled(ItemStack stack, World world)
	{
		return getSpoilTime(stack, world) >= this.foodType.maxSpoiling;
	}
	
	public static long getSpoilTime(ItemStack stack, World world)
	{
		if (stack.stackTagCompound != null)
		{
			long l = stack.stackTagCompound.getLong("SpoilTime");
			if (l != 0)
			{
				l = world.getTotalWorldTime() - l;
				
				if (isFrozen(stack))
				{
					l /= 20L;
				}
				
				return l;
			}
		}
		return 0L;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean flag)
	{		
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		else if (stack.stackTagCompound.hasKey("SpoilTime"))
		{
			return;
		}
		
		stack.stackTagCompound.setLong("SpoilTime", world.getTotalWorldTime());
	}
	
	// ICONS
	
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
		if (this.isSpoiled(stack, Minecraft.getMinecraft().theWorld))
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
	
	// FOOD
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if (isFried(stack))
		{
			player.getFoodStats().addStats(3, 0.05F);
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 15, 0));
		}
		
		if (this.isSpoiled(stack, world))
		{
			player.addPotionEffect(new PotionEffect(Potion.poison.id, this.foodType.poisonDuration, 0));
		}
	}
	
	// TOOLTIP
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		StringBuilder builder = new StringBuilder();
		
		if (isFried(stack))
		{
			builder.append(I18n.getString("item.food.fried")).append(' ');
		}
		builder.append(I18n.getString(this.getUnlocalizedName(stack) + ".name"));
		
		return builder.toString();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		boolean frozen = isFrozen(stack);
		
		int ticks = (int) (this.foodType.maxSpoiling - getSpoilTime(stack, player.worldObj));
		if (ticks > 0)
		{
			list.add(EnumChatFormatting.GREEN + "Spoils in: " + StringUtils.ticksToElapsedTime(ticks));
		}
		else
		{
			list.add(EnumChatFormatting.DARK_GREEN + "Spoiled");
		}
		
		if (frozen)
		{
			list.add(EnumChatFormatting.BLUE + "Frozen");
		}
	}
}
