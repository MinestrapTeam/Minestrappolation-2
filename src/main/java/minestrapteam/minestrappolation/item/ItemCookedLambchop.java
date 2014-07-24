package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCookedLambchop extends MItemFood
{
	public ItemCookedLambchop(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onEaten(stack, world, player);
		return stack.stackSize <= 0 ? new ItemStack(MItems.animalBones) : stack;
	}
	
}
