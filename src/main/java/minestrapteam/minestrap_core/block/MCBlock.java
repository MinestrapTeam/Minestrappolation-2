package minestrapteam.minestrap_core.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MCBlock extends Block
{
	public MCBlock(Material material)
	{
		super(material);
	}
	
    public int quantityDropped(Random p_149745_1_)
    {
    	return 1;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	if(this == MBlocks.meuroditeOre)
    	{
    		return MItems.meuroditeGem;
    	}
    	if(this == MBlocks.radiantQuartzOre)
    	{
    		return MItems.radiantQuartz;
    	}
    	
    	return Item.getItemFromBlock(this);
    }
    
    protected boolean canSilkHarvest()
    {
    	if(this == MBlocks.meuroditeOre || this == MBlocks.radiantQuartzOre)
    	{
    		return true;
    	}
    	return super.canSilkHarvest();
    }

}
