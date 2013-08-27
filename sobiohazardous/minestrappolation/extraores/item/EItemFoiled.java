package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EItemFoiled extends Item
{
        private String itemTexture;
		public EItemFoiled(int i, String texture)
        {
                super(i);
                this.setCreativeTab(EOItemManager.tabOresItems);
                this.itemTexture = "Minestrappolation:" + texture;
        }

        public void registerIcons(IconRegister iconRegister)
		{
		         itemIcon = iconRegister.registerIcon(itemTexture);
		}
        @SideOnly(Side.CLIENT)
        public boolean hasEffect(ItemStack par1ItemStack)
        {
            return true;
        }
}