package sobiohazardous.minestrappolation.api.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class MItemSword extends ItemSword
{
	private boolean ignitesMob;
    private final EnumToolMaterial toolMaterial;

	public MItemSword(int par1, EnumToolMaterial par2EnumToolMaterial, boolean ignitesMob) 
	{
		super(par1, par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.ignitesMob = ignitesMob;
        this.setCreativeTab(null);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	
	/**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(ignitesMob)
    	{
    		par2EntityLivingBase.setFire(10);
    	}
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

}
