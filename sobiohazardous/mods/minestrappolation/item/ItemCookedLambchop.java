package sobiohazardous.mods.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MCItemFood;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;

public class ItemCookedLambchop extends MCItemFood
{
	public ItemCookedLambchop(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onEaten(stack, world, player);
		return stack.stackSize <= 0 ? new ItemStack(EMDItems.animalBones) : stack;
	}
	
}
