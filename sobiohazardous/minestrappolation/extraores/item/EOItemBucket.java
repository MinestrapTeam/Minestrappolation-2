package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;


public class EOItemBucket extends ItemBucket
{
	public EOItemBucket(int id, int blockID) 
	{
		super(id, blockID);
		this.setContainerItem(Item.bucketEmpty);
		this.setCreativeTab(EOItemManager.tabOresItems);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	
}
