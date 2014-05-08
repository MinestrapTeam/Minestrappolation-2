package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;

public class ItemCalimari extends MItemFood
{
	public ItemCalimari(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.heal(2F);
		super.onEaten(stack, world, player);
		return super.onEaten(stack, world, player);
	}
	
}
