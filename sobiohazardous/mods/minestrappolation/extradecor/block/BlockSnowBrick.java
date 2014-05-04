package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSnowBrick extends MBlock
{
	public BlockSnowBrick()
	{
		super(Material.craftedSnow);
	}
	
	/**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 4;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)    
    {
        return Items.snowball;
    }
}
