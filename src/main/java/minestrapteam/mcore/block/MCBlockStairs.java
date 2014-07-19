package minestrapteam.mcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MCBlockStairs extends BlockStairs
{
	public Block	block;
	public int		meta	= 0;
	
	public MCBlockStairs(Block block)
	{
		this(block, 0);
		this.setLightOpacity(0);
		this.block = block;
		if (block instanceof MCBlockCustom)
		{
			this.blockHardness = ((MCBlockCustom) block).getHardness(0);
			this.blockResistance = ((MCBlockCustom) block).getResistance(0);
		}
	}
	
	public MCBlockStairs(Block block, int meta)
	{
		super(block, meta);
		this.setLightOpacity(0);
		this.block = block;
		this.meta = meta;
		if (block instanceof MCBlockCustom)
		{
			this.blockHardness = ((MCBlockCustom) block).getHardness(meta);
			this.blockResistance = ((MCBlockCustom) block).getResistance(meta);
		}
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		if (this.block instanceof MCBlockCustom && ((MCBlockCustom) this.block).netherrack)
		{
			return this.isSideSolid(world, x, y, z, side);
		}
		return false;
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
	{
		if (this.block instanceof MCBlockCustom && ((MCBlockCustom) this.block).enderDragonCantDestroy)
		{
			return false;
		}
		return true;
	}
}
