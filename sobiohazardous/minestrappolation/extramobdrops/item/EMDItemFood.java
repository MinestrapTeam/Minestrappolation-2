package sobiohazardous.minestrappolation.extramobdrops.item;

import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class EMDItemFood extends ItemFood
{
	public EMDItemFood(int id, int healAmt, float sat)
	{
		super(id, healAmt, sat, false);
		this.setCreativeTab(ExtraMobDrops.tabItems);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
}
