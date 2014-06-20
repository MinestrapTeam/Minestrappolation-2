package minestrapteam.minestrappolation.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmuletPullum extends ItemAmulet
{
	public ItemAmuletPullum()
	{
		super(50);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (world.isRemote)
		{
			return;
		}
		
		EntityPlayer player = (EntityPlayer) entity;
		if (player.getRNG().nextFloat() < 0.33F && player.isAirBorne && player.motionY > 1.2)
		{
			player.fallDistance = 0;
			stack.damageItem(1, player);
		}
	}
}
