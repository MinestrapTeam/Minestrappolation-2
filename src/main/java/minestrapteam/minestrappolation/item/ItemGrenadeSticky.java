package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.entity.EntityGrenadeSticky;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenadeSticky extends ItemGrenade
{
	public ItemGrenadeSticky()
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
			world.spawnEntityInWorld(new EntityGrenadeSticky(world, player));
		}
		
		return stack;
	}
}
