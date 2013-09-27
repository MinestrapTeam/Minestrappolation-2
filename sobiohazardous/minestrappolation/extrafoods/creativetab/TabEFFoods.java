package sobiohazardous.minestrappolation.extrafoods.creativetab;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public final class TabEFFoods extends CreativeTabs
{
        public TabEFFoods(int par1, String par2Str)
        {
                super(par1, par2Str);
        }
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
                return ExtraFoods.cakeGoldItem.itemID;
        }
   
        public String getTranslatedTabLabel()
        {
         return "Crazy Foods - Foods";
        }
}