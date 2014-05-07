package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;

public class ItemCookedLambchop extends MItemFood
{
	
	public ItemCookedLambchop(int healAmt, float sat)
	{
		super(healAmt, sat);
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack.stackSize <= 0 ? new ItemStack(EMDItems.animalBones) : par1ItemStack;
	}
	
}
