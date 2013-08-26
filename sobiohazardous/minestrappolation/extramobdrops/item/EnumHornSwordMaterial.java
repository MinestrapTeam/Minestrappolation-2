package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumHornSwordMaterial
{
    WOODH(0, 59, 2.0F, 2.0F, 15),
    STONEH(1, 131, 4.0F, 3.0F, 5),
    IRONH(2, 250, 6.0F, 4.0F, 14),
    EMERALDH(3, 1561, 8.0F, 5.0F, 10),
    GOLDH(0, 32, 12.0F, 2.0F, 22),
    
    MEURODITEH(2, 805, 7.0F, 4, 15),
    TITANIUMH(4, 2999, 10.0F, 6, 11),
    TORITEH(2, 699, 6.0F, 5, 20),
    BLAZIUMH(2, 799, 8.0F, 5, 18),
    COPPERH(1, 139, 5.0F, 4, 10),
    SANDSTONEH(1, 111, 4.5F, 4, 6),
    BRONZEH(2, 1501, 6.5F, 4, 8),
    STEELH(2, 300, 7.5F, 5, 15),
    BEDROCKH(4, 6247, 7F, 4, 5),
    GRANITEH(1, 199, 4.3F, 4, 4);

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final float damageVsEntity;

    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumHornSwordMaterial(int par3, int par4, float par5, float par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public float getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        switch (this)
        {
            case WOODH:    return Block.planks.blockID;
            case STONEH:   return Block.cobblestone.blockID;
            case GOLDH:    return Item.ingotGold.itemID;
            case IRONH:    return Item.ingotIron.itemID;
            case EMERALDH: return Item.diamond.itemID;
            default:      return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
