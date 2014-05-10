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
		this.setMaxStackSize(16);
		this.setCreativeTab(EOItems.tabOresItems);
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
}
