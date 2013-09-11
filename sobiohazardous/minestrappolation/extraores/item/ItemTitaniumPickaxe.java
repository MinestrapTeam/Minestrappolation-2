package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemTitaniumPickaxe extends TitaniumTool
{   
    /** an array of the blocks this pickaxe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.bedrock};

    public ItemTitaniumPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setCreativeTab(null);
    }
    
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.bedrock ? this.toolMaterial.getHarvestLevel() >= 4 : (par1Block == Block.obsidian || par1Block == EOBlockManager.TitaniumOre || par1Block == EOBlockManager.TitaniumBlock || par1Block == EOBlockManager.SmoothRadiantQuartz || par1Block == EOBlockManager.PillarRadiantQuartz || par1Block == EOBlockManager.ChiseledRadiantQuartz || par1Block == EOBlockManager.RadiantQuartzOre ? this.toolMaterial.getHarvestLevel() >= 3 : (par1Block == Block.blockDiamond || par1Block == Block.oreDiamond || par1Block == Block.oreEmerald || par1Block == Block.blockEmerald || par1Block == Block.blockGold || par1Block == Block.oreGold || par1Block == Block.oreRedstone || par1Block == Block.oreRedstoneGlowing || par1Block == EOBlockManager.ToriteOre || par1Block == EOBlockManager.ToriteBlock || par1Block == EOBlockManager.meuroditeOre || par1Block == EOBlockManager.meuroditeBlock || par1Block == EOBlockManager.BlaziumOre || par1Block == EOBlockManager.BlaziumBlock || par1Block == EOBlockManager.SunstoneOre || par1Block == EOBlockManager.Sunstone || par1Block == EOBlockManager.UraniumOre || par1Block == EOBlockManager.PlutoniumOre || par1Block == EOBlockManager.BronzePlatedCobble || par1Block == EOBlockManager.BronzePlatedMossy || par1Block == EOBlockManager.BronzePlatedStoneBrick || par1Block == EOBlockManager.BronzePlatedChiseled || par1Block == EOBlockManager.BronzePlatedGranite || par1Block == EOBlockManager.SteelPlatedCobble || par1Block == EOBlockManager.SteelPlatedMossy || par1Block == EOBlockManager.SteelPlatedStoneBrick || par1Block == EOBlockManager.SteelPlatedChiseled || par1Block == EOBlockManager.SteelPlatedGranite || par1Block == EOBlockManager.SteelBlock || par1Block == EOBlockManager.BronzeBlock ? this.toolMaterial.getHarvestLevel() >= 2 : (par1Block == Block.oreLapis || par1Block == Block.blockLapis || par1Block == EOBlockManager.SteelBlock || par1Block == Block.oreIron || par1Block == EOBlockManager.TinOre || par1Block == EOBlockManager.TinBlock || par1Block == EOBlockManager.TinPlatedCobble || par1Block == EOBlockManager.TinPlatedMossy || par1Block == EOBlockManager.TinPlatedStoneBrick || par1Block == EOBlockManager.TinPlatedChiseled || par1Block == EOBlockManager.TinPlatedGranite ? this.toolMaterial.getHarvestLevel() >= 1 : this.toolMaterial.getHarvestLevel() >= 0))); 
    }


    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}

