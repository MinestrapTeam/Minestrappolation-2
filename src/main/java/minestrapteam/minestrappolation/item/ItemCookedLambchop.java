package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCookedLambchop extends MItemFood
{
	public ItemCookedLambchop(FoodType type, int healAmount, float saturationModifier)
	{
		super(type, healAmount, saturationModifier);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onEaten(stack, world, player);
		if (stack.stackSize <= 0)
		{
			return new ItemStack(MItems.animalBones);
		}
		else
		{
			ItemStack stack1 = new ItemStack(MItems.animalBones);
			if (!player.inventory.addItemStackToInventory(stack1))
			{
				player.dropPlayerItemWithRandomChoice(stack1, false);
			}
			return stack;
		}
	}
}
