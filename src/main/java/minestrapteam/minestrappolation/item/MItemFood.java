package minestrapteam.minestrappolation.item;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemFood extends ItemFood
{
	public static enum FoodType
	{
		BAKED(600, false), RAW_MEAT(1000, false), COOKED_MEAT(2000, true), RAW_FISH(400, false), COOKED_FISH(800, true), VEGETABLE(1200, false), COOKED_VEGETABLE(1600, false), FRUIT(1000, false), MISC(600, false);
		
		private int		maxSpoiling;
		private boolean	isCooked;
		
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
	
	public static boolean isFried(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getBoolean("Fried");
		}
		return false;
	}
	
	public static int getSpoilingLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getInteger("Spoiling");
		}
		return 0;
	}
	
	public static void setFried(ItemStack stack, boolean fried)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setBoolean("Fried", fried);
	}
	
	public static void setSpoilingLevel(ItemStack stack, int spoiling)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setInteger("Spoiling", spoiling);
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
		if (getSpoilingLevel(stack) >= this.getMaxDamage(stack))
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
	public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public int getDisplayDamage(ItemStack stack)
	{
		return getSpoilingLevel(stack);
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return this.foodType.getMaxSpoiling();
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		int spoiling = getSpoilingLevel(stack);
		if (spoiling < this.getMaxDamage(stack))
		{
			setSpoilingLevel(stack, ++spoiling);
		}
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
		
		int spoiling = getSpoilingLevel(stack);
		int maxSpoiling = this.getMaxDamage(stack);
		int duration = spoiling - maxSpoiling;
		
		if (duration > 0)
		{
			duration /= 2;
			int amplifier = 0;
			if (duration >= 60)
			{
				amplifier = duration / 60;
				duration = 60;
			}
			player.addPotionEffect(new PotionEffect(Potion.poison.id, duration, amplifier));
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
		if (getSpoilingLevel(stack) > this.getMaxDamage(stack))
		{
			builder.append(I18n.getString("item.food.spoiled")).append(' ');
		}
		builder.append(I18n.getString(this.getUnlocalizedName(stack) + ".name"));
		
		return builder.toString();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (isFried(stack))
		{
			list.add("\u00a76" + I18n.getString("item.food.fried"));
		}
	}
}
