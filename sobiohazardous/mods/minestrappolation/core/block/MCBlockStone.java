package sobiohazardous.mods.minestrappolation.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * The first stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>(Raw Block)
 * <li>Brick
 * <li>Patterned Brick
 * <li>Road
 * <li>Refined Block
 * <li>Refined Tiles
 * <li>Chiseled
 * <li>Chiseled Variant
 * <li>Cracked
 * <li>Mossy
 * </ul>
 * Everything else if added by {@link MCBlockStone2}
 * 
 * @author Clashsoft
 */
public class MCBlockStone extends Block
{
	public String name;
	
	public MCBlockStone(String name)
	{
		super(Material.rock);
		this.name = name;
	}
}
