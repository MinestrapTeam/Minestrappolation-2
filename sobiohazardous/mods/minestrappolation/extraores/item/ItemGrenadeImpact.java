package sobiohazardous.mods.minestrappolation.extraores.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;

public class ItemGrenadeImpact extends Item
{
	public ItemGrenadeImpact()
	{
		super();
		this.maxStackSize = 16;
		this.setCreativeTab(EOItemManager.tabOresItems);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			--par1ItemStack.stackSize;
		}

		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityGrenadeImpact(par2World, par3EntityPlayer));
		}

		return par1ItemStack;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.RED + "WIP");
	}

}
