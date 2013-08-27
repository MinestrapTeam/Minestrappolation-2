package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class ItemEShovel extends ItemExtracraftTool
{
    private static Block blocksEffectiveAgainst[];
    private String texture;

    public void registerIcons(IconRegister par1IconRegister)
    {
             this.itemIcon = par1IconRegister.registerIcon(texture);
    }

    public ItemEShovel(int par1, String texture, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 1, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.texture = "Minestrappolation:" + texture;
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
                    Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, EOBlockManager.SoulOre
                });
    }
}
