package sobiohazardous.minestrappolation.extramobdrops.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sobiohazardous.minestrappolation.api.item.MItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemCharm extends Item
{
    public static final String[] geneNames = new String[] {"pig", "cow", "chicken", "sheep", "horse"};
    @SideOnly(Side.CLIENT)
    private Icon[] geneIcons;
    
	public ItemCharm(int par1) 
	{
		super(par1);
	}
	
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 4);
        return this.geneIcons[j];
    }
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 4);
        return super.getUnlocalizedName() + "." + geneNames[i];
    }
	
	/**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 5; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.geneIcons = new Icon[geneNames.length];

        for (int i = 0; i < geneNames.length; ++i)
        {
            this.geneIcons[i] = par1IconRegister.registerIcon("Minestrappolation:" + geneNames[i] + "_" + this.getUnlocalizedName().substring(5));
        }
    }
}
