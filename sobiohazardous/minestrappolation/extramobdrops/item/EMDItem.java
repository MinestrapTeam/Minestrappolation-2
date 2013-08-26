package sobiohazardous.minestrappolation.extramobdrops.item;

import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class EMDItem extends Item
{
	private String texture;
	
	public EMDItem(int id, String texture)
	{
		super(id);
		this.texture = texture;
		this.setCreativeTab(ExtraMobDrops.tabItems);
	}
	
	public void registerIcons(IconRegister reg)
	{
		itemIcon = reg.registerIcon("ExtraMobDrops:" + texture);
	}
}
