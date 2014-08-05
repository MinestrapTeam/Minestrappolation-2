package minestrapteam.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCalimari extends MItemFood
{
	public float healBonus;
	public ItemCalimari(int healAmount, float saturationModifier)
	{
		super(healAmount, saturationModifier);
		
	}
	
	public ItemCalimari setHealBonus(float healBonus)
	{
		this.healBonus = healBonus;
		return this;
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.heal(this.healBonus);
		return super.onEaten(stack, world, player);
	}
	
}
