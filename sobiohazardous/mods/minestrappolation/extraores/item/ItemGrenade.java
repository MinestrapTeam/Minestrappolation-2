package sobiohazardous.mods.minestrappolation.extraores.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

public class ItemGrenade extends Item
{
	public ItemGrenade()
	{
		super();
		this.maxStackSize = 16;
		this.setCreativeTab(EOItems.tabOresItems);
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			--par1ItemStack.stackSize;
		}
		
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityGrenade(par2World, par3EntityPlayer));
		}
		
		return par1ItemStack;
	}
	
}
