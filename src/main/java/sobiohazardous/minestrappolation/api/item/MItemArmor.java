package sobiohazardous.minestrappolation.api.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MItemArmor extends ItemArmor
{	
	public MItemArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(null);
	}
	
	/*
	public void registerIcons(IIconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	*/
	
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
        return "minestrappolation:armor/"+material+"_layer_"+layer+type+".png";
	}
}
