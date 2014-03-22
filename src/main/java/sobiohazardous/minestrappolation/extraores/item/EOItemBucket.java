package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class EOItemBucket extends ItemBucket
{
	public EOItemBucket(int id, Block block)
	{
		super(block);
		this.setContainerItem(Items.bucket);
		this.setCreativeTab(EOItemManager.tabOresItems);
	}

}
