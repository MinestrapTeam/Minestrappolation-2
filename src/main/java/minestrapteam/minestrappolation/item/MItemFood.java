package minestrapteam.minestrappolation.item;

import java.util.List;

import clashsoft.cslib.minecraft.CSLib;
import clashsoft.cslib.minecraft.lang.I18n;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.lib.MConfig;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class MItemFood extends ItemFood
{
	private static int	HOURS	= 1000;
	private static int	DAYS	= 24000;
	
	public static enum FoodType
	{
		BAKED(3 * DAYS, false), RAW_MEAT(1 * DAYS, false), COOKED_MEAT(3 * DAYS, true), RAW_FISH(18 * HOURS, false), COOKED_FISH(2 * DAYS, true), VEGETABLE(4 * DAYS, false), COOKED_VEGETABLE(5 * DAYS, false), FRUIT(4 * DAYS, false), MISC(0, false);
		
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
		
		public boolean isSpoilable()
		{
			return this != MISC;
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
	
	public FoodType getFoodType(ItemStack stack)
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
		if (this.getFoodType(stack).isSpoilable())
		{
			return getSpoilTime(stack, world) >= this.getFoodType(stack).getMaxSpoiling();
		}
		return false;
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
		if (this.getFoodType(stack).isSpoilable() && MConfig.foodSpoiling)
		{
			if (stack.stackTagCompound == null)
			{
				stack.stackTagCompound = new NBTTagCompound();
			}
			else if (stack.stackTagCompound.hasKey("SpoilTime"))
			{
				return;
			}
			
			long l = MConfig.spoilTimeRounding * 20;
			long t = (world.getTotalWorldTime() / l) * l;
			stack.stackTagCompound.setLong("SpoilTime", t);
		}
	}
	
	// ICONS
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.iconString);
		if (this.foodType.isSpoilable())
		{
			this.spoiledIcon = iconRegister.registerIcon(this.iconString + "_spoiled");
		}
		if (this.foodType.isFriable())
		{
			this.friedIcon = iconRegister.registerIcon(this.iconString + "_fried");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack)
	{
		if (isFried(stack))
		{
			return this.getFriedIcon(stack);
		}
		if (this.isSpoiled(stack, CSLib.proxy.getClientWorld()))
		{
			return this.getSpoiledIcon(stack);
		}
		return this.getFoodIcon(stack);
	}
	
	public IIcon getFoodIcon(ItemStack stack)
	{
		return this.itemIcon;
	}
	
	public IIcon getFriedIcon(ItemStack stack)
	{
		return this.friedIcon;
	}
	
	public IIcon getSpoiledIcon(ItemStack stack)
	{
		return this.spoiledIcon;
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
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 0));
		}
		
		if (this.isSpoiled(stack, world))
		{
			player.addPotionEffect(new PotionEffect(Potion.poison.id, this.getFoodType(stack).poisonDuration, 0));
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
		if (this.foodType.isSpoilable())
		{
			int ticks = (int) (this.getFoodType(stack).getMaxSpoiling() - getSpoilTime(stack, player.worldObj));
			if (ticks > 0)
			{
				list.add(I18n.getString("item.food.spoiling", StringUtils.ticksToElapsedTime(ticks)));
			}
			else
			{
				list.add(I18n.getString("item.food.spoiled"));
			}
		}
		
		if (isFrozen(stack))
		{
			list.add(I18n.getString("item.food.frozen"));
		}
	}
	
	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	{
		super.onEaten(item, world, player);
		if (this == Items.mushroom_stew)
		{
			return new ItemStack(Items.bowl);
		}
		return item;
	}
}
