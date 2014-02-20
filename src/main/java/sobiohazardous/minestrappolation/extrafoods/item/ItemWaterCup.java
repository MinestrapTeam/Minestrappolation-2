package sobiohazardous.minestrappolation.extrafoods.item;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.world.World;

public class ItemWaterCup extends Item
{
	
	public ItemWaterCup(int par1)
    {
        super(par1);
        this.setCreativeTab(ExtraFoods.tabItems);
    }
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("crazyfoods:glass_water");
	}

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            par3EntityPlayer.curePotionEffects(par1ItemStack);
        }
        return par1ItemStack.stackSize <= 0 ? new ItemStack(ExtraFoods.cupGlass) : par1ItemStack;
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
