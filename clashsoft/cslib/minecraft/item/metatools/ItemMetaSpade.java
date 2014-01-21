package clashsoft.cslib.minecraft.item.metatools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;

public class ItemMetaSpade extends ItemMetaTool
{
    /** an array of the blocks this spade is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    public ItemMetaSpade(int par1, EnumToolMaterial par2EnumToolMaterial, String[] names, String[] icons, int[] colors)
    {
        super(par1, 1.0F, par2EnumToolMaterial, blocksEffectiveAgainst, names, icons, colors);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    @Override
	public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
}
