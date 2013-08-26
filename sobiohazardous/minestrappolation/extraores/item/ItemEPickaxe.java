package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemEPickaxe extends ItemExtracraftTool
{   
	private String texture;
    /** an array of the blocks this pickaxe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, ExtraOres.SteelBlock, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered};

    public ItemEPickaxe(int par1, String texture, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.texture = "extraores:" + texture;     
        this.setCreativeTab(null);
    }
    
    public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon(texture);
	}


    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.bedrock ? this.toolMaterial.getHarvestLevel() >= 4 : (par1Block == Block.obsidian || par1Block == ExtraOres.TitaniumOre || par1Block == ExtraOres.TitaniumBlock || par1Block == ExtraOres.SmoothRadiantQuartz || par1Block == ExtraOres.PillarRadiantQuartz || par1Block == ExtraOres.ChiseledRadiantQuartz || par1Block == ExtraOres.RadiantQuartzOre ? this.toolMaterial.getHarvestLevel() >= 3 : (par1Block == Block.blockDiamond || par1Block == Block.oreDiamond || par1Block == Block.oreEmerald || par1Block == Block.blockEmerald || par1Block == Block.blockGold || par1Block == Block.oreGold || par1Block == Block.oreRedstone || par1Block == Block.oreRedstoneGlowing || par1Block == ExtraOres.ToriteOre || par1Block == ExtraOres.ToriteBlock || par1Block == ExtraOres.meuroditeOre || par1Block == ExtraOres.meuroditeBlock || par1Block == ExtraOres.BlaziumOre || par1Block == ExtraOres.BlaziumBlock || par1Block == ExtraOres.SunstoneOre || par1Block == ExtraOres.Sunstone || par1Block == ExtraOres.UraniumOre || par1Block == ExtraOres.PlutoniumOre || par1Block == ExtraOres.BronzePlatedCobble || par1Block == ExtraOres.BronzePlatedMossy || par1Block == ExtraOres.BronzePlatedStoneBrick || par1Block == ExtraOres.BronzePlatedChiseled || par1Block == ExtraOres.BronzePlatedGranite || par1Block == ExtraOres.SteelPlatedCobble || par1Block == ExtraOres.SteelPlatedMossy || par1Block == ExtraOres.SteelPlatedStoneBrick || par1Block == ExtraOres.SteelPlatedChiseled || par1Block == ExtraOres.SteelPlatedGranite || par1Block == ExtraOres.SteelBlock || par1Block == ExtraOres.BronzeBlock ? this.toolMaterial.getHarvestLevel() >= 2 : (par1Block == Block.oreLapis || par1Block == Block.blockLapis || par1Block == ExtraOres.SteelBlock || par1Block == Block.oreIron || par1Block == ExtraOres.TinOre || par1Block == ExtraOres.TinBlock || par1Block == ExtraOres.TinPlatedCobble || par1Block == ExtraOres.TinPlatedMossy || par1Block == ExtraOres.TinPlatedStoneBrick || par1Block == ExtraOres.TinPlatedChiseled || par1Block == ExtraOres.TinPlatedGranite ? this.toolMaterial.getHarvestLevel() >= 1 : this.toolMaterial.getHarvestLevel() >= 0))); 
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

