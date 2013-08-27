package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class EOItem extends Item
{
       	private String itemTexture;
       
		public EOItem(int i, String texture)
        {
                super(i);
                this.setCreativeTab(EOItemManager.tabOresItems);
                this.itemTexture = "Minestrappolation:" + texture;
        }
		
		public void registerIcons(IconRegister iconRegister)
		{
		         itemIcon = iconRegister.registerIcon(itemTexture);
		}
}