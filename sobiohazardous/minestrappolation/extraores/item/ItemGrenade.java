package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenade;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends Item
{
    public static String texture = "Minestrappolation:item_NukeGrenade";
	public ItemGrenade(int par1)
    {
        super(par1);
        this.maxStackSize = 16;
        this.setCreativeTab(ExtraOres.tabOresItems);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityGrenade(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
    
    public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon(texture);
	}
}
