package sobiohazardous.minestrappolation.api.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.src.*;

public class MItemShovel extends MItemTool
{
    private static Block blocksEffectiveAgainst[];

    public MItemShovel(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 1, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setCreativeTab(null);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        if (par1Block == Block.snow)
        {
            return true;
        }

        return par1Block == Block.blockSnow;
    }

    static
    {
        blocksEffectiveAgainst = (new Block[]
                {
                    Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
                });
    }
}
