package minestrapteam.minestrappolation.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmuletPorcum extends ItemAmulet
{
	private int	tick	= 0;
	
	public ItemAmuletPorcum()
	{
		super(50);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (!world.isRemote && flag && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			this.tick++;
			if (this.tick > 120)
			{
				this.tick = 0;
			}
			else if (this.tick > 60 && player.getRNG().nextInt(61) > 59)
			{
				this.tick = 0;
				if (player.getFoodStats().needFood())
				{
					player.getFoodStats().addStats(1, 0F);
					stack.damageItem(1, player);
				}
			}
		}
	}
}
