package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDPotions;

public class ItemInfectiousFungus extends MItemFood
{
	public ItemInfectiousFungus(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 1));
		player.addPotionEffect(new PotionEffect(EMDPotions.infectious.id, 30 * 20, 1));
	}
	
}
