package minestrapteam.minestrappolation.item;

import clashsoft.cslib.random.CSRandom;
import minestrapteam.minestrappolation.lib.MPotions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGhastTentacle extends MItemFood
{
	public ItemGhastTentacle()
	{
		super(0, 0F);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		
		int seconds = CSRandom.nextInt(player.getRNG(), 30, 180);
		player.addPotionEffect(new PotionEffect(MPotions.ghastTentaclePotion.id, seconds * 20, 0));
	}
}
