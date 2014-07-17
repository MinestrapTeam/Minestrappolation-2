package minestrapteam.mcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.World;

public class MCBlockStairs extends BlockStairs
{
	public Block block;
	public int meta = 0;
	
	public MCBlockStairs(Block block)
	{
		this(block, 0);
		this.setLightOpacity(0);
		this.block = block;
		if(block instanceof MCBlockCustom)
		{
			this.blockHardness = ((MCBlockCustom) block).getHardness(0);
		}
		if(block instanceof MCBlockCustom)
		{
			this.blockResistance = ((MCBlockCustom) block).getResistance(0);
		}
	}
	
	public MCBlockStairs(Block block, int meta)
	{
		super(block, meta);
		this.setLightOpacity(0);
		this.meta = meta;
		if(block instanceof MCBlockCustom)
		{
			this.blockHardness = ((MCBlockCustom) block).getHardness(meta);
		}
		if(block instanceof MCBlockCustom)
		{
			this.blockResistance = ((MCBlockCustom) block).getResistance(meta);
		}
	}	
}
