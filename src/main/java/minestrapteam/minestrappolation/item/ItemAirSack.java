package minestrapteam.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAirSack extends MItemFood
{
	public ItemAirSack()
	{
		super(FoodType.MISC, 0, 0);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if (player.isInWater())
		{
			if (player.getAir() <= 540)
			{
				player.setAir(player.getAir() + 120);
			}
			else
			{
				player.setAir(660);
			}
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isInWater())
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
}
