package com.minestrappolation.item;

import java.util.List;

import com.minestrappolation.entity.EntityGrenade;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemGrenadeImpact extends Item
{
	public ItemGrenadeImpact()
	{
		super();
		this.setMaxStackSize(16);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			if (!player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}
			
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.spawnEntityInWorld(new EntityGrenade(world, player));
		}
		
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.RED + "WIP");
	}
	
}
