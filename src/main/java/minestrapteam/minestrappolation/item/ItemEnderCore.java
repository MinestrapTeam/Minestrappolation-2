package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MPotions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEnderCore extends MItemFood
{
	public ItemEnderCore(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
		this.setMaxStackSize(16);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 30 * 20, 0));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 2));
		player.addPotionEffect(new PotionEffect(MPotions.hydrophobiaPotion.id, 30 * 20, 0));
		
		super.onFoodEaten(stack, world, player);
	}
	
}
