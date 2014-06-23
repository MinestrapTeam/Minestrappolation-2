package minestrapteam.minestrappolation.item;

import minestrapteam.minestrap_core.item.MCItem;
import minestrapteam.minestrappolation.entity.EntityHangGlider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHangGlider extends MCItem
{
	public ItemHangGlider()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(25);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{
			stack.stackSize -= 1;
		}
		if (!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityHangGlider(world, player));
		}
		return stack;
	}
}
