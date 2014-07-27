package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class MItemBucket extends ItemBucket
{
	public MItemBucket(Block block)
	{
		super(block);
		this.setContainerItem(Items.bucket);
	}
}
