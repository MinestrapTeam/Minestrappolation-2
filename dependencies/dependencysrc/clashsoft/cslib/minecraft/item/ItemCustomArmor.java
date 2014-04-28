package clashsoft.cslib.minecraft.item;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCustomArmor extends ItemArmor
{
	public ItemCustomArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType & 3);
		CSReflection.setValue(ItemArmor.class, this, armorType, 4);
		CSReflection.setValue(ItemArmor.class, this, this.getDamageReductionAmount(material), 5);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
	}
	
	public int getDamageReductionAmount(ArmorMaterial material)
	{
		return material.getDamageReductionAmount(this.armorType & 3);
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == this.armorType;
	}
}
