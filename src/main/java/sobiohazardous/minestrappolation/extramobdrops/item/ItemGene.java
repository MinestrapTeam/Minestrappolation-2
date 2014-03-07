package sobiohazardous.minestrappolation.extramobdrops.item;

import java.util.List;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ItemGene extends Item
{
    public static final String[] geneNames = new String[] {"pig", "cow", "chicken", "sheep", "horse", "mooshroom", "squid", "ocelot", "wolf", "bat"};
    @SideOnly(Side.CLIENT)
    private IIcon[] geneIcons;

	public ItemGene() 
	{
		super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(EMDItemManager.tabItems);	
	}
	
	public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 9);
        return this.geneIcons[j];
    }
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 9);
        return super.getUnlocalizedName() + "." + geneNames[i];
    }
	
	/**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 10; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.geneIcons = new IIcon[geneNames.length];

        for (int i = 0; i < geneNames.length; ++i)
        {
            this.geneIcons[i] = par1IconRegister.registerIcon("Minestrappolation:" + geneNames[i] + "_" + this.getUnlocalizedName().substring(5));
        }
    }
}
