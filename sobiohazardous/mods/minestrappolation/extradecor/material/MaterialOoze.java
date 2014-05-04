package sobiohazardous.mods.minestrappolation.extradecor.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialOoze extends Material
{

	public MaterialOoze(MapColor par1MapColor) 
	{
		super(par1MapColor);
	}
	
	/**
     * Returns if blocks of these materials are liquids.
     */
    public boolean isLiquid()
    {
        return true;
    }

    /**
     * Returns if this material is considered solid or not
     */
    public boolean blocksMovement()
    {
        return false;
    }

    public boolean isSolid()
    {
        return false;
    }
    
    public int getMaterialMobility()
    {
        return 0;
    }

}
