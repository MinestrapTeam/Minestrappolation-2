package sobiohazardous.minestrappolation.extradecor.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ItemMulti extends Item
{
    private final String[] types;
    private IIcon[] field_150920_d;

    public ItemMulti(String[] textures)
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.types = textures;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int par1)
    {
        int var2 = MathHelper.clamp_int(par1, 0, 15);
        return this.field_150920_d[var2];
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, types.length - 1);
        return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
    }

    /**
     * This returns the sub items
     */
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
    {
        for (int var4 = 0; var4 < types.length; ++var4)
        {
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, var4));
        }
    }

    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_150920_d = new IIcon[types.length];

        for (int var2 = 0; var2 < types.length; ++var2)
        {
            this.field_150920_d[var2] = par1IconRegister.registerIcon(this.getIconString() + "_" + types[var2]);
        }
    }
}
