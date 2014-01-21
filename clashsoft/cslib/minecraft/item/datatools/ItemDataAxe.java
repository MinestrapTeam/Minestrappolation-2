package clashsoft.cslib.minecraft.item.datatools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemDataAxe extends ItemDataTool
{
    /** an array of the blocks this axe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

    public ItemDataAxe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 3F, par2EnumToolMaterial, blocksEffectiveAgainst, "Axe");
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    @Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine))
        {
        	EnumToolMaterial tm = getToolMaterialFromItemStack(par1ItemStack);
        	if (tm != null)
        		return tm.getEfficiencyOnProperMaterial();
        }
        return super.getStrVsBlock(par1ItemStack, par2Block);
    }
}