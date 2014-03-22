package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EOItemArmor extends ItemArmor
{
	private int tick = 0;
	
	public EOItemArmor(ArmorMaterial armorMat, int p_i45325_2_, int p_i45325_3_)
	{
		super(armorMat, p_i45325_2_, p_i45325_3_);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
        //slot will tell us helmet vs. boots
        //type will be either null or overlay (cloth armor)
        //can use stack.stackTagCompound.getString("matName") for material, etc.
        String layer = "1";
        String material = stack.stackTagCompound.getString("matName").toLowerCase();
        if(type == null) 
        {
        	type = "";
            material = "iron";
        }
        if(slot == 2) 
        {
        	layer="2";
        }
        return MAssetManager.getEOTexture("/"+material+"_layer_"+layer+type+".png");
	}
}
