package sobiohazardous.minestrappolation.extrafoods.item;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class EFItem extends Item
{
	private String texture;
	
	public EFItem(int id, String texture)
	{
		super(id);
		this.texture ="CrazyFoods:" + texture;
		this.setCreativeTab(ExtraFoods.tabItems);
	}
	
	public void registerIcons(IconRegister ig)
	{
		itemIcon = ig.registerIcon(texture);
	}
}
