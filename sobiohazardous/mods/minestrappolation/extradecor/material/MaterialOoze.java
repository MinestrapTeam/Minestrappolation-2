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
	@Override
	public boolean isLiquid()
	{
		return true;
	}
	
	/**
	 * Returns if this material is considered solid or not
	 */
	@Override
	public boolean blocksMovement()
	{
		return false;
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
	
	@Override
	public int getMaterialMobility()
	{
		return 0;
	}
	
}
