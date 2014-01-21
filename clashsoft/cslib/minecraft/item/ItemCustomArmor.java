package clashsoft.cslib.minecraft.item;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCustomArmor extends ItemArmor
{
	public ItemCustomArmor(int itemID, EnumArmorMaterial material, int renderIndex, int armorType)
	{
		super(itemID, material, renderIndex, armorType & 3);
		CSReflection.setValue(ItemArmor.class, this, armorType, 4);
		CSReflection.setValue(ItemArmor.class, this, getDamageReductionAmount(material), 5);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
	}
	
	public int getDamageReductionAmount(EnumArmorMaterial material)
	{
		return material.getDamageReductionAmount(this.armorType & 3);
	}
	
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == this.armorType;
	}
}
