package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;

public class ItemEnderCore extends MItemFood
{
	public ItemEnderCore(int healAmt, float sat)
	{
		super(healAmt, sat);
		this.setMaxStackSize(16);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.invisibility.id, 30 * 20, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 2));
		// TODO Hydrophobia potion effect (no idea what that is)
		
		super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	}
	
}
