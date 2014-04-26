package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;

public class ItemCookedLambchop extends MItemFood
{

	public ItemCookedLambchop(int healAmt, float sat) 
	{
		super(healAmt, sat);
	}
	
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
        return par1ItemStack.stackSize <= 0 ? new ItemStack(EMDItemManager.animalBones) : par1ItemStack;
    }

}
