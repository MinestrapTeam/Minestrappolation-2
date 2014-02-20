package sobiohazardous.minestrappolation.extramobdrops.item;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import sobiohazardous.minestrappolation.api.item.MItem;

public class ItemAmuletVaccam extends MItem
{
	Random rand = new Random();

	public ItemAmuletVaccam(int id) 
	{
		super(id);
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
	}
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	EntityPlayer player = (EntityPlayer)par2EntityLivingBase;
    	//not a crit
    	if(par2EntityLivingBase.attackEntityFrom(DamageSource.generic, 1.0F))
    	{
    		if(1 + rand.nextInt(10) < 3)
    		{
    			player.onCriticalHit(par3EntityLivingBase);
				par1ItemStack.damageItem(1, player);
    		}
    	}
    	
    	return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
