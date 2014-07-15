package minestrapteam.mcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class MCBlockStairs extends BlockStairs
{
	public MCBlockStairs(Block block)
	{
		this(block, 0);
		this.setLightOpacity(0);
	}
	
	public MCBlockStairs(Block block, int meta)
	{
		super(block, meta);
		this.setLightOpacity(0);
	}
	 
}
