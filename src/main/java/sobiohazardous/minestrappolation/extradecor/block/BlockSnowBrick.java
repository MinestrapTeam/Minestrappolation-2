package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockSnowBrick extends MBlock
{
	public BlockSnowBrick(int id)
	{
		super(id, Material.craftedSnow);
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
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.snowball.itemID;
    }
}
