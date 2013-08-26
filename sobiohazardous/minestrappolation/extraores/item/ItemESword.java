package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import sobiohazardous.minestrappolation.extraores.ExtraOres;

public class ItemESword extends ItemSword
{
	private String texture;
    private final EnumToolMaterial toolMaterial;

	public ItemESword(int par1, String texture, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		this.texture = "extraores:" + texture;
        this.toolMaterial = par2EnumToolMaterial;
        this.setCreativeTab(ExtraOres.tabOresItems);
        this.setCreativeTab(null);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon(texture);
	}
	
	/**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(this.toolMaterial == ExtraOres.toolMaterialBlazium)
    	{
    		par2EntityLivingBase.setFire(10);
    	}
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

}
