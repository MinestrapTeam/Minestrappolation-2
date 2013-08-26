package sobiohazardous.minestrappolation.extramobdrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public final class CreativeTabExtraMobDropsItems extends CreativeTabs
{
        public CreativeTabExtraMobDropsItems(int par1, String par2Str)
        {
                super(par1, par2Str);
        }
        
        
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
                return ExtraMobDrops.pigHoof.itemID;
        }
       
   
        public String getTranslatedTabLabel()
        {
         return "Extrappolated Mob Drops - Items";
        }
}