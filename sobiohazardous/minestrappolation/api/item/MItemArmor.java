package sobiohazardous.minestrappolation.api.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MItemArmor extends ItemArmor
{
	private String layer1;
	private String layer2;
	
	public MItemArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String layer1, String layer2) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.layer1 = layer1;
		this.layer2 = layer2;
		this.setCreativeTab(EOItemManager.tabOresItems);
	}

	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	
	public String getArmorTexture(ItemStack par1, Entity entity, int slot, int layer)
	{
		if(layer==1)
		{
			return "minestrappolation:armor/" + layer1 + ".png";
		}
		else
		{
			return "minestrappolation:armor/" + layer2 + ".png";
		}
	}
}
