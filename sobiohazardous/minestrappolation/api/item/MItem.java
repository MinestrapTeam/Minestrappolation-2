package sobiohazardous.minestrappolation.api.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class MItem extends Item
{
	public MItem(int id) 
	{
		super(id);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("minestrappolation" + this.getUnlocalizedName().substring(5));
	}
}
