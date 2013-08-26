package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.src.*;

public class EOItem extends Item
{
       	private String itemTexture;
       
		public EOItem(int i, String texture)
        {
                super(i);
                this.setCreativeTab(ExtraOres.tabOresItems);
                this.itemTexture = "Minestrappolation:" + texture;
        }
		
		public void registerIcons(IconRegister iconRegister)
		{
		         itemIcon = iconRegister.registerIcon(itemTexture);
		}
}