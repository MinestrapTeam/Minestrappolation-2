package sobiohazardous.minestrappolation.extraores.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class ItemSoulBottle extends Item
{
	public ItemSoulBottle()
	{
		super();
		this.setCreativeTab(EOItemManager.tabOresItems);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par2EntityPlayer)
	{
		if (par2EntityPlayer.experienceTotal >= 20)
		{
			par2EntityPlayer.addExperience(-20);
			--par1ItemStack.stackSize;

			if (par1ItemStack.stackSize <= 0)
			{
				return new ItemStack(Items.experience_bottle);
			}

			if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.experience_bottle)))
			{
				par2EntityPlayer.dropItem(Items.experience_bottle, 1);
			}
		}
		System.out.println(par2EntityPlayer.experience);
		return par1ItemStack;

	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.RED + "WIP");
	}

}