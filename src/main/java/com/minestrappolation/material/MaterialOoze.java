package com.minestrappolation.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialOoze extends Material
{
	public MaterialOoze(MapColor mapColor)
	{
		super(mapColor);
	}
	
	@Override
	public boolean isLiquid()
	{
		return true;
	}
	
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
