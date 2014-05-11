package sobiohazardous.mods.minestrappolation.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * The second stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>Raw Slab Lower
 * <li>Raw Slab Upper
 * <li>Raw Slab Double
 * <li>Refined Slab Lower
 * <li>Refined Slab Upper
 * <li>Refined Slab Double
 * <li>Pillar facing up
 * <li>Pillar facing north
 * <li>Pillar facing south
 * </ul>
 * Everything else if added by {@link MBlockStone}
 * 
 * @author Clashsoft
 */
public class MBlockStone2 extends Block
{
	public String name;
	
	public MBlockStone2(String name)
	{
		super(Material.rock);
		this.name = name;
	}
}
