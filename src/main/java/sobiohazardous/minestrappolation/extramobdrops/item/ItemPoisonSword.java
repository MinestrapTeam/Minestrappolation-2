package sobiohazardous.minestrappolation.extramobdrops.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import sobiohazardous.minestrappolation.api.item.MItemSword;

public class ItemPoisonSword extends MItemSword
{
	private float poisonLevel = 4;
	private Item normSword;
	
	public ItemPoisonSword(ToolMaterial par2EnumToolMaterial, Item normalSword) 
	{
		super(par2EnumToolMaterial, false);
		this.normSword = normalSword;
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(poisonLevel > 0)
    	{
    		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
    		poisonLevel-=0.5;
    	}
    	
    	if(poisonLevel == 1)
    	{
    		EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
    		//changes the current item?
    		player.inventory.func_70439_a(normSword, 0);
    	}
    	
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
    	par3List.add(EnumChatFormatting.GREEN + "Poisoned +" + (int)poisonLevel);
    }    
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
    }
}
