package com.minestrappolation.item;

import java.util.List;

import com.minestrappolation.core.item.MCItemSword;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemPoisonSword extends MCItemSword
{
	private Item	normalSword;
	
	public ItemPoisonSword(ToolMaterial material, Item normalSword)
	{
		super(material, null);
		this.normalSword = normalSword;
	}
	
	public static float getPoisonLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getFloat("PoisonLevel");
		}
		return 4F;
	}
	
	public static void setPoisonLevel(ItemStack stack, float level)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setFloat("PoisonLevel", level);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		float level = getPoisonLevel(stack);
		if (level > 0)
		{
			entity.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
			level -= 0.5F;
			setPoisonLevel(stack, level);
		}
		
		if (level == 0F)
		{
			EntityPlayer player = (EntityPlayer) attacker;
			// changes the current item?
			player.inventory.func_70439_a(this.normalSword, 0);
		}
		
		stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		super.addInformation(stack, player, list, flag);
		list.add(I18n.getString("item.poisonSword.desc", getPoisonLevel(stack)));
	}
}
