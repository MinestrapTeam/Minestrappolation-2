package sobiohazardous.minestrappolation.extramobdrops.item;

import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class EMDItemFood extends ItemFood
{
	private String texture;
	public EMDItemFood(int id, int healAmt, float sat, String texture)
	{
		super(id, healAmt, sat, false);
		this.texture = texture;
		this.setCreativeTab(ExtraMobDrops.tabItems);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
}
