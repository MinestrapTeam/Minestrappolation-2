package sobiohazardous.mods.minestrappolation.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

public class ItemSoulBottle extends Item
{
	public ItemSoulBottle()
	{
		super();
		this.setCreativeTab(EOItems.tabOresItems);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.experienceTotal >= 20)
		{
			player.addExperience(-20);
			--stack.stackSize;
			
			if (stack.stackSize <= 0)
			{
				return new ItemStack(Items.experience_bottle);
			}
			else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.experience_bottle)))
			{
				player.dropItem(Items.experience_bottle, 1);
			}
		}
		return stack;
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.RED + "WIP");
	}
	
}