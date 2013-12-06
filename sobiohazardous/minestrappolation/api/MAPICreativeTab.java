package sobiohazardous.minestrappolation.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public final class MAPICreativeTab extends CreativeTabs
{
       	public MAPICreativeTab(int par1, String par2Str)
        {
                super(par1, par2Str);
        }
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
                return Item.potion.itemID;
        }
   
        public String getTranslatedTabLabel()
        {
         return "MAPI";
        }
}