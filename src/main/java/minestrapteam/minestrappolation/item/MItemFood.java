package minestrapteam.minestrappolation.item;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemFood extends ItemFood
{
	public IIcon	spoiledIcon;
	public IIcon	friedIcon;
	
	public MItemFood(int healAmount, float saturationModifier)
	{
		this(healAmount, saturationModifier, false);
	}
	
	public MItemFood(int healAmount, float saturationModifier, boolean wolfMeat)
	{
		super(healAmount, saturationModifier, wolfMeat);
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
		this.friedIcon = iconRegister.registerIcon(this.iconString + "_fried");
		this.spoiledIcon = iconRegister.registerIcon(this.iconString + "_spoiled");
	}
	
	@Override
	public IIcon getIconIndex(ItemStack stack)
	{
		if (isFried(stack))
		{
			return this.friedIcon;
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
		}
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
