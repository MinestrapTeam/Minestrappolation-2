package com.minestrappolation.item;

import com.minestrappolation_core.util.MCAssetManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemHorseHairBow extends ItemBow
{
	protected IIcon[]	iconArray;
	
	public ItemHorseHairBow()
	{
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		String texture = MCAssetManager.getTexture("horseHairBow");
		this.itemIcon = iconRegister.registerIcon(texture);
		this.iconArray = new IIcon[3];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(texture + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (player.getItemInUse() == null)
		{
			return this.itemIcon;
		}
		int pull = stack.getMaxItemUseDuration() - useRemaining;
		if (pull >= 18)
		{
			return this.iconArray[2];
		}
		else if (pull > 13)
		{
			return this.iconArray[1];
		}
		else if (pull > 0)
		{
			return this.iconArray[0];
		}
		return this.iconArray[0];
	}
}
