package sobiohazardous.mods.minestrappolation.extraores.item;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class EOItemBucket extends ItemBucket
{
	public EOItemBucket(int id, Block block)
	{
		super(block);
		this.setContainerItem(Items.bucket);
		this.setCreativeTab(EOItems.tabOresItems);
	}
	
}
