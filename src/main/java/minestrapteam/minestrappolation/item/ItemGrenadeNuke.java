package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.entity.EntityGrenadeNuke;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenadeNuke extends ItemGrenade
{
	public ItemGrenadeNuke()
	{
		super();
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
			world.spawnEntityInWorld(new EntityGrenadeNuke(world, player));
		}
		
		return stack;
	}
}
