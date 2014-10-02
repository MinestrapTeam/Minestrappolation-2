package minestrapteam.minestrappolation.item.mob;

import minestrapteam.minestrappolation.item.MItemFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCatEye extends MItemFood
{
	public ItemCatEye(int healAmount, float saturationModifier)
	{
		super(FoodType.MISC, healAmount, saturationModifier);
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 45 * 20, 0));
		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10 * 20, 0));
	}
}
